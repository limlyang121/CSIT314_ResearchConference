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
            	<th>Review ID</th>
                <th>PaperName</th>
                <th>Review</th>
                <th>Rating</th>
            </tr>
            <c:forEach var="paper" items="${listPaper}">
                <tr>
                	<td><c:out value="${paper.reviewid}" /></td>
                    <td><c:out value="${paper.papername}" /></td>
                    <td><textarea id="review" name="review" rows="4" cols="50">${paper.review}</textarea></td>
                    <td><c:out value="${paper.rating}" /></td>
   
            		
                    <td style="width:10%">
                      <a href="editReview?reviewid=<c:out value = '${paper.reviewid}'/>&userid=<c:out value = '${sessionScope.id}'/>">
						Edit
						</a>
        
					</td>
					<td style="width:10%">

						<a href="deleteReview?reviewid=<c:out value = '${paper.reviewid}'/>&userid=<c:out value = '${sessionScope.id}'/> " >
						Delete
						</a>
					</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>