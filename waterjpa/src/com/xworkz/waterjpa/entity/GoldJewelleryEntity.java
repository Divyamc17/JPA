package com.xworkz.waterjpa.entity;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;

import com.xworkz.waterjpa.singleton.GoldJwellery;

import io.smallrye.common.constraint.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="gold_jewellery")
@NamedQuery(name = "findShopNameAndId",
query = "select gold from GoldJewelleryEntity where gold.shopName=:sh and gold.id=:id ")
@NamedQuery(name = "findShopNameById", query = "select gold.shopName from  GoldJewelleryEntity where gold.id=:id")
@NamedQuery(name = "findMakingChargesByShopName",
query = "select gold.makingCharges from GoldJewelleryEntity where gold.shopName=:sh")
@NamedQuery(name = "findWastageChargesAndMakingChargesByShopName",
query = "select gold.wastageCharges,gold.makingCharges from GoldJewelleryEntity where gold.shopName=:shn")
@NamedQuery(name = "findTotalPriceByGramAndShopName",
query = "select gold.sum(goldPrice+gstPrice+makingCharges+wastageCharges) from GoldJewelleryEntity "
		+ "where gold.grams=:gr and gold.shopName=:sh")
@NamedQuery(name = "findAll", query = "select gold from GoldJewelleryEntity gold")
@NamedQuery(name = "getAllShopName", query = "select gold.shopName from GoldJewelleryEntity gold")
@NamedQuery(name = "getAllShopNameAndType", query = "select gold.shopName,gold.type from GoldJewelleryEntity gold")
@NamedQuery(name = "findAllByMakingChargesGreaterThan",
query = "select gold from GoldJewelleryEntity where gold.makingCharges>=:mag")
@NamedQuery(name = "findAllByMakingChargesLesserThan",
query = "select gold from GoldJewelleryEntity where gold.makingCharges<=:mal")
@NamedQuery(name = "findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan", 
query = "select gold from GoldJewelleryEntity where gold.gold.makingCharges>=:mag and gold.gold.makingCharges<=:mal")
public class GoldJewelleryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotEmpty
	
	private GoldJwellery type;
	private double goldPrice;
	private double gstPrice;
	private double grams;
	private double makingCharges;
	private double wastageCharges;
	private boolean copper;
	private String shopName;
	
	public GoldJewelleryEntity(GoldJwellery type, double goldPrice, double gstPrice, double grams, double makingCharges,
			double wastageCharges, boolean copper, String shopName) {
		super();
		this.type = type;
		this.goldPrice = goldPrice;
		this.gstPrice = gstPrice;
		this.grams = grams;
		this.makingCharges = makingCharges;
		this.wastageCharges = wastageCharges;
		this.copper = copper;
		this.shopName = shopName;
	}
	
	
	
	
	}
	

	

