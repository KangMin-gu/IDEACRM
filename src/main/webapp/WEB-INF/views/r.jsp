<%--
  Created by IntelliJ IDEA.
  User: mingukang
  Date: 2019-04-27
  Time: 21:38
  To change this        template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${a}
<br/>

<c:forEach items="${b}" var="list">

    <li> ${list }</li>

</c:forEach>
<img src="${pageContext.request.contextPath}/mail/check" width="0" height="0" border="0"/>
<script>

</script>
</body>
</html>
