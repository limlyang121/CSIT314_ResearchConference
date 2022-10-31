<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>
	
	<h1>Current Bid from reviewer</h1>
	
	<table>
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
						<c:out value="${paperInfo.status}" />
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/PaperReview?paperID=<c:out value = '${paperInfo.id}'  />" >
							More Information
						</a>
						
					</td>
				
				</tr>
			
			
			</c:forEach>
		
		
		</tbody>
	</table>
</body>
</html>