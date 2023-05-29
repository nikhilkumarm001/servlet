<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating using urlRW with jsp file</title>
</head>
<body>
<form action="updating">
Id: <input type="number" name="sid" value=<%=request.getParameter("id") %> readonly="readonly"><br><br>
Name: <input type="text" name="name" value=<%=request.getParameter("sname")%>><br><br>
Phone Number: <input type="tel" name="sno" value=<%=request.getParameter("phno")%>><br><br>
<%if(request.getParameter("gender").equals("male")){ %>
Male:<input type="radio" name="gender" value="male" checked="checked">
Female:<input type="radio" name="gender" value="female">
<%} else{%>
Male:<input type="radio" name="gender" value="male">
Female:<input type="radio" name="gender" value="female" checked="checked">
<%} %>
<button type="submit">Update</button>
</form>
</body>
</html>