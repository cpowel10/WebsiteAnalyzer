package edu.odu.cs.cs350;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.Test;
import java.net.URI;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;
import java.util.LinkedList;

public class TestScript {
    @Test
    public final void testDefaultConstructor(){
        LinkedList<Path> list = new LinkedList<Path>();
        Script tag = new Script();
        assertThat(tag.getType(), is(TagType.SCRIPT));
        assertThat(tag.getListings(), is(list));
    }
    @Test
	public final void testNonDefaultConstructor() {
        Path path = Paths.get("testPath");
        Externality ext = Externality.EXTERNAL;
        URI uri = URI.create("fakeURI");
        Script tag = new Script(path, ext, uri);
        assertThat(tag.getPath(), is(path));
        assertThat(tag.getExternality(), is(ext));
        assertThat(tag.getType(), is(TagType.SCRIPT));
        assertThat(tag.getUri(), is(uri));
    }
    @Test
	public final void testSecondNonDefaultConstructor() {
        LinkedList<Path> list = new LinkedList<Path>();
        Path path = Paths.get("testPath");
        Externality ext = Externality.EXTERNAL;
        URI uri = URI.create("fakeURI");
        list.add(path);
        Script tag = new Script(path, ext, path, uri);

        assertThat(tag.getPath(), is(path));
        assertThat(tag.getExternality(), is(ext));
        assertThat(tag.getType(), is(TagType.SCRIPT));
        assertThat(tag.getUri(), is(uri));
        assertThat(tag.getListings(), is(list));
    }
    @Test
    public final void testAddListing(){
        LinkedList<Path> list = new LinkedList<Path>();
        Path path = Paths.get("testPath");
        Externality ext = Externality.EXTERNAL;
        URI uri = URI.create("fakeURI");
        list.add(path);
        Script tag = new Script(path, ext, path, uri);
        list.add(path);
        tag.addListing(path);

        assertThat(tag.getPath(), is(path));
        assertThat(tag.getExternality(), is(ext));
        assertThat(tag.getType(), is(TagType.SCRIPT));
        assertThat(tag.getUri(), is(uri));
        assertThat(tag.getListings(), is(list));
    }
}