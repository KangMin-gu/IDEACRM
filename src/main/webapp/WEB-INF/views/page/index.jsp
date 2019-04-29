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


            <div class="row">
              <div class="col-lg-3">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>고객 응답률</h5>
                  </div>
                  <div class="ibox-content">
                    <h1 class="no-margins">40 886,200</h1>
                    <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i></div>
                    <small>Total income</small>
                  </div>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 완료률</h5>
                  </div>
                  <div class="ibox-content">
                    <h1 class="no-margins">40 886,200</h1>
                    <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i></div>
                    <small>Total income</small>
                  </div>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 미완률</h5>
                  </div>
                  <div class="ibox-content">
                    <h1 class="no-margins">40 886,200</h1>
                    <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i></div>
                    <small>Total income</small>
                  </div>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 불만률</h5>
                  </div>
                  <div class="ibox-content">
                    <h1 class="no-margins">40 886,200</h1>
                    <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i></div>
                    <small>Total income</small>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-lg-6">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 접수 유형</h5>
                  </div>
                  <div class="ibox-content">
                    <div>
                      <canvas id="barChart" height="140"></canvas>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 접수 제품</h5>
                  </div>
                  <div class="ibox-content">
                    <div>
                      <canvas id="barChart2" height="140"></canvas>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-lg-6">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>${SITENAME} 공지사항</h5>
                  </div>
                  <div class="ibox-content">
                    <table class="footable table table-striped noticeTable siteNotice">
                      <thead>
                      <tr>
                        <th data-name="NTNUM" data-visible="false" data-filterable="true">
                        <th data-name="TAGNAME" data-filterable="true">말머리</th>
                        <th data-name="TITLE" data-formatter="siteNoticeListFormatter" data-filterable="true">제목</th>
                        <th data-name="WRITER" data-filterable="true">글쓴이</th>
                        <th data-name="REGDATE" data-filterable="true" data-direction="DESC">날짜</th>
                      </tr>
                      </thead>
                    </table>
                  </div>
                </div>
              </div>

              <div class="col-lg-6">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>VOC 공지사항</h5>
                  </div>
                  <div class="ibox-content">
                    <table class="footable table table-striped vocNotice">
                      <thead>
                      <tr>
                        <th data-name="VOCNTNUM" data-visible="false" data-filterable="true">
                        <th data-name="VOCTAGNAME" data-filterable="true">말머리</th>
                        <th data-name="VOCTITLE" data-formatter="indexVocNoticeListFormatter" data-filterable="true">제목</th>
                        <th data-name="VOCWRITER" data-filterable="true">글쓴이</th>
                        <th data-name="VOCREGDATE" data-filterable="true" data-direction="DESC">날짜</th>
                      </tr>
                      </thead>
                    </table>
                  </div>
                </div>
              </div>

            </div>
        </div>
      </div>
    </div>

    <div class="footer">
      <%@ include file="/WEB-INF/views/common/footer.jsp"%>
    </div>

  </div>
</div>

<!--js includ -->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/index.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/notice.js"></script>
<script>
  $(document).ready(function() {
    footableSearchList('/index/sitenotice', $('.siteNotice'));
    footableSearchList('/index/vocnotice', $('.vocNotice'));
  });
</script>
</body>
</html>
