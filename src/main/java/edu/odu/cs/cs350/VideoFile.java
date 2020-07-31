package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class VideoFile extends WebsiteFile {
	/*
	 * nondefault constructor,
	 * no default constructor because videoFiles should not exist without a size and path
	 */
	public VideoFile(long inSize, Path inPath) {
		super(inSize, inPath, FileType.VIDEO);
	}

}
