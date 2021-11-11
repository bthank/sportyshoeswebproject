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
        <h2>User Registration:</h2>
        <form:form action="registerUser" method="post" modelAttribute="user">
          <form:label path="userName">Username:</form:label>
          <form:input path="userName" /><br />

          <form:label path="email">E-mail:</form:label>
          <form:input path="email" /><br />

          <form:label path="password">Password:</form:label>
          <form:password path="password" /><br />

          <form:label path="gender">Gender:</form:label>
          <form:radiobutton path="gender" value="Male" />Male
          <form:radiobutton path="gender" value="Female" />Female
          <form:radiobutton path="gender" value="Other" />Other<br />

          <form:label path="age">Age:</form:label>
          <form:input path="age" /><br />

          <form:label path="firstName">First Name:</form:label>
          <form:input path="firstName" /><br />

          <form:label path="lastName">Last Name:</form:label>
          <form:input path="lastName" /><br /><br />
          <h4>Home Address:</h4>
          <form:label path="homeAddress.addressLine1"
            >Address Line 1:</form:label
          >
          <form:input path="homeAddress.addressLine1" /><br />

          <form:label path="homeAddress.addressLine2"
            >Address Line 2:</form:label
          >
          <form:input path="homeAddress.addressLine2" /><br />

          <form:label path="homeAddress.city">City:</form:label>
          <form:input path="homeAddress.city" /><br />

          <form:label path="homeAddress.state">State:</form:label>
          <form:input path="homeAddress.state" /><br />

          <form:label path="homeAddress.zipCode">Zip Code:</form:label>
          <form:input path="homeAddress.zipCode" /><br />

          <form:label path="homeAddress.country">Country:</form:label>
          <form:input path="homeAddress.country" /><br /><br />

          <form:label path="homePhoneNo">Home Phone No:</form:label>
          <form:input path="homePhoneNo" /><br />

          <form:label path="cellPhoneNo">Cell Phone No:</form:label>
          <form:input path="cellPhoneNo" /><br /><br />

          <form:button>Register</form:button>
        </form:form>
      </div>

      <br />
      <a href="/"><h4>Customer home</h4></a>
      <br /><br />
    </center>
  </body>
</html>
