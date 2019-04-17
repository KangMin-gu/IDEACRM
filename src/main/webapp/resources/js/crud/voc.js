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
        $('.vocCustInput:input:checkbox').val(1);
        $('.vocCustInput:input:checkbox').prop('checked',false);
    }else{ //팝업에서 호출
        opener.$('#relcustname').val('');
        opener.$('.vocCustInput').val('');
        opener.$('#custgrade').val(0);
        opener.$('#custgubun').val(0);
        opener.$('#relcustno').val(0);
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
        btnStr = "<button type='button' class='btn btn-default pull-left' style='margin-right: 9px;' onClick='addBlack()'>블랙추가</button>";
    } else if (statusStr == 'update') {
        btnStr = "<button type='button' class='btn btn-default pull-left' style='margin-right: 9px;' onClick='cancleBlack()'>블랙해제</button>";
    }
    if (fromStr == "voc") {// 호출한 곳이 voc 페이지면
        $('#blackSpan').empty();
        $('#blackSpan').html(btnStr);
    } else {// 팝업
        opener.$('#blackSpan').empty();
        opener.$('#blackSpan').html(btnStr);
    }
}

//블랙추가 - 블랙리스트 추가 팝업 페이지 호출
function addBlack(){
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
    console.log('vocServiceTabBtn click');
    tabFootableSearchList('tab-1','/voc/tab/sv');
});