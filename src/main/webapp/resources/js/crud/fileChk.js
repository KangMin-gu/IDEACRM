

$(document).ready(function(){
    $('#files').removeAttr('disabled');
});


//회원사 로고 체크
$('input[class=logoChk]').change(function(){
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


//멀티 파일업로드 확장자 및 사이즈 체크
$('input[class=fileChk]').change(function(){
    fileBuffer = [];
    const target = document.getElementById('files');
    const target2 = $('#files').val();
    //Array.prototype.push.apply(fileBuffer, target.files[0].name);

    for(var i =0; i<target.files.length; i++){
        const fileName = target.files[i].name;
        const fileSize = target.files[i].size;
        var fileEx = fileName.slice(fileName.indexOf(".") + 1).toLowerCase();

        if($.inArray(fileEx, ["xls","xlsx","doc","docx","ppt","pptx","pdf","jpg","gif","tif","bmp","mov","ogg","zip","wav","txt","png","PNG","ZIP"]) == -1 ){
            alert("해당 파일은 등록 가능한 확장자가 아닙니다.");
            $('input[class=fileChk]').val("");
            return false;
        }

        var maxSize = 50*1024*1024;
        if(fileSize > maxSize) {
            alert("파일사이즈를 초과하였습니다.");
            $('input[class=fileChk]').val("");
            return false;
        }

    }

});

//파일폼 전송시 file null 체크
$('#multiFile').submit(function(){
    var fileChk = $('#files').val();

    if(fileChk == ""){
        $('#files').attr('disabled','true');
    }

});

//파일폼 전송시 file null 체크
$('#logoFile').submit(function(){
    var fileChk = $('#files').val();

    if(fileChk == ""){
        $('#files').attr('disabled','true');
    }

});