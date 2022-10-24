<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowMyPaper</title>
</head>
<body>
        <h1>Your Papers</h1>
         <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of papers</h2></caption>
            <tr>
            	<th>ID</th>
                <th>PaperName</th>
                <th>Status</th>
                <th>Author</th>
                <th>Co-Author</th>
            </tr>
            <c:forEach var="paper" items="${listPaper}">
                <tr>
                	<td><c:out value="${paper.id}" /></td>
                    <td><c:out value="${paper.papername}" /></td>
                    <td><c:out value="${paper.status}" /></td>
                    <td><c:out value="${paper.author}" /></td>
                    <td><c:out value="${paper.coauthor}" /></td>
            		
                    <td style="width:10%">
                    <c:choose>
    					<c:when test = "${paper.authorusername == sessionScope.username}">
        					<a href="EditPaper?paperid=<c:out value = '${paper.id}'/>&username=<c:out value = '${sessionScope.username}'/>">
						Edit
						</a>
        					
						</c:when>    
    					<c:otherwise>
        					
    					</c:otherwise>
					</c:choose>
        
					</td>
					<td style="width:10%">
					 <c:choose>
    					<c:when test = "${paper.authorusername == sessionScope.username}">
						<a href="deletePaper?paperid=<c:out value = '${paper.id}'/>&username=<c:out value = '${sessionScope.username}'/> " >
						Delete
						</a>
						</c:when>    
    					<c:otherwise>
        					
    					</c:otherwise>
					</c:choose>
					</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>