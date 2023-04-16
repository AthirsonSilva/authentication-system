package com.authenticationsystem.controller;

import com.authenticationsystem.entity.payload.RegistrationRequest;
import com.authenticationsystem.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService service;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(request));
    }

    @GetMapping("confirm")
    @ResponseBody
    public ResponseEntity<?> confirm(@RequestParam("token") String token) {
        return ResponseEntity.status(HttpStatus.OK).body(service.confirmToken(token));
    }
}
