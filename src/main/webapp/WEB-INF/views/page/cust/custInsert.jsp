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
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>고객 신규 등록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/cust">고객 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>고객 등록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">등록</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
                </div>
            </div>

            <br/>

            <div class="row ">
                <div class="col-lg-12">
                    <div class="tabs-container">
                        <ul class="nav nav-tabs" role="tablist">
                            <li><a class="nav-link active" data-toggle="tab" href="#tab-1">고객 정보</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-2">직장 정보</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-3">부가 정보</a></li>
                        </ul>
                        <form:form id="custInfo" action="/custinsert" method="post">
                            <div class="tab-content">
                                <div role="tabpanel" id="tab-1" class="tab-pane active">
                                    <div class="panel-body">

                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">고객명</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm" id="custname" name="custname">
                                            </div>
                                            <label class="col-sm-2 col-form-label">성별</label>
                                            <div class="radio-inline i-checks">
                                                <c:forEach var="sex" items="${SEX}">
                                                    <label><input type="radio" value="${sex.codeval}" name="sex"> <i></i>&nbsp;${sex.codename}</label>&nbsp;&nbsp;
                                                </c:forEach>
                                                <!--<label><input type="radio" value="option1" name="sex"> <i></i>&nbsp;남자</label>&nbsp;&nbsp;
                                                <label class="radio-inline"><input type="radio" value="option2" name="sex"> <i></i>&nbsp;여자</label>
                                                -->
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">생년월일</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="birth" name="birth">
                                            </div>
                                            <label class="col-sm-2 col-form-label">이메일</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="email" name="email">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">휴대전화</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="mobile1" name="mobile1">
                                                            <option value="">선택</option>
                                                        <c:forEach var="mobile" items="${MOBILE}">
                                                            <option value="${mobile.codeval}">${mobile.codename}</option>
                                                        </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" id="mobile2" name="mobile2"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" id="mobile3" name="mobile3"></div>
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">자택전화</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="homtel1" name="homtel1">
                                                            <option value="">선택</option>
                                                            <c:forEach var="phone" items="${PHONE}">
                                                                <option value="${phone.codeval}">${phone.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" id="homtel2" name="homtel2"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" id="homtel3" name="homtel3"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">결혼여부</label>
                                            <div class="col-sm-4">
                                                <div class="radio-inline i-checks">
                                                    <select class="form-control m-b" id="married" name="married">
                                                        <option value="0">선택</option>
                                                        <c:forEach var="married" items="${MARRIED}">
                                                            <option value="${married.codeval}">${married.codename}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <!--<label><input type="radio" value="option1" name="a"> <i></i>&nbsp;미혼</label>&nbsp;&nbsp;
                                                    <label class="radio-inline"><input type="radio" value="option2" name="a"> <i></i>&nbsp;기혼</label>-->
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">결혼기념일</label>
                                            <div class="col-sm-4">
                                                <input type="text" placeholder=".col-md-2" class="form-control form-control-sm" id="weddingday" name="weddingday" >
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">직업</label>
                                            <div class="col-sm-4">
                                                <input type="text" placeholder=".col-md-4" class="form-control form-control-sm" id="job" name="job">
                                            </div>
                                            <label class="col-sm-2 col-form-label">취미</label>
                                            <div class="col-sm-4">
                                                <input type="text" placeholder=".col-md-4" class="form-control form-control-sm" id="hobby" name="hobby">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">주소</label>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-md-2"><input type="text" placeholder=".col-md-2" class="form-control form-control-sm" id="homaddr1" name="homaddr1"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" id="homaddr2" name="homaddr2"></div>
                                                    <div class="col-md-4"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" id="homaddr3" name="homaddr3"></div>
                                                    <div class="col-md-3"><button class="btn btn-white btn-sm" type="submit">주소 검색</button></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div role="tabpanel" id="tab-2" class="tab-pane">
                                    <div class="panel-body">

                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">직장명</label>
                                            <div class="col-sm-4">
                                                <input type="hidden" id="clino" name="clino" value="0"/>
                                                <input type="text" class="form-control form-control-sm" id="cliname" name="cliname">
                                            </div>
                                            <label class="col-sm-2 col-form-label">홈페이지</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="wrkurl" name="wrkurl">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">소속 부서</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="deptname" name="deptname">
                                            </div>
                                            <label class="col-sm-2 col-form-label">직책</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="duty" name="duty">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">직장 전화</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="wrktel1" name="wrktel1">
                                                            <option value="">선택</option>
                                                            <c:forEach var="phone" items="${PHONE}">
                                                                <option value="${phone.codeval}">${phone.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" id="wrktel2" name="wrktel2"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" id="wrktel3" name="wrktel3"></div>
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">직장 FAX</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="wrkfax1" name="wrkfax1">
                                                            <option value="">선택</option>
                                                            <c:forEach var="fax" items="${FAX}">
                                                                <option value="${fax.codeval}">${fax.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" id="wrkfax2" name="wrkfax2"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" id="wrkfax3" name="wrkfax3"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">직장 주소</label>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-md-2"><input type="text" placeholder=".col-md-2" class="form-control form-control-sm" id="wrkaddr1" name="wrkaddr1"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" id="wrkaddr2" name="wrkaddr2"></div>
                                                    <div class="col-md-4"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" id="wrkaddr3" name="wrkaddr3"></div>
                                                    <div class="col-md-3"><button class="btn btn-white btn-sm" type="submit">주소 검색</button></div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div role="tabpanel" id="tab-3" class="tab-pane">
                                    <div class="panel-body" style="margin-bottom: 20px;">
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">회원구분</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="custgubun" name="custgubun">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="custgubun" items="${CUSTGUBUN}">
                                                        <option value="${custgubun.codeval}">${custgubun.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">고객등급</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="custgrade" name="custgrade">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="custgrade" items="${CUSTGRADE}">
                                                        <option value="${custgrade.codeval}">${custgrade.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">활동등급</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="actgrade" name="actgrade">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="actgrade" items="${ACTGRADE}">
                                                        <option value="${actgrade.codeval}">${actgrade.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">발송처</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="mailto" name="mailto">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="mailto" items="${MAILTO}">
                                                        <option value="${mailto.codeval}">${mailto.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">담당자</label>
                                            <div class="col-sm-2">
                                                <input type="hidden" id="owner" name="owner" value="${sessionScope.USERNO}">
                                                <input type="text" class="form-control form-control-sm" id="owner_" name="owner_">
                                            </div>
                                            <label class="col-sm-2 col-form-label">정보활용</label>
                                            <div class="col-sm-2">
                                                <div class="radio-inline i-checks">
                                                    <c:forEach var="infoagree" items="${INFOAGREE}">
                                                        <label><input type="radio" value="${infoagree.codeval}" name="infoagree"> <i></i>&nbsp;${infoagree.codename}</label>&nbsp;&nbsp;
                                                    </c:forEach>
                                                    <!--<label><input type="radio" value="option1" name="a"> <i></i>&nbsp;동의</label>&nbsp;&nbsp;
                                                    <label class="radio-inline"><input type="radio" value="option2" name="a"> <i></i>&nbsp;거부</label>-->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group  row">
                                            <div class="col-sm-2">수신거부</div>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">EMAIL</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denymailnomal" name="denymailnomal">&nbsp; 일반</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denymailsurvey" name="denymailsurvey">&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denymailseminar" name="denymailseminar">&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denymailad" name="denymailad">&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">SMS</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denysmsnomal" name="denysmsnomal">&nbsp; 일반</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denysmssurvey" name="denysmssurvey" >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denysmsseminar" name="denysmsseminar">&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denysmsad" name="denysmsad">&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <!--<div class="row">
                                                    <label class="col-sm-2 col-form-label">KAKAO</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denydmnomal" name="denydmnomal">&nbsp; 일반</label>&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmsurvey" name="denydmsurvey">&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmseminar" name="denydmseminar">&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmad" name="denydmad">&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>-->
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">DM</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denydmnomal" name="denydmnomal">&nbsp; 일반</label>&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmsurvey" name="denydmsurvey">&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmseminar" name="denydmseminar">&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmad" name="denydmad">&nbsp; 광고</label>
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmnews" name="denydmnews">&nbsp; 뉴스레터</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">전화</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denytelad" name="denytelad">&nbsp; 광고</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denytelsurvey" name="denytelsurvey">&nbsp; 해피콜</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">기타</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denyfax" name="denyfax">&nbsp; FAX</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denyvisit" name="denyvisit">&nbsp; 방문</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">메모</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="memo" id="memo" cols="30" rows="5"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>

            <br/>

            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">등록</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
                </div>
            </div>

            <br/>

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
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function() {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>
</html>
