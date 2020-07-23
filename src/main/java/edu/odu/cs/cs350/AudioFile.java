package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class AudioFile extends WebsiteFile {
	public AudioFile(int inSize, Path inPath) {
		super(inSize, inPath, FileType.AUDIO);
	}

}
