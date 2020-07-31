package edu.odu.cs.cs350;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;

import java.util.LinkedList;

import edu.odu.cs.cs350.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //First InputHandler will check arguments for errors and otherwise prepare/sanitize inputs
        //Passes to DirectoryParser to begin populating list of file paths

        //InputHandler ioHandler = new InputHandler;
        //ioHandler.checkInput(args);
        //DirectoryParser dparser = new DirectoryParser(ioHandler.getHome(), ioHandler.getUrls());

        //For now this prints out files that will be sorted and also scanned for HTML content
        //DirectoryParser dparser = new DirectoryParser(Paths.get(args[0]));
        //dparser.parseWebsiteDirectory();
        //System.out.println("Files that would be scanned for HTML content and sorted:");
        //for(Path doc : dparser.getPages())
        //    System.out.println(doc.toString());

        /* Dparser will populate a list of htmlpages and make the website
        *  website will ask its pageReader to scan its pages for tags
        *
        * dparser.generateWebsite();
        * Website site = dparser.getWebsite();
        * site.scanForTags();    //This will call the site's PageReader to call scanForImages, and other scanners, to populate the HTMLDocuments of the site with tags
        */

        //Hard coding a website with a couple Pages for now
        Website site = new Website();
        LinkedList<HTMLDocument> pages = new LinkedList<HTMLDocument>();
        for(int i = 0; i < 3; i++)
            pages.add(new HTMLDocument());

        //Hard coding the paths to a couple of images placed in a /path folder
        //Analyzer will be able to look for these and populate the ImgSize for each page
        for(int i = 0; i < pages.size(); i++)
        {
            HTMLDocument htmldoc = pages.get(i);
            if(i==0)
                htmldoc.setPath(Paths.get("z"));
            if(i==1)
                htmldoc.setPath(Paths.get("a"));
            if(i==2)
                htmldoc.setPath(Paths.get("b"));

            //Adds a couple of hardcoded images to the pages, each will have a different size
            Image img0 = new Image();
            img0.setPath(Paths.get("src/test/data/img0.png"));
            Image img1 = new Image();
            img1.setPath(Paths.get("src/test/data/img1.png"));
            Image img2 = new Image();
            img2.setPath(Paths.get("src/test/data/img2.png"));
        
            if(i==0)
                htmldoc.addImage(img0);
            if(i==1) {
                htmldoc.addImage(img0);
                htmldoc.addImage(img1);
            }
            if(i==2) {
                htmldoc.addImage(img0);
                htmldoc.addImage(img1);
                htmldoc.addImage(img2);
            }
        }
        site.setPages(pages);

        //This analyzer will begin analyzing the website that is created
        Analyzer ana = new Analyzer(site);

        //Begins Image analysis
        //ana.analyzeImages(ana.getWebsite());

        //ReportGenerator that makes our reports
        ReportGenerator generate = new ReportGenerator();

        //Give it the website and generate reports
        generate.generateText(ana.getWebsite());
        generate.generateXls(ana.getWebsite());
        generate.generateJson(ana.getWebsite());
    }
}