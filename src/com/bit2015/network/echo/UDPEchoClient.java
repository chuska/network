package com.bit2015.network.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVER_IP = "192.168.1.97";
	private static final int SERVER_PORT = 60000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket datagramSocket = null;
		try {
			// 1. UDP 클라이언트 소켓 생성
			datagramSocket = new DatagramSocket();
			Scanner scanner = new Scanner(System.in);

			// 2. 사용자 입력받기
			while (true) {
				System.out.print(">>");
				String message = scanner.nextLine();
				if ("quit".equals(message) == true) {
					break;
				}

				// 3. packet 보내기
				byte[] data = message.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(data,
						data.length, new InetSocketAddress(SERVER_IP,
								SERVER_PORT));
				datagramSocket.send(sendPacket);

				// 4. 데이터 받기
				DatagramPacket receivePacket = new DatagramPacket(
						new byte[BUFFER_SIZE], BUFFER_SIZE);
				datagramSocket.receive(receivePacket);

				// 5. 데이터 출력
				message = new String(receivePacket.getData(), 0,
						receivePacket.getLength(), "UTF-8");
				System.out.println("<<" + message);
			}
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			log("error-" + ex);
		} finally {
			// 6. 자원 정리
			datagramSocket.close();
		}
	}

	public static void log(String log) {
		System.out.println("[UDP-echo-client]" + log);
	}
}
