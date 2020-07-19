package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PageReader {
	/*
	 * 
	 */
	  public LinkedList<Image> scanForImages(HTMLDocument page) throws IOException{
		  //get Path of HTMLDocument
		  Path path = page.getPath();
		  //use jsoup library to find image tags
		  File pathFile = path.toFile();
		  Document doc = Jsoup.parse(pathFile, "UTF-8");
		  //String in select() will be a String to identify 
		  //what the method will search for and add to the Elements(list)
		  Elements images = doc.select("");
		  //add each image found in File to LinkedList<Image> in given HTMLDocument Object
		  
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
