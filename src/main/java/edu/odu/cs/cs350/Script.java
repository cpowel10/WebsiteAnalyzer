package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class Script extends Tag {	
	public Script(String inPath, Externality inEality) {
		super.path = inPath;
		super.type = TagType.SCRIPT;
		super.eality = inEality;
	}

}
