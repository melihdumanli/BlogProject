package com.bilgeadam.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	private Connection connection;
	private static int count = 0;
	private static DatabaseInformation databaseInformation;
	
	private String url = databaseInformation.getUrl();
	private String user = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();
	
	// singleton design pattern properties 1.
	private static DatabaseConnection instance;
	
	// singleton design pattern properties 2.
	private DatabaseConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			System.out.println("PostgreSQL Driver loaded");
			this.connection = DriverManager.getConnection(url, user, password);
			System.out.println("Database connected");
			count++;
			System.out.println("DatabaseConnection count: " + count);
		} catch (Exception e) {
			System.out.println("DatabaseConnection Error");
			e.printStackTrace();
		}
	}
	
	static {
		databaseInformation = new DatabaseInformation();
	}
	
	// singleton design pattern properties 3.
	public static DatabaseConnection getInstance() {
		try {
			if (instance == null) {
				instance = new DatabaseConnection();
			} else if (instance.getConnection().isClosed()) {
				instance = new DatabaseConnection();
			}
		} catch (Exception e) {
			System.out.println("Singleton Error");
			e.printStackTrace();
		}
		
		return instance;
	}
	
	// getters and setters
	public Connection getConnection() {
		return connection;
	}
	
	public static void main(String[] args) {
		DatabaseConnection connection = new DatabaseConnection();
	}
}
