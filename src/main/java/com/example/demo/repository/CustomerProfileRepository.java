package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CustomerProfile;



public interface CustomerProfileRepository extends JpaRepository<CustomerProfile,Long> {

}
