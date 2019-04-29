<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<style>
</style>
<body>
<c:set var="menuactive" value='insideNotice'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <%@ include file="/WEB-INF/views/common/insideNotice.jsp"%>


                <div class="col-lg-9 animated fadeInRight">
                    <div class="mail-box-header">
                        <div class="row">
                            <div class="col-xl-8">
                                <h2>
                                    받은 편지
                                </h2>
                            </div>
                            <div class="col-xl-4">
                                <form:form action="/inbox" method="post">
                                    <input type="hidden" id="condition" value="${condition }" name="condition" />
                                    <div class="input-group">
                                        <div class="input-group-btn">
                                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                                <span id="conditionBtn">제목+내용</span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a href="javascript:set('titlecontent')">제목+내용</a>
                                                </li>
                                                <li><a href="javascript:set('title')">제목</a>
                                                </li>
                                                <li><a href="javascript:set('sender')">작성자</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <!-- /btn-group -->
                                        <input type="text" id="keyword" name="keyword" value="${keyword }" class="form-control"/>
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit" style="height: 35px;">
                                              <span class="sr-only">검색</span>
                                              <span class="glyphicon glyphicon-search"></span>
                                            </button>
                                        </span>
                                    </div>
                                </form:form>
                            </div>
                        </div>

                        <div class="mail-tools tooltip-demo m-t-md">
                            <div class="btn-group float-right">
                                <ul class="pagination">
                                    <c:choose>
                                        <c:when test="${page.startPageNum ne 1 }">
                                            <li><a
                                                    href="${pageContext.request.contextPath}/${url }?pageNum=${page.startPageNum-1 }&condition=${condition}&keyword=${keyword}">&laquo;</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="disabled"><a href="javascript:">&laquo;</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:forEach var="i" begin="${page.startPageNum }"
                                               end="${page.endPageNum }">
                                        <c:choose>
                                            <c:when test="${i eq page.pageNum }">
                                                <li class="active page-item"><a class="page-link"
                                                                                href="${pageContext.request.contextPath}/inbox?pageNum=${i }&condition=${condition}&keyword=${keyword}">${i }</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a
                                                        href="${pageContext.request.contextPath}/inbox?pageNum=${i }&condition=${condition}&keyword=${keyword}">${i }</a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${page.endPageNum lt page.totalPageCount }">
                                            <li><a
                                                    href="${pageContext.request.contextPath}/inbox?pageNum=${page.endPageNum+1 }&condition=${condition}&keyword=${keyword}">&raquo;</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="disabled"><a href="javascript:">&raquo;</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>

                            <button class="btn btn-white btn-sm" onclick="window.location.href='${pageContext.request.contextPath}/inbox?condition=${condition}&keyword=${keyword}'"><i class="fa fa-refresh"></i> 새로고침</button>
                            <button id="eyeChk" class="btn btn-white btn-sm"><i class="fa fa-eye"></i> </button>
                            <button id="trashChk" class="btn btn-white btn-sm"><i class="fa fa-trash-o"></i> </button>

                        </div>
                    </div>
                    <div class="mail-box">

                        <table class="table table-hover table-mail">
                            <tbody>
                            <c:forEach var="tmp" items="${noteList }">
                                <tr
                                        <c:choose>
                                            <c:when test="${tmp.READCHEK eq 0 }">class="unread"</c:when>
                                            <c:otherwise>class="read"</c:otherwise>
                                        </c:choose>
                                >
                                    <td class="check-mail">
                                        <input id="noticeid" name="noticeid" type="checkbox" class="i-checks chksquare" value="${tmp.NOTICEID }">
                                    </td>
                                    <td class="mail-ontact">
                                        <a href="${pageContext.request.contextPath}/compose?reno=${tmp.FROMUSERNO}">${tmp.FROMUSERNAME }</a>
                                    </td>
                                    <td class="mail-subject">
                                        <a href="${pageContext.request.contextPath}/inbox/view/${tmp.NOTICEID}">${tmp.TITLE }</a>
                                    </td>
                                    <td>
                                        <c:if test="${tmp.FILESEARCHKEY ne NULL }">
                                            <i class="fa fa-paperclip"></i>
                                        </c:if>
                                    </td>
                                    <td class="text-right mail-date">
                                        <jsp:useBean id="toDay" class="java.util.Date" />
                                        <fmt:formatDate value="${toDay}" pattern="yyyy-MM-dd" var="nowDate"/>
                                        <c:choose>
                                            <c:when test="${nowDate >  tmp.SENDDATE}">${tmp.SENDDATE }</c:when>
                                            <c:otherwise>${tmp.SENDDATETIME }</c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>


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
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/insidenotice.js"></script>
<script>
    $(document).ready(function() {
        $('#daterange').daterangepicker();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });

    set("${condition}");

    function set(condition){
        if(condition=="titlecontent" || condition==""){
            condition="titlecontent";
            $("#conditionBtn").text("제목+내용");
        }else if(condition=="title"){
            $("#conditionBtn").text("제목");
        }else if(condition=="content"){
            $("#conditionBtn").text("내용");
        }else if(condition == "sender"){
            $("#conditionBtn").text("작성자");
        }

        $("#condition").val(condition);
    }
</script>
</body>
</html>
