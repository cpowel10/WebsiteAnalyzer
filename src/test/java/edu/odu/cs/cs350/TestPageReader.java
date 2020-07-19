package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestPageReader {

	PageReader pgReader;
	String pathStr1 = "";
	Path path1 = Paths.get(pathStr1);
	HTMLDocument page1expected = new HTMLDocument(path1);
	HTMLDocument page1actual = new HTMLDocument(path1);
	
	@Before
	public void setup() {
		//set up HTMLDocument(s) to have lists filled
		//with images, anchors, scripts, and styles
	}
	
	@Test
	public void testPageReader1() throws IOException {
		LinkedList<Image> images = pgReader.scanForImages(page1actual);
		LinkedList<Style> styles = pgReader.scanForStyles(page1actual);
		LinkedList<Script> scripts = pgReader.scanForScripts(page1actual);
		LinkedList<Anchor> anchors = pgReader.scanForAnchors(page1actual);
		assertTrue(page1actual.equals(page1expected));
	}
}
