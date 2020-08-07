package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

import java.nio.file.Path;
import java.util.LinkedList;

import java.net.URI;

public class Script extends Tag {
	private LinkedList<Path> listings;
	/**
	 * default constructor
	 */
	public Script() {
		super(TagType.SCRIPT);
		listings = new LinkedList<Path>();
	}
	/**
	 * nondefault constructor
	 * @param myPath contains path to script tag
	 * @param myEality contains externality of script tag
	 * @param myUri contains URI to script tag
 	 */
	public Script(Path myPath, Externality myEality, URI myUri) {
		super(TagType.SCRIPT, myPath, myEality, myUri);
		listings = new LinkedList<Path>();
	}
	/**
	 * second nondefault constructor
	 * @param myPath contains path to script tag
	 * @param myEality contains externality of script tag
	 * @param firstListing contains path to be added to listings collection
	 * @param myUri contains URI to script tag
 	 */
	public Script(Path myPath, Externality myEality, Path firstListing, URI myUri) {
		super(TagType.SCRIPT, myPath, myEality, myUri);
		listings = new LinkedList<Path>();
		listings.add(firstListing);
	}
	/**
	 * adds path to collection of paths leading to script tag
	 * @param listing contains path to be added
	 */
	public void addListing(Path listing) {
		listings.add(listing);
	}
	/**
	 * returns listings
	 */
	public LinkedList<Path> getListings(){
		return this.listings;
	}
}
