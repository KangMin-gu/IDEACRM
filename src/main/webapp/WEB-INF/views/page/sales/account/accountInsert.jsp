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
                <h2>거래처 신규</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/cust">거래처 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>거래처 신규</strong>
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
                            <li><a class="nav-link active" data-toggle="tab" href="#tab-1">거래처 정보</a></li>
                        </ul>
                        <form:form>
                            <div class="tab-content">
                                <div role="tabpanel" id="tab-1" class="tab-pane active">
                                    <div class="panel-body">

                                        <div class="form-group  row">
                                            <label class="col-sm-1 col-form-label">거래처명</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control form-control-sm">
                                            </div>
                                            <label class="col-sm-1 col-form-label">거래처 호칭</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control form-control-sm">
                                            </div>
                                            <label class="col-sm-1 col-form-label">대표자명</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control form-control-sm">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-1 col-form-label">법인번호</label>
                                            <div class="col-sm-5">
                                                <div class="row">
                                                    <div class="col-md-6"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                    <div class="col-md-6"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                </div>
                                            </div>
                                            <label class="col-sm-1 col-form-label">사업자 번호</label>
                                            <div class="col-sm-5">
                                                <div class="row">
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-1 col-form-label">업태</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-1 col-form-label">업종</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-1 col-form-label">종목</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-1 col-form-label">중요도</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-1 col-form-label">국내/국외</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-1 col-form-label">규모</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-1 col-form-label">대표 전화</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b">
                                                            <option value="Bahamas">010</option>
                                                            <option value="Bahrain">011</option>
                                                            <option value="Bangladesh">017</option>
                                                            <option value="Barbados">018</option>
                                                            <option value="Belarus">019</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                </div>
                                            </div>
                                            <label class="col-sm-1 col-form-label">FAX</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b">
                                                            <option value="Bahamas">010</option>
                                                            <option value="Bahrain">011</option>
                                                            <option value="Bangladesh">017</option>
                                                            <option value="Barbados">018</option>
                                                            <option value="Belarus">019</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-1 col-form-label">휴대전화</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b">
                                                            <option value="Bahamas">010</option>
                                                            <option value="Bahrain">011</option>
                                                            <option value="Bangladesh">017</option>
                                                            <option value="Barbados">018</option>
                                                            <option value="Belarus">019</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                </div>
                                            </div>
                                            <label class="col-sm-1 col-form-label">EMAIL</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm">
                                            </div>
                                        </div>

                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-1 col-form-label">주소</label>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-md-2"><input type="text" placeholder=".col-md-2" class="form-control form-control-sm"></div>
                                                    <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                    <div class="col-md-4"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                    <div class="col-md-3"><button class="btn btn-white btn-sm" type="submit">주소 검색</button></div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-1 col-form-label">메모</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="" id="" cols="30" rows="5"></textarea>
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
        $('.footable').footable();
        $('#daterange').daterangepicker();
        $('#daterange2').daterangepicker();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>
</html>
