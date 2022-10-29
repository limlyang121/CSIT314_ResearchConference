<%@include file= "script.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <div class="container">
      <p class="navbar-brand" >SemiColon</p>
      <c:if test="${sessionScope.username != null}">
         <ul class="navbar-nav">
         	<li>
         		<a class="nav-link" href="<%=request.getContextPath()%>/HomePage.jsp">Home</a>
        	</li>
            <c:if test="${sessionScope.profileName == 'systemadmin'}">
			   
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewUserAccount">User Accounts</a>
               </li>
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewUserProfile">User Profiles</a>
               </li>
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/newUserForm">Add User Accounts</a>
               </li>
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/newUserProfileForm" >Add New User Profile</a>
               </li>
               
            </c:if>
            <c:if test="${sessionScope.profileName == 'conference'}">
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/conferenceBidPage">View Current Bid</a>
               </li>
               
               <li>
               	    <a class="nav-link" href="<%=request.getContextPath()%>/selfUpdateForm?username=
					<c:out value ='${sessionScope.username}'/>&profileName=<c:out value = '${sessionScope.profileName}'/>" > Update my Profile </a>
             	</li>
            </c:if>
            
            <c:if test="${sessionScope.profileName == 'reviewer'}">
               <li>
                  <a class="nav-link" href="PaperstoReview?userid=<c:out value = '${sessionScope.id}'/>">Papers to be Reviewed</a>
               </li>
               
               <li>
                  <a class="nav-link" href="ShowAllPaperstoBid?userid=<c:out value = '${sessionScope.id}'/>">Bid Papers</a>
               </li>
               
               <li>
               	    <a class="nav-link" href="<%=request.getContextPath()%>/selfUpdateForm?username=
					<c:out value ='${sessionScope.username}'/>&profileName=<c:out value = '${sessionScope.profileName}'/>" > Update my Profile </a>
             	</li>
            </c:if>
            <c:if test="${sessionScope.profileName == 'author'}">
               <li>
                  <a class="nav-link" href="SubmissionPaper?username=<c:out value = '${sessionScope.username}'/>">Create Submissions</a>
               </li>
               <li>
                  <a class="nav-link" href="ShowMyPapers?username=<c:out value = '${sessionScope.username}'/>">View My Papers</a>
               </li>
               <li>
               	    <a class="nav-link" href="<%=request.getContextPath()%>/selfUpdateForm?username=
					<c:out value ='${sessionScope.username}'/>&profileName=<c:out value = '${sessionScope.profileName}'/>" > Update my Profile </a>
             	</li>
            </c:if>
         </ul>
      </c:if>
      <ul class="navbar-nav ml-auto">
         <c:if test="${sessionScope.username == null}">
            <li class="nav-item">
               <a class="nav-link" href="<%=request.getContextPath()%>/welcome">Main Menu <i class="fas fa-home"> </i></a>
            </li>

         </c:if>
         <c:if test="${sessionScope.username != null}">
            <li class="nav-item">
               <a class="nav-link disabled" href="">${profile}</a>
            </li>
            <li class="nav-item dropdown">
               <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${username}  &nbsp; <i class="fas fa-user"> </i></a>
               <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" id="logout_btn" href="<%=request.getContextPath()%>/logout" onclick="return logoutuser();" class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</a>
               </div>
            </li>
         </c:if>
      </ul>
   </div>
</nav>