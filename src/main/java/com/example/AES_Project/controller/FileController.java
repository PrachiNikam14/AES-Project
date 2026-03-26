package com.example.AES_Project.controller;

import com.example.AES_Project.service.AESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.ResponseEntity;

@Controller
public class FileController {

    @Autowired
    private AESService aesService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/encrypt")
    public ResponseEntity<byte[]> encrypt(
            @RequestParam("file") MultipartFile file,
            @RequestParam("password") String password) throws Exception {

        byte[] result = aesService.encrypt(file.getBytes(), password);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=encrypted.dat")
                .body(result);
    }

    @PostMapping("/decrypt")
    public ResponseEntity<byte[]> decrypt(
            @RequestParam("file") MultipartFile file,
            @RequestParam("password") String password) throws Exception {

        byte[] result = aesService.decrypt(file.getBytes(), password);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=decrypted.txt")
                .body(result);
    }
}