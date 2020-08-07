package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Website {
	private Path localPath;
	private LinkedList<String> urls;
	private LinkedList<HTMLDocument> allPages; 
	private LinkedList<AudioFile> allAudioFiles;
	private LinkedList<VideoFile> allVideoFiles;
	private LinkedList<ArchiveFile> allArchiveFiles;
	private LinkedList<NonCategoryFile> allNonCategoryFiles;
	/**
	 * default constructor 
	 */
	public Website() {
		this.localPath = Paths.get("pathNotSet");
		this.urls = new LinkedList<String>();
		this.allPages = new LinkedList<HTMLDocument>();
		this.allAudioFiles = new LinkedList<AudioFile>();
		this.allVideoFiles = new LinkedList<VideoFile>();
		this.allArchiveFiles = new LinkedList<ArchiveFile>();
		this.allNonCategoryFiles = new LinkedList<NonCategoryFile>();
	}
	/**
	 * @return the Path of the website
	 */
	public Path getPath() {
		return this.localPath;
	}
	/**
	 * @return the LinkedList of URLS(of type string)
	 */
	public LinkedList<String> getURLs(){
		return this.urls;
	}
	/**
	 * @return the LinkedList of pages(of type HTMLDocument)
	 */
	public LinkedList<HTMLDocument> getPages(){
		return this.allPages;
	}
	/**
	 * @return the LinkedList of audioFiles
	 */
	public LinkedList<AudioFile> getAudioFiles(){
		return this.allAudioFiles;
	}
	/**
	 * @return the LinkedList of videoFiles
	 */
	public LinkedList<VideoFile> getVideoFiles(){
		return this.allVideoFiles;
	}
	/**
	 * @return the LinkedList of archiveFiles
	 */
	public LinkedList<ArchiveFile> getArchiveFiles(){
		return this.allArchiveFiles;
	}
	/**
	 * @return the LinkedList of nonCategoryFiles
	 */
	public LinkedList<NonCategoryFile> getNonCatFiles(){
		return this.allNonCategoryFiles;
	}
	/**
	 * sets the Path
	 * @param path contains path to website
	 */
	public void setPath(Path path) {
		this.localPath = path;
	}
	/**
	 * sets the urls
	 * @param url contains a linked list of strings of urls of the website
	 */
	public void setURLs(LinkedList<String> url){
		this.urls = url;
	}
	/**
	 * sets the pages(of type HTMLDocument)
	 * @param pages contains a linked list of HTMLDocuments of the website
	 */
	public void setPages(LinkedList<HTMLDocument> pages){
		this.allPages = pages;
	}
	/**
	 * sets the audioFiles
	 * @param files contains a linked list of AudioFiles of the website
	 */
	public void setAudioFiles(LinkedList<AudioFile> files){
		this.allAudioFiles = files;
	}
	/**
	 * sets the videoFiles
	 * @param files contains a linked list of VideoFiles of the website
	 */
	public void setVideoFiles(LinkedList<VideoFile> files){
		this.allVideoFiles = files;
	}
	/**
	 * sets the archiveFiles
	 * @param files contains a linked list of ArchiveFiles of the website
	 */
	public void setArchiveFiles(LinkedList<ArchiveFile> files){
		this.allArchiveFiles = files;
	}
	/**
	 * sets the nonCategoryFiles
	 * @param files contains a linked list of NonCategoryFiles of the website
	 */
	public void setNonCatFiles(LinkedList<NonCategoryFile> files){
		this.allNonCategoryFiles = files;
	}
}