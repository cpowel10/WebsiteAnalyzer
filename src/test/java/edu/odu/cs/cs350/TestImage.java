/**
 * 
 */
package edu.odu.cs.cs350;

//import org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.LinkedList;
import java.nio.file.Paths;
import java.nio.file.Path;
//import org.junit.Before;
//import org.hamcrest.core.IsNull;
import org.junit.Test;
//import org.junit.FixMethodOrder;
//import org.junit.runners.MethodSorters;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
import java.net.URI;

//import java.util.stream.Stream;

//import javax.print.attribute.URISyntax;

//import static java.util.stream.Collectors.toList;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

/**
 * @author kyle
 *
 */
public class TestImage {
 
	Image firstImage = new Image();		
	LinkedList<Path> emptyList = new LinkedList<Path>();
	TagType myType = TagType.IMAGE;
	
	@Test
	public final void testDefaultConstructor() {	
		assertThat(firstImage.getType(), is(TagType.IMAGE));
		assertThat(firstImage.getSize(), is(0));
		assertThat(firstImage.getListings(), is(emptyList));
		assertThat(firstImage.numPages(), is(0));
	}
	
	@Test
	public final void testNonDefaultConstructor() {
		//Set up
		TagType myType = TagType.IMAGE;
		long mySize = 2;
		LinkedList<Path> myListings = new LinkedList<Path>();
		myListings.add(Paths.get("fakePath3"));
		URI myUri = URI.create("fakeURI");

		//Change
		Image secondImage = new Image(Paths.get("fakePath0"), mySize, Paths.get("fakePath1"), Externality.EXTERNAL, myUri);
		
		//Check changes
		assertThat(secondImage.getType(), is(myType));
		assertThat(secondImage.getSize(), is(mySize));
		assertThat(secondImage.getPath(), is(Paths.get("fakePath0")));
		assertThat(secondImage.getExternality(), is(Externality.EXTERNAL));
		assertThat(secondImage.getUri(), is(myUri));
		assertThat(secondImage.getListings(), is(myListings));
		assertThat(secondImage.numPages(), is(1));	
	}
	@Test
	public final void testSetSize() {
		//Set up
		long mySize = 8;
		
		//Change
		firstImage.setSize(mySize);
		
		//Change has been made
		assertThat(firstImage.getSize(), is(mySize));		
		
		//No other changes
		assertThat(firstImage.getType(), is(myType));
		assertThat(firstImage.getListings(), is(emptyList));
		assertThat(firstImage.numPages(), is(0));
	}
	
	@Test
	public final void testSetNumPages() {
		//Set up
		int mySize = 8;
		
		//Change
		firstImage.setNumPages(mySize);
		
		//Change has been made
		assertThat(firstImage.numPages(), is(mySize));		
		
		//No other changes
		assertThat(firstImage.getType(), is(myType));
		assertThat(firstImage.getListings(), is(emptyList));
		assertThat(firstImage.getSize(), is(0));
	}
	@Test
	public final void testAddListing() {
		//Set up
		Path path = Paths.get("testPath");		
		LinkedList<Path> list = new LinkedList<Path>();
		list.add(path);
		
		//Change
		firstImage.addListing(path);
		
		//Change has been made
		assertThat(firstImage.getListings(), is(list));		
		assertThat(firstImage.numPages(), is(1));
		
		//No other changes
		assertThat(firstImage.getType(), is(myType));
		assertThat(firstImage.getSize(), is(0));
	}
}
