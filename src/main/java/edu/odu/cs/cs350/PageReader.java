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
		//find size of Image
		File imgFile = new File(i.attr("src"));
		long fileSize = imgFile.length();
		//need to convert fileSize from bytes to MiB
		//long fileSizeMiB = (long) (fileSize * 9.53674e-7);
		tempImage.setSize((int)(fileSize));
		//set the path to image Path list
		Path imgPath = Paths.get(i.attr("src"));
		LinkedList<Path> imgPaths = new LinkedList<Path>();
		imgPaths.add(imgPath);
		tempImage.setPagesOn(pathList);
		tempImage.setListings(imgPaths);
		tempImage.setNumPages(1);
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
		//use jsoup library to find image tags
		File pathFile = path.toFile();
		Document doc = Jsoup.parse(pathFile, "UTF-8");
		//String in select() will be a String to identify 
		//what the method will search for and add to the Elements(list)
		Elements links = doc.getElementsByTag("link");
		//add each script file found in File to LinkedList<Script> 
		//in given HTMLDocument Object ignoring inline scripts
		for (Element s : links) {
			if (s.attr("rel") == "stylesheet") {
				Style tempStyle = new Style();
				Path stylePath = Paths.get(s.attr("href"));
				tempStyle.setPath(stylePath);
				styleList.add(tempStyle);
			}
		}
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
		return scriptList;
		
	}
	
	/*
	* 
	*/
	public LinkedList<Anchor> scanForAnchors(Path path) throws IOException{
		return null;
		
	}

}
