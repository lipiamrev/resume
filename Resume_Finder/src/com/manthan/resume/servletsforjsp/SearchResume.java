package com.manthan.resume.servletsforjsp;

import com.manthan.resume.bean.Resumebean;
import com.manthan.resume.readimplementation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")

public class SearchResume extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		String keyword = request.getParameter("searchfile");

		File dir = new File("D:\\UploadResume");

		ArrayList<Resumebean> filelist = new ArrayList<ResumeBean>();

		if(dir.isDirectory()){
			File[] listFiles = dir.listFiles();

			for(File file : listFiles){
				if(file.isFile()) {
					filelist.addAll(file);
				}
			}
		}

		PDFRead pdf_read = new PDFRead();

		Resumebean resume_bean = null;

		if (resume_bean.getFile_name() != null &&
				resume_bean.getName() != null &&
				resume_bean.getEmail() != null ) {

			filelist.add(resume_bean);
		}

		if (filelist.isEmpty()) {
			request.setAttribute("message", "No records found");
		} else {
			request.setAttribute("filelist", filelist);
		}
		request.getRequestDispatcher("/search").forward(request, response);


	}
}

