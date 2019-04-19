

$('.servicecust').click(function(e){
    if( e.target.classList.contains('dataCancle') == false ){
        openNewWindow('고객','/popservicecust',e.currentTarget.id,650,700);
    }
});

$('#servicecode1').change(function(){
    upperCode('servicecode1');
});

// 단계에 따른 화면처리
function serviceStep(){
    var step = $('#servicestep').val();
    if(step == 3){
        tinyMCE.EditorManager.editors[0].setMode('readonly');
        $('.reward').prop("disabled",true);
        $('.reward').iCheck('disable');
    }else if(step == 5 || step == 6){
        tinyMCE.EditorManager.editors[0].setMode('readonly');
        $('.reward').prop("disabled",true);
        $('.reward').iCheck('disable');
    }
    var sessionId = $('#sessionId').val();
    var owner = $('#owner').val();
    if(sessionId != owner ){
        tinyMCE.EditorManager.editors[2].setMode('readonly');
        $('.ract').prop("disabled",true);
    }
}

$('.servicenext').click(function(e){
    var name = '담당자이관'
    var id = $('#serviceno').val();
    var url = '/popservicedelivery/'+id;
    var x = '1232';
    var y = '500';

    openNewWindow(name,url,e,x,y);
});

// 이관 팝업에서 저장버튼 눌렀을때 동작
$('#conveySave').click(function(e){
    var	url= "/service/delivery";
    /*
    var serviceno = $('#serviceno').val();
    var conveydate= $("#conveydate").val();
    var conveyreason = $("#conveyreason").val();
    var nextowner = $("#nextowner").val();
    var conveydesc = $('#conveydesc').val();
    var param = {"serviceno":serviceno,"conveydate":conveydate,"conveyreason":conveyreason,"nextowner":nextowner,"conveydesc":conveydesc};
    */
    param = searchDataToJson();
    $.ajax({
        url: url,
        method: "POST",
        dataType: "json",
        data:param,
        success: function () {
            alert('이관되엇습니다');
            opener.location.reload();
            self.close();
            window.opener.location.reload();
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });

});

function moveDetail(){
    var serviceNo = $('#serviceno').val();
    var href = "/service/" + serviceNo;

    opener.window.location.href = href;
    self.close();
}

function ractPop(ractNo){
    var name = '처리 내용';
    var url = '/popserviceract/'+ractNo;
    var x = '1000';
    var y = '500';
    var e ='';
    openNewWindow(name,url,e,x,y);
}


// footable에서 click했을때 view화면으로 가기 위한 처리
function ractFormatter(value, options, rowData) {
    return "<a href=javascript:ractPop("+rowData.RACTNO +")>"+ value + "</a>";
}

$(".footable").on("click.ft.row",function(obj,e,ft,row){
    var url = window.location.pathname;
    if(url =='/popservicecust'){
        parentCustname($(obj.target.parentElement));
    }
});
// 고객 팝업 클릭
function parentCustname(tr){
    var parentid = $('#parentid').val();
    opener.$('[name="'+parentid+'"]').next().val(tr.children().get(0).textContent);
    opener.$('[name="'+parentid+'"]').val(tr.children().get(1).textContent).trigger('keyup');
    if(parentid != "relcustname"){//관련 고객에서의 호출이 아니라면 아래행 실행
        popCustClick(tr.children().get(0).textContent);
    }

    setTimeout(function(){
        window.close();
    },300);
}

