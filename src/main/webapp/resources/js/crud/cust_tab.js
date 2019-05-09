
function callbackHistFormatter(value, options, rowData){
    if( !rowData.REQNO == false ){
        return '<a onclick="goPlay('+"'"+rowData.RECDATE_+"'"+','+"'"+rowData.RECEXT+"'"+','+"'"+rowData.RECFILENAME+"'"+');"><i class="fa fa-play-circle" style="font-size:17px;"></i></a>';
    }
    return "";
}

function vocSvTabFormatter(value, options, rowData){
    var htmlStr = '<a href="#" onclick="serviceDetailPop(' + "'" + rowData.NO + "'" + ');">' + value + '</a>';
    return htmlStr;
}
function vocEmailTabformatter(value, options, rowData){
    // var htmlStr = '<a href="#" data-toggle="tooltip" title="'+ rowData.CONTENT +'">' + value + '</a>';
    var htmlStr = '<span data-toggle="tooltip" title="'+ rowData.CONTENT +'">' + value + '</span>';
    return htmlStr;
}
function vocBlackFormatter(value, options, rowData){
    // var htmlStr = '<a href="#" data-toggle="tooltip" title="'+ rowData.MEMO +'">' + value + '</a>';
    var htmlStr = '<span data-toggle="tooltip" title="'+ rowData.MEMO +'">' + value + '</span>';
    return htmlStr;
}
function vocSmsFormatter(value, options, rowData){
    //var htmlStr = '<a href="#" data-toggle="tooltip" title="'+ rowData.TR_MSG +'">' + value + '</a>';
    var htmlStr = '<span data-toggle="tooltip" title="'+ rowData.TR_MSG +'">' + value + '</span>';
    return htmlStr;
}

function vocLmsFormatter(value, options, rowData){
    // var htmlStr = '<a href="#" data-toggle="tooltip" title="'+ rowData.MSG +'">' + value + '</a>';
    var htmlStr = '<span data-toggle="tooltip" title="'+ rowData.MSG +'">' + value + '</span>';
    return htmlStr;
}
function vocMmsFormatter(value, options, rowData){
    // var htmlStr = '<a href="#" data-toggle="tooltip" title="'+ rowData.MSG +'">' + value + '</a>';
    var htmlStr = '<span data-toggle="tooltip" title="'+ rowData.MSG +'">' + value + '</span>';
    return htmlStr;
}
function vocKakaoFormatter(value, options, rowData){
    var htmlStr = '<span data-toggle="tooltip" title="'+ rowData.SEND_MESSAGE +'">' + value + '</span>';
    // var htmlStr = '<a href="#" data-toggle="tooltip" title="'+ rowData.SEND_MESSAGE +'">' + value + '</a>';
    return htmlStr;
}

//고객 관련 Tab클릭 이벤트
$('.vocTabDetail').find('.nav-link').click(function(e){
    var obj = $(this);
    var bool = boolTimeDiff(obj);//동일 버튼 클릭 시간이 3초 미만이면 false 리턴
    if(bool == false){ return; }

    var custno = $('#custno').val();
    if( !custno == false ){
        // click 탭의 href의 값을 가지고 온다.
        var href = e.target.attributes.href.value;
        // href의 tabpanel에 footable에 사용할 url을 가지고 온다.
        var url = $(href).attr('url');
        if(url != undefined){
            vocTabFootableSearchList(href,url);
        }
    }
});

function vocTabFootableSearchList(id,url) {
    var param = searchDataToJson();
    var page = $('#paging').val();
    if(page == undefined){  page = 5; }
    if( window.location.pathname == '/voc' && id != '#callbackBottomTab' ){
        if( !$('#custno').val() ) return;//voc에서는 custno가 없다면 아래행 실행 x
    }
    var pagination = $(id).find('.pagination');
    $.post(url, param, function (response) {
        $(id).find('.vocfootable').footable({
            "toggleSelector": ".footable-toggle",
            "empty": "",
            "filtering": {
                "enabled": true,
                "placeholder": "통합검색",
                "delay": 300,
                "min":1,
            },
            "paging": {
                "enabled": true,
                "container" : pagination,
                "size":page
            },
            "rows": response
        });
        // pagination이 반복해서 생겨서 무조건 한개를 지우게 처리함.
        $('.footable-pagination-wrapper:eq(0)').remove();
        $('.footable-empty').remove();
    });
};

$(".vocfootable").on("ready.ft.table",function(obj,e,ft,row){
    $('.input-group-btn').find('button').remove();
    $('.footable-pagination-wrapper > .label-default').hide();

    if ( $('.vocfootable tbody tr').hasClass('footable-empty') ){ //출력 건수가 없다면 삭제
        $('.vocfootable tbody tr').remove();
    }
});

function serviceDetailPop(serviceno){
    openNewWindow('service','/service/'+serviceno,'voc',1200,700);
}
