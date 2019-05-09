<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <h5>고객 응대률</h5>
                  </div>
                  <div class="ibox-content">
                    <h1 class="no-margins"> ${responseRate}% </h1>
                    <div class="stat-percent font-bold text-success"><span style="color:green;">전일대비 ${beforedayrate}% </span><i style="color:green;" class="fa fa-level-up"></i></div>
                    <small>  2019-05-10 현재 </small>
                  </div>
                </div>
              </div>

              <div class="col-lg-3">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 불만율</h5>
                  </div>
                  <div class="ibox-content">
                    <h1 class="no-margins"> ${complainRate} % </h1>
                    <div class="stat-percent font-bold text-success"><span style="color:red;"> 전월대비 ${beforemonthrate} % </span> <i style="color:red;" class="fa fa-level-down"></i></div>
                    <small> 2019-05-10 현재</small>
                  </div>
                </div>
              </div>

              <div class="col-lg-3">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 완료건</h5>
                  </div>
                  <div class="ibox-content">
                     <c:forEach var="row" items="${endCnt}">
                        <h1 class="no-margins"> ${row.endCnt} / ${row.endTot} </h1>
                     </c:forEach>
                    <small>   2019-05-01 - 현재</small>
                  </div>
                </div>
              </div>

              <div class="col-lg-3">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 미완건</h5>
                  </div>
                  <div class="ibox-content">
                      <c:forEach var="row" items= "${unendCnt}" >
                        <h1 class="no-margins"> ${row.unendCnt} / ${row.unendTot} </h1>
                      </c:forEach>
                    <small>  2019-05-01 - 현재 </small>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-lg-6">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 접수유형</h5>
                    <div class=" pull-right">
                      <small>기준 : 일</small>
                    </div>
                  </div>
                  <div class="ibox-content">
                    <div class="row">
                      <div class="col-lg-12">
                        <canvas id="receptChart" height="140"></canvas>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-12">
                        <div class=" pull-right">
                          <c:forEach var="type" items= "${receptType}">
                          <span>기간 : 2019-05-01 - 현재</span>&nbsp;<span>/</span>&nbsp;<span>총 : ${type.tot} </span>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-12">
                        <div class=" pull-left">
                          <h5>   5  월 접수유형 </h5>
                            <span> 일반 : <strong> ${type.normal} </strong></span>
                            <span> 칭찬 : <strong> ${type.compliment} </strong></span>
                            <span> 품질 : <strong> ${type.quality} </strong></span>
                            <span> A/S : <strong>  ${type.afterService} </strong></span>
                            <span> 콜센터 : <strong> ${type.center} </strong></span>
                            <span> 매장 : <strong> ${type.store} </strong></span>
                            <span> 불만 : <strong> ${type.complain} </strong></span>
                            <span> 관리 : <strong> ${type.management} </strong></span>
                          </c:forEach>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-lg-6">
                <div class="ibox ">
                  <div class="ibox-title">
                    <h5>상담 접수제품</h5>
                    <small class="pull-right">기준 : 월</small>
                  </div>
                  <div class="ibox-content">
                    <div class="row">
                      <div class="col-lg-12">
                        <canvas id="productChart" height="140"></canvas>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-12">
                        <div class=" pull-right">
                          <span>기간 :  2019-01 - 현재 </span>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-12">
                        <div class=" pull-left">
                            <c:forEach var="product" items= "${productYear}">
                              <h5>   2019 년 종합 판매량 </h5>
                              <span>  폴리콜사놀 10mg(30정) : <strong> ${product.prodCode1} </strong></span>&nbsp;
                              <span> / 폴리콜사놀 5mg(30정) : <strong> ${product.prodCode2} </strong></span>&nbsp;
                              <span> / 폴리콜사놀 10mg(75정) : <strong> ${product.prodCode3} </strong></span>&nbsp;
                              <span> / 폴리콜사놀 10mg(180정) : <strong> ${product.prodCode4} </strong></span>&nbsp;
                              <span> / 폴리콜사놀 in 오메가 : <strong> ${product.prodCode5} </strong></span>&nbsp;
                            </c:forEach>
                        </div>
                      </div>
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
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
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
