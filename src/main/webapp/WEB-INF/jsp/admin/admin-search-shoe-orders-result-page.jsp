<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Sporty Shoes Web Application</title>

    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->

    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
      integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
      integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
      crossorigin="anonymous"
    ></script>

    <style>
      .align-right {
        text-align: right;
      }
    </style>
    <style>
      body {
        background-color: lightblue;
      }

      th,
      td {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <center>
      <h1>Sporty Shoes</h1>
      <h2>Shoe Order Search Results</h2>
      <br />
    </center>

    <div align="center">
      <caption>
        <h3>Qualifying Shoe Orders</h3>
      </caption>
      <table border="1" cellpadding="5" class="table">
        <thead class="thead-dark">
          <tr>
            <th>Shoe Order Id</th>
            <th>Username</th>
            <th>Order Date</th>
            <th>Order Type</th>

            <th>Shipping Carrier</th>
            <th>Shipping Choice</th>
            <th>Shipped</th>
            <th>Ship Date</th>
          </tr>
        </thead>
        <c:forEach var="shoeOrderItem" items="${listOfShoeOrderItems}">
          <tr>
            <td><c:out value="${shoeOrderItem.shoeOrderId}" /></td>
            <td><c:out value="${shoeOrderItem.userName}" /></td>
            <td><c:out value="${shoeOrderItem.dateOfOrder}" /></td>
            <td><c:out value="${shoeOrderItem.orderType}" /></td>

            <td><c:out value="${shoeOrderItem.shippingCarrier}" /></td>
            <td><c:out value="${shoeOrderItem.shippingChoice}" /></td>
            <td><c:out value="${shoeOrderItem.shipped}" /></td>
            <td><c:out value="${shoeOrderItem.shippedDate}" /></td>
          </tr>
        </c:forEach>
      </table>

      <br />
      <a href="/admin/displayAdminHomePage"><h5>Admin Home</h5></a>
      <br /><br />
      <a href="/"><h4>Customer home</h4></a>
      <br /><br />
    </div>
  </body>
</html>
