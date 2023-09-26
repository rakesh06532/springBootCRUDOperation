<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#main-div{
width: 600px;
height:350px;
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
<h1>PRODUCT EDIT PAGE</h1>
<form:form action="update" method="POST" modelAttribute="product">
<pre>
ID   : <form:input path="prodId" readonly="true"/>
CODE : <form:input path="prodCode"/>
COST : <form:input path="prodCost"/>
TYPE : <form:select path="prodType">
         <form:option value="">SELECT</form:option>
         <form:option value="NIT">NIT</form:option>
         <form:option value="AIT">AIT</form:option>
         <form:option value="RIT">RIT</form:option>
       </form:select>
NOTE : <form:textarea path="prodNote"/>
       <input type="submit" value="Update">
</pre>
</form:form><br>
<a href="all">Show All Product</a>
</div>
</body>
</html>