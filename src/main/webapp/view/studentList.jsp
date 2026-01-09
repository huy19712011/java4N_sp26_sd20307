
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Students</h3>
<table border="1">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
  </tr>
  <c:forEach var="tempStudent" items="${students}">
    <tr>
      <td>${tempStudent.id}</td>
      <td>${tempStudent.name}</td>
      <td>${tempStudent.email}</td>
      <td>${tempStudent.phone}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
