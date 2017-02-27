<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ad</title>
</head>
<body>
    <h1>${ads.desc}</h1>
    <h1>${ads.image_url}</h1>
    <h1>${ads.click_url}</h1>
    <h1>${ads.success}</h1>
    <h1>${ads.msg}</h1>

     <a href=${ads.click_url}>${ads.desc} </a>
     <a href=${ads.click_url}><img src="${ads.image_url}" /></a>
</body>
</html>
