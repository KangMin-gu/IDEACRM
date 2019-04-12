<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <div class="float-left">
        <img src="${pageContext.request.contextPath}/resources/img/crud/ideacrmlogo.png" alt="" />
    </div>
    <div class="float-right">
        <strong>Copyright</strong> CRUD SYSTEM &copy; 2019
    </div>
    <input type="hidden" id="hiddenSideStates" value="${SIDESTATES }"/>
    <input type="hidden" id="hiddenUserId" value="${USERID }"/>
    <input type="hidden" id="hiddenSiteId" value="${SITEID }"/>
    <input type="hidden" id="hiddenUserNo" value="${USERNO }"/>

