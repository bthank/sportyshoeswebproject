<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
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
      body {
        background-color: lightblue;
      }
    </style>
  </head>
  <body>
    <center>
      <h1>Sporty Shoes</h1>
      <br />
      <h2>Admin Home Page</h2>

      <br /><br />
      <a href="/admin/displayAdminUpdatePasswordPage"
        ><h5>Update Admin password</h5></a
      >
      <br />
      <a href="/shoe/displayAddShoeToInventoryPage"
        ><h5>Add Shoe to Inventory</h5></a
      >
      <br />
      <a href="/admin/displaySignedUpUsersPage"
        ><h5>Display List of Users Who Signed Up</h5></a
      >
      <br />
      <a href="/admin/displaySearchUsersPage"><h5>Search Users</h5></a>
      <br />
      <a href="/admin/displayPurchaseReportPage"
        ><h5>Display Purchase Report</h5></a
      >
      <br />
      <a href="/admin/displaySearchShoeOrdersPage"
        ><h5>Search Shoe Orders</h5></a
      >
      <br />
      <br /><br />
    </center>
  </body>
</html>
