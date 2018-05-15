package com.bonjourcs.java.ejc.io;

import java.util.Date;
import java.util.Scanner;

/**
 * @author Liang Chenghao
 * Description: a mock console application
 * Date: 2018/5/15
 */
public class MockConsole {

	private static final String EXIT = "exit";
	private static final String CLEAR = "clear";
	private static final String SU = "su";
	private static final int ROW = 5;

	public static void main(String[] args) {

		// show login banner
		login();

		Scanner in = new Scanner(System.in);
		System.out.print("[bonjourcs@localhost ~]$ ");

		String str;
		while ((str = in.next()) != null) {
			// handle input string
			handle(str);
		}

	}

	/**
	 * login banner
	 */
	private static void login() {
		try {
			System.out.println("Connecting to localhost:21...");
			Thread.sleep(500);
			System.out.println("Connection established.");
			Thread.sleep(500);
			System.out.println("Last login: " + new Date(System.currentTimeMillis()) + " from 127.0.0.1");
		} catch (Exception e) {
			System.out.println("Error happened.");
		}
	}

	/**
	 * logout banner
	 */
	private static void logout() {
		try {
			System.out.println("logout");
			Thread.sleep(500);
			System.out.println("Connecting closing...Socket close.");
			Thread.sleep(500);
			System.out.println("Connection closed by foreign host..");
			Thread.sleep(500);
			System.out.println("Disconnected from remote host(bonjourcs@localhost) at " + new Date(System.currentTimeMillis()));
			Thread.sleep(500);
			System.exit(0);
		} catch (Exception e) {
			System.out.println("Error happened.");
		}
	}

	/**
	 * handle input string
	 *
	 * @param str input string
	 */
	private static void handle(String str) {
		if (EXIT.equalsIgnoreCase(str)) {
			logout();
		} else if (CLEAR.equalsIgnoreCase(str)) {
			clear();
		} else {
			normal(str);
		}

	}

	/**
	 * handle normal string
	 *
	 * @param str input string
	 */
	private static void normal(String str) {
		System.out.println("-bash: " + str + ": command not found");
		System.out.print("[bonjourcs@localhost ~]$ ");
	}

	/**
	 * clean console
	 */
	private static void clear() {
		for (int i = 0; i < ROW; i++) {
			System.out.println();
		}
		System.out.print("[bonjourcs@localhost ~]$ ");
	}

}
