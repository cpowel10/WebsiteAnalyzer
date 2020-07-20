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
		this.setPath(Paths.get("noAssignedPath")); 
		this.setType(TagType.STYLE); 
		this.setExternality(Externality.EXTERNAL);
	}
	public Tag(Path pth, TagType typ, Externality ext) {
		this.setPath(pth); 
		this.setType(typ); 
		this.setExternality(ext);
		}
	public Path path() {
		return this.path;
	}
	public TagType type() {
		return this.type;
	}
	public Externality externality() {
		return this.externality;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	public void setType(TagType type) {
		this.type = type;
	}
	public void setExternality(Externality ext) {
		this.externality = ext;
	}
}
