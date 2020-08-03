package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class TestDirectoryParser {

    private DirectoryParser dparser;

    private Path homeDir;
    
    private URL[] urls = new URL[3];
    private URL testurl1;
    private URL testurl2;
    private URL testurl3;
    private URL testurl4;

    private List<Path> parsedPaths;
    private LinkedList<Path> expectedPaths = new LinkedList<Path>();

    @Before
    public void setUp() throws MalformedURLException {
        //Paths to 'pages' or HTMLDocuments that the parser should add to be analyzed
        expectedPaths.add(Paths.get("Home/slideshow/SlideShowIndex.html"));
        expectedPaths.add(Paths.get("Home/articles/fire.html"));
        expectedPaths.add(Paths.get("Home/articles/notOnFire.html"));
        
        urls[0] = new URL("https://www.example.com/hello/world");
        urls[1] = new URL("https://www.example.com/my/test");
        urls[2] = new URL("https://www.example.com/my/test/path");

        dparser = new DirectoryParser(homeDir);

    }
    @Test
    public void testParseWebsiteDirectory() throws IOException {
        boolean isPresent;
        //Parse through the local copy of the website for all pages with html content
        dparser.parseWebsiteDirectory();
        parsedPaths = dparser.getPages();

        //For every expected path, remove it from list of parsed paths
        for(Path p : expectedPaths)
        {
            //must have parsed an expected path
            isPresent = parsedPaths.contains(p);
            assertThat(isPresent, is(true));

            //remove (1) instance of the expected path
            if(isPresent)
                parsedPaths.remove(p);
        }
        //no path should be leftover
        assertThat(parsedPaths.isEmpty(), is(true));
    }
    @Test
    public void testGetExtension() {
        Path p = Paths.get("this/is/a/path.html");
        assertThat(dparser.getExtension(p), is("html"));
        
        p = Paths.get("video.mp4");
        assertThat(dparser.getExtension(p), is("mp4"));

        p = Paths.get("noExtension");
        assertThat(dparser.getExtension(p), is("noExtension"));
    }
}