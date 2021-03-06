package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestInputHandler {
	InputHandler handler;
	
	String direct1 = "/home/tkennedy/cs350/sum20/";
	//String invalidDirect = "https://www.cs.odu.edu/~tkennedy/cs350/sum20/";
	String url1 = "https://www.cs.odu.edu/~tkennedy/cs350/sum20/";
	String url2 = "https://secweb.cs.odu.edu/~tkennedy/cs350/sum20/";
	String[] args1 = new String[] {direct1,url1,url2};
	String[] invalid = new String[] {url1,url2};
	String[] empty = new String[] {};
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testInputHandlerArgs1() {
		Path expectedPath = Paths.get(direct1);
		LinkedList<String> expectedURLs = new LinkedList<String>();
		expectedURLs.add(url1);
		expectedURLs.add(url2);
		
		handler = new InputHandler();
		handler.getInput(args1);
		assertTrue(expectedPath.equals(handler.getDirectory()));
		assertTrue(expectedURLs.equals(handler.getUrls()));
	}
	
	@Test
	public void testInputHandlerEmptyArgs() {
		handler = new InputHandler();
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		thrown.expectMessage("No arguments provided");
		handler.getInput(empty);
	}
}
