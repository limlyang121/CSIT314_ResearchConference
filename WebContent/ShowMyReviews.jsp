<!DOCTYPE html>
<html>
<head>
<%@include file= "include/header.jsp" %>

</head>
<style>

body{
background-image: linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)), url("img/background.jpg");
height: 100vh;
-webkit-background-size: cover;
background-size: cover;
background-position: center center;
background-opacity: 0.1;
}

.main{
	align: center;
	width: 60%;
	background-color: white;
	margin: auto;
	min-height: 100%;
	opacity: 0.9;
	padding: 30px;
}

</style>
<body>
	<%@include file = "include/navbar.jsp" %>

     	<div align="center" class="main">
       	<h1>Your Papers</h1>
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