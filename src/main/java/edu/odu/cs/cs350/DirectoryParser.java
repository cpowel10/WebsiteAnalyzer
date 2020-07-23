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
import java.util.Scanner;

import edu.odu.cs.cs350.*;
import edu.odu.cs.cs350.Enum.*;

public class DirectoryParser {

	private List<Path> foundFiles;
	private LinkedList<VideoFile> foundVideos;
	private LinkedList<AudioFile> foundAudios;
	private LinkedList<ArchiveFile> foundArchives;
	private LinkedList<NonCategoryFile> foundNonCats;
	private LinkedList<Path> htmlPaths;

	private PathManager pman;

	private Path homeDir;
	private URL[] urls;

	Scanner scanner;

	public DirectoryParser(Path home, URL[] theurls) {
		pman = new PathManager();
		homeDir = pman.sanitizePath(home);
		urls = theurls;
	}

	/*
	 *
	 */
	public void parseWebsiteDirectory() throws IOException {
		foundFiles = Files.walk(homeDir)
						.filter(Files::isRegularFile)
						.collect(Collectors.toList());
		FileType type;
		for(Path p : foundFiles)
		{
			scanner = new Scanner(p);
			if(scanner.hasNext("<html>")&&scanner.hasNext("</html>"))
				htmlPaths.add(p);
			scanner.close();
		}
	}

	public void categorizeFiles() {
		String filename;
	}

	public List<Path> getPages() {
		return foundFiles;
	}
}
