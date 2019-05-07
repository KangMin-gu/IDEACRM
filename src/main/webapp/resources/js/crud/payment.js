$(document).ready(function() {
    var jsTreeOption = {"plugin":['types','dnd','search'], "icon":{'icon': 'fa fa-folder'}};
    jsTree('/company/products' ,jsTreeOption); // 전달

    var mobile1 = opener.$('#mobile1').val();
    var mobile2 = opener.$('#mobile2').val();
    var mobile3 = opener.$('#mobile3').val();
    var homtel1 = opener.$('#homtel1').val();
    var homtel2 = opener.$('#homtel2').val();
    var homtel3 = opener.$('#homtel3').val();
    var email = opener.$('#email').val();
    var homaddr1 = opener.$('#homaddr1').val();
    var homaddr2 = opener.$('#homaddr2').val();
    var homaddr3 = opener.$('#homaddr3').val();
    var custname = opener.$('#custname').val();
    var custno = opener.$('#custno').val();

    var homeaddr = "("+homaddr1+")"+" "+homaddr2+" "+homaddr3;
    var homtel = homtel1+"-"+homtel2+"-"+homtel3;
    var mobile = mobile1+"-"+mobile2+"-"+mobile3;

    $('#buyNametext').text(custname);
    $('#buyTel').text(homtel);
    $('#buyPhone').text(mobile);
    $('#buyAddr').text(homeaddr);
    $('#buyEmailtext').text(email);

    $('#buyTel1').val(homtel1);
    $('#buyTel2').val(homtel2);
    $('#buyTel3').val(homtel3);
    $('#buyPhone1').val(mobile1);
    $('#buyPhone2').val(mobile2);
    $('#buyPhone3').val(mobile3);
    $('#buyAddr1').val(homaddr1);
    $('#buyAddr2').val(homaddr2);
    $('#buyAddr3').val(homaddr3);
    $('#buyName').val(custname);
    $('#buyuserNo').val(custno);
});

$('#sameChk').change(function(){
    if($("#sameChk").is(":checked")){
        $('#deliveryname').val($('#buyName').val());
        $('#deliverytel1').val($('#buyTel1').val());
        $('#deliverytel2').val($('#buyTel2').val());
        $('#deliverytel3').val($('#buyTel3').val());
        $('#deliverymobile1').val($('#buyPhone1').val());
        $('#deliverymobile2').val($('#buyPhone2').val());
        $('#deliverymobile3').val($('#buyPhone3').val());
        $('#deliveryaddr1').val($('#buyAddr1').val());
        $('#deliveryaddr2').val($('#buyAddr2').val());
        $('#deliveryaddr3').val($('#buyAddr3').val());
    }else{
        $('#deliveryname').val("");
        $('#deliverytel1').val('선택');
        $('#deliverytel2').val("");
        $('#deliverytel3').val("");
        $('#deliverymobile1').val('선택');
        $('#deliverymobile2').val("");
        $('#deliverymobile3').val("");
        $('#deliveryaddr1').val("");
        $('#deliveryaddr2').val("");
        $('#deliveryaddr3').val("");
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
                "<input type='hidden' name='price' class='price' value='" + prdpriceVal + "'>" +
                "<td><input type='text' name='qty' id='qty' class='qty' style='width: 50px;'></td>" +
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


$('#orderBtn').click(function(){

    var a = $('#backetList tbody tr').length;

    var b = 0;
    var product = [];

    for(var i = 1; i<=a; i++){
        var dataObj = new Object();
        dataObj.productVal = $('#backetList tbody tr').eq(b).children().eq(4).val();
        dataObj.qty = $('#backetList tbody tr').eq(b).children().eq(3).children().eq(0).val();
        b++;
        product.push(dataObj);
    }

    //dataArr.push(product);

    var delivery = new Object();
    delivery.name = $('#deliveryname').val();
    delivery.tel1 =  $('#deliverytel1').val();
    delivery.tel2 =  $('#deliverytel2').val();
    delivery.tel3 = $('#deliverytel3').val();
    delivery.mobile1 =  $('#deliverymobile1').val();
    delivery.mobile2 =  $('#deliverymobile2').val();
    delivery.mobile3 =  $('#deliverymobile3').val();
    delivery.addr1 =  $('#deliveryaddr1').val();
    delivery.addr2 =  $('#deliveryaddr2').val();
    delivery.addr3 =  $('#deliveryaddr3').val();
    delivery.desc =  $('#deliverydesc').val();

    // dataArr.push(delivery);


    //구매자 userId
    var buyer = $('#buyuserNo').val();
    var totalprice = $('#totalPrice').val();

    //dataArr.push(buyer);
    //받는이 정보
    var order = {product : product, delivery : delivery, buyer: buyer, totalprice : totalprice};
    console.log(JSON.stringify(order));
    $.ajax({
        url: "/order",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(order),
        contentType:'application/json; charset=utf-8',
        success: function (data) {
            //주문완료창 열기
            location.href = "/order/reuslt/"+data;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR+ textStatus+ errorThrown);
            return false;
        }
    });
});






