package edu.odu.cs.cs350;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class InputHandler {
	private LinkedList<String> urls = new LinkedList<String>();
	private Path directory;
	  
	/**
	 * 
	 * @param args : command line arguments
	 */
	public void getInput(String[] args) {
		try {
			directory = Paths.get(args[0]);
		}catch(InvalidPathException e) {
			System.out.println("Invalid directory provided. Unable to perform analysis");
			throw e;
		}
		
		for (int i = 1 ; i < (args.length) ; i++) {
			urls.add(args[i]);
		}
	}
	  
	/**
	 * 
	 * @return list of urls to analyze when encountered
	 */
	public LinkedList<String> getUrls(){
		return urls;
	}
	  
	/**
	 * 
	 * @return Path to directory to be parsed
	 */
	public Path getDirectory() {
		return directory;
	}
}
