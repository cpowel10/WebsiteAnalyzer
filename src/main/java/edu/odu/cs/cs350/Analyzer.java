package edu.odu.cs.cs350;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

import edu.odu.cs.cs350.Enum.Externality;

import java.util.Iterator;

public class Analyzer {
	private Website site = new Website();
	private PathManager pathManager = new PathManager();

	private LinkedList<Image> analyzedImages = new LinkedList<Image>();
	private LinkedList<Style> analyzedStyles = new LinkedList<Style>();
	private LinkedList<Script> analyzedScripts = new LinkedList<Script>();
	private LinkedList<Anchor> analyzedAnchors = new LinkedList<Anchor>();

	public Analyzer(Website mysite) {
		site = mysite;
	}
	
	/** 
	 * Iterates over site's pages and performs the relevant analysis on each individual
	 * type of tag that we care about
	 * @throws IOException 
	 */
	public void analyzeWebsite() throws IOException {
		for(HTMLDocument page : site.getPages()) {

			analyzePageScripts(page);
			analzyePageStyles(page);
			analyzeImages(page);
			analyzePageAnchors(page);
			
			//Call the page to count and set its external/internal/intra counters
	 		//for each of the tag types
			page.setAnchorTypeCounters();
			page.setImageTypeCounters();
			page.setStyleTypeCounters();
			page.setScriptTypeCounters();
		}
	}

	/**
	 * Iterates over the page's script tags and analyzes them.
	 * @param Page to analyze
	 */
	public void analyzePageScripts(HTMLDocument page) {
		Script scrToAdd;
		int index;
		for(Script script : page.getScripts()) {
			index = analyzedScripts.indexOf(script);
			//if script hasn't been analyzed, add unique entry to analyzedScripts
			if(index==-1) {
				scrToAdd = script;
				scrToAdd.addListing(page.getPath());
				analyzedScripts.add(scrToAdd);
			}
			//otherwise add this page's path to the scripts' listings
			else {
				analyzedScripts.get(index).addListing(page.getPath());
			}
		}
	}

	/**
	 * Iterates over the page's Anchor tags and analyzes them.
	 * @param Page to analyze
	 */
	public void analyzePageAnchors(HTMLDocument page) {
		Path expanded;
		for(Anchor link : page.getAnchors()) {
			expanded = pathManager.expandPath(link.getPath(), page.getPath());
			if(expanded.equals(page.getPath())) {
				link.setExternality(Externality.INTRA);
			}
		}
	}

	/**
	 * Iterates over the page's style tags and analyzes them.
	 * @param Page to analyze
	 */
	public void analzyePageStyles(HTMLDocument page) {
		Style styToAdd;
		int index;
		for(Style style : page.getStyles()) {
			index = analyzedStyles.indexOf(style);
			//if style hasn't been analyzed, add unique entry to analyzedStyles
			if(index==-1) {
				styToAdd = style;
				styToAdd.addListing(page.getPath());
				analyzedStyles.add(styToAdd);
			}
			//otherwise add this page's path to the styles' listings
			else {
				analyzedStyles.get(index).addListing(page.getPath());
			}
		}
	}

	/**
	 * Iterates over the page's image tags and analyzes them.
	 * @pre Page to analyze
	 */
	public void analyzeImages(HTMLDocument page) throws IOException {
		Image imgToAdd;
		long pageTotalImageSize = 0;

		int index;
		Iterator<Image> imgIt = page.getImages().iterator();
		Image tempImage;
		//iterate over the pages' images
		while(imgIt.hasNext())
		{
			tempImage = imgIt.next();

			index = analyzedImages.indexOf(tempImage);
			//if image hasn't been analyzed yet, make a new one for analyzedImages
			//with this page as its first listing
			if(index==-1) {
				//Keep track of size if internal image
				if(tempImage.getExternality() == Externality.INTERNAL) {
					imgToAdd = new Image(tempImage.getPath(), 
										Files.size(tempImage.getPath()),
										page.getPath(), Externality.INTERNAL, null/*URI.create(page.getPath().toString())*/); //likely a better way
				}
				else {
					imgToAdd = new Image(tempImage.getPath(), 0,
										page.getPath(), Externality.EXTERNAL, URI.create(page.getPath().toString())); //likely a better way
				}
				analyzedImages.add(imgToAdd);
			}
			//otherwise ++ the images' listing count and add this page's path to listings
			else {
				analyzedImages.get(index).addListing(page.getPath());
			}
			//Tally the size of internal images
			if(tempImage.getExternality() == Externality.INTERNAL)
				pageTotalImageSize += Files.size(tempImage.getPath());
		}
		//assign total image size to the page and reset tally
		page.setTotalImageSize(pageTotalImageSize);
		pageTotalImageSize = 0;
	}
	/**
     * @return this analyzer's website
     */
	public Website getWebsite() {
		return site;
	}
}
