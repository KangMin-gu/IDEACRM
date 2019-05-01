
function smsFormat(value, options, rowData){
    var format = rowData.FORMATDESC
    if(value){
        var b = "<a href='#' onclick=smsFormatBind('"+rowData.FORMATNO+"') >" + value + "</a>";
        return b;
    }
};
function emailFormat(value, options, rowData){
    if(value){
        var b = "<a href='#' onclick=emailFormatBind('"+rowData.FORMATNO+"') >" + value + "</a>";
        return b;
    }
};
function smsFormatBind(formatNum){
    var valid =confirm("확인을 눌르시면 기존에 작성하신 글이 모두 지워집니다.");
    if(valid){
        var allData = {"formatnum": formatNum };
        $.ajax({
            url:"/formatdesc",
            type:'GET',
            data:allData,
            success:function(data){
                $('#senddesc').text();
                $('#senddesc').text(data.FORMATDESC);
                $('#senddesc').focus();
            },
            error:function(jqXHR, textStatus, errorThrown){
                alert("서식을 불러오지 못했습니다. 오류가 지속된다면 관리자에게 문의해주세요.");
            }
        });
    }
}


function emailFormatBind(formatNum){
    var valid =confirm("확인을 눌르시면 기존에 작성하신 글이 모두 지워집니다.");
    if(valid){
        var allData = {"formatnum": formatNum };
        $.ajax({
            url:"/formatdesc",
            type:'GET',
            data:allData,
            success:function(data){
                console.log(data.FORMATDESC);
                tinyMCE.activeEditor.setContent(data.FORMATDESC);
            },
            error:function(jqXHR, textStatus, errorThrown){
                alert("서식을 불러오지 못했습니다. 오류가 지속된다면 관리자에게 문의해주세요.");
            }
        });
    }
}

