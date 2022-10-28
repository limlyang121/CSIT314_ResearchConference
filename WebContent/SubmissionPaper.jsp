<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file = "include/navbar.jsp" %>

        <h1>File Upload to Database Demo</h1>
        <form method="post" action="SubmissionPaper" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>File Name: </td>
                    <td><input type="text" name="fileName" size="50"/></td>
                </tr>
                <tr>
                    <td>File: </td>
                    <td><input type="file" name="paper" size="50"/></td>
                </tr>
                <tr>
                	<td>Add Co-Author: </td>
                	<td>
                		 <select name="authors">
        					<c:forEach items="${listAuthor}" var="author">
            				<option value="${author}">${author}</option>
        					</c:forEach>
    						</select>
    						<br/><br/>
                	</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Upload">
                    </td>
                </tr>
            </table>
        </form>

</body>
</html>