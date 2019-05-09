$(document).ready(function() {
    $('.downInput').hide();
    $('.grpInput').hide();
    $('#saveBtn').hide();
    $('#deleteBtn').hide();
    $('#resetBtn').hide();
    $('#updateBtn').hide();

    jsTreeLoad();
});
///////버튼제어///////////////
function prdFormReset(){
    $('#j1_1_anchor').trigger('click');
    $('#grpupper').val("");
    $('#grpno option:eq(0)').prop('selected', true);
    resetInput();
};

function resetInput(){
    $('#grpupper').attr("disabled", false);
    $('#grpupper option:eq(0)').prop('selected', true);
    $('#prdvalue').val("");
    $('#erpno').val("");
    $('#prdname').val("");
    $('#prdprice').val("");
    $('#prddesc').val("");
    $('#grpname').val("");
    $('#groupkey').val("");
};

$("#grpno").change(function () {
    var check = $(this).val();
    if(check == 1){
        $('.grpInput').hide();
        $('.downInput').show();
        $('#saveBtn').show();
        resetInput();
        $('#prdno').val('1');
    }else if(check == 0){
        $('.grpInput').show();
        $('.downInput').hide();
        $('#saveBtn').show();
        resetInput();
        $('#prdno').val('0');
    }else{
        $('.downInput').hide();
        $('.grpInput').hide();
        $('#saveBtn').hide();
        resetInput();
        $('#prdno').val('');
    };
});

$('#jstreeSet').on("changed.jstree", function (e, data) {
    resetInput();

    var upperprdnoVal = data.node.original.UPPERPRDNO;
    var prdvalueVal =data.node.original.PRDVALUE;
    var textVal = data.node.original.text;
    var idVal =data.node.original.id;
    var erpnoVal =data.node.original.ERPNO;
    var prdpriceVal = data.node.original.PRDPRICE;
    var prddescVal = data.node.original.PRDDESC;
    var groupkeyVal = data.node.original.id;

    if(upperprdnoVal == 0 ){
        $('.downInput').hide();
        $('.grpInput').hide();
        $('#saveBtn').hide();

        $('#grpname').val(textVal);
        $('#grpno').val(upperprdnoVal);
        $('#groupkey').val(groupkeyVal);
        $('#prdno').val(idVal);
        $('.grpInput').show();
        $('#updateBtn').show();
        $('#deleteBtn').show();
    }else{
        $('.downInput').hide();
        $('.grpInput').hide();
        $('#saveBtn').hide();

        $('#grpno').val("1");
        $('#grpupper').val(upperprdnoVal);
        $('#prdvalue').val(prdvalueVal);
        $('#erpno').val(erpnoVal);
        $('#prdname').val(textVal);
        $('#prdprice').val(prdpriceVal);
        $('#prddesc').val(prddescVal);
        $('#prdno').val(idVal);
        $('#updateBtn').show();
        $('.downInput').show();
        $('#deleteBtn').show();

        $('#grpupper').attr("disabled", true);
    };

    if(prdpriceVal === undefined && upperprdnoVal === undefined){
        $('#saveBtn').hide();
        $('#updateBtn').hide();
        $('#deleteBtn').hide();
        $('.downInput').hide();
        $('.grpInput').hide();
        $('#grpno option:eq(0)').prop('selected', true);
    };

});

function jsTreeLoad(){
    var jsTreeOption = {"plugin":['types','dnd','search'], "icon":{'icon': 'fa fa-folder'}};
    jsTree('/company/products' ,jsTreeOption); // 전달
};

function productDel() {
    var updatePrdno = $('#prdno').val();
    var grpnoValid = $('#grpno').val();
    var jsonData = {prdno : updatePrdno, grpno : grpnoValid};
    if(grpnoValid != 0){
        delAjax(jsonData);
    }else{
        var valid = confirm("하위 값을 포함하여 전부 삭제됩니다. 삭제하시겠습니까?");
        if(!valid){
            return false;
        }else{
            delAjax(jsonData);
        }
    }
}

function delAjax(jsonData) {
    $.ajax({
        url:'/company/product/del',
        method:'POST',
        data:JSON.stringify(jsonData),


        success: function (data) {
            alert("삭제되었습니다.");
            location.reload();
        }
    });
}

function productUpdate(){
    var grpnoValid = $('#grpno').val();
    var prdnameVal = $('#prdname').val();
    var grpnameVal = $('#grpname').val();


    if(grpnoValid == 0){
        if(grpnameVal == ""){
            alert("그룹명을 입력해주세요.");
            return false;
        }else{
            updateAjax();
        }
    }else{
        if(prdnameVal == ""){
            alert("제품명을 입력해주세요.");
            return false;
        }else{
            updateAjax();
        }
    }

}

function updateAjax(){

    var prdvalueVal = $('#prdvalue').val();
    var erpnoVal = $('#erpno').val();
    var prdnameVal = $('#prdname').val();
    var prdpriceVal = $('#prdprice').val();
    var prddescVal = $('#prddesc').val();
    var prdnoVal = $('#prdno').val();
    var grpnameVal = $('#grpname').val();

    var jsonUpdateData = {prdno : prdnoVal, erpno : erpnoVal, prdname : prdnameVal, prdvalue:prdvalueVal, prdprice:prdpriceVal, prddesc:prddescVal, grpname: grpnameVal};

    $.ajax({
        url:'/company/product/modified',
        method:'POST',
        data:JSON.stringify(jsonUpdateData),
        contentType:"application/json",
        success: function (data) {
            alert("수정되었습니다.");
            location.reload();
        }
    });
}

$('#productForm').submit(function(){

    var grpnoValid = $('#grpno').val();

    if(grpnoValid != 0){

        if($('#grpupper').val() == '선택'){
          alert("그룹명을 선택하지 않았습니다.");
          return false;
        }else if($("#prdname").val() == ""){
            alert("제품명을 입력해주세요.");
            return false;
        }else if($('#prdprice').val() == ""){
            alert("제품가격을 입력해주세요.");
            return false;
        }

    }else{
        if($('#grpname').val() == ""){
            alert("그룹명을 입력해주세요.");
            return false;
        }
    }
});



//--------------기존 product 함수 추가 ---------------------------------------------

//제품 추가를 눌렀을때
$(document).on('click', '.plus', function(e) {
    debugger;
    var productLength = $('.product').length;
    if(productLength > 9){
        alert('제품은 9개 이상 등록할수 없습니다');
        $('.product:last').remove();
    }else{
        var productId = $(e.target).parent().prev().children().attr('id');

        if(productId != undefined){
            var productNum = productId.substring(7, 8);
            productPlus(parseInt(productNum));
        }else{
            productId = $(e.target).parent().children().children().attr('id');
            var productNum = productId.substring(7, 8);
            productPlus(parseInt(productNum));
        }
    }
});
// 제품 삭제를 눌렀을때
$(document).on('click','.minus',function(e) {
    var productLength = $('.product').length;
    var selectId = $(e.target).parent().find('select:last').attr('id');
    var lastId = $('.product:last select:last').attr('id');
    if(selectId == lastId){
        $(e.target).parent().prev().find('select:last').parent().after('<div style="display: inline-block"><button type="button" style="margin-bottom: 5px;margin-left: 10px;" class="btn btn-default plus">추가</button></div>');
    }

    //$(e.target).parent().prev().find('select:last').after('<button class="plus btn btn-primary d-inline-block btn-sm mr-2">추가</button>');
    $(e.target).parent().remove();
});
// 최근 한건을 가져올때 제품의 갯수를 늘려줌
function productPlus(length) {
    var countP = length + 1;
    var flag = window.location.pathname.indexOf('pop');
    // 팝업인지 아닌지 비교해서 팝업인경우에는 opener를 늘려주고 아니면 본인을 늘려줌
    if (flag == -1) {
        $('.product:last').clone(true).insertAfter('.product:last');
        $('.product:last').find('#product' + length + 1).attr('name',
            'product' + countP + 1).attr('id', 'product' + countP + 1);
        $('.product:last').find('#product' + length + 2).attr('name',
            'product' + countP + 2).attr('id', 'product' + countP + 2);
        $('.product:last').find('#product' + length + 3).attr('name',
            'product' + countP + 3).attr('id', 'product' + countP + 3);
        $('.product:last').prev().find('.plus').remove();
        // 첫번째 인경우에는 삭제버튼만 있으면 되기 떄문
        if (length == 1) {
            $('.product:last').append('<button style="margin-bottom: 5px;margin-left: 5px" class="minus btn btn-default mr-2">삭제</button>');
        }
    } else {
        opener.$('.product:last').clone(true).insertAfter('.product:last');
        opener.$('.product:last').find('#product' + length + 1).attr('name',
            'product' + countP + 1).attr('id', 'product' + countP + 1);
        opener.$('.product:last').find('#product' + length + 2).attr('name',
            'product' + countP + 2).attr('id', 'product' + countP + 2);
        opener.$('.product:last').find('#product' + length + 3).attr('name',
            'product' + countP + 3).attr('id', 'product' + countP + 3);
        opener.$('.product:last').prev().find('.plus').remove();
    }
}

$('[name*=product]').change(function(){
    upperProduct(this);
});

// 상위 코드 받아서 하위코드 매핑하기
function upperProduct(product){
    debugger;
    var productNo = $(product).val();
    var nextId = 'product' + parseInt(parseInt(product.id.substring(7)) + 1);
    if(productNo == ""){
        $('#'+nextId).children().remove();
    }else {
        var url = "/product/upper/" + productNo;

        $.ajax({
            url: url,
            method: "GET",
            dataType: "json",
            cache: false,
            success: function (data) {
                var text = "";
                $('#' + nextId).find('option').remove();
                $('#' + nextId).append('<option label="선택" value="0"/>');
                for (i = 0; i < data.length; i++) {
                    text = '<option label="' + data[i].prdname + '" value="' + data[i].prdno + '"/>';
                    $('#' + nextId).append(text);
                }
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    }
}