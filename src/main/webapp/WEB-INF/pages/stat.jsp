<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>stat</title>
</head>
<body>
    <h1>广告1</h1>
    <ul>
    	<li>展示次数 ：${mStat.imp_num_ad1}</li>
		<li>点击次数 ：${mStat.clk_num_ad1}</li>
		<li>CTR ：${mStat.ctr_ad1}%</li>
	</ul>
	<h1>广告2</h1>
	<ul>
    	<li>展示次数 ：${mStat.imp_num_ad2}</li>
		<li>点击次数 ：${mStat.clk_num_ad2}</li>
		<li>CTR ：${mStat.ctr_ad2}%</li>
	</ul>
    
    <h1>广告位1</h1>
    <ul>
    	<li>展示次数 ：${mStat.imp_num_seat1}</li>
		<li>点击次数 ：${mStat.clk_num_seat1}</li>
	</ul>
	
    <h1>广告位2</h1>
    <ul>
    	<li>展示次数 ：${mStat.imp_num_seat2}</li>
		<li>点击次数 ：${mStat.clk_num_seat2}</li>
	</ul>
</body>
</html>
