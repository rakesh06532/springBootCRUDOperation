<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body>
<div id="main-div">
<h1>PRODUCT REGISTER PAGE</h1>
<form action="save" method="post">
<pre>
CODE:   <input type="text" name="prodCode"><br>
COST:   <input type="text" name="prodCost"><br>
TYPE:   <select name="prodType">
          <option value="">Select</option>
          <option value="NIT">NIT</option>
          <option value="AIT">AIT</option>
          <option value="RIT">RIT</option>
        </select> 
NOTE:   <textarea name="prodNote"></textarea><br>
        <input type="submit" value="Register">
</pre>
</form>
${message }<br><br>
<a href="all">Show All Product</a>
</div>
</body>
</html>