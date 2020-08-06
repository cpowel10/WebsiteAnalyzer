package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.Test;



import edu.odu.cs.cs350.Enum.FileType;



public class TestWebsiteFile {

    WebsiteFile webF = new WebsiteFile();
    Path path = Paths.get("noAssignedPath");
    int size = -1;
    FileType type = FileType.UNDEFINED; 

	@Test
	public final void testDefaultConstructor(){
        assertThat(webF.getSize(), is(size));
        assertThat(webF.path(), is(path));
        assertThat(webF.type(), is(type));
    }

    @Test
    public final void testNonDefaultConstructor(){
        int size =  3;
        Path path = Paths.get("fakePath");
        FileType type = FileType.AUDIO;
        WebsiteFile webF = new WebsiteFile(size, path, type);
        assertThat(webF.getSize(), is(size));
        assertThat(webF.path(), is(path));
        assertThat(webF.type(), is(type));
    }
    @Test
	public final void testSetSize(){
        int newSize = 100;

        webF.setSize(newSize);

        assertThat(webF.getSize(), is(newSize));
        assertThat(webF.path(), is(path));
        assertThat(webF.type(), is(type));
    }
    @Test
	public final void testSetPath(){
        Path newPath = Paths.get("newPath");

        webF.setPath(newPath);

        assertThat(webF.getSize(), is(size));
        assertThat(webF.path(), is(newPath));
        assertThat(webF.type(), is(type));
    }
    @Test
	public final void testSetType(){
        FileType newType = FileType.ARCHIVE;

        webF.setType(newType);

        assertThat(webF.getSize(), is(size));
        assertThat(webF.path(), is(path));
        assertThat(webF.type(), is(newType));
    }
}