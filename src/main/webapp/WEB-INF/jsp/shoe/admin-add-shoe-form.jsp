<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
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
    <style type="text/css">
      label {
        display: inline-block;
        width: 200px;
        margin: 5px;
        text-align: left;
      }
      input[type='text'],
      input[type='email'],
      input[type='password'],
      select {
        width: 200px;
      }
      input[type='radio'] {
        display: inline-block;
        margin-left: 45px;
      }
      input[type='checkbox'] {
        display: inline-block;
        margin-right: 190px;
      }

      button {
        padding: 5px;
        margin: 5px;
        border-radius: 10%;
      }
    </style>
  </head>
  <body>
    <center>
      <h1>Sporty Shoes</h1>
      <br />

      <div align="center">
        <h2>Add Shoe To Inventory:</h2>
        <form:form
          action="addShoeToInventory"
          method="post"
          modelAttribute="shoe"
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
    </center>
  </body>
</html>
