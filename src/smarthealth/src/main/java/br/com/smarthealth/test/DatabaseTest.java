package br.com.smarthealth.test;

import javax.persistence.Persistence;

public class DatabaseTest {
	
	public static void main(String[] args) {
		
		// Initialize Database
		Persistence.createEntityManagerFactory("SmartHealth").createEntityManager();	
	}
}
