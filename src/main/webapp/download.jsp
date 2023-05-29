<%@page import="java.util.List"%>
<%@page import="dto.Studentdto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch all data</title>
</head>
<body>
<% List<Studentdto> l1=(List<Studentdto>)request.getAttribute("studentlist"); %>
<table border>
<tr>
<th>Student_id</th>
<th>Student_Name</th>
<th>Student_Gender</th>
<th>Student_Number</th>
<th>Delete</th>
<th>Update</th>
</tr>
<%for(Studentdto a:l1){ %>
<tr>
<td><%=a.getStd_id()%></td>
<td><%=a.getStd_name() %></td>
<td><%=a.getGender()%></td>
<td><%=a.getPh_no()%></td>
<td><a href="delete?id=<%=a.getStd_id()%>">Remove</a></td>
<td><a href="update.jsp?
&id=<%=a.getStd_id()%>
&sname=<%=a.getStd_name()%>
&gender=<%=a.getGender()%>
&phno=<%=a.getPh_no()%>
">Update</a></td>
</tr>
<%} %>
</table>
</body>
</html>