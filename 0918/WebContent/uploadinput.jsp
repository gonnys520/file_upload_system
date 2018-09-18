<%@ page language="java" contentType="text/html; charset=UTF-8">
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>하이 헬로 안녕~!~!~!~!~!~</h1>


<img src = 'http://localhost:8-80/getfile?fname=aaa.jpg'/>

<a href ='http://localhost:8-80/getfile?fname=> 구멍  가게1.jpg'>
<h2>구멍  가게1 파일</h2>
</a>

<form action="/upload1" method="post" enctype="multipart/form-data">
<input type = "text" name="mname">
<input type = "number" name="price">

<input type = 'file' name='files' multiple="multiple">

<button>Save</button>

</form>

</body>
</html>