<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>

	<c:if test="${userProfile == null}">
		<form id="newUserProfileForm" action = "newUserProfile" method="post"  >	
	</c:if>
	<c:if test="${userProfile != null}">
		<form id="editUserProfileForm" action = "editUserProfileForm" method="post"  >	
	</c:if>
	

	
		<label>Profile Name</label>
		<c:if test="${userProfile != null}">
			<input type="text" name="profilename" id="profilename" value="<c:out value='${userProfile.profileName}' />" readonly>
		
		</c:if>
		<c:if test="${userProfile == null}">
			<input type="text" name="profilename" id="profilename" value="<c:out value='${userProfile.profileName}' />">
		
		</c:if>
		
		<br/>
		
		<label>description</label>
		<input style="height:200px;font-size:14pt;" type="text" name="description" id="description" value="<c:out value='${userProfile.description}' />">
		<br/>
		<button type= "submit">Submit</button>
		
		
	
	</form>
</body>
</html>