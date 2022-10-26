
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@include file = "include/header.jsp" %>
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
						<a href="editUserAccountForm?cusername=<c:out value = '${ user.username}'  />&cprofilename=<c:out value = '${user.profileName }'/> " >
						Update
						</a>
					</td>
					<td>
						<a href="readAccountForm?username=<c:out value = '${user.username}'  />&profilename=<c:out value = '${user.profileName}'/> " >
						View
						</a>
						
					</td>
					

						
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>