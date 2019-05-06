// 하단의 탭중 첫번째 값을 클릭
if($('.detail').length > 0){
    setTimeout(function(){
        $('.detail > li:first >a').click();
    },500);
}

$('.cust').click(function(e){
    if( e.target.classList.contains('dataCancle') == false ){
            openNewWindow('고객','/popcust',e.currentTarget.id,650,700);
        }
});

// 사용자 팝업
$('.owner').click(function(e){
    debugger;
    if( e.target.classList.contains('dataCancle') == false ){
        openNewWindow('사용자','/popuser',e.currentTarget.id,650,700);
    }
});

//거래처 팝업
$('.client').click(function(e){
    if( e.target.classList.contains('dataCancle') == false ){
        openNewWindow('거래처','/popaccount',e.currentTarget.id,650,700);
    }
});
// 초기화 버튼클릭(List)
$('#reset').click(function(e){
    $('.searchparam').val('');
    if( $('#infoagree') ){
        $('#infoagree').val(1);
    }
});

// sms 모양 클릭
$('.smsBtn').click(function(){
    window.open("/popsms", "문자발송","width=450px, height=600px");
});
// 이메일 모양 클릭
$('.emailBtn').click(function(){
    window.open("/popemail", "메일발송","width=1200px, height=900px");
});
$('.insideNoticeBtn').click(function(){
    window.open("/popbox", "내부통지","width=1200px, height=900px");
});
$('.kakaoBtn').click(function(){
    window.open("/popkakao", "카카오발송","width=450px, height=600px");
});
$('.excel').click(function(e){
    var url = $('#excelUrl').val();//엑셀 페이지에 url이 담긴 히든값 셋팅 필요
    var searchPrmJson = jQuery.param(searchDataToJson());
    window.location.href = url + '?' + searchPrmJson;
});

var newWindow = null;
// 부모 window 가 실행
function openNewWindow(name,url,target,x,y){
    // specs -> 팝업창의 설정들을 정의해 둔 부분
    var specs= "resizable=yes,scrollbars=yes,menubar=no,status=no,toolbar=no,Width="+x+",Height="+y;
    // window.open 함수를 통해서 팝업창 호출
    newWindow = window.open(url, name, specs);
    // window Popup이 되고 난후에 바로 실행시키면 inpu창이 만들어지지 않아서 1초의 시간을 지연시킴
    if(target != ""){
        setTimeout(function(){
            newWindow.document.getElementById("parentid").value = target;
        },1000);
    }
}
// 풀스크린 팝업 윈도우
function openNewWindowFullScreen(url){
    window.open(url, "", "resizable=yes,scrollbars=yes,channelmode=yes");
}

// 팝업에서 tr 값 클릭 이벤트
function popParentNameClick(tr){
    debugger;
    var parentid = $('#parentid').val();
    opener.$('[name="'+parentid+'"]').next().val(tr.children().get(0).textContent);
    opener.$('[name="'+parentid+'"]').val(tr.children().get(1).textContent).trigger('keyup');
    setTimeout(function(){
        window.close();
    },300);
}

// 검색조건들 footable에서 사용하기 위해서 json형태로 변환
function searchDataToJson() {
    var param = {};
    var data = $('.searchparam');
    var dataLength = data.length;

    for (i = 0; i < dataLength; i++) {
        var idVal = data[i].name;
        if (idVal != '') {
            if (idVal.substring(0, 4) == 'deny') { // 수신거부 체크박스 항목일 경우
                if ($('#' + idVal).prop('checked') == true) {
                    param[idVal] = dataata[i].value;//체크 되었으면 값 바인딩
                } else {
                    param[idVal] = 0; // 체크 해제 되었다면 0
                }
            } else {
                param[idVal] = data[i].value;
            }
        }
    }
    return param;
}
// Detail화면의 상세내역을 보기위한 Tab클릭 이벤트
$('.detail').find('.nav-link').click(function(e){
    // click 탭의 href의 값을 가지고 온다.
    var href = e.target.attributes.href.value;
    // href의 tabpanel에 footable에 사용할 url을 가지고 온다.
    var url = $(href).attr('url');
    if(url != undefined){
        tabFootableSearchList(href,url);
    }
});

// 상위 코드 받아서 하위코드 매핑하기
function upperCode(codeGrp){
    var code = $('#'+codeGrp).val();
    var id = $('#'+codeGrp).attr('id');
    var url = "/company/code/upper"
    $.ajax({
        url: url+"?codegrp="+id+"&codeval="+code,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            var text = "";
            $('[upper="'+codeGrp+'"] option').remove();
            $('[upper="'+codeGrp+'"]').append('<option label="선택" value="0"/>');
            for(i=0;i<data.length;i++){
                text = '<option label="'+data[i].codename+'" value="'+data[i].codeval+'"/>';
                $('[upper="'+codeGrp+'"]').append(text);
            }
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}
// text길이 값 가지고옴
function getTextLength(str) {
    var len = 0;
    for (var i = 0; i < str.length; i++) {
        if (escape(str.charAt(i)).length == 6) {
            len++;
        }
        len++;
    }
    return len;
}
function smsToLms(obj){
    var str =  $('#'+obj).val();
    var textLength = getTextLength(str);
    if(textLength > 80){
        var bool = confirm("80바이트이상 작성하여서 LMS로 자동 전환합니다.");
        if(bool){
            $('#'+obj).val(str);
            $('#lengthtype').val(1);
            alert("Lms로 전환되어 저장됩니다.");
            return true;
        }else{
            var limit = '80' //제한byte를 가져온다.
            var strLength = 0;
            var strTitle = "";
            var strPiece = "";
            var check = false;

            for (i = 0; i < textLength; i++){
                var code = str.charCodeAt(i);
                var ch = str.substr(i,1).toUpperCase();
                //체크 하는 문자를 저장
                strPiece = str.substr(i,1);

                code = parseInt(code);

                if ((ch < "0" || ch > "9") && (ch < "A" || ch > "Z") && ((code > 255) || (code < 0))){
                    strLength = strLength + 2; //UTF-8 3byte 로 계산
                }else{
                    strLength = strLength + 1;
                }
                if(strLength>limit){
                    $('#lengthtype').val(0);
                    alert(limit+"byte 초과된 문자는 잘려서 입력 됩니다.");
                    $('#'+obj).val(strTitle);
                    var textLength = getTextLength(strTitle);
                    textLength = textLength +'/ 80';
                    $('#bytelength').text(textLength);
                    return false;
                }else{
                    strTitle = strTitle+strPiece; //제한길이 보다 작으면 자른 문자를 붙여준다.
                }
            }
        }
    }
}

function dateRangeError(){
    var boolean;
    $('.daterange').each(function(index,item){
        var val = $(item).val();
        var dataLength = val.length;
        if(val != ''){
            if(dataLength < 23){
                alert('올바른 날자형식이 아닙니다. 다시 선택해주세요');
                $(item).focus();
                boolean = false;
            }else{
                boolean = true;
            }
        }else{
            boolean = true;
        }
    });
    return boolean;
}

function today(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10) {
        dd='0'+dd
    }
    if(mm<10) {
        mm='0'+mm
    }
    today = yyyy+'-' + mm+'-'+dd;

    return today;
}

//동일 버튼 클릭 시간이 3초 미만이면 false 리턴
//파라미터 버튼 obj  리턴타입 boolean
function boolTimeDiff(obj){
    var SET_TIME = 3000; //설정 타임 1초 = 1000

    if( !obj.attr("runtime") == true ){//this가 '' 또는 null 또는 undefind 라면
        obj.attr("runtime",new Date()); // runtime 셋팅
        return true;
    }else{
        var newTime = new Date(); //현재시간
        var oldTime = new Date(obj.attr('runtime')); //runtime에 있는 String형태의 값을 Date 포멧으로 변환
        var timeDiff =  newTime.getTime() - oldTime.getTime(); // 현재시간 - 메뉴 클릭 시간  (단위 : 밀리세컨드)
        // console.log(timeDiff);
        if(timeDiff > SET_TIME ){
            //   console.log('3초 지남');
            obj.attr("runtime",new Date());
            return true;
        }else{
            // console.log('#초 안지남');
            obj.attr("runtime",new Date());
            return false;
        }
    }
}

