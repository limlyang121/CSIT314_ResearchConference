<!DOCTYPE html>
<html>
<head>
<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>

         <form method="post" action="editReview">
          <table border="0">
          <tr>
               <td>Your Review </td>
                  <td><textarea id="review" name="review" rows="4" cols="50" >${reviewinfo.review}</textarea></td>
                 </tr>
                 <tr>
                    <td>Rating </td>
                    <td><input type="text" value="<c:out value='${reviewinfo.rating}'/>"></td>
                    <td>
                    	<select name="rating" id="rating">
			  				<option value="-3">3	</option>
			  				<option value="-2">-2	</option>
			  				<option value="-1">-1	</option>
			 				<option value="0">0		</option>
 				  			<option value="1">1		</option>
							<option value="2">2		</option>
   				  			<option value="3">3		</option>
			     		</select>
		     		</td>
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