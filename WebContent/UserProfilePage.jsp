
<!DOCTYPE html>
<html>
<head>

<%@include file= "include/header.jsp" %>
</head>
<body>

	<h1>All User Profile</h1>
	<br/>

	<table>
		<thead>
			<tr>
				<th>Profile</th>
				<th>Description</th>
				<th> </th>
				

			</tr>

		</thead>
		<tbody>
			<c:forEach var ="user" items = "${userProfileList}">
				<tr>

					<td>
						<c:out value="${user.profileName}" />
					</td>
					<td>
						<c:out value="${user.description}" />
					</td>
					
					<td>
						<a href="<%=request.getContextPath()%>/editUserProfileForm?profilename=<c:out value = '${ user.profileName}'  />" >
						Edit
						</a>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
		
</body>
</html>