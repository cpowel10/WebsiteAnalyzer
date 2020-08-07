package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;
import java.net.URI;
import java.nio.file.Path;

public class Anchor extends Tag {
	/**
	 * default contructor
	 */
	public Anchor() {
		super(TagType.ANCHOR);
	}
	/**
	 * nondefault constructor
	 * @param myPath contains path to anchor tag
	 * @param myEality contains externality of tag (internal, intrapage, external)
	 * @param myUri contains Uri to anchor tag
	 */	
	public Anchor(Path myPath, Externality myEality, URI myUri) {
		super(TagType.ANCHOR, myPath, myEality, myUri);
	}
}
