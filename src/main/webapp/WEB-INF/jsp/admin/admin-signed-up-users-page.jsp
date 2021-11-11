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
      <h2>Admin Site</h2>
      <br />
    </center>

    <div align="center">
      <caption>
        <h3>All Signed Up Users</h3>
      </caption>
      <table border="1" cellpadding="5" class="table">
        <thead class="thead-dark">
          <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Age</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address Line 1</th>
            <th>Address Line 2</th>
            <th>City</th>
            <th>State</th>
            <th>Zip Code</th>
            <th>Country</th>
            <th>Home Ph No</th>
            <th>Cell Ph No</th>
          </tr>
        </thead>
        <c:forEach var="user" items="${listSignedUpUsers}">
          <tr>
            <td><c:out value="${user.userName}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.gender}" /></td>
            <td><c:out value="${user.age}" /></td>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <td><c:out value="${user.homeAddress.addressLine1}" /></td>
            <td><c:out value="${user.homeAddress.addressLine2}" /></td>
            <td><c:out value="${user.homeAddress.city}" /></td>
            <td><c:out value="${user.homeAddress.state}" /></td>
            <td><c:out value="${user.homeAddress.zipCode}" /></td>
            <td><c:out value="${user.homeAddress.country}" /></td>
            <td><c:out value="${user.homePhoneNo}" /></td>
            <td><c:out value="${user.cellPhoneNo}" /></td>
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
