package edu.odu.cs.cs350;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.LinkedList;
import java.util.Iterator;

public class DirectoryParser {

	private LinkedList<Path> accessedPaths;
	
	private Path homeDir;
	private LinkedList<Path> uris;

	public DirectoryParser(String home, String[] theuris) {
		homeDir = Paths.get(home);

		for(String uri : theuris)
			uris.add(Paths.get(uri));
	}

	/*
	 * "Sanitizes" paths by making relative paths and those with redundant
	 * name elements removed.
	 */
	public Path expandPath(Path p) {
		Path expanded;
		expanded = p.normalize().toAbsolutePath();
		return expanded;
	}
	
	/*
	 * 
	 */
	public void parseWebsiteDirectory() {
		
	}
}
