package edu.odu.cs.cs350;

import java.util.Collections;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Iterator;
import java.util.LinkedList;
import org.json.simple.JSONObject; //Does this work for you guys?


public class ReportGenerator {
	/*
	 * writes collected data to a .json file
	 */
	public void generateJson(Website web) {
		/*
		JSONObject myJson = new JSONObject();
		HTMLDocument page;
		Iterator<HTMLDocument> docIt = web.allPages.iterator();
		page = docIt.next(); 
		Iterator<W> fileIt = myWebFile.iterator();

		
		
		myJson.put("Basepath", web.getPath());
		myJson.put(":urls", web.getURLs()); //every url
		myJson.put("pages", doNothing?);
		//{
		while(docIt.hasNext()) {
			myJson.put("path", page.getPath());
			myJson.put("imageCount", page.getImages()); //need a local and an external
			myJson.put("jsCount", page.getScripts()); //local and external
			myJson.put("cssCount", page.getClass());//local and external
			myJson.put("imagePaths", ); //every image path
			myJson.put("scriptPaths"); //every script path
			myJson.put("cssPaths", ); //every class path
			myJson.put("linkCount", ); //intrap\intras\ext
			//}
			//one such for every page
		
			myJson.put("images", );
			//[
			while() {
				myJson.put("path", getPath, "pageCount", getPageCount, "usedOn", getUsedOn);
			}//do ^ for every image
		
			myJson.put("files", );
			Iterator<ArhciveFile> = docIt.get
			myJson.put("archive", );
			while() {
				myJson.put("path", getPath, "size", getSize);
			}
			//do ^ for every archive
		
			myJson.put("video", );
			while() {
				myJson.put("path", getPath, "size", getSize);
			}
			myJson.put("audio", );
			while() {
				myJson.put("path", getPath, "size", getSize);
			}
			myJson.put("other", );
			while() {
				myJson.put("path", getPath, "size", getSize);
			}
		}
		//}
		//}
*/
		try {
			FileWriter myFile = new FileWriter("output.json");
	       // myFile.write(myJson.toJSONString());
	        myFile.close();
	    } catch (IOException e) {
	          e.printStackTrace();
	       }
	}
	
	/*
	 * writes collected data to a .txt file
	 */
	public void generateText(Website web) {
		
		//Stores the total size to be outputted on the final line
		long total = 0; 
		
		//Make a file
		File myFile = new File("WebsiteAnalysis.txt"); 
		
		//If the file was created output that it was and its name
		try {   
			if (myFile.createNewFile()) {
				System.out.println("Text File created: " + myFile.getName());
			}
		 
		//holds data between iterator 
		HTMLDocument tempDoc;
		
		//make a fileWriter to write to the file
		FileWriter myWrite = new FileWriter(myFile);
		
		//Iterator for the different pages of the website
		Iterator<HTMLDocument> docIt = web.allPages.iterator();
		
		//Store the data that will be written
		LinkedList<HTMLDocument> toWrite = new LinkedList<HTMLDocument>();
		
		//Iterate over all pages, find the total sum of image sizes, write data to toWrite
		while(docIt.hasNext())		{
			tempDoc = docIt.next();
			total += tempDoc.getTotalImageSize();
			toWrite.add(tempDoc);			
		}

		//Sorts toWrite with my overridden comparison (lexiconographical order of paths/pages)
		Collections.sort(toWrite);

		//iterate for toWrite
		docIt = toWrite.iterator();
		
		//Iterate over toWrite, print(to file), first the total image size of the page,
		//a couple spaces, then the path all on one line. Then add line break for the next. 
		while(docIt.hasNext()) {
			tempDoc = docIt.next();
			myWrite.write((String.valueOf(tempDoc.getTotalImageSize())));
			myWrite.write("   "); //will need to be a setWidth equivalent for final product
			myWrite.write((tempDoc.getPath()).toString());
			myWrite.write("\n");
		}
		
		//Print the total image size of all pages combined in proper form (same as before but with "." as path)
		myWrite.write(String.valueOf(total));
		myWrite.write("  ."); //will need a setWidth equivalent for final product
		myWrite.close();
	
	
    } catch(IOException ie) {
        ie.printStackTrace();
	}
	 
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
