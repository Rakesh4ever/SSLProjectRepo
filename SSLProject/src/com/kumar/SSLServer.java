package com.kumar;

import java.io.IOException;
import java.net.ServerSocket;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class SSLServer {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("javax.net.ssl.keyStore", "za.store");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		ServerSocket serverSocket= ((SSLServerSocketFactory) SSLServerSocketFactory.getDefault()).createServerSocket(4444);
		System.out.println("Server is up and ready.....");
		
		while(true) new SSLServerThread(serverSocket.accept()).start();

	}

}
