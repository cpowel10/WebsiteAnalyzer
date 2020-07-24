package edu.odu.cs.cs350;

import java.util.Collections;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Iterator;
import java.util.LinkedList;

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
	public void generateText(Website web) {
		long total = 0;
		File myFile = new File("WebsiteAnalysis.txt"); 
	 try {   
		 if (myFile.createNewFile()) {
	         System.out.println("Text File created: " + myFile.getName());
	     }
		HTMLDocument tempDoc;
		//Image tempImg = null;
        FileWriter myWrite = new FileWriter(myFile);
		Iterator<HTMLDocument> docIt = web.allPages.iterator();
		//Iterator<Image> imgIt;
		LinkedList<HTMLDocument> toWrite = new LinkedList<HTMLDocument>();
		while(docIt.hasNext())		{
			tempDoc = docIt.next();
			total += tempDoc.getTotalImageSize();
			toWrite.add(tempDoc);
		/*mgIt = tempDoc.getImages().iterator();
			while(imgIt.hasNext()) {
				tempImg = imgIt.next();
				toWrite.add(tempImg);	
				//myWrite.write((String.valueOf(tempImg.size())));
				//myWrite.write("   ");
				//myWrite.write((tempImg.path()).toString());
			}
			*/
			System.out.println("I am inside the first loop");
			
		}

		Collections.sort(toWrite);
		
		docIt = toWrite.iterator();
		while(docIt.hasNext()) {
			System.out.println("I am inside the second loop");
			tempDoc = docIt.next();
			//imgIt = tempDoc.getImages().iterator();
			//while(imgIt.hasNext()) {
			//	tempImg = imgIt.next();
			myWrite.write((String.valueOf(tempDoc.getTotalImageSize())));
			myWrite.write("   ");
			myWrite.write((tempDoc.getPath()).toString());
			myWrite.write("\n");
			//}
		}
		myWrite.write(String.valueOf(total));
		myWrite.write("  .");
		myWrite.close();
	    //return myFile;
		
    } catch(IOException ie) {
        ie.printStackTrace();
	}
	// return myFile;
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
		return null; //I think we shouldn't use this and that we should just output filename when generating each file.
	}
}
