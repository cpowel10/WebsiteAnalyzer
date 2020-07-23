package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class ArchiveFile extends WebsiteFile {
	public ArchiveFile(int inSize, Path inPath) {
		super(inSize, inPath, FileType.ARCHIVE);
	}

}
