<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>

	<c:if test="${userProfile == null}">
		<form id="newUserProfileForm" action = "newUserProfile" method="post"/>	
	</c:if>
	<c:if test="${userProfile != null}">
		<form id="editUserProfileForm" action = "editUserProfileForm" method="post"/>	
	</c:if>
	
		<input type="text" id ="id" name ="id" value="<c:out value='${userProfile.profileID}' />" hidden >
	
		<label>Profile Name</label>
		<input type="text" name="profilename" id="profilename" value="<c:out value='${userProfile.profileName}' />">

		
		<label>description</label>
		<input style="height:200px;font-size:14pt;" type="text" name="description" id="description" value="<c:out value='${userProfile.description}' />">
		<br/>
		<button type= "submit">Submit</button>
		
		
	
	</form>
</body>
</html>