<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>
	
	
	<h1>Current Bid from reviewer</h1>
	

<a href="<%=request.getContextPath()%>/viewAllPaper?status=Pending" > <button> View Pending </button> </a>
<a href="<%=request.getContextPath()%>/viewAllPaper?status=Accept"> <button> View Accept </button> </a>	
<a href="<%=request.getContextPath()%>/viewAllPaper?status=Reject"> <button> View Reject </button> </a>
<div align = center>
	<table border = 1 cellpadding = "10">
		<thead>
			<tr>
				<th>PaperID</th>
				<th>Paper Name</th>
				<th>Author Name </th>
				<th>Status </th>
				<th>Review Status </th>
				

			</tr>

		</thead>
		
		<tbody> 
			<c:forEach var ="paperInfo" items = "${paperInfo}">
				<c:if test = "${param.status == null || param.status == paperInfo.status}"> 
				<tr>
					<td>
						<c:out value="${paperInfo.id}" />
					</td>
					<td>
						<c:out value="${paperInfo.papername}" />
					</td>
					<td>
						<c:out value="${paperInfo.author}" />
					</td>
					
					<td>
						<c:if test="${paperInfo.status == 'Accept' }" > 
							<p class="text-success"> <c:out value="${paperInfo.status}" /> </p> 
						</c:if>
						<c:if test="${paperInfo.status == 'Reject' }" > 
							<p class="text-danger"> <c:out value="${paperInfo.status}" /> </p> 
						</c:if>
						<c:if test="${paperInfo.status == 'Pending' }" > 
							<p class="text-dark"> <c:out value="${paperInfo.status}" /> </p> 
						</c:if>
							
					</td>
					<td>
						<c:if test="${paperInfo.status == 'Pending'}"> 
							<a href="<%=request.getContextPath()%>/GetPaperReviewAndRating?paperID=<c:out value = '${paperInfo.id}'  />" >
							Accept/Reject Paper
						</a>
						</c:if>
						<c:if test="${paperInfo.status != 'Pending'}"> 
							<a href="<%=request.getContextPath()%>/GetPaperReviewAndRating?paperID=<c:out value = '${paperInfo.id}'  />" >
							Update Paper Status
						</a>
						</c:if>
					
					</td>
				
				</tr>
				</c:if>
			
			
			</c:forEach>
		
		
		</tbody>
	</table>
</div>
</body>
</html>