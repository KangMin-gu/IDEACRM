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
<style>
    th{
        background-color: #f5f6f7;
    }
</style>
<body>
<c:set var="menuactive" value='vocdashM'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <!--<div class="row">
                <div class="col-lg-12">
                    <a href="#" class="btn btn-default"><i class="fa fa-envelope fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-mobile fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-comment fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-file-excel-o fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-file-pdf-o fa-lg"></i></a>
                </div>
            </div>
            -->

            <br/>
            <div class="row">
                <div class="col-lg-6">
                  <div class="row">
                      <div class="col-lg-12">
                          <div class="ibox">
                              <div class="ibox-title">
                                  <h5><i class="fa fa-certificate"></i> 인입 현황</h5>
                                  <div class="ibox-tools">
                                      <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                  </div>
                              </div>
                              <div class="ibox-content">
                                  <div class="row">
                                      <div class="col-lg-12">
                                          <div class="row">
                                              <div class="col-lg-12">
                                                  총 건수 : 12,222
                                              </div>
                                              <div class="col-lg-12">
                                                  <div id="morris-donut-chart" ></div>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="row">
                                      <div class="col-lg-12">
                                          <div class="table-responsive">
                                              <table class="table table-bordered" style="white-space:nowrap;">
                                                  <colgroup>
                                                      <col width="5%">
                                                      <col width="10%">
                                                      <col width="5%">
                                                      <col width="10%">
                                                      <col width="5%">
                                                      <col width="10%">
                                                      <col width="5%">
                                                      <col width="10%">
                                                  </colgroup>
                                                  <tbody>
                                                    <tr>
                                                        <th>일반 문의</th>
                                                        <td>50</td>
                                                        <th>칭찬</th>
                                                        <td>5</td>
                                                        <th>불만</th>
                                                        <td>10</td>
                                                        <th>AS문의</th>
                                                        <td>35</td>
                                                    </tr>
                                                  </tbody>
                                              </table>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="col-lg-12">
                          <div class="ibox">
                              <div class="ibox-content">
                                  <div class="table-responsive">
                                      <table class="" style="white-space:nowrap;">
                                          <colgroup>
                                              <col width="25%">
                                              <col width="25%">
                                              <col width="25%">
                                              <col width="25%">
                                              <col width="25%">
                                          </colgroup>
                                          <tbody>
                                          <tr>
                                              <td>
                                                  <div class="text-center">
                                                      <a href="">
                                                          <img src="${pageContext.request.contextPath}/resources/img/crud/angry.png" alt="" height="100px;">
                                                      </a>
                                                  </div>
                                                  <div class="text-center"><strong>불만</strong></div>
                                              </td>
                                              <td>
                                                  <div class="text-center">
                                                      <a href="">
                                                      <img src="${pageContext.request.contextPath}/resources/img/crud/question.png" height="100px;">
                                                      </a>
                                                  </div>
                                                  <div class="text-center"><strong>문의</strong></div>
                                              </td>
                                              <td>
                                                  <div class="text-center">
                                                      <a href="">
                                                      <img src="${pageContext.request.contextPath}/resources/img/crud/good.png" height="100px;">
                                                      </a>
                                                  </div>
                                                  <div class="text-center"><strong>칭찬</strong></div>
                                              </td>
                                              <td>
                                                  <div class="text-center">
                                                      <a href="">
                                                      <img src="${pageContext.request.contextPath}/resources/img/crud/Document.png" height="100px;">
                                                      </a>
                                                  </div>
                                                  <div class="text-center"><strong>VOC 정독</strong></div>
                                              </td>
                                              <td>
                                                  <div class="text-center">
                                                      <a href="#" onclick="vocWindow()">
                                                      <img src="${pageContext.request.contextPath}/resources/img/crud/callcenter.png" height="100px;">
                                                      </a>
                                                  </div>
                                                  <div class="text-center"><strong>VOC 접속</strong></div>
                                              </td>
                                          </tr>
                                          </tbody>
                                      </table>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
                </div>
                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox">
                                <div class="ibox-title">
                                    <h5><i class="fa fa-certificate"></i> 불만유형 집계</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <div class="table-responsive">
                                        <table style="white-space:nowrap;">
                                            <colgroup>
                                                <col width="10%">
                                                <col width="40%">
                                                <col width="10%">
                                                <col width="40%">
                                            </colgroup>
                                            <tbody>
                                            <tr>
                                                <th>기간</th>
                                                <td>2018/12/10 - 2019/3/20</td>
                                                <th>출처</th>
                                                <td>해피콜, 인바운드, 아웃바운드</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div id="morris-bar-chart" style="height:150px;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="ibox">
                                <div class="ibox-title">
                                    <h5><i class="fa fa-certificate"></i> 고객접점현황 / 필수 VOC</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <div id="morris-bar-chart2" style="height:150px;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="ibox">
                                <div class="ibox-title">
                                    <h5><i class="fa fa-certificate"></i> 필수 VOC 전달사항 정독률</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <div id="morris-bar-chart3" style="height:150px;"></div>
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
<script>
    function vocWindow(){
        window.open("/voc", "", "fullscreen");
    }
</script>
<script>
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{ label: "AS문의", value: 35 },
            { label: "불만", value: 10 },
            { label: "칭찬", value: 5 },
            { label: "일반문의", value: 50 }],

        resize: true,
        colors: ['#87d6c6', '#54cdb4','#1ab394','#1ab394'],
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{ y: '2006', a: 60, b: 50 },
            { y: '2007', a: 75, b: 65 },
            { y: '2008', a: 50, b: 40 },
            { y: '2009', a: 75, b: 65 },
            { y: '2010', a: 50, b: 40 },
            { y: '2011', a: 75, b: 65 },
            { y: '2012', a: 100, b: 90 } ],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true,
        barColors: ['#1ab394', '#cacaca'],
    });

    Morris.Bar({
        element: 'morris-bar-chart2',
        data: [{ y: '2006', a: 60, b: 50 },
            { y: '2007', a: 75, b: 65 },
            { y: '2008', a: 50, b: 40 },
            { y: '2009', a: 75, b: 65 },
            { y: '2010', a: 50, b: 40 },
            { y: '2011', a: 75, b: 65 },
            { y: '2012', a: 100, b: 90 } ],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true,
        barColors: ['#1ab394', '#cacaca'],
    });

    Morris.Bar({
        element: 'morris-bar-chart3',
        data: [{ y: '2006', a: 60, b: 50 },
            { y: '2007', a: 75, b: 65 },
            { y: '2008', a: 50, b: 40 },
            { y: '2009', a: 75, b: 65 },
            { y: '2010', a: 50, b: 40 },
            { y: '2011', a: 75, b: 65 },
            { y: '2012', a: 100, b: 90 } ],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true,
        barColors: ['#1ab394', '#cacaca'],
    });

</script>

</body>
</html>
