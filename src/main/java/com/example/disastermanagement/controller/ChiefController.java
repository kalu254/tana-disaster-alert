package com.example.disastermanagement.controller;

import com.example.disastermanagement.models.ChiefEntity;
import com.example.disastermanagement.service.ChiefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/V1")
public class ChiefController {

    private final ChiefService chiefService;

    @Autowired
    public ChiefController(ChiefService chiefService) {
        this.chiefService = chiefService;
    }

    @GetMapping("/chiefs")
    public List<ChiefEntity> getAllChiefs(){
        return chiefService.findAll();
    }

    @GetMapping("/chiefs/{id}")
    public Optional<ChiefEntity> getChiefById(@PathVariable int id){
        return chiefService.findById(id);
    }

    @PostMapping("/register-chief")
    public void registerChief(@RequestBody ChiefEntity chiefEntity){
        chiefService.addChief(chiefEntity);
    }

    @PostMapping("/update-chief/{id}")
    public void updateChiefById(@PathVariable int id, @RequestBody ChiefEntity chiefEntity){
        chiefService.updateChief(id,chiefEntity);
    }

    @DeleteMapping("/delete-chief/{id}")
    public void deleteChiefById(@PathVariable int id){
        chiefService.deleteChief(id);
    }
}
