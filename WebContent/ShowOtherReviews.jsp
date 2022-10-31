<!DOCTYPE html>
<html>
<head>
<%@include file= "include/header.jsp" %>

</head>
</head>
<body>
	<%@include file = "include/navbar.jsp" %>

        <h1>What others have to say</h1>
         <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of reviews</h2></caption>
            <tr>
            	<th>Reviewer</th>
                <th>Review</th>
                <th>Rating</th>
            </tr>
            <c:forEach var="review" items="${listReview}">
                <tr>
                	
                    <td><c:out value="${review.reviewername}" /></td>
                    <td><textarea id="review" name="review" rows="4" cols="50">${review.review}</textarea></td>
                    <td><c:out value="${review.rating}" /></td>
   
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>