package com.kumar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SSLServerThread extends Thread{

	private Socket socket;

	public SSLServerThread(Socket socket) {
		 this.socket=socket;
	}
	
	public void run(){
		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("User '"+bufferedReader.readLine()+"' is now connected to the server .");
			while(true) printWriter.println(bufferedReader.readLine()+" echo");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
