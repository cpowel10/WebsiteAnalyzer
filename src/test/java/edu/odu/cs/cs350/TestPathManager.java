package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import edu.odu.cs.cs350.Enum.Externality;

public class TestPathManager {

    private PathManager pman;

    private Path homeDir = Paths.get("home/web").toAbsolutePath();
    
    private URL[] urls = new URL[2];
    private URI testurl1;
    private URI testurl2;
    private URI testurl3;
    private URI testurl4;

    @Before
    public void setUp() throws MalformedURLException {
        urls[0] = new URL("https://www.example.com/hello/world");
        urls[1] = new URL("https://www.febreze.example.com/hello/world");
        pman = new PathManager(homeDir, urls);
    }

    @Test
    public void testExpandPath() throws IOException {
        //Absolute and relative paths to an image
        Path img_absolute_path = homeDir.resolve("Home/Images/slideshow/slide1.png");
        Path img_relative_from = homeDir.resolve("Home/slideshow/SlideshowIndex.html");
        Path img_relative_path = Paths.get("../.././Images/slideshow/slide1.png");

        //pman expands relative path to the absolute and compare
        Path expanded_path = pman.expandPath(img_relative_path, img_relative_from);
        assertThat(expanded_path.toString(), is(img_absolute_path.toString()));
    }

    @Test
    public void testMapAndClassifyTag() throws URISyntaxException{
        Tag tag = new Tag(new URI("page2.html"));
        Path pagePath = Paths.get("articles/page.html");
        pman.mapAndClassifyTag(tag, pagePath);
        assertThat(tag.getPath().toString(), is("articles/page2.html"));
        assertThat(tag.getExternality(), is(Externality.INTERNAL));

        Tag tag2 = new Tag(new URI("../books/book1.html"));
        pman.mapAndClassifyTag(tag2, pagePath);
        assertThat(tag2.getPath().toString(), is("books/book1.html"));
        assertThat(tag2.getExternality(), is(Externality.INTERNAL));

        Tag tag3 = new Tag(new URI("../../outside/website"));
        pman.mapAndClassifyTag(tag3, pagePath);
        assertThat(tag3.getPath().toString(), is("../outside/website"));
        assertThat(tag3.getExternality(), is(Externality.EXTERNAL));

        Tag tag4 = new Tag(new URI("articles/page.html#intraLink"));
        pman.mapAndClassifyTag(tag4, pagePath);
        assertThat(tag4.getPath().toString(), is("articles/page.html"));
        assertThat(tag4.getExternality(), is(Externality.INTRA));
    }

    @Test
    public void testRemoveSitePathRoot() {
        Path tagPath = Paths.get("home/web/this/is/a/test").toAbsolutePath();
        assertThat(pman.removeSitePathRoot(tagPath).toString(), is("this/is/a/test"));

        tagPath = Paths.get("home/external/this/is/a/test").toAbsolutePath();
        assertThat(pman.removeSitePathRoot(tagPath).toString(), is(""));
    }

    @Test
    public void testClassifyRelativeUriTag() {
        //assertThat(pman.classifyRelativeUriTag(Paths.get(""), Paths.get("this/page.html")), is(Externality.EXTERNAL));
        //assertThat(pman.classifyRelativeUriTag(Paths.get("../outside/website/dir"), Paths.get("this/page.html")), is(Externality.EXTERNAL));
        //assertThat(pman.classifyRelativeUriTag(Paths.get("this/page.html"), Paths.get("this/page.html")), is(Externality.INTRA));
        //assertThat(pman.classifyRelativeUriTag(Paths.get("README.md"), Paths.get("this/page.html")), is(Externality.INTERNAL));
        //assertThat(pman.classifyRelativeUriTag(Paths.get("404error"), Paths.get("this/page.html")), is(Externality.UNDEFINED));
    }

    @Test
    public void testMapUrlToPath() throws URISyntaxException {
        Path mappedPath;

        testurl1 = new URI("https://www.example.com/hello/world/this/test/passes");
        mappedPath = pman.uriToPath(testurl1);
        assertThat(mappedPath.toString(), is("this/test/passes"));

        testurl2 = new URI("https://www.febreze.example.com/hello/world/passing/test");
        mappedPath = pman.uriToPath(testurl2);
        assertThat(mappedPath.toString(), is("passing/test"));

        testurl3 = new URI("https://www.example.com/world");
        mappedPath = pman.uriToPath(testurl3);
        assertThat(mappedPath.toString(), is(""));

        testurl4 = new URI("https://www.bad.example.com/my/test");
        mappedPath = pman.uriToPath(testurl4);
        assertThat(mappedPath.toString(), is(""));
    }
}