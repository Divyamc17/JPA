package com.xworkz.waterjpa.service;

import java.util.Optional;

import com.xworkz.waterjpa.entity.WaterEntity;
import com.xworkz.waterjpa.repository.WaterRepository;
import com.xworkz.waterjpa.repository.WaterRepositoryImpl;

public class WaterServiceImpl implements waterService {

	WaterRepository repo = new WaterRepositoryImpl();

	@Override
	public boolean create(WaterEntity entity) {

		return this.repo.create(entity);
	}

	@Override
	public Optional<WaterEntity> findById(int id) {
		if (id > 0) {
			System.out.println("id is valid");
			return this.repo.findById(id);
		}
		return Optional.empty();
	}

	@Override
	public boolean updateByName(int id, String name) {
		this.repo.updateByName(id, name);
		return false;
	}

	@Override
	public boolean delete(int id) {
		this.repo.delete(id);
		return false;
	}

}
