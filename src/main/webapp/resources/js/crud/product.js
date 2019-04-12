
//제품 추가를 눌렀을때
$(document).on('click', '.plus', function(e) {
    var productLength = $('.product').length;
    if(productLength > 9){
        alert('제품은 9개 이상 등록할수 없습니다');
        $('.product:last').remove();
    }else{
        var productId = $(e.target).parent().prev().children().attr('id');
        if(productId != undefined){
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
        $(e.target).parent().prev().find('select:last').parent().after('<div style="display: inline-block"><button type="button" class="btn btn-default plus">추가</button></div>');
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
            $('.product:last').append('<button class="minus btn btn-primary d-inline-block btn-sm mr-2">삭제</button>');
        }
    } else {
        opener.$('.product:last').clone(true).insertAfter(
            '.select-area .select-box:last');
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
    var productNo = $(product).val();
    var url = "/product/upper/"+productNo;
    var nextId = 'product'+ parseInt(parseInt(product.id.substring(7))+1);
    $.ajax({
        url: url,
        method: "GET",
        dataType: "json",
        cache: false,
        success: function (data) {
            var text = "";
            $('#'+nextId).find('option').remove();
            $('#'+nextId).append('<option label="선택" value="0"/>');
            for(i=0;i<data.length;i++){
                text = '<option label="'+data[i].prdname+'" value="'+data[i].prdno+'"/>';
                $('#'+nextId).append(text);
            }
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}