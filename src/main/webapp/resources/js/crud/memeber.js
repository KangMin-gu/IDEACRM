
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