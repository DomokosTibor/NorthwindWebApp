<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Task 3</title>
</head>

<body>
<h1>Task 3</h1>

<form action="Task3Servlet" method="post">
    <input type="text" value="" name="filter" placeholder="Company Name">
    <input type="submit" value="Filter">
</form>

<table>
<tr>
    <td><b>Company Name</b></td>
</tr>
<c:forEach items="${task}" var='task'>
<tr>
    <td>${task.companyName}</td>
</tr>
</c:forEach>

</table>

</body>
</html>
