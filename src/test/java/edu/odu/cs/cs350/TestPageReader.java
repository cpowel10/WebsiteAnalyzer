package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import edu.odu.cs.cs350.Enum.TagType;

import static org.hamcrest.CoreMatchers.*;

public class TestPageReader {

	PageReader pgReader = new PageReader();
	String pathStr1 = "C:\\Users\\chris\\Desktop\\SampleHTML\\page1.html";
	Path path1 = Paths.get(pathStr1);
	HTMLDocument page1expected = new HTMLDocument(path1);
	HTMLDocument page1actual = new HTMLDocument(path1);
	
	@Before
	public void setup() {
		//set up HTMLDocument(s) to have lists filled
		//with images, anchors, scripts, and styles
		LinkedList<Path> paths = new LinkedList<Path>();
		LinkedList<Path> imgPaths = new LinkedList<Path>();
		paths.add(path1);
		imgPaths.add(Paths.get("C:\\Users\\chris\\Desktop\\SampleHTML\\Images\\Image1.jpg"));
		Image img1 = new Image(TagType.IMAGE, 240698, imgPaths, 1, paths); //235 KB (240,698 bytes)
		page1expected.addElement(img1);
	}
	
	@Test
	public void testPageReaderOnlyImages() throws IOException {
		LinkedList<Image> images = pgReader.scanForImages(page1actual);
		LinkedList<Style> styles = pgReader.scanForStyles(page1actual);
		LinkedList<Script> scripts = pgReader.scanForScripts(page1actual);
		LinkedList<Anchor> anchors = pgReader.scanForAnchors(page1actual);
		System.out.println(page1expected.getImages().get(0).size() + " bytes : " + page1expected.getImages().get(0).listings().toString());
		System.out.println(images.get(0).size() + " bytes : " + images.get(0).listings().toString());
		assertTrue(page1actual.getImages().get(0).equals(page1expected.getImages().get(0)));
	}
}
