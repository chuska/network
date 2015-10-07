package com.bit2015.network.time2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class TimeClient {
	private static final String SERVER_IP = "192.168.1.26";
	private static final int SERVER_PORT = 22222;
	private static final int BUFFER_SIZE = 1024;
	public static void main(String[] args) {

		// 1. UDP 클라이언트 소켓 생성
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			// 2. 사용자 입력받기
			byte[] data = "".getBytes();
			// 3. packet 보내기
			DatagramPacket sendPacket = new DatagramPacket(data, data.length,
					new InetSocketAddress(SERVER_IP, SERVER_PORT));
			datagramSocket.send(sendPacket);
			// 4. 데이터 받기
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			datagramSocket.receive(receivePacket);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5. 데이터 출력

		// 6. 자원 정리

	}

}
