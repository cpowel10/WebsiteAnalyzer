package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;
import java.nio.file.Path;

public class Style extends Tag {
	public Style(Path inPath, Externality inEality) {
		// TODO Auto-generated constructor stub
		super.path = inPath;
		super.type = TagType.STYLE;
		super.eality = inEality;
	}

}
