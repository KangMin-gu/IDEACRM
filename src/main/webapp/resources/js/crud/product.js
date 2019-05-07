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
        }

    }else{
        if($('#grpname').val() == ""){
            alert("그룹명을 입력해주세요.");
            return false;
        }
    }
});

