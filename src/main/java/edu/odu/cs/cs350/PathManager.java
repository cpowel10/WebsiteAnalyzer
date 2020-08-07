package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URL;
import java.net.URI;
import java.util.Iterator;
import edu.odu.cs.cs350.Enum.Externality;

public class PathManager {
	private Path homeDir;
	private URL[] urls;
	/**
	 * default contructor
	 */
	public PathManager() {
	}
	/**
	 * nondefault constructor
	 * @param home contains home path 
	 * @param theUrls contains the collection of Urls
	 */
	public PathManager(Path home, URL[] theUrls) {
		
		homeDir = home.toAbsolutePath();
		urls = theUrls;
	}
	/**
	 * maps the tag to the uri
	 * @param tag to be mapped
	 * @param pageSrc of the page (HTMLDocument)
	 */
	public void mapAndClassifyTag(Tag tag, Path pageSrc) {
		URI taguri = tag.getUri();
		Path tagLocalPath;
		//Absolute URIs that don't match any of our hosts must be external
		//therefore local path is set to empty
		if(taguri.isAbsolute()) {
			if(isExternalHost(taguri)) {
				tag.setExternality(Externality.EXTERNAL);
				tag.setPath(Paths.get(""));
				return;
			}
			//if absolute URI matches a host strip the root to get its local path
			else {
				tagLocalPath = removeSitePathRoot(Paths.get(taguri.getPath()));
				//Use localPath to determine externality
				tag.setExternality(mapLocalTag(tag, tagLocalPath, pageSrc));
				return;
			}
		}
		//Resolve and normalize relative URIs
		tagLocalPath = Paths.get(taguri.getPath());
		tagLocalPath = expandPath(tagLocalPath, pageSrc);
		System.out.println(tagLocalPath);
		//Use localPath to determine externality
		tag.setExternality(mapLocalTag(tag, tagLocalPath, pageSrc));
	}
	/**
	 * removes the site root from the path
	 * @param tagPath is the path to be manipulated
	 * returns the manipulated path or an empty path if it doesn't contain the site root
	 */
	public Path removeSitePathRoot(Path tagPath) {
		//first check if path starts with site root
		tagPath = tagPath.toAbsolutePath();
		if(tagPath.startsWith(homeDir)) {
			//iterate over name elements in homeDir
			Iterator<Path> it = homeDir.iterator();
			Path p = Paths.get("");
			while(it.hasNext()&&tagPath.getNameCount()>1) {
				p = it.next();
				//remove leading element from tagPath if it matches appropriate homeDir name
				if(tagPath.subpath(0,1).equals(p)) {
					tagPath = tagPath.subpath(1, tagPath.getNameCount());
				}
			}
			//return tagpath with root removed
			return tagPath;
		}
		return Paths.get("");
	}
	/**
	 * classifies a tag and localPath as intra/internal/external to the srcPage/website
	 * while also assigning the tag's path if it is intra/internal
	 * @param tag whose path to check as internal/external
	 * @param pageSrc path to the htmldoc this tag came from
	 */
	public Externality mapLocalTag(Tag tag, Path tagLocalPath, Path pageSrc) {
		//special case for intra-page anchors whose path matches the page
		if(tagLocalPath.equals(pageSrc)) {
			tag.setPath(tagLocalPath);
			return Externality.INTRA;
		}
		//Compare tag's path to homeDir to determine if Internal/External
		if(tag.getPath().toAbsolutePath().startsWith(homeDir)) {
			tag.setPath(tagLocalPath);
			return Externality.INTERNAL;
		}
		//Empty path for external resources (URI is used even for local resources)
		tag.setPath(Paths.get(""));
		return Externality.EXTERNAL;
	}
	/** 
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
	/**
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
	/**
	 * converts URI to a path
	 * @param uri contains to URI to be converted
	 */
	public Path uriToPath(URI uri) {
		Path thepath = Paths.get(uri.getPath());
		return thepath;
	}
	/**
	 * sets home directory
	 * @param home contains path to home directory
	 */
	public void setHome(Path home) {
		homeDir = home.toAbsolutePath();
	}
}
