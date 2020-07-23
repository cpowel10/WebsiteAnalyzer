package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class VideoFile extends WebsiteFile {
	public VideoFile(int inSize, Path inPath) {
		super(inSize, inPath, FileType.VIDEO);
	}

}
