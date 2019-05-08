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
</head>
<style>
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="ibox">
		<div class="ibox-title">
			<h5>고객 조회</h5>
		</div>
		<div class="ibox-content">
			<div class="row">
				<div class="col-lg-12">
					<div class="w-100 text-right mb-3">
						<button class="btn btn-default" type="button" onclick="blackSubmit('/voc/black')">등록</button>
					</div>
					<div class="box1 col-lg-12 col-xl-4 p-0">
						<table class="table table-bordered mb-0">
							<form method="post" class="blackForm" >
								<colgroup>
									<col style="width: 110px; background: #fafafa;">
									<col style="width: auto;">
								</colgroup>
								<tbody>
								<tr>
									<th>고객명</th>
									<td>
										<input type="text" class="form-control"id="custname" name="custname" readonly>
										<input class="blackCustInput" type="hidden" id="custno" name="custno" value="0">
									</td>
								</tr>
								<tr>
									<th>수신번호</th>
									<td>
										<input class="blackCustInput" type="text" class="form-control" id="receiveno" name="receiveno" readonly>
									</td>
								</tr>
								<tr>
									<th>타입</th>
									<td>
										<select class="form-control blackCustInput" name="blacktype" id="blacktype">
											<option value="1">욕설</option>
											<option value="2">성희롱</option>
											<option value="3">기타</option>
										</select>
									</td>
								</tr>
								<tr>
									<th>메모</th>
									<td><textarea name="memo" id="memo" class="form-control blackCustInput" style="resize: none;" rows="4"></textarea></td>
								</tr>
								</tbody>
							</form>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc.js"></script>
<script>
$(document).ready(function() {
	initBlackCustPop();//페이지 초기값 셋팅
});
</script>
</body>
</html>
