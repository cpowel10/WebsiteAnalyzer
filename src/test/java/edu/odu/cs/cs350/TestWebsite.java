package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class TestWebsite {
    Path path = Paths.get("pathNotSet");
    LinkedList<String> urls = new LinkedList<String>();
    LinkedList<HTMLDocument> pages = new LinkedList<HTMLDocument>();
    LinkedList<AudioFile> audios = new LinkedList<AudioFile>();
    LinkedList<VideoFile> videos = new LinkedList<VideoFile>();
    LinkedList<ArchiveFile> archives = new LinkedList<ArchiveFile>();
    LinkedList<NonCategoryFile> nons = new LinkedList<NonCategoryFile>();
    Website web = new Website();

    @Test
    public final void testDefaultConstructor(){
        assertThat(web.getPath(), is(path));
        assertThat(web.getURLs(), is(urls));
		assertThat(web.getPages(), is(pages));
		assertThat(web.getAudioFiles(), is(audios));
		assertThat(web.getVideoFiles(), is(videos));
		assertThat(web.getNonCatFiles(), is(nons));   
    }
    @Test 
    public final void testSetPath(){
        Path newPath = Paths.get("newPath");

        web.setPath(newPath);

        assertThat(web.getPath(), is(newPath));
        assertThat(web.getURLs(), is(urls));
		assertThat(web.getPages(), is(pages));
		assertThat(web.getAudioFiles(), is(audios));
		assertThat(web.getVideoFiles(), is(videos));
		assertThat(web.getNonCatFiles(), is(nons));   
    }
    @Test 
    public final void testSetURLS(){
        String str = "newUrl";
        urls.add(str);
        urls.add(str);

        web.setURLs(urls);

        assertThat(web.getPath(), is(path));
        assertThat(web.getURLs(), is(urls));
		assertThat(web.getPages(), is(pages));
		assertThat(web.getAudioFiles(), is(audios));
		assertThat(web.getVideoFiles(), is(videos));
        assertThat(web.getNonCatFiles(), is(nons)); 
    }  
    @Test 
    public final void testSetPages(){
        HTMLDocument it = new HTMLDocument(path);
        pages.add(it);
        pages.add(it);

        web.setPages(pages);

        assertThat(web.getPath(), is(path));
        assertThat(web.getURLs(), is(urls));
		assertThat(web.getPages(), is(pages));
		assertThat(web.getAudioFiles(), is(audios));
		assertThat(web.getVideoFiles(), is(videos));
		assertThat(web.getNonCatFiles(), is(nons));      
    }
    @Test 
    public final void testSetAudioFiles(){
        long lng = 10;
        AudioFile it = new AudioFile(lng, path);
        audios.add(it);
        audios.add(it);

        web.setAudioFiles(audios);

        assertThat(web.getPath(), is(path));
        assertThat(web.getURLs(), is(urls));
		assertThat(web.getPages(), is(pages));
		assertThat(web.getAudioFiles(), is(audios));
		assertThat(web.getVideoFiles(), is(videos));
		assertThat(web.getNonCatFiles(), is(nons));      
    }   
     @Test 
    public final void testSetVideoFiles(){
        long lng = 10;
        VideoFile it = new VideoFile(lng, path);
        videos.add(it);
        videos.add(it);

        web.setVideoFiles(videos);

        assertThat(web.getPath(), is(path));
        assertThat(web.getURLs(), is(urls));
		assertThat(web.getPages(), is(pages));
		assertThat(web.getAudioFiles(), is(audios));
		assertThat(web.getVideoFiles(), is(videos));
		assertThat(web.getNonCatFiles(), is(nons));         
    }
    @Test 
    public final void testSetArchiveFiles(){
        long lng = 10;
        ArchiveFile it = new ArchiveFile(lng, path);
        archives.add(it);
        archives.add(it);

        web.setArchiveFiles(archives);

        assertThat(web.getPath(), is(path));
        assertThat(web.getURLs(), is(urls));
		assertThat(web.getPages(), is(pages));
		assertThat(web.getAudioFiles(), is(audios));
		assertThat(web.getVideoFiles(), is(videos));
		assertThat(web.getNonCatFiles(), is(nons));      
    }
    @Test 
    public final void testSetNonCategoryFiles(){
        long lng = 10;
        NonCategoryFile it = new NonCategoryFile(lng, path);
        nons.add(it);
        nons.add(it);

        web.setNonCatFiles(nons);

        assertThat(web.getPath(), is(path));
        assertThat(web.getURLs(), is(urls));
		assertThat(web.getPages(), is(pages));
		assertThat(web.getAudioFiles(), is(audios));
		assertThat(web.getVideoFiles(), is(videos));
		assertThat(web.getNonCatFiles(), is(nons));      
    }
}



