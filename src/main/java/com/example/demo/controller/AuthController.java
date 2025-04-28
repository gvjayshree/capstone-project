package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterCustomerRequest;
import com.example.demo.dto.RegisterSellerRequest;
import com.example.demo.model.SellerProfile;
import com.example.demo.model.User;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:5173")
public class AuthController {

    @Autowired 
    private AuthService authService;

    @PostMapping("/register-customer")
    public ResponseEntity<String> registerCustomer(@RequestBody RegisterCustomerRequest request) {
        authService.registerCustomer(request);
        return ResponseEntity.ok("Customer registered successfully.");
    }

    @PostMapping("/register-seller")
    public ResponseEntity<String> registerSeller(@RequestBody RegisterSellerRequest request) {
        authService.registerSeller(request);
        return ResponseEntity.ok("Seller registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
    @GetMapping("/seller")
    public List<SellerProfile> getAllSeller(){
    	
    	return authService.getAllSeller();
    	
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
    	return authService.getAllUsers();
    }
    
}
