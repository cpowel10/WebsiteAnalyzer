package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;
import java.nio.file.Path;
import java.util.LinkedList;
import java.net.URI;

public class Style extends Tag {
	private LinkedList<Path> listings;
	/**
	 * default constructor
	 */
	public Style() {
		super(TagType.STYLE);
		listings = new LinkedList<Path>();
	}
	/**
	 * nondefault constructor
	 * @param myPath contains path to Style Tag
	 * @param myEality contains externality of style tag (internal, intrapage, external)
	 * @param myUri contains URI of style tag
	 */
	public Style(Path myPath, Externality myEality, URI myUri) {
		super(TagType.STYLE, myPath, myEality, myUri);
		listings = new LinkedList<Path>();
	}
	/**
	 * second nondefault constructor
	 * @param myPath contains path to style tag
	 * @param myEality contains externality of style tag (internal, ...)
	 * @param firstListing contains path to be added to collection of listings
	 * @param myUri contains URI of style tag
	 */
	public Style(Path myPath, Externality myEality, Path firstListing, URI myUri) {
		super(TagType.STYLE, myPath, myEality, myUri);
		listings = new LinkedList<Path>();
		listings.add(firstListing);
	}
	/**
	 * adds a path to the collection(linked list) of paths to this style
	 * @param Path to this style
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
