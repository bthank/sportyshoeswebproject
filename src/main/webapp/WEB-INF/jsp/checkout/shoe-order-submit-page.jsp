<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
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
      <h2>Submit Shoe Order</h2>
      <br />

      <div align="center">
        <div align="center">
          <h2>Click to submit order:</h2>
          <form:form
            action="submitShoeOrder"
            method="post"
            modelAttribute="shoeOrder"
          >
            <form:button>Submit Order</form:button>
          </form:form>
        </div>
      </div>
      <br />
      <a href="/user/displayLoggedInCustomerHomePage"><h4>Customer home</h4></a>
      <br /><br />
    </center>
  </body>
</html>
