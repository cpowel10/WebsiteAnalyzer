package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;
import java.nio.file.Path;

public class Script extends Tag {	
	public Script(Path inPath, Externality inEality) {
		super.path = inPath;
		super.type = TagType.SCRIPT;
		super.eality = inEality;
	}

}
