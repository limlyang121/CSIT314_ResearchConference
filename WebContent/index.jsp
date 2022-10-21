<html>
<head>
	<%@include file= "include/header.jsp" %>
</head>
<body>

	 <form id="loginForm" action="login" method="post"  onsubmit="return loginValidation();">
	     <h2>Login</h2>
	     <fieldset class="form-group">
	        <label>Username</label>
	        <input type="text" class="form-control" name="username" id="username">
	        <i class="fa-solid fa-circle-check symbol valid"></i>
	        <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
	        <small>Error</small>
	     </fieldset>
	     <fieldset class="form-group">
	        <label>Password</label>
	        <input type="password" class="form-control" name="password" id="password">
	        <i class="fa-solid fa-circle-check symbol valid"></i>
	        <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
	        <small>Error</small>
	     </fieldset>
	     <label for = "profile">Choose Profile: </label>
		 <select name = "profile" id = "profile" >
			<option value = "systemadmin" >SysAdmin</option>
			<option value = "reviewer" >Reviewer</option>
			<option value = "conference" >Conference Chair</option>
			<option value = "author" >Author</option>
			
		 </select> 
	     <div class="btn-toolbar pull-right">
	        <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Login</button>
	     </div>
	  </form>
</body>
</html>