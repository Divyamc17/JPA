package com.xworkz.main;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.xworkz.entity.TempleEntity;
import com.xworkz.service.TempleService;
import com.xworkz.service.TempleServiceImpl;
import com.xworkz.singleton.Factory;

public class TempleMain {

	public static void main(String[] args) {
		TempleEntity entity = new TempleEntity("Iskon", "Begaluru", 6.00, 9.00, 4);
		TempleEntity entity1 = new TempleEntity("SriKrishna", "udupi", 5.00, 8.00, 1);
		TempleEntity entity2 = new TempleEntity("Vittala", "Hampi", 7.00, 9.30, 6);
		TempleEntity entity3 = new TempleEntity("Channakeshava", "Belur", 4.00, 7.00, 2);
		TempleEntity entity4 = new TempleEntity("Kotillingeshwara", "kolar", 6.30, 7.30, 100);
		TempleEntity entity5 = new TempleEntity("Mallikarjuna", "Pattadkallu", 5.00, 9.30, 3);
		TempleEntity entity6 = new TempleEntity("Golden", "KushalNagar", 7.00, 10.30, 1);
		TempleEntity entity7 = new TempleEntity("Chamundeshwari", "Mysore", 4.30, 10.00, 2);
		TempleEntity entity8 = new TempleEntity("Yadiyur", "Tumkur", 5.00, 9.30, 5);
		TempleEntity entity9 = new TempleEntity("Najundeshwara", "Nanjanagudu", 5.30, 8.30, 10);

		TempleService service = new TempleServiceImpl();
		boolean validateAndSave = service.validateAndSave(entity);
		System.out.println(validateAndSave);
		boolean validateAndSave2 = service.validateAndSave(entity1);
		System.out.println(validateAndSave2);
		boolean validateAndSave3 = service.validateAndSave(entity2);
		System.out.println(validateAndSave3);
		boolean validateAndSave4 = service.validateAndSave(entity3);
		System.out.println(validateAndSave4);
		boolean validateAndSave5 = service.validateAndSave(entity4);
		System.out.println(validateAndSave5);
		boolean validateAndSave6 = service.validateAndSave(entity5);
		System.out.println(validateAndSave6);
		service.validateAndSave(entity6);
		service.validateAndSave(entity7);
		service.validateAndSave(entity8);
		service.validateAndSave(entity9);

		try {
			Optional<TempleEntity> findById = service.findById(3);
			if (findById.isPresent()) {
				TempleEntity findid = findById.get();
				System.out.println(findid);
			}
		  //service.deleteById(2);

		} finally {
			Factory.getValue().close();
		}

	}
}
