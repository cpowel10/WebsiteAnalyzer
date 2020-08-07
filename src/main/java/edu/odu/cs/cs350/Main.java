package edu.odu.cs.cs350;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;

import edu.odu.cs.cs350.*;
//import jdk.tools.jlink.internal.Archive;
import edu.odu.cs.cs350.Enum.Externality;
//import jdk.tools.jlink.internal.Archive;

public class Main {
    public static void main(String[] args) throws IOException {
        //ReportGenerator that makes our reports
        ReportGenerator generate = new ReportGenerator();
        generate.setTime(); //This needs to be done at the start 
        
        //First InputHandler will check arguments for errors and otherwise prepare/sanitize inputs
        //Passes to DirectoryParser to begin populating list of file paths
        
        InputHandler ioHandler = new InputHandler();
        ioHandler.getInput(args);
        DirectoryParser dparser = new DirectoryParser(ioHandler.getDirectory());

        //For now this prints out files that will be sorted and also scanned for HTML content
        //DirectoryParser dparser = new DirectoryParser(Paths.get(args[0]));
        dparser.parseWebsiteDirectory();
        dparser.categorizeFiles();
        //System.out.println("Files that would be scanned for HTML content and sorted:");
        //for(Path doc : dparser.getPages())
        //    System.out.println(doc.toString());

        /* Dparser will populate a list of htmlpages and make the website
        *  website will ask its pageReader to scan its pages for tags
        */
        Website site = new Website();
        site.setPath(ioHandler.getDirectory());
        site.setURLs(ioHandler.getUrls());
        LinkedList<Path> htmlPaths = (LinkedList<Path>) dparser.getPages();
        LinkedList<HTMLDocument> htmlDocs = new LinkedList<HTMLDocument>();
        for (Path p : htmlPaths) {
        	HTMLDocument tempHTML = new HTMLDocument(p);
        	PageReader reader = new PageReader();
        	LinkedList<Image> tempImages = reader.scanForImages(p);
        	tempHTML.setImages(tempImages);
        	LinkedList<Script> tempScripts = reader.scanForScripts(p);
        	tempHTML.setScripts(tempScripts);
        	LinkedList<Style> tempStyles = reader.scanForStyles(p);
        	tempHTML.setStyles(tempStyles);
        	LinkedList<Anchor> tempAnchors = reader.scanForAnchors(p);
        	tempHTML.setAnchors(tempAnchors);
        	htmlDocs.add(tempHTML);
        }
        site.setPages(htmlDocs);
        site.setAudioFiles(dparser.getAudios());
        site.setVideoFiles(dparser.getVideos());
        site.setArchiveFiles(dparser.getArchives());
        site.setNonCatFiles(dparser.getNonCats());
        
        //dparser.generateWebsite();
        //Website site = dparser.getWebsite();
        //site.scanForTags();    //This will call the site's PageReader to call scanForImages, and other scanners, to populate the HTMLDocuments of the site with tags
        

        //Hard coding a website with a couple Pages for now
//        Website site = new Website();
//        Path myPath = Paths.get("myFakeBasePath");
//        site.setPath(myPath);
//        LinkedList<String> myURLS = new LinkedList<String>();
//        myURLS.add("fakeURL0");
//        myURLS.add("fakeURL1");
//        myURLS.add("fakeURL2");
//        site.setURLs(myURLS);
//        myPath = Paths.get("myFakePagePath");
//        LinkedList<HTMLDocument> pages = new LinkedList<HTMLDocument>();
//        for(int i = 0; i < 3; i++){
//            myPath = Paths.get("myFakePagePath" + String.valueOf(i));
//            pages.add(new HTMLDocument(myPath));
//        }
//        //Hard coding the paths to a couple of images placed in a /path folder
//        //Analyzer will be able to look for these and populate the ImgSize for each page
//        for(int i = 0; i < pages.size(); i++)
//        {
//            HTMLDocument htmldoc = pages.get(i);
//            //if(i==0)
//            //    htmldoc.setPath(Paths.get("z" + String.valueOf(i)));
//            //if(i==1)
//            //    htmldoc.setPath(Paths.get("a" + String.valueOf(i)));
//            //if(i==2)
//            //    htmldoc.setPath(Paths.get("b" + String.valueOf(i)));
//
//            //Adds a couple of hardcoded images to the pages, each will have a different size
//            Image img0 = new Image();
//            img0.setPath(Paths.get("src/test/data/img0.png"));
//            img0.setSize(1000000);
//            img0.setNumPages(7);
//            img0.addListing(Paths.get("listing0"));
//            img0.setExternality(Externality.INTERNAL);
//            Image img1 = new Image();
//            img1.setPath(Paths.get("src/test/data/img1.png"));
//            img1.setSize(2000000);
//            img1.setNumPages(17);
//            img1.addListing(Paths.get("listing1"));
//            img1.setExternality(Externality.EXTERNAL);
//            Image img2 = new Image();
//            img2.setPath(Paths.get("src/test/data/img2.png"));
//            img2.setSize(3000000);
//            img2.setNumPages(27);
//            img2.addListing(Paths.get("listing2"));
//            img2.setExternality(Externality.INTERNAL);
//
//            Style sty0 = new Style(Paths.get("fakepath"), Externality.INTERNAL, Paths.get("fakepath"), URI.create("fakeURI?"));
//            Style sty1 = new Style(Paths.get("fakepath"), Externality.INTERNAL, Paths.get("fakepath"), URI.create("fakeURI?"));
//            Style sty2 = new Style(Paths.get("fakepath"), Externality.INTERNAL, Paths.get("fakepath"), URI.create("fakeURI?"));
//            Anchor anc0 = new Anchor(Paths.get("fakepath"), Externality.INTERNAL, URI.create("fakeURI?"));
//            Anchor anc1 = new Anchor(Paths.get("fakepath"), Externality.INTERNAL, URI.create("fakeURI?"));
//            Anchor anc2 = new Anchor(Paths.get("fakepath"), Externality.INTERNAL, URI.create("fakeURI?"));
//            Script scr0 = new Script(Paths.get("fakepath"), Externality.INTERNAL, Paths.get("fakepath"), URI.create("fakeURI?"));
//            Script scr1 = new Script(Paths.get("fakepath"), Externality.INTERNAL, Paths.get("fakepath"), URI.create("fakeURI?"));
//            Script scr2 = new Script(Paths.get("fakepath"), Externality.INTERNAL, Paths.get("fakepath"), URI.create("fakeURI?"));
//        
//            if(i==0){
//                htmldoc.addImage(img0);
//                htmldoc.addElement(sty0);
//                htmldoc.addElement(anc0);
//                htmldoc.addElement(scr0);
//            }
//            if(i==1) {
//                htmldoc.addImage(img0);
//                htmldoc.addImage(img1);
//                htmldoc.addElement(sty0);
//                htmldoc.addElement(anc0);
//                htmldoc.addElement(scr0);
//                htmldoc.addElement(sty1);
//                htmldoc.addElement(anc1);
//                htmldoc.addElement(scr1);
//                
//            }
//            if(i==2) {
//                htmldoc.addImage(img0);
//                htmldoc.addImage(img1);
//                htmldoc.addImage(img2);
//                htmldoc.addElement(sty0);
//                htmldoc.addElement(anc0);
//                htmldoc.addElement(scr0);
//                htmldoc.addElement(sty1);
//                htmldoc.addElement(anc1);
//                htmldoc.addElement(scr1);
//                htmldoc.addElement(sty2);
//                htmldoc.addElement(anc2);
//                htmldoc.addElement(scr2);
//            }
//            htmldoc.setAnchorTypeCounters();
//        }
//        site.setPages(pages);
//        ArchiveFile arc0 = new ArchiveFile(1000000, Paths.get("src/test/data/img0.png"));
//        ArchiveFile arc1 = new ArchiveFile(2000000, Paths.get("src/test/data/img1.png"));
//        ArchiveFile arc2 = new ArchiveFile(3000000, Paths.get("src/test/data/img2.png"));
//        VideoFile vid0 = new VideoFile(1000000, Paths.get("src/test/data/img0.png"));
//        VideoFile vid1 = new VideoFile(2000000, Paths.get("src/test/data/img1.png"));
//        VideoFile vid2 = new VideoFile(3000000, Paths.get("src/test/data/img2.png"));
//        AudioFile aud0 = new AudioFile(1000000, Paths.get("src/test/data/img0.png"));
//        AudioFile aud1 = new AudioFile(2000000, Paths.get("src/test/data/img1.png"));
//        AudioFile aud2 = new AudioFile(3000000, Paths.get("src/test/data/img2.png"));
//        NonCategoryFile non0 = new NonCategoryFile(1000000, Paths.get("src/test/data/img0.png"));
//        NonCategoryFile non1 = new NonCategoryFile(2000000, Paths.get("src/test/data/img1.png"));
//        NonCategoryFile non2 = new NonCategoryFile(3000000, Paths.get("src/test/data/img2.png"));
//        LinkedList<ArchiveFile> arcFiles = new LinkedList<ArchiveFile>();
//        LinkedList<VideoFile> vidFiles = new LinkedList<VideoFile>();
//        LinkedList<AudioFile> audFiles = new LinkedList<AudioFile>();
//        LinkedList<NonCategoryFile> nonFiles = new LinkedList<NonCategoryFile>();
//        arcFiles.add(arc0);
//        arcFiles.add(arc1);
//        arcFiles.add(arc2);
//        vidFiles.add(vid0);
//        vidFiles.add(vid1);
//        vidFiles.add(vid2);
//        audFiles.add(aud0);
//        audFiles.add(aud1);
//        audFiles.add(aud2);
//        nonFiles.add(non0);
//        nonFiles.add(non1);
//        nonFiles.add(non2);
//        site.setArchiveFiles(arcFiles);
//        site.setVideoFiles(vidFiles);
//        site.setAudioFiles(audFiles);
//        site.setNonCatFiles(nonFiles);
        //This analyzer will begin analyzing the website that is created
        Analyzer ana = new Analyzer(site);

        //Begins Image analysis
        ana.analyzeWebsite();


        //Give it the website and generate reports
        //generate.generateText(ana.getWebsite());
        generate.generateText(ana.getWebsite());
        generate.generateXls(ana.getWebsite());
        generate.generateJson(ana.getWebsite());
    }
}