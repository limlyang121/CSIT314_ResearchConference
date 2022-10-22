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
            </tr>
            <c:forEach var="paper" items="${listPaper}">
                <tr>
                	<td><c:out value="${paper.id}" /></td>
                    <td><c:out value="${paper.papername}" /></td>
                    <td><c:out value="${paper.status}" /></td>
                    <td>
						<a href="/editPaper?paperid=<c:out value = '${paper.id}'/> " >
						Edit
						</a>
					</td>
					<td>
						<a href="viewPaper?paperid=<c:out value = '${paper.id}'/> " >
						View
						</a>
						
					</td>
					<td>
						<a href="deletePaper?paperid=<c:out value = '${paper.id}'/> " >
						Delete
						</a>
					</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>