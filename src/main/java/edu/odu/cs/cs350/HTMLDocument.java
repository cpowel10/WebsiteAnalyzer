package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import edu.odu.cs.cs350.Enum.Externality;

public class HTMLDocument implements Comparable<HTMLDocument> {
  	private LinkedList<Image> allImages; 
  	private LinkedList<Style> allStyles;
  	private LinkedList<Script> allScripts;
  	private LinkedList<Anchor> allAnchors;
  	private long totalImageSize;
	private Path path;
	private int intraLinks;
	private int internalLinks;
	private int externalLinks;
	private int internalScripts;
	private int externalScripts;
	private int internalStyles;
	private int externalStyles;
	private int internalImages;
	private int externalImages;

  	/**
	 * defualt constructor
	 */
	public HTMLDocument() {
		this.path = Paths.get("pathNotSet");
		allImages = new LinkedList<Image>();
		allStyles = new LinkedList<Style>();
		allScripts = new LinkedList<Script>();
		allAnchors = new LinkedList<Anchor>();
		totalImageSize = 0;
	}
	
  	/**
  	 * nondefault contructor
	 * @param userPath contains path to HTMLDocument (page)
  	 */
	public HTMLDocument(Path userPath) {
		this.path = userPath;
		allImages = new LinkedList<Image>();
		allStyles = new LinkedList<Style>();
		allScripts = new LinkedList<Script>();
		allAnchors = new LinkedList<Anchor>();
		totalImageSize = 0;
	}
	
	/**
	 * @return the size of this page [total size of all images contained]
	 */
	public long getTotalImageSize() {
		return totalImageSize;
	}

	/**
	 * @return path to HTMLDocument
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * @return linked list of images containing all images
	 */
	public LinkedList<Image> getImages(){
		return allImages;
	}

	/**
	 * @return linked list of scripts containing all scripts
	 */
	public LinkedList<Script> getScripts(){
		return allScripts;
	}

	/**
	 * @return linked list of styles containing all styles
	 */
	public LinkedList<Style> getStyles(){
		return allStyles;
	}

	/**
	 * @return linked list of anchors containing all anchors
	 */
	public LinkedList<Anchor> getAnchors(){
		return allAnchors;
	}
	/**
	 * sets total image size
	 * @param size of total image size
	 */
	public void setTotalImageSize(long size) {
		totalImageSize = size;
	}
	/**
	 * sets path of HTMLDocument
	 * @param pth contains path to HTMLDocument (page) 
	 */
	public void setPath(Path pth) {
		this.path = pth;
	}
	/**
	 * sets linked list of images 
	 * @param linked list of images to be set
	 */
	public void setImages(LinkedList<Image> images){
		this.allImages = images;
	}
	/**
	 * sets linked list of scripts
	 * @param linked list of sripts to be set
	 */
	public void setScripts(LinkedList<Script> scripts){
		this.allScripts = scripts;
	}
	/**
	 * sets linked list of styles
	 * @param linked list of styles to be set
	 */	
	public void setStyles(LinkedList<Style> styles){
		this.allStyles = styles;
	}
	/**
	 * sets linked list of anchors
	 * @param linked list of anchors to be set
	 */
	public void setAnchors(LinkedList<Anchor> anchors){
		this.allAnchors = anchors;
	}
	/**
	 * adds image size to total
	 * @param imageSize contains long to be added to total size of images
	 */
	public void addToImageSize(long imageSize){
		long size;
		size = this.totalImageSize;
		size += imageSize;
		this.totalImageSize = size; 
	}
	/**
	 * adds image to collection of images
	 * @param img contains image to be added to collection of images
	 */
	public void addImage(Image img) {
		allImages.add(img);
	}
	/**
	 * sets internal, intra, and external link counts
	 */
	public void setAnchorTypeCounters() {
		int intra=0, internal=0, external=0;
		for(Anchor anc : allAnchors) {
			if(anc.getExternality().equals(Externality.INTRA)) {
				intra++;
			}
			if(anc.getExternality().equals(Externality.INTERNAL)) {
				internal++;
			}
			if(anc.getExternality().equals(Externality.EXTERNAL)) {
				external++;
			}
		}
		intraLinks = intra;
		internalLinks = internal;
		externalLinks = external;
	}

	/** 
	 * Sets counts for number of internal and external Images
	 */
	public void setImageTypeCounters() {
		int internal=0, external=0;
		for(Image img : allImages) {
			if(img.getExternality().equals(Externality.INTERNAL)) {
				internal++;
			}
			if(img.getExternality().equals(Externality.EXTERNAL)) {
				external++;
			}
		}
		internalImages = internal;
		externalImages = external;
	}

	/** 
	 * Sets counts for number of internal and external Scripts
	 */
	public void setStyleTypeCounters() {
		int internal=0, external=0;
		for(Script scr : allScripts) {
			if(scr.getExternality().equals(Externality.INTERNAL)) {
				internal++;
			}
			if(scr.getExternality().equals(Externality.EXTERNAL)) {
				external++;
			}
		}
		internalScripts = internal;
		externalScripts = external;
	}

	/** 
	 * Sets counts for number of internal and external Styles
	 */
	public void setScriptTypeCounters() {
		int internal=0, external=0;
		for(Style sty : allStyles) {
			if(sty.getExternality().equals(Externality.INTERNAL)) {
				internal++;
			}
			if(sty.getExternality().equals(Externality.EXTERNAL)) {
				external++;
			}
		}
		internalStyles = internal;
		externalStyles = external;
	}

	/**
	 * @return number of intra-page links on this page
	 */
	public int getNumIntraLinks() {
		return this.intraLinks;
	}

	/**
	 * @return number of links to outside the website on this page
	 */
	public int getNumExternalLinks() {
		return this.externalLinks;
	}

	/**
	 * @return number of links to within the website on this page
	 */
	public int getNumInternalLinks() {
		return this.internalLinks;
	}

	/**
	 * @return number of external-site scripts on this page
	 */
	public int getNumExternalScripts() {
		return this.externalScripts;
	}

	/**
	 * @return number of internal-site scripts on this page
	 */
	public int getNumInternalScripts() {
		return this.internalScripts;
	}

	/**
	 * @return number of external-site styles on this page
	 */
	public int getNumExternalStyles() {
		return this.externalStyles;
	}

	/**
	 * @return number of internal-site links on this page
	 */
	public int getNumInternalStyles() {
		return this.internalStyles;
	}

	/**
	 * @return number of external-site images on this page
	 */
	public int getNumExternalImages() {
		return this.externalImages;
	}

	/**
	 * @return number of internal-site links on this page
	 */
	public int getNumInternalImages() {
		return this.internalImages;
	}

	/**
	 * Override for comparison, used in GenerateReport for Collections.sort(List)
	 * compares two HTMLDocuments lexiconographically 
	 * @param doc contains HTMLDocument to be compared 
	 */
	@Override
	public int compareTo(HTMLDocument doc) {
		
		String lhsPath = (this.getPath()).toString();
		String rhsPath = (doc.getPath()).toString(); 
		int lhsLength = lhsPath.length();
		int rhsLength = rhsPath.length();
		
		//grab a quick max length for iteration/indexing
		int max = 0;
		if(lhsLength > rhsLength)
			max = lhsLength;
		else
			max = rhsLength;
		
		//go over every character  of the path to compare
		for(int i = 0; i < max; i++) {
			if((int)lhsPath.charAt(i) - (int)rhsPath.charAt(i) > 0)
				return 1; //difference is greater than 0 means lhs is larger(comes later in alphabet)
			else if((int)lhsPath.charAt(i) - (int)rhsPath.charAt(i) < 0)
				return -1; //lhs is smaller(comes earlier in alphabet)
		}
		return 0; //equal 
	}
	
	/**
	 * For Testing Only Below
	 * To string collection of variables for testing
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
