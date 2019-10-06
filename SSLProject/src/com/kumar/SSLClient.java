package com.kumar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

public class SSLClient {

	public static void main(String[] args) throws UnknownHostException, IOException {


		System.setProperty("javax.net.ssl.trustStore", "za.store");
		Socket socket =((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket("localhost",4444);
        BufferedReader socketBufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader cmdsocketBufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter customer name : ");
        printWriter.println(cmdsocketBufferedReader.readLine());
        String message=null;
        while(true){
        	System.out.println("Send a messge to server");
        	message=cmdsocketBufferedReader.readLine();
        	if(message.equalsIgnoreCase("QUIT")){
        		printWriter.println(message);
        		socket.close();
        		break;
        	}
        	printWriter.println(message);
        	System.out.print("Message reply back to server :");
        	System.out.println(socketBufferedReader);
        }
	}

}
