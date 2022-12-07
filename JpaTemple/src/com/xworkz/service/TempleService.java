package com.xworkz.service;

import java.util.Optional;

import com.xworkz.entity.TempleEntity;

public interface TempleService {
	
	boolean validateAndSave(TempleEntity entity);
	Optional <TempleEntity> findById(int id);
	boolean deleteById(int id); 

}
