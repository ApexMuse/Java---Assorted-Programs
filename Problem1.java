/* Write a program that reads the names from all the ten files described in 
 * Exercise 12.31 (assignment 2 � problem 3), sorts all names (boy and girl 
 * names together, duplicates removed), and stores the sorted names in one 
 * file ten per line (only names, no ranks).
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;

public class Problem1 {

	public static void main(String[] args) throws IOException {
		
		/* Read the data from all ten files, one line at a time.
		 * Split lines by gender, and create a BabData object for
		 *  each set.  Place objects into ArrayList.
		 */		
		ArrayList<BabyData> babyInfo = new ArrayList<BabyData>();
		
		for (int i = 2001; i < 2011; i++) {				
			String fileText = "Babynamesranking" + i + ".txt";
			
			// Create Scanner object with file
			Scanner fileScan = new Scanner (new File(fileText));
			
			while (fileScan.hasNext()){
				// Create String with line from text file
				String babyLine = fileScan.nextLine();
				
				// Create array with data from String babyLine
				String[] lineData = babyLine.split("\\s+");
				
				// Assign data to new array
				String boyName = lineData[1];
				String girlName = lineData[3];
				
				// Create BabyData objects & add to ArrayList babyInfo
				babyInfo.add(new BabyData(boyName));
				babyInfo.add(new BabyData(girlName));
			}
			
			fileScan.close();
		}
		
		// Create an array with only the list of names
		String[] names = new String[babyInfo.size()];
		for (int i = 0; i < babyInfo.size(); i++){
			names[i] = babyInfo.get(i).getName();
		}
		
		// Remove duplicates from the array	and sort it	
		names = new HashSet<String>(Arrays.asList(names)).toArray(new String[0]);
		Arrays.sort(names);
		
		// Store the names in one file, ten per line
		File file = new File("Problem1.txt");
		PrintWriter printWriter = new PrintWriter(file);		
		
		for (int i = 0; i < names.length; i++){
			for (int j = 0; j < 10 && i < names.length; j++){
				printWriter.print(names[i] + " ");
				i++;
			}
			printWriter.println();
		}

		printWriter.close();	

	}
}
