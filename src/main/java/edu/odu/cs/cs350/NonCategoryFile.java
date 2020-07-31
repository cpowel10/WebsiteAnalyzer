package edu.odu.cs.cs350;

import java.nio.file.Path;

import edu.odu.cs.cs350.Enum.FileType;

public class NonCategoryFile extends WebsiteFile {	
	/*
	 * nondefault constructor
	 * @param inSize contains a long of the size of the non-category file
	 * @param inPath contains path to non-category file
	 */
	public NonCategoryFile(long inSize, Path inPath) {
		super(inSize, inPath, FileType.NONCATEGORY);
	}

}
