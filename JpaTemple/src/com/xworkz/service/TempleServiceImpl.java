package com.xworkz.service;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.entity.TempleEntity;
import com.xworkz.repository.TempleRepository;
import com.xworkz.repository.TempleRepositoryImpl;

public class TempleServiceImpl implements TempleService {

	private TempleRepository repo = new TempleRepositoryImpl();

	@Override
	public boolean validateAndSave(TempleEntity entity) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<TempleEntity>> valid = validator.validate(entity);
		if (valid.size() > 0) {
			System.out.println("fix the errors");
		} else {
			System.out.println(" validated");
			System.out.println(entity);
			return repo.save(entity);

		}
		return true;
	}

	@Override
	public Optional<TempleEntity> findById(int id) {
		if (id > 0) {
			System.out.println("id is valid");
			return this.repo.findById(id);
		}
		return Optional.empty();
	}

	@Override public boolean deleteById(int id) { 
		
	   return this.repo.deleteById(id);
	  }

}
