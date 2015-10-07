package com.bit2015.network.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static final int PORT = 60000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket datagramsocket = null;
		try {
			// 1. UDP 서버 소켓 생성
			datagramsocket = new DatagramSocket(PORT);

			// 2. 수신대기
			while (true) {
				log("packet 수신 대기");

				DatagramPacket receivePacket = new DatagramPacket(
						new byte[BUFFER_SIZE], BUFFER_SIZE);
				datagramsocket.receive(receivePacket);

				// 3. 수신 데이터 출력
				String message = new String(receivePacket.getData(), 0,
						receivePacket.getLength(), "UTF-8");
				log("packet 수신:" + message);

				// 4. 데이터 보내기
				DatagramPacket sendPacket = new DatagramPacket(
						receivePacket.getData(), receivePacket.getLength(),
						receivePacket.getAddress(), receivePacket.getPort());
				datagramsocket.send(sendPacket);
			}
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			log("error:" + ex);
		} finally {
			// 5. 자원 정리
			datagramsocket.close();
		}
	}

	public static void log(String log) {
		System.out.println("[UDP-echo-server]" + log);
	}
}
