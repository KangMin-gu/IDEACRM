function licenseDetailPage(siteId){
    $.ajax({
        url: "/company/license/"+siteId,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            var length = $('[name="licenseno"]').length;
            var totalUseCnt = 0;
            var totalLicenseCnt;
            for(var i = 0 ; i < data.length; i++){
                for(var j = 0 ; j< length ; j++){
                    if (data[i].LICENSENO ==$('[name="licenseno"]:eq('+j+')').attr('value')){
                        $('[name="licenseno"]:eq('+j+')').parent().parent().find('[name="isdelete"]').val(data[i].ISDELETE).text(data[i].ISDELETE_);
                        $('[name="licenseno"]:eq('+j+')').parent().parent().find('[name="licensecnt"]').val(data[i].BUYCNT).text(data[i].BUYCNT);
                        $('[name="licenseno"]:eq('+j+')').parent().parent().find('[name="edtdate"]').text(data[i].EDTDATE);
                        $('[name="licenseno"]:eq('+j+')').parent().parent().find('[name="usecnt"]').text(data[i].USECNT);
                        totalUseCnt = totalUseCnt + data[i].USECNT;
                    }
                }
                totalLicenseCnt = data[i].TOTALCNT;
            }
            $('#totalusercnt').text(totalUseCnt);
            $('#totallicensecnt').text(totalLicenseCnt);
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}


function licenseInsertPage(siteId){
    $.ajax({
        url: "/company/license/"+siteId,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            var length = $('input[name*="licenseno"]').length;
            var totalUseCnt = 0;
            var totalLicenseCnt;
            for(var i = 0 ; i < data.length; i++){
                for(var j = 0 ; j< length ; j++){
                    if (data[i].LICENSENO ==$('input[name="useLicenseDtoList['+j+'].licenseno"]').val()){
                        $('[name="useLicenseDtoList['+j+'].isdelete"]').val(data[i].ISDELETE).prop('selected',true);
                        $('[name="useLicenseDtoList['+j+'].licensecnt"]').val(data[i].BUYCNT).prop('selected',true);
                        $('input[name="useLicenseDtoList['+j+'].licenseno"]').parent().find('[name="edtdate"]').text(data[i].EDTDATE);
                        $('input[name="useLicenseDtoList['+j+'].licenseno"]').parent().find('[name="usecnt"]').text(data[i].USECNT);
                        totalUseCnt = totalUseCnt + data[i].USECNT;
                    }
                }
                totalLicenseCnt = data[i].TOTALCNT;
            }
            $('#totalusercnt').text(totalUseCnt);
            $('#totallicensecnt').text(totalLicenseCnt);
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}


