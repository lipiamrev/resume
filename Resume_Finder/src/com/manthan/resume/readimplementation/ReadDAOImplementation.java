package com.manthan.resume.readimplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import com.manthan.resume.bean.Resumebean;
import com.manthan.resume.servletsforjsp.ResumeBean;

public class ReadDAOImplementation implements ReadDAO {
	
	@Override
	public Resumebean PDFRead(File file, String searchfile) throws IOException {
		
		Resumebean resume_bean = new Resumebean();

		    PDDocument document = PDDocument.load(file);

		    //Instantiate PDFTextStripper class
		    PDFTextStripper pdfStripper = new PDFTextStripper();

		    //Retrieving text from PDF document
		    String text = pdfStripper.getText(document);
		    
		    String lineText = text.replaceAll("\n", " ").replaceAll("\r", " ").toLowerCase();
		    
		    if(lineText.contains(searchfile)) 
		    {
				String email=null;
			String[] arr = lineText.split(" ");
			
			for(String s:arr) {
		        String patternString1 ="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		        Pattern pattern = Pattern.compile(patternString1);
		        Matcher matcher = pattern.matcher(s);
			
			
			while(matcher.find()) {
	            email = matcher.group();
	        }
			
			resume_bean.setName(file.getName());
			resume_bean.setFile_name(file.getName());
			resume_bean.setEmail(email);
			}
			}
		    //Closing the document
		    try {
				document.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		    return resume_bean;
		}

	@Override
	public Resumebean DOCRead(File file, String searchfile) {
		
		Resumebean resume_bean = new Resumebean();
		return resume_bean;
	}
	}
