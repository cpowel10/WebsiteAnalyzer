package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

import java.nio.file.Path;
import java.util.LinkedList;

import java.net.URI;

public class Style extends Tag {
	private LinkedList<Path> listings;
	
	public Style() {
		super(TagType.STYLE);
		listings = new LinkedList<Path>();
	}
	
	public Style(Path myPath, Externality myEality, URI myUri) {
		super(TagType.STYLE, myPath, myEality, myUri);
		listings = new LinkedList<Path>();
	}

	public Style(Path myPath, Externality myEality, Path firstListing, URI myUri) {
		super(TagType.STYLE, myPath, myEality, myUri);
		listings = new LinkedList<Path>();
		listings.add(firstListing);
	}

	public void addListing(Path listing) {
		listings.add(listing);
	}
}
