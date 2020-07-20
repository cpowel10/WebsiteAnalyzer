package edu.odu.cs.cs350;

import org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
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
	Tag myTag = new Tag(pth, typ, ext);
	
	
	@Test
	public final void testDefaultConstructor(){
	assertThat(firstTag.path(), is(""));
	assertThat(firstTag.type(), is(TagType.STYLE));
	assertThat(firstTag.externality(), is(Externality.EXTERNAL));
	}
		
	@Test
	public final void testNonDefaultContructor(){
	assertThat(myTag.path(), is(pth));
	assertThat(myTag.type(), is(typ));
	assertThat(myTag.externality(), is(ext));
	}
		
	@Test
	public final void testSetPath(){
	Path newPath = Paths.get("my/new/testing/path");
	myTag.setPath(newPath);
	assertThat(myTag.path(), is(newPath));
	assertThat(myTag.type(), is(typ));
	assertThat(myTag.externality(), is(ext));
	}
		
	@Test
	public final void testSetType(){
	TagType newType = TagType.SCRIPT;
	myTag.setType(newType);
	assertThat(myTag.path(), is(pth));
	assertThat(myTag.type(), is(newType));
	assertThat(myTag.externality(), is(ext));	
	}
	
		
	@Test
	public final void testExternality(){
	Externality newExt = Externality.INTERNAL;
	myTag.setExternality(newExt);
	assertThat(myTag.path(), is(pth));
	assertThat(myTag.type(), is(typ));
	assertThat(myTag.externality(), is(newExt));
	}
}
