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
    <!-- FooTable -->
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
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

        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <%@ include file="/WEB-INF/views/common/insideNotice.jsp"%>
                <div class="col-lg-9 animated fadeInRight">
                        <div class="mail-box-header">
                            <div class="float-right tooltip-demo">
                                <a href="${pageContext.request.contextPath}/compose?reply=${noteInfo.NOTICEID}" class="btn btn-white btn-sm"><i class="fa fa-reply"></i> 답장</a>
                                <c:choose>
                                    <c:when test="${location eq 'inbox'}">
                                        <a class="btn btn-sm btn-white" href="${pageContext.request.contextPath}/trashin?noticeid=${noteInfo.NOTICEID}"><i class="fa fa-trash-o"></i> 휴지통</a>
                                    </c:when>
                                    <c:when test="${location eq 'trash'}">
                                        <a class="btn btn-sm btn-white" href="${pageContext.request.contextPath}/del?noticeid=${noteInfo.NOTICEID}"><i class="fa fa-trash-o"></i> 삭제</a>
                                    </c:when>
                                    <c:otherwise>

                                    </c:otherwise>
                                </c:choose>
                            </div>

                            <div class="mail-tools tooltip-demo m-t-md">

                                <h3>
                                    <span class="font-normal">제목: </span>${noteInfo.TITLE}
                                </h3>
                                <h5>
                                    <span class="float-right font-normal">${noteInfo.REGDATE}</span>
                                    <span class="font-normal">보낸이: </span>${noteInfo.FROMUSERNAME}
                                </h5>

                                <h5>
                                    <span class="font-normal">받는이: </span>
                                    <c:forEach var="to" items="${toList }" varStatus="comma">
                                        <a style="color: #676a6c" href="${pageContext.request.contextPath}/compose?reno=${to.USERNO}">${to.USERNAME }</a>
                                        <c:if test="${!comma.last }">,</c:if>
                                    </c:forEach>
                                </h5>

                                <c:if test="${not empty noteInfo.LNKURL }">
                                    <h5>
                                        <span class="font-normal">공유 URL: </span> <a href="${noteInfo.LNKURL}">정보 확인</a>
                                    </h5>
                                </c:if>
                            </div>
                        </div>
                        <div class="mail-box">
                            <div class="mail-body">
                               ${noteInfo.CONTENT}
                            </div>

                            <c:if test="${fn:length(fileInfo) > 0}">
                                <div class="mail-attachment">
                                    <p>
                                        <span><i class="fa fa-paperclip"></i> 첨부파일 - </span>
                                        <c:forEach var="file" items="${fileInfo}">
                                            <a href="${pageContext.request.contextPath}/download/${file.FILEID}">${file.ORGFILENAME}</a>
                                            |
                                        </c:forEach>
                                    </p>

                                    <div class="attachment">
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </c:if>
                            <div class="mail-body text-right tooltip-demo">
                                <a href="${pageContext.request.contextPath}/inbox" class="btn btn-white btn-sm float-left"><i class="fa fa-times"></i> 목록</a>
                                <a class="btn btn-sm btn-white" href="${pageContext.request.contextPath}/compose?reply=${noteInfo.NOTICEID}"><i class="fa fa-reply"></i> 답장</a>
                                <c:choose>
                                    <c:when test="${location eq 'inbox'}">
                                        <a class="btn btn-sm btn-white" href="${pageContext.request.contextPath}/trashin?noticeid=${noteInfo.NOTICEID}"><i class="fa fa-trash-o"></i> 휴지통</a>
                                    </c:when>
                                    <c:when test="${location eq 'trash'}">
                                        <a class="btn btn-sm btn-white" href="${pageContext.request.contextPath}/del?noticeid=${noteInfo.NOTICEID}"><i class="fa fa-trash-o"></i> 삭제</a>
                                    </c:when>
                                    <c:otherwise>

                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="clearfix"></div>


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
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function() {
        $('#daterange').daterangepicker();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });

</script>
</body>
</html>
