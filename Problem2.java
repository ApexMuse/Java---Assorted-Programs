/* Write a program that obtains the cumulative ranking for the names 
 * in the ten years using the data from the ten files described in 
 * Exercise 12.31. You program should write to a file the cumulative 
 * ranking for boy's names and to another file the cumulative ranking 
 * for girl's names. For each name, display its ranking, name, and its 
 * cumulative count.
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

public class Problem2 {

	public static void main(String[] args) throws IOException {
		
		/* Read the data from all ten files, one line at a time.
		 * Split lines by gender, and create a BabData object for
		 *  each set.  Place objects into ArrayList.
		 */		
		ArrayList<BabyData> boyBabies = new ArrayList<BabyData>();
		ArrayList<BabyData> girlBabies = new ArrayList<BabyData>();
		
		for (int i = 2001; i < 2011; i++) {				
			String fileName = "Babynamesranking" + i + ".txt";
			
			// Create Scanner object with file
			Scanner fileScan = new Scanner (new File(fileName));
			
			while (fileScan.hasNext()){
				// Create String with line from text file
				String babyLine = fileScan.nextLine();
				
				// Create array with data from String babyLine
				String[] lineData = babyLine.split("\\s+");
				
				// Assign data to variables 
				String boyName = lineData[1];
				Integer boyTotal = Integer.valueOf(lineData[2].replaceAll(",", ""));
				String girlName = lineData[3];
				Integer girlTotal = Integer.valueOf(lineData[4].replaceAll(",", ""));
				
				/* Check boyBabies ArrayList to see if it already contains the boy name.
				 * If it does, update the total number of babies and break the loop.
				 * If it doesn't, add a new BabyData object.
				 */
				boolean boyDuplicate = false;
				for(int x = 0; x < boyBabies.size(); x++) {
					if (boyBabies.get(x).getName().equals(boyName)) {
						boyDuplicate = true;
						int newTotal = boyTotal + boyBabies.get(x).getNumOfBabies();
						boyBabies.get(x).setNumOfBabies(newTotal);
						break;
					}
				}
				if (!boyDuplicate) {
					boyBabies.add(new BabyData("Male", boyName, boyTotal));
				}
				
				/* Check girlBabies ArrayList to see if it already contains the girl name.
				 * If it does, update the total number of babies and break the loop.
				 * If it doesn't, add a new BabyData object.
				 */
				boolean girlDuplicate = false;
				for(int x = 0; x < girlBabies.size(); x++) {
					if (girlBabies.get(x).getName().equals(girlName)) {
						girlDuplicate = true;
						int newTotal = girlTotal + girlBabies.get(x).getNumOfBabies();
						girlBabies.get(x).setNumOfBabies(newTotal);
						break;
					}
				}
				if (!girlDuplicate) {
					girlBabies.add(new BabyData("Female", girlName, girlTotal));
				}
				
			} // End of while loop
			
			fileScan.close();
				
		} // End of for loop
		
		// Sort the ArrayLists by numOfBabies in descending order
		Collections.sort(boyBabies,new Comparator<BabyData>() {
			@Override
			public int compare(BabyData o1, BabyData o2) {
				return o2.getNumOfBabies().compareTo(o1.getNumOfBabies());
			}
		});
		Collections.sort(girlBabies,new Comparator<BabyData>() {
			@Override
			public int compare(BabyData o1, BabyData o2) {
				return o2.getNumOfBabies().compareTo(o1.getNumOfBabies());
			}
		});

		
		// Write the ArrayLists to two separate files
		File boyFile = new File("Problem2Boys.txt");
		PrintWriter boyPrintWriter = new PrintWriter(boyFile);
		int count = 1;
		for (int i = 0; i < boyBabies.size(); i++) {
			boyPrintWriter.println(count + " " + boyBabies.get(i).getName() + " " 
							+ NumberFormat.getNumberInstance(Locale.US).format(boyBabies.get(i).getNumOfBabies()));
			count++;
		}
		boyPrintWriter.close();
		
		File girlFile = new File("Problem2Girls.txt");
		PrintWriter girlPrintWriter = new PrintWriter(girlFile);
		count = 1;
		for (int i = 0; i < girlBabies.size(); i++) {
			girlPrintWriter.println(count + " " + girlBabies.get(i).getName() + " " 
							+ NumberFormat.getNumberInstance(Locale.US).format(girlBabies.get(i).getNumOfBabies()));
			count++;
		}
		girlPrintWriter.close();		
		
	} // End of main
				
} // End of class Problem2