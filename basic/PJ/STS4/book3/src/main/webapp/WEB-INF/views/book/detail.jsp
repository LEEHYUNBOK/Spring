<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>
    div.container { width: 600px; margin: 50px auto; }
    body { font-family: 굴림체; }
    table { width: 500px;  border-collapse: collapse; }
    table td:nth-child(1) { background-color: #eee; width:30%; text-align:center; }
    td { padding: 5px; border: 1px solid lightgray; }   
  </style>
</head>
<body>

<div class="container">

<h1>책</h1>

<c:if test="${ empty book}">
	<div style="color: red">조회 결과가 없습니다.</div>
</c:if>

<c:if test="${ not empty book}">
<table>
  <tr>
    <td>ID</td>
    <td>${ book.id }</td>
  </tr>
  <tr>
    <td>책 제목</td>
    <td>${ book.title }</td>
  </tr>  
  <tr>
    <td>카테고리 ID</td>
    <td>${ book.categoryId }</td>
  </tr>
  <tr>
    <td>카테고리 이름</td>
    <td>${ book.categoryName }</td>
  </tr>
  <tr>
    <td>저자</td>
    <td>${ book.author }</td>
  </tr>
  <tr>
    <td>가격</td>
    <td>${ book.price }</td>
  </tr>
</table>
</c:if><br/>
<a href="javascript:window.history.back()">돌아가기</a>
</div>
</body>
</html>

