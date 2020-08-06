package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.Test;

import edu.odu.cs.cs350.Enum.FileType;

public class TestNonCategoryFile {

    @Test
	public final void testNonDefaultConstructor() {
        long size = 8;
        Path path = Paths.get("testPath");
        NonCategoryFile vid = new NonCategoryFile(size, path);
        assertThat(vid.getSize(), is(size));
        assertThat(vid.path(), is(path));
        assertThat(vid.type(), is(FileType.NONCATEGORY));
	}

}
