<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>servlet async support</title>
</head>
<body>
<script src="assets/js/jquery.js"></script>
<script>
    deferred();

    function deferred() {
        $.get("defer", function (data) {
            console.log(data);
            deferred();
        })
    }
</script>
</body>

</html>