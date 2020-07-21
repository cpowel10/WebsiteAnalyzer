package edu.odu.cs.cs350;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Iterator;

public class ReportGenerator {
	/*
	 * writes collected data to a .json file
	 */
	public File generateJson(Website web) {
		return null;
	}
	
	/*
	 * writes collected data to a .txt file
	 */
	public File generateText(Website web) {
		
		File myFile = new File("notSure.txt"); 
	 try {   
		 if (myFile.createNewFile()) {
	         System.out.println("File created: " + myFile.getName());
	     }
		 
        FileWriter myWrite = new FileWriter("notSure.txt");
		Iterator<HTMLDocument> docIt = web.getPages().iterator();
		
/*		while(docIt.hasNext())
		{
			Iterator<Tag> tagIt = new docIt.getImages().iterator();
			while(tagIt.hasNext())
				myWrite.write(tagIt.size().toString());
				myWrite.write("   ");
				myWrite.write(tagIt.path());
		}
*/
		myWrite.close();
	    return myFile;
	
    } catch(IOException ie) {
        ie.printStackTrace();
	}
	 return myFile;
	}
	/*
	 * writes collected data to a .xls file
	 */
	public File generateXls(Website web) {
		return null;
	}
	
	/*
	 * writes The names of all output files(one per line) to standard out.
	 */
	public File generateDisplay(Website web) {
		return null;
	}
}
