<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    .btn { padding: 0.4em 1em; border: 1px solid gray;
       border-radius: 0.5em; background: linear-gradient(#fff, #ddd);
       text-decoration: none; color: black; display: inline-block; }
    a.btn { float: right; margin: -20px 0 5px 0; }
  </style>
</head>
<body>
<div class="container">

  <h1>연락처 목록</h1>

  <a href="create" class="btn">연락처 등록</a>
  <table class="table table-bordered table-condensed">
    <thead>
      <tr>
        <th>이름</th>
        <th>유형</th>
        <th>성별</th>
        <th>전화번호</th>
        <th>이메일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="person" items="${ persons }">
        <tr>
          <td><a href="edit?id=${ person.id }">${ person.name }</a></td>
          <td>${ person.categoryName }</td>
          <td>${ person.sex }</td>
          <td>${ person.phone }</td>
          <td>${ person.email }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>

