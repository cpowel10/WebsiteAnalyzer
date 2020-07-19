package edu.odu.cs.cs350;


import java.io.File;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.net.URL;

import java.util.LinkedList;
import java.util.Iterator;

public class DirectoryParser {

	private LinkedList<Path> accessedPaths;

	private Path homeDir;
	private Path[] urls;

	public DirectoryParser(Path home, Path[] theurls) {
		homeDir = home;
		urls = theurls;
	}

	/*
	 *
	 */
	public void parseWebsiteDirectory() {

	}

	public Path urlToPath()

	/*
	 * "Sanitizes" paths by making relative paths and those with redundant
	 * name elements removed.
	 */
	public Path expandPath(Path p) {
		Path expanded;
		expanded = p.normalize().toAbsolutePath();
		return expanded;
	}
}
