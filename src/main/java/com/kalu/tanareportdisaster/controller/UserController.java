package com.example.disastermanagement.controller;

import com.example.disastermanagement.models.User;
import com.example.disastermanagement.service.ChiefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/V1")
public class UserController {

    private final ChiefService chiefService;

    @Autowired
    public UserController(ChiefService chiefService) {
        this.chiefService = chiefService;
    }

    @GetMapping("/chiefs")
    public List<User> getAllChiefs(){
        return chiefService.findAll();
    }

    @GetMapping("/chiefs/{id}")
    public ResponseEntity<String> getChiefById(@PathVariable Integer id){
        Optional<User> chief = chiefService.findById(id);
        return ResponseEntity.ok(chief.get().getPassword());
    }

    @PostMapping("/register-chief")
    public void registerChief(@RequestBody User user){
        chiefService.addChief(user);
    }

    @PostMapping("/update-chief/{id}")
    public void updateChiefById(@PathVariable int id, @RequestBody User user){
        chiefService.updateChief(id, user);
    }

    @DeleteMapping("/delete-chief/{id}")
    public void deleteChiefById(@PathVariable int id){
        chiefService.deleteChief(id);
    }


}
