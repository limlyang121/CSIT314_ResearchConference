<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file= "include/header.jsp" %>
</head>
<body>

<a href="<%=request.getContextPath()%>/HomePageAdmin.jsp" >
		<button  >Add New User</button>
</a>

<h1>
	<label> My name</label>
	<input type="text" value =<c:out value = '${sessionScope.tusername}'/>>


</h1>
	<h1>All User Account</h1>
	<br/>

	<form action = "searchUserAccount" method = "post">
		<label>Search </label>
		<input name = "searchbox" id = "searchbox" type = "text" placeholder = "search by name" > 
		<button type="submit">Find</button>
	</form>


	<table>
		<thead>
			<tr>
				<th>username</th>
				<th>password</th>
				<th>Role </th>
				<th> </th>
				

			</tr>

		</thead>
		<tbody>
			<c:forEach var ="user" items = "${userAccountList}">
				<tr>
					
					<td>
						<c:out value="${user.username}" />
					</td>
					<td>
						<c:out value="${user.password}" />
					</td>
					
					<td>
						<c:out value="${user.profileName}" />
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