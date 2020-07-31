package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;

import edu.odu.cs.cs350.Enum.FileType;

public class WebsiteFile {
	private long size;
	private Path path;
	private FileType type;
	/*
	 * default constructor
	 */
	public WebsiteFile() {
		this.setPath(Paths.get("noAssignedPath")); 
		this.setSize(-1);
		this.setType(FileType.UNDEFINED);
	}
	/*
	 * nondefault constructor
	 * @param size contains size of Website file
	 * @param path contains path to website file
	 * @param type contains filetype of website file (video, archive, audio, noncategory)
	 */
	public WebsiteFile(long size, Path path, FileType type) {
		this.setSize(size);
		this.setPath(path);
		this.setType(type);
	}
	/*
	 * sets size of website file
	 * @param size contains long to set size to
	 */
	public void setSize(long size) {
		this.size = size;
	}
	/*
	 * sets path of website file
	 * @param path contains path to website file
	 */
	public void setPath(Path path) {
		this.path = path;
	}
	/*
	 * sets type of website file
	 * @param type contains type of website file (video, archive,...)
	 */
	public void setType(FileType type) {
		this.type = type;
	}
	/*
	 * returns size of website file
	 */
	public long getSize() {
		return this.size;
	}
	/*
	 * returns path of website file
	 */
	public Path path() {
		return this.path;
	}
	/*
	 * returns file type of website file
	 */
	public FileType type() {
		return this.type;
	}
}
