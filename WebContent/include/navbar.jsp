<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <div class="container">
      <a class="navbar-brand" href="">ScreamScrum Restaurant</a>
      <c:if test="${sessionScope.username != null}">
         <ul class="navbar-nav">
            <li>
               <a  class="nav-link" href="<%=request.getContextPath()%>/StaffHomePage.jsp">Home</a>
            </li>
            <c:if test="${sessionScope.profile == 'User Admin'}">
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewUserAccount">User Accounts</a>
               </li>
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewUserProfile">User Profiles</a>
               </li>
            </c:if>
            <c:if test="${sessionScope.profile == 'Restaurant Manager'}">
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewMenuItem">Menu Items</a>
               </li>
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewCoupons">Coupons</a>
               </li>
            </c:if>
            <c:if test="${sessionScope.profile == 'Restaurant Staff'}">
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewOrder">Orders</a>
               </li>
            </c:if>
            <c:if test="${sessionScope.profile == 'Restaurant Owner'}">
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewOwnerDrinksAndDishesReport">Drinks and Dishes</a>
               </li>
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewOwnerFrequencyReport">Customer Frequency</a>
               </li>
               <li>
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewOwnerAverageSpendReport">Customer Average Spending</a>
               </li>
            </c:if>
         </ul>
      </c:if>
      <ul class="navbar-nav ml-auto">
         <c:if test="${sessionScope.username == null}">
            <li class="nav-item">
               <a class="nav-link" href="<%=request.getContextPath()%>/welcome">Main Menu <i class="fas fa-home"> </i></a>
            </li>
            <li class="nav-item">
               <a class="nav-link" href="Cart.jsp">Shopping Cart <i class="fas fa-shopping-cart"> </i> &nbsp;<span class="badge badge-danger"><c:if test="${sessionScope.sessionCartList != null}">${fn:length(sessionCartList)}</c:if></span> </a>
            </li>
            <li class="nav-item">
               <a class="nav-link" href="LoginForm.jsp">Staff Login <i class="fas fa-sign-in-alt"> </i></a>
            </li>
         </c:if>
         <c:if test="${sessionScope.username != null}">
            <li class="nav-item">
               <a class="nav-link disabled" href="">${profile}</a>
            </li>
            <li class="nav-item dropdown">
               <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${username}  &nbsp; <i class="fas fa-user"> </i></a>
               <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" id="logout_btn" href="<%=request.getContextPath()%>/logout" onclick="return logout();" class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</a>
               </div>
            </li>
         </c:if>
      </ul>
   </div>
</nav>