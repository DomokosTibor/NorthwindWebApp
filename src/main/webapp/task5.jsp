<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Task 5</title>
</head>

<body>
<h1>Task 5</h1>

<form action="Task5Servlet" method="post">
    <input type="text" value="" name="filter" placeholder="Company Name">
    <input type="submit" value="Filter">
</form>

<table>
<tr>
    <td><b>Company Name</b></td>
    <td><b>Product</b></td>
    <td><b>Price</b></td>
</tr>
<c:forEach items="${task}" var='task'>
<tr>
    <td>${task.companyName}</td>
    <td>${task.productName}</td>
    <td>${task.unitPrice}</td>
</tr>
</c:forEach>

</table>

</body>
</html>
