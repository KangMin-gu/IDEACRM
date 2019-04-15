/*********확장자 체크***********/

/*
 *
 * Ajax 파일업로드 확장체크
 *
 *
 */

//회원사 로고 체크
$('input[id=logoChk]').change(function(){
    if($(this).val() != ""){

        var ext = $(this).val().split(".").pop().toLowerCase();

        if($.inArray(ext, ["gif","jpg","jpeg","png"]) == -1 ){
            alert("gif, jpg, jpeg, png 파일만 업로드 해주세요.");
            $(this).val("");
            return;
        }

        var fileSize = this.files[0].size;
        var maxSize = 1024*1024;
        if(fileSize > maxSize){
            alert("로고파일은 10MB 이내로 등록 가능합니다.");
            $(this).val("");
            return;
        }

        var file  = this.files[0];
        var _URL = window.URL || window.webkitURL;
        var img = new Image();

        img.src = _URL.createObjectURL(file);
        img.onload = function() {

            if(img.width != 170 || img.height != 48) {
                alert("이미지 가로 170px, 세로 48px로 맞춰서 올려주세요.");
                $('input[id=logoChk]').val("");
                return;
            }
        }
    }
});




//내부통지 파일업로드
$('input[class=fileChk]').change(function(){
    fileBuffer = [];
    const target2 = document.getElementsByName('file');
    const target = $('.fileChk').val();
    Array.prototype.push.apply(fileBuffer, target[0].files);

    $.each(fileBuffer, function(index, file){
        const fileName = file.name;
        const fileEx = fileName.slice(fileName.indexOf(".") + 1).toLowerCase();

        if($.inArray(fileEx, ["xls","xlsx","doc","docx","ppt","pptx","pdf","jpg","gif","tif","bmp","mov","ogg","zip","wav","txt","png","PNG"]) == -1 ){
            alert("해당 파일은 등록 가능한 확장자가 아닙니다.");
            $('input[class=fileChk]').val("");
            return false;
        }

        const fileSize = file.size;
        var maxSize = 1024*1024;
        if(fileSize > maxSize){
            alert("파일사이즈를 초과하였습니다.");
            $('input[id=noteChk]').val("");
            return false;
        }

    });


});
