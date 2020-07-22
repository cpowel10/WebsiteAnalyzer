package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Website {
	private Path localPath;
	private LinkedList<String> urls;
	public LinkedList<HTMLDocument> allPages; //setters have been written, replace .allPages with .getPages() then switch this to private
	private LinkedList<AudioFile> allAudioFiles;
	private LinkedList<VideoFile> allVideoFiles;
	private LinkedList<ArchiveFile> allArchiveFiles;
	private LinkedList<NonCategoryFile> allNonCategoryFiles;

	public Website() {
		this.localPath = Paths.get("pathNotSet");
		this.urls = new LinkedList<String>();
		this.allPages = new LinkedList<HTMLDocument>();
		this.allAudioFiles = new LinkedList<AudioFile>();
		this.allVideoFiles = new LinkedList<VideoFile>();
		this.allArchiveFiles = new LinkedList<ArchiveFile>();
		this.allNonCategoryFiles = new LinkedList<NonCategoryFile>();
	}
	//getters 
	/*
	 * returns the Path 
	 */
	public Path getPath() {
		return this.localPath;
	}
	/*
	 * returns the LinkedList of URLS(of type string)
	 */
	public LinkedList<String> getURLs(){
		return this.urls;
	}
	/*
	 * returns the LinkedList of pages(of type HTMLDocument)
	 */
	public LinkedList<HTMLDocument> getPages(){
		return this.allPages;
	}
	/*
	 * returns the LinkedList of audioFiles
	 */
	public LinkedList<AudioFile> getAudioFiles(){
		return this.allAudioFiles;
	}
	/*
	 * returns the LinkedList of videoFiles
	 */
	public LinkedList<VideoFile> getVideoFiles(){
		return this.allVideoFiles;
	}
	/*
	 * returns the LinkedList of archiveFiles
	 */
	public LinkedList<ArchiveFile> getArchiveFiles(){
		return this.allArchiveFiles;
	}
	/*
	 * returns the LinkedList of nonCategoryFiles
	 */
	public LinkedList<NonCategoryFile> getNonCatFiles(){
		return this.allNonCategoryFiles;
	}
	//Setters
	/*
	 * sets the Path
	 */
	public void setPath(Path path) {
		this.localPath = path;
	}
	/*
	 * sets the urls
	 */
	public void setURLs(LinkedList<String> url){
		this.urls = url;
	}
	/*
	 * sets the pages(of type HTMLDocument)
	 */
	public void setPages(LinkedList<HTMLDocument> pages){
		this.allPages = pages;
	}
	/*
	 * sets the audioFiles
	 */
	public void setAudioFiles(LinkedList<AudioFile> files){
		this.allAudioFiles = files;
	}
	/*
	 * sets the videoFiles
	 */
	public void setVideoFiles(LinkedList<VideoFile> files){
		this.allVideoFiles = files;
	}
	/*
	 * sets the archiveFiles
	 */
	public void setArchiveFiles(LinkedList<ArchiveFile> files){
		this.allArchiveFiles = files;
	}
	/*
	 * sets the nonCategoryFiles
	 */
	public void setNonCatFiles(LinkedList<NonCategoryFile> files){
		this.allNonCategoryFiles = files;
	}
	
	/*
	 * returns the number of Images from the website that 
	 * are marked as internal
	 */
	public int numInternalImages() {
		int count = 0;
		//for each HTMLDoc
		//	for eachImage
		//		if( x.externality == externality.INTERNAL)
		//			count++;
		return count;
	}
	
	/*
	 * returns the number of Images from the website that 
	 * are marked as External
	 */
	int numExternalImages() {
		int count = 0;
		//for each HTMLDoc
		//	for eachImage
		//		if( x.externality == externality.EXTERNAL)
		//			count++;
		return count;
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
