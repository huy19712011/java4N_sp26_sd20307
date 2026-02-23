<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script src="js/student.js"></script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<form action="filterInput">
    <input type="text" name="name">
    <br>
    <input type="text" name="password">
    <br>
    <button type="submit">Submit</button>
</form>
<br>
<h3>Post student using AJAX</h3>
<form>
    <div id="responseDiv"></div>
    <div>
        <label>Id</label>
        <input type="text" id="student_id" name="student_id">
    </div>
    <div>
        <label>Name</label>
        <input type="text" id="student_name" name="student_name">
    </div>
    <div>
        <label>Email</label>
        <input type="text" id="student_email" name="student_email">
    </div>
    <div>
        <label>Phone</label>
        <input type="text" id="student_phone" name="student_phone">
    </div>
    <div>
        <button type="button" onclick="saveStudent()">Add</button>
        <button type="button" onclick="showStudents()">Display All</button>
    </div>

</form>


<a href="hello-servlet">Hello Servlet</a>
</body>
</html>