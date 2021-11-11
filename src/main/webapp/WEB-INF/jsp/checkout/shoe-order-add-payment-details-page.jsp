<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ taglib prefix="form"
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
      .paymentdetail-div {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
      }
      .form-label-and-input {
        display: flex;
        justify-content: right;
        flex-direction: row;
      }
      .form-label {
        display: flex;
        justify-content: left;      
        flex-direction: row;
        width: 200px;
        height: 30px;
        
         
      }
      .form-input {
        display: flex;
        justify-content: right;
        flex-direction: row;
        width: 200px;
        height: 30px;
      }

    </style>
  </head>
  <body>
    <center>
      <h1>Sporty Shoes</h1>
      <h2>Add Payment Detail</h2>
      <br />
      <br />

      <h3>Payment Information:</h3><br />

      <div align="center" class="paymentdetail-div">
        <form:form
          action="addPaymentDetail"
          method="post"
          modelAttribute="paymentDetail"
        >
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="payerFirstName">Payer First Name:</form:label></span>
            <span class="form-input"><form:input path="payerFirstName" /></span> 
          </div>
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="payerLastName">Payer Last Name:</form:label></span>
            <span class="form-input"><form:input path="payerLastName" /></span> 
          </div>
          <br /><h4>Billing Address:</h4><br />
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="billingAddress.addressLine1">Address Line 1:</form:label></span>
            <span class="form-input"><form:input path="billingAddress.addressLine1" /></span> 
          </div>
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="billingAddress.addressLine2">Address Line 2:</form:label></span>
            <span class="form-input"><form:input path="billingAddress.addressLine2" /></span> 
          </div>
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="billingAddress.city">City:</form:label></span>
            <span class="form-input"><form:input path="billingAddress.city" /></span> 
          </div>         
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="billingAddress.state">State:</form:label></span>
            <span class="form-input"><form:input path="billingAddress.state" /></span> 
          </div>
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="billingAddress.zipCode">Zip Code:</form:label></span>
            <span class="form-input"><form:input path="billingAddress.zipCode" /></span> 
          </div>          
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="billingAddress.country">Country:</form:label></span>
            <span class="form-input"><form:select path="billingAddress.country" items="${countryList}" /></span> 
          </div>     
          <br /><h4></h4><br />     
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="billingPhoneNo">Billing Phone No:</form:label></span>
            <span class="form-input"><form:input path="billingPhoneNo" /></span> 
          </div>     
          <br /><h4>Card Details:</h4><br />     
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="paymentType">Card Type:</form:label></span>
            <span class="form-input"><form:select path="paymentType" items="${paymentTypeList}" /></span> 
          </div>          
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="cardNo">Card No:</form:label></span>
            <span class="form-input"><form:input path="cardNo" /></span> 
          </div>          
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="cardExpirationMonth">Card Exp Month:</form:label></span>
            <span class="form-input"><form:select path="cardExpirationMonth" items="${expMonthList}" /></span> 
          </div>                    
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="cardExpirationYear">Card Exp Year:</form:label></span>
            <span class="form-input"><form:select path="cardExpirationYear" items="${expYearList}" /></span> 
          </div>          
          <div class="form-label-and-input">
            <span class="form-label"><form:label path="cardCvvCode">Card Cvv Code:</form:label></span>
            <span class="form-input"><form:input path="cardCvvCode" /></span> 
          </div>                
          <div class="form-label-and-input">
            <span class="form-label"></span>
            <span class="form-input"><form:button>Register</form:button></span> 
          </div>           

        </form:form>

    </center>
  </body>
</html>
