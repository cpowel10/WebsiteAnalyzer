package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import java.util.Iterator;

public class Website {
	private Path localPath;
	private LinkedList<String> urls;
	private LinkedList<HTMLDocument> allPages; 
	private LinkedList<AudioFile> allAudioFiles;
	private LinkedList<VideoFile> allVideoFiles;
	private LinkedList<ArchiveFile> allArchiveFiles;
	private LinkedList<NonCategoryFile> allNonCategoryFiles;
	/*
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
	/*
	 * returns the Path of the website
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
	/*
	 * reads all of its pages
	 */
	public void readPages() {

	}
	/*
	 * sets the Path
	 * @param path contains path to website
	 */
	public void setPath(Path path) {
		this.localPath = path;
	}
	/*
	 * sets the urls
	 * @param url contains a linked list of strings of urls of the website
	 */
	public void setURLs(LinkedList<String> url){
		this.urls = url;
	}
	/*
	 * sets the pages(of type HTMLDocument)
	 * @param pages contains a linked list of HTMLDocuments of the website
	 */
	public void setPages(LinkedList<HTMLDocument> pages){
		this.allPages = pages;
	}
	/*
	 * sets the audioFiles
	 * @param files contains a linked list of AudioFiles of the website
	 */
	public void setAudioFiles(LinkedList<AudioFile> files){
		this.allAudioFiles = files;
	}
	/*
	 * sets the videoFiles
	 * @param files contains a linked list of VideoFiles of the website
	 */
	public void setVideoFiles(LinkedList<VideoFile> files){
		this.allVideoFiles = files;
	}
	/*
	 * sets the archiveFiles
	 * @param files contains a linked list of ArchiveFiles of the website
	 */
	public void setArchiveFiles(LinkedList<ArchiveFile> files){
		this.allArchiveFiles = files;
	}
	/*
	 * sets the nonCategoryFiles
	 * @param files contains a linked list of NonCategoryFiles of the website
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
	 * returns an iterator over the videoFiles
	 */
	public Iterator<VideoFile> getVideoIterator() {
		return allVideoFiles.iterator();
	}
	/*
	 * returns an iterator over the audioFiles
	 */
	public Iterator<AudioFile> getAudioIterator() {
		return allAudioFiles.iterator();
	}
	/*
	 * returns an iterator over the archiveFiles
	 */
	public Iterator<ArchiveFile> gEtaRChiVeiteRATOR() {
		return allArchiveFiles.iterator();
	}
	/*
	 * returns an iterator over the nonCategoryFiles
	 */
	public Iterator<NonCategoryFile> getNonCategoryIteraotr() {
		return allNonCategoryFiles.iterator();
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
