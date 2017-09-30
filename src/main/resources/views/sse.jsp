<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSE demo</title>
</head>
<body>
<div id="msgFrompPush"></div>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script>
    //sse是服务器一直抓住请求不放直到有了消息发给响应，之后浏览器自动又发起请求。
    if (!!window.EventSource) {
        var source = new EventSource('push');
        s = '';
        source.addEventListener('message', function (e) {
            s += e.data + "<br/>";
            $("#msgFrompPush").html(s);
        },false);
        source.addEventListener("open", function (e) {
            console.log("连接打开。");
        }, false);
    } else {
        console.log("你的浏览器不支持SSE");
    }
</script>
</body>
</html>