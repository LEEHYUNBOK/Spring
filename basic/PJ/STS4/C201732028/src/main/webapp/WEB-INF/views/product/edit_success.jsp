<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
  div.container { width: 310px; margin: 20px auto; }
  table { width: 300px; border-collapse: collapse; }
  thead tr { background-color: #eee; }
  td, th { border: 1px solid #aaa; padding: 5px; }
  td:nth-child(1) { background-color: #eee; }
</style>  
</head>
<body>

<div class="container">

<h1>제품 등록 성공</h1>

<table>
  <tr>
    <td>제품명</td>
    <td>${ product.title }</td>
  </tr>
  <tr>
    <td>카테고리ID</td>
    <td>${ product.category }</td>
  </tr>
  <tr>
    <td>가격</td>
    <td>${ product.price }</td>
  </tr>
  <tr>
    <td>수량</td>
    <td>${ product.quantity }</td>
  </tr>  
  <tr>
    <td>금액</td>
    <td>${ result }</td>
  </tr>    
</table>

</div>
</body>
</html>

