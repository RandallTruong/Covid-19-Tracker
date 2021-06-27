<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Covid Tracker</title>
    <style><%@include file="../css/style.css"%></style>
</head>
<body>
<hr>
<h1>Covid-19 </h1>
<form method="get" action="/get/" >
    <select name = "state">
        <option value = "AL">AL</option>
        <option value = "AK">AK</option>
        <option value = "AZ">AZ</option>
        <option value = "AR">AR</option>
        <option Value = "CA">CA</option>
        <option Value = "CO">CO</option>
        <option Value = "CT">CT</option>
        <option Value = "DE">DE</option>
        <option Value = "FL">FL</option>
        <option Value = "GA">GA</option>
        <option Value = "HI">HI</option>
        <option Value = "ID">ID</option>
        <option Value = "IL">IL</option>
        <option Value = "IN">IN</option>
        <option Value = "IA">IA</option>
        <option Value = "KS">KS</option>
        <option Value = "KY">KY</option>
        <option Value = "LA">LA</option>
        <option Value = "ME">ME</option>
        <option Value = "MD">MD</option>
        <option Value = "MA">MA</option>
        <option Value = "MI">MI</option>
        <option Value = "MN">MN</option>
        <option Value = "MS">MS</option>
        <option Value = "MO">MO</option>
        <option Value = "MT">MT</option>
        <option Value = "NE">NE</option>
        <option Value = "NV">NV</option>
        <option Value = "NH">NH</option>
        <option Value = "NJ">NJ</option>
        <option Value = "NM">NM</option>
        <option Value = "NY">NY</option>
        <option Value = "NC">NC</option>
        <option Value = "ND">ND</option>
        <option Value = "OH">OH</option>
        <option Value = "OK">OK</option>
        <option Value = "OR">OR</option>
        <option Value = "PA">PA</option>
        <option Value = "RI">RI</option>
        <option Value = "SC">SC</option>
        <option Value = "SD">SD</option>
        <option Value = "TN">TN</option>
        <option Value = "TX">TX</option>
        <option Value = "UT">UT</option>
        <option Value = "VT">VT</option>
        <option Value = "VA">VA</option>
        <option Value = "WA">WA</option>
        <option Value = "WV">WV</option>
        <option Value = "WI">WI</option>
        <option Value = "WY">WY</option>
    </select>
    <input required type='date' name= "date" min="2020-03-07"  />
    <input type="submit" value="Submit" >
</form>
<div id="flip-tabs" >
    <ul id="flip-navigation" >

        <li><a href="/loadcovidinfo" id="tab-1" >Covid Table</a></li>
        <li><a href="/loadusersinfo" id="tab-2" >Users Table</a></li>
        <li><a href="/chart" id="tab-3" >Chart</a></li>
    </ul>
</div>

<hr/>
<div >
    <h2>State</h2> <h3><%=request.getParameter("state")%></h3>
    <h2>Total Number of Tests</h2> <h3><%=request.getParameter("totalTestResults")%></h3>
    <h2>Number of positive Cases</h2> <h3><%=request.getParameter("positive")%></h3>
    <h2>Number of Negative Cases</h2> <h3><%=request.getParameter("negative")%></h3>
    <h2>Total Number of Deaths</h2> <h3><%=request.getParameter("death")%></h3>
    <h2>Date</h2> <h3><%=request.getParameter("date")%></h3>
</div>


<div class="container">
    <form method="post" action="/save">
        <input type="hidden" name="state" value="<%=request.getParameter("state")%>">
        <input type="hidden" name="totaltestresults" value="<%=request.getParameter("totalTestResults")%>">
        <input type="hidden" name="positive" value="<%=request.getParameter("positive")%>">
        <input type="hidden" name="negative" value="<%=request.getParameter("negative")%>">
        <input type="hidden" name="death" value="<%=request.getParameter("death")%>">
        <input type="hidden" name="date" value="<%=request.getParameter("date")%>">
        <input type="submit" value="save">
    </form>
</div>



</body>
</html>
