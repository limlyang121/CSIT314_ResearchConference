<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>

	<c:if test="${userAccount != null}">
	<%
   		String clientusername = request.getParameter("cusername").toString();
		String clientprofilename = request.getParameter("cprofilename").toString();
		
	%>
		<form id = "editUserForm" action = "editUserAccountForm?cusername=<%=clientusername %>&cprofilename=<%=clientprofilename %>" method ="post" >
	</c:if>
	<c:if test="${userAccount == null}">
		<form id="newUserForm" action = "newUserAccount" method="post"  >	
	</c:if>

	
		<label>Fullname</label>
		<input type="text" name="name" id="name" value="<c:out value='${userAccount.fullname}' />">
		
		<br/>
		
		<label>Username</label>
		<input type="text" name="username" id="username" value="<c:out value='${userAccount.username}' />">
		
		
		<br/>
		
		
		<label>email</label>
		<input type="text" name="email" id="email" value="<c:out value='${userAccount.email}' />">

		<br/>
		
		<br/>
		<label>password</label>
		<input type="password" name="password" id="password" value="<c:out value='${userAccount.password}' />" >
		
		<br/>
		
		<label for = "profile">Choose Profile: </label>
		<select id = "profilename" name = "profilename" class="form-control" >
        	<c:forEach var="userProfile" items="${userProfileList}">
        		<option value ="<c:out value='${userProfile.profileName }' />" >
           			<c:out value = "${userProfile.profileName }" />
           		</options>
   
            	
            </c:forEach>
       </select>
       
       <br/>
       
		
		
		
		<button type= "submit">Submit</button>
		
		
	
	</form>
</body>
</html>