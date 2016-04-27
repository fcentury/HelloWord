package com.jf.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		try {
			//设置了请求队列长度
			serverSocket = new ServerSocket(8000,1);
//			ServerSocket serverSocket2 = new ServerSocket(8000,1);
			System.out.println("服务器启动");
//			Thread.sleep(100000);
			Socket socket = null;
			while(true){
				socket = serverSocket.accept();
				System.out.println("new connection accepted=" + socket.getInetAddress() + ":" + socket.getPort());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
				String msg = null;
				while((msg = br.readLine()) != null){
					System.out.println(msg);
					pw.println("return " + msg);
					if(msg.equals("bye")){
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(serverSocket != null){
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
