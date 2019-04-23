
function pwdReset(){
    var userNo = $('#userNo').val();
    $.ajax({
        url: "/user/pwdreset?userNo="+userNo,
        method: "GET",
        success: function (data) {
           alert("비밀번호 초기화가 완료되었습니다.");
        },
        error: function (request, status, error) {
            alert("오류가 발생하였습니다. 관리자에게 문의해주세요.");
        }
    });

}


function id_check(){
    var idcheck = $('#userid').val();
    var text ="";
    var bool;
    if(idcheck.length < 5){
        text = 'ID는 5글자 이상 입력되어야 합니다.';
        alert(text);
        $('#userid').addClass('error');
        $('#userid').focus();
    }else{
        $.ajax({
            url:"/user/idcheck/"+idcheck ,
            method: "GET",
            dataType: "json",
            cache: false,
            success:function(data){
                if(data == 0){
                    text = '사용 가능한 ID 입니다.';
                    alert(text);
                    bool = true;
                    return bool;
                }else{
                    text = '이미 존재하고 있는 ID 이거나 입력되지 않았습니다.';
                    alert(text);
                    $('#userid').addClass('error');
                    $('#userid').focus();
                    bool = false
                    return bool;
                }
                return bool;
            },
            error:function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    }
}