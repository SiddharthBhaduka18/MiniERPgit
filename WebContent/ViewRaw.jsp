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


<h1>Raw Data </h1>
<table border="1">
<tr>
<th>id</th>
<th>item</th>
<th>quantity</th>
<th>ppu</th>
<th>role</th>
<th>delete</th>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from material where role='rawMaterial'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("item") %></td>
<td><%=resultSet.getString("quantity") %></td>
<td><%=resultSet.getString("ppu") %></td>
<td><%=resultSet.getString("role") %></td>
<td><a href="deleteRaw.jsp?id=<%=resultSet.getInt(1) %>">delete</a></td>
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
<a href="inventoryLogin.html">Dashboard</a>
</body>
</html>