package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;
import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class Tag {
	private Path path;
	private URI uri;
	private TagType type;
	private Externality eality;
	/**
	 * default constructor
	 */
	public Tag() {
		path = Paths.get("");
		type = TagType.UNDEFINED; 
		eality = Externality.UNDEFINED;
	}
	/**
	 * nondefault constructor
	 * @param myType is the tag type (anchor, script, etc) (Enumerated type not string!)
	 */
	public Tag(TagType mytype) {
		path = Paths.get("");
		type = mytype; 
		eality = Externality.UNDEFINED;
	}
	/**
	 * second nondefault constructor
	 * @param myType is the tag type (anchor, script, etc) (Enumerated type not string!)
	 * @param myPath is the path to such tag (of type path)
	 * @param myEality is the externality (internal, interpage, external) (Enumerated type)
	 * @param myUri is the URI of the tag
	 */
	public Tag(TagType myType, Path myPath, Externality myEality, URI myUri) {
		type = myType;
		path = myPath;
		eality = myEality;
		uri = myUri;
	}
	/**
	 * nondefault constructor that PageReader uses to make Raw tags
	 * @param myUri is the URI of the tag
	 */
	public Tag(URI myUri) {
		path = Paths.get("");
		type = TagType.UNDEFINED; 
		eality = Externality.UNDEFINED;
		uri = myUri;
	}
	/**
	 * returns path of tag
	 */
	public Path getPath() {
		return this.path;
	}
	/**
	 * returns Tag type of tag
	 */
	public TagType getType() {
		return this.type;
	}
	/**
	 * returns externality of tag
	 */
	public Externality getExternality() {
		return this.eality;
	}
	/**
	 * returns URI of tag
	 */
	public URI getUri() {
		return this.uri;
	}
	/**
	 * sets path of tag
	 * @param path to tag
	 */
	public void setPath(Path path) {
		this.path = path;
	}
	/**
	 * sets tag type of tag
	 * @param tag type of tag
	 */
	public void setType(TagType type) {
		this.type = type;
	}
	/**
	 * sets externality of tag
	 * @param externality of tag
	 */
	public void setExternality(Externality ext) {
		this.eality = ext;
	}
	/**
	 * overide equals to compare tag equality
	 * @param Object to be compared for equality
	 */
	@Override
	public boolean equals(Object other) {
		if(this == other)
			return true;
		if(!(other instanceof Tag))
			return false;
		Tag otherTag = (Tag) other;
		return this.path.equals(otherTag.getPath());
	}
}
