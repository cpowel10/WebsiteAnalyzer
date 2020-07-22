package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;
import java.nio.file.Path;

public class Style extends Tag {
	public Style(Path inPath, Externality inEality) {
		super(inPath, TagType.STYLE, inEality);
	}

}
