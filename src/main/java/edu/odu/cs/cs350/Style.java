package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

import java.nio.file.Path;
import java.util.LinkedList;

public class Style extends Tag {
	private LinkedList<Path> listings;
	
	public Style() {
		super(TagType.STYLE);
		listings = new LinkedList<Path>();
	}
	
	public Style(Path myPath, Externality myEality) {
		super(TagType.STYLE, myPath, myEality);
		listings = new LinkedList<Path>();
	}

	public Style(Path myPath, Externality myEality, Path firstListing) {
		super(TagType.STYLE, myPath, myEality);
		listings = new LinkedList<Path>();
		listings.add(firstListing);
	}

	public void addListing(Path listing) {
		listings.add(listing);
	}
}
