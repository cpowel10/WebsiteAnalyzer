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
import java.util.Iterator;

public class TestDirectoryParser {

    private DirectoryParser dparser;

    private Path homeDir;
    
    private URL[] urls = new URL[3];
    private URL testurl1;
    private URL testurl2;
    private URL testurl3;
    private URL testurl4;

    private LinkedList<Path> parsedPaths = new LinkedList<Path>();
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

        dparser = new DirectoryParser(homeDir, urls);

    }

    @Test
    public void testSanitizePath() throws IOException {
        //Absolute and relative paths to an image
        Path img_absolute_path = Paths.get("Home/Images/slideshow/slide1.png");
        Path img_relative_path = Paths.get("../Images/slideshow/slide1.png");

        //dparser expands relative path to the absolute and compare
        Path expanded_path = dparser.sanitizePath(img_relative_path);
        boolean sameFile = Files.isSameFile(expanded_path, img_absolute_path);
        assertThat(sameFile, is(true));
    }

    @Test
    public void testMapUrlToPath() throws MalformedURLException {
        Path mappedPath;

        testurl1 = new URL("https://www.example.com/good/test");
        mappedPath = dparser.mapUrlToPath(testurl1);
        assertThat(mappedPath.toString(), is("/good/test"));

        testurl2 = new URL("https://www.example.com/my/test/path/hello");
        mappedPath = dparser.mapUrlToPath(testurl2);
        assertThat(mappedPath.toString(), is("/path/hello"));
        
        testurl3 = new URL("https://www.example.com/outside");
        mappedPath = dparser.mapUrlToPath(testurl3);
        assertThat(mappedPath.toString(), is(equalTo(null)));
        
        testurl4 = new URL("https://www.bad.example.com/my/test");
        mappedPath = dparser.mapUrlToPath(testurl4);
        assertThat(mappedPath.toString(), is(equalTo(null)));
    }

    @Test
    public void testParseWebsiteDirectory() {
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
}