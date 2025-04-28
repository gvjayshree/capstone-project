package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterCustomerRequest;
import com.example.demo.dto.RegisterSellerRequest;
import com.example.demo.model.CustomerProfile;
import com.example.demo.model.SellerProfile;
import com.example.demo.model.User;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.SellerProfileRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AuthService {

    @Autowired 
    private UserRepository userRepo;
    @Autowired 
    private SellerProfileRepository sellerRepo;
    @Autowired 
    private CustomerProfileRepository customerRepo;

    public void registerCustomer(RegisterCustomerRequest req) {
        User user = new User();
        user.setName(req.name);
        user.setEmail(req.email);
        user.setPassword(req.password);
        user.setPhone(req.phone);
        user.setRole(User.Role.CUSTOMER);
        userRepo.save(user);

        CustomerProfile profile = new CustomerProfile();
        profile.setUser(user);
        profile.setAddress(req.address);
        profile.setLatitude(req.latitude);
        profile.setLongitude(req.longitude);
        customerRepo.save(profile);
    }

    public void registerSeller(RegisterSellerRequest req) {
        User user = new User();
        user.setName(req.name);
        user.setEmail(req.email);
        user.setPassword(req.password);
        user.setPhone(req.phone);
        user.setRole(User.Role.SELLER);
        userRepo.save(user);

        SellerProfile profile = new SellerProfile();
        profile.setUser(user);
        profile.setShopName(req.shopName);
        profile.setCategory(req.category);
        profile.setDescription(req.description);
        profile.setLatitude(req.latitude);
        profile.setLongitude(req.longitude);
        sellerRepo.save(profile);
    }

    public String login(LoginRequest req) {
        Optional<User> user = userRepo.findByEmailAndPassword(req.email, req.password);
        if (user.isPresent()) {
            return "Login success! Welcome " + user.get().getRole();
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
    
    public List<SellerProfile> getAllSeller(){
    	return sellerRepo.findAll();
    }
    
    public List<User> getAllUsers(){
    	return userRepo.findAll();
    }
}

