package com.userActivityProducer.controller;

import com.userActivityProducer.DTO.User;
import com.userActivityProducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class StringProducerController {

    private final StringProducerService stringProducerService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody User user){
        stringProducerService.sendMessage(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
