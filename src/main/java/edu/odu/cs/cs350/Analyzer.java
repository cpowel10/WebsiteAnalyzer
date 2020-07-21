package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.LinkedList;

public class Analyzer {
	  private Website site = new Website();
	  private LinkedList<Image> analyzedImages = new LinkedList<Image>();
	  private LinkedList<Style> analyzedStyles = new LinkedList<Style>();
	  private LinkedList<Script> analyzedScripts = new LinkedList<Script>();
	  private LinkedList<Anchor> analyzedAnchors = new LinkedList<Anchor>();
	  
	  public void analyzerMain(LinkedList<Path> paths) {
		  //Call analyzeImages(Path) for each path in paths
		  
		  //Call analyzeStyles(Path) for each path in paths
		  
		  //Call analyzeScripts(Path) for each path in paths
		  
		  //Call analyzeAnchors(Path) for each path in paths
		  
		  //Create HTMLDocument for each path and add all four lists 
		  
		  //add HTMLDocuments to Website
	  }
	  
	  /*
	   * 
	   */
	  public void analyzeImages(Path path) {
		  //Call scanForImages(Path) for the given path
		  //which returns a list of images found on that path
		  
		  //add all images in the recieved list to analyzedImages
		  
	  }
	  
	  /*
	   * 
	   */
	  public void analyzeStyles(Path path) {
		  
	  }
	  
	  /*
	   * 
	   */
	  public void analyzeScripts(Path path) {
		  
	  }
	  
	  /*
	   * 
	   */
	  public void analyzeAnchors(Path path) {
		  
	  }
	  
	  /*
	   * Get toal size of all images in a path
	   * @param LinkedList of HTMLDocuments, pages
	   * @return sum of all totalImageSize variables in list of HTMLDocuments
	   */
	  public int pageImageSize(LinkedList<HTMLDocument> pages) {
		  return -1;
	  }

}
