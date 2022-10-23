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
        <h1>Edit Your Paper</h1>
        <form method="post" action="SubmissionPaper">
            <table border="0">
                <tr>
                    <td>Edit file Name: </td>
                    <td><input type="text" name="fileName" placeholder="${paperinfo.papername}"/></td>
                </tr>
                <tr>
                    <td>Edit Co-Author: </td>
                    <td><input type="text" placeholder="${paperinfo.coauthor}"</td>
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
                        <input type="submit" value="Edit">
                    </td>
                </tr>
            </table>
        </form>

</body>
</html>