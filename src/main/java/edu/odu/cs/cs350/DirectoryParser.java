package edu.odu.cs.cs350;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.net.URL;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.odu.cs.cs350.*;
import edu.odu.cs.cs350.Enum.*;

public class DirectoryParser {

	private LinkedList<Path> foundFiles;
	private LinkedList<VideoFile> foundVideos;
	private LinkedList<AudioFile> foundAudios;
	private LinkedList<ArchiveFile> foundArchives;
	private LinkedList<NonCategoryFile> foundNonCats;
	private LinkedList<Path> htmlPaths;

	private PathManager pman;

	private Path homeDir;
	private URL[] urls;

	/* //This constructor once we incororate the URLS
		
	    public DirectoryParser(Path home, URL[] theurls) {
		pman = new PathManager();
		homeDir = pman.sanitizePath(home);
		urls = theurls;
	}*/

	public DirectoryParser(Path home) {
		homeDir = home;
	}

	public void parseWebsiteDirectory() throws IOException {
		foundFiles = Files.walk(homeDir)
						.filter(Files::isRegularFile)
						.collect(Collectors.toCollection(LinkedList::new));
	}

	public void categorizeFiles() {
		for(Path p : foundFiles)
		{
			//categorize
		}
	}

	public List<Path> getPages() {
		return foundFiles;
	}
}
