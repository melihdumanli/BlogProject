package com.bilgeadam.socketapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
	public static void main(String[] args) {
		clientStart();
	}
	
	public static void clientStart() {
		String messageToServer = "";
		String messageFromServer = "";
		boolean checkValue = true;
		// need host and port, we want to connect to the ServerSocket at port PORT1
		try (Socket socket = new Socket("localhost", StaticPort.PORT1)) {
			// create a BufferedReader to read from the socket
			BufferedReader brSystemIn = new BufferedReader(new InputStreamReader(System.in));
			// get the output stream from the socket.
			OutputStream outputStream = socket.getOutputStream();
			// create a PrintWriter to write to the socket
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			// get the input stream from the socket
			InputStream inputStream = socket.getInputStream();
			// create a BufferedReader to read from the socket
			BufferedReader brInputStream = new BufferedReader(new InputStreamReader(inputStream));
			
			// read from the socket "You Have Successfully Logged In."
			while (checkValue) {
				messageFromServer = brInputStream.readLine();
				System.out.println(messageFromServer);
				if (messageFromServer.equals("Login Successful")) {
					checkValue = false;
				}
				messageToServer = brSystemIn.readLine();
				printWriter.println(messageToServer);
			}
			System.out.println(brInputStream.readLine());
			System.out.println(brInputStream.readLine());
			System.out.println(brInputStream.readLine());
			
			while (true) {
				printWriter.println(brSystemIn.readLine());
				printWriter.flush();
				messageFromServer = brInputStream.readLine();
				System.out.println(messageFromServer);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
