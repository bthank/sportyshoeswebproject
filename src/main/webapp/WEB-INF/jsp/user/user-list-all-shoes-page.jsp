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

      th, td {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <center>
      <h1>Sporty Shoes</h1>
      <h2>All Sporty Shoes</h2>
      <br />
    </center>

    <div align="center">
      <caption>
        <h3>List of All Sporty Shoes</h3>
      </caption>
      <table border="1" cellpadding="5" class="table">
        <thead class="thead-dark">
          <tr>
            <th>Id</th>
            <th>Shoe Name</th>
            <th>Shoe Type</th>
            <th>Brand</th>
            <th>Color</th>
            <th>Gender</th>
            <th>Size</th>
            <th>Price</th>
            <th>Image</th>
            <th>Action</th>
          </tr>
        </thead>
        <c:forEach var="shoe" items="${listShoes}">
          <tr>
            <td><c:out value="${shoe.id}" /></td>
            <td><c:out value="${shoe.shoeName}" /></td>
            <td><c:out value="${shoe.shoeType}" /></td>
            <td><c:out value="${shoe.brand}" /></td>
            <td><c:out value="${shoe.color}" /></td>
            <td><c:out value="${shoe.gender}" /></td>
            <td><c:out value="${shoe.size}" /></td>
            <td class="align-right"><c:out value="$${shoe.marketPrice}" /></td>
            <td class="align-right"><img src="${shoe.imageUrl}" height="200" width="200"></td>
            <td>
              <a href="/cart/addItemToCart/<c:out value='${shoe.id}' />">Buy</a>
            </td>
          </tr>
        </c:forEach>
      </table>

      <br />
      <a href="/"><h4>Customer home</h4></a>
      <br /><br />
    </div>
  </body>
</html>
