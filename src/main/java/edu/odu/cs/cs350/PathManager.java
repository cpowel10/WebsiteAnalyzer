package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.net.URL;

import java.util.Iterator;

public class PathManager {

	private Path homeDir;
	private URL[] urls;

	public PathManager(Path home, URL[] theurls) {
		homeDir = home;
		urls = theurls;
	}
	/*
	 * Checks a url against the provided urls to be analyzed
	 * if internal url, the site root is removed and remaining path returned
	 * null if otherwise
	 */
	public Path mapUrlToPath (URL toMap) {
		Path mappedPath = null;
		for(URL internalURL : urls)
		{
			if(internalURL.getHost().equals(toMap.getHost()))
			{
				//If the hosts match, grab their paths
				mappedPath = Paths.get((toMap.getPath()));
				Path internalPath = Paths.get(internalURL.getPath());

				Iterator<Path> it = internalPath.iterator();
				//Iterate over name elements of the internalURL
				while(it.hasNext())
				{
					//if the first name element matches, remove it from the mappedPath
					if(mappedPath.startsWith(it.next()))
						mappedPath = mappedPath.subpath(1, mappedPath.getNameCount());
					else
						return mappedPath;
				}
			}
		}
		return mappedPath;
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
