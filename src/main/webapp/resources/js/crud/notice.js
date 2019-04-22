function noticeListFormatter(value, options, rowData){
    if(value){  return "<a href='/notice/"+ rowData.NTNUM + "'>" + value + "</a>";  }
    return "";
}
function siteNoticeListFormatter(value, options, rowData){
    if(value){  return "<a href='/company/notice/"+ rowData.NTNUM + "'>" + value + "</a>";  }
    return "";
}
function vocNoticeListFormatter(value, options, rowData){
    if(value){  return "<a href='/voc/notice/"+ rowData.NTNUM + "'>" + value + "</a>";  }
    return "";
}

$('#reset').click(function(e){
    $('.searchparam').val('');
});