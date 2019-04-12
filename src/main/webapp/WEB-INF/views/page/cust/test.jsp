<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page import="com.crud.ideacrm.crud.util.Codec" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>IDEACRM</title>
    <%@ include file="/WEB-INF/views/includ/link.jsp"%>
    <!-- FooTable -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
</head>
<style>
</style>
<body>

<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>

        <%

            String test = "kkk";out.write(test);

            Codec a = new Codec();
            String encotest = a.encrypt(test);
            String decotest = a.decrypt(encotest);
            out.write(encotest);
            out.write(decotest);
            String abcd = (String)request.getAttribute("abcd");
            out.write("@@@@@@@@@@@@@@@@@@@"+abcd);
        %>

<button type="button" id="t" >kk</button>

        <div class="footer">
            <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        </div>

    </div>
</div>

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- crud js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/cust.js"></script>
<script>

$('#t').click(function(){
    var urlStr = "/testtt/?";
    var prmStr = "custname=abcd&custno=efgh&mobile=하하하";
    urlStr = encodeURI(urlStr);
    prmStr = encodeURIComponent(prmStr);
    alert(urlStr);
    alert(prmStr);
    console.log(encodeURI(prmStr),' / ',encodeURIComponent(prmStr));
    for(var i=0; i<100;i++){
        var test1 = "custname=abcd&custno=efgh&mobile=하하하";
        test1 = encodeURIComponent(test1);
        console.log(test1 == prmStr);
    }
    debugger;
  location.href = urlStr+encodeURIComponent(prmStr);
});

</script>
</body>
</html>
