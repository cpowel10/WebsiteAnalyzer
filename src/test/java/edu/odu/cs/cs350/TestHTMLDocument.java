package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.Test;
import java.net.URI;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;
import java.util.LinkedList;


public class TestHTMLDocument {

/*	String fileName = "/c/Users/chris/Downloads/";
	Path path1 = Paths.get(fileName);
	LinkedList<Path> llp = new LinkedList<Path>();
	LinkedList<Path> llp2 = new LinkedList<Path>();
	LinkedList<Image> images = new LinkedList<Image>();
	LinkedList<Script> scripts = new LinkedList<Script>();
	LinkedList<Style> styles = new LinkedList<Style>();
	LinkedList<Anchor> anchors = new LinkedList<Anchor>();
	Path test1 = Paths.get("fake/path");
	Path test2 = Paths.get("fake/path2");
  
	Image img1 = new Image(test1,1,test2,Externality.INTERNAL, URI.create("fakeURI"));
	Image img2 = new Image(test1,2,test2,Externality.EXTERNAL, URI.create("fakeURI"));
	Image img3 = new Image(test1,3,test2,Externality.INTERNAL, URI.create("fakeURI"));
	Style sty1 = new Style(test1, Externality.INTERNAL, URI.create("fakeURI"));
	Style sty2 = new Style(test2, Externality.EXTERNAL, URI.create("fakeURI"));
	Script script1 = new Script(test1, Externality.INTRA, URI.create("fakeURI"));
	Anchor anch1 = new Anchor(test2, Externality.INTERNAL, URI.create("fakeURI"));
	//HTMLDocument doc = new HTMLDocument(path1);
	*/
	

	@Test
	public void testDefaultConstructor() {
		Path path = Paths.get("pathNotSet");
		LinkedList<Image> images = new LinkedList<Image>();
		LinkedList<Style> styles = new LinkedList<Style>();
		LinkedList<Script> scripts = new LinkedList<Script>();
		LinkedList<Anchor> anchors = new LinkedList<Anchor>();
		long size = 0;
		HTMLDocument doc = new HTMLDocument();

		assertThat(doc.getPath(), is(path));
		assertThat(doc.getImages(), is(images));
		assertThat(doc.getStyles(), is(styles));
		assertThat(doc.getScripts(), is(scripts));
		assertThat(doc.getAnchors(), is(anchors));
		assertThat(doc.getTotalImageSize(), is(size));
	}
	public void testNonDefaultConstructor() {
		Path path = Paths.get("pathSet");
		LinkedList<Image> images = new LinkedList<Image>();
		LinkedList<Style> styles = new LinkedList<Style>();
		LinkedList<Script> scripts = new LinkedList<Script>();
		LinkedList<Anchor> anchors = new LinkedList<Anchor>();
		long size = 0;
		HTMLDocument doc = new HTMLDocument(path);

		assertThat(doc.getPath(), is(path));
		assertThat(doc.getImages(), is(images));
		assertThat(doc.getStyles(), is(styles));
		assertThat(doc.getScripts(), is(scripts));
		assertThat(doc.getAnchors(), is(anchors));
		assertThat(doc.getTotalImageSize(), is(size));
	}
	/*
	@Test
	public void testAddImage() {
		doc.addElement(img1);
		images.add(img1);
		assertThat(doc.getPath(), is(path1));
		assertThat(doc.getImages(), is(images));
		assertThat(doc.getStyles(), is(styles));
		assertThat(doc.getScripts(), is(scripts));
		assertThat(doc.getAnchors(), is(anchors));
		assertThat(doc.toString(), is("\\c\\Users\\chris\\Downloads 1 0 0 0 1"));
	}
	
	@Test
	public void testAddScript() {
		doc.addElement(script1);
		scripts.add(script1);
		assertThat(doc.getPath(), is(path1));
		assertThat(doc.getImages(), is(images));
		assertThat(doc.getStyles(), is(styles));
		assertThat(doc.getScripts(), is(scripts));
		assertThat(doc.getAnchors(), is(anchors));
		assertThat(doc.toString(), is("\\c\\Users\\chris\\Downloads 0 0 1 0 0"));
	}
	
	@Test
	public void testAddStyle() {
		doc.addElement(sty1);
		styles.add(sty1);
		assertThat(doc.getPath(), is(path1));
		assertThat(doc.getImages(), is(images));
		assertThat(doc.getStyles(), is(styles));
		assertThat(doc.getScripts(), is(scripts));
		assertThat(doc.getAnchors(), is(anchors));
		assertThat(doc.toString(), is("\\c\\Users\\chris\\Downloads 0 1 0 0 0"));
	}

	@Test
	public void testAddAnchor() {
		doc.addElement(anch1);
		anchors.add(anch1);
		assertThat(doc.getPath(), is(path1));
		assertThat(doc.getImages(), is(images));
		assertThat(doc.getStyles(), is(styles));
		assertThat(doc.getScripts(), is(scripts));
		assertThat(doc.getAnchors(), is(anchors));
		assertThat(doc.toString(), is("\\c\\Users\\chris\\Downloads 0 0 0 1 0"));
	}
	
	@Test
	public void testAddAll() {
		doc.addElement(img1);
		doc.addElement(img2);
		doc.addElement(img3);
		images.add(img1);
		images.add(img2);
		images.add(img3);
		doc.addElement(script1);
		scripts.add(script1);
		doc.addElement(sty1);
		doc.addElement(sty2);
		styles.add(sty1);
		styles.add(sty2);
		doc.addElement(anch1);
		anchors.add(anch1);
		assertThat(doc.getPath(), is(path1));
		assertThat(doc.getImages(), is(images));
		assertThat(doc.getStyles(), is(styles));
		assertThat(doc.getScripts(), is(scripts));
		assertThat(doc.getAnchors(), is(anchors));
		assertThat(doc.toString(), is("\\c\\Users\\chris\\Downloads 3 2 1 1 6"));
	}
	*/
}
