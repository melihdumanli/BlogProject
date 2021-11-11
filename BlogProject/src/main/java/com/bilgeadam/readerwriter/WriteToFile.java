package com.bilgeadam.readerwriter;

import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.dto.AdminDto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteToFile {
    public String writer(AdminDto t, String text) {
        String result = "";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePath.ADMINLOGSPATH(), true))) {
            bufferedWriter.write(text + " " + t.getEmailAddress() + " " + t.getPassword() + LocalDateTime.now().toString());
            bufferedWriter.flush();
            result = "Write To File Operation Succeeded";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //This method is used once to write admin data to file
    /*public static void adminWriter() {
        AdminDao adminDao = new AdminDao();
        ArrayList<AdminDto> adminDtoArrayList = adminDao.list();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePath.ADMINPATH(), true))) {
            for (int i = 0; i < adminDtoArrayList.size(); i++) {
                bufferedWriter.write(adminDtoArrayList.get(i).toString() + "\n");
                bufferedWriter.flush();
            }
            System.out.println("Write To File Operation Succeeded");
            for (int i = 0; i < adminDtoArrayList.size(); i++) {
                System.out.println(adminDtoArrayList.get(i).toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        adminWriter();
    }*/
}
