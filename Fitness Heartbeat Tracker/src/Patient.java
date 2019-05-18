/*
 * Program: Patient class
 * Programmer: Jay
 * Date: 11/27/2013
 * Filename: Patient.java
 * Purpose: used for indiviual Patients
 */
import java.text.DecimalFormat;
public class Patient 
{
	public int beat1;
	public int beat2;
	public int beat3;
	public double fitnessvalue;
	public static DecimalFormat fix = new DecimalFormat("#.###");
	
	public Patient(int heartbeat1, int heartbeat2, int heartbeat3)
	{
		beat1 = this.getFirstHeartbeat(heartbeat1);
		beat2 = this.getSecondHeartbeat(heartbeat2);
		beat3 = this.getThirdHeartbeat(heartbeat3);
		//fitnessvalue = this.CalculateFitnessQutioent();
	}
	
	public static int getFirstHeartbeat(int tempbeat)
	{
		return tempbeat;
	}
	public static int getSecondHeartbeat(int tempbeat2)
	{
		return tempbeat2;
	}
	
	public static int getThirdHeartbeat(int tempbeat3)
	{
		return tempbeat3;
	}
	
	public static double CalculateFitnessQutioent(int min, int max)
	{
		double fitness;
		String formatter;
		double FinalValue;
		
		fitness = (2 * min) / (min + max);
		formatter = fix.format(fitness);
		FinalValue = Double.parseDouble(formatter);
		return FinalValue;
	}
	
	
}