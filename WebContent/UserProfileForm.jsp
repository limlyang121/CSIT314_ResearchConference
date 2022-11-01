<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>

	<c:if test="${userProfile == null}">
		<form id="createNewUserProfileForm" action = "createNewUserProfileForm" method="post"/>	
	</c:if>
	<c:if test="${userProfile != null}">
		<form id="updateUserProfile" action = "updateUserProfile" method="post"/>	
	</c:if>
	
		<input type="text" id ="id" name ="id" value="<c:out value='${userProfile.profileID}' />" hidden >
	
		<label>Profile Name</label>
		<input type="text" name="profilename" id="profilename" value="<c:out value='${userProfile.profileName}' />">

		<br>
		
		<label for="description">description</label>
		<br>
		<textarea class="form-control" rows="3" name="description" id="description" >
<c:out value='${userProfile.description}' />
		
		</textarea>
		<br/>
		<button type= "submit">Submit</button>
		
		
	
	</form>
</body>
</html>