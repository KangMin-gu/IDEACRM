<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-lg-3">
    <div class="ibox ">
        <div class="ibox-content mailbox-content">
            <div class="file-manager">
                <a class="btn btn-block btn-primary compose-mail" href="${pageContext.request.contextPath}/compose">편지쓰기</a>
                <div class="space-25"></div>
                <h5>내부통지</h5>
                <ul class="folder-list m-b-md" style="padding: 0">
                    <li>
                        <a href="${pageContext.request.contextPath}/inbox"> <i class="fa fa-inbox "></i>
                            받은 편지 <span class="label label-warning float-right isnVal"></span> </a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/outbox"> <i class="fa fa-envelope-o"></i> 보낸 편지 </a></li>
                    <li><a href="${pageContext.request.contextPath}/trashbox"> <i class="fa fa-trash-o"></i> 휴지통</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>