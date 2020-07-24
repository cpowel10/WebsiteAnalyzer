package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class HTMLDocument implements Comparable<HTMLDocument> {
  	public LinkedList<Image> allImages; //we need setters as well (I think) so I made public for now...
  	private LinkedList<Style> allStyles;
  	private LinkedList<Script> allScripts;
  	private LinkedList<Anchor> allAnchors;
  	private long totalImageSize;
  	private Path path;
  	
	public HTMLDocument() {
		this.path = Paths.get("pathNotSet");
		allImages = new LinkedList<Image>();
		allStyles = new LinkedList<Style>();
		allScripts = new LinkedList<Script>();
		allAnchors = new LinkedList<Anchor>();
		totalImageSize = 0;
	}
  	/*
  	 * set private path variable to given userPath
  	 */
	public HTMLDocument(Path userPath) {
		this.path = userPath;
		allImages = new LinkedList<Image>();
		allStyles = new LinkedList<Style>();
		allScripts = new LinkedList<Script>();
		allAnchors = new LinkedList<Anchor>();
		totalImageSize = 0;
	}
	
	/*
	 * adds sizes of all Image objects in
	 * allImages and returns the totalImageSize
	 * for the current HTMLDocument
	 */
	public long getTotalImageSize() {
		return totalImageSize;
	}
	
	public Path getPath() {
		return path;
	}
	
	public LinkedList<Image> getImages(){
		return allImages;
	}
	
	public LinkedList<Script> getScripts(){
		return allScripts;
	}
	
	public LinkedList<Style> getStyles(){
		return allStyles;
	}
	
	public LinkedList<Anchor> getAnchors(){
		return allAnchors;
	}

	public void setTotalImageSize(long size) {
		totalImageSize = size;
	}

	public void setPath(Path pth) {
		this.path = pth;
	}
	
	public void setImages(LinkedList<Image> images){
		this.allImages = images;
	}
	
	public void setScripts(LinkedList<Script> scripts){
		this.allScripts = scripts;
	}
	
	public void setStyles(LinkedList<Style> styles){
		this.allStyles = styles;
	}
	
	public void setAnchors(LinkedList<Anchor> anchors){
		this.allAnchors = anchors;
	}
	public void addToImageSize(long imageSize){
		long size;
		size = this.totalImageSize;
		size += imageSize;
		this.totalImageSize = size; 
	}
	
	/*
	 * May go in PageReader class
	 */
	public void addElement(Object tag) {
		if (tag instanceof Anchor) {
			allAnchors.add((Anchor) tag);
		}
		else if (tag instanceof Style) {
			allStyles.add((Style) tag);
		}
		else if (tag instanceof Script) {
			allScripts.add((Script) tag);
		}
		else {
			allImages.add((Image) tag);
			totalImageSize += ((Image) tag).size();
		}
	}
	@Override
	public int compareTo(HTMLDocument doc) {
		
		String lhsPath = (this.getPath()).toString();
		String rhsPath = (doc.getPath()).toString(); 
		int lhsLength = lhsPath.length();
		int rhsLength = rhsPath.length();
		int max = 0;
		if(lhsLength > rhsLength)
			max = lhsLength;
		else
			max = rhsLength;
		for(int i = 0; i < max; i++) {
			if((int)lhsPath.charAt(i) - (int)rhsPath.charAt(i) > 0)
				return 1; //difference is greater than 0 means lhs is larger(comes later in alphabet)
			else if((int)lhsPath.charAt(i) - (int)rhsPath.charAt(i) < 0)
				return -1;
		}
		return 0; 
	}
 
	
	/*
	 * For Testing Only Below
	 * <path> <num_img> <num_style> <num_script> <num_anchor> <totalImageSize>
	 */
	public String toString() {
		String str = path.toString() + " ";
		str += Integer.toString(allImages.size()) + " ";
		str += Integer.toString(allStyles.size()) + " ";
		str += Integer.toString(allScripts.size()) + " ";
		str += Integer.toString(allAnchors.size()) + " ";
		str += String.valueOf(totalImageSize);

		return str;
	}
}
