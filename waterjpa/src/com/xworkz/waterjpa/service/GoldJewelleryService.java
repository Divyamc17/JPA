package com.xworkz.waterjpa.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.waterjpa.entity.GoldJewelleryEntity;

public interface GoldJewelleryService {
	
	boolean validateAndSave(GoldJewelleryEntity entity);
	
	boolean saveAndValidate(List<GoldJewelleryEntity> list);
	
    Optional<GoldJewelleryEntity> findShopNameById(int id);
	
    Optional<String> findShopNameAndId(int id,String shopName);
	
	Optional<Double> findMakingChargesByShopName(String shopName);
	
	Optional<Object[]> findWastageChargesAndMakingChargesByShopName(String shopName);
	
	Optional<Double> findTotalPriceByGramAndShopName(double gram,String shopName);
	
	Collection<GoldJewelleryEntity> findAll();
	
	Collection<String> getAllShopName();

	Collection<Object[]> getAllShopNameAndType();
	
	Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges);
	
	Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesLesserThan(double charges);
	
	Optional<Collection<GoldJewelleryEntity>> findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(double charges,double makingCharges);
	


}
