package com.bilgeadam.socketapp;

import com.bilgeadam.controller.UserController;
import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.dto.AdminDto;
import com.bilgeadam.dto.UserDto;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSide {
    public static void main(String[] args) {
        ServerSide serverSide = new ServerSide();
        serverSide.serverStart();
    }

    public void serverStart() {
        String messageToReceive = null;
        String messageToSend = null;
        String password = null;
        boolean bool = true;
        UserController userDao = new UserController();
        UserDto userDto = new UserDto();

        int counter = 0;
        // don't need to specify a hostname, it will be the current machine
        try (ServerSocket ss = new ServerSocket(StaticPort.PORT1)) {
            Socket socket = ss.accept();// blocking call, this will wait until a connection is attempted on this port.
            BufferedReader brSystemIn = new BufferedReader(new InputStreamReader(System.in));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            System.out.println("Client Connected. Server Is Ready At Port Number : " + StaticPort.PORT1);
            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();
            BufferedReader brInputStream = new BufferedReader(new InputStreamReader(inputStream));

            // Login control
            while (true) {
                printWriter.println("Please Enter Your E-Mail Address : ");
                userDto.setEmailAddress(brInputStream.readLine());
                printWriter.println("Please Enter Your Password : ");
                userDto.setPassword(brInputStream.readLine());
                if (userDao.userLoginControl(userDto) == true) {
                    printWriter.println("Login Successful");
                    break;
                } else {
                    printWriter.println("Login Failed. Please Try Again.");
                    brInputStream.readLine();
                }
            }
            System.out.println(userDto.getEmailAddress());

            //Start Messenger
            userDto = userDao.getUserInfo(userDto.getEmailAddress());
            /*userDto.setName(userDao.getUserInfo(userDto.getEmailAddress()).getName());
            userDto.setSurname(userDao.getUserInfo(userDto.getEmailAddress()).getSurname());*/
            printWriter.println(userDto.getName() + " " + userDto.getSurname() + "." + " Welcome To Messenger.");
            printWriter.println("Please Enter ''Exit'' When You Want To Quit Program");
            printWriter.println("Please Enter Your Message : ");
            printWriter.flush();
            while (true) {
                messageToReceive = brInputStream.readLine();
                if (!messageToReceive.equalsIgnoreCase("Exit") && messageToReceive != null) {
                    System.out.println(userDto.getName() + " " + userDto.getSurname() + " : " + messageToReceive);
                } else if (messageToReceive.equals("Exit")) {
                    printWriter.println("You Have Successfully Logged Out.");
                    System.exit(0);
                }
                messageToSend = brSystemIn.readLine();
                printWriter.println(messageToSend);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
