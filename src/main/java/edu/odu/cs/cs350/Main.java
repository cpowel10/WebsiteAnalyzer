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
        //site.scanForTags();    
        //This will call the site's PageReader to call scanForImages, and other scanners, to populate the HTMLDocuments of the site with tags
        //This analyzer will begin analyzing the website that is created
        Analyzer ana = new Analyzer(site);

        //Begins Image analysis
        ana.analyzeWebsite();


        //Give it the website and generate reports
        generate.generateText(ana.getWebsite());
        generate.generateXls(ana.getWebsite());
        generate.generateJson(ana.getWebsite());
    }
}