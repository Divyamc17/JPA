package com.xworkz.waterjpa.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.waterjpa.entity.GoldJewelleryEntity;
import com.xworkz.waterjpa.repository.GoldJewelleryRepository;
import com.xworkz.waterjpa.repository.GoldJewelleryRepositoryImpl;

public class GoldJewelleryServiceImpl implements GoldJewelleryService {

	GoldJewelleryRepository repository=new GoldJewelleryRepositoryImpl();
	
	@Override
	public boolean validateAndSave(GoldJewelleryEntity entity) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<GoldJewelleryEntity>> valid = validator.validate(entity);
		if (valid.size() > 0) {
			System.out.println("size is fixed");
		} else {
			System.out.println("validated");
		}
		
		
		return this.repository.save(entity);
	}

	@Override
	public boolean saveAndValidate(List<GoldJewelleryEntity> list) {
		
		ValidatorFactory fact = Validation.buildDefaultValidatorFactory();
		Validator validator = fact.getValidator();
		for (GoldJewelleryEntity goldJewelleryEntity : list) {
			Set<ConstraintViolation<GoldJewelleryEntity>> constraint = validator.validate(goldJewelleryEntity);
			if (constraint.size() > 0) {
				System.out.println("Error");
			}
			System.out.println(list);
		}
		return repository.save(list);
	}

	@Override
	public Optional<GoldJewelleryEntity> findShopNameById(int id) {
		if(id>0) {
			return this.repository.findShopNameById(id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<String> findShopNameAndId(int id, String shopName) {
		return repository.findShopNameAndId(id, shopName);
	}

	@Override
	public Optional<Double> findMakingChargesByShopName(String shopName) {
		return repository.findMakingChargesByShopName(shopName);
	}

	@Override
	public Optional<Object[]> findWastageChargesAndMakingChargesByShopName(String shopName) {
		return repository.findWastageChargesAndMakingChargesByShopName(shopName);
	}

	@Override
	public Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName) {
		return repository.findTotalPriceByGramAndShopName(gram, shopName);
	}

	@Override
	public Collection<GoldJewelleryEntity> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Collection<String> getAllShopName() {
		return this.repository.getAllShopName();
	}

	@Override
	public Collection<Object[]> getAllShopNameAndType() {
		return this.repository.getAllShopNameAndType();
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges) {
		return this.repository.findAllByMakingChargesGreaterThan(charges);
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesLesserThan(double charges) {
		return this.repository.findAllByMakingChargesLesserThan(charges);
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(
			double charges, double makingCharges) {
		return this.repository.findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(charges, makingCharges);
	}

}
