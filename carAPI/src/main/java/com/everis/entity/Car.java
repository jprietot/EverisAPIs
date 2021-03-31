package com.everis.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String brand;
	
	@Column(nullable = false)
	private LocalDateTime registration;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@Column(nullable = false)
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
	
	public Car(String brand, LocalDateTime registration, String country, LocalDateTime createdAt,
			LocalDateTime lastUpdated) {
		super();
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
