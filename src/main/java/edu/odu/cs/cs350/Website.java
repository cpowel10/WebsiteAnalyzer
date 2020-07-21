package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Website {
	private String localPath;
	private LinkedList<String> urls;
	public LinkedList<HTMLDocument> allPages; //need to write setters
	private LinkedList<AudioFile> allAudioFiles;
	private LinkedList<VideoFile> allVideoFiles;
	private LinkedList<ArchiveFile> allArchiveFiles;
	private LinkedList<NonCategoryFile> allNonCategoryFiles;

	public Website() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * returns the Collection of HTMLDocument Objects
	 */
	public LinkedList<HTMLDocument> getPages(){
		return null;
	}
	
	/*
	 * returns the number of Images from the website that 
	 * are marked as internal
	 */
	public int numInternalImages() {
		return -1;
	}
	
	/*
	 * returns the number of Images from the website that 
	 * are marked as External
	 */
	int numExternalImages() {
		return -1;
	}
	
	/*
	 * returns the number of Scripts used in the website
	 */
	int numScriptsReferenced() {
		return -1;
	}
	
	/*
	 * returns the number of Stylesheets used in the website
	 */
	int numStylesUtilized() {
		return -1;
	}
	
	/*
	 * returns the number of Links on the website that 
	 * are marked as Intra
	 */
	int numIntraLinks() {
		return -1;
	}
	
	/*
	 * returns the number of Links on the website that 
	 * are marked as Internal
	 */
	int numInternalLinks() {
		return -1;
	}
	
	/*
	 * returns the number of Links on the website that 
	 * are marked as External
	 */
	int numExternalLinks() {
		return -1;
	}
}
