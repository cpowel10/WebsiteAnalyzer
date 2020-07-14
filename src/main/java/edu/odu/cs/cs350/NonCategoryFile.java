package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.FileType;

public class NonCategoryFile extends WebsiteFile {	
	public NonCategoryFile(int inSize, String inPath) {
		super.size = inSize;
		super.path = inPath;
		super.type = FileType.NONCATEGORY;
	}

}
