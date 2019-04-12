$('#searchNumber').keydown(function(key){

    if(key.keyCode == 13){
        openNewWindow('고객검색','/voc/custsearch','',1000,500);
    }
});
/*
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
                openNewWindow('고객검색','/voc/custsearch','',1000,500);
            }else if(length == 1){
                custInfoBinding(data[0]);
            }
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}
*/

function custInfoBinding(data) {// 인풋 필드 데이터 바인딩
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

    if(boolean){
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

function vocCustDetail(){
    var custNo = $('#custno').val();
    if(custNo == 0 || custNo == '' ){
        alert('고객이 선택되지 않았습니다.');
        return;
    }
    openNewWindow('voc','/voc/custdetail/'+custNo,'voc',1200,700);
}
$('#servicecode1').change(function(){
    upperCode('servicecode1');
});



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

function popVocCust(){
    var searchPhoneNo = document.getElementById('searchNumber').value;
    openNewWindow('voc','/voc/custsearch','voc',1260,800);
}