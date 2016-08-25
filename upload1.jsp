<%@page import="fileuploading.GetConnection"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<%!
Connection connection = null;
FileOutputStream fos = null;
String fileName = null;
String storedata="d://download/";
String category="";
String subcategory="";
%>
<%
   File file ;
   int maxFileSize = 1024 * 1024 * 50; //50 MB
   int maxMemSize = 1024 * 1024 * 50;//50 MB
   ServletContext context = pageContext.getServletContext();
   String filePath = context.getInitParameter("file-upload");
  // String filePath = getServletContext().getRealPath(filePath1)+"\\";
  // System.out.println("filePath1 :"+filePath1);
   System.out.println("filePath :"+filePath);
   // Verify the content type
   String contentType = request.getContentType();
   if ((contentType.indexOf("multipart/form-data") >= 0)) {

      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );
      try{ 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);

         // Process the uploaded file items
         Iterator i = fileItems.iterator();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>JSP File upload</title>");  
         out.println("</head>");
         out.println("<body>");
         while (i.hasNext () ) 
         {
            FileItem fi = (FileItem)i.next();
            if (fi.isFormField () )	
            {
            	if (fi.getFieldName().equals("category")) {
            		category = fi.getString();
            		}
            		else if(fi.getFieldName().equals("subcategory")) {
                		subcategory = fi.getString();
                    }
           	     //System.out.println(category);
           	//  System.out.println(subcategory);
           	  }
            if (!fi.isFormField () )	
            {
            // Get the uploaded file parameters
            String fieldName = fi.getFieldName();
            fileName = fi.getName();
            System.out.println("file name: "+fi.getName());
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();
            // Write the file
            if( fileName.lastIndexOf("\\") >= 0 ){
            file = new File( filePath + 
            fileName.substring( fileName.lastIndexOf("\\"))) ;
            }else{
            file = new File( filePath + 
            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
            }
            fi.write( file ) ;
            out.println("Uploaded Filename: " + filePath + 
            fileName + "<br>");
            System.out.println(filePath+fileName);
            // System.out.println(fileName);
             File file1 = new File(filePath+fileName);
     		FileInputStream fis = new FileInputStream(file1);
     		connection = GetConnection.getConnection();
     		PreparedStatement ps = connection.prepareStatement("INSERT INTO files VALUES (?,?,?,?,?)");
     		ps.setString(1, file1.getName());
     		ps.setBinaryStream(2, fis, (int)file1.length());
     		ps.setInt(3, new Random().nextInt());
     		ps.setString(4, category);
     		ps.setString(5,subcategory);
     		ps.executeUpdate();
     		System.out.println("insert success ");
     		
     		String query = "SELECT filedata, LENGTH(filedata) FROM files where filename='"+fileName+"'";
             ps = connection.prepareStatement(query);

             ResultSet result = ps.executeQuery();
             result.next();

             fos = new FileOutputStream(storedata+fileName);

             int len = result.getInt(2);
             byte[] buf = result.getBytes("filedata");
             fos.write(buf, 0, len);
             System.out.println("retrieve success ");
            }
           }
         out.println("</body>");
         out.println("</html>");
      }catch(Exception ex) {
         System.out.println(ex);
      }
   }else{
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet upload</title>");  
      out.println("</head>");
      out.println("<body>");
      out.println("<p>No file uploaded</p>"); 
      out.println("</body>");
      out.println("</html>");
   }
   
%>
<a href="../Documents/<%=fileName%>" target="_blank">
                                        <%=fileName%></a> 