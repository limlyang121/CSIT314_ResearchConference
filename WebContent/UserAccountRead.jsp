
<!DOCTYPE html>
<html>
<head>
<%@include file= "include/header.jsp" %>
<meta charset="ISO-8859-1">
<title>FUCK</title>
</head>
<body>
		<label>Fullname</label>
		<input type="text" name="name" id="name" value="<c:out value='${userAccount.fullname}' />" readonly>
		
		<br/>
		
		<label>Username</label>
		<input type="text" name="username" id="username" value="<c:out value='${userAccount.username}' />" readonly>
		
		
		<br/>
		
		
		<label>email</label>
		<input type="text" name="email" id="email" value="<c:out value='${userAccount.email}' />" readonly>

		<br/>
		
		<br/>
		<label>password</label>
		<input type="password" name="password" id="password" value="<c:out value='${userAccount.password}' />" readonly >
		
		<br/>
		
		<label for = "profile">Choose Profile: </label>
		<input type="text" name="prof" id="prof" value="<c:out value='${userAccount.profileName}' />"  readonly>
		
		
		
       
       <br/>
		
</body>
</html>