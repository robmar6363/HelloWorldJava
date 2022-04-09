package edu.hippie.examples.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This program checks IP addresses of host provided as an argument
 * 
 * @author Robert Marciniak
 *
 */
public class DNSService {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("" + "Please provide single argument, eg. google.com");
			return ;
		}
		try

		{
			InetAddress[] add1 = InetAddress.getAllByName(args[0]);
			System.err.println("IP addresses of " + args[0]+":");
			for (int i = 0; i < add1.length; i++){
				System.out.println(" " + add1[i].getHostAddress());
			}
		}
		catch (UnknownHostException e){
			System.out.println("The domain: "+args[0] + " is not known" );
		}

	}

}
