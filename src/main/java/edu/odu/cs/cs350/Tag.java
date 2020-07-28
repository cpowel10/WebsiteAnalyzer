package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class Tag {
	private Path path;
	private TagType type;
	private Externality eality;

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

	public Path getPath() {
		return this.path;
	}

	public TagType getType() {
		return this.type;
	}

	public Externality getExternality() {
		return this.eality;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public void setType(TagType type) {
		this.type = type;
	}

	public void setExternality(Externality ext) {
		this.eality = ext;
	}

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
