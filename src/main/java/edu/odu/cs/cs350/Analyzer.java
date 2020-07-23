package edu.odu.cs.cs350;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

import edu.odu.cs.cs350.Enum.Externality;

import java.util.Iterator;

public class Analyzer {
	private Website site = new Website();
	private LinkedList<Image> analyzedImages = new LinkedList<Image>();
	private LinkedList<Style> analyzedStyles = new LinkedList<Style>();
	private LinkedList<Script> analyzedScripts = new LinkedList<Script>();
	private LinkedList<Anchor> analyzedAnchors = new LinkedList<Anchor>();

	public Analyzer(Website mysite) {
		site = mysite;
	}
	
	public void analyzerMain(LinkedList<Path> paths) {
		//Call analyzeImages(Path) for each path in paths
		
		//Call analyzeStyles(Path) for each path in paths
		
		//Call analyzeScripts(Path) for each path in paths
		
		//Call analyzeAnchors(Path) for each path in paths
		
		//Create HTMLDocument for each path and add all four lists 
		
		//add HTMLDocuments to Website
	}
	
	public void analyzeImages() throws IOException {
		//Call scanForImages(Path) for the given path
		//which returns a list of images found on that path
		HTMLDocument tempPage;
		Image tempImage;
		Image imgToAdd;
		long imgToAddSize;
		long pageImageSize = 0;
		Iterator<HTMLDocument> pageit = site.allPages.iterator();
		Iterator<Image> imgit;
		Path imgToAddPath;
		Path imgToAddListing;
		while(pageit.hasNext())
		{
			tempPage = pageit.next();
			imgit = tempPage.getImages().iterator();
			while(imgit.hasNext())
			{
				tempImage = imgit.next();
				int imgindex;
				imgindex = analyzedImages.indexOf(tempImage);
				if(imgindex==-1) {
					imgToAddPath = tempImage.path();
					imgToAddListing = tempPage.getPath();
					if(tempImage.externality()==Externality.INTERNAL) {
						imgToAddSize = Files.size(tempImage.path());
						imgToAdd = generateInternalImage(imgToAddPath, imgToAddSize, imgToAddListing);
					}
					else {
						imgToAdd = generateExternalImage(tempImage.path(), tempPage.getPath());
					}
					analyzedImages.add(imgToAdd);
				}
				else {
					analyzedImages.get(imgindex).incrementListings();
					analyzedImages.get(imgindex).addListing(tempPage.getPath());
				}
				if(tempImage.externality()==Externality.INTERNAL)
					pageImageSize+=Files.size(tempImage.path());
			}
			tempPage.setTotalImageSize(pageImageSize);
			pageImageSize = 0;
		}
	}

	public Image generateInternalImage(Path myPath, long imgSize, Path firstListing) {
		return new Image(myPath, imgSize, firstListing, Externality.INTERNAL);
	}

	public Image generateExternalImage(Path myPath, Path firstListing) {
		return new Image(myPath, -1, firstListing, Externality.EXTERNAL);
	}
	  
	public void analyzeStyles(Path path) {
	//Call scanForStyles(Path) for the given path
		//which returns a list of stylesheets found on that path
	
		//add all stylesheets in the recieved list to analyzedStyles
	}

	public void analyzeScripts(Path path) {
	//Call scanForScripts(Path) for the given path
	//which returns a list of scripts found on that path
	
	//add all scripts in the recieved list to analyzedScripts
	}
	
	public void analyzeAnchors(Path path) {
		//Call scanForAnchors(Path) for the given path
		//which returns a list of anchors found on that path
		
		//add all anchors in the recieved list to analyzedAnchors
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
