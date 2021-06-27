<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Final Project</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style><%@include file="../css/style.css"%></style>
</head>

<body>

<h2>Covid-19 Information Table</h2>

<table class="w3-table-all">
    <tr class="w3-red">
        <th>State</th>
        <th>Total Number of Tests</th>
        <th>Number of Positive Tests</th>
        <th>Number of Negative Tests</th>
        <th>Number of Deaths</th>
        <th>Date</th>
        <c:forEach var = "Covid19Info" items = "${covidinfolist}">
    <tr>
        <td>${Covid19Info.getState()}</td>
        <td>${Covid19Info.getTotalTestResults()}</td>
        <td>${Covid19Info.getPostive()}</td>
        <td>${Covid19Info.getNegative()}</td>
        <td>${Covid19Info.getDeath()}</td>
        <td>${Covid19Info.getDate()}</td>
        <td><a href="/delete/${Covid19Info.getId()}">Delete</a></td>
    </tr>
    </c:forEach>
    </tr>


    </table>

<div id="flip-tabs" >
    <ul id="flip-navigation" >

        <li><a href="/" id="tab-1" >Main Menu</a></li>

    </ul>
</div>

</body>
</html>