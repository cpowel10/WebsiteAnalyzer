package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.Test;
import java.net.URI;

import edu.odu.cs.cs350.Enum.Externality;
import edu.odu.cs.cs350.Enum.TagType;

public class TestAnchor {

    @Test
    public final void testDefaultConstructor(){
        Anchor tag = new Anchor();
        assertThat(tag.getType(), is(TagType.ANCHOR));
    }
    @Test
	public final void testNonDefaultConstructor() {
        Path path = Paths.get("testPath");
        Externality ext = Externality.EXTERNAL;
        URI uri = URI.create("fakeURI");
        Anchor tag = new Anchor(path, ext, uri);
        assertThat(tag.getPath(), is(path));
        assertThat(tag.getExternality(), is(ext));
        assertThat(tag.getType(), is(TagType.ANCHOR));
        assertThat(tag.getUri(), is(uri));
	}

}
