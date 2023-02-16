<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<table border="1" >
   <thead>
   <tr>
       <th>Id</th>
       <th>Name</th>
       <th>Email ID</th>
       <th>Age</th>
       <th>OfficeName</th>
       <th>Country</th>
       <th>Edit</th>
       <th>Delete</th>
   </tr>
   </thead>
    <tbody>
    <c:forEach var="obj" items="${list}">
    <tr >
        <td><c:out value="${obj.id}"/></td>
        <td><c:out value="${obj.name}"/></td>
        <td><c:out value="${obj.emailId}"/></td>
        <td><c:out value="${obj.age}"/></td>
        <td><c:out value="${obj.officeName}"/></td>
        <td><c:out value="${obj.country}"/></td>
        <td>
            <div>
                <a href="edit-team-leader?id=${obj.id}">edit</a>
         <%--   <i style="text-align: center": class="fa fa-pencil">Edit</i>--%>
            </div>
        </td>
        <td>
            <div>
                <a href="delete-team-leader?id=${obj.id}">Delete</a>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>