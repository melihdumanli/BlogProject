package com.bilgeadam.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.bilgeadam.utils.DatabaseConnection;

// CRUD generics DML
public interface IDAOImplements<T> {
	void insert(T t); // insert into tableName() values()
	
	void update(T t); // update tableName() set name=""
	
	void delete(T t); // delete from tableName where id=5
	
	public ArrayList<T> list(); // select * from tableName
	
	default Connection getInterfaceConnection() {
		return DatabaseConnection.getInstance().getConnection();
	}
	
}
