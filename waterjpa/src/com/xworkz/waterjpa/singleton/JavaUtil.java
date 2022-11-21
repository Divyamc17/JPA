package com.xworkz.waterjpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JavaUtil {
	
	private static  EntityManagerFactory factory;
	
	public static EntityManagerFactory getValue() {
		return factory;
	}
	
	static{
		System.out.println("method is created in static block");
		factory=Persistence.createEntityManagerFactory("com.xworkz");
	}

}
