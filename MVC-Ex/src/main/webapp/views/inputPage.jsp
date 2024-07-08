<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
</head>
<body>
	<form action="insert",method="post">
		Reg No :- <input type="text" id="reg_no" name="reg_no"><br>
		Name   :- <input type="text" id="name" name="name"><br>
		Subject:- <input type="text" id="subject" name="subject"><br>
		Marks  :- <input type="text" id="marks" name="marks"><br>
		<input type="submit" value="insert Student">
	</form>
</body>
</html>