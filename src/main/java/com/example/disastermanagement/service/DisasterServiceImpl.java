package com.example.disastermanagement.service;

import com.example.disastermanagement.models.DisasterEntity;
import com.example.disastermanagement.repository.DisasterRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisasterServiceImpl implements DisasterService {

    private final DisasterRepository disasterRepository;
    public static String uploadDisaster = System.getProperty("user.dir") + "/disaster_images";


    public DisasterServiceImpl(DisasterRepository disasterRepository) {
        this.disasterRepository = disasterRepository;
    }

    @Override
    public List<DisasterEntity> findAll() {
        return disasterRepository.findAll();
    }

    @Override
    public Optional<DisasterEntity> findById(int id) {
        return disasterRepository.findById(id);
    }

    @Override
    public void addDisaster(MultipartFile[] imageFiles, DisasterEntity disasterEntity) {

        StringBuilder filename = new StringBuilder();
        List<String> disasterImageUris = Arrays.asList(imageFiles)
            .stream()
            .map(imageFile -> {
                Path path = Paths.get(uploadDisaster, imageFile.getOriginalFilename());
                filename.append(imageFile.getOriginalFilename());

                try {
                    Files.write(path, imageFile.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String imageDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("disaster_images/")
                    .path(Objects.requireNonNull(imageFile.getOriginalFilename()))
                    .toUriString();
                return imageDownloadUri;
            }).collect(Collectors.toList());

        String image_one = disasterImageUris.get(0);
        String image_two = disasterImageUris.get(1);
        String image_three = disasterImageUris.get(2);
        String image_four = disasterImageUris.get(3);

        persistToDb(disasterEntity,image_one,image_two,image_three,image_four);

    }

    private void persistToDb(DisasterEntity disasterEntity, String image_one, String image_two, String image_three, String image_four) {

        DisasterEntity saveDisaster = new DisasterEntity();
        saveDisaster.setDate_reported(disasterEntity.getDate_reported());
        saveDisaster.setDisaster_type(disasterEntity.getDisaster_type());
        saveDisaster.setDisaster_description(disasterEntity.getDisaster_description());
        saveDisaster.setVillage(disasterEntity.getVillage());
        saveDisaster.setDisaster_img_url_one(image_one);
        saveDisaster.setDisaster_img_url_two(image_two);
        saveDisaster.setDisaster_img_url_three(image_three);
        saveDisaster.setDisaster_img_url_four(image_four);

        disasterRepository.saveAndFlush(saveDisaster);
    }

    @Override
    public void updateDisaster(int id, DisasterEntity disasterEntity, MultipartFile multipartFile) {

    }

    @Override
    public void deleteDisaster(int id) {
        disasterRepository.deleteById(id);
    }
}
