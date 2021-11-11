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
      <h2>All Sporty Shoes</h2>
      <br />

      <div align="center">
        <caption>
          <h3>Order Checkout and Payment Page</h3>
        </caption>
        <table border="1" cellpadding="5" class="table">
          <thead class="thead-dark">
            <tr>
              <th>Order Item Id</th>
              <th>Shoe Id</th>
              <th>Shoe</th>
              <th>Quantity</th>
              <th>Item Price</th>
              <th>Action</th>
            </tr>
          </thead>
          <c:forEach var="orderItem" items="${listOfAllOrderItems}">
            <tr>
              <td><c:out value="${orderItem.id}" /></td>
              <td><c:out value="${orderItem.shoeId}" /></td>
              <td><c:out value="${orderItem.shoeName}" /><br />
                <img src="${orderItem.imageUrl}" height="200" width="200"></td>
              <td><c:out value="${orderItem.purchaseQuantity}" /></td>
              <td><c:out value="$${orderItem.price}" /></td>
              <td>
                <a
                  href="/cart/deleteOrderItem/<c:out value='${orderItem.id}' />"
                  >Delete</a
                >
              </td>
            </tr>
          </c:forEach>
          <tr>
            <td><h5>Subtotal</h5></td>
            <td></td>
            <td></td>
            <td></td>
            <td><h5>$${subtotal}</h5></td>
            <td></td>
          </tr>
          <tr>
            <td><h5>Tax</h5></td>
            <td></td>
            <td></td>
            <td></td>
            <td><h5>$${tax}</h5></td>
            <td></td>
          </tr>
          <tr>
            <td><h5>Total before shipping costs</h5></td>
            <td></td>
            <td></td>
            <td></td>
            <td><h5>$${total}</h5></td>
            <td></td>
          </tr>
          
        </table>
        <div align="center">
            <h2>Payment Details:</h2>
            <form:form
              action="addPaymentDetails"
              method="post"
              modelAttribute="paymentDetails"
            >
              <form:label path="shoeName">Shoe Name:</form:label>
              <form:input path="shoeName" /><br />
    
              <form:label path="stockId">Stock Id:</form:label>
              <form:input path="stockId" /><br />
    
              <form:label path="shoeType">Shoe Type:</form:label>
              <form:select path="shoeType" items="${shoeTypeList}" /><br />
    
              <form:label path="brand">Size:</form:label>
              <form:select path="brand" items="${brandList}" /><br />
    
              <form:label path="color">Color:</form:label>
              <form:select path="color" items="${colorList}" /><br />
    
              <form:label path="gender">Gender:</form:label>
              <form:radiobutton path="gender" value="Male" />Male
              <form:radiobutton path="gender" value="Female" />Female<br />
    
              <form:label path="size">Size:</form:label>
              <form:select path="size" items="${sizeList}" /><br />
    
              <form:label path="quantityOnHand">Quantity:</form:label>
              <form:input path="quantityOnHand" /><br />
    
              <form:label path="inventoryCost">Inventory Cost:</form:label>
              <form:input path="inventoryCost" /><br />
    
              <form:label path="marketPrice">Market Price:</form:label>
              <form:input path="marketPrice" /><br />
    
              <form:label path="countryOfManufacture"
                >Country of Manufacture:</form:label
              >
              <form:select
                path="countryOfManufacture"
                items="${countryOfManufactureList}"
              /><br />
    
              <form:label path="imageUrl">Image Url:</form:label>
              <form:input path="imageUrl" /><br /><br />
    
              <form:button>Register</form:button>
            </form:form>
          </div>
    
      </div>
      <br />
      <a href="/user/displayLoggedInCustomerHomePage"><h4>Customer home</h4></a>
      <br /><br />
    </center>
  </body>
</html>
