package com.bit2015.network.time;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
	private static final int PORT = 22222;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket datagramsocket = null;
		try {
			datagramsocket = new DatagramSocket(PORT);
			while (true) {
				System.out.println("packet 수신 대기");
				DatagramPacket receivePacket = new DatagramPacket(
						new byte[BUFFER_SIZE], BUFFER_SIZE);
				datagramsocket.receive(receivePacket);
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss a");
				String date = format.format(new Date());
				byte[] data = date.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(data,
						data.length, receivePacket.getAddress(),
						receivePacket.getPort());
				datagramsocket.send(sendPacket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5. 자원 정리
			datagramsocket.close();
		}
	}

}
