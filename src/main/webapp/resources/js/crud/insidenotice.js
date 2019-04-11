//읽음으로체크
$('#eyeChk').click(function(){
    var checkArr=[]
    $("input[name='noticeid']:checked").each(function(i){
        checkArr.push($(this).val());
    });
    var allData = {"checkArr": checkArr };

    $.ajax({
        url:"eyechk",
        type:'GET',
        data: allData,
        success:function(data){
            location.reload();
        },
        error:function(jqXHR, textStatus, errorThrown){
            alert("통지가 선택되지 않았습니다.");
            return false;
        }
    });
});
//휴지통이동
$("#trashChk").click(function(){
    var checkArr=[]
    $("input[name='noticeid']:checked").each(function(i){
        checkArr.push($(this).val());
    });
    var allData = {"checkArr": checkArr };
    $.ajax({
        url:"trashchk",
        type:'GET',
        data: allData,
        success:function(data){
            location.reload();
        },
        error:function(jqXHR, textStatus, errorThrown){
            alert("통지가 선택되지 않았습니다.");
            return false;
        }
    });
});