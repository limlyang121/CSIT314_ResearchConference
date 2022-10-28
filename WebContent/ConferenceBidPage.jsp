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
				<th>BidID</th>
				<th>PaperID</th>
				<th>ReviewerName</th>
				<th> </th>
				

			</tr>

		</thead>
		<tbody>
			<c:forEach var ="bidInfo" items = "${bidInfo}">
				<tr>
					
					<td>
						<c:out value="${bidInfo.bid_id}" />
					</td>
					<td>
						<c:out value="${bidInfo.paper_id}" />
					</td>
					
					<td>
						<c:out value="${bidInfo.reviewer_id}" />
					</td>
					<td>
					<c:if test = "${bidInfo.allocateStatus == 'unallocated'}">
						<a href="editUserAccountForm?cusername=<c:out value = '${ user.username}'  />&cprofilename=<c:out value = '${user.profileName }'/> " >
						Allocate
						</a>
						<a href="editUserAccountForm?cusername=<c:out value = '${ user.username}'  />&cprofilename=<c:out value = '${user.profileName }'/> " >
						Reject
						</a>
					 </c:if>
					<c:if test = "${bidInfo.allocateStatus == 'allocated'}">
						<a href="editUserAccountForm?cusername=<c:out value = '${ user.username}'  />&cprofilename=<c:out value = '${user.profileName }'/> " >
						Unallocated
						</a>
					 </c:if>
						
					</td>
	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>