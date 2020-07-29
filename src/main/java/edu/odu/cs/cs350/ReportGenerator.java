package edu.odu.cs.cs350;

import java.util.Collections;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Iterator;
import java.util.LinkedList;
import org.xml.sax.ext.*;
import com.cedarsoftware.util.io.*;

public class ReportGenerator {
	/*
	 * writes collected data to a .json file
	 */
	public void generateJson(Website web) {
		/*
	
		JsonObject myJson = new JsonObject();
		HTMLDocument page;
		Iterator<HTMLDocument> docIt = web.allPages.iterator();
		page = docIt.next(); 
		WebsiteFile myWebFile = new WebsiteFile();
		Iterator<WebsiteFile> fileIt = myWebFile.iterator();

		
		
		myJson.put("Basepath", web.getPath());

		//json array for urls
		myJson.put(":urls", web.getURLs()); //every url
		
		//json array for pages
		JsonObject pages = new JsonObject();

		//{
		while(docIt.hasNext()) {
			pages.put("path", page.getPath());
			pages.put("imageCount", page.getImages()); //need a local and an external
			pages.put("jsCount", page.getScripts()); //local and external
			pages.put("cssCount", page.getClass());//local and external
			
			//json array for image paths
			JsonObject imagePaths = new JsonObject();
			pages.put("imagePaths", imagePaths); //every image path

			//array for script
			JsonObject scriptPaths = new JsonObject();
			pages.put("scriptPaths", scriptPaths); //every script path

			//array for css
			JsonObject cssPaths = new JsonObject();
			pages.put("cssPaths", cssPaths); //every class path

			//pages.put("linkCount", ); //intrap\intras\ext
			//}
			//one such for every page
			//end pages array
			myJson.put("pages", pages);

			//array for images
			JsonObject images = new JsonObject();
			Iterator<Image> imageIt;
			while(imageIt.hasNext()) {
				images.put("path", imageIt.getPath(), "pageCount", imageIt.getPageCount(), "usedOn", imageIt.getUsedOn());
			}//do ^ for every image
			myJson.put("images", images);

		
			Iterator<ArhciveFile> archiveIt = docIt.getArchiveFiles().iterator;
			Iterator<VideoFile> videoIt = docIt.getVideoFiles().iterator;
			Iterator<AudioFile> audioIt = docIt.getAudioFiles().iterator;
			Iterator<nonCategoryFile> nonCatIt = docIt.getNonCategoryFiles().iterator;

			JsonObject files = new JsonObject();

			JsonObject archives = new JsonObject();
			while(archiveIt.hasNext()) {
				archives.put("path", archiveIt.getPath(), "size", archiveIt.getSize());
			}
			files.put("archive", archives);
		
			JsonObject videos = new JsonObject();
			while(videoIt.hasNext()) {
				videos.put("path", videoIt.getPath(), "size", videoIt.getSize());
			}
			files.put("video", videos);

			JsonObject audios = new JsonObject();
			while(audioIt.hasNext()) {
				audios.put("path", audioIt.getPath(), "size", audioIt.getSize());
			}
			files.put("audio", audios);

			JsonObject others = new JsonObject();
			while(nonCatIt.hasNext()) {
				others.put("path", nonCatIt.getPath(), "size", nonCatIt.getSize());
			}
			files.put("other", others);

			myJson.put("files", files);

		}

		try {
			FileWriter myFile = new FileWriter("output.json");
	       // myFile.write(myJson.toJSONString());
	        myFile.close();
	    } catch (IOException e) {
	          e.printStackTrace();
		   }
		   */
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
