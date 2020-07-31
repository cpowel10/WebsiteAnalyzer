package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.net.URL;
import java.net.URI;

import java.util.Iterator;

import edu.odu.cs.cs350.Enum.Externality;

public class PathManager {
	private Path homeDir;
	private URL[] urls;
	/*
	 * default contructor
	 */
	public PathManager() {
	}
	/*
	 * nondefault constructor
	 * @param home contains home path 
	 * @param theUrls contains the collection of Urls
	 */
	public PathManager(Path home, URL[] theUrls) {
		
		homeDir = home.toAbsolutePath();
		urls = theUrls;
	}
	/*
	 * maps the tag to the uri
	 * @param tag contains the tag to be mapped
	 * @param pagePath contains the path of the page (HTMLDocument)
	 */
	public void mapTagUri(Tag tag, Path pagePath) {
		URI taguri = tag.getUri();
		if(taguri.isAbsolute()) {
			//check if URI matches any of our URL's hosts
			if(isExternalHost(taguri)) {
				tag.setPath(Paths.get(""));
				return;
			}
			//if absolute URI that does match one of our hosts, remove siteroot from path
			else {
				tag.setPath(removeSitePathRoot(Paths.get(taguri.getPath())));
			}
		}
		else {
			Path tagPath = Paths.get(taguri.getPath());
			tagPath = expandPath(tagPath, pagePath);
			tag.setPath(tagPath);
		}
	}
	/*
	 * removes the site root from the path
	 * @param tagPath is the path to be manipulated
	 * returns the manipulated path
	 */
	public Path removeSitePathRoot(Path tagPath) {
		Iterator<Path> it = homeDir.iterator();
        Path p;
		while(it.hasNext()&&tagPath.getNameCount()>1) {
            p = it.next();
            System.out.println((tagPath.subpath(0,1).equals(p)));
			if(tagPath.subpath(0,1).equals(p)) {
                tagPath = tagPath.subpath(1, tagPath.getNameCount());
                System.out.println(tagPath+"gethere?");
			}
        }
		return tagPath;
	}
	/*
	 * classifies the URI as its externality (intrapage, iternal, external)
	 * @param tagPath contains the path to the tag
	 * @param pagePath contains the path to the page(HTMLDocument)
	 */
	public Externality classifyRelativeUriTag(Path tagPath, Path pagePath) {
		if(tagPath.equals(pagePath)) {
			return Externality.INTRA;
		}
		if(tagPath.toString().equals("")) {
			return Externality.EXTERNAL;
		}
		if(tagPath.startsWith("..")) {
			return Externality.EXTERNAL;
		}
		if(Files.exists(tagPath)) {
			return Externality.INTERNAL;
		}
		return Externality.UNDEFINED;
	}
	/* 
	 * Grabs the Path portion of whatever URL we match to for mapping
	 * @param toCheck contains the URI to be checked 
	 */ 
	public boolean isExternalHost(URI toCheck) {
		for(int i = 0; i < urls.length; i++) {
			if(urls[i].getHost().equals(toCheck.getHost())) {
				return false;
			}
		}
		return true;
	}
	/*
	 * 'Expands' a relative path by resolving against src path and removing
	 * redundant name elements, effectively returns a CanonicalPath
	 * @param toExpand contains the path to be expanded
	 * @param src contains the source path
	 */
	public Path expandPath(Path toExpand, Path src) {
		Path expanded;
		expanded = src.resolveSibling(toExpand.normalize()).normalize();
		return expanded;
	}
	/*
	 * converts URI to a path
	 * @param uri contains to URI to be converted
	 */
	public Path uriToPath(URI uri) {
		Path thepath = Paths.get(uri.getPath());
		return thepath;
	}
}
