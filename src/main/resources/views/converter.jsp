<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>HttpMessageConverter Demo</title>
</head>

<body>
<div id="resp">

    <input type="button" onclick="req();" value="请求"/>
    <script src="assets/js/jquery.js" type="text/javascript"></script>
    <script>
        function req() {
            $.ajax({
                url: "convert",
                data: "1-wangyunfei",
                type: "POST",
                contentType: "application/x-wisely",
                success: function (data) {
                    $("#resp").html(data);
                }
            })
        }
    </script>
</div>
</body>
</html>