
// 타이머
function startInterval() {
    second = 1;
    min = 00;
    vocTimer = setInterval(function() {
        // 0초면 초기화 후 이동되는 사이트
        if (second == 60) {
            second = 00;
            min = parseInt(min) + 1;
        }
        if (second < 10) {
            second = "0" + second;
        }
        var time = min + " : " + second;
        $('#timer').text(time);
        second = parseInt(second) + 1;// 카운트 증가
    }, 1000);
}

function stopInterval() {
    if (vocTimer != '') {
        clearInterval(vocTimer);
    }
}


//voc 고객 검색 팝업 이벤트
//필터링 창에 인입번호 바인딩 후 엔터키 입력
$(".searchCust").on("ready.ft.table",function(obj,e,ft,row){
    var enter = jQuery.Event( "keypress", { keyCode: 13 } );//enter key 입력 이벤트
    $('.footable-filtering-search').find('input[type=text]').val(opener.$('#searchNumber').val());//호출 창의 인입번호 입력값 바인딩 후 엔터
    $('.footable-filtering-search').find('input[type=text]').trigger(enter);
});

$('.voc').find('.nav-link').click(function(e){
    // click 탭의 href의 값을 가지고 온다.
    var href = e.target.attributes.href.value;
    // href의 tabpanel에 footable에 사용할 url을 가지고 온다.
    var url = $(href).attr('url');
    if(url != undefined){
        vocFootableSearchList(href,url);
    }
});

function vocFootableSearchList(id,url) {
    var param = searchDataToJson();
    var page = $('#paging').val();
    if(page == undefined){
        page = 5;
    }
    if( window.location.pathname == '/voc' && id != '#callbackBottomTab' ){
        if( !$('#custno').val() ) return;//voc에서는 custno가 없다면 아래행 실행 x
    }
    var pagination = $(id).find('.pagination');
    $.post(url, param, function (response) {
        $(id).find('.vocfootable').footable({
            "toggleSelector": ".footable-toggle",
            "empty": "",
            "filtering": {
                "enabled": true,
                "placeholder": "통합검색",
                "delay": 300,
                "min":1,
            },
            "paging": {
                "enabled": true,
                "container" : pagination,
                "size":page
            },
            "rows": response
        });
        // pagination이 반복해서 생겨서 무조건 한개를 지우게 처리함.
        $('.footable-pagination-wrapper:eq(0)').remove();
        $('.footable-empty').remove();
        $('.input-group-btn').remove();
    });
};


$('#searchNumber').keydown(function(key){
    if(key.keyCode == 13){ //엔터키 입력시 이벤트 실행
        custSearch(key.target);
    }
});

$('#servicecode1').change(function(){
    upperCode('servicecode1');
});

//voc고객팝업창
function custSearch(obj){
    var param = {
        "mobile" : $(obj).val()};
    $.ajax({
        url: "/voc/pop/custsearch",
        method: "POST",
        dataType: "json",
        data : param,
        cache: false,
        success: function (data) {
            var length = data.length;
            if(length == 1){
                custInfoBinding(data[0]);
            }else {
                openNewWindow('고객검색','/voc/pop/custsearch','',1000,680);
            }
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}

// voc 고객 인풋 필드 데이터 바인딩
function custInfoBinding(data) {
        opener.$('#custname').val(data.CUSTNAME);
        opener.$('#custno').val(data.CUSTNO);
        opener.$('#custgubun').val(data.CUSTGUBUN);
        opener.$('#mobile1').val(data.MOBILE1);
        opener.$('#mobile2').val(data.MOBILE2);
        opener.$('#mobile3').val(data.MOBILE3);
        opener.$('#homtel1').val(data.HOMTEL1);
        opener.$('#homtel2').val(data.HOMTEL2);
        opener.$('#homtel3').val(data.HOMTEL3);
        opener.$('[name="relcustname"]').val(data.RELCUSTNAME);
        if (data.RELCUSTNO != null && data.RELCUSTNO != '') {
            opener.$('#relcustno').val(data.RELCUSTNO);
        }
        opener.$('#email').val(data.EMAIL);
        opener.$('#custgrade').val(data.CUSTGRADE);
        opener.$('#homaddr1').val(data.HOMADDR1);
        opener.$('#homaddr2').val(data.HOMADDR2);
        opener.$('#homaddr3').val(data.HOMADDR3);
        opener.$('#blackcnt').val(data.BLACKCNT);

        //체크박스 제어
        if(data.DENYMAILNOMAL == 1){ //mail일반
            opener.$('#denymailnomal').iCheck('check');
        }else
            opener.$('#denymailnomal').iCheck('uncheck');

        if(data.DENYMAILSURVEY == 1){ //mail해피콜
            opener.$('#denymailsurvey').iCheck('check');
        }else
            opener.$('#denymailsurvey').iCheck('uncheck');

        if(data.DENYSMSNOMAL == 1){ //sms일반
            opener.$('#denysmsnomal').iCheck('check');
        }else
            opener.$('#denysmsnomal').iCheck('uncheck');

        if(data.DENYSMSSURVEY == 1){ //sms해피콜
            opener.$('#denysmssurvey').iCheck('check');
        }else
            opener.$('#denysmssurvey').iCheck('uncheck');

        if(data.DENYDMNOMAL == 1){ //dm일반
            opener.$('#denydmnomal').iCheck('check');
        }else
            opener.$('#denydmnomal').iCheck('uncheck');

        if(data.DENYDMSURVEY == 1){ //dm해피콜
            opener.$('#denydmsurvey').iCheck('check');
        }else
            opener.$('#denydmsurvey').iCheck('uncheck');

}

//voc 고객 상세보기 팝업
function vocCustDetail(){
    var custNo = $('#custno').val();
    if(custNo == '' ){
        alert('고객이 선택되지 않았습니다.');
        return;
    }
    openNewWindow('voc','/voc/custdetail/'+custNo,'voc',1200,700);
}


// voc 고객 팝업 tr 클릭
// 상세정보를 가져와서 필드에 바인딩한다.
function popVocCustNameClick(tr){
    var custno = tr.children().get(0).textContent;
    $.ajax({
        url: "/voc/cust/"+custno,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            vocCustFieldReset();// 필드값 초기화
            custFormActivation('update');// 파라미터에 따라 insert/ update 버튼을 생성
            custInfoBinding(data);//데이터 바인딩
            vocGetServiceInfo('/voc/pop/service/'+custno);//최근 1건의 서비스 데이터 바인딩
            //블랙등록 고객이면 인풋창 css변경
            var blackCnt = data.BLACKCNT;
            if(blackCnt > 0){
                blackCustCssChange(true);//인풋창 css변경
                blackSpanActivation('update');//블랙 버튼 변경
            }
            else {
                blackCustCssChange(false);
                blackSpanActivation('insert');
            }
            setTimeout(function(){
                window.close();
            },300);
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}

// 버튼 생성 메서드
// 파라미터에 따라 insert/ update 버튼을 생성
function custFormActivation(statusStr, fromStr) {
    var btnStr = "";
    if (statusStr == 'insert') {
        btnStr = "<button type='button' class='btn btn-default pull-left' style='margin-right: 9px;' onClick='goCustInsert()'>고객추가</button>";
    } else if (statusStr == 'update') {
        btnStr = "<button type='button' class='btn btn-default pull-left' style='margin-right: 9px;' onClick='goCustUpdate()'>고객수정</button>";
    }
    if (fromStr == "voc") {// 호출한 곳이 voc 페이지면
        $('#regSpan').empty();
        $('#regSpan').html(btnStr);
    } else {// 팝업
        opener.$('#custRegSpan').empty();
        opener.$('#custRegSpan').html(btnStr);
    }
}

//voc 고객 추가 버튼 생성 이벤트
function makeCustAddBtn(){
    vocCustFieldReset();//필드초기화
    custFormActivation('insert');//insert 버튼생성
    window.close();
}
//voc 고객 필드 초기화
function vocCustFieldReset(){
    if(window.location.pathname == '/voc'){
        $('#relcustname').val('');
        $('.vocCustInput').val('');
        $('#custgrade').val(0);//int type
        $('#custgubun').val(0);
        $('#relcustno').val(0);
        $('#callbackcustno').val(0);//콜백 매칭용 히든값
        $('.vocCustInput:input:checkbox').val(1);
        $('.vocCustInput:input:checkbox').prop('checked',false);
    }else{ //팝업에서 호출
        opener.$('#relcustname').val('');
        opener.$('.vocCustInput').val('');
        opener.$('#custgrade').val(0);
        opener.$('#custgubun').val(0);
        opener.$('#relcustno').val(0);
        opener.$('#callbackcustno').val(0);
        opener.$('.vocCustInput:input:checkbox').val(1);
        opener.$('.vocCustInput:input:checkbox').prop('checked',false);
    }
}

// voc 고객 수정
function goCustUpdate() {
    var custNo = $("#custno").val();
    if(custNo != ""){
        var urlStr = "/voc/cust/modified/"+custNo;
        var param = getDataToJson('vocCustInput');
        $.ajax({
            url : urlStr,
            method : "POST",
            dataType : "json",
            data : param,
            cache : false,
            success : function(data) {
                alert("수정 되었습니다.");
            },
            error : function(request, status, error) {
                alert("code:" + request.status + "\n" + "message:"
                    + request.responseText + "\n" + "error:" + error);
            }
        });
    }else alert('고객이 선택되지 않았습니다.');
}

function goCustInsert(){
    if(vocCustRequiredFieldCheck() == false){
        alert('휴대전화를 입력해 주세요.');
        return;
    }
    var urlStr = "/voc/cust/input";
    var param = getDataToJson('vocCustInput');
    $.ajax({
        url : urlStr,
        method : "POST",
        dataType : "json",
        data : param,
        cache : false,
        success : function(data) {
            $('#custno').val(data.CUSTNO);
            alert("추가 되었습니다.");
        },
        error : function(request, status, error) {
            alert("code:" + request.status + "\n" + "message:"
                + request.responseText + "\n" + "error:" + error);
        }
    });
}

function vocCustRequiredFieldCheck(){
    var mobile = $('#mobile1').val() + $('#mobile2').val() + $('#mobile3').val();
    var custname = $('#custname').val();
    if(mobile.length < 9 ){
        return false;
    }else {
        if(custname == ''){  $('#custname').val(mobile); }
    }
    return;
}

//고객 인풋 필드 데이터 json형식 리턴.
function getDataToJson(className){
    var param={};
    var data = $('.'+className);
    var length = data.length;

    for(i=0; i<length;i++){
        var idVal = data[i].id;

        if(idVal.substring(0,4) =='deny' ){ // 수신거부 체크박스 항목일 경우
            if($('#'+idVal).prop('checked') == true){
                param[idVal] = data[i].value;//체크 되었으면 값 바인딩
            }else{
                param[idVal] = 0; // 체크 해제 되었다면 0
            }
        }else{
            param[idVal] = data[i].value;
        }
    }
    return param;
}

// 버튼 생성 메서드
// 파라미터에 따라 insert / update 버튼을 생성
function blackSpanActivation(statusStr, fromStr) {
    var btnStr = "";

    if (statusStr == 'insert') {
        btnStr = "<button type='button' class='btn btn-default pull-left' style='margin-right: 9px;' onClick='addBlackPop()'>블랙추가</button>";
    } else if (statusStr == 'update') {
        btnStr = "<button type='button' class='btn btn-default pull-left' style='margin-right: 9px;' onClick='cancleBlack()'>블랙해제</button>";
    }
    if( window.location.pathname == '/voc' ){// 호출한 곳이 voc 페이지면
        $('#blackSpan').empty();
        $('#blackSpan').html(btnStr);
    }
    else {
        opener.$('#blackSpan').empty();
        opener.$('#blackSpan').html(btnStr);
    }
}

//블랙추가 - 블랙리스트 추가 팝업 페이지 호출
function addBlackPop(){
    var custno = $('#custno').val();
    if(custno != "" ){
        openNewWindow('voc','/voc/black','voc',700,480);
    }else{
        alert('대상이 선택되지 않았습니다.');
    }
}

//블랙해제
function cancleBlack(){
    var blackCnt = $('#blackcnt').val();
    if(blackCnt < 1){
        return;
    }else{
        var custno = $('#custno').val();
        var urlStr = '/voc/black/del';
        $.ajax({
            url: urlStr,
            method: "POST",
            dataType: "json",
            data:{"custno":custno},
            cache: false,
            success: function (data) {

                blackCustCssChange(false);
                blackSpanActivation('insert');
                alert("해제 되었습니다.");
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    }
};

//팝업 - 블랙 추가 실행
function blackSubmit(url) {
    var jsonPrm = getDataToJson('blackCustInput');
    $.ajax({
        url: url,
        method: "POST",
        dataType: "json",
        data: jsonPrm,
        cache: false,
        success : function(response) {

            alert('등록 되었습니다.');
            blackCustCssChange(true);
            blackSpanActivation('update');
            window.close();
        }
    });
}

function blackCustCssChange(bool){//블랙 유저면 true   아니면 false
    if(window.location.pathname == '/voc'){
        if(bool == true) {
            $('#custname').css({"background-color":"#f8d7da"});
        }else{
            $('#custname').css({"background-color":"#ffffff"});
        }
    }else{
        if(bool == true) {
            opener.$('#custname').css({"background-color":"#f8d7da"});
        }else{
            opener.$('#custname').css({"background-color":"#ffffff"});
        }


    }
}


function callbackHistFormatter(value, options, rowData){
   if( !rowData.REQNO == false ){
      return '<a onclick="goPlay('+"'"+rowData.RECDATE_+"'"+','+"'"+rowData.RECEXT+"'"+','+"'"+rowData.RECFILENAME+"'"+');"><i class="fa fa-play-circle" style="font-size:17px;"></i></a>';
    }
    return "";
}

function callBtnFormatter(value, options, rowData){
var htmlStr = '<button class="btn btn-primary btn-sm dialingBtn"  onclick="callConfirm('+"'"+rowData.CALLBACK+"'"+');">';
htmlStr += '<i class="fa fa-phone"></i></button>&nbsp;&nbsp;';
htmlStr += '<button class="btn btn-danger btn-sm hangUpBtn" onclick="javascript:func_hangup();" disabled><i class="fa fa-phone"></i></button>';
    return htmlStr;
}

function processBtnFormatter(value, options, rowData){
    var htmlStr = '<button class="btn btn-primary btn-sm" onclick="callBackMatching(' + rowData.CALLBACKNO + ');">매칭</button>';
    htmlStr += '&nbsp;&nbsp;<button class="btn btn-primary btn-sm" onclick="callBackConfirm(' + rowData.CALLBACKNO + ',2);">완료</button>&nbsp;&nbsp;<button class="btn btn-danger btn-sm" onclick="callBackConfirm(' + rowData.CALLBACKNO + ',3);">불통</button>';
    return htmlStr;
}

function callBackHiddenFormatter(value, options, rowData){
    var htmlStr = '<input type="hidden" id="callbackno' + rowData.CALLBACKNO + '" value="' + rowData.CALLBACKNO + '" />';
    htmlStr += '<input type="hidden" id="trunk' + rowData.CALLBACKNO + '" value="' + rowData.TRUNK + '"/>';
    htmlStr += '<input type=hidden" id="callbackcustno' + rowData.CALLBACKNO + '"/>';
    htmlStr += '<input type=hidden" id="callcount' + rowData.CALLBACKNO + '" value="' + rowData.CALLCOUNT +'">'
    return htmlStr;
}

function callConfirm(phoneNo){//콜백 목록 전화걸기전 확인 alert

    $('#blindCall').val(phoneNo);
    $('#phone').val(phoneNo);
    swal({
        title: phoneNo,
        text: "번호를 확인해 주세요",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "통 화",
        closeOnConfirm: false
    }, function () {
        swal.close();
        didCheckMakeCall();
    });
}

function callBackMatching(callbackno){//매칭 버튼 클릭시 현재 바인딩 된 고객과 콜백 회원을 매칭시킨다.
    var custname = $('#custname').val();
    var custno = $('#custno').val();
    var phoneNo = $('#mobile1').val()+$('#mobile2').val()+$('#mobile3').val();

    var textStr = "고객명 : "+custname+ " / 휴대폰 : "+phoneNo;
    swal({
        title: "매칭 회원을 확인해주세요",
        text: textStr,
        showCancelButton: true,
        confirmButtonText: "완 료",
        closeOnConfirm: false
    }, function () {
        $('#callbackcustno'+callbackno).val(custno);
        swal.close();
    });

}

function callBackConfirm(callbackno,callstatus){//콜백 목록 처리
    //swal에서 사용할 메시지 셋팅
    var typeText;
    var titleText;
    var callcount = $('#callcount'+callbackno).val();

    if(callstatus == 2){//완료버튼 클릭시
        titleText = "완료 처리 하시겠습니까?";
        typeText="success";
    }else if(callstatus == 3){//통화불가버튼 클릭시
        if(callcount > 2){//현재 콜 시도횟수가 3회 이상이라면
            titleText = "미해결 처리 하시겠습니까?"
        }else{
            titleText = "통화불가 처리 하시겠습니까?";
        }
        typeText="warning";
    }

    swal({
        title: titleText,
        text: "",
        showCancelButton: true,
        type: typeText,
        confirmButtonText: "완 료",
        closeOnConfirm: false
    }, function () {//컨펌버튼 클릭 실행 함수
        var custno = $('#callbackcustno'+callbackno).val();
       // var memo = $('#vocmemo'+callbackno).val();
        var trunk = $('#trunk'+callbackno).val();
        var reqno = $('#reqno').val();
        if(callstatus == 3 && callcount > 2){//callcount가 3이상일때 불통 버튼 클릭 시 status = 4 미해결
            callstatus = 4;
        }

        var jsonPrm = {"callbackno":callbackno, "custno":custno, "callstatus":callstatus , "trunk":trunk, "reqno":reqno };
        var urlStr = '/voc/callback/modified/'+callbackno;

        $.ajax({
            url: urlStr,
            method: "POST",
            dataType: "json",
            data:jsonPrm,
            cache: false,
            success: function (data) {
                $("#callbackBottomTabBtn").trigger("click");
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
        swal.close();
    });
}



// 최근 서비스 1건 획득 후 바인딩
function vocGetServiceInfo(urlServ) {
    $.ajax({
        url : urlServ,
        method : "GET",
        dataType : "json",
        cache : false,
        async : false,
        success : function(data) {
            serviceInfoBinding(data);// 바인딩
        },
        error : function(request, status, error) {
            alert("code:" + request.status + "\n" + "message:"
                + request.responseText + "\n" + "error:" + error);
        }
    });
}

function serviceInfoBinding(data) {

    opener.$('input:radio[name="servicetype"]').each(
        function(index) {
            if (this.value == data.SERVICETYPE) {
                opener.$('input:radio[name="servicetype"]:eq('+ index + ')').iCheck('check');
            }
        });
    opener.$('#servicecode1').val(data.SERVICECODE1);
    opener.$('#servicecode2').append('<option value='+data.SERVICECODE2+'>'+data.SERVICECODE2_+'</option>');
    opener.$('#servicecode2').val(data.SERVICECODE2);
    opener.$('#servicename').val(data.SERVICENAME);
    opener.$('#servicedesc').text(data.SERVICEDESC);
    opener.tinymce.activeEditor.setMode('readonly');
    opener.tinymce.activeEditor.setContent(data.SERVICEDESC);

    opener.$('#memo').val(data.MEMO);
    if (data.SERVICETYPE == 1) {

        opener.$('input:radio[name="vocstep"]').each(
            function(index) {
                if (this.value == data.SERVICESTEP) {
                    opener.$('input:radio[name="vocstep"]:eq('+ index + ')').iCheck('check');
                }
            });
        if (data.SERVICESTEP == 5) {
            opener.$('#reservphone').val(data.reserv.MOBILENO);
            opener.$('#reservdate').val(formatDate(data.reserv.RESERVDATE));
            opener.$('#reservtimeto').val(data.reserv.RESERVTIMETO);
            opener.$('#reservtimefrom').val(data.reserv.RESERVTIMEFROM);
        } else if (data.SERVICESTEP == 6 || data.SERVICESTEP == 7) {
            opener.$('#nextowner').val(data.convey.NEXTOWNER);
            opener.$('#nextowner_').val(data.convey.NEXTOWNER_);
            opener.$('[name="conveyreason"]').val(data.convey.CONVEYREASON);
            opener.$('[name="conveydesc"]').val(data.convey.CONVEYDESC);
        }
    } else if (data.SERVICETYPE == 2) {
        opener.$('#visitdate').val(data.reward.VISITDATE);
        opener.$('#visitaddr1').val(data.reward.VISITADDR1);
        opener.$('#visitaddr2').val(data.reward.VISITADDR2);
        opener.$('#visitaddr3').val(data.reward.VISITADDR3);
        opener.$('[name="asowner_"]').val(data.reward.OWNER_);
        opener.$('[name="#asowner"]').val(data.reward.OWNER);
    }

    opener.$('.voc').attr('disabled', true);
    opener.$('.i-checks').iCheck('disable');
    opener.$('.plus').hide();

    opener.$('tbody .plus').attr('disabled', true);

    $('.product:gt(0)').remove();

    $.each(data.product, function(index, item) {
        if(index > 0){
            productPlus(index);
        }
        opener.$('#product' + parseInt(parseInt(index + 1) + '1')).empty();
        opener.$('#product' + parseInt(parseInt(index + 1) + '2')).empty();
        opener.$('#product' + parseInt(parseInt(index + 1) + '3')).empty();

        opener.$('#product' + parseInt(parseInt(index + 1) + '1')).append('<option label="' + item.PRODUCTBNAME + '" value="'+ item.PRODUCTB + '"/>');
        opener.$('#product' + parseInt(parseInt(index + 1) + '2')).append('<option label="' + item.PRODUCTMNAME + '" value="'+ item.PRODUCTM + '"/>');
        opener.$('#product' + parseInt(parseInt(index + 1) + '3')).append('<option label="' + item.PRODUCTSNAME + '" value="'+ item.PRODUCTS + '"/>');
        opener.$('#product' + parseInt(parseInt(index + 1) + '3')).next().remove();
    });
}

$('#vocSave').click(
    function(e) {
        debugger;
        var reqno = $('#reqno').val();
        var custno = $('#custno').val();
        //reqno 테스트후 반드시삭제
        reqno = '2019042217453002112807042622864';
        if(!reqno){
            alert("고객과의 전화를 끊어주세요");
        }else if(!custno){
            alert("고객이 선택되지 않았습니다.");
        }else{
            var servicetype = $('.servicetype .checked input').val();
            var servicename = $("#servicename").val();
            var servicedesc = tinymce.activeEditor.getContent();
            var vocstep = $('.check:checked').val();
            var nextowner = $('#nextowner').val();
            var conveyreason = $('[name="conveyreason"]:eq(0)').val();
            var conveydesc = $('[name="conveydesc"]:eq(0)').val();
            var reservphone = $('#reservphone').val();
            var reservdate = $('#reservdate').val();
            var reservtimeto = $('#reservtimeto').val();
            var reservtimefrom = $('#reservtimefrom').val();
            var nextadminowner = $('#nextadminowner').val();
            var servicecode1 = $('#servicecode1').val();
            var servicecode2 = $('#servicecode2').val();
            var memo = $('#memo').val();
            var custno = $('#custno').val();
            var asowner = $('#asowner').val();
            var visitdate = $('#visitdate').val();
            var visittime = $('#visittime').val();
            var visitaddr1 = $('#visitaddr1').val();
            var visitaddr2 = $('#visitaddr2').val();
            var visitaddr3 = $('#visitaddr3').val();
            var visitapm = $('#visitapm').val();
            var visithour = $('#visithour').val();
            var visitminute = $('#visitminute').val();

            var param = {
                "custno" : custno,
                "servicetype" : servicetype,
                "servicename" : servicename,
                "servicedesc" : servicedesc,
                "vocstep" : vocstep,
                "nextowner" : nextowner,
                "conveyreason" : conveyreason,
                "conveydesc" : conveydesc,
                "reservphone" : reservphone,
                "reservdate" : reservdate,
                "reservtimeto" : reservtimeto,
                "reservtimefrom" : reservtimefrom,
                "nextadminowner" : nextadminowner,
                "memo" : memo,
                "servicecode1" : servicecode1,
                "servicecode2" : servicecode2,
                "asowner" : asowner,
                "visitdate" : visitdate,
                "visittime" : visittime,
                "visitaddr1" : visitaddr1,
                "visitaddr2" : visitaddr2,
                "visitaddr3" : visitaddr3,
                "reqno" : reqno,
                "visitapm" : visitapm,
                "visithour" : visithour,
                "visitminute" : visitminute
            };

            // var productNum = $('.plus:last').prev().attr('id').substring(7, 8);
            var productNum = $('.plus:last').parent().prev().find('.form-control').attr('id').substring(7, 8);

            for (var i = 1; i <= productNum; i++) {
                var products = $('[id*="product' + i + '1"]').attr('id');
                var products2 = $('[id*="product' + i + '2"]').attr('id');
                var products3 = $('[id*="product' + i + '3"]').attr('id');

                param[products] = $('[id*="product' + i + '1"]').val();
                param[products2] = $('[id*="product' + i + '2"]').val();
                param[products3] = $('[id*="product' + i + '3"]').val();
            }


            $.ajax({
                url : "/voc/service/input",
                method : "POST",
                dataType : "json",
                data : param,
                cache : false,
                success : function(data) {
                    if (data != 0) {
                        alert("저장되었습니다.");
                        // 데이터 전부 초기화
                        /*
                        $('.form-control').val('').keyup();
                        tinymce.activeEditor.setContent('');
                        $('#create').show();
                        $('#vocSave').hide();
                        $('[id*=product]').attr('disabled',true);
                        $('#servicename').attr('disabled',true);
                        $('#memo').attr('disabled',true);
                        tinymce.activeEditor.setMode('readonly');
                        $('.voc').iCheck('disable');
                        $('#servicetype').iCheck('check');
                        $('#custname').css({"background-color":"#ffffff"});
                        */
                        vocServiceFieldReset();
                    }
                },
                error : function(request, status, error) {
                    alert("code:" + request.status + "\n" + "message:"
                        + request.responseText + "\n" + "error:" + error);
                }
            });
        }
    });



$('.asowner').click(function(e) {
    var custName = $('#custname').val();
    if (custName == "") {
        e.preventDefault();
        alert("고객이 선택되지 않았습니다. 고객을 선택해주세요");
    } else {
        openNewWindow('AS기사', '/voc/as/cal', e.currentTarget.id, 1200, 800);
    }

});


$('.i-checks').on('ifChecked', function(event) {
    var value = event.target.value;
    var name = event.target.name;
    if (name == 'vocstep') {
        if (value == 6) {
            $('.convey').show();
            $('.adminconvey').hide();
            $('.reservation').hide();
        } else if (value == 7) {
            $('.convey').hide();
            $('.adminconvey').show();
            $('.reservation').hide();
        } else if (value == 5) {
            $('.convey').hide();
            $('.adminconvey').hide();
            $('.reservation').show();
        } else {
            $('.convey').hide();
            $('.adminconvey').hide();
            $('.reservation').hide();
        }
    } else if (name == "servicetype") {
        if (value == 1) {
            $('.result').show();
            $('.as').hide();
        } else if (value == 2) {
            $('.convey').hide();
            $('.adminconvey').hide();
            $('.reservation').hide();
            $('.result').hide();
            $('.as').show();
        }
    } else if (name == "addrsame") {
        $('#visitaddr1').val($('#homaddr1').val());
        $('#visitaddr2').val($('#homaddr2').val());
        $('#visitaddr3').val($('#homaddr3').val());
    }
});

$('#addrsame').on('ifUnchecked', function (event) {
    $('#visitaddr1').val('');
    $('#visitaddr2').val('');
    $('#visitaddr3').val('');
});

function productB() {
    var urlServ = "/voc/productB";
    $.ajax({
        url : urlServ,
        method : "GET",
        dataType : "json",
        cache : false,
        success : function(data) {

            for (i = 0; i < data.length; i++) {
                $('.product select:first').append(
                    '<option label="' + data[i].prdname + '" value="'
                    + data[i].prdno + '"/>');
            }
        },
        error : function(request, status, error) {
            alert("code:" + request.status + "\n" + "message:"
                + request.responseText + "\n" + "error:" + error);
        }
    });
}


// vocDetail화면의 Tab클릭 이벤트
$('.vocTabDetail').find('.nav-link').click(function(e){
    var obj = $(this);
    var bool = boolTimeDiff(obj);//동일 버튼 클릭 시간이 3초 미만이면 false 리턴
    if(bool == false){ return; }

    var custno = $('#custno').val();
    if( !custno == false ){
        // click 탭의 href의 값을 가지고 온다.
        var href = e.target.attributes.href.value;
        // href의 tabpanel에 footable에 사용할 url을 가지고 온다.
        var url = $(href).attr('url');
        if(url != undefined){
            tabFootableSearchList(href,url);
        }
    }
});


// 캘린더 시작
if ($('#calendar').length > 0) {
    var schList = $('#schList').val();// hidden value에 담겨있는 스케쥴 리스트를
    // 받아온다.(json String)
    /*
     * initialize the calendar
     * -----------------------------------------------------------------
     */
    var url = window.location.pathname;

    $('#external-events div.external-event').each(function() {

        // store data so the calendar knows to render an event upon drop
        $(this).data('event', {
            title : $.trim($(this).text()), // use the element's text as the
                                            // event title
            stick : true
            // maintain when user navigates (see docs on the renderEvent method)
        });

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex : 1111999,
            revert : true, // will cause the event to go back to its
            revertDuration : 0
            // original position after the drag
        });

    });

    $('#calendar').fullCalendar(
        {

            header : {// 캘린더 프레임 헤더설정
                left : 'prev,next today',// 저번달, 다음달, 오늘로이동
                center : 'title',
                right : 'month,agendaWeek,agendaDay' // 월,주,일별 보기
            },

            editable : true, // false - 일정 수정 안됨.

            droppable : true, // false - 드래그 박스의 일정 캘린더로 이동이 안됨.

            drop : function(event, a, b) { // 드래그 박스의 일정 캘린더로 드랍시 발생
                var name = $(b.helper).text().trim();
                var val1 = $(b.helper).children().val();
                var date = formatDate(event._d);
                var flag = confirm(name + " 기사님에게 배정하시겠습니까?");
                if (flag) {
                    opener.$('[name="asowner_"]').val(name);
                    opener.$('[name="asowner"]').val(val1);
                    opener.$('#visitdate').val(date);
                    alert("배정되었습니다.");
                    self.close();
                } else {
                    alert("취소되었습니다.");
                }

            },

            // 한글화
            monthNames : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월",
                "9월", "10월", "11월", "12월" ],
            monthNamesShort : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월",
                "8월", "9월", "10월", "11월", "12월" ],
            dayNames : [ "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" ],
            dayNamesShort : [ "일", "월", "화", "수", "목", "금", "토" ],
            buttonText : {
                today : "오늘",
                month : "월별",
                week : "주별",
                day : "일별",
            },
            timeFormat : "HH:mm",

            eventRender : function(event, element) {
                if (event.end == null) {
                    event.end = event.start;
                    event.end._i = event.start._i;
                }

                element.popover({
                    placement : 'top',
                    animation : true,
                    delay : 100,
                    content : '<b>서비스명</b>:' + event.title
                        + "<b>서비스 일자</b>:" + event.start._i,
                    trigger : 'hover',
                    html : true
                });
            },

            eventClick : function(event, element, func) {// 캘린더 이벤트 클릭시
                // window.location.href = campUrl+"/"+id;
                openNewWindow("AS기사 접수내용", "/vc/voc/owner/" + event.id
                    + "?visitdate=" + event.start._i, "", 600, 700);
            },
            eventSources : [ {
                events : JSON.parse(schList)
                // json String객체를 json객체로 변환해준다 -> 스케쥴 리스트 달력에 표시됨
            } ]
        });// 캘린더의끝

}

function formatDate(date) {
    var time = new Date(date);
    var year = time.getFullYear();
    var month = time.getMonth() +1;
    if(month < 10){
        month = '0'+month;
    }
    var day = time.getDate();
    return year+'-'+month+'-' + day;
}


$('#create').click(function() {

    $('.i-checks input').iCheck('uncheck');
    $('.i-checks input').iCheck('enable');
    $('.vocSvInput').val('');
    $('.vocSvInput').attr('disabled',false);
    tinymce.activeEditor.setMode('design');
    tinymce.activeEditor.setContent('');
    $('#visitapm').val('0');

    $('[name="vocstep"]:first').iCheck('check');
    $('[name="servicetype"]:first').iCheck('check');
    $('.product').not(':first').remove();
    $('.product:first select').empty();
    $('.product:first select').append('<option label="선택" value=""></option>');
    $('tbody .plus').attr('disabled', false);
    var productLength = $('.plus').length;
    if(productLength == 0){
        $('.product').append('<button class="plus btn btn-default d-inline-block btn-sm mr-2">추가</button>');
    }
    productB();

    $('#vocSave').show();
    $('#create').hide();
});

function vocServiceFieldReset(){
    $('.convey').hide();
    $('.adminconvey').hide();
    $('.reservation').hide();
    $('.as').hide();
    $('#vocSave').hide();

    $('.vocSvInput').val('');
    $('.vocSvInput').attr('disabled', true);
    $('.i-checks input').iCheck('uncheck');
    $('.i-checks input').iCheck('disable');

    tinymce.activeEditor.setMode('design');
    tinymce.activeEditor.setContent('');

    $('#visitapm').val('0');


    $('.product').not(':first').remove();
    $('.product:first select').empty();
    $('.product:first select').append('<option label="선택" value=""></option>');
    $('tbody .plus').attr('disabled', false);
    var productLength = $('.plus').length;
    if(productLength == 0){
        $('.product').append('<button class="plus btn btn-default d-inline-block btn-sm mr-2">추가</button>');
    }
    productB();

    $('#create').show();
}

$('#vocReset').click(function(){
    vocServiceFieldReset();
});