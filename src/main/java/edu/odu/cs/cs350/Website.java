package edu.odu.cs.cs350;

import java.util.Collection;

/*
  + String localPath
  + Collection<String> urls
  + allPages Collection<HTMLDocument>
  + allAudioFiles Collection<AudioFile>
  + allVideoFiles Collection<VideoFile>
  + allArchiveFiles Collection<ArchiveFile>
  + allNonCategoryFiles Collection<NonCategoryFile>
  + Collection<HTMLDocument> getPages()
  + int numInternalImages()
  + int numExternalImages()
  + int numScriptsReferenced()
  + int numStylesUtilized()
  + int numIntraLinks()
  + int numInternalLinks()
  + int numExternalLinks()
 */
public class Website {
	private String localPath;
	private Collection<String> urls;
	private Collection<HTMLDocument> allPages;
	private Collection<AudioFile> allAudioFiles;
	private Collection<VideoFile> allVideoFiles;
	private Collection<ArchiveFile> allArchiveFiles;
	private Collection<NonCategoryFile> allNonCategoryFiles;

	public Website() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 
	 */
	public Collection<HTMLDocument> getPages(){
		return null;
	}
	
	/*
	 * 
	 */
	public int numInternalImages() {
		return -1;
	}
	
	/*
	 * 
	 */
	int numExternalImages() {
		return -1;
	}
	
	/*
	 * 
	 */
	int numScriptsReferenced() {
		return -1;
	}
	
	/*
	 * 
	 */
	int numStylesUtilized() {
		return -1;
	}
	
	/*
	 * 
	 */
	int numIntraLinks() {
		return -1;
	}
	
	/*
	 * 
	 */
	int numInternalLinks() {
		return -1;
	}
	
	/*
	 * 
	 */
	int numExternalLinks() {
		return -1;
	}
}
