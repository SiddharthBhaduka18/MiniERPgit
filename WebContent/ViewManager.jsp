<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
/* String id = request.getParameter("userid"); */
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "minierp";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<style>

table {

  font-family: arial, sans-serif;

  border-collapse: collapse;

  width: 100%;
  
 

}


td, th {

  /* border: 1px solid #dddddd; */
  border: 1px solid black;

  text-align: left;

  padding: 8px;
  
  border-collapse: collapse;

}


tr:nth-child(even) {

  background-color: #dddddd;

}

th {
  background: #395870;
  color: #fff;
}

h1 {
    text-align:center;
}

</style>
<body bgcolor="skyblue">
<body>

<h1>Manager Data</h1>
<table border="1">
<tr>
<th>id</th>
<th>name</th>
<th>email</th>
<th>pwd</th>
<th>role</th>
<th>delete</th>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from user where role='inventoryManager'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("pwd") %></td>
<td><%=resultSet.getString("role") %></td>
<td><a href="delete.jsp?id=<%=resultSet.getInt(1) %>">delete</a></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<h2>Click below to go on Dashbord Page</h2>
<a href="selectLogin.html">Dashboard</a>
</body>
</html>