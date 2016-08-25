<%@page import="fileuploading.GetConnection"%>
<%@page import="java.sql.*"%>
<html>
<head>
<title>File Uploading Form</title>
</head>
<script>

function validateFileExtension(fld) {
    if(!/(\.doc|\.docx)$/i.test(fld.value)) {
        alert("Invalid doc file type.");      
        fld.form.reset();
        fld.focus();        
        return false;   
    }   
    return true; 
 }
function validateFileExtension1(fld) {
    if(!/(\.ppt)$/i.test(fld.value)) {
        alert("Invalid power point file type.");      
        fld.form.reset();
        fld.focus();        
        return false;   
    }   
    return true; 
 }
function validateFileExtension2(fld) {
    if(!/(\.pdf)$/i.test(fld.value)) {
        alert("Invalid pdf file type.");      
        fld.form.reset();
        fld.focus();        
        return false;   
    }   
    return true; 
 }
function validateFileExtension3(fld) {
    if(!/(\.xls)$/i.test(fld.value)) {
        alert("Invalid excel file type.");      
        fld.form.reset();
        fld.focus();        
        return false;   
    }   
    return true; 
 }
function validateFileExtension4(fld) {
    if(!/(\.txt)$/i.test(fld.value)) {
        alert("Invalid text file type.");      
        fld.form.reset();
        fld.focus();        
        return false;   
    }   
    return true; 
 }
</script>
<body>
<h3>File Upload:</h3>
</br>

Select a file to upload: 

<form action="upload1.jsp" method="post"
                        enctype="multipart/form-data">
                        <table>
                     
<tr><td>PDF File: <input type="file" id="filename3" name="file" size="50"  onchange="return validateFileExtension2(this)"/></td></tr><tr><td></td></tr>
    <tr><td>Category : <select name="category">
    <% 
    Connection con=GetConnection.getConnection();
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from categories");
    while(rs.next()){
    %>
                    <option value="<%=rs.getString("catname")%>"><%=rs.getString("catname")%></option>
    <%
    }
    %>
                    </select></td></tr> 
                    <tr><td>Sub Category : <select name="subcategory">
    <% 
    Connection con1=GetConnection.getConnection();
    Statement st1=con1.createStatement();
    ResultSet rs1=st1.executeQuery("select * from subcategories");
    while(rs1.next()){
    %>
                    <option value="<%=rs1.getString("subcatname")%>"><%=rs1.getString("subcatname")%></option>
    <%
    }
    %>
                    </select></td></tr> 
<br />
<tr><td><input type="submit" value="Upload File" onclick="retrun Checkfiles()"/></td></tr>
   </table>
</form>
</body>
</html>