package com.example.disastermanagement.controller;

import com.example.disastermanagement.models.AffectedUnitEntity;
import com.example.disastermanagement.service.AffectedUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/V3")
public class AffectedUnitController {

    private final AffectedUnitService affectedUnitService;

    @Autowired
    public AffectedUnitController(AffectedUnitService affectedUnitService) {
        this.affectedUnitService = affectedUnitService;
    }

    @GetMapping("/affected-units")
    public List<AffectedUnitEntity> getAllAffectedUnits(){
       return affectedUnitService.findAll();
    }

    @GetMapping("/affected-units/{id}")
    public Optional<AffectedUnitEntity> getAffectedUnitById(@PathVariable int id){
        return affectedUnitService.findById(id);
    }

    @PostMapping("/report_disaster")
    public void reportDisaster(@RequestBody AffectedUnitEntity affectedUnitEntity){
        affectedUnitService.addAffectedUnit(affectedUnitEntity);
    }

}
