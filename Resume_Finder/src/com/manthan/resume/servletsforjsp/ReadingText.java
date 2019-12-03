package com.manthan.resume.servletsforjsp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class ReadingText {

   public static void main(String args[]){
	   
	   File f = new File("C:\\");
	   ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
	   
	    Scanner fileinput = new Scanner((Readable) files);

	    //create array list  to hold text files 

	    ArrayList<Object> txtfiles = new ArrayList<Object>();


	    //read through  and find text files

	    while(fileinput.hasNext()){
	        //get the next file

	        Object nextfile = fileinput.next();

	        //Determine if file is in  the array list

	        if (txtfiles.contains(nextfile)) {
	            int index = txtfiles.indexOf(nextfile);

	        }
	        else {
	            txtfiles.add(nextfile);

	        }
	    }
	        //close streams
	        fileinput.close();
	        try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

	        //print result
	        for (int i = 0; i < txtfiles.size(); i++){
	            System.out.println(Arrays.asList(txtfiles));
	        }

	}}

//	   File dir = new File("D:\\Resume");
//	      FilenameFilter filter = new FilenameFilter() {
//	         public boolean accept (File dir, String name) { 
//	            return name.startsWith("b");
//	         } 
//	      }; 
//	      String[] children = dir.list(filter){
//	      if (children == null) {
//	         System.out.println("Either dir does not exist or is not a directory"); 
//	      } else { 
//	         for (int i = 0; i< children.length; i++) {
//	            String filename = children[i];
//	            System.out.println(filename);
//	         } 
//	      } 
//   };
//}