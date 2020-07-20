package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class Tag {

	private Path path;
	private TagType type;
	private Externality externality;
	

	public Tag() {
		this.externality = Externality.EXTERNAL;
	}
	public Tag(Path pth, TagType typ, Externality ext) {
		this.externality = Externality.EXTERNAL;
	}
	public Path path() {
		return Paths.get("null");
	}
	public TagType type() {
		return TagType.ANCHOR;
	}
	public Externality externality() {
		return Externality.EXTERNAL;
	}
	public void setPath(Path path) {
		
	}
	public void setType(TagType type) {
		
	}
	public void setExternality(Externality ext) {
		
	}
}
