package com.xworkz.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "templejpa")
public class TempleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50, message = "name is valid")
	private String name;
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 50, message = "place is valid")
	private String place;
	@DecimalMin(value = "0.00")
	@DecimalMax(value = "8.00")
	private double openTime;
	@DecimalMin(value = "00.00")
	@DecimalMax(value = "11.00")
	private double closeTime;
	@Min(value = 0)
	@Max(value = 200)
	private int noGods;

	public TempleEntity(String name, String place, double openTime, double closeTime, int noGods) {
		super();
		this.name = name;
		this.place = place;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.noGods = noGods;
	}

}
