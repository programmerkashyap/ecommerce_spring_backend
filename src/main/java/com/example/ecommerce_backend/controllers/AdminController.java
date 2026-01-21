package com.example.ecommerce_backend.controllers;

import com.example.ecommerce_backend.models.Admin;
import com.example.ecommerce_backend.repositories.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    AdminRepository adminRepository;
    public AdminController(AdminRepository adminRepository)
    {
        this.adminRepository = adminRepository;
    }

    // Admin Login API
    @PostMapping("/admin")
    public ResponseEntity<?> login(@RequestBody Admin data)
    {
        Admin result = adminRepository.findByUsernameAndPassword(data.getUsername(), data.getPassword());
        log.info("Result: "+result);
        if(result!=null)
        {
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message","Login Success",
                    "data", result
            ));
        }
        else
        {
            return ResponseEntity.ok(Map.of(
                    "status", "error",
                    "message","User name and Password is incorrect"
            ));
        }
    }


}
