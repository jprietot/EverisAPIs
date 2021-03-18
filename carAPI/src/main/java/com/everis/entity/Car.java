package com.everis.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Car {
	private long id;
	private String brand;
	private LocalDateTime registration;
	private String country;
	private LocalDateTime created_at;
	private LocalDateTime last_updated;
	
	//Constructor por defecto
	public Car() {}
	
	//Constructor parametrizado
	public Car(long id, String brand, LocalDateTime registration, String country, LocalDateTime created_at,
			LocalDateTime last_updated) {
		super();
		this.id = id;
		this.brand = brand;
		this.registration = registration;
		this.country = country;
		this.created_at = created_at;
		this.last_updated = last_updated;
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
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}
	
	
}
