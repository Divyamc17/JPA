package com.xworkz.waterjpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="water")
public class WaterEntity {
	@Id
	private int id;
	private String color;
	private double density;
	private double bolingPoint;
	private double meltingPoint;
	

}
