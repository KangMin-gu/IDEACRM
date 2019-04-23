function callBackList(pageNum){
    var callBack  = $('#callback').val();
    if(callBack != ''){
        var url = '/callBackList?pageNum='+pageNum+'&callBack='+callBack;
    }else{
        var url = '/callBackList?pageNum='+pageNum;
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
            var length = data.callBack.length;
            var html ="";
            for (var i = 0; i < length; i++) {

                html = '<tr><td><input type="checkbox" class="i-checks chksquare" name="callbackno" id="callbackno" value="'+data.callBack[i].CALLBACKNO+'"></td><td>' + data.callBack[i].RECEIVEDATE_ + '</td><td>' + data.callBack[i].CALLER + '</td><td>' + data.callBack[i].CALLBACK + '</td></tr>';
                $('.ibox-left .table-responsive tbody').append(html);
            }
            var html2= "";

            if (data.page.startPageNum != 1) {
                html2 += '<li class="footable-page-arrow disabled"><a onclick="tabTargetCust(' + eval(data.page.startPageNum - 1) + ')" >&laquo;</a></li>'
            } else {
                html2 += '<li class="disabled"><a href="javascript:">&laquo;</a></li>'
            }
            for (var i = data.page.startPageNum; i <= data.page.endPageNum; i++) {
                if (i == data.page.pageNum) {
                    html2 += '<li class="footable-page active"><a onclick="tabTargetCust(' + i + ')">'+i+'</a></li>'
                } else {
                    html2 += '<li><a onclick="tabTargetCust(' + i + ')">'+i+'</a></li>'
                }
            }
            if (data.page.endPageNum < data.page.totalPageCount) {
                html2 += '<li><a onclick="tabTargetCust(' + eval(data.page.endPageNum + 1)+')">&raquo;</a></li>'
            } else {
                html2 += '<li class="disabled"><a href="javascript:">&raquo;</a></li>'
            }
            html3 = '<h4 class="float-right">&middot; 총 자료수 : ' +data.totalRows +'건</h4>';

            $('.ibox-left .pagination').append(html2);
            $('.ibox-left .m-auto').prepend(html3);

            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}


function ctiUserList(pageNum){
    var userNo  = $('#owner').val();
    if(userNo != ''){
        var url = '/callBackUserList?pageNum='+pageNum+'&userNo='+userNo;
    }else{
        var url = '/callBackUserList?pageNum='+pageNum;
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
            var length = data.callBackUser.length;
            var html ="";
            for (var i = 0; i < length; i++) {

                html = '<tr><td><input type="checkbox" class="i-checks chksquare" name="userno" id="userno" value="'+data.callBackUser[i].USERNO+'"></td><td>' + data.callBackUser[i].USERNAME + '</td><td>' + data.callBackUser[i].USERID + '</td><td>'+data.callBackUser[i].CTICOUNT+'</td></tr>';
                $('.ibox-right .table-responsive tbody').append(html);
            }
            var html2= "";

            if (data.page.startPageNum != 1) {
                html2 += '<li class="footable-page-arrow disabled"><a onclick="tabTargetCust(' + eval(data.page.startPageNum - 1) + ')" >&laquo;</a></li>'
            } else {
                html2 += '<li class="disabled"><a href="javascript:">&laquo;</a></li>'
            }
            for (var i = data.page.startPageNum; i <= data.page.endPageNum; i++) {
                if (i == data.page.pageNum) {
                    html2 += '<li class="footable-page active"><a onclick="tabTargetCust(' + i + ')">'+i+'</a></li>'
                } else {
                    html2 += '<li><a onclick="tabTargetCust(' + i + ')">'+i+'</a></li>'
                }
            }
            if (data.page.endPageNum < data.page.totalPageCount) {
                html2 += '<li><a onclick="tabTargetCust(' + eval(data.page.endPageNum + 1)+')">&raquo;</a></li>'
            } else {
                html2 += '<li class="disabled"><a href="javascript:">&raquo;</a></li>'
            }
            html3 = '<h4 class="float-right">&middot; 총 자료수 : ' +data.totalRows +'건</h4>';

            $('.ibox-right .pagination').append(html2);
            $('.ibox-right .m-auto').prepend(html3);

            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}