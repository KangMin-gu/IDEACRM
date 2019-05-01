


$('#leftSearch').click(function(e){
    callBackList(1);
});
$('[name="owner_"]').keyup(function(e){
    ctiUserList(1);
});

function icheckAllAct(){ //checkbox 전체 선택/해제 이벤트
    $('.icheckAll').on('ifChecked', function(event){
        if(event.target.id == 'user'){ $('.callBackUser').iCheck('check'); }
        else{ $('.callBack').iCheck('check'); }
    });
    $('.icheckAll').on('ifUnchecked', function(event){
        if(event.target.id == 'user'){ $('.callBackUser').iCheck('uncheck'); }
        else{ $('.callBack').iCheck('uncheck'); }
    });
}

function callBackList(pageNum){
    var callBack  = $('#callback').val();
    if(callBack != ''){
        var url = '/voc/pop/calldiv/call?pageNum='+pageNum+'&callBack='+callBack;
    }else{
        var url = '/voc/pop/calldiv/call?pageNum='+pageNum;
    }
    $.ajax({
        url: url ,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            $('.ibox-left .table-responsive tbody tr').remove();
            $('.ibox-left .pagination li').remove();
            $('.ibox-left .m-auto h4').remove();

            var length = 0;
            if( !data.callBack == false ){
                length = data.callBack.length;
            }

            var html ="";
            for (var i = 0; i < length; i++) {
                html = '<tr><td><input type="checkbox" class="i-checks callBack" name="callbackno" id="callbackno" value="'+data.callBack[i].CALLBACKNO+'"></td><td>' + data.callBack[i].RECEIVEDATE_ + '</td><td>' + data.callBack[i].CALLER + '</td><td>' + data.callBack[i].CALLBACK + '</td></tr>';
                $('.ibox-left .table-responsive tbody').append(html);
            }
            var html2= "";

            if (data.page.startPageNum != 1) {
                html2 += '<li class="footable-page-arrow disabled"><a onclick="callBackList(' + eval(data.page.startPageNum - 1) + ')" >&laquo;</a></li>';
            } else {
                html2 += '<li class="disabled"><a href="javascript:">&laquo;</a></li>'
            }
            for (var i = data.page.startPageNum; i <= data.page.endPageNum; i++) {
                if (i == data.page.pageNum) {
                    html2 += '<li class="footable-page active"><a onclick="callBackList(' + i + ')">'+i+'</a></li>';
                } else {
                    html2 += '<li><a onclick="callBackList(' + i + ')">'+i+'</a></li>';
                }
            }
            if (data.page.endPageNum < data.page.totalPageCount) {
                html2 += '<li><a onclick="callBackList(' + eval(data.page.endPageNum + 1)+')">&raquo;</a></li>';
            } else {
                html2 += '<li class="disabled"><a href="javascript:">&raquo;</a></li>'
            }

            html3 = '<h4 class="float-right">&middot; 총 자료수 : ' +data.totalRows +'건</h4>';

            if( length == 0 ){
                html2 = '';
                html3 = '';
            }

            $('.ibox-left .pagination').append(html2);
            $('.ibox-left .m-auto').prepend(html3);

            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            icheckAllAct();

        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}


function ctiUserList(pageNum){
    var userNo  = $('#owner').val();
    if(userNo != ''){
        var url = '/voc/pop/calldiv/user?pageNum='+pageNum+'&userNo='+userNo;
    }else{
        var url = '/voc/pop/calldiv/user?pageNum='+pageNum;
    }
    $.ajax({
        url: url ,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            $('.ibox-right .table-responsive tbody tr').remove();
            $('.ibox-right .pagination li').remove();
            $('.ibox-right .m-auto h4').remove();
            var length = 0;
            if( !data.callBackUser == false ){
                length = data.callBackUser.length;
            }

            var html ="";
            for (var i = 0; i < length; i++) {

                html = '<tr><td><input type="checkbox" class="i-checks callBackUser" name="userno" id="userno" value="'+data.callBackUser[i].USERNO+'"></td><td>' + data.callBackUser[i].USERNAME + '</td><td>' + data.callBackUser[i].USERID + '</td><td>'+data.callBackUser[i].CTICOUNT+'</td></tr>';
                $('.ibox-right .table-responsive tbody').append(html);
            }
            var html2= "";

            if (data.page.startPageNum != 1) {
                html2 += '<li class="footable-page-arrow disabled"><a onclick="ctiUserList(' + eval(data.page.startPageNum - 1) + ')" >&laquo;</a></li>';
            } else {
                html2 += '<li class="disabled"><a href="javascript:">&laquo;</a></li>';
            }
            for (var i = data.page.startPageNum; i <= data.page.endPageNum; i++) {
                if (i == data.page.pageNum) {
                    html2 += '<li class="footable-page active"><a onclick="ctiUserList(' + i + ')">'+i+'</a></li>';
                } else {
                    html2 += '<li><a onclick="ctiUserList(' + i + ')">'+i+'</a></li>';
                }
            }
            if (data.page.endPageNum < data.page.totalPageCount) {
                html2 += '<li><a onclick="ctiUserList(' + eval(data.page.endPageNum + 1)+')">&raquo;</a></li>';
            } else {
                html2 += '<li class="disabled"><a href="javascript:">&raquo;</a></li>';
            }
            html3 = '<h4 class="float-right">&middot; 총 자료수 : ' +data.totalRows +'건</h4>';

            if( length == 0 ){
                html2 = '';
                html3 = '';
            }

            $('.ibox-right .pagination').append(html2);
            $('.ibox-right .m-auto').prepend(html3);

            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            icheckAllAct();
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}


$('#passDiv').click(function(e){
    var callBackLength = $('.ibox-left .checked').length;
    var userLength = $('.ibox-right .checked').length;

    var callBackNo="";

    if(callBackLength == 0){
        alert("콜백 리스트에서 선택해주세요");
        return false;
    }

    if(userLength == 0){
        alert("사용자 리스트에서 선택해주세요");
        return false;
    }else if(userLength >= 2){
        alert("한명의 사용자만 선택해주세요");
        return false;
    }else{
        var userNo = $('.ibox-right .checked input').val();
        var userName = $('.ibox-right .checked').parent().next().text();
    }

    if(callBackLength > 0 && userLength > 0){
        for(i=0;i < callBackLength; i++){
            var callBackVal = $('.ibox-left .checked:eq('+i+') input').val();
            callBackNo += callBackVal+",";
        }
        var url = "/voc/pop/calldiv/pass?callBackNo="+callBackNo+"&userNo="+userNo;
        $.ajax({
            url: url ,
            method: "GET",
            dataType: "json",
            cache: false,
            success: function (data) {
                alert(data+"건이 "+ userName +" 에게 할당 되었습니다.");
                self.location.reload();
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });

    }

});


$('#autoDiv').click(function(e){
    var userNo = $('#owner').val();
    var callBack = $('#callback').val();

    if(callBack != "" && userNo != ""){
        url='/voc/pop/calldiv/auto?callBack='+parseInt(callBack)+'&userNo='+parseInt(userNo);
    }else if(callBack == "" && userNo != ""){
        url='/voc/pop/calldiv/auto?userNo='+parseInt(userNo);
    }else if(callBack != "" && userNo == ""){
        url='/voc/pop/calldiv/auto?callBack='+parseInt(callBack);
    }else{
        url='/voc/pop/calldiv/auto';
    }
    $.ajax({
        url: url ,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            alert("자동 분배 되었습니다.");
            self.location.reload();
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
});
