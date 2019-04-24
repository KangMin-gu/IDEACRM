function btnFirst(){
    $(".body input").attr("readonly",true);
    $('.body select').attr('disabled','disabled');
    $('#create').show();
    $('#delete').hide();
    $('#update').hide();
    $('#save').hide();
    $('#cancel').hide();
    $('#bodyreset').hide();
    $('.error').addClass('errors').removeClass('error');
}
function btnRead(){
    $(".body input").attr("readonly",true);
    $('.body select').attr('disabled','disabled');
    $('#create').show();
    $('#delete').show();
    $('#update').show();
    $('#save').hide();
    $('#cancel').hide();
    $('#bodyreset').hide();
    $('.error').addClass('errors').removeClass('error');
}
function btnCreate(){
    $(".body input").attr("readonly",false);
    $('.body select').attr("readonly",false);
    $('.body select').removeAttr('disabled');
    $('#create').hide();
    $('#delete').hide();
    $('#update').hide();
    $('#save').show();
    $('#cancel').show();
    $('#bodyreset').show();
    $('.errors').addClass('error').removeClass('errors');
}

function bodyReset(){
    $('.body input').val('');
    $('.errors').addClass('error').removeClass('errors');
}

var QueryString = '/company/code';

$('#cancel').click(function (e) {
    var codeNo = $('#codeno').val();
    if(codeNo == ""){
        btnFirst();
    }else{
        $.ajax({
            url: QueryString+"/"+codeNo,
            method: "GET",
            dataType: "json",
            cache: false,
            success: function (data) {
                $('.body #viewcodegrp').val(data.CODEGRP);
                $('.body #viewcodename').val(data.CODENAME);
                $('.body #viewcodeval').val(data.CODEVAL);
                $('.body #viewusingmenu').val(data.USINGMENU);
                $('.body #viewuppercodegrp').val(data.UPPERCODEGRP);
                $('.body #codeno').val(data.CODENO);

                btnRead();
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    }
});

$('#bodyreset').click(function (e) {
    bodyReset();
});
$('#delete').click(function(e){
    var codeNo = $('#codeno').val();
    var param = {"codeno":codeNo};
    $.ajax({
        url: QueryString+"/del/"+codeNo,
        method: "POST",
        dataType: "json",
        data:param,
        cache: false,
        success: function (data) {
            alert("삭제되었습니다.");
            btnFirst();
            location.reload();
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });

});
$('#create').click(function(e){
    bodyReset();
    btnCreate();
    $(".required[id='codegrp']").prop('disabled', false );

});
$('#update').click(function(e){
    btnCreate();
    $(".required[id='codegrp']").prop('disabled', true );
});
$('#save').click(function(e){
    var codeNo = $('#codeno').val();
    if(codeNo == '' || codeNo == undefined){
        url= QueryString+"/input";
    }else{
        url= QueryString+"/modified/"+codeNo;
    }
    var codegrp= $(".body #viewcodegrp").val();
    var codename = $(".body #viewcodename").val();
    var codeval = $(".body #viewcodeval").val();
    var usingmenu = $(".body #viewusingmenu").val();
    var uppercodegrp = $(".body #viewuppercodegrp").val();
    var codeno = $(".body #codeno").val();

    var param = {"codegrp":codegrp,"codename":codename,"codeval":codeval,"uppercodegrp":uppercodegrp,"codeno":codeno,"usingmenu":usingmenu};
    $.ajax({
        url: url,
        method: "POST",
        dataType: "json",
        data:param,
        cache: false,
        success: function () {
            btnRead();
            alert("저장되었습니다.");
            location.reload();
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });

});
$(".footable").on("click.ft.row",function(obj,e,ft,row) {
    var pathUrl = window.location.pathname;
    if($(obj.target.parentElement.parentElement).is('tbody')) {
        if (pathUrl == '/popuppercode') {
            popParentNameClick($(obj.target.parentElement));
        } else {
            var id = $(obj.target.parentElement).children().eq(0).text();
            if (id.length > 5 && id.indexOf(" ") < 0) {
                $('#codeno').val(id);
                btnRead();
                $.ajax({
                    url: QueryString + "/" + id,
                    method: "GET",
                    dataType: "json",
                    cache: false,
                    success: function (data) {

                        $('.body #viewcodegrp').val(data.CODEGRP);
                        $('.body #viewcodename').val(data.CODENAME);
                        $('.body #viewcodeval').val(data.CODEVAL);
                        $('.body #viewuppercodegrp').val(data.UPPERCODEGRP);
                        $('.body #viewuppercodegrp_').val(data.UPPERCODEGRP_);
                    },
                    error: function (request, status, error) {
                        alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
                    }
                });
            }
        }
    }
});

$('.button').click(function(e){
    var id = e.target.id;
    $('#codegrp').val(id);
    $('.search').click();
});