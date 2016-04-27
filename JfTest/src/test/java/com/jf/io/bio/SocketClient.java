package com.jf.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args){
		Socket socket = null;
		try{
			socket = new Socket("127.0.0.1",8000);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			System.out.println("随便说点啥...");
			while((msg = localReader.readLine()) != null){
				pw.println(msg);
				System.out.println(br.readLine());
				if(msg.equals("bye")){
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
