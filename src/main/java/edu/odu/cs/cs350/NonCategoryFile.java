package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class NonCategoryFile extends WebsiteFile {	
	public NonCategoryFile(long inSize, Path inPath) {
		super(inSize, inPath, FileType.NONCATEGORY);
	}

}
