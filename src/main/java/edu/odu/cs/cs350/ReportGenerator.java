package edu.odu.cs.cs350;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.util.Collections; //
import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
//import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.xml.sax.ext.*;
import com.cedarsoftware.util.io.*;
//import org.apache.poi.*;
//import org.apache.poi.xssf.usermodel.*;
import java.util.List;
import java.util.Vector;
//import java.util.function.ObjLongConsumer;
import java.util.HashMap;
//import java.nio.file.Paths;
import java.nio.file.Path;


public class ReportGenerator {
	private String myTime;
	/*
	 * sets the current date and time in YYYYMMDD-HHMMSS format
	 */
	public void setTime(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		myTime = dtf.format(now);  
		//Inspiration/much credit to https://www.javatpoint.com/java-get-current-date
	}
	/*
	 * gets the private String myTime
	 * @returns string myTime
	 */
	public String getTime(){
		return myTime;
	}
	/*
	 * writes collected data to a .json file
	 * @param Website contains data to be reported
	 * @throws IOexception
	 */
	public void generateJson(Website web) {
		try {
			Map<String, Object> customMap = new HashMap<>();

	        //List<String> paths = new Vector<String>();
    	    //for (HTMLDocument page : web.getPages()) {
        	//    paths.add(page.getPath().toString());
        	//}

			Map args = new HashMap<>();
			args.put(JsonWriter.PRETTY_PRINT, true); // Make the output human readable
			args.put(JsonWriter.TYPE, false); // Hide the type metadata 		
		
			HTMLDocument page;
			Iterator<HTMLDocument> docIt = web.getPages().iterator();
			page = docIt.next(); 
			
			customMap.put("basepath", web.getPath().toString()); //Have tried moving this almost everywhere to get it to work
			//json array for urls
			customMap.put("urls", web.getURLs()); //every url
			//json array for pages
			Map<String, Object> pages = new HashMap<>();
			while(docIt.hasNext()) {
				page = docIt.next();
				pages.put("path", page.getPath().toString());

				Map<String, Object> counts = new HashMap<>();
				counts.put("local", String.valueOf(page.getLocalImages(page.getImages())));
				counts.put("external", String.valueOf(page.getExternalImages(page.getImages())));
				pages.put("imageCount", counts); //need a local and an external

				counts = new HashMap<>();
				counts.put("local",String.valueOf(page.getLocalScripts(page.getScripts())));
				counts.put("external", String.valueOf(page.getExternalScripts(page.getScripts())));
				pages.put("jsCount", counts); //local and external

				counts = new HashMap<>();
				counts.put("local", String.valueOf(page.getLocalStyles(page.getStyles())));
				counts.put("external", String.valueOf(page.getExternalStyles(page.getStyles())));
				pages.put("cssCount", counts);//local and external
				
				//json array for image paths
				List<String> imagePaths = new Vector<String>();
				for (Image img : page.getImages()) {
					imagePaths.add(img.getPath().toString());
				}
				pages.put("imagePaths", imagePaths); //every image path

				//array for script
				List<String> scriptPaths = new Vector<String>();
				for (Script scpt : page.getScripts()) {
					scriptPaths.add(scpt.getPath().toString());
				}
				pages.put("scriptPaths", scriptPaths); //every script path

				//array for css
				List<String> cssPaths = new Vector<String>();
				for (Style styl : page.getStyles()) {
					cssPaths.add(styl.getPath().toString());
				}
				pages.put("cssPaths", cssPaths); //every class path

				//pages.put("linkCount", ); //intrap\intras\ext
				//one such for every page
				//end pages array
				customMap.put("pages", pages);

				//array for images
				Map<String, Object> images = new HashMap<>();

				Iterator<Image> imageIt = page.getImages().iterator();
				Image image;
				while(imageIt.hasNext()) {
					image = imageIt.next();
					images.put("path", image.getPath().toString());
					images.put("pageCount", String.valueOf(image.numPages()));

					List<String> usedOn = new Vector<String>();
					for (Path path : image.getListings()) {
						usedOn.add(path.toString());
					}
					images.put("usedOn", usedOn);
				}//do ^ for every image
				customMap.put("images", images);

				Iterator<ArchiveFile> archiveIt = web.getArchiveFiles().iterator();
				Iterator<VideoFile> videoIt = web.getVideoFiles().iterator();
				Iterator<AudioFile> audioIt = web.getAudioFiles().iterator();
				Iterator<NonCategoryFile> nonCatIt = web.getNonCatFiles().iterator();

				Map<String, Object> files = new HashMap<>();

				Map<String, Object> archives = new HashMap<>();
				ArchiveFile archive;
				while(archiveIt.hasNext()) {
					archive = archiveIt.next();
					archives.put("path", archive.path().toString());
					archives.put("size", String.valueOf((archive.getSize())));
				}
				files.put("archive", archives);
			
				Map<String, Object> videos = new HashMap<>();
				VideoFile video;
				while(videoIt.hasNext()) {
					video = videoIt.next();
					videos.put("path", video.path().toString());
					videos.put("size", String.valueOf(video.getSize()));
				}
				files.put("video", videos);

				Map<String, Object> audios = new HashMap<>();
				AudioFile audio;
				while(audioIt.hasNext()) {
					audio = audioIt.next();
					audios.put("path", audio.path().toString());
					audios.put("size", String.valueOf(audio.getSize()));
				}
				files.put("audio", audios);

				Map<String, Object> others = new HashMap<>();
				NonCategoryFile nonCat;
				while(nonCatIt.hasNext()) {
					nonCat = nonCatIt.next();
					others.put("path", nonCat.path().toString());
					others.put("size", String.valueOf(nonCat.getSize()));
				}
				files.put("other", others);

				customMap.put("files", files);
			}
			String json = "something went wrong";
			json = JsonWriter.objectToJson(customMap, args);
			String fileName = getTime() + "-summary.json";
			File myOut = new File(fileName);
			FileWriter myFile = new FileWriter(myOut);
			System.out.println("JSON file created: " + myOut.getName());
			myFile.write(json);
			myFile.close();	

		} 
		catch (IOException e) {
	        e.printStackTrace();
		}
	}
	
	/*
	 * writes collected data to a .txt file
	 * @param Website contains data to be reported
	 * @throws IOexception
	 */
	public void generateText(Website web) {
		
		//Stores the total size to be outputted on the final line
		long total = 0; 
		
		String fileName = getTime() + "-summary.txt";
		//Make a file
		File myFile = new File(fileName); 
		
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
			Iterator<HTMLDocument> docIt = web.getPages().iterator();
		
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
	
	
		} 
		catch(IOException ie) {
			ie.printStackTrace();
		}
	 
	}
	/*
	 * writes collected data to a .xls file
	 * @param Website contains data to be reported
	 * @throws IOexception
	 */
	public void generateXls(Website web) {
		int counter = 1;

		//Iterate over the pages of the website
		Iterator<HTMLDocument> pageIt = web.getPages().iterator();

		//Create a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 

		//Create a sheet of the workbook titled summary
		XSSFSheet sheet = workbook.createSheet("summary");
		
		//Map for data, int for row number, object for data
		Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
		
		//Sets up column headers (row 0)
		data.put(0, new Object[] {"Page", "#Images", "#CSS", "Scripts", "#Links(Intra-Page)", "#Links(Internal)", "#Links(External)"});

		//collect data for each page
		while(pageIt.hasNext()){
			HTMLDocument page = pageIt.next();
			data.put(counter, new Object[] {page.getPath().toString(), page.getImages().size(), page.getStyles().size(), page.getScripts().size(), page.getIntra(), page.getIntern(), page.getExtern()});
			
			//Increase row number
			counter++;
		}
		  
		Set<Integer> keySet = data.keySet();
		int rowNum = 0;

		//Works through each cell of the sheet outputting the collected data
		for (Integer key : keySet){
			Row row = sheet.createRow(rowNum++);
			Object [] objArr = data.get(key);
			int cellNum = 0;
			for (Object obj : objArr){
			   Cell cell = row.createCell(cellNum++);
			   if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
			}
		}
		try{
			String fileName = getTime() + "-summary.xlsx";
			File myOut = new File(fileName); 
			FileOutputStream out = new FileOutputStream(myOut);
			workbook.write(out);
			System.out.println("XLSX File created: " + myOut.getName());
			out.close();
			workbook.close();
			//Inspirtation/Much credit to https://howtodoinjava.com/library/readingwriting-excel-files-in-java-poi-tutorial/#writing_excel_file
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
