<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>

	<form action= "selfUpdate?id=<c:out value ='${sessionScope.id }'/>&profileName=
	<c:out value='${sessionScope.profileName}'/>" method = "post">
	
		<input name="oldusername" id = "oldusername" value =<c:out value = '${myAccount.username} }'/> hidden>
		<label> Username</label>
		<input id = "myusername" name="myusername" value =<c:out value = '${myAccount.username} }'/> >


		<br>
		<label> Fullname</label>
		<input id = "myname" name="myname" value =<c:out value = '${myAccount.fullname} }'/> >
		
		
		<br>
		<label> Password</label>
		<input id = "mypassword" name="mypassword" value =<c:out value = '${myAccount.password} }'/> >
		
		<br>
		<label> Email</label>
		<input id = "myemail"  name="myemail" value =<c:out value = '${myAccount.email} }'/> >
		
		<br>
		
		<c:if test="${sessionScope.profileName == 'reviewer'}">
			<label> Max Number of Papers</label>
			<input id = "maxPaper"  name="maxPaper" value =<c:out value = '${myAccount.max_no_papers} }'/> >
		</c:if>
		
		<br>
		<button type = "submit">Submit</button>
			
	
	</form>
</body>
</html>