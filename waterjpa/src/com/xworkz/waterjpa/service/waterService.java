package com.xworkz.waterjpa.service;

import java.util.Optional;

import com.xworkz.waterjpa.entity.WaterEntity;

public interface waterService {

	boolean create(WaterEntity entity);
	
	Optional<WaterEntity> findById(int id);
	
	boolean updateByName(int id,String name);
	
	boolean delete(int id);
}
