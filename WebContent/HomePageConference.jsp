
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file = "include/header.jsp" %>
</head>

<body>
	<h1> My name is <c:out value= '${sessionScope.username}' /> </h1>
	
	<a href="<%=request.getContextPath()%>/selfUpdateForm?username=
	<c:out value ='${sessionScope.username}'/>&profileName=<c:out value = '${sessionScope.profileName}'/>" >
		<button  >My Profile Update</button>
	</a>
	
	<form  action = "logout" onsubmit = "return logoutUser();" >
		<button type = "submit"> Button </button>
	</form>
</body>
</html>