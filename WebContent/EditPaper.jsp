<!DOCTYPE html>
<html>
<head>
	<%@include file= "include/header.jsp" %>

</head>
<body>
	<%@include file = "include/navbar.jsp" %>
	
        <h1>Edit Your Paper</h1>
        <form method="post" action="EditPaper">
            <table border="0">
                <tr>
                    <td>Edit file Name: </td>
                    <td><input type="text" name="fileName" value="<c:out value='${paperinfo.papername}'/>"></td>
                </tr>
                <tr>
                    <td>Edit Co-Author: </td>
                    <td><input type="text" value="<c:out value='${paperinfo.coauthor}'/>"></td>
                    <td>
                         <select name="authors">
                            <c:forEach items="${listAuthor}" var="author">
                            <option value="${author}">${author}</option>
                            </c:forEach>
                            </select>
                            <br/><br/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Edit">
                    </td>
                </tr>
            </table>
        </form>

</body>
</html>