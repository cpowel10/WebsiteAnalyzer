package edu.odu.cs.cs350;

import java.util.Collection;
import edu.odu.cs.cs350.Enum.TagType;

public class Image extends Tag {
	private TagType type = TagType.IMAGE;
	private int size;
	private Collection<String> listings;
	private int numPages;
	private Collection<String> pagesOn;
	
	public Image() {
		// TODO Auto-generated constructor stub
	}

}
