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
<link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/plugins/fullcalendar/fullcalendar.print.css" rel='stylesheet' media='print'>
<!-- link includ -->
<%@ include file="/WEB-INF/views/includ/link.jsp"%>

</head>
<body>
	<div id="wrapper">
		<!-- Top -->
		<div id="page-wrapper" class="gray-bg" style="margin-left: 0px;">
			<div class="wrapper wrapper-content">
				<div class="row animated fadeInDown">
					<div class="col-lg-12">
						<div class="ibox ">
							<div class="ibox-title">
								<h5>AS 기사 일정 관리</h5>
								<select id="asowner" name="asowner">
									<option label="선택" value="0"/>
                                        <c:forEach var="owner" items="${owner }">
                                            <c:choose>
                                                <c:when test="${search.asowner eq owner.USERNO}">
                                                	<option selected label="${owner.USERNAME }" value="${owner.USERNO }"/>
                                                </c:when>
                                                <c:otherwise>
                                                	<option label="${owner.USERNAME }" value="${owner.USERNO }"/>
                                            	</c:otherwise>
                                        	</c:choose>
                                    	</c:forEach>
								</select>
							</div>
							<div class="wrapper wrapper-content">
								<div class="row animated fadeInDown">
									<div class="col-lg-3">
										<div class="ibox ">
											<div class="ibox-title">
												<h5>AS 기사</h5>
											</div>
											<div class="ibox-content">
												<div id='external-events'>
													<input type="hidden" id="hiddenId" name="hiddenId" value="">
													<input type="hidden" id="hiddenColor" name="hiddenColor" value="">
													<c:forEach var="list" items="${asOwner}"  varStatus="status">
														<div class='external-event navy-bg' style="position: relative;" id="status${status.index }">
															${list.title }
															<input type="hidden" id="id${status.index }" name="id${list.id }" value="${list.id }">
														</div>
													</c:forEach>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-9">
										<div class="ibox ">
											<div class="ibox-title">
												<h5>AS기사 일정</h5>
											</div>
											<div class="ibox-content">
												<input type="hidden" id="schList" name="schList" value='${schList }'/>
												<div id="calendar"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- js includ -->
	<%@ include file="/WEB-INF/views/includ/js.jsp"%>
	<!-- Mainly scripts -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/fullcalendar/moment.min.js"></script>
	<!-- jQuery UI  -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- iCheck -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
	<!-- Full Calendar -->
	<script src="${pageContext.request.contextPath}/resources/js/plugins/fullcalendar/fullcalendar.min.js"></script>
	<!-- 캘린더 이벤트 정의 -->
	<script src="${pageContext.request.contextPath}/resources/js/crud/voc.js"></script>

<script>
    $(document).ready(function() {
    	$('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
    });
</script>
</body>

</html>