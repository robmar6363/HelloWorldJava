package edu.hippie.examples.networking;

import java.io.IOException;
import java.net.Socket;


/**
 * This is single-threaded port scanner monitoring ports within range 0-65535
 * or other range provided as parameters
 * 
 * @author Robert Marciniak
 *
 */
public class PortScanner {


	/**
	 *  
	 * @param args - optional program arguments, i.e. ["hostname" "minimum" "maximum"]
	 *
	 */
	public static void main(String[] args) {

		String host =args.length>0 && args[0]!=null?args[0]:"localhost";
		int min = args.length>1 && args[1]!=null?Integer.parseInt(args[1]):0;
		int max = args.length>1 && args[2]!=null?Integer.parseInt(args[2]):65535;

		System.out.println("Scanning started!");
		for (int port = min; port <= max; port++) {
			try {
				Socket s = new Socket(host, port);
				System.out.println("open port: " + port);
				s.close();
			} catch (IOException e) {
				
			}
		}
		System.out.println("Scanning ended!");

	}

}
