<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
    </div>
    <ul class="nav navbar-top-links navbar-right">

<!--내부통지-->
        <li class="dropdown">
            <a id="ins" class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                    <i class="fa fa-envelope"></i>  <span class="label label-warning isnVal"></span>
            </a>
            <ul id="insNotRead" class="dropdown-menu dropdown-messages">

            </ul>
        </li>

<!--공지알람-->
        <li class="dropdown">
            <a id="noticeAlarm" class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                <i class="fa fa-bell"></i>  <span class="label label-primary noticeCounts"></span>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="/company/notice" class="dropdown-item">
                        <div>
                            <i class="fa fa-building fa-fw"></i> ${SITENAME} 공지사항
                            <span class="float-right text-muted small"><span id="siteNoticeCount" class="label label-warning"></span></span>
                        </div>
                    </a>
                </li>
                <li class="dropdown-divider"></li>
                <li>
                    <a href="/voc/notice" class="dropdown-item">
                        <div>
                            <i class="fa fa-phone fa-fw"></i> 콜센터 공지사항
                            <span class="float-right text-muted small"><span id="vocNoticeCount" class="label label-warning"></span></span>
                        </div>
                    </a>
                </li>
                <li class="dropdown-divider"></li>
                <li>
                    <a href="/notice" class="dropdown-item">
                        <div>
                            <i class="fa fa-certificate fa-fw"></i> 시스템 공지사항
                            <span class="float-right text-muted small"><span id="noticeCount" class="label label-warning"></span></span>
                        </div>
                    </a>
                </li>
            </ul>
        </li>

        <li>
            <a href="${pageContext.request.contextPath}/logout">
                <i class="fa fa-sign-out"></i> 로그아웃
            </a>
        </li>
    </ul>
</nav>
