package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

import java.nio.file.Path;

public class Anchor extends Tag {
	public Anchor() {
		super();
		this.setType(TagType.ANCHOR);
	}
	
	public Anchor(Path inPath, Externality inEality) {
		super(inPath, TagType.ANCHOR, inEality);
	}

}
