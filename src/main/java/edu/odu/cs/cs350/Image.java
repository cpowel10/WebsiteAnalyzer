package edu.odu.cs.cs350;

import java.util.LinkedList;
import java.nio.file.Paths;
import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class Image extends Tag {
	private TagType type = TagType.IMAGE;
	private long size;
	private LinkedList<Path> listings;
	private int numPages;
	private LinkedList<Path> pagesOn;
	
	public Image() {
		this.setType(TagType.IMAGE);
		this.setSize(0);
		LinkedList<Path> emptyList = new LinkedList<Path>();
		this.setListings(emptyList);
		this.setNumPages(0);
		this.setPagesOn(emptyList);
	}

	public Image(Path myPath, long mySize, Path firstListing, Externality myExternality) {
		super(myPath, TagType.IMAGE, myExternality);
		size = mySize;
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
	public void setListings(LinkedList<Path> list) {
		this.listings = list;
	}
	public void incrementListings() {
		numPages++;
	}
	public void setPagesOn(LinkedList<Path> list) {
		this.pagesOn = list;
	}
}
