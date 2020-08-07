package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class VideoFile extends WebsiteFile {
	/**
	 * nondefault constructor,
	 * no default constructor because videoFiles should not exist without a size and 
	 * @param inSize contains size of video file
	 * @param inPath contains path to video file
	 */
	public VideoFile(long inSize, Path inPath) {
		super(inSize, inPath, FileType.VIDEO);
	}

}
