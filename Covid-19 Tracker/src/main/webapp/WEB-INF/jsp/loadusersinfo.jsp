<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Final Project</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style><%@include file="../css/style.css"%></style>
</head>

<body>

<h2>User Information Table</h2>

<table class="w3-table-all">
    <tr class="w3-red">
        <th>Username</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Admin</th>
        <c:forEach var = "User" items = "${userlist}">
    <tr>
        <td>${User.getUserName()}</td>
        <td>${User.getFirstName()}</td>
        <td>${User.getLastName()}</td>
        <td>${User.getEmail()}</td>
        <td>${User.getIsAdmin()}</td>
        <td><a href="/loadusersinfo/delete/${User.getUserId()}">Delete</a></td>
    </tr>
    </c:forEach>
    </tr>


</table>

        <h2> Add User to Database</h2>
<form method="post" action="/loadusersinfo/save">
    <input type = "hidden" name= "userid" value = "">
    UserName:   <br>
    <input type = "text" name = "userName" placeholder="Username" required>
    <br>
    First Name:   <br>
    <input type = "text" name = "firstName" placeholder="First Name" required>
    <br>
    Last Name: <br>
    <input type = "text" name = "lastName" placeholder="Last Name" required>
    <br>
    Email:      <br>
    <input type = "text" name = "email" placeholder="Email" required>
    <br>

    Password:    <br>
    <input type = "password" name ="password" placeholder="Password" required>
    <br>

    Admin Privileges:    <br>
    <input type = "text" name ="admin" placeholder="True or False"required >
    <br>

    <input type= "submit" value = "Submit">
    <br>

</form>
<div id="flip-tabs" >
    <ul id="flip-navigation" >

        <li><a href="/" id="tab-1" >Main Menu</a></li>

    </ul>
</div>
</body>

</html>