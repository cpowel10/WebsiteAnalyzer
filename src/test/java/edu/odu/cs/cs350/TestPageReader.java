package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

import static org.hamcrest.CoreMatchers.*;

public class TestPageReader {

	PageReader pgReader = new PageReader();
	String pathStr1 = "C:\\Users\\chris\\Desktop\\SampleHTML\\page1.html";
	Path path1 = Paths.get(pathStr1);
	String pathStr2 = "";
	Path path2 = Paths.get(pathStr2);
	String pathStr3 = "";
	Path path3 = Paths.get(pathStr3);
	String pathStr4 = "";
	Path path4 = Paths.get(pathStr4);
	LinkedList<Image> expectedImages = new LinkedList<Image>();
	LinkedList<Image> images;
	LinkedList<Style> expectedStyles = new LinkedList<Style>();
	LinkedList<Style> styles;
	LinkedList<Script> expectedScripts = new LinkedList<Script>();
	LinkedList<Script> scripts;
	LinkedList<Anchor> expectedAnchors = new LinkedList<Anchor>();
	LinkedList<Anchor> anchors;
	
	LinkedList<Path> paths = new LinkedList<Path>();
	LinkedList<Path> imgPaths = new LinkedList<Path>();
	LinkedList<Path> stylePaths = new LinkedList<Path>();
	LinkedList<Path> scriptPaths = new LinkedList<Path>();
	LinkedList<Path> anchorPaths = new LinkedList<Path>();
	
	@Test
	public void testPageReaderImages() throws IOException {
		paths.add(path1);
		imgPaths.add(Paths.get("C:\\Users\\chris\\Desktop\\SampleHTML\\Images\\Image1.jpg"));
		Image img1 = new Image(240698, imgPaths, 1, paths); //235 KB (240,698 bytes)
		expectedImages.add(img1);
		/************************/
		images = pgReader.scanForImages(path1);
		styles = pgReader.scanForStyles(path1);
		scripts = pgReader.scanForScripts(path1);
		anchors = pgReader.scanForAnchors(path1);
		for (int i = 0 ; i < images.size() - 1 ; i++) {
			assertTrue(images.get(i).equals(expectedImages.get(i)));
		}
		for (int i = 0 ; i < styles.size() - 1 ; i++) {
			assertTrue(styles.get(i).equals(expectedStyles.get(i)));
		}
		for (int i = 0 ; i < scripts.size() - 1 ; i++) {
			assertTrue(scripts.get(i).equals(expectedScripts.get(i)));
		}
		for (int i = 0 ; i < anchors.size() - 1 ; i++) {
			assertTrue(anchors.get(i).equals(expectedAnchors.get(i)));
		}
	}
	
//	@Test
//	public void testPageReaderStyles() throws IOException {
//		Path stylePath = Paths.get("");
//		Style style1 = new Style(stylePath,Externality.EXTERNAL);
//		
//		/************************/
//		images = pgReader.scanForImages(path2);
//		styles = pgReader.scanForStyles(path2);
//		scripts = pgReader.scanForScripts(path2);
//		anchors = pgReader.scanForAnchors(path2);
//		assertTrue(images.equals(expectedImages));
//		assertTrue(styles.equals(expectedStyles));
//		assertTrue(scripts.equals(expectedScripts));
//		assertTrue(anchors.equals(expectedAnchors));
//	}
//	
//	@Test
//	public void testPageReaderScripts() throws IOException {
//		Path scriptPath = Paths.get("");
//		Script script1 = new Script(scriptPath,Externality.EXTERNAL);
//		/************************/
//		images = pgReader.scanForImages(path2);
//		styles = pgReader.scanForStyles(path2);
//		scripts = pgReader.scanForScripts(path2);
//		anchors = pgReader.scanForAnchors(path2);
//		assertTrue(images.equals(expectedImages));
//		assertTrue(styles.equals(expectedStyles));
//		assertTrue(scripts.equals(expectedScripts));
//		assertTrue(anchors.equals(expectedAnchors));
//	}
//	
//	@Test
//	public void testPageReaderAnchors() throws IOException {
//		Path anchorPath = Paths.get("");
//		Anchor anchor1 = new Anchor(anchorPath,Externality.EXTERNAL);
//		/************************/
//		images = pgReader.scanForImages(path2);
//		styles = pgReader.scanForStyles(path2);
//		scripts = pgReader.scanForScripts(path2);
//		anchors = pgReader.scanForAnchors(path2);
//		assertTrue(images.equals(expectedImages));
//		assertTrue(styles.equals(expectedStyles));
//		assertTrue(scripts.equals(expectedScripts));
//		assertTrue(anchors.equals(expectedAnchors));
//	}
}
