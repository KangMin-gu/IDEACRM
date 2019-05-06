$(document).ready(function() {
    var jsTreeOption = {"plugin":['types','dnd','search'], "icon":{'icon': 'fa fa-folder'}};
    jsTree('/company/products' ,jsTreeOption); //전달*/

});

$('#sameChk').change(function(){
    if($("#sameChk").is(":checked")){

    }else{

    }
});


$('#jstreeSet').on("changed.jstree", function (e, data) {
        //로드될때마다 data 바인딩되기전에 읽혀짐으로 if 로 바인딩안되게 처리
        if (data.node != null) {
            var upperprdnoVal = data.node.original.UPPERPRDNO;
            var prdvalueVal = data.node.original.PRDVALUE;
            var textVal = data.node.original.text;
            var idVal = data.node.original.id;
            var erpnoVal = data.node.original.ERPNO;
            var prdpriceVal = data.node.original.PRDPRICE;
            var prddescVal = data.node.original.PRDDESC;
            var groupkeyVal = data.node.original.id;
        }

//장바구니담기
        if(upperprdnoVal != 0 && typeof upperprdnoVal != "undefined" && upperprdnoVal != "") {

            html = "<tr>" +
                "<td>" + textVal + "</td>" +
                "<td>" + prdpriceVal + "</td>" +
                "<td><input type='hidden' name='qty' class='qty' value='" + prdpriceVal + "'></td>" +
                "<td><input type='text' name='price' class='price' style='width: 50px;'></td>" +
                "<input type='hidden' class='productVal' name='productVal' id='productVal' value='" + idVal + "'>" +
                "<td><input type='hidden' name='sumPrice' class='sumPrice'></td>" +
                "<td><button onclick='delProduct(" + idVal + ")' class='btn btn-sm btn-warning delRow'>" + "삭제" + "</button></td>" +
                "</tr>";
            $('#productBacketList').append(html);


            js();

        }
//계산

        $('.price').keyup(function () {
            var num = $(".price").index(this);
            $('.sumPrice').eq(num).val($('.price').eq(num).val() * $('.qty').eq(num).val());
        });
        $('.qty').keyup(function () {
            var num = $(".qty").index(this);
            $('.sumPrice').eq(num).val($('.price').eq(num).val() * $('.qty').eq(num).val());
        });
        $('.sumPrice').keyup(function () {
            var num = $(".sumPrice").index(this);
            $('.sumPrice').eq(num).val($('.price').eq(num).val() * $('.qty').eq(num).val());

        });

        $('.delRow').click(function () {
            $(this).parent().parent().remove();
            delProduct(data);
        });

        $('.price, .qty').keyup(function () {

            var appPays = [];
            var result = 0;
            $("input[name='sumPrice']").each(function (i) {
                appPays.push($(this).val());
            });

            for (var i = 0; i < appPays.length; i++) {
                result += parseInt(appPays[i]);
            }

            if (isNaN(result)) {
                var num = $("#payPrice").index(this);
                $('#payPrice').eq(num).text();
                $('#totalPrice').eq(num).val('');
            } else {
                var num = $("#payPrice").index(this);
                $('#payPrice').eq(num).text(result);
                $('#totalPrice').eq(num).val(result);
            }

        });

});

//제품 눌를때마다 빼기
function js() {

    var checkArr=[]

    $("input[name='productVal']").each(function(i){
        checkArr.push($(this).val());
    });

    var allData = {"checkArr": checkArr };

    $.ajax({
        url:"/productbacketlist",
        type:'GET',
        data: allData,
        success:function(data){
            $('#jstreeSet').jstree(true).settings.core.data = data;
            $('#jstreeSet').jstree(true).refresh();
        },
        error:function(jqXHR, textStatus, errorThrown){
            alert("에러발생");
            return false;
        }
    });
}

function delProduct(data){

    var checkArr=[]
    $("input[name='productVal']").each(function(i){
        checkArr.push($(this).val());
    });
    var allData = {"checkArr": checkArr };
    if (data.node != null) {
        $.ajax({
            url: "/productbacketlist",
            type: 'GET',
            data: allData,
            success: function (data) {
                $('#jstreeSet').jstree(true).settings.core.data = data;
                $('#jstreeSet').jstree(true).refresh();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR+ textStatus+ errorThrown);
                return false;
            }
        });
    }
}







