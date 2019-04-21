<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <!-- userInfo menu -->
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <a href="${pageContext.request.contextPath}/">
                        <img alt="image" class="rounded" src="${pageContext.request.contextPath}/${SITELOGO }"/>
                    </a>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="block m-t-xs font-bold">${SITENAME }</span>
                        <span class="text-muted text-xs block">${USERNAME }<b class="caret"></b></span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/company/user/${sessionScope.USERNO}">내 정보</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/company/notice">공지사항</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/inbox">내부통지</a></li>
                        <li class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    <a href="${pageContext.request.contextPath}/">${CALLNAME }</a>
                </div>
            </li>

            <li>
                <a href="${pageContext.request.contextPath}/"><i class="fa fa-th-large"></i> <span class="nav-label">메인</span></a>
            </li>

            <li>
                <a href="#"><i class="fa fa-users"></i> <span class="nav-label">고객관리</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="/cust">고객 관리</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-handshake-o"></i> <span class="nav-label">영업관리</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/sales">영업 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/account">거래처 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/sales/calendar">영업 일정</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">서비스관리</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/service">서비스 접수</a></li>
                    <li><a href="${pageContext.request.contextPath}/service/delivery">서비스 이관</a></li>
                    <li><a href="${pageContext.request.contextPath}/service/calendar">서비스 일정</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-envelope-o"></i> <span class="nav-label">캠페인</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/campaign">캠페인 생성</a></li>
                    <li><a href="${pageContext.request.contextPath}/extraction">대상 추출</a></li>
                    <li>
                        <a href="#">발송 매체<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">EMAIL</a></li>
                            <li><a href="#">SMS/LMS</a></li>
                            <li><a href="#">MMS</a></li>
                            <li><a href="#">KAKAO</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/campaing/calendar">캠페인 일정</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-phone"></i> <span class="nav-label">콜센터</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/voc/dashboard">콜센터</a></li>
                    <li><a href="${pageContext.request.contextPath}/voc/satisfied">고객만족도 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/voc/satisfied">콜센터공지</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-line-chart"></i> <span class="nav-label">리포트</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="form_basic.html">고객</a></li>
                    <li><a href="form_basic.html">영업</a></li>
                    <li><a href="form_basic.html">서비스</a></li>
                    <li><a href="form_basic.html">CTR</a></li>
                    <li><a href="form_basic.html">VOC</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-cogs"></i> <span class="nav-label">내정보</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/inbox">내부통지</a></li>
                    <li><a href="${pageContext.request.contextPath}/company/notice">공지사항</a></li>
                    <li><a href="${pageContext.request.contextPath}/notice">IDEA 공지</a></li>
                    <li><a href="${pageContext.request.contextPath}/common/site/${sessionScope.ENCSITEID}">회사정보</a></li>
                    <li><a href="${pageContext.request.contextPath}/company/user/${sessionScope.ENCUSERNO}">내정보</a></li>
                </ul>
            </li>
            <c:if test="${sessionScope.CHKAUTH eq '20' or sessionScope.CHKAUTH eq '30'}">
            <li>
                <a href="#"><i class="fa fa-cog"></i> <span class="nav-label">관리</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/common/site/${sessionScope.ENCSITEID}">회사정보</a></li>
                    <li><a href="${pageContext.request.contextPath}/company/user">사용자관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/company/code">코드관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/company/format">서식관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/company/notice">공지사항</a></li>
                </ul>
            </li>
            </c:if>

            <c:if test="${sessionScope.CHKAUTH eq '30'}">
            <li>
                <a href="#"><i class="fa fa-cogs"></i> <span class="nav-label">CRUD</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/common/site">회원사관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/common/code">공통코드</a></li>
                    <li><a href="${pageContext.request.contextPath}/notice">IDEA 공지</a></li>
                    <li><a href="${pageContext.request.contextPath}/contact">접속자</a></li>
                </ul>
            </li>
            </c:if>
        </ul>
    </div>
</nav>
