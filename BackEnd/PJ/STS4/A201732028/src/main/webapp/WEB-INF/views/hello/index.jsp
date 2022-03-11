<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<style>
	table, td{
	padding: 0 30px 0 0;
		border:1px solid  #000;
		border-collapse: collapse;
	}
</style>
<body>
	<table>
		<tr>
			<td>학번</td>
			<td>${ id }</td>
		</tr>
		<tr>	
			<td>이름</td>
			<td>${ name }</td>
		</tr>
		<tr>
			<td>시각</td>
			<td><fmt:formatDate pattern = "HH:mm:ss" value = "${ now }" /></td>
		</tr>
	</table>
</body>
</html>
