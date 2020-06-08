package com.jpa.world.pagenations.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Table(name = "fruit")
@Entity
public class Fruit {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private double price;

	@CreationTimestamp
	private LocalDateTime packedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getPackedDate() {
		return packedDate;
	}

	public void setPackedDate(LocalDateTime packedDate) {
		this.packedDate = packedDate;
	}

}
