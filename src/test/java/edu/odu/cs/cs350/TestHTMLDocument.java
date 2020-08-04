package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import static org.junit.Assert.assertThat;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.junit.Test;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

import static org.hamcrest.CoreMatchers.*;

public class TestHTMLDocument {

	String fileName = "/c/Users/chris/Downloads/";
	Path path1 = Paths.get(fileName);
	LinkedList<Path> llp = new LinkedList<Path>();
	LinkedList<Path> llp2 = new LinkedList<Path>();
	LinkedList<Image> images = new LinkedList<Image>();
	LinkedList<Script> scripts = new LinkedList<Script>();
	LinkedList<Style> styles = new LinkedList<Style>();
	LinkedList<Anchor> anchors = new LinkedList<Anchor>();
	Path test1 = Paths.get("fake/path");
	Path test2 = Paths.get("fake/path2");

	Image img1 = new Image(test1,1,test2,Externality.INTERNAL,null);
	Image img2 = new Image(test1,2,test2,Externality.EXTERNAL,null);
	Image img3 = new Image(test1,3,test2,Externality.INTERNAL,null);
	Style sty1 = new Style(test1, Externality.INTERNAL,null);
	Style sty2 = new Style(test2, Externality.EXTERNAL,null);
	Script script1 = new Script(test1, Externality.INTRA,null);
	Anchor anch1 = new Anchor(test2, Externality.INTERNAL,null);
	
	HTMLDocument page1 = new HTMLDocument(path1);

	@Test
	public void testConstructorEmpty() {
		assertTrue(page1.getPath().equals(path1));
		assertTrue(page1.getImages().equals(images));
		assertTrue(page1.getStyles().equals(styles));
		assertTrue(page1.getScripts().equals(scripts));
		assertTrue(page1.getAnchors().equals(anchors));
		assertTrue(page1.toString().equals("\\c\\Users\\chris\\Downloads 0 0 0 0 0"));
	}
	
	@Test
	public void testAddImage() {
		page1.addElement(img1);
		images.add(img1);
		assertTrue(page1.getPath().equals(path1));
		assertTrue(page1.getImages().equals(images));
		assertTrue(page1.getStyles().equals(styles));
		assertTrue(page1.getScripts().equals(scripts));
		assertTrue(page1.getAnchors().equals(anchors));
		assertTrue(page1.toString().equals("\\c\\Users\\chris\\Downloads 1 0 0 0 1"));
	}
	
	@Test
	public void testAddScript() {
		page1.addElement(script1);
		scripts.add(script1);
		assertTrue(page1.getPath().equals(path1));
		assertTrue(page1.getImages().equals(images));
		assertTrue(page1.getStyles().equals(styles));
		assertTrue(page1.getScripts().equals(scripts));
		assertTrue(page1.getAnchors().equals(anchors));
		assertTrue(page1.toString().equals("\\c\\Users\\chris\\Downloads 0 0 1 0 0"));
	}
	
	@Test
	public void testAddStyle() {
		page1.addElement(sty1);
		styles.add(sty1);
		assertTrue(page1.getPath().equals(path1));
		assertTrue(page1.getImages().equals(images));
		assertTrue(page1.getStyles().equals(styles));
		assertTrue(page1.getScripts().equals(scripts));
		assertTrue(page1.getAnchors().equals(anchors));
		assertTrue(page1.toString().equals("\\c\\Users\\chris\\Downloads 0 1 0 0 0"));
	}

	@Test
	public void testAddAnchor() {
		page1.addElement(anch1);
		anchors.add(anch1);
		assertTrue(page1.getPath().equals(path1));
		assertTrue(page1.getImages().equals(images));
		assertTrue(page1.getStyles().equals(styles));
		assertTrue(page1.getScripts().equals(scripts));
		assertTrue(page1.getAnchors().equals(anchors));
		assertTrue(page1.toString().equals("\\c\\Users\\chris\\Downloads 0 0 0 1 0"));
	}
	
	@Test
	public void testAddAll() {
		page1.addElement(img1);
		page1.addElement(img2);
		page1.addElement(img3);
		images.add(img1);
		images.add(img2);
		images.add(img3);
		page1.addElement(script1);
		scripts.add(script1);
		page1.addElement(sty1);
		page1.addElement(sty2);
		styles.add(sty1);
		styles.add(sty2);
		page1.addElement(anch1);
		anchors.add(anch1);
		assertTrue(page1.getPath().equals(path1));
		assertTrue(page1.getImages().equals(images));
		assertTrue(page1.getStyles().equals(styles));
		assertTrue(page1.getScripts().equals(scripts));
		assertTrue(page1.getAnchors().equals(anchors));
		assertTrue(page1.toString().equals("\\c\\Users\\chris\\Downloads 3 2 1 1 6"));
	}
}
