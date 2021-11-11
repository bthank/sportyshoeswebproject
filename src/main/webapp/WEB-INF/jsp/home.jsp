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
      <h1>Welcome to Sporty Shoes, the world's greatest footwear site!</h1>
      <br /><br />
      <img
        src="mens/sneakers/daniel-storek-JM-qKEd1GMI-unsplash.jpg"
        height="200"
        width="200"
      />
      <img
        src="womens/sneakers/irene-kredenets-dwKiHoqqxk8-unsplash.jpg"
        height="200"
        width="200"
      />
      <img
        src="mens/shoes/iman-ameli-jng0VFa-jRw-unsplash.jpg"
        height="200"
        width="200"
      />
      <img
        src="womens/shoes/alyssa-hurley-1MW0oT45Epo-unsplash.jpg"
        height="200"
        width="200"
      />
      <img
        src="mens/boots/clem-onojeghuo-cjjKEdaBobk-unsplash.jpg"
        height="200"
        width="200"
      />
      <img
        src="womens/boots/alex-quezada-qAyOt0aGsCo-unsplash.jpg"
        height="200"
        width="200"
      />
      <img
        src="mens/sneakers/ervan-m-wirawan-6r280_Z7Efc-unsplash.jpg"
        height="200"
        width="200"
      />

      <br /><br />
      <br /><br />
      <a href="/user/searchSportyShoes"><h2>Search for sporty shoes</h2></a>
      <br />
      <a href="/user/listAllSportyShoes"><h2>List all sporty shoes</h2></a>
      <br /><br /><br />
      <a href="/user/displayUserLoginPage"><h5>Login to order</h5></a>
      <br />
      <a href="/user/displayUserRegistrationPage"
        ><h5>New User Registration</h5></a
      >
      <br />
      <a href="/admin/displayAdminLoginPage"><h5>Login as an Admin</h5></a>
      <br /><br />
    </center>
  </body>
</html>
