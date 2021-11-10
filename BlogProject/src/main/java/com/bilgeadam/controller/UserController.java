package com.bilgeadam.controller;

import com.bilgeadam.dao.IDAOImplements;
import com.bilgeadam.dao.UserDao;
import com.bilgeadam.dto.UserDto;

import java.util.ArrayList;

public class UserController implements IDAOImplements<UserDto> {

    // variable declaration
    private UserDto userDto;
    private UserDao userDao;
    private ArrayList<UserDto> userList;

    // constructor
    public UserController() {
        this.userDto = new UserDto();
        this.userDao = new UserDao();
        this.userList = new ArrayList<>();
    }

    // method declaration
    @Override
    public void insert(UserDto t) {
        userDao.insert(t);
    }

    @Override
    public void update(UserDto t) {
        userDao.update(t);
    }

    @Override
    public void delete(UserDto t) {
        userDao.delete(t);
    }

    @Override
    public ArrayList<UserDto> list() {
        return userDao.list();
    }

    // getter and setter
    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ArrayList<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserDto> userList) {
        this.userList = userList;
    }
}
