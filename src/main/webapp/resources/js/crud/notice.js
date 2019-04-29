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
function popNoticeListFormatter(value, options, rowData){
    if(value){  return "<a href='/pop/notice/"+ rowData.NTNUM + "'>" + value + "</a>";  }
    return "";
}
function indexVocNoticeListFormatter(value, options, rowData){
    if(value){  return "<a href='/voc/notice/"+ rowData.VOCNTNUM + "'>" + value + "</a>";  }
    return "";
}
$('#reset').click(function(e){
    $('.searchparam').val('');
});