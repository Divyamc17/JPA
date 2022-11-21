package com.xworkz.waterjpa.main;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.waterjpa.entity.GoldJewelleryEntity;
import com.xworkz.waterjpa.repository.GoldJewelleryRepository;
import com.xworkz.waterjpa.repository.GoldJewelleryRepositoryImpl;
import com.xworkz.waterjpa.service.GoldJewelleryService;
import com.xworkz.waterjpa.service.GoldJewelleryServiceImpl;
import com.xworkz.waterjpa.singleton.GoldJwellery;
import com.xworkz.waterjpa.singleton.JavaUtil;

public class GoldJewellryInvite {

	public static void main(String[] args) {

	GoldJewelleryEntity entity1=new GoldJewelleryEntity( GoldJwellery.BANGLE, 70000, 0.03, 15,
				10000, 5000, true, "Mahalakshmi");
	GoldJewelleryEntity entity2 = new GoldJewelleryEntity( GoldJwellery.BRACELET, 100000,
			0.02, 20, 14000, 8000, true,"Lalitha Jewellery");
	GoldJewelleryEntity entity3 = new GoldJewelleryEntity( GoldJwellery.EARRING, 75000,
			0.04, 15, 11000, 4000, false,"Bhima Jewellery");
	GoldJewelleryEntity entity4 = new GoldJewelleryEntity( GoldJwellery.NOSEPIN, 125000,
			0.04, 25, 12000, 8500, false,"Malabar Jewellery");
	GoldJewelleryEntity entity5 = new GoldJewelleryEntity( GoldJwellery.CHAIN, 70000, 0.05, 21,
			13000, 6000, false,"Joyalukkas");
	GoldJewelleryEntity entity6 = new GoldJewelleryEntity( GoldJwellery.NOSEPIERCHING, 15000,
			0.03, 3, 5000, 3000, true,"GRT Jewellers");
	GoldJewelleryEntity entity7 = new GoldJewelleryEntity( GoldJwellery.RING, 50000, 0.05,
			10, 11500, 7500, true,"Prince Jewellery");
	GoldJewelleryEntity entity8 = new GoldJewelleryEntity( GoldJwellery.NECKLACE,
			150000, 0.03, 30, 14500, 7000, false,"PC Chandra Jewellers");
	GoldJewelleryEntity entity9 = new GoldJewelleryEntity( GoldJwellery.PENDENT, 29000,
			0.02, 5, 6000, 2500, true,"Reliance Jewels");
	GoldJewelleryEntity entity10 = new GoldJewelleryEntity( GoldJwellery.BANGLES, 150000,
			0.04, 25, 2000, 3600, true,"Shubh Jewellers");
	
	List<GoldJewelleryEntity> list=Arrays.asList(entity1,entity2,entity3,entity4,entity5,entity6,entity7,entity8,entity9,entity10);
	
	
	GoldJewelleryRepository repo=new GoldJewelleryRepositoryImpl();
	repo.save(list);
	
	GoldJewelleryService service=new GoldJewelleryServiceImpl();
	service.saveAndValidate(list);
	
	Optional<GoldJewelleryEntity> findShopNameById=service.findShopNameById(2);
	if(findShopNameById.isPresent()) {
	GoldJewelleryEntity byid = findShopNameById.get();
	System.out.println(byid);
	}
	
	Optional<String> findShopNameAndId= service.findShopNameAndId(5, "Joyalukkas");
	if(findShopNameAndId.isPresent()) {
	String byNameAndId=findShopNameAndId.get();
	System.out.println(byNameAndId);
	
	}
	System.out.println("==============findMakingChargesByShopName===============");

	Optional<Double> findMakingChargesByShopName = service.findMakingChargesByShopName("Joyalukkas");
	if (findMakingChargesByShopName.isPresent()) {
		Double doub = findMakingChargesByShopName.get();
		System.out.println(doub);
	}

	System.out.println("==============findWastageChargesAndMakingChargesByShopName===============");

	Optional<Object[]> findWastageChargesAndMakingChargesByShopName = service
			.findWastageChargesAndMakingChargesByShopName("Joyalukkas");
	if (findWastageChargesAndMakingChargesByShopName.isPresent()) {
		Object[] array = findWastageChargesAndMakingChargesByShopName.get();
		for (Object object : array) {
			System.out.println(object);
		}
	}

	System.out.println("==============findTotalPriceByGramAndShopName===============");

	Optional<Double> findTotalPriceByGramAndShopName = service.findTotalPriceByGramAndShopName(3,
			"GRT Jewellers");
	if (findTotalPriceByGramAndShopName.isPresent()) {
		Double goldEntity = findTotalPriceByGramAndShopName.get();
		System.out.println(goldEntity);
	}

	System.out.println("====================findAll========================");
	Collection<GoldJewelleryEntity> collect = service.findAll();
	collect.forEach(all -> System.out.println(all));

	System.out.println("=====================findAllShopName==========================");
	Collection<String> str = service.getAllShopName();
	str.forEach(shop -> System.out.println(shop));

	System.out.println("===========================findAllShopNameAndType===============================");
	Collection<Object[]> objType = service.getAllShopNameAndType();
	for (Object[] objects : objType) {
		for (int array = 0; array < objects.length; array++) {
			System.out.println(objects[array]);
		}
	}
	System.out.println("===============findAllByMakingChargesGreaterThan====================");
	Optional<Collection<GoldJewelleryEntity>> opt = service.findAllByMakingChargesGreaterThan(4000);
	if (opt.isPresent()) {
		Collection<GoldJewelleryEntity> coll = opt.get();
		System.out.println(coll);
	}

	System.out.println(
			"=========================findAllByMakingChargesLesserThan===============================");
	Optional<Collection<GoldJewelleryEntity>> optional = service
			.findAllByMakingChargesLesserThan(1000);
	if (optional.isPresent()) {
		Collection<GoldJewelleryEntity> colGold = optional.get();
		System.out.println(colGold);
	}

	System.out.println("============findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan===========");
	Optional<Collection<GoldJewelleryEntity>> waste = service
			.findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(500, 4000);
	if (waste.isPresent()) {
		Collection<GoldJewelleryEntity> jewe = waste.get();
		System.out.println(jewe);
	}
	
    finally {
		JavaUtil.getValue().close();
	}

}

}
