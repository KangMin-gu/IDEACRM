
function KKOCHECK(check){
    if(check != 1){
        alert("카카오 템플릿은 관리자에게 문의 부탁드립니다.");
        $('#sendtype').focus();
        $('#sendtype').val(0);
        $('.kko').hide();
        return false;
    }else{
        $('.kko').show();
    }
}