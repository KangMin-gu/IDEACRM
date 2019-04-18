<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>녹취</title>
</head>
<body>

<div id="audio" class="line_audio"></div>
<input type="hidden" name="checkTryCount" id="checkTryCount" value="0">
<input type="hidden" name="checkDownTryCount" id="checkDownTryCount" value="0">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/vocRec.js"></script>
<script>
    $(document).ready(function() {
        var nucIdx = opener.$('#nucIdx').val();
        audio();
        fn_nuc_url_conv_check(nucIdx);
    });
</script>
</body>
</html>