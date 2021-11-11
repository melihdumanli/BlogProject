package com.bilgeadam.login;

import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.dto.AdminDto;

import java.util.Scanner;

public class AdminLogin {
    public void AdminCheck(){
        Scanner scanner = new Scanner(System.in);
        AdminDto adminDto = new AdminDto();
        AdminDao adminDao = new AdminDao();
        System.out.println("Please Enter Your E-Mail Address : ");
        adminDto.setEmailAddress(scanner.nextLine());
        System.out.println("Please Enter Your Password : ");
        adminDto.setPassword(scanner.nextLine());
        if (adminDao.adminLoginControl(adminDto) == true) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed. Please Try Again.");
        }
    }
}
