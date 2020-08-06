package edu.odu.cs.cs350;

//import org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
//import java.util.LinkedList;
import java.nio.file.Paths;
import java.net.URI;
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

//import java.util.stream.Stream;
//import static java.util.stream.Collectors.toList;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

/**
 * @author kyle
 *
 */
public class TestTag {
 
/*
	private Path path;
	private TagType type;
	private Externality externality;
 *	
 */
	//@Before
	//public void setUp() { 
	Tag firstTag = new Tag();		
	Path pth = Paths.get("my/original/testing/path");
	TagType typ = TagType.ANCHOR;
	Externality ext = Externality.INTRA;
	URI myUri = URI.create("fakeURI");
	Tag myTag = new Tag(typ, pth, ext, myUri);
	
	//path = Paths.get("");
	//type = TagType.UNDEFINED; 
	//eality = Externality.UNDEFINED;

	@Test
	public final void testDefaultConstructor(){
		assertThat(firstTag.getPath(), is(Paths.get("")));
		assertThat(firstTag.getType(), is(TagType.UNDEFINED));
		assertThat(firstTag.getExternality(), is(Externality.UNDEFINED));
	}
		
	@Test
	public final void testNonDefaultContructorTagType(){
		TagType tagTyp = TagType.IMAGE;
		Tag tag  = new Tag(tagTyp);
		assertThat(tag.getPath(), is(Paths.get("")));
		assertThat(tag.getType(), is(tagTyp));
		assertThat(tag.getExternality(), is(Externality.UNDEFINED));
	}

	@Test
	public final void testNonDefaultContructor(){
		assertThat(myTag.getPath(), is(pth));
		assertThat(myTag.getType(), is(typ));
		assertThat(myTag.getExternality(), is(ext));
		assertThat(myTag.getUri(), is(myUri));
	}

	@Test
	public final void testNonDefaultContructorURI(){
		URI uri = URI.create("testURI");
		Tag tag  = new Tag(uri);
		assertThat(tag.getPath(), is(Paths.get("")));
		assertThat(tag.getType(), is(TagType.UNDEFINED));
		assertThat(tag.getExternality(), is(Externality.UNDEFINED));
		assertThat(tag.getUri(), is(uri));
	}
	
		
	@Test
	public final void testSetPath(){
		//set up
		Path newPath = Paths.get("my/new/testing/path");
		//change
		myTag.setPath(newPath);
		//check change
		assertThat(myTag.getPath(), is(newPath));
		//no other change
		assertThat(myTag.getType(), is(typ));
		assertThat(myTag.getExternality(), is(ext));
		assertThat(myTag.getUri(), is(myUri));
	}
		
	@Test
	public final void testSetType(){
		//set up
		TagType newType = TagType.SCRIPT;
		//change
		myTag.setType(newType);
		//check change
		assertThat(myTag.getType(), is(newType));
		//no other change
		assertThat(myTag.getPath(), is(pth));
		assertThat(myTag.getExternality(), is(ext));	
		assertThat(myTag.getUri(), is(myUri));
	}
		
	@Test
	public final void testExternality(){
		//set up
		Externality newExt = Externality.INTERNAL;
		//change
		myTag.setExternality(newExt);
		//check change
		assertThat(myTag.getExternality(), is(newExt));
		//no other change
		assertThat(myTag.getPath(), is(pth));
		assertThat(myTag.getType(), is(typ));
		assertThat(myTag.getUri(), is(myUri));
	}
}
