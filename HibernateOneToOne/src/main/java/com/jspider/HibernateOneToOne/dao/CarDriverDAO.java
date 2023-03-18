package com.jspider.HibernateOneToOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.HibernateOneToOne.dto.CarDTO;
import com.jspider.HibernateOneToOne.dto.DriverDTO;

public class CarDriverDAO{
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory =Persistence.createEntityManagerFactory("OneToOne");
		manager =factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	private static void closeConnection() {
		if (factory!=null) {
			factory.close();
		}
		if (manager!=null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			DriverDTO driver1=new DriverDTO();
			driver1.setId(1);
			driver1.setName("krish");
			driver1.setContact(7099921937L);
			manager.persist(driver1);

			CarDTO car= new CarDTO();
			car.setId(1);
			car.setBrand("yamaha");
			car.setModel("R15");
			car.setReg_no("MH14AB8629");
			car.setDriver(driver1);
	       manager.persist(car);
			
			transaction.commit();
		} finally {
		closeConnection();
		}
	}
}
