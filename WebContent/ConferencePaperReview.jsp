<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>
	
	<c:if test="${PaperReview == null }" >
		<h1>Currently No Review yet</h1>
	</c:if>
	
	
	<c:if test="${PaperReview != null }" >
		<c:forEach var ="PaperReview" items = "${PaperReview}">
			<label >Reviewer Name </label>
			<input type= "text" id = "reviewerName" value ="<c:out value="${PaperReview.bidfk.reviewer.fullname}"/>" readonly>
			
			<br>
			
			<label >Reviewer Rating </label>
			<input type= "text" id = "reviewerRating" value ="<c:out value="${PaperReview.rating}"/>" readonly>
			
			<br>
			
			<label >Reviewer Comment </label>
			<input style="height:200px;font-size:14pt;" type= "text" id = "reviewerComment" value ="<c:out value="${PaperReview.review}"/>" readonly>
			
			<hr/>
		
		</c:forEach>
		
		
		<hr/>
		
		<form method = "post" action = "RatePaper?paperID=<c:out value = '${paperID}'/>">
			<label>Rate Paper </label>
			<br>
			<select id ="ratePaper"  name ="ratePaper">
				<option value = "Accept" >Accept</option>
				<option value = "Pending" >Pending</option>
				<option value = "Reject" >Reject</option>
			
			</select>
			
			<br/> <br/> <br/>
			
			<button id = "submitButton" type= "submit"> Rate Paper</button>
		
		</form>
				
	</c:if>
	
	
	
	
</body>
</html>