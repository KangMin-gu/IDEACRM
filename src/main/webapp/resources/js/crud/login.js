
$(document).ready(function(){
    // localStorage 에 저장된 아이디 비밀번호가 있으면 복구시켜준다.
    if(localStorage.idId != undefined){
        $("#userid").val(localStorage.idId);
        //체크박스 체크해주기
        $("#isSave").prop("checked", true);
    }
});

//폼 전송 이벤트가 발생했을때 실행할 함수 등록
$("#loginChk").on("submit", function(){
    //아이디 비밀번호 저장여부
    var isSave=$("#isSave").is(":checked");
    if(isSave){
        //입력한 아이디 비밀번호를 읽어와서
        var inputId=$("#userid").val();
        //localStorage 에 저장한다.
        localStorage.idId=inputId;
    }else{
        //localStorage 에 id, pwd 삭제하기
        delete localStorage.idId;
    }
});

$('#allNoticeBtn').click(function(){
    window.open("/pop/notice", "공지사항","width=1200px, height=650px");
});

