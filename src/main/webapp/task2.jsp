<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Task 2</title>
</head>

<body>
<h1>Task 2</h1>

<form action="Task2Servlet" method="post">
    <input type="text" value="" name="filter" placeholder="Company Name">
    <input type="submit" value="Filter">
</form>

<table>
<tr>
    <td><b>Company Name</b></td>
    <td><b>Number of Products</b></td>
</tr>
<c:forEach items="${task}" var='task'>
<tr>
    <td>${task.companyName}</td>
    <td>${task.numberOfProducts}</td>
</tr>
</c:forEach>

</table>

</body>
</html>
