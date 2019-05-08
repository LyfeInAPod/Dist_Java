<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.SQLControl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List products</title>
        				<style>
#cartt {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#cartt td, #cartt th {
  border: 1px solid #ddd;
  padding: 8px;
}

#cartt tr:nth-child(even){background-color: #f2f2f2;}

#cartt tr:hover {background-color: #ddd;}

#cartt th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #074383;
  color: white;
}

input[type=submit]{
  background-color: #2B9BAF;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}

#btn{
  background-color: #69B04C;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}

</style>
        
    </head>
    <body>
        <%
            SQLControl control = new SQLControl();
            ArrayList<Product> arrP = control.selectAllProduct();
        %>
        <h1>Select thing to buy</h1>
        <form action="ProductServlet" method="GET" >
        <table id="cartt" border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
					<th>Product Name</th>
                    <th>Price </th>
                    <th>Product Description</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%  if (arrP != null) {
                        for (int i = 0; i < arrP.size(); i++) {
                %>
                <tr>
                    <td><%= arrP.get(i).getpId()%></td>
                    <td><%= arrP.get(i).getpName()%></td>
                    <td><%= arrP.get(i).getpPrice()%></td>
                    <td><%= arrP.get(i).getDes()%></td>
                    <td>
                        <a href="ProductServlet?id=<%=arrP.get(i).getpId()%>"><input type="submit" value="Buy" /></a> 
                    </td>
                </tr>
                <% }
                    }%>
            </tbody>
        </table>
        </form>
          <p><br><br><a href="cart.jsp"><input id="btn" type="submit" value="Back to Shoping cart" /></a></p>
    </body>
</html>