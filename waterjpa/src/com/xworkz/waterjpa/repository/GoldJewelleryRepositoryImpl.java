
package com.xworkz.waterjpa.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.waterjpa.entity.GoldJewelleryEntity;

public class GoldJewelleryRepositoryImpl implements GoldJewelleryRepository {
private EntityManagerFactory factory;
	
	@Override
	public boolean save(GoldJewelleryEntity entity) {
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		}
		catch(PersistenceException e) {
			e.getStackTrace();
			transaction.rollback();
		}
		finally {
			manager.close();
		}
		return false;
	}

	@Override
	public boolean save(List<GoldJewelleryEntity> list) {
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction= manager.getTransaction();
		try {
			transaction.begin();
			for (GoldJewelleryEntity goldJewelleryEntity : list) {
				manager.persist(goldJewelleryEntity);
			}
			transaction.commit();
		}
		catch(PersistenceException e) {
			e.getStackTrace();
			transaction.rollback();
		}
		finally {
			manager.close();
		}

		return false;
	}

	@Override
	public Optional<GoldJewelleryEntity> findShopNameById(int id) {
		EntityManager manager= factory.createEntityManager();
		try {
			Query query=manager.createNamedQuery("findShopNameById");
			query.setParameter("id",id);
		   Object obj= query.getSingleResult();
		   if(obj!=null) {
			   GoldJewelleryEntity entity=(GoldJewelleryEntity)obj;
			   return Optional.of(entity);
		   }
		}
		finally {
			manager.close();
		}
		return null;
	}

	@Override
	public Optional<String> findShopNameAndId(int id, String shopName) {
         EntityManager manager= factory.createEntityManager();
         try {
        	Query query= manager.createNamedQuery("findShopNameAndId");
        	query.setParameter("id", id);
        	query.setParameter("shop", shopName);
           Object obj= query.getSingleResult();
           if(obj!=null) {
        	   String strng=(String)obj;
        	   return Optional.of(strng);
           }
         }
         finally {
        	 manager.close();
         }
		return Optional.empty();
	}

	@Override
	public Optional<Double> findMakingChargesByShopName(String shopName) {
         EntityManager manager= factory.createEntityManager();
         try {
        	Query query= manager.createNamedQuery("findMakingChargesByShopName");
        	query.setParameter("shop",shopName );
        	Object obj=query.getSingleResult();
        	if(obj!=null) {
        		Double dou=(Double)obj;
        		return Optional.of(dou);
        	}
         }
         finally {
        	manager.close(); 
         }
		return Optional.empty();
	}

	@Override
	public Optional<Object[]> findWastageChargesAndMakingChargesByShopName(String shopName) {
               EntityManager manager=factory.createEntityManager();
               try {
            	   Query query=manager.createNamedQuery("findWastageChargesAndMakingChargesByShopName");
            	   query.setParameter("shopname",shopName );
            	   Object obj=query.getSingleResult();
            	   if(obj!=null) {
            		   Object[] ent=(Object[])obj;
            		   return Optional.of(ent);
            				   
            	   }
               }finally {
            	   manager.close();
               }
		return Optional.empty();
	}

	@Override
	public Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName) {
        EntityManager manager=factory.createEntityManager();
        try {
     	   Query query=manager.createNamedQuery("findTotalPriceByGramAndShopName");
     	   query.setParameter("gram", gram);
     	   query.setParameter("shopname",shopName );
     	   Object obj=query.getSingleResult();
     	   if(obj!=null) {
     		   Double ent=(Double)obj;
     		   return Optional.of(ent);
     				   
     	   }
        }finally {
     	   manager.close();
        }
	return Optional.empty();
		
		
	}

	@Override
	public Collection<GoldJewelleryEntity> findAll() {
		EntityManager manager=factory.createEntityManager();
		try {
			  Query query=manager.createNamedQuery("findAll");
			return query.getResultList();
		
		}finally {
			manager.close();
		}
		
	}

	@Override
	public Collection<String> getAllShopName() {
		EntityManager manager=factory.createEntityManager();
		try {
			Query query=manager.createNamedQuery("getAllShopName");
			return query.getResultList();
		
		}finally {
			manager.close();
		}
		
		
		
	}

	@Override
	public Collection<Object[]> getAllShopNameAndType() {
		EntityManager manager=factory.createEntityManager();
		try {
			return manager.createNamedQuery("getAllShopNameAndType").getResultList();
			
		
		}finally {
			manager.close();
		}
		
		
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges) {
           
		EntityManager manager=factory.createEntityManager();
		try {
			return Optional.of( manager.createNamedQuery("findAllByMakingChargesGreaterThan")
					.setParameter("charge", charges).getResultList());
					
		}finally {
			manager.close();
		}
	  
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesLesserThan(double charges) {
       
		EntityManager manager=factory.createEntityManager();
		try {
			return Optional.of( manager.createNamedQuery("findAllByMakingChargesLesserThan")
					.setParameter("charge", charges).getResultList());
					
		}finally {
			manager.close();
		}
	
	
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(
			double charges, double makingCharges) {
		EntityManager manager=factory.createEntityManager();
		try {
			return Optional.of( manager.createNamedQuery("findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan")
					.setParameter("charge", charges).setParameter("making", makingCharges).getResultList());
					
		}finally {
			manager.close();
		}
		
	}

}
