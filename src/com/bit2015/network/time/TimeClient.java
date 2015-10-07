package com.bit2015.network.time;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TimeClient {
	private static final String SERVER_IP = "192.168.1.26";
	private static final int SERVER_PORT = 22222;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket datagramSocket = null;
		try {
			datagramSocket = new DatagramSocket();
			byte[] data = "".getBytes();
			DatagramPacket sendPacket = new DatagramPacket(data, data.length,
					new InetSocketAddress(SERVER_IP, SERVER_PORT));
			datagramSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(
					new byte[BUFFER_SIZE], BUFFER_SIZE);
			datagramSocket.receive(receivePacket);
			String date = new String(receivePacket.getData(), 0,
					receivePacket.getLength(), "UTF-8");
			System.out.println(date);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			datagramSocket.close();
		}
	}

}
