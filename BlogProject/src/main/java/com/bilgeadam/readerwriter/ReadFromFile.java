package com.bilgeadam.readerwriter;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFromFile {
    public void adminLogReader() {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath.ADMINLOGSPATH()))) {
            String line="",result ="";
            while ((line=bufferedReader.readLine()) != null) {
                result = result + line +"\n";
            }
            System.out.println(result);
            System.out.println("Reading Completed Successfully");
        } catch (Exception e) {
            System.out.println("Reading Admin Logs Failed");
            e.printStackTrace();
        }
    }

    public void showAdminList() {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath.ADMINPATH()))) {
            String line="",result ="";
            while ((line=bufferedReader.readLine()) != null) {
                result = result + line +"\n";
            }
            System.out.println(result);
            System.out.println("Reading Completed Successfully");
        } catch (Exception e) {
            System.out.println("Reading Admin List Failed");
            e.printStackTrace();
        }
    }
}
