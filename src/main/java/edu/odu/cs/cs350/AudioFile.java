package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class AudioFile extends WebsiteFile {
	/*
	 * nondefault contructor
	 * @param inSize contains long of AudioFile size
	 * @param inPath contains path to AudioFile
	 */
	public AudioFile(long inSize, Path inPath) {
		super(inSize, inPath, FileType.AUDIO);
	}

}
