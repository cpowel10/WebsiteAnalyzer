package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.odu.cs.cs350.Enum.TagType;

public class PageReader {
	/*
	 * 
	 */
	  public LinkedList<Image> scanForImages(Path path) throws IOException{
		  //get Path of HTMLDocument
		  LinkedList<Path> pathList = new LinkedList<Path>();
		  LinkedList<Image> imgList = new LinkedList<Image>();
		  pathList.add(path);
		  //use jsoup library to find image tags
		  File pathFile = path.toFile();
		  Document doc = Jsoup.parse(pathFile, "UTF-8");
		  //String in select() will be a String to identify 
		  //what the method will search for and add to the Elements(list)
		  Elements images = doc.getElementsByTag("img");
		  //add each image found in File to LinkedList<Image> in given HTMLDocument Object
		  for (Element i : images) {
			Image tempImage = new Image();
			//find size of Image
			File imgFile = new File(i.attr("src"));
			long fileSize = imgFile.length();
			//need to convert fileSize from bytes to MiB
			long fileSizeMiB = (long) (fileSize * 9.53674e-7);
			tempImage.setSize(fileSizeMiB);
			//set the path to image Path list
			Path imgPath = Paths.get(i.attr("src"));
			LinkedList<Path> imgPaths = new LinkedList<Path>();
			imgPaths.add(imgPath);
			tempImage.setPagesOn(pathList);
			tempImage.setListings(imgPaths);
			tempImage.setNumPages(1);
			imgList.add(tempImage);
		  }
		  //return updated LinkedList of Images from given page
		  return imgList;
		  
	  }
	  
	  /*
	   * 
	   */
	  public LinkedList<Style> scanForStyles(Path path){
		  return null;
		  
	  }
	  
	  /*
	   * 
	   */
	  public LinkedList<Script> scanForScripts(Path path){
		  return null;
		  
	  }
	  
	  /*
	   * 
	   */
	  public LinkedList<Anchor> scanForAnchors(Path path){
		  return null;
		  
	  }

}
