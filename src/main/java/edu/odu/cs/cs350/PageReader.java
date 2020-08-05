package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class PageReader {
	LinkedList<Path> sitePages;
	/*
	 * default constructor
	 */
	public PageReader()
	{
		sitePages = new LinkedList<Path>();
	}
	/*
	 * nondefault constructor
	 * @param pages is a linkedList of paths containing pages of the website
	 */
	public PageReader(LinkedList<Path> pages) {
		sitePages = pages;
	}
	
	public LinkedList<Path> getPages(){
		return sitePages;
	}
	
	/**
	 * scans path for images
	 * @param path : Path to HTML file to be scanned
	 * @return list of images found with only path variable defined
	 * @throws IOException
	 */
	public LinkedList<Image> scanForImages(Path path) throws IOException{
		//get Path of HTMLDocument
		LinkedList<Image> imgList = new LinkedList<Image>();
		sitePages.add(path);
		//use jsoup library to find image tags
		File pathFile = path.toFile();
		Document doc = Jsoup.parse(pathFile, "UTF-8");
		//String in select() will be a String to identify 
		//what the method will search for and add to the Elements(list)
		Elements images = doc.getElementsByTag("img");
		//add each image found in File to LinkedList<Image> in given HTMLDocument Object
		for (Element i : images) {
			Image tempImage = new Image();
			//set the path to image Path list
			String imgString = i.attr("src");
			try {
				tempImage.setPath(Paths.get(imgString));
				imgList.add(tempImage);
			}catch(InvalidPathException e) {
				URL url = new URL(imgString);
				Path imagePath = Paths.get(url.getPath());
				tempImage.setPath(imagePath);
				imgList.add(tempImage);
			}
		}
		//return updated LinkedList of Images from given page
		return imgList;
	}
	
	/**
	 * scans path for styles
	 * @param path : Path to HTML file to be scanned
	 * @return list of stylesheets found with only path variable defined
	 * @throws IOException
	 */
	public LinkedList<Style> scanForStyles(Path path) throws IOException{
		LinkedList<Style> styleList = new LinkedList<Style>();
		sitePages.add(path);
		//use jsoup library to find style tags
		File pathFile = path.toFile();
		Document doc = Jsoup.parse(pathFile, "UTF-8");
		//String in select() will be a String to identify 
		//what the method will search for and add to the Elements(list)
		Elements links = doc.getElementsByTag("link");
		//add each .css files found in File to LinkedList<Style> 
		//in given HTMLDocument Object ignoring inline style tags
		for (Element s : links) {
			if (s.attr("rel") == "stylesheet") {
				Style tempStyle = new Style();
				String styleString = s.attr("href");
				try {
					tempStyle.setPath(Paths.get(styleString));
					styleList.add(tempStyle);
				}catch(InvalidPathException e) {
					URL url = new URL(styleString);
					Path stylePath = Paths.get(url.getPath());
					tempStyle.setPath(stylePath);
					styleList.add(tempStyle);
				}
			}
		}
		//return updated LinkedList of Styles from given page
		return styleList;
		
	}
	
	/**
	 * scans path for scripts 
	 * @param path : Path to HTML file to be scanned
	 * @return list of script files referenced in given path, with only path variable defined
	 * @throws IOException
	 */
	public LinkedList<Script> scanForScripts(Path path) throws IOException{
		LinkedList<Script> scriptList = new LinkedList<Script>();
		sitePages.add(path);
		//use jsoup library to find image tags
		File pathFile = path.toFile();
		Document doc = Jsoup.parse(pathFile, "UTF-8");
		//String in select() will be a String to identify 
		//what the method will search for and add to the Elements(list)
		Elements scripts = doc.getElementsByTag("script");
		//add each script file found in File to LinkedList<Script> 
		//in given HTMLDocument Object ignoring inline scripts
		for (Element s : scripts) {
			if (s.hasAttr("src")) {
				Script tempScript = new Script();
				String scriptString = s.attr("src");
				try {
					tempScript.setPath(Paths.get(scriptString));
					scriptList.add(tempScript);
				}catch(InvalidPathException e) {
					URL url = new URL(scriptString);
					Path scriptPath = Paths.get(url.getPath());
					tempScript.setPath(scriptPath);
					scriptList.add(tempScript);
				}
			}
		}
		//return updated LinkedList of Scripts from given page
		return scriptList;
		
	}
	
	/**
	 * scans path for anchors
	 * @param path : Path to HTML file to be scanned
	 * @return list of anchor tags found with only path variable defined,
	 * unless referencing an external URL with "http:" or "https"
	 * @throws IOException
	 */
	public LinkedList<Anchor> scanForAnchors(Path path) throws IOException{
		LinkedList<Anchor> anchorList = new LinkedList<Anchor>();
		sitePages.add(path);
		//use jsoup library to find anchor tags
		File pathFile = path.toFile();
		Document doc = Jsoup.parse(pathFile, "UTF-8");
		//String in select() will be a String to identify 
		//what the method will search for and add to the Elements(list)
		Elements anchors = doc.getElementsByTag("a");
		//add each anchor tag found in File to LinkedList<Anchor> 
		//in given HTMLDocument Object
		for (Element a : anchors) {
			Anchor tempAnchor = new Anchor();
			String anchorString = a.attr("href");
			try {
				tempAnchor.setPath(Paths.get(anchorString));
				anchorList.add(tempAnchor);
			}catch(InvalidPathException e) {
				URL url = new URL(anchorString);
				Path anchorPath = Paths.get(url.getPath());
				tempAnchor.setPath(anchorPath);
				anchorList.add(tempAnchor);
			}
		}
		//return updated LinkedList of Anchors from given page
		return anchorList;
		
	}

}
