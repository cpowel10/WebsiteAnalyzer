package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.net.URL;

import java.util.Iterator;

public class PathManager {
	private Path homeDir;
	private URL[] urls;

	public PathManager() {
	}
	
	public PathManager(Path home, URL[] theurls) {
		homeDir = home;
		urls = theurls;
	}

	/*
	 * Checks a url against the provided urls to be analyzed
	 * if internal url, the site root is removed and remaining path returned
	 * if external, returns an empty path
	 */
	public Path mapUrlToPath (URL toMap) {
		Path mappedPath = Paths.get("");
		Path internalPath = matchHost(toMap);
		Path toMapPath = Paths.get(toMap.getPath());
		
		//Iterate over name elements of the internalURL
		Iterator<Path> it = internalPath.iterator();
		while(it.hasNext()&&toMapPath.getNameCount()>0)
		{
			//if the first name elements match, remove it
			if(toMapPath.subpath(0, 1).equals(it.next()))
			{
				toMapPath = toMapPath.subpath(1, toMapPath.getNameCount());
				mappedPath = toMapPath;
			}
			else
				return mappedPath;
		}
		return mappedPath;
	}

	/* 
	 * Grabs the Path portion of whatever URL we match to for mapping
	 */ 
	public Path matchHost (URL toMap) {
		Path matchedPath = Paths.get("");
		for(URL internalURL : urls)
			if(internalURL.getHost().equals(toMap.getHost()))
				matchedPath = Paths.get(internalURL.getPath());
		return matchedPath;
	}

	/*
	 * Transmutes any relative paths to absolute and removes redunant name elements
	 */
	public Path sanitizePath(Path p) {
		Path expanded;
		expanded = p.normalize().toAbsolutePath();
		return expanded;
	}

	public Path urlToPath(URL url) {
		Path thepath = Paths.get(url.getPath());
		sanitizePath(thepath);
		return thepath;
	}
}
