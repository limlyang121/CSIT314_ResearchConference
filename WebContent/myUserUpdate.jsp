<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<form action= "selfUpdate?id=<c:out value ='${sessionScope.id }'/>&profileName=
	<c:out value='${sessionScope.profileName}'/>" method = "post">
		<label> Username</label>
		<input id = "myusername" value =<c:out value = '${myAccount.username} }'/> >


		<br>
		<label> Fullname</label>
		<input id = "myname" value =<c:out value = '${myAccount.fullname} }'/> >
		
		
		<br>
		<label> Password</label>
		<input id = "mypassword" value =<c:out value = '${myAccount.fullname} }'/> >
		
		<br>
		<label> Email</label>
		<input id = "myemail" value =<c:out value = '${myAccount.fullname} }'/> >
		
		<c:if test="${sessionScope.profileName} == 'reviewer'">
			<label> Max Number of Papers</label>
			<input id = "maxPaper" value =<c:out value = '${myAccount.max_no_papers} }'/> >
		</c:if>
		
		<button type = "submit">Submit</button>
			
	
	</form>
</body>
</html>