<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style>
    div.container { width: 600px; margin: 50px auto; }
    thead th { background-color: #eee; }
    table{ border-collapse: collapse; width: 100%; }
    td, th { padding: 4px; border: 1px solid lightgray; }
    td{ text-align: center; }
    .btn { padding: 0.4em 1em; border: 1px solid gray;
       border-radius: 0.5em; background: linear-gradient(#fff, #ddd);
       text-decoration: none; color: black; display: inline-block; }
  </style>
</head>
<body>

<div class="container">

<h1>책</h1>

<c:if test="${ empty books}">
	<div style="color: red">조회 결과가 없습니다.</div><br/>
	<a href="javascript:window.history.back()">돌아가기</a>
</c:if>

<c:if test="${ not empty books}">
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
      	<th>ID</th>
        <th>제목</th>
        <th>저자</th>
        <th>카테고리 ID</th>
        <th>카테고리 제목</th>
        <th>가격</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${ books }">
        <tr>
          <td>${ book.id }</td>
          <td>${ book.title }</td>
          <td>${ book.author }</td>
          <td>${ book.categoryId }</td>
          <td>${ book.categoryName }</td>
          <td>${ book.price }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</c:if>
<br/>
<a class="btn" href="javascript:window.history.back()">돌아가기</a>
</div>
</body>
</html>

