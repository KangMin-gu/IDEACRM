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
<title>CRUD SYSTEM</title>
    <%@ include file="/WEB-INF/views/includ/link.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/plugins/clockpicker/clockpicker.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet"> <!--radioBox-->
</head>
	<body>
        <div class="wrapper wrapper-content">
        	<div>
                <div class="ibox-left col-6">
                	<h2>콜백 리스트</h2>
                        <div class="ibox-content row">
                            <div class="box2 col-lg-12 col-xl-8 p-0">
                                <table class="table table-bordered mb-0">
                                    <colgroup>
                                        <col style="width: 110px; background: #fafafa;">
                                        <col style="width: auto;">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>콜백번호</th>
                                            <td class="border-top-0">
                                                <div class="input-group">
                                                    <input type="text" class="form-control reset"  autocomplete="off" name="callback" id="callback" value="${search.callback }">
                                                    <button id="leftSearch" class="btn btn-primary" style="padding-top: 0px;   padding-bottom: 0px;">검색</button>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="ibox-content row border-top-0 pt-lg-0 tooltip-demo">
                            <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                            	<colgroup>
                            		<col style="width: 3%;">
                            		<col style="width: 15%;">
                            		<col style="width: 7%;">
                            		<col style="width: 7%;">                            		                            		                            		                            		                            		                            		                            		
                            	</colgroup>                            
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" class="i-checks chksquare" name="icheckAll" id="icheckAll"></th>
                                        <th>접수일자</th>
                                        <th>발신번호</th>
                                        <th>콜백번호</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>

                                    </tr>                            
                                </tbody>
                            </table>
                            </div>
                            <div class="m-auto">
                                <ul class="pagination">
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                
                <div class="ibox-right col-6">
                	<h2>사용자 리스트</h2>
                        <div class="ibox-content row">
                            <div class="box2 col-lg-6 col-xl-4 p-0">
                                <table class="table table-bordered mb-0">
                                    <colgroup>
                                        <col style="width: 110px; background: #fafafa;">
                                        <col style="width: auto;">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>사용자</th>
                                            <td class="border-top-0">
                                                <div class="input-group owner" id="owner_">
                                                    <input type="text" class="form-control reset" readonly autocomplete="off" name="owner_" value="${search.owner_ }">
                                                    <input type="hidden" class="reset" name="owner" id="owner" value="${search.owner }">
                                                    <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="ibox-content row border-top-0 pt-lg-0 tooltip-demo">
                            <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                            	<colgroup>
                            		<col style="width: 3%;">
                            		<col style="width: 7%;">
                            		<col style="width: 7%;">                            		                            		                            		                            		                            		                            		                            		
                            		<col style="width: 7%;">
                            	</colgroup>                            
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" class="i-checks chksquare" name="icheckAll" id="icheckAll"></th>
                                        <th>사용자명</th>
                                        <th>사용자ID</th>
                                        <th>할당된 콜백수</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        
                                    </tr> 
                                </tbody>
                            </table>
                            </div>
                            <div class="m-auto">
                                <ul class="pagination">
                                   
                                </ul>
                            </div>
                        </div>
                        <div class="box col-12" style="padding-left: 0px;padding-right: 0px;">
                        	<div class="col-lg-4 float-right text-right mb-2 w-100" style="padding-right: 0px;">    		
	                           	<button id="passDiv" class="btn btn-primary btn-large">수동분배</button>
                        		<button id="autoDiv" class="btn btn-primary btn-large">자동분배</button>
                        	</div>
                    	</div>
                    </div>
				</div>
			</div>
        <%@ include file="/WEB-INF/views/includ/js.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script> <!-- radioBox-->
        <script src="${pageContext.request.contextPath}/resources/js/crud/voc.js"></script>

<script>
$(document).ready(function () {
	callBackList(1);
	ctiUserList(1);
});
</script>

	
</body>

</html>
