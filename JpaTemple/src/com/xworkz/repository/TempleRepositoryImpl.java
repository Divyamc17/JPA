package com.xworkz.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.entity.TempleEntity;
import com.xworkz.singleton.Factory;

public class TempleRepositoryImpl implements TempleRepository {

	private EntityManagerFactory factory = Factory.getValue();

	@Override
	public boolean save(TempleEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.getStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public Optional<TempleEntity> findById(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		TempleEntity entity = manager.find(TempleEntity.class, id);
		try {
			transaction.begin();
			if (entity != null) {
				System.out.println("id is found" + entity);
				return Optional.of(entity);
			} else {
				System.out.println("id is not found" + entity);
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.commit();
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteById(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(transaction);
			transaction.commit();
		} catch (PersistenceException e) {
			e.getStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return true;
	}
		
	}

