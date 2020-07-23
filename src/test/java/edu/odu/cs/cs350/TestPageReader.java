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
	LinkedList<Image> expectedImages = new LinkedList<Image>();
	LinkedList<Image> images;
	LinkedList<Script> expectedScripts = new LinkedList<Script>();
	LinkedList<Script> scripts;
	
	@Before
	public void setup() {
		LinkedList<Path> paths = new LinkedList<Path>();
		LinkedList<Path> imgPaths = new LinkedList<Path>();
		paths.add(path1);
		imgPaths.add(Paths.get("C:\\Users\\chris\\Desktop\\SampleHTML\\Images\\Image1.jpg"));
		Image img1 = new Image(240698, imgPaths, 1, paths); //235 KB (240,698 bytes)
		expectedImages.add(img1);
	}
	
	@Test
	public void testPageReaderOnlyImages() throws IOException {
		images = pgReader.scanForImages(path1);
		LinkedList<Style> styles = pgReader.scanForStyles(path1);
		scripts = pgReader.scanForScripts(path1);
		LinkedList<Anchor> anchors = pgReader.scanForAnchors(path1);
		//System.out.println(page1expected.getImages().get(0).size() + " bytes : " + page1expected.getImages().get(0).listings().toString());
		//System.out.println(images.get(0).size() + " bytes : " + images.get(0).listings().toString());
		assertTrue(images.equals(expectedImages));
	}
}
