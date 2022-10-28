<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Paper</title>
</head>
<body>
	<%@include file = "include/navbar.jsp" %>

         <form method="post" action="submitReview">
          <table border="0">
          <tr>
               <td>Your Review </td>
                  <td><textarea id="review" name="review" rows="4" cols="50">
                       </textarea></td>
                 </tr>
                 <tr>
                    <td>Rating </td>
                    <td><select name="rating" id="rating">
  				<option value="1">1</option>
  				<option value="2">2</option>
  				<option value="3">3</option>
 				 <option value="4">4</option>
 				  <option value="5">5</option>
			     </select></td>
                </tr>
                <tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit">
                    </td>
                </tr>
			</table>
         </form>

</body>
</html>