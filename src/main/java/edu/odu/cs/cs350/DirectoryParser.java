package edu.odu.cs.cs350;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;

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
	private LinkedList<VideoFile> foundVideos = new LinkedList<VideoFile>();
	private LinkedList<AudioFile> foundAudios = new LinkedList<AudioFile>();
	private LinkedList<ArchiveFile> foundArchives = new LinkedList<ArchiveFile>();
	private LinkedList<NonCategoryFile> foundNonCats = new LinkedList<NonCategoryFile>();
	private LinkedList<Path> htmlPaths = new LinkedList<Path>();

	private PathManager pman;
	Scanner scanner;

	private List<String> archiveExtensions = 
		Arrays.asList("zip", "gz", "tar", "7z");
	private List<String> videoExtensions =
		Arrays.asList("m4a", "mka", "ogg");
	private List<String> audioExtensions =
		Arrays.asList("mkv", "mp4");

	private Path homeDir;
	private URL[] urls;

	/** //This constructor once we incororate the URLS
		
	    public DirectoryParser(Path home, URL[] theurls) {
		pman = new PathManager();
		homeDir = pman.sanitizePath(home);
		urls = theurls;
	}*/
	public DirectoryParser(Path home) {
		homeDir = home;
	}

	/** Simple file walk for the homeDirectory and stores a list of files
	 * (excluding directories)
	 */
	public void parseWebsiteDirectory() throws IOException {
		foundFiles = Files.walk(homeDir)
						.filter(Files::isRegularFile)
						.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Goes over the list of files we found while parsing, grabs their extension/size
	 * to be sorted
	 */
	public void categorizeFiles()  throws IOException {
		for(Path p : foundFiles) {
			sortFile(p);
		}
	}

	/**
	 * Given a particular file will 'sort' it by generating an instance of the correct
	 * file type for analysis OR if heuristically determined to be an HTML document
	 * (for having text and valid html tags) to be parsed by jsoup in analyzer
	 */
	public void sortFile(Path p) throws IOException {
		String extension = getExtension(p);
		long size = Files.size(p);
		if(archiveExtensions.contains(extension)) {
			foundArchives.add(new ArchiveFile(size, p));
			return;
		}
		if(videoExtensions.contains(extension)) {
			foundVideos.add(new VideoFile(size, p));
			return;
		}
		if(audioExtensions.contains(extension)) {
			foundAudios.add(new AudioFile(size, p));
			return;
		}
		//**maaaaaybe* this will be okay? checks MIME type for text
		if(Files.probeContentType(p).startsWith("text")) {
			if(hasHtml(p)) {
				htmlPaths.add(p);
				return;
			}
		}
		foundNonCats.add(new NonCategoryFile(size, p));
	}

	/** Returns true if the given path to a text file contains an html doctype declaration
	 * otherwise returns false
	 *  @param file path to check
	 *  @pre given path is to a text file
	 */
	public boolean hasHtml(Path p) throws IOException{
		//Grab list of Strings for each line of file
		try {
			List<String> lines = Files.readAllLines(p);
			//consider a file with a valid html doctype declaration tag an html doc
			for(String line : lines) {
				if(line.toLowerCase().matches("\\s<!doctype html.*>")) {
					return true;
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading what should be a text file.");
		}
		return false;
	}

	/**
	 * Get the extension of a file simply
	 * @param  p Path to parse for file extension
	 * @pre path contains at least 1 element
	 * @returns the file extension
	 */
	public String getExtension(Path p) {
		int i = 0;
		i = p.getFileName().toString().lastIndexOf(".");
		return p.getFileName().toString().substring(i+1);
	}

	public List<Path> getPages() {
		return htmlPaths;
	}
	
	public LinkedList<VideoFile> getVideos(){
		return foundVideos;
	}
	
	public LinkedList<AudioFile> getAudios(){
		return foundAudios;
	}
	
	public LinkedList<ArchiveFile> getArchives(){
		return foundArchives;
	}
	
	public LinkedList<NonCategoryFile> getNonCats(){
		return foundNonCats;
	}
}
