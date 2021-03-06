package com.everis.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;

@Entity
@NamedQueries({
	@NamedQuery(name="Car.GetAllCars", query="SELECT c FROM Car c"),
	@NamedQuery(name="Car.DeleteMarkedCars", query="DELETE FROM Car c WHERE c.deleted=true")
})

public class Car {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name="uuid2", strategy="org.hibernate.id.UUIDGenerator")
	private String id;
	
	@ManyToOne
	private Brand brand;
	
	@Column(nullable = false)
	private LocalDateTime registration;
	
	@ManyToOne
	private Country country;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@Column(nullable = false)
	private LocalDateTime lastUpdated;
	
	@Column(nullable = true)
	private boolean deleted;
	
	//Constructor por defecto
	public Car() {}
	
	//Constructor parametrizado
	public Car(String id, Brand brand, LocalDateTime registration, Country country, LocalDateTime createdAt,
			LocalDateTime lastUpdated) {
		this.id = id;
		this.brand = brand;
		this.registration = registration;
		this.country = country;
		this.createdAt = createdAt;
		this.lastUpdated = lastUpdated;
		this.deleted = false;
	}
	
	public Car(Brand brand, LocalDateTime registration, Country country, LocalDateTime createdAt,
			LocalDateTime lastUpdated) {
		this.brand = brand;
		this.registration = registration;
		this.country = country;
		this.createdAt = createdAt;
		this.lastUpdated = lastUpdated;
		this.deleted = false;
	}

	//Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public LocalDateTime getRegistration() {
		return registration;
	}

	public void setRegistration(LocalDateTime registration) {
		this.registration = registration;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
