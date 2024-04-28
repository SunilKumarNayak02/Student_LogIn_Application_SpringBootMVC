<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- for the collection data i want to iterate and i want printing for that i am use JSTL tag libray  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>View Students</h1>
 <!-- Iterate the collection -->
 <a href="/">Add New Student</a>
  <table border="1">
     <thead>
          <tr>
              <th>S.No</th>
              <th>Name</th>
              <th>Email</th>
              <th>Gender</th>
              <th>Course</th>
              <th>Timings</th>
          </tr>     
     </thead>
     
     <tbody>
     <!-- We are having the data in the form of the list ... send get request to the url(@GetMapping) it retriving the data from data base table 
     that data is sending to the UI by using model Object model.addAttribute(Key,Value) we can access these value for that we use jstl tag libray -->
     
     <!-- This is my collection.. from this list or collection take each record  store the s Variable -->
    <c:forEach items="${students}" var="student" varStatus="index">
    <tr>
        <td>${index.count}</td>
        <td>${student.name}</td>
       <td>${student.email}</td>
       <td>${student.gender}</td>
      <td>${student.course}</td>
      <td>${student.timings}</td>
    </tr>
</c:forEach>

     
     </tbody>
     </table>
 
</body>
</html>