/*
 * Program: Fitness Heartbeat Tracker
 * Programmer: Jay
 * Date: 11/27/2013
 * Filename: Project6.java
 * Purpose: read in and output heartbeats as an html page.
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.text.*;
public class Tracker {
	//public static Scanner keyboard = new Scanner(new File())
	
	
	public static void main(String[] args) throws IOException
	{
		int heart_beat_rates;
		DecimalFormat format = new DecimalFormat("#.###");
	    ArrayList<Double> FitnessQuotient = new ArrayList<Double>();
		File fileWrite;
		PrintWriter output;
		int min = Integer.MAX_VALUE;
		int max;
	   Scanner fileReader;
	   File fileRead = new File("sample-input.txt");
	   fileReader = new Scanner(fileRead);
	   fileWrite = new File("many-heart-rates.txt");
	   output = new PrintWriter(fileWrite);
	   heart_beat_rates = fileReader.nextInt();
	   int i = 0;
	   	output.println("<html>");
		output.println("<head>");
		output.println("<body>");
			output.println("<table border=\"1\" cellpadding=\"5\">");
			output.println("<tr align=\"center\">");
			output.println("<th> Fitness Quotient");
			output.println("</th>");
			output.println("<th> Minimum Heart Rate");
			output.println("</th>");
			output.println("<th> Maximum Heart Rate");
			output.println("</th>");
			output.println("<th> Heart Rate Series");
			output.println("</th>");
			output.println("</tr>");
			
	   while(i < heart_beat_rates)
	   {
		   int heartbeat = fileReader.nextInt();
		   ArrayList<Integer> patient = new ArrayList<Integer>();
		   patient = getData(fileReader, heartbeat);
			 FitnessQuotient = getFitnessQuotient(patient);
			 double MinDouble = FitnessQuotient.get(0);
			 double MaxDouble = FitnessQuotient.get(1);
			 min =  (int) MinDouble;
			 max =  (int) MaxDouble;
			 double formatter = Double.parseDouble(format.format(FitnessQuotient.get(2)));
		   output.println("<tr>");
			 output.println("<td>");
			 output.println(formatter);
			 output.println("</td>");
			 output.println("<td>");
			 output.println(min);
			 output.println("</td>");
			 output.println("<td>");
			 output.println(max);
			 output.println("</td>");
			 output.println("<td>");
			 int k = 0;
			 for(;  k < heartbeat-1; k++)
			 {
				 output.println(patient.get(k)+ ", ");
			 }
			 output.println(patient.get(k));
			 output.println("</td>");
			 output.println("</tr>");
		  i++; 
	   }
	   output.println("</table>");
		output.println("</body>");
		output.println("</head>");
		output.println("</html>");
		output.close();
		fileReader.close();
	
	}
	
	
	public static ArrayList<Integer> getData(Scanner fileReader,int heartbeat)
	{
		ArrayList<Integer> beats = new ArrayList<Integer>();
		int i = 0;
		while(i < heartbeat)
		{
			beats.add(fileReader.nextInt());
			i++;
		}
		
		return beats;
		
	}
	public static ArrayList<Double> getFitnessQuotient(ArrayList<Integer> patient)
	{
		int i = 0;
		ArrayList<Double> fitness = new ArrayList<Double>();
		int min = patient.get(i);
		int max = patient.get(i);
		while(i < patient.size())
		{
		  if(patient.get(i) < min)
		  {
			  min = patient.get(i);
		  }
		  else if(patient.get(i) > max)
		  {
			  max = patient.get(i);
		  }
		  i++;
		}
		fitness.add((double) min);
		fitness.add((double) max);
		
		double Quotient = (2 * (double)min) / ((double)min + (double)max);
		fitness.add(Quotient);
		return fitness;
	}
}