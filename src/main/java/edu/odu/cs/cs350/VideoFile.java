package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.FileType;

public class VideoFile extends WebsiteFile {
	public VideoFile(int inSize, String inPath) {
		super.size = inSize;
		super.path = inPath;
		super.type = FileType.VIDEO;
	}

}
