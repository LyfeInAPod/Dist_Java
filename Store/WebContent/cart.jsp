<%@page import="model.Customer"%>
<%@page import="controller.SQLControl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
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

        <h1>Welcome to My Shopping Cart</h1>
        <%
            SQLControl control = new SQLControl();
            ArrayList<Customer> arrCus = control.selectAllCustomer();
        %>
        <form action="ShoppingCardServlet" method="POST">
            <%--
                Load all Customer form data
            --%>
        <p>Customer: <select name="slCustomer">
                <%
                    for (int i = 0; i < arrCus.size(); i++) {
                %>
                <option value="<%=arrCus.get(i).getcID()%>"> <%= arrCus.get(i).getcName() %></option>
                <%
                    }
                %>

            </select>
        </p>
        <p>Payment Method: <input type="text" name="txtMethod" value="Cash" /></p>
        <table id="cartt" border="0">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <%--
                    - Get all product that added to cart
                    - Caculate total cash
                --%>
                <%
                    int totalOrder = 0;
                    HttpSession newSession = request.getSession();
                    if (newSession.getAttribute("cart") != null) {
                        ArrayList<Cart> arrC = (ArrayList<Cart>) newSession.getAttribute("cart");
                        for (int i = 0; i < arrC.size(); i++) {
                            totalOrder += (arrC.get(i).getQuantity() * arrC.get(i).getpPrice());
                %>
                <tr>
                    <td><%= arrC.get(i).getpName()%></td>
                    <td><%= arrC.get(i).getQuantity()%></td>
                    <td><%= arrC.get(i).getpPrice()%></td>
                </tr>
                <%      }
                } else {
                %>
            <h2>You did not select any item yet</h2>
            <%
                }

            %>
        </tbody>
    </table>

    <p>Total: <%= totalOrder%></p>
    <p><input type="submit" value="Confirm" value ="confirm" /></p>
    </form>
     <p><a href="product.jsp"><input id="btn" type="submit" value="Back to Buy" /></a></p>
</body>
</html>
