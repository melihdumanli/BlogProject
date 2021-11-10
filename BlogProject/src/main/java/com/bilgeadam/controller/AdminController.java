package com.bilgeadam.controller;

import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.dao.IDAOImplements;
import com.bilgeadam.dto.AdminDto;

import java.util.ArrayList;
import java.util.List;

public class AdminController implements IDAOImplements<AdminDto> {

    // variable declaration
    private AdminDto adminDto;
    private AdminDao adminDao;
    private List<AdminDto> adminList;

    //constructor
    public AdminController() {
        adminDto = new AdminDto();
        adminDao = new AdminDao();
        adminList = new ArrayList<>();
    }

    @Override
    public void insert(AdminDto t) {
        adminDao.insert(t);
    }

    @Override
    public void update(AdminDto t) {
        adminDao.update(t);
    }

    @Override
    public void delete(AdminDto t) {
        adminDao.delete(t);
    }

    @Override
    public ArrayList<AdminDto> list() {
        return adminDao.list();
    }

    //getters and setters
    public AdminDto getAdminDto() {
        return adminDto;
    }

    public void setAdminDto(AdminDto adminDto) {
        this.adminDto = adminDto;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public List<AdminDto> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<AdminDto> adminList) {
        this.adminList = adminList;
    }

}


