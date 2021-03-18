package com.everis.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Car {
	private long id;
	private String brand;
	private LocalDateTime registration;
	private String country;
	private LocalDateTime createdAt;
	private LocalDateTime lastUpdated;
	
	//Constructor por defecto
	public Car() {}
	
	//Constructor parametrizado
	public Car(long id, String brand, LocalDateTime registration, String country, LocalDateTime createdAt,
			LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.brand = brand;
		this.registration = registration;
		this.country = country;
		this.createdAt = createdAt;
		this.lastUpdated = lastUpdated;
	}

	//Getters & Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public LocalDateTime getRegistration() {
		return registration;
	}
	public void setRegistration(LocalDateTime registration) {
		this.registration = registration;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
