function noticeListFormatter(value, options, rowData){
    if(value){  return "<a href='/company/notice/"+ rowData.NTNUM + "'>" + value + "</a>";  }
    return "";
}

$('#reset').click(function(e){
    $('.searchparam').val('');
});