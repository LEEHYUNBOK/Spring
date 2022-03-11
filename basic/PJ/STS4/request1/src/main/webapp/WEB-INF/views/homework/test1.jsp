<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
	div.container { margin:10px;}
	div.container div{display:inline-block;}
	input { width: 150px; padding: 4px; }
	button { padding: 0.4em 2em; margin-top: 10px; }
</style>
</head>
<body>
	<div class="container">
		<form method="post">
			<div>
				<input type="text" name="num1" value="${ num1 }" />
			</div>
			<div>
				<button type="submit">++</button>
			</div>
		</form>
	</div>
</body>
</html>

