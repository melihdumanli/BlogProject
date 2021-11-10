package com.bilgeadam.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.bilgeadam.dto.AdminDto;

public class AdminDao implements IDAOImplements<AdminDto> {
	
	@Override
	public void insert(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			
		}
		
	}
	
	@Override
	public void update(AdminDto t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(AdminDto t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<AdminDto> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
