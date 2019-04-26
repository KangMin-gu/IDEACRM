
$('.passreset').click(function(e){
    pwdReset();
});

function pwdReset(){
    var userNo = $('#userno').val();
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


function id_check(e){
    var idcheck = $('#userid').val();
    var text ="";
    if(idcheck.length < 5){
        text = 'ID는 5글자 이상 입력되어야 합니다.';
        alert(text);
        $('#userid').addClass('error');
        $('#userid').focus();
    }else{

        $.ajax({
            url:"/user/idcheck?userid="+idcheck ,
            method: "GET",
            dataType: "json",
            cache: false,
            success:function(data){
                if(data == 0){
                    $('#command').submit();
                }else{
                    $('#userid').focus();
                    text = '이미 존재하고 있는 ID입니다.';
                    alert(text);
                    $('#userid').addClass('error');
                    $('#userid').next().text(text);
                    $('#userid').next().show();
                    $('#userid').next().addClass('error');

                    return false;
                }
            },
            error:function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    }
}

$('#licenseinsert').click(function(e){
    e.stopPropagation();
    alert("메뉴부여가 되었습니다.");
    return true;

});