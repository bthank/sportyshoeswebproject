<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ page session="true" %>

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
      <h2>Admin Update Password:</h2>
      <br /><br />
      <form action="/admin/updateAdminPassword" method="post">
        <div class="form-group">
          Admin Username:
          <input
            type="text"
            name="adminUserName"
            value="${sessionScope.adminusername}"
            readonly
          />
          <br /><br />
          New Admin Password: <input type="password" name="adminPwd" />
          <br /><br />
        </div>
        <input
          type="submit"
          class="btn btn-primary mb-2"
          value="Update Password"
        />
      </form>
    </center>
  </body>
</html>
