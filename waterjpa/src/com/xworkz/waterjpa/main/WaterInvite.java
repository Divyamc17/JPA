package com.xworkz.waterjpa.main;

import java.util.Optional;

import com.xworkz.waterjpa.entity.WaterEntity;
import com.xworkz.waterjpa.service.WaterServiceImpl;
import com.xworkz.waterjpa.service.waterService;

public class WaterInvite {

	public static void main(String[] args) {

		// WaterEntity water=new WaterEntity(1, "colorless", 12.88, 10.23, 100.0);
		waterService service = new WaterServiceImpl();
		// service.create(water);

		Optional<WaterEntity> find = service.findById(1);
		if (find.isPresent()) {
			WaterEntity waterEntity = find.get();
			System.out.println(waterEntity);
		} else {
			System.out.println("optional is null");
		}
		// return Optional.empty();

	}
}
