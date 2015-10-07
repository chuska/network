package com.bit2015.network.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.network.chat.ChatServerProcessThread;

public class HttpServer {
	private static final int PORT = 8088;

	public static void main(String[] args) {
		ServerSocket serversocket = null;

		try {
			// 1. 서버 소켓 생성
			serversocket = new ServerSocket();

			// 2. binding
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostAddress = inetAddress.getHostAddress();
			serversocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결기다림" + hostAddress + ":" + PORT);
			// 3. 연결요청 기다림
			while (true) {
				Socket socket = serversocket.accept();
				Thread thread = new HttpThread(socket);
				thread.start();
			}
		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			if (serversocket != null && serversocket.isClosed() == false) {
				try {
					serversocket.close();
				} catch (IOException ex) {
					log("error:" + ex);
				}
			}
		}
	}

	public static void log(String log) {
		System.out.println("[chat-server]" + log);
	}
}
