<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>IDEACRM</title>
  <%@ include file="/WEB-INF/views/includ/link.jsp"%>
</head>
<body>

<div id="wrapper">
  <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
  <div id="page-wrapper" class="gray-bg">
    <div class="row border-bottom">
      <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
    </div>

    <div class="wrapper wrapper-content animated fadeInRight">
      <div class="row">
        <div class="col-lg-12">
          <div class="text-center m-t-lg">
            <h1>
              INSPINIA Static Seed Project for BS4
            </h1>
            <small>
              It is an application skeleton for a typical web app. You can use it to quickly bootstrap your webapp projects and dev environment for these projects.
            </small>
          </div>
        </div>
      </div>
    </div>

    <div class="footer">
      <%@ include file="/WEB-INF/views/common/footer.jsp"%>
    </div>

  </div>
</div>

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>

<script>
</script>
</body>
</html>
