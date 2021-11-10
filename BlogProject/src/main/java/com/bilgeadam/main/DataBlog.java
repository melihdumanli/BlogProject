package com.bilgeadam.main;

import com.bilgeadam.controller.AdminController;
import com.bilgeadam.controller.UserController;
import com.bilgeadam.dto.AdminDto;
import com.bilgeadam.dto.UserDto;

import java.util.ArrayList;

public class DataBlog {
    public static void main(String[] args) {
        AdminDto adminDto = new AdminDto();
        adminDto.setName("Burak");
        adminDto.setSurname("GÜNEŞ");
        adminDto.setEmailAddress("burakgunes@gmail.com");
        adminDto.setPassword("12345");
        adminDto.setTelNumber("04444444444");

        AdminController adminController = new AdminController();
        adminController.insert(adminDto);

        UserDto userDto = new UserDto();
        userDto.setName("Ali");
        userDto.setSurname("ERGÜL");
        userDto.setEmailAddress("aliergul@hotmail.com");
        userDto.setPassword("54321");
        userDto.setTelNumber("03333333333");
        userDto.setHesCode("HES-123");

        UserController userController = new UserController();
        userController.insert(userDto);

        AdminController adminDao = new AdminController();
        ArrayList<AdminDto> temp = adminDao.list();
        temp.forEach(System.out::println);

        UserController userDao = new UserController();
        ArrayList<UserDto> temp2 = userDao.list();
        temp2.forEach(System.out::println);
    }
}
