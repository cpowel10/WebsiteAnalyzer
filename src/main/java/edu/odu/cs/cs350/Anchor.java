package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class Anchor extends Tag {	
	public Anchor(String inPath, Externality inEality) {
		super.path = inPath;
		super.type = TagType.ANCHOR;
		super.eality = inEality;
	}

}
