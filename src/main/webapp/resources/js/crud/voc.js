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
    debugger;
    var param = {
        "mobile" : $(obj).val()};
    $.ajax({
        url: "/voc/custsearch",
        method: "POST",
        dataType: "json",
        data : param,
        cache: false,
        success: function (data) {
            var length = data.length;
            if(length == 1){
                custInfoBinding(data[0]);
            }else {
                openNewWindow('고객검색','/voc/custsearch','',1000,680);
            }
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}

// voc 고객 인풋 필드 데이터 바인딩
function custInfoBinding(data) {
debugger;
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
            debugger;
            vocCustFieldReset();
            custFormActivation('update');
            custInfoBinding(data);
            vocGetServiceInfo('/voc/pop/service/'+custno);
            //블랙이면 인풋창 css변경
            var blackCnt = data.BLACKCNT;
            if(blackCnt > 0){
                blackCustCssChange(true);
                blackSpanActivation('update');
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
    vocCustFieldReset();
    custFormActivation('insert');
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
    if(mobile == ''){
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
    debugger;
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
                debugger;
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
    debugger;
    var jsonPrm = getDataToJson('blackCustInput');
    $.ajax({
        url: url,
        method: "POST",
        dataType: "json",
        data: jsonPrm,
        cache: false,
        success : function(response) {
            debugger;
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

$('#vocServiceTabBtn').click(function(){
    var custno = $('#custno').val();
    if( !custno == false )
        tabFootableSearchList('vocSvTab', '/voc/tab/sv');
});
$('#vocBlackTabBtn').click(function(){
    var custno = $('#custno').val();
    if( !custno == false )
        tabFootableSearchList('vocBlackTab','/voc/tab/black');
});

$('#vocCallbackHistTabBtn').click(function(){
    var custno = $('#custno').val();
    if( !custno == false )
        tabFootableSearchList('vocCallbackHistTab','/voc/tab/callbackhist');
});

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
debugger;
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
    }, function () {
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
    opener.$('#servicecode2').append('<option value='+data.SERVICECODE2+'>'+data.SERVICECODE2+'</option>');
    opener.$('#servicecode2').val(data.SERVICECODE2);
    opener.$('#servicename').val(data.SERVICENAME);
    opener.$('#servicedesc').val(data.SERVICEDESC);
    opener.tinymce.activeEditor.setMode('readonly');
    opener.tinymce.activeEditor.setContent(data.SERVICEDESC);
    //opener.oEditors.getById["servicedesc"].exec("SET_IR", [""]); //내용초기화

    //opener.oEditors.getById["servicedesc"].exec("PASTE_HTML", [data.SERVICEDESC]); //내용밀어넣기
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
            opener.$('#conveyreason').val(data.convey.CONVEYREASON);
            opener.$('#conveydesc').val(data.convey.CONVEYDESC);
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
    opener.$('.voc').iCheck('disable');
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

$('#save').click(
    function(e) {
        var reqno = $('#reqno').val();

        if(reqno == ""){
            alert("고객과의 전화를 끊어주세요");
        }else{
            var servicetype = $('.servicetype .checked input').val();
            var servicename = $("#servicename").val();
            var servicedesc = tinymce.activeEditor.getContent();
            var vocstep = $('.check:checked').val();
            var nextowner = $('#nextowner').val();
            var conveyreason = $('#conveyreason').val();
            var conveydesc = $('#conveydesc').val();
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
                "reqno" : reqno
            };

            var productNum = $('.plus:last').prev().attr('id').substring(7, 8);

            for (i = 1; i <= productNum; i++) {
                var products = $('[id*="product' + i + '1"]').attr('id');
                var products2 = $('[id*="product' + i + '2"]').attr('id');
                var products3 = $('[id*="product' + i + '3"]').attr('id');

                param[products] = $('[id*="product' + i + '1"]').val();
                param[products2] = $('[id*="product' + i + '2"]').val();
                param[products3] = $('[id*="product' + i + '3"]').val();
            }

            $.ajax({
                url : "/service/input",
                method : "POST",
                dataType : "json",
                data : param,
                cache : false,
                success : function(data) {
                    if (data != 0) {
                        alert("저장되었습니다.");
                        // 데이터 전부 초기화
                        $('.form-control').val('').keyup();
                        tinymce.activeEditor.setContent('');
                        $('#create').show();
                        $('#save').hide();
                        $('[id*=product]').attr('disabled',true);
                        $('#servicename').attr('disabled',true);
                        $('#memo').attr('disabled',true);
                        tinymce.activeEditor.setMode('readonly');
                        $('.voc').iCheck('disable');
                        $('#servicetype').iCheck('check');
                        $('#custname').css({"background-color":"#ffffff"});
                        //oEditors.getById["servicedesc"].exec("SET_IR", [""]); //내용초기화
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
        openNewWindow('AS기사', '/vc/voc/cal', e.currentTarget.id, 1200, 800);
    }

});

$('#save').click(
    function(e) {
        var reqno = $('#reqno').val();

        if(reqno == ""){
            alert("고객과의 전화를 끊어주세요");
        }else{
            var servicetype = $('.servicetype .checked input').val();
            var servicename = $("#servicename").val();
            var servicedesc = tinymce.activeEditor.getContent();
            var vocstep = $('.check:checked').val();
            var nextowner = $('#nextowner').val();
            var conveyreason = $('#conveyreason').val();
            var conveydesc = $('#conveydesc').val();
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
                "reqno" : reqno
            };

            var productNum = $('.plus:last').prev().attr('id').substring(7, 8);

            for (i = 1; i <= productNum; i++) {
                var products = $('[id*="product' + i + '1"]').attr('id');
                var products2 = $('[id*="product' + i + '2"]').attr('id');
                var products3 = $('[id*="product' + i + '3"]').attr('id');

                param[products] = $('[id*="product' + i + '1"]').val();
                param[products2] = $('[id*="product' + i + '2"]').val();
                param[products3] = $('[id*="product' + i + '3"]').val();
            }

            $.ajax({
                url : "/vc/voc/post",
                method : "POST",
                dataType : "json",
                data : param,
                cache : false,
                success : function(data) {
                    if (data != 0) {
                        alert("저장되었습니다.");
                        // 데이터 전부 초기화
                        $('.form-control').val('').keyup();
                        tinymce.activeEditor.setContent('');
                        $('#create').show();
                        $('#save').hide();
                        $('[id*=product]').attr('disabled',true);
                        $('#servicename').attr('disabled',true);
                        $('#memo').attr('disabled',true);
                        tinymce.activeEditor.setMode('readonly');
                        $('.voc').iCheck('disable');
                        $('#servicetype').iCheck('check');
                        $('#custname').css({"background-color":"#ffffff"});
                        //oEditors.getById["servicedesc"].exec("SET_IR", [""]); //내용초기화
                    }
                },
                error : function(request, status, error) {
                    alert("code:" + request.status + "\n" + "message:"
                        + request.responseText + "\n" + "error:" + error);
                }
            });
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


function productB() {
    var urlServ = "/vc/productB";
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