/*
 * Program: Palindrome checker 
 * Programmer: Jay
 * Date: 9/24/2013
 * FileName: palindrome.java
 * Purpose: To check the string for being a palindrome.
 */

import java.util.Scanner;
public class palindrome 
{
	public static void main(String[] args)
	{
		System.out.println("Please enter a palindrome word?");
		Scanner keyboard = new Scanner(System.in);
		String word_entered = keyboard.nextLine();
		int begin = 0;
		int end = word_entered.length() - 1;
	    boolean Pal = false;
	    
	   while(begin <= end)
	   {
		   if(word_entered.charAt(begin) == word_entered.charAt(end))
		   {
			   begin+=1;
			   end+=1;
			   Pal = true;
			   System.out.println("The word is a palindrome");
			   break;
			  
		   }
		   else
		   {
			   Pal = false;
			   System.out.println("This word isn't a palindrome.");
			   break;
			   
		   }
	   }
		
	}
}