<!DOCTYPE html>
<html>
<head>
<%@include file= "include/header.jsp" %>

</head>
</head>
<body>
	<%@include file = "include/navbar.jsp" %>

        <h1>Your Papers</h1>
         <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of reviews</h2></caption>
            <tr>
            	<th>Paper ID</th>
                <th>PaperName</th>
                <th>Review</th>
                <th>Rating</th>
                <th>Reviewer</th>
            </tr>
            <c:forEach var="review" items="${listReview}">
                <tr>
                	<td><c:out value="${review.paperid}" /></td>
                    <td><c:out value="${review.papername}" /></td>
                    <td><textarea id="review" name="review" rows="4" cols="50">${review.review}</textarea></td>
                    <td><c:out value="${review.rating}" /></td>
                    <td><c:out value="${review.reviewername}" /></td>
   
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>