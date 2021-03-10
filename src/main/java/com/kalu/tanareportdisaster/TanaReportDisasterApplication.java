package com.kalu.tanareportdisaster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kalu.tanareportdisaster.service.DisasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.File;

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

}
