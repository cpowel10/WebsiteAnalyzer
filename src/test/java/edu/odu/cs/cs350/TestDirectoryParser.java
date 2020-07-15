package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.LinkedList;
import java.util.Iterator;

public class TestDirectoryParser {

    DirectoryParser dparser;

    String homeDir;
    String uri;

    LinkedList<Path> parsedPaths = new LinkedList<Path>();
    LinkedList<Path> expectedPaths = new LinkedList<Path>();

    @Before
    public void setUp() {
        //Paths to 'pages' or HTMLDocuments that the parser should add to be analyzed
        expectedPaths.add(Paths.get("Home/slideshow/SlideShowIndex.html"));
        expectedPaths.add(Paths.get("Home/articles/fire.html"));
        expectedPaths.add(Paths.get("Home/articles/notOnFire.html"));
    }

    @Test
    public void testExpandPath() {
        //Absolute and relative paths to an image
        Path img_absolute_path = Paths.get("Home/Images/slideshow/slide1.png");
        Path img_relative_path = Paths.get("../Images/slideshow/slide1.png");

        //dparser expands relative path to the absolute and compare
        Path expanded_path = dparser.expandPath(img_relative_path);
        boolean sameFile = Files.isSameFile(expanded_path, img_absolute_path);
        assertThat(sameFile, is(true));
    }

    public void testDirectoryList() {
        boolean isPresent;
        //Parse through the local copy of the website for all pages with html content
        dparser.parseWebsiteDirectory(homeDir, uri);
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