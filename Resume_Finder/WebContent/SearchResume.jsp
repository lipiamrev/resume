<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String msg = (String) request.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./uploadResume" style="margin-left: 90%">Upload Resume</a>

	<div align="center">
		<h2>Search Resume</h2>
	</div>
	<br>
	<form action="/search" method="GET" style="margin-left: 42%"
		name="searchfile">
		<input type="text" placeholder="Search" name="keywords"> <input
			type="submit" value="Search">
	</form>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<%=msg%>
	<%
		}
	%>

	<%
		if (filelist != null) {
	%>
	<table>
		<tr>
			<th>FileName</th>
			<th>Name</th>
			<th>Email_ID</th>
			<th>Download link</th>
		</tr>
		<%
			for (Resumebean bean : filelist) {
		%>
		<tr>
			<td><%=bean.getFileName()%></td>&nbsp;
			<td><%=bean.getName()%></td>&nbsp;
			<td><%=bean.getEmail()%></td>&nbsp;

			<%!public static String getMimeType(String fileUrl) throws java.io.IOException, MalformedURLException {
				
		String type = null;
		URL u = new URL(fileUrl);
		URLConnection uc = null;
		uc = u.openConnection();
		type = uc.getContentType();
		return type;
	}%>
			<%
				String file = "D:/UploadResume/" + rs.getName();
						File f = new File(file);
						String filename = f.getName();
						String type = getMimeType("file:" + file);
						response.setContentType(type);
						response.setHeader("Content-Disposition", "attachment;     filename=\"" + filename + "\"");
						String name = f.getName().substring(f.getName().lastIndexOf("/") + 1, f.getName().length());
						InputStream in = new FileInputStream(f);
						ServletOutputStream outs = response.getOutputStream();
						int bit = 256;
						int i = 0;
						try {
							while ((bit) >= 0) {
								bit = in.read();
								outs.write(bit);
							}
						} catch (IOException ioe) {
							ioe.printStackTrace(System.out);
						}
						outs.flush();
						outs.close();
						in.close();
			%>

		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>

</body>
</html>