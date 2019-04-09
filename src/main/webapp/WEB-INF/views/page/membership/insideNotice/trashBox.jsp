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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
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
                        <div class="row">
                            <div class="col-xl-8">
                                <h2>
                                    휴지통 (16)
                                </h2>
                            </div>
                            <div class="col-xl-4">
                                <div style="display: inline-block">
                                    <select class="form-control" >
                                        <option value="Bahamas">전체</option>
                                        <option value="Belarus">제목+내용</option>
                                        <option value="Bahrain">날짜</option>
                                        <option value="Bangladesh">보낸이</option>
                                        <option value="Barbados">내용</option>
                                        <option value="Belarus">제목</option>
                                    </select>
                                </div>
                                <div style="display: inline-block">
                                    <div class="input-group">
                                        <input type="text" class="form-control form-control-sm" name="search" style="width: 150px;">
                                        <div class="input-group-btn">
                                            <button type="submit" class="btn btn-sm btn-primary">
                                                Search
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="mail-tools tooltip-demo m-t-md">
                            <div class="btn-group float-right">
                                <button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i></button>
                                <button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i></button>
                            </div>

                            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" title="Refresh inbox"><i class="fa fa-refresh"></i> 새로고침</button>
                            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Mark as read"><i class="fa fa-eye"></i> </button>
                            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Mark as important"><i class="fa fa-exclamation"></i> </button>
                            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Move to trash"><i class="fa fa-trash-o"></i> </button>

                        </div>
                    </div>
                    <div class="mail-box">

                        <table class="table table-hover table-mail">
                            <tbody>
                            <tr class="unread">
                                <td class="check-mail">
                                    <input type="checkbox" class="i-checks">
                                </td>
                                <td class="mail-ontact">
                                    <a href="mail_detail.html">강민구</a>
                                </td>
                                <td class="mail-subject">
                                    <a href="mail_detail.html">안녕하세요</a>
                                </td>
                                <td class="">
                                    <i class="fa fa-paperclip"></i>
                                </td>
                                <td class="text-right mail-date">6.10 AM</td>
                            </tr>
                            <tr class="unread">
                                <td class="check-mail">
                                    <input type="checkbox" class="i-checks" checked>
                                </td>
                                <td class="mail-ontact">
                                    <a href="mail_detail.html">Jack Nowak</a>
                                </td>
                                <td class="mail-subject">
                                    <a href="mail_detail.html">Aldus PageMaker including versions of Lorem Ipsum.</a>
                                </td>
                                <td class=""></td>
                                <td class="text-right mail-date">8.22 PM</td>
                            </tr>
                            <tr class="read">
                                <td class="check-mail">
                                    <input type="checkbox" class="i-checks">
                                </td>
                                <td class="mail-ontact">
                                    <a href="mail_detail.html">Facebook</a> <span class="label label-warning float-right">중요</span>
                                </td>
                                <td class="mail-subject">
                                    <a href="mail_detail.html">Many desktop publishing packages and web page editors.</a>
                                </td>
                                <td class=""></td>
                                <td class="text-right mail-date">Jan 16</td>
                            </tr>
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
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
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
