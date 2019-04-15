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
            if(length > 1){
                openNewWindow('고객검색','/voc/custsearch','',1000,680);
            }else if(length == 1){
                custInfoBinding(data[0]);
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
    var boolean;
    if(newWindow == null){
        boolean = false;
    }else{
        if(newWindow.closed){
            boolean = false;
        }else{
            boolean = true;
        }
    }

//    if(boolean){
    if(true){
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

    }else{
        $('#custname').val(data.CUSTNAME);
        $('#custno').val(data.CUSTNO);
        $('#custgubun').val(data.CUSTGUBUN);
        $('#mobile1').val(data.MOBILE1);
        $('#mobile2').val(data.MOBILE2);
        $('#mobile3').val(data.MOBILE3);
        $('#homtel1').val(data.HOMTEL1);
        $('#homtel2').val(data.HOMTEL2);
        $('#homtel3').val(data.HOMTEL3);
        $('[name="relcustname"]').val(data.RELCUSTNAME);
        if (data.RELCUSTNO != null && data.RELCUSTNO != '') {
            $('#relcustno').val(data.RELCUSTNO);
        }
        $('#email').val(data.EMAIL);
        $('#custgrade').val(data.CUSTGRADE);
        $('#homaddr1').val(data.HOMADDR1);
        $('#homaddr2').val(data.HOMADDR2);
        $('#homaddr3').val(data.HOMADDR3);
        $('#blackcnt').val(data.BLACKCNT);

        //체크박스 제어
        if(data.DENYMAILNOMAL == 1){ //mail일반
            $('#denymailnomal').iCheck('check');
        }else
            $('#denymailnomal').iCheck('uncheck');

        if(data.DENYMAILSURVEY == 1){ //mail해피콜
            $('#denymailsurvey').iCheck('check');
        }else
            $('#denymailsurvey').iCheck('uncheck');

        if(data.DENYSMSNOMAL == 1){ //sms일반
            $('#denysmsnomal').iCheck('check');
        }else
            $('#denysmsnomal').iCheck('uncheck');

        if(data.DENYSMSSURVEY == 1){ //sms해피콜
            $('#denysmssurvey').iCheck('check');
        }else
            $('#denysmssurvey').iCheck('uncheck');

        if(data.DENYDMNOMAL == 1){ //dm일반
            $('#denydmnomal').iCheck('check');
        }else
            $('#denydmnomal').iCheck('uncheck');

        if(data.DENYDMSURVEY == 1){ //dm해피콜
            $('#denydmsurvey').iCheck('check');
        }else
            $('#denydmsurvey').iCheck('uncheck');
    }
}

//voc 고객 상세보기 팝업
function vocCustDetail(){
    var custNo = $('#custno').val();
    if(custNo == 0 || custNo == '' ){
        alert('고객이 선택되지 않았습니다.');
        return;
    }
    openNewWindow('voc','/voc/custdetail/'+custNo,'voc',1200,700);
}


// voc 고객 팝업 tr 클릭
// 상세정보를 가져와서 필드에 바인딩한다.
function popVocCustNameClick(tr){
    var custno = tr.children().get(0).textContent;
    console.log(custno);
    $.ajax({
        url: "/voc/cust/"+custno,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            custFormActivation('update');
            custInfoBinding(data);
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
    debugger;
    var btnStr = "";
    if (statusStr == 'insert') {
        btnStr = "<button type='button' class='btn btn-default pull-left' style='margin-right: 9px;' onClick='goCustInsert()'>고객등록</button>";
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
    custFormActivation('insert');
    opener.$('.vocCustInput').val('');
    opener.$('.vocCustInput').val();
    window.close();
}

// voc 고객 수정
function goCustUpdate() {
    debugger;
    var custNo = $("#custno").val();
    if(custNo != ""){
        var urlStr = "/voc/cust/modified/"+custNo;
        var param = getCustInfoToJson();
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

//고객 인풋 필드 데이터 json형식 리턴.
function getCustInfoToJson(){
    var param={};
    var custData = $('.vocCustInput');
    var custLength = custData.length;

    for(i=0; i<custLength;i++){
        var idVal = custData[i].id;

        if(idVal.substring(0,4) =='deny' ){ // 수신거부 체크박스 항목일 경우
            if($('#'+idVal).prop('checked') == true){
                param[idVal] = custData[i].value;//체크 되었으면 값 바인딩
            }else{
                param[idVal] = 0; // 체크 해제 되었다면 0
            }

        }else{
            param[idVal] = custData[i].value;
        }
    }
    return param;
}