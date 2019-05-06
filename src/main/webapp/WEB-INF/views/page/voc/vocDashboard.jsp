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
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <!-- orris -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
</head>
<body>
<c:set var="menuactive" value='vocdashM'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
           <div class="row">
                <div class="col-lg-12">
                    <a href="#" onclick="openNewWindowFullScreen('${pageContext.request.contextPath}/voc')" class="btn btn-default"><i class="fa fa-compress fa-lg"></i> CS 접속</a>
                    <!--<a href="${pageContext.request.contextPath}/voc/notice" class="btn btn-default"><i class="fa fa-bell fa-lg"></i>콜센터 공지</a>
                    <a href="${pageContext.request.contextPath}/service" class="btn btn-default"><i class="fa fa-edit fa-lg"></i>서비스 관리</a>
                    <a href="${pageContext.request.contextPath}/service/delivery" class="btn btn-default"><i class="fa fa-reply fa-lg"></i> 서비스 이관 정보</a>-->
                    <a href="#" onclick="openNewWindowFullScreen('${pageContext.request.contextPath}/voc/notice')" class="btn btn-default"><i class="fa fa-bell fa-lg"></i>콜센터 공지</a>
                    <a href="#" onclick="openNewWindowFullScreen('${pageContext.request.contextPath}/service')" class="btn btn-default"><i class="fa fa-edit fa-lg"></i>서비스 관리</a>
                    <a href="#" onclick="openNewWindowFullScreen('${pageContext.request.contextPath}/service/delivery')" class="btn btn-default"><i class="fa fa-reply fa-lg"></i> 서비스 이관 정보</a>
                </div>
            </div>


            <br/>
            <div class="row">
                <div class="col-lg-5">
                  <div class="row">
                      <div class="col-lg-12">
                          <div class="ibox">
                              <div class="ibox-title">
                                  <h5><i class="fa fa-certificate"></i> 인입 현황</h5>
                                  <small class="pull-right">기준 : 일</small>
                              </div>
                              <div class="ibox-content">
                                  <div class="row">
                                      <div class="col-lg-12">
                                          <div class="row">
                                              <div class="col-lg-12">
                                                  <canvas id="callStatus" height="155"></canvas>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                                  <br>
                                  <div class="row">
                                      <div class="col-lg-12">
                                          <div class=" pull-left">
                                              <h5>접수유형</h5>
                                              <span> 일반 : <strong>90</strong></span>&nbsp;
                                              <span> 칭찬 : <strong>20</strong></span>&nbsp;
                                              <span> 품질 : <strong>5</strong></span>&nbsp;
                                              <span> A/S : <strong>6</strong></span>&nbsp;
                                              <span> 콜센터 : <strong>1</strong></span>&nbsp;
                                              <span> 매장 : <strong>2</strong></span>&nbsp;
                                              <span> 불만 : <strong>1</strong></span>&nbsp;
                                              <span> 관리 : <strong>5</strong></span>&nbsp;
                                          </div>
                                      </div>
                                  </div>

                              </div>
                          </div>
                      </div>

                  </div>
                </div>
                <div class="col-lg-7">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>상담제품</h5>
                                    <small class="pull-right">기준 : 일</small>
                                </div>
                                <div class="ibox-content">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <canvas id="inproduct" height="40"></canvas>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class=" pull-right">
                                                <span>기간 : 2019.05.02</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>상담처리현황</h5>
                                    <small class="pull-right">기준 : 일</small>
                                </div>
                                <div class="ibox-content">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <canvas id="processStatus" height="40"></canvas>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class=" pull-right">
                                                <span>기간 : 2019.05.02</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>





            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5><i class="fa fa-certificate"></i> 시간대별 콜 인입현황</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-lg-12">
                                    <canvas id="inOutCountChart" height="50"></canvas>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class=" pull-left">
                                        <h5>접수유형</h5>
                                        <span> 09-10 시 : <strong>90</strong></span>&nbsp;
                                        <span> 11-12 시 : <strong>20</strong></span>&nbsp;
                                        <span> 12-13 시 : <strong>5</strong></span>&nbsp;
                                        <span> 13-14 시 : <strong>6</strong></span>&nbsp;
                                        <span> 15-16 시 : <strong>1</strong></span>&nbsp;
                                        <span> 17-18 시 : <strong>2</strong></span>&nbsp;
                                    </div>
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

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<%@ include file="/WEB-INF/views/includ/menuactive.jsp"%>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc_dashboard.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script>

</script>
<script>

</script>

</body>
</html>
