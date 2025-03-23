package myjavaproject;

public class swapTwoVariables {
	public static void main (String[] args) {
		String x = "water";
		String y = "wine";
		
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		String temp = null; // We give it no value
		
		temp = x;
		x = y;
		y = temp;
		
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
	}
}
