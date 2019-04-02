// footable 관련 함수들
if($('.footable').length > 0) {
// footable 검색 및 ready상태일때 사용할 수 있게 변경
    function footableSearchList(url) {
        var param = searchDataToJson();
        $.post(url, param, function (response) {
            $('.footable').footable({
                "toggleSelector": ".footable-toggle",
                "paging": {
                    "enabled": true
                },
                "rows": response
            });
        });
    }

// footable에서 click했을때 view화면으로 가기 위한 처리
    function formatter(value, options, rowData) {
        return "<a href='" + rowData.URL + "'>" + value + "</a>"
    }

// 검색조건들 footable에서 사용하기 위해서 json형태로 변환
    function searchDataToJson() {
        var param = {};
        var data = $('.searchparam');
        var dataLength = data.length;

        for (i = 0; i < dataLength; i++) {
            var idVal = data[i].id;
            if (idVal != '') {
                if (idVal.substring(0, 4) == 'deny') { // 수신거부 체크박스 항목일 경우
                    if ($('#' + idVal).prop('checked') == true) {
                        param[idVal] = dataata[i].value;//체크 되었으면 값 바인딩
                    } else {
                        param[idVal] = 0; // 체크 해제 되었다면 0
                    }
                } else {
                    param[idVal] = data[i].value;
                }
            }
        }
        return param;
    }
}

// daterange 호출
if($('.daterange').length > 0){
    $('.daterange').daterangepicker({
        format: 'YYYY-MM-DD',
        separator:' ~ '
    });
}


