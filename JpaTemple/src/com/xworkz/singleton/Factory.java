package com.xworkz.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getValue() {
		return factory;
	}
  static {
	  System.out.println("factory is in  block");
	 factory= Persistence.createEntityManagerFactory("com.xworkz");
  }
}
