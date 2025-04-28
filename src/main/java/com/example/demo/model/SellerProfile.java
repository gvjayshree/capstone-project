package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SellerProfile {
    @Id
    private Long userId;

    private String shopName;
    private String category;
    private String description;
    private double latitude;
    private double longitude;

    @OneToOne
    @MapsId
    private User user;
    
    public SellerProfile() {}

	public SellerProfile(Long userId, String shopName, String category, String description, double latitude,
			double longitude, User user) {
		super();
		this.userId = userId;
		this.shopName = shopName;
		this.category = category;
		this.description = description;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
