package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;

import edu.odu.cs.cs350.Enum.FileType;

public class WebsiteFile {
	private int size;
	private Path path;
	private FileType type;
	
	public WebsiteFile() {
		this.setPath(Paths.get("noAssignedPath")); 
		this.setSize(-1);
		this.setType(FileType.AUDIO);
	}
	
	public WebsiteFile(int size, Path path, FileType type) {
		this.setSize(size);
		this.setPath(path);
		this.setType(type);
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setPath(Path path) {
		this.path = path;
	}
	
	public void setType(FileType type) {
		this.type = type;
	}
	
	public int size() {
		return this.size;
	}
	
	public Path path() {
		return this.path;
	}
	
	public FileType type() {
		return this.type;
	}
}
