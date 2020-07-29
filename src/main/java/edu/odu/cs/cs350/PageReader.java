package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
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
	public PageReader()
	{
		sitePages = new LinkedList<>();
	}

	public PageReader(LinkedList<Path> pages) {
		sitePages = pages;
	}
	
	public LinkedList<Image> scanForImages(Path path) throws IOException{
		//get Path of HTMLDocument
		LinkedList<Path> pathList = new LinkedList<Path>();
		LinkedList<Image> imgList = new LinkedList<Image>();
		pathList.add(path);
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
			Path imgPath = Paths.get(i.attr("src"));
			LinkedList<Path> imgPaths = new LinkedList<Path>();
			imgPaths.add(imgPath);
			imgList.add(tempImage);
		}
		//return updated LinkedList of Images from given page
		return imgList;
	}
	/*
	* 
	*/
	public LinkedList<Style> scanForStyles(Path path) throws IOException{
		LinkedList<Path> pathList = new LinkedList<Path>();
		LinkedList<Style> styleList = new LinkedList<Style>();
		pathList.add(path);
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
				Path stylePath = Paths.get(s.attr("href"));
				tempStyle.setPath(stylePath);
				styleList.add(tempStyle);
			}
		}
		//return updated LinkedList of Styles from given page
		return styleList;
		
	}
	
	/*
	* 
	*/
	public LinkedList<Script> scanForScripts(Path path) throws IOException{
		LinkedList<Path> pathList = new LinkedList<Path>();
		LinkedList<Script> scriptList = new LinkedList<Script>();
		pathList.add(path);
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
				Path scriptPath = Paths.get(s.attr("src"));
				tempScript.setPath(scriptPath);
				scriptList.add(tempScript);
			}
		}
		//return updated LinkedList of Scripts from given page
		return scriptList;
		
	}
	
	/**
	* 
	**/
	public LinkedList<Anchor> scanForAnchors(Path path) throws IOException{
		LinkedList<Path> pathList = new LinkedList<Path>();
		LinkedList<Anchor> anchorList = new LinkedList<Anchor>();
		pathList.add(path);
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
			int colonIndex = anchorString.indexOf(":");
			if (colonIndex != 4 && colonIndex != 5) {
				tempAnchor.setPath(Paths.get(anchorString));
				anchorList.add(tempAnchor);
			}
			else {
				tempAnchor.setExternality(Externality.EXTERNAL);
				anchorList.add(tempAnchor);
			}
		}
		//return updated LinkedList of Anchors from given page
		return anchorList;
		
	}

}
