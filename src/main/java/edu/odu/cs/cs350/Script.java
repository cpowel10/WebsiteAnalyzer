package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

import java.nio.file.Path;
import java.util.LinkedList;

import java.net.URI;

import edu.odu.cs.cs350.Enum.*;

public class Script extends Tag {
	private LinkedList<Path> listings;
	
	public Script() {
		super(TagType.SCRIPT);
		listings = new LinkedList<Path>();
	}
	
	public Script(Path myPath, Externality myEality, URI myUri) {
		super(TagType.SCRIPT, myPath, myEality, myUri);
		listings = new LinkedList<Path>();
	}

	public Script(Path myPath, Externality myEality, Path firstListing, URI myUri) {
		super(TagType.SCRIPT, myPath, myEality, myUri);
		listings = new LinkedList<Path>();
		listings.add(firstListing);
	}

	public void addListing(Path listing) {
		listings.add(listing);
	}
}
