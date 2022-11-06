<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file= "include/header.jsp" %>
</head>

<style>
table, td, th, tr{
	border: 2px solid black;
}

table{
	margin-left: auto;
	margin-right: auto;
	background-color: white;
	td  : {text-align: center;};

}

.main{
	align: center;
	width: 80%;
	background-color: white;
	margin: auto;
	min-height: 100%;
	opacity: 0.9;
}

body{
background-image: linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)), url("img/background.jpg");
height: 100vh;
-webkit-background-size: cover;
background-size: cover;
background-position: center center;
}

</style>
<body>
	<%@include file = "include/navbar.jsp" %>

	<div class="main">
	<br/>
	<div align="center">
	<h1>All User Account</h1>
	<br/>

	<form action = "searchUserAccount" method = "post">
		<label>Search </label>
		<input name = "searchbox" id = "searchbox" type = "text" placeholder = "search by username" > 
		<button type="submit">Find</button>
	</form>
	</div>


	<table style="width:80%;height:80%;">
		<thead>
			<tr style="text-align: center">
				<th> Username </th>
				<th> Password</th>
				<th> Role </th>
				<th> </th>
				

			</tr>

		</thead>
		<tbody style="text-align: center">
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
						<a href="updateUserAccount?cusername=<c:out value = '${ user.username}'  />&cprofilename=<c:out value = '${user.profileName }'/> " >
						Update
						</a>
					</td>
					<td>
						<a href="readAccountForm?username=<c:out value = '${user.username}'  />&profilename=<c:out value = '${user.profileName}'/> " >
						Read
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</body>
</html>