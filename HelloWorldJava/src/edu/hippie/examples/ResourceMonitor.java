package edu.hippie.examples;

import java.util.*;

/**
 * Program displaying System properties and JRE VM resources.
 * 
 * @author Robert Marciniak
 *
 */
public class ResourceMonitor {

	public static void main(String[] args) {
		System.out.println(new Date());
		Properties p = System.getProperties();
		p.list(System.out);
		System.out.println("--- Memory Usage:");
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total Memory = " + rt.totalMemory() + " Free Memory = " + rt.freeMemory());
	}
}