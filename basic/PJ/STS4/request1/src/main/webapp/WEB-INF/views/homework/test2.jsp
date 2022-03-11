<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
	div.container {	display: inline-block; margin: 20px 0px 0px 40px; }
	form div { margin-bottom: 10px; }
	select { width: 140px; padding: 4px; }
	input {	width: 150px; padding: 4px; }
	button { padding: 0.4em 2em; width: 80px;}
</style>
</head>
<body>
	<div class="container">
		<form method="post">
			<div>
				<select name="cmd">
					<option value="one" ${ cmd == "one" ? "selected" : "" }>one</option>
					<option value="two" ${ cmd == "two" ? "selected" : "" }>two</option>
					<option value="three" ${ cmd == "three" ? "selected" : "" }>three</option>
				</select>
			</div>
			<div>
				<input type="text" name="stringNum" value="${ cmd }" />
			</div>
			<div>
				<button type="submit">Ok</button>
			</div>
		</form>
	</div>
</body>
</html>

