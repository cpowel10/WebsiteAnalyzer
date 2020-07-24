package edu.odu.cs.cs350;

import java.util.LinkedList;
import java.nio.file.Paths;
import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class Image extends Tag 	implements Comparable<Image> {
	
	private TagType type = TagType.IMAGE;
	private long size;
	private LinkedList<Path> listings;
	private int numPages;
	private LinkedList<Path> pagesOn;
	
	public Image() {
		super(Paths.get("lol"), TagType.IMAGE, Externality.INTERNAL);
		this.setSize(0);
		listings = new LinkedList<Path>();
		this.setNumPages(0);
		pagesOn = new LinkedList<Path>();

	}

	public Image(Path myPath, long mySize, Path firstListing, Externality myExternality) {
		super(myPath, TagType.IMAGE, myExternality);
		size = mySize;
		listings = new LinkedList<Path>();
		listings.add(firstListing);
	}

	public Image(long mySize, LinkedList<Path> myListings, int myNumPages, LinkedList<Path> myPagesOn) {
		this.setType(TagType.IMAGE);
		this.setSize(mySize);
		this.setListings(myListings);
		this.setNumPages(myNumPages);
		this.setPagesOn(myPagesOn);
	}
	public TagType type() {
		return this.type;
	}
	public long size() {
		return this.size;
	}
	public LinkedList<Path> listings() {
		 return this.listings;
	}
	public int numPages() {
		return this.numPages;
	}
	public LinkedList<Path> pagesOn() {
		 return this.pagesOn;	
	}
	public void setType(TagType myType) {
		this.type = myType;
	}
	public void setSize(long mySize) {
		this.size = mySize;
	}
	public void addListing(Path listing) {
		listings.add(listing);
	}
	public void incrementListings() {
		numPages++;
	}
	public void setListings(LinkedList<Path> myListings) {
		listings = myListings;
	}
	public void setNumPages(int num) {
		numPages = num;
	}
	public void setPagesOn(LinkedList<Path> list) {
		this.pagesOn = list;
	}
		
	//New comparison logic 
	@Override
	public int compareTo(Image img) {
		
		String lhsPath = (this.path()).toString();
		String rhsPath = (img.path()).toString(); 
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
