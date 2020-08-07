package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class ArchiveFile extends WebsiteFile {
	/**
	 * nondefault constructor
	 * @param inSize contains size of ArchiveFile
	 * @param inPath contains path to ArchiveFile
	 */
	public ArchiveFile(long inSize, Path inPath) {
		super(inSize, inPath, FileType.ARCHIVE);
	}
}
