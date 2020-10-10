package com.example.disastermanagement.controller;

import com.example.disastermanagement.models.CommissionerEntity;
import com.example.disastermanagement.service.CommissionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/V2")
public class CommissionerController {

    private final CommissionerService commissionerService;

    @Autowired
    public CommissionerController(CommissionerService commissionerService) {
        this.commissionerService = commissionerService;
    }

    @GetMapping("/commissioners")
    public List<CommissionerEntity> getAllCommissioners(){
        return commissionerService.findAll();
    }

    @GetMapping("/commissioners/{id}")
    public Optional<CommissionerEntity> getCommissionerById(@PathVariable int id){
        return commissionerService.findById(id);
    }

    @PostMapping("/add-commissioner")
    public void registerCommissioner(@RequestBody CommissionerEntity commissionerEntity){
        commissionerService.addCommissioner(commissionerEntity);
    }

    @PostMapping("update-commissioners/{id}")
    public void updateCommissioner(@PathVariable int id, @RequestBody CommissionerEntity commissionerEntity){
        commissionerService.updateCommissioner(id,commissionerEntity);
    }

    @DeleteMapping("commissioners/{id}")
    public void deleteCommissioner(@PathVariable int id){
        commissionerService.deleteCommissioner(id);
    }
}
