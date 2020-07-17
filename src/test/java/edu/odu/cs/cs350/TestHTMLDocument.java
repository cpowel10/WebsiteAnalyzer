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

	Image img1 = new Image(TagType.IMAGE, 2, llp, 1, llp2);
	Image img2 = new Image(TagType.IMAGE, 3, llp, 1, llp2);
	Image img3 = new Image(TagType.IMAGE, 13, llp, 1, llp2);
	Style sty1 = new Style("fake/path", Externality.INTERNAL);
	Style sty2 = new Style("fake/path2", Externality.EXTERNAL);
	Script script1 = new Script("fake/path", Externality.INTRA);
	Anchor anch1 = new Anchor("fake/path", Externality.INTERNAL);
	HTMLDocument page1 = new HTMLDocument(path1);

	@Test
	public void testConstructorEmpty() {
		assertThat(page1.getPath(), is(path1));
		assertThat(page1.getImages(), is(images));
		assertThat(page1.getStyles(), is(styles));
		assertThat(page1.getScripts(), is(scripts));
		assertThat(page1.getAnchors(), is(anchors));
		assertThat(page1.toString(), is("\\c\\Users\\chris\\Downloads 0 0 0 0 0"));
	}
	
	@Test
	public void testAddImage() {
		page1.addElement(img1);
		images.add(img1);
		assertThat(page1.getPath(), is(path1));
		assertThat(page1.getImages(), is(images));
		assertThat(page1.getStyles(), is(styles));
		assertThat(page1.getScripts(), is(scripts));
		assertThat(page1.getAnchors(), is(anchors));
		assertThat(page1.toString(), is("\\c\\Users\\chris\\Downloads 1 0 0 0 2"));
	}
	
	@Test
	public void testAddScript() {
		page1.addElement(script1);
		scripts.add(script1);
		assertThat(page1.getPath(), is(path1));
		assertThat(page1.getImages(), is(images));
		assertThat(page1.getStyles(), is(styles));
		assertThat(page1.getScripts(), is(scripts));
		assertThat(page1.getAnchors(), is(anchors));
		assertThat(page1.toString(), is("\\c\\Users\\chris\\Downloads 0 0 1 0 0"));
	}
	
	@Test
	public void testAddStyle() {
		page1.addElement(sty1);
		styles.add(sty1);
		assertThat(page1.getPath(), is(path1));
		assertThat(page1.getImages(), is(images));
		assertThat(page1.getStyles(), is(styles));
		assertThat(page1.getScripts(), is(scripts));
		assertThat(page1.getAnchors(), is(anchors));
		assertThat(page1.toString(), is("\\c\\Users\\chris\\Downloads 0 1 0 0 0"));
	}

	@Test
	public void testAddAnchor() {
		page1.addElement(anch1);
		anchors.add(anch1);
		assertThat(page1.getPath(), is(path1));
		assertThat(page1.getImages(), is(images));
		assertThat(page1.getStyles(), is(styles));
		assertThat(page1.getScripts(), is(scripts));
		assertThat(page1.getAnchors(), is(anchors));
		assertThat(page1.toString(), is("\\c\\Users\\chris\\Downloads 0 0 0 1 0"));
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
		assertThat(page1.getPath(), is(path1));
		assertThat(page1.getImages(), is(images));
		assertThat(page1.getStyles(), is(styles));
		assertThat(page1.getScripts(), is(scripts));
		assertThat(page1.getAnchors(), is(anchors));
		assertThat(page1.toString(), is("\\c\\Users\\chris\\Downloads 3 2 1 1 18"));
	}
}
