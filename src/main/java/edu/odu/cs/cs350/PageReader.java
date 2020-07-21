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
	  public LinkedList<Image> scanForImages(HTMLDocument page) throws IOException{
		  //get Path of HTMLDocument
		  Path path = page.getPath();
		  LinkedList<Path> pathList = new LinkedList<Path>();
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
			double fileSize = imgFile.length();
			tempImage.setSize((int) fileSize);
			//set the path to image Path list
			Path imgPath = Paths.get(i.attr("src"));
			LinkedList<Path> imgPaths = new LinkedList<Path>();
			imgPaths.add(imgPath);
			tempImage.setPagesOn(pathList);
			tempImage.setListings(imgPaths);
			tempImage.setNumPages(1);
			page.addElement(tempImage);
		  }
		  //return updated LinkedList of Images from given page
		  return page.getImages();
		  
	  }
	  
	  /*
	   * 
	   */
	  public LinkedList<Style> scanForStyles(HTMLDocument page){
		  return null;
		  
	  }
	  
	  /*
	   * 
	   */
	  public LinkedList<Script> scanForScripts(HTMLDocument page){
		  return null;
		  
	  }
	  
	  /*
	   * 
	   */
	  public LinkedList<Anchor> scanForAnchors(HTMLDocument page){
		  return null;
		  
	  }

}
