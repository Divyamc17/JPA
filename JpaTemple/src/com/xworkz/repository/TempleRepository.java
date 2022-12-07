package com.xworkz.repository;

import java.util.Optional;

import com.xworkz.entity.TempleEntity;

public interface TempleRepository {
	
	boolean save(TempleEntity entity);
	Optional <TempleEntity> findById(int id);
	boolean deleteById(int id); 


}
