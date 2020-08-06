package edu.odu.cs.cs350;

import java.util.LinkedList;
//import java.nio.file.Paths;
import java.nio.file.Path;

import java.net.URI;

import edu.odu.cs.cs350.Enum.*;

public class Image extends Tag 	implements Comparable<Image> {
	private long size;
	private int numPages;
	private LinkedList<Path> listings;
	/*
	 * default constructor
	 */
	public Image() {
		super(TagType.IMAGE);
		size = 0;
		listings = new LinkedList<Path>();
		this.setNumPages(0);
	}
	/*
	 * nondefault constructor
	 * @param myPath contains a path to the image
	 * @param mySize contains a long of the image size
	 * @param firstListing contains path image was first listed on
	 * @param myExternality contains externality (internal, intrapage, external)
	 * @param myUri contains URI to image
	 */
	public Image(Path myPath, long mySize, Path firstListing, Externality myExternality, URI myUri) {
		super(TagType.IMAGE, myPath, myExternality, myUri);
		size = mySize;
		listings = new LinkedList<Path>();
		this.setNumPages(0);
		this.addListing(firstListing);
	}
	/*
	 * returns the image size
	 */
	public long getSize() {
		return this.size;
	}
	/*
	 * returns the linked list of paths that lead to the image
	 */
	public LinkedList<Path> getListings() {
		 return this.listings;
	}
	/*
	 * returns the number of pages the image was on
	 */
	public int numPages() {
		return this.numPages;
	}
	/*
	 * adds a path to the collection of paths leading to the image
	 * @param path to image to be added to listings
	 */
	public void addListing(Path listing) {
		listings.add(listing);
		numPages++;
	}
	/*
	 * set the number of pages image is found on
	 * @param number(integer) to set number of pages to
	 */
	public void setNumPages(int num) {
		numPages = num;
	}
	/*
	 * set the size of the image
	 * @param mySize contains size of image
	 */
	public void setSize(long mySize) {
		size = mySize;
	}
	/*
	 * override comparison operator to compare images
	 * @param image to compare 
	 */
	@Override
	public int compareTo(Image img) {
		String lhsPath = (this.getPath()).toString();
		String rhsPath = (img.getPath()).toString(); 
		int lhsLength = lhsPath.length();
		int rhsLength = rhsPath.length();
		
		//grab a quick max length for iteration/indexing
		int max = 0;
		if(lhsLength > rhsLength)
			max = lhsLength;
		else
			max = rhsLength;
		
		for(int i = 0; i < max; i++) {
			if((int)lhsPath.charAt(i) - (int)rhsPath.charAt(i) > 0)
				return 1; //difference is greater than 0 means lhs is larger(comes later in alphabet)
			else if((int)lhsPath.charAt(i) - (int)rhsPath.charAt(i) < 0)
				return -1; //lhs is smaller
		}
		return 0; //equal 
	}
}
