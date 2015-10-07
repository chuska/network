package com.bit2015.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.print(">");
				String host = scanner.nextLine();
				if ("exit".equals(host) == true) {
					break;
				}
				InetAddress[] inetAddresses = InetAddress.getAllByName(host);
				for (int i = 0; i < inetAddresses.length; i++) {
					System.out.println(inetAddresses[i].getHostName() + ":"
							+ inetAddresses[i].getHostAddress());
				}
			}
			scanner.close();
		} catch (UnknownHostException ex) {
			System.out.println("IP를 가져올 수 없습니다.");
		}
	}
}
