package com.kalu.tanareportdisaster.controller;

import com.kalu.tanareportdisaster.models.ApplicationUser;
import com.kalu.tanareportdisaster.models.ApplicationUserRole;
import com.kalu.tanareportdisaster.models.Role;
import com.kalu.tanareportdisaster.models.User;
import com.kalu.tanareportdisaster.models.payload.JwtResponse;
import com.kalu.tanareportdisaster.models.payload.MessageResponse;
import com.kalu.tanareportdisaster.models.payload.SignupRequest;
import com.kalu.tanareportdisaster.models.payload.UsernameAndPasswordAuthenticationRequest;
import com.kalu.tanareportdisaster.repository.RoleRepository;
import com.kalu.tanareportdisaster.repository.UserRepository;
import com.kalu.tanareportdisaster.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;

    @Autowired
    public AuthController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UsernameAndPasswordAuthenticationRequest usernameAndPasswordAuthenticationRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(usernameAndPasswordAuthenticationRequest.getUsername(), usernameAndPasswordAuthenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        ApplicationUser userDetails = (ApplicationUser) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            roles));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User newUser = new User(
            user.getUsername(),
            user.getfName(),
            user.getlName(),
            user.getEmail(),
            user.getAdministrativeLevel(),
            user.getRegionLevel(),
            user.getRegion(),
            user.getPhoneNumber(),
            encoder.encode(user.getPassword()),
            user.getRole()

        );

        Set<String> strRoles = user.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ApplicationUserRole.CHIEF)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "Admin":
                        Role adminRole = roleRepository.findByName(ApplicationUserRole.ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "Commissioner":
                        Role modRole = roleRepository.findByName(ApplicationUserRole.COMMISSIONER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ApplicationUserRole.CHIEF)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(newUser);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
