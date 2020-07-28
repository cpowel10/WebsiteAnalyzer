package edu.odu.cs.cs350;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

import javax.swing.text.html.HTML;

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
	
	public void analyzeWebsite(LinkedList<Path> paths) {
		HTMLDocument tempPage;
		Iterator<HTMLDocument> pageIt = site.allPages.iterator();

		site.readPages();

		//Iterate over all pages
		while(pageIt.hasNext()) {
			tempPage = pageIt.next();

			//to edit below to analyzePageImages(tempPage) to work;
			analyzePageScripts(tempPage);
			//analzyePageStyles(tempPage);
			//analyzePageAnchors(tempPage);
		}
	}

	public void analyzePageScripts(HTMLDocument page) {
		Script script;
		Script scrToAdd;
		int index;
		Iterator<Script> scriptIt = page.getScripts().iterator();
		while(scriptIt.hasNext()) {
			script = scriptIt.next();
			index = analyzedScripts.indexOf(script);

			if(index==-1) {
				scrToAdd = script;
				scrToAdd.addListing(page.getPath());
				analyzedScripts.add(scrToAdd);
			}
			else
				analyzedScripts.get(index).addListing(page.getPath());
		}
	}
	
	public void analyzeImages() throws IOException {
		HTMLDocument tempPage;

		Image tempImage;
		Image imgToAdd;

		long imgToAddSize;
		long pageImageSize = 0;

		Iterator<HTMLDocument> pageIt = site.allPages.iterator();
		Iterator<Image> imgIt;

		Path imgToAddPath;
		Path imgToAddListing;
		
		//Iterate over all pages
		while(pageIt.hasNext())
		{
			tempPage = pageIt.next();
			
			//iterator for traversal of all images of a page
			imgIt = tempPage.getImages().iterator();
			
			//Iterate over all images of a page
			while(imgIt.hasNext())
			{
				tempImage = imgIt.next();
				
				//Save the index
				int imgIndex = analyzedImages.indexOf(tempImage);
				
				//When index is -1, it has not been analyzed before, 
				//so we assign the data to variables then create an image, 
				//then finally add it to the collection of analyzed images. 
				if(imgIndex==-1) {
					
					//variables are functionally unnecessary but help readability
					imgToAddPath = tempImage.getPath();
					imgToAddListing = tempPage.getPath();
					
					//Internal image procedure
					if(tempImage.getExternality() == Externality.INTERNAL) {
						imgToAddSize = Files.size(tempImage.getPath());
						imgToAdd = generateInternalImage(imgToAddPath, 
								imgToAddSize, imgToAddListing);
					}
					//ExternalImage procedure
					else {
						imgToAdd = generateExternalImage(imgToAddPath, imgToAddListing);
					}
					//add image to list of analyzed images
					analyzedImages.add(imgToAdd);
				}
				//Image has been analyzed before so we note it is another occurrence 
				//by incrementing the listing count and add its path to the collection 
				//of paths that reference it
				else {
					analyzedImages.get(imgIndex).incrementListings();
					analyzedImages.get(imgIndex).addListing(tempPage.getPath());
				}
				//Increase total pageImageSize accordingly
				if(tempImage.getExternality() == Externality.INTERNAL)
					pageImageSize += Files.size(tempImage.getPath());
			}
			//assign the correct/new total image size to the page
			tempPage.setTotalImageSize(pageImageSize);
			
			//start fresh for next pass
			pageImageSize = 0;
		}
	}

	public Image generateInternalImage(Path myPath, long imgSize, Path firstListing) {
		return new Image(myPath, imgSize, firstListing, Externality.INTERNAL);
	}

	public Image generateExternalImage(Path myPath, Path firstListing) {
		return new Image(myPath, -1, firstListing, Externality.EXTERNAL);
	}
	
	public void analyzePageAnchors(HTMLDocument page) {
		//Call scanForAnchors(Path) for the given path
		//which returns a list of anchors found on that path
		//add all anchors in the recieved list to analyzedAnchors
	}

	

	public Website getWebsite() {
		return site;
	}
}
