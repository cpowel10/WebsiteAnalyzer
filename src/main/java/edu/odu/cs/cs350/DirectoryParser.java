package edu.odu.cs.cs350;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.net.URL;
import java.util.Arrays;
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

	private List<String> archiveExtensions = 
		Arrays.asList("zip", "gz", "tar", "7z");
	private List<String> videoExtensions =
		Arrays.asList("m4a", "mka", "ogg");
	private List<String> audioExtensions =
		Arrays.asList("mkv", "mp4");

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
		String extension = "";
		long size = 0;

		for(Path p : foundFiles)
		{
			extension = getExtension(p);
			if(archiveExtensions.contains(extension)) {
				foundArchives.add(new ArchiveFile(size, p));
			}
			if(videoExtensions.contains(extension)) {
				foundVideos.add(new VideoFile(size, p));
			}
			if(audioExtensions.contains(extension)) {
				foundAudios.add(new AudioFile(size, p));
			}
		}
	}

	public String getExtension(Path p) {
		int i = 0;
		i = p.getFileName().toString().lastIndexOf(".");
		return p.getFileName().toString().substring(i+1);
	}

	public List<Path> getPages() {
		return htmlPaths;
	}
}
