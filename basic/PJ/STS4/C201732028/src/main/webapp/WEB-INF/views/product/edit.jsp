<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
  div.container { width: 400px; margin: 20px auto; }
  form div { margin-bottom: 20px; }
  label { display: block; }   
  input, select { width: 200px; padding: 5px; }
  button { padding: 0.4em 1.5em; }
  div.error { margin-top: 20px; color: red; }
</style>
</head>
<body>

<div class="container">


<form method="post">
  <h1>제품 등록</h1>
  <div>
    <label>제품명</label>
    <input type="text" class="text" name="title" value="${ product.title }"/>
  </div>
    <div>
    <label>카테고리</label>
    <select name="category">
      <option value="0" ${ product.category == 0 ? "selected" : "" }>카테고리를 선택하세요</option>
      <option value="1" ${ product.category == 1 ? "selected" : "" }>과자</option>
      <option value="2" ${ product.category == 2 ? "selected" : "" }>음료</option>
      <option value="3" ${ product.category == 3 ? "selected" : "" }>빵</option>
    </select>
  </div>
  <div>
    <label>가격</label>
    <input type="text" class="text" name="price" value="${ product.price }" />
  </div>
  <div>
    <label>수량</label>
    <input type="text" class="text" name="quantity" value="${ product.quantity }" />
  </div>
  <button type="submit" class="btn">제출</button>
</form>

<c:if test="${ not empty errorMsg }">
  <div class="error">${ errorMsg }</div>
</c:if>
</div>
</body>
</html>

