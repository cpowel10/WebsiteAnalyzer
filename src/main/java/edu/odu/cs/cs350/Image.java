package edu.odu.cs.cs350;

import java.util.LinkedList;
import java.nio.file.Paths;
import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.TagType;

public class Image extends Tag {
	private TagType type = TagType.IMAGE;
	private int size;
	private LinkedList<Path> listings;
	private int numPages;
	private LinkedList<Path> pagesOn;
	
	public Image() {
		// TODO Auto-generated constructor stub
	}
	public Image(TagType myType, int mySize, LinkedList<Path> myListings, int myNumPages, LinkedList<Path> myPagesOn) {
		//TODO
	}
	public TagType type() {
		//TODO
		return TagType.ANCHOR;
	}
	public int size() {
		//TODO
		return -1;
	}
	public LinkedList<Path> listings() {
		//TODO
		 LinkedList<Path> emptyList = new LinkedList<Path>();
		 return emptyList;
	}
	public int numPages() {
		//TODO
		return -1;
	}
	public LinkedList<Path> pagesOn() {
		//TODO		
		 LinkedList<Path> emptyList = new LinkedList<Path>();
		 return emptyList;	
		 }
	public TagType setType(TagType myType) {
		//TODO
		return TagType.ANCHOR;
	}
	public int setSize(int mySize) {
		//TODO
		return -1;
	}
	public LinkedList<Path> setListings(LinkedList<Path> list) {
		//TODO
		 LinkedList<Path> emptyList = new LinkedList<Path>();
		 return emptyList;
	}
	public int setNumPages(int numberOfPages) {
		//TODO
		return -1;
	}
	public LinkedList<Path> setPagesOn(LinkedList<Path> list) {
		//TODO		
		 LinkedList<Path> emptyList = new LinkedList<Path>();
		 return emptyList;	}
}
