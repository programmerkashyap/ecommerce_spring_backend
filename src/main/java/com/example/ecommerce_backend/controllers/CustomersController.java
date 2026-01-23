package com.example.ecommerce_backend.controllers;

import com.example.ecommerce_backend.models.Customers;
import com.example.ecommerce_backend.repositories.CustomersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomersController {

    CustomersRepository cr;
    public CustomersController(CustomersRepository cr)
    {
        this.cr = cr;
    }

    @PostMapping("/customers")
    public Customers save(@RequestBody Customers data)
    {
        return cr.save(data);
    }

    @GetMapping("/customers")
    public List<Customers> getall()
    {
        return cr.findAll();
    }

    @PutMapping("/customers")
    public Customers update(@RequestBody Customers data)
    {
        return  cr.save(data);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        cr.deleteById(id);

        return ResponseEntity.ok(Map.of(
                "status","success",
                "message","Customer Deleted Successfully"
        ));
    }

    @GetMapping("/customers/{id}")
    public Customers getsingle(@PathVariable Long id)
    {
        return cr.findById(id).orElse(null);
    }


}
