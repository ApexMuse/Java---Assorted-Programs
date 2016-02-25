/* Write a program that prompts the user to enter one of the file names 
 * described in Exercise 12.31, reads the data from the file, and stores 
 * the data in a new file without the rankings. The new file is the same 
 * as the original file except that it does not have the ranking for each 
 * row. The new file is named as the input file with the extension .new.
 */

import java.util.Scanner;
import java.io.*;

import javax.swing.*;

public class Problem3 {

	public static void main(String[] args) throws IOException {
		
		// Get the year from the user using drop-down selection to eliminate errors
		JFrame yearFrame = new JFrame();
		final String[] years = {"2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"};
		String year = (String)JOptionPane.showInputDialog(
				      yearFrame, 
				      "Please select a year...",
				      "Year Selection",
				      JOptionPane.QUESTION_MESSAGE,
				      null, 
				      years, 
				      years[0]);
		
		// Append user's year to the text of the file name
		String inputFile = "Babynamesranking" + year + ".txt";
		
		// Create output file
		File outputFile = new File("Babynamesranking" + year + ".new");
				
		// Create Scanner objects
		Scanner inputScan = new Scanner (new File(inputFile));
		
		// Create PrintWriter for the output file
		PrintWriter printWriter = new PrintWriter(outputFile);
		
		while (inputScan.hasNext()) {
			
			// Create String with line from text file
			String babyLine = inputScan.nextLine();
			
			// Create array with data from String babyLine
			String[] lineData = babyLine.split("\\s+");
			
			// Output data to the new file
			printWriter.println(lineData[1] + " " + lineData[2] + " " + lineData[3] + " " + lineData[4]);
			
		}
		
		inputScan.close();
		printWriter.close();

	}

}
