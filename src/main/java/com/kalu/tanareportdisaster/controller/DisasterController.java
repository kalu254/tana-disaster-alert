package com.kalu.tanareportdisaster.controller;

import com.kalu.tanareportdisaster.models.DisasterEntity;
import com.kalu.tanareportdisaster.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/V4")
public class DisasterController {

    private final DisasterService disasterService;

    @Autowired
    public DisasterController(DisasterService disasterService) {
        this.disasterService = disasterService;
    }


    @GetMapping("/get-disasters")
    public List<DisasterEntity> getAllDisasters(){
        return disasterService.findAll();
    }

    @GetMapping("get-disasters/{id}")
    public Optional<DisasterEntity> getDisasterById(@PathVariable int id){
       return disasterService.findById(id);
    }

    @DeleteMapping("/delete-disasters/{id}")
    public void deleteDisaster(@PathVariable int id){
        disasterService.deleteDisaster(id);
    }

    @RequestMapping(value = "get-disasters/{id}",method = RequestMethod.POST, consumes = {" multipart/form-data"})
    @ResponseBody
    public void updateDisaster(@PathVariable int id, @RequestPart DisasterEntity disasterEntity, @RequestParam MultipartFile multipartFile){
      disasterService.updateDisaster(id,disasterEntity,multipartFile);
    }

    @PostMapping(value = "/add-disaster", consumes = {   "multipart/form-data" })
    @ResponseBody
    public void addProduct(@RequestParam("imageFile") MultipartFile[] imageFiles, @RequestPart("disasterEntity") DisasterEntity disasterEntity) throws IOException {
        System.out.println(disasterEntity.toString());
        disasterService.addDisaster(imageFiles,disasterEntity);
    }
}
