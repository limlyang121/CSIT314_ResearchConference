<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<form>
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
		<input id = "myEmail" value =<c:out value = '${myAccount.fullname} }'/> >
		
			
	
	</form>
</body>
</html>