package com.jspider.hibernate.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernate.DTO.StudentDTO;

public class StudentDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.
				createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			
			openConnection();
			
			entityTransaction.begin();
			
			StudentDTO student=new StudentDTO();
			student.setId(1);
			student.setName("Harish");
			student.setEmail("ajinkya@gmail.com");
			student.setContact(9876541320L);
			student.setCity("Pune");
			
			student.setId(2);
			student.setName("Krish");
			student.setEmail("ksrish@gmail.com");
			student.setContact(7676543270L);
			student.setCity("Banglore");
			
			student.setId(3);
			student.setName("rushi");
			student.setEmail("rushi@gmail.com");
			student.setContact(9976543270L);
			student.setCity("Dubai");
			
			entityManager.persist(student);
			
			entityTransaction.commit();
			
		} finally {
			closeConnection();
		}
	}
}
