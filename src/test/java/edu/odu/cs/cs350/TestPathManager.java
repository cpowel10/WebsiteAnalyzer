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

public class TestPathManager {

    private PathManager pman;

    private Path homeDir;
    
    private URL[] urls = new URL[2];
    private URL testurl1;
    private URL testurl2;
    private URL testurl3;
    private URL testurl4;

    @Before
    public void setUp() throws MalformedURLException {
        urls[0] = new URL("https://www.example.com/hello/world");
        urls[1] = new URL("https://www.febreze.example.com/hello/world");
        pman = new PathManager(homeDir, urls);
    }

    @Test
    public void testSanitizePath() throws IOException {
        //Absolute and relative paths to an image
        Path img_absolute_path = Paths.get("Home/Images/slideshow/slide1.png");
        Path img_relative_path = Paths.get("../Images/slideshow/slide1.png");

        //pman expands relative path to the absolute and compare
        Path expanded_path = pman.sanitizePath(img_relative_path);
        boolean sameFile = Files.isSameFile(expanded_path, img_absolute_path);
        assertThat(sameFile, is(true));
    }

    @Test
    public void testMapUrlToPath() throws MalformedURLException {
        Path mappedPath;

        testurl1 = new URL("https://www.example.com/hello/world/this/test/passes");
        mappedPath = pman.mapUrlToPath(testurl1);
        assertThat(mappedPath.toString(), is("this/test/passes"));

        testurl2 = new URL("https://www.febreze.example.com/hello/world/passing/test");
        mappedPath = pman.mapUrlToPath(testurl2);
        assertThat(mappedPath.toString(), is("passing/test"));
        
        testurl3 = new URL("https://www.example.com/world");
        mappedPath = pman.mapUrlToPath(testurl3);
        assertThat(mappedPath.toString(), is(""));
        
        testurl4 = new URL("https://www.bad.example.com/my/test");
        mappedPath = pman.mapUrlToPath(testurl4);
        assertThat(mappedPath.toString(), is(""));
    }
}