package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

import java.net.URI;

import java.nio.file.Path;

public class Anchor extends Tag {
	public Anchor() {
		super(TagType.ANCHOR);
	}
	
	public Anchor(Path myPath, Externality myEality, URI myUri) {
		super(TagType.ANCHOR, myPath, myEality, myUri);
	}
}
