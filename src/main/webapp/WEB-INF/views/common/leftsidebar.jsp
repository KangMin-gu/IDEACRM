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
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/myinfo/${sessionScope.USERNO}">내 정보</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/notice">공지사항</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/note/inbox">내부통지</a></li>
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
                <a href="#"><i class="fa fa-phone"></i> <span class="nav-label">VOC</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/voc/dashboard">VOC</a></li>
                    <li><a href="${pageContext.request.contextPath}/voc/satisfied">고객만족도 관리</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-line-chart"></i> <span class="nav-label">리포트</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="form_basic.html">고객 </a></li>
                    <li><a href="form_basic.html">영업</a></li>
                    <li><a href="form_basic.html">서비스</a></li>
                    <li><a href="form_basic.html">CTR</a></li>
                    <li><a href="form_basic.html">VOC</a></li>
                </ul>
            </li>



            <li>
                <a href="#"><i class="fa fa-cog"></i> <span class="nav-label">관리자</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/ad/user">회원 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/ad/code">코드 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/ad/content">서식 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/ad/company/${sessionScope.SITEID}">회원사 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/notice">공지사항 관리</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-cogs"></i> <span class="nav-label">CRUD 관리자</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="${pageContext.request.contextPath}/ma/company">회원사 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/ma/code">공통코드</a></li>
                    <li><a href="${pageContext.request.contextPath}/ma/license">라이센스 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/ma/menu">메뉴 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/ma/allnotice">전체 공지사항 관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/ma/sitechk">접속 유저 확인</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
