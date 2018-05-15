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
	private static final Scanner in = new Scanner(System.in);
	private static final String ROOT_PASSWORD = "ROOT";

	public static void main(String[] args) {

		// show login banner
		login();

		preNormal();

	}

	private static void preNormal() {
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
		} else if (SU.equalsIgnoreCase(str)) {
			su();
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

	/**
	 * su
	 */
	private static void su() {
		System.out.print("Password: ");
		String str = in.next();

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// do nothing
		}

		if (ROOT_PASSWORD.equals(str)) {
			System.out.println("su: Authentication failure.");
			preNormal();
		} else {
			preSuNormal();
		}
	}

	/**
	 * root user loop condition
	 */
	private static void preSuNormal() {
		String str;
		System.out.print("[root@localhost /home/root]# ");
		while ((str = in.next()) != null) {
			suHandleString(str);
		}
	}

	/**
	 * root user handle input string
	 *
	 * @param str
	 */
	private static void suHandleString(String str) {
		if (EXIT.equalsIgnoreCase(str)) {
			suLogout();
		} else {
			suNormal(str);
		}
	}

	/**
	 * root user exit
	 */
	private static void suLogout() {
		System.out.println("exit");
		preNormal();
	}

	/**
	 * handle another operation
	 *
	 * @param str input string
	 */
	private static void suNormal(String str) {
		System.out.println("-bash: " + str + ": command not found");
		System.out.print("[root@localhost /home/root]# ");
	}

}
