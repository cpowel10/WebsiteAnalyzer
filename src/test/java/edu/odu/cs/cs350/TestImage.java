/**
 * 
 */
package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.Before;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

import edu.odu.cs.cs350.Enum.TagType;

/**
 * @author kyle
 *
 */
public class TestImage {
 
/*
 * 	private TagType type = TagType.IMAGE;
 *	private int size;
 *	private LinkedList<Path> listings;
 *	private int numPages;
 *	private LinkedList<Path> pagesOn;
 *	
 */
//	@Before
//	public void setUp() {
		Image firstImage = new Image();		
		LinkedList<Path> emptyList = new LinkedList<Path>();
		TagType myType = TagType.IMAGE;


//	}
	
	@Test
	public final void testDefaultConstructor() {		
	/*	assertThat(firstImage.type(), is(TagType.IMAGE));
		assertThat(firstImage.size(), is(0));
		assertThat(firstImage.listings(), is(emptyList));
		assertThat(firstImage.numPages(), is(0));
		assertThat(firstImage.pagesOn(), is(emptyList));
	*/	
		assert(firstImage.type() == myType);
		assert(firstImage.size() == 0);
		assert(firstImage.listings() == emptyList);
		assert(firstImage.numPages() == 0);
		assert(firstImage.pagesOn() == emptyList);
	}
	
	@Test
	public final void testNonDefaultConstructor() {
		//Set up
		TagType myType = TagType.IMAGE;
		int mySize = 2;
		LinkedList<Path> myListings = new LinkedList<Path>();
		int myNumPages = 5;
		LinkedList<Path> myPagesOn = new LinkedList<Path>();
		
		//Change
		Image secondImage = new Image(myType, mySize, myListings, myNumPages, myPagesOn);
		
		//Check changes
/*		assertThat(secondImage.type(), is(myType));
		assertThat(secondImage.size(), is(mySize));
		assertThat(secondImage.listings(), is(myListings));
		assertThat(secondImage.numPages(), is(myNumPages));
		assertThat(secondImage.pagesOn(), is(myPagesOn));
*/
		assert(secondImage.type() == (myType));
		assert(secondImage.size() == (mySize));
		assert(secondImage.listings() == (myListings));
		assert(secondImage.numPages() == (myNumPages));
		assert(secondImage.pagesOn() == (myPagesOn));
	}
	
	@Test
	public final void testSetTagType() {
		//Set up
		TagType myType = TagType.STYLE;
		
		//Change
		firstImage.setType(myType);
		
		//Change has been made
//		assertThat(firstImage.type(), is(myType));
		assert(firstImage.type()  == (myType));

		
		
		//No other changes
/*		assertThat(firstImage.size(), is(0));
		assertThat(firstImage.listings(), is(help));
		assertThat(firstImage.numPages(), is(0));
		assertThat(firstImage.pagesOn(), is(help));	
*/
		assert(firstImage.size() == (0));
		assert(firstImage.listings() == (emptyList));
		assert(firstImage.numPages() == (0));
		assert(firstImage.pagesOn() == (emptyList));	
		}
	
	@Test
	public final void testSetSize() {
		//Set up
		int mySize = 8;
		
		//Change
		firstImage.setSize(mySize);
		
		//Change has been made
//		assertThat(firstImage.size(), is(mySize));
		assert(firstImage.size() == mySize);
		
		
		//No other changes
/*		assertThat(firstImage.type(), is(help));
		assertThat(firstImage.listings(), is(help));
		assertThat(firstImage.numPages(), is(0));
		assertThat(firstImage.pagesOn(), is(help));	
*/
		assert(firstImage.type() == (myType));
		assert(firstImage.listings() == (emptyList));
		assert(firstImage.numPages() == (0));
		assert(firstImage.pagesOn() == (emptyList));	
}
	
	@Test
	public final void testSetListings() {
		//Set up
		LinkedList<Path> myListings = new LinkedList<Path>();
		
		//Change
		firstImage.setListings(myListings);
		
		//Change has been made
//		assertThat(firstImage.listings(), is(myListings));
		assert(firstImage.listings() == myListings);
		
		//No other changes
/*		assertThat(firstImage.type(), is(help));
		assertThat(firstImage.size(), is(myPagesOn));
		assertThat(firstImage.numPages(), is(0));
		assertThat(firstImage.pagesOn(), is(help));		
*/
		assert(firstImage.size() == (0));
		assert(firstImage.listings() == (emptyList));
		assert(firstImage.numPages() == (0));
		assert(firstImage.pagesOn() == (emptyList));	
		}
	
	@Test
	public final void testSetNumPages() {
		//Set up
		int myNumPages = 20;
		
		//Change
		firstImage.setNumPages(myNumPages);
		
		//Change has been made
//		assertThat(firstImage.numPages(), is(myNumPages));
		assert(firstImage.numPages() == (myNumPages));

		
		//No other changes
/*		assertThat(firstImage.type(), is(help));
		assertThat(firstImage.size(), is(myPagesOn));
		assertThat(firstImage.listings(), is(help));
		assertThat(firstImage.pagesOn(), is(help));
*/
		assert(firstImage.size() == (0));
		assert(firstImage.listings() == (emptyList));
		assert(firstImage.numPages() == (0));
		assert(firstImage.pagesOn() == (emptyList));	
		}
	
	@Test
	public final void testSetPagesOn() {
		//Set up
		LinkedList<Path> myPagesOn = new LinkedList<Path>();
		
		//Change
		firstImage.setPagesOn(myPagesOn);
		
		//Change has been made
//		assertThat(firstImage.pagesOn(), is(myPagesOn));
		assert(firstImage.pagesOn() == (myPagesOn));

		
		//No other changes
/*		assertThat(firstImage.type(), is(help));
		assertThat(firstImage.size(), is(myPagesOn));
		assertThat(firstImage.listings(), is(help));
		assertThat(firstImage.numPages(), is(0));
*/
		assert(firstImage.type() == (myType));
		assert(firstImage.size() == (0));
		assert(firstImage.listings() == (emptyList));
		assert(firstImage.numPages() == (0));
		assert(firstImage.pagesOn() == (emptyList));	
		}
}
