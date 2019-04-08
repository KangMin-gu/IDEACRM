$('.cust').click(function(e){
    if( e.target.classList.contains('dataCancle') == false ){
            openNewWindow('고객','/popcust',e.currentTarget.id,650,700);
        }
});
$('.owner').click(function(e){
    if( e.target.classList.contains('dataCancle') == false ){
        openNewWindow('사용자','/popowner',e.currentTarget.id,650,700);
    }
});
$('.client').click(function(e){
    if( e.target.classList.contains('dataCancle') == false ){
        openNewWindow('사용자','/popclient',e.currentTarget.id,650,700);
    }
});



$('#reset').click(function(e){
    $('.searchparam').val('');
    if( $('#infoagree') ){
        $('#infoagree').val(1);
    }
});

$('.smsBtn').click(function(){
    window.open("/voc/sms", "고객상세정보","width=400px, height=600px");
});
$('.emailBtn').click(function(){
    window.open("/voc/email", "고객상세정보","width=1200px, height=900px");
});
$('.kakaoBtn').click(function(){
    window.open("/voc/kakao", "고객상세정보","width=400px, height=600px");
});

var newWindow = null;
// 부모 window 가 실행

function openNewWindow(name,url,target,x,y){
    // specs -> 팝업창의 설정들을 정의해 둔 부분
    var specs= "scrollbars=yes,menubar=no,status=no,toolbar=no,Width="+x+",Height="+y;
    // window.open 함수를 통해서 팝업창 호출
    newWindow = window.open(url, name, specs);
    // window Popup이 되고 난후에 바로 실행시키면 inpu창이 만들어지지 않아서 1초의 시간을 지연시킴
    if(target != ""){
        setTimeout(function(){
            newWindow.document.getElementById("parentid").value = target;
        },1000);
    }
}
// 자식 window가 실행
// 영업 담당자 및 담당자 가지고옴
//tr -> 실제로 클릭한 tr 자체
// 담당자 팝업 클릭
function parentOwnerUser(tr){
    // 접수자, 담당자가 겹치는 경우에 발생할 것 같아서 한번에 처리 할수 있게 수정작업함..
    // parentid => 버튼을 눌렀을때의 id 값
    var parentid = $('#parentid').val();
    // opener -> 부모의 window를 의미함.
    // tr.getAttribute("value") -> tr 값에 value를 넣어두었는데 해당 value 값을 가지고옴 => 여기서는 영업담당자의 키값(USERNO)
    // 버튼을 눌렀을때의 id 값의 next값 즉 Owner_ 옆의 Owner 값(DB에 들어갈값)
    opener.$('[name="'+parentid+'"]').next().val(tr.children().get(0).textContent);
    // tr.children.userName.textContent -> tr하위에있는 td 값중 userName의 text값을 가지고옴 => 여기서는 영업담당자의 이름을 의미
    // 버튼을 눌렀을때의 id 값을 실제로 넣음.
    opener.$('[name="'+parentid+'"]').val(tr.children().get(1).textContent).trigger('keyup');
    opener.$('#'+parentid).trigger('keyup');
    // window 창을 종료 -> 담당자 팝업을 종료함.
    window.close();
}
// 고객 팝업 클릭
function parentCustname(tr){
    var parentid = $('#parentid').val();
    opener.$('[name="'+parentid+'"]').next().val(tr.children().get(0).textContent);
    opener.$('[name="'+parentid+'"]').val(tr.children().get(1).textContent).trigger('keyup');
    if(parentid != "relcustname"){//관련 고객에서의 호출이 아니라면 아래행 실행
        popCustClick(tr.children().get(0).textContent);
    }

    setTimeout(function(){
        window.close();
    },300);
}
// 거래처 팝업 클릭
function popParentNameClick(tr){
    var parentid = $('#parentid').val();
    opener.$('[name="'+parentid+'"]').next().val(tr.children().get(0).textContent);
    opener.$('[name="'+parentid+'"]').val(tr.children().get(1).textContent).trigger('keyup');
    setTimeout(function(){
        window.close();
    },300);
}

function popCustClick(id){
    $.ajax({
        url: "/popcust/"+id,
        method: "GET",
        dataType: "json",
        success: function (data) {
            var addr = data.HOMADDR1 + data.HOMADDR2 + data.HOMADDR3;
            if(addr == '0'){
                addr ='';
            }
            opener.$('#company').val('');
            opener.$('#duty').val('');
            opener.$('#custaddress').val('');
            opener.$('#mobile').val('');
            opener.$('#email').val('');

            opener.$('#company').val(data.COMPANY);
            opener.$('#duty').val(data.DUTY);
            opener.$('#custaddress').val(addr);
            opener.$('#custaddress').text(addr);
            opener.$('#mobile').val(data.MOBILE_);
            opener.$('#mobile').text(data.MOBILE_);
            opener.$('#hometel').val(data.HOMTEL_);
            opener.$('#hometel').text(data.HOMTEL_);
            opener.$('#email').val(data.EMAIL);
            opener.$('#email').text(data.EMAIL);
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}



// 검색조건들 footable에서 사용하기 위해서 json형태로 변환
function searchDataToJson() {
    var param = {};
    var data = $('.searchparam');
    var dataLength = data.length;

    for (i = 0; i < dataLength; i++) {
        var idVal = data[i].id;
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
    tabFootableSearchList(href,url);
});

// 상위 코드 받아서 하위코드 매핑하기
function upperCode(codeGrp){
    var code = $('#'+codeGrp).val();
    var id = $('#'+codeGrp).attr('id');
    var url = "/code/upper"
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