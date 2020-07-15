package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.LinkedList;

public class HTMLDocument {
  	private LinkedList<Image> allImages;
  	private LinkedList<Style> allStyles;
  	private LinkedList<Script> allScripts;
  	private LinkedList<Anchor> allAnchors;
  	private int totalImageSize;
  	private Path path;
  	
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
	public int getTotalImageSize() {
		return totalImageSize;
	}
	
	public Path getPath() {
		return path;
	}
	
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
		str += Integer.toString(totalImageSize);
		return str;
	}
}
