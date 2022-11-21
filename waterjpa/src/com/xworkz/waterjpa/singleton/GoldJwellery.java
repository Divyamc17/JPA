package com.xworkz.waterjpa.singleton;

public enum GoldJwellery {
	
	
	NECKLACE("Necklace"),BANGLE("Bangle"),RING("Ring"),BRACELET("Bracelet"),EARRING("Ear-ring"),
	NOSEPIERCHING("Nose-Pierching"),CHAIN("Chain"),ANKLET("Anklet"),BANGLES("Bangles"),NOSEPIN("Nose-pin"),PENDENT("Pendent");
	
	private String value;
	
	private GoldJwellery(String value) {
		this.value=value;
	}

	public String getValue() {
		return value;
	}

}
