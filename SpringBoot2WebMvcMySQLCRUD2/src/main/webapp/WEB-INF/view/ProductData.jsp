<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#main-div{
width: 600px;
height:100%;
background: pink;
margin: auto;
padding-left: 20px;
padding-top: 15px;
box-shadow: 2px 2px 4px 4px blue;
margin-top: 30px;
padding-bottom:30px;
}
h1{
text-align:center;
text-decoration: underline;
color: green;
}
body{
background-color: rgb(209, 204, 204);
}
</style>
</head>
<body>
 <div id="main-div">
 <h1>CRUD OPERATIONS</h1>
<table border="1">
<tr>
     <th>ID</th>
     <th>CODE</th>
     <th>COST</th>
     <th>TYPE</th>
     <th>NOTE</th>
     <th>DISCOUNT</th>
     <th>GST</th> 
     <th colspan="2">OPERATIONS</th>
  </tr>
  <c:forEach items="${list}" var="ob">
  <tr>
      <td>${ob.prodId}</td>
      <td>${ob.prodCode}</td>
      <td>${ob.prodCost}</td>
      <td>${ob.prodType}</td>
      <td>${ob.prodNote}</td>
      <td>${ob.prodDiscount}</td>
      <td>${ob.prodGst}</td>
      <td>
      <a href="delete?id=${ob.prodId}">DELETE</a>
      </td>
      <td>
      <a href="edit?id=${ob.prodId}">EDIT</a></td>
    </tr>
  </c:forEach>
</table> <br>
<a href="register">New Product</a><br><br>
${message }
</div>
</body>
</html>