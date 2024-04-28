<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Student Registration form by using spring MVC form tag libray -->
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

           <h1>Student Registration</h1>
           <font color='green'>${msg} </font>
           <!-- Spring mvc Form tag this action will be represent which method you want to call when this form is submitted... modelAttribute
           what is the binding class object(student)---|this form is belongs to student  class object | student object i already sended ti the
           controller to UI by using this model Object    -->
           <form:form action="save" modelAttribute="student" method="POST">
                   <table>
                   <!-- Name -->
                       <tr>
                        <!-- first i want to disply the text field we having a tag |  this path representing what ever the field data we are entering.  that 
                        field data should be stored in to binding class(student) object variable(name) -->
                            <td>Name: </td>
                            <td><form:input path="name"/></td>
                       </tr>
                       
                       <!-- Email -->
                       <tr>
                          <td>Email: </td>
                          <td><form:input path="email"/></td>
                       </tr>
                       
                       <!-- Gender -->
                       <tr>
                           <td>Gender: </td>
                           <!-- input we cannot use it is only for text field Gender should be radio button  -->
                           <td>
                                <form:radiobutton path="gender" value="Male"/>Male
                                <form:radiobutton path="gender" value="Female"/>Female
                           </td>
                       </tr>
                       
                       <!-- Course -->
                       <!-- it should be disply dropdown -->
                       <tr>
                           <td>Course: </td>
                           <td>
                                <form:select path="course">
                     <!-- we are sending data to the controller--| and courses is the key. when i am giving the key it will select all option dropdown  -->
                                   <form:option value="">Select_Courses</form:option>
                                   <form:options items="${courses}"/> 
                                </form:select>
                           </td>                       
                       </tr>
                       
                       <!-- Timings -->
                        <tr>
                           <td>Timing : </td>
                           <td>
                                <form:checkboxes items="${timings}" path="timings"/>
                           </td>                       
                       </tr>
                       
                       <!-- Submit Button there is no Submit button you need to develop basic html-->
                        <tr>
                           <td></td>
                           <td>
                                <input type="submit" value="save"/>
                           </td>                       
                       </tr>
                       
                   
                   </table>
           
           </form:form>
           
           <!--when ever  click on the hyperLink it should call viewStudents method  -->
<a href="viewStudents">ViewStudents</a>

</body>
</html>