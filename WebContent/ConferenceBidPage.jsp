<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>
	
	<h1>Current Bid from reviewer</h1>
	
	<a href = "<%=request.getContextPath()%>/autoAllocatePaper" onclick = "return confirmUserAction('Auto Allocate?');">
		<button >
			Auto Allocate
		</button>
	</a>
	
	<table>
		<thead>
			<tr>
				<th>BidID</th>
				<th>PaperName</th>
				<th>ReviewerName</th>
				<th>AuthorName </th>
				<th>CoAuthor </th>
				<th> </th>
				

			</tr>

		</thead>
		<tbody>
			<c:forEach var ="bidInfo" items = "${bidInfo}">
			<c:if test= "${bidInfo.allocateStatus != 'complete' }"> 
				<tr>
					
					<td>
						<c:out value="${bidInfo.bid_id}" />
					</td>
					<td>
						<c:out value="${bidInfo.paper.papername}" />
					</td>
					
					<td>
						<c:out value="${bidInfo.reviewer.fullname}" />
					</td>
					
					<td>
						<c:out value="${bidInfo.paper.author}" />
					</td>
					<td > 	
						<c:if test = "${bidInfo.paper.coauthor != null }"> 
							<c:out value="${bidInfo.paper.coauthor}" />
		
						</c:if>
						<c:if test = "${bidInfo.paper.coauthor == null }"> 
							Null
						</c:if>
						
					</td>
					
					<td>
					<c:if test = "${bidInfo.allocateStatus == 'unallocated'}">
						<a href="allocatePaper?bidID=<c:out value = '${bidInfo.bid_id}'  />" >
						Allocate
						</a>
						<a onclick = "return confirmUserAction('Are you Sure');" href="RejectBid?bidID=<c:out value = '${bidInfo.bid_id}'  />" >
						Reject
						</a>
					 </c:if>
					 
					 <c:if test = "${bidInfo.allocateStatus == 'allocated'}" >
						<a type= "submit" onclick = "return confirmUserAction('Are you Sure');" href="unallocatePaper?bidID=<c:out value = '${bidInfo.bid_id}'  />" >
						UnAllocate
						</a>
					 </c:if>
					
						
					</td>
	
				</tr>
			</c:if>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>