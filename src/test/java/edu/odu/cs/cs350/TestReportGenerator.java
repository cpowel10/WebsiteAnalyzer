package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.LinkedList;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.Before;
import org.junit.Test;

public class TestReportGenerator {

	@Before
	public void setUp() {
		Path path0 = Paths.get("/path/0");
		Path path1 = Paths.get("/path/1");
		Path path2 = Paths.get("/path/2");
		Path path3 = Paths.get("/path/3");
		int size0 = 10;
		int size1 = 100;
		int size2 = 1000;
		int size3 = 10000;
	
		Image image0 = new Image();
		image0.setPath(path0);
		image0.setSize(size0);
		
		Image image1 = new Image();
		image1.setPath(path1);
		image1.setSize(size1);
		
		Image image2 = new Image();
		image2.setPath(path2);
		image2.setSize(size2);
		
		Image image3 = new Image();
		image3.setPath(path3);
		image3.setSize(size3);
		
		LinkedList<Image> myImages = new LinkedList<Image>();
		myImages.add(image0);
		myImages.add(image1);
		myImages.add(image2);
		myImages.add(image3);
		
		HTMLDocument doc = new HTMLDocument();
		doc.setImages(myImages);
		
		LinkedList<HTMLDocument> myDocs = new LinkedList<HTMLDocument>();
		myDocs.add(doc);
		
		Website webs = new Website();
		webs.setPages(myDocs);
	}
	
	@Test
	public final void testJSON() {
		assertThat(true, is(false));
		//fail("Not yet implemented"); // TODO
	}
	@Test
	public final void testTxt() {

		//generateText(webs);//Cannot figure this out >:(
		//File myFile = new File("notSure.txt"); 

		//assertThat(generateText(webs), is("10KB /path/0 /n 100KB /path/1 /n 1000KB /n /path/2")); //There is certainly a better way
		assertThat(true, is(false));
		//fail("Not yet implemented"); // TODO
	}
	@Test
	public final void testXls() {
		assertThat(true, is(false));
		//fail("Not yet implemented"); // TODO
	}
	@Test
	public final void testDisplay() {
		assertThat(true, is(false));
		//fail("Not yet implemented"); // TODO
	}

}
