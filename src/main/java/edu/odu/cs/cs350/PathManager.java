package edu.odu.cs.cs350;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.net.URL;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.odu.cs.cs350.Enum.*;
import edu.odu.cs.cs350.WebsiteFile;
import edu.odu.cs.cs350.VideoFile;
import edu.odu.cs.cs350.NonCategoryFile;
import edu.odu.cs.cs350.AudioFile;
import edu.odu.cs.cs350.ArchiveFile;

public class PathManager {
//
	private List<Path> foundFiles;
	private List<VideoFile> foundVideos;
	private List<AudioFile> foundAudios;
	private List<ArchiveFile> foundArchives;
	private List<NonCategoryFile> foundNonCats;

	private Path homeDir;
	private URL[] urls;

	public PathManager(Path home, URL[] theurls) {
		homeDir = sanitizePath(home);
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
			//type = 
		}
	}

	public void categorizeFiles() {
		String filename;
	}

	/*
	 * Checks a url against the provided urls to be analyzed
	 * if internal url, the site root is removed and remaining path returned
	 * null if otherwise
	 */
	//remove www.example.com part but leave path
	public Path mapUrlToPath (URL u) { //need Paths.get(u.getPath)
		Path mappedPath = null;
		for(URL url : urls)
		{
			if(url.getHost().equals(u.getHost()))
				mappedPath = mappedPath.resolve(u.getPath()); 
		}
		return mappedPath;
	}

	/*
	 * Transmutes any relative paths to absolute and removes redunant name elements
	 */
	public Path sanitizePath(Path p) {
		Path expanded;
		expanded = p.normalize().toAbsolutePath();
		return expanded;
	}

	public Path urlToPath(URL url) {
		Path thepath = Paths.get(url.getPath());
		sanitizePath(thepath);
		return thepath;
	}
}
