package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class CustomerProfile {
    @Id
    private Long userId;

    private String address;
    private double latitude;
    private double longitude;

    @OneToOne
    @MapsId
    private User user;
    
    public CustomerProfile() {}

	public CustomerProfile(Long userId, String address, double latitude, double longitude, User user) {
		super();
		this.userId = userId;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.user = user;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
