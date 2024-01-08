package com.kalu.tanareportdisaster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kalu.tanareportdisaster.models.Role;
import com.kalu.tanareportdisaster.models.User;
import com.kalu.tanareportdisaster.repository.RoleRepository;
import com.kalu.tanareportdisaster.repository.UserRepository;
import com.kalu.tanareportdisaster.service.DisasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.HashSet;

@SpringBootApplication
public class TanaReportDisasterApplication {
    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        new File(DisasterServiceImpl.uploadDisaster).mkdir();
        SpringApplication.run(TanaReportDisasterApplication.class, args);
    }

    @PostConstruct
    public void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
    }


    @Profile({"dev", "prod"})
    @Bean
    CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {

            HashSet<String> roleSet = new HashSet<>();
            roleSet.add("ADMIN");
            AggregateReference<User, Integer> author =
                    AggregateReference.to(userRepository.save(
                            new User("Kalu", "Luka", "Macharia", "kaluarichama@gmail.com", "Commissioner", "County", "Eastern", 746882415, "1234", roleSet)).getId());
        };
    }
}
