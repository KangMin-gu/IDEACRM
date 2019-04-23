<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>IDEA CRM</title>
<!-- link includ -->
<%@ include file="/WEB-INF/views/includ/link.jsp"%>
<!-- S: 추가 CSS-->
<!-- Toastr style -->
<link href="/resources/css/plugins/toastr/toastr.min.css"
	rel="stylesheet">
<!--radioBox-->
<link href="/resources/css/plugins/iCheck/custom.css" rel="stylesheet">

<style>
body {
	background-color: #f3f3f4;
}
</style>



</head>
<body>
	<div class="wrapper">
		<div class="row wrapper border-bottom white-bg page-heading">
			<div class="col-lg-10">
				<h2>일정상세</h2>
			</div>
		</div>

		<!-- S: 고객 목록 ppt p01-->
		<div class="wrapper wrapper-content  animated fadeInRight article">
			<div class="row justify-content-md-center">
				<div class="col-lg-12">
					<div class="ibox">
						<div class="ibox-content row border-top-0 pt-lg-0">
							<div class="overflow-x w-100 head">
								<table class="table table-bordered table-hover">
									<colgroup>
										<col style="width: 100px;">
                            			<col style="width: 100px;">
                            			<col style="width: 200px;">
                            			<col style="width: 100px;">
                            		</colgroup>  
                            		<thead>
                                		<tr>
                                    		<th>고객명</th>
                                    		<th>연락처</th>
                                    		<th>주소</th>
                                    		<th>처리상태</th>
                                		</tr>
                            		</thead>
                            		<tbody>
                            		<c:forEach var="calOwner" items="${calOwner }">
                                		<tr>
                                    		<td>${calOwner.CUSTNAME}</td>
                                    		<td>${calOwner.MOBILE_ }</td>
                                    		<td>${calOwner.ADDR_ }</td>
                                    		<td>${calOwner.SERVICESTEP_ }</td>
                                		</tr>
                            		</c:forEach>
                            		</tbody>
                        		</table>
                    		</div>
                		</div>
            		</div>
        		</div>
    		</div>
		</div>
	</div>
	<!-- js includ -->
	<%@ include file="/WEB-INF/views/includ/js.jsp"%>
	<script src="${pageContext.request.contextPath}/resources/crud/voc.js"></script>

</body>
</html>