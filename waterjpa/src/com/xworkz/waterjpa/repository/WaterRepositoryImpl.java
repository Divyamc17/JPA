package com.xworkz.waterjpa.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.waterjpa.entity.WaterEntity;
import com.xworkz.waterjpa.singleton.JavaUtil;

public class WaterRepositoryImpl implements WaterRepository {

	
	private EntityManagerFactory factory=JavaUtil.getValue();
	
	
	@Override
	public boolean create(WaterEntity entity) {
		/*EntityManager manager=this.factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
		}catch(PersistenceException e){
			e.printStackTrace();
			transaction.commit();
		}finally {
			manager.close();
		}*/
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		
		return false;
	}

	@Override
	public Optional<WaterEntity> findById(int id) {
     EntityManager manger=this.factory.createEntityManager();
	EntityTransaction transaction=manger.getTransaction();	
	WaterEntity entity=manger.find(WaterEntity.class,id);
		try {
			transaction.begin();
			if(entity!=null) {
				System.out.println("id is found"+entity);
				return Optional.of(entity);
			}else {
				System.out.println("id is not found"+entity); 
			}
			
			
		}catch(PersistenceException e){
			e.printStackTrace();
			transaction.commit();
		}finally {
			manger.close();
		}
		return Optional.empty();
	}

	@Override
	public boolean updateByName(int id, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
