var globalUrl;
//  footable 검색 및 ready상태일때 사용할 수 있게 변경
function footableSearchList(url, selector) {
    var param = searchDataToJson();
    $.post(url, param, function (response) {
        selector.footable({
            "toggleSelector": ".footable-toggle",
            "filtering": {
                "enabled": true,
                "placeholder": "통합검색",
                // "delay": 500,
                "min":1,
                "dropdownTitle": "Search in:"
            },
            "paging": {
                "enabled": true,
                "container" : selector.find('.pagination'),
                "position":"center"
            },
            "sorting": {
                "enabled": true
            },
            "rows": response
           // "columns":columns
        });
    });
}

function tabFootableSearchList(id,url) {
    var param = searchDataToJson();
    var page = $('#paging').val();
    if(page == undefined){
        page = 5;
    }
    var pagination = $(id).find('.pagination');
    $.post(url, param, function (response) {
        $(id).find('.tabfootable').footable({
            "toggleSelector": ".footable-toggle",
            "empty": "",
            "filtering": {
                "enabled": true,
                "placeholder": "통합검색",
                // "delay": 500,
                "min":1,
            },
            "paging": {
                "enabled": true,
                "container" : pagination,
                "size":page
            },
            "sorting": {
                "enabled": true
            },
            "rows": response
        });
        // pagination이 반복해서 생겨서 무조건 한개를 지우게 처리함.
        $('.footable-pagination-wrapper:eq(0)').remove();
        $('.footable-empty').remove();
    });
};
$(".footable").on("click.ft.row",function(obj,e,ft,row){
    globalUrl = window.location.pathname;
    if($(obj.target.parentElement.parentElement).is('tbody')){
        if(globalUrl =='/popuser'){
            popParentNameClick($(obj.target.parentElement));
        }
        else if(globalUrl == '/popcust'){
            popParentNameClick($(obj.target.parentElement));
        }
        else if(globalUrl == '/popaccount'){
            popParentNameClick($(obj.target.parentElement));
        }
        else if(globalUrl == '/voc/pop/custsearch'){
            popVocCustNameClick($(obj.target.parentElement));
        }
    }
});

// footable이 실행되고 나서 검색창의 지저분한 button 삭제
$(".footable").on("ready.ft.table",function(obj,e,ft,row){
    $('.input-group-btn').find('button').remove();
    $('.footable-pagination-wrapper > .label-default').hide();

    if ( $('.footable tbody tr').hasClass('footable-empty') ){ //출력 건수가 없다면 삭제
        $('.footable tbody tr').remove();
    }
});
$(".tabfootable").on("ready.ft.table",function(obj,e,ft,row){
    $('.input-group-btn').find('button').remove();
    $('.footable-pagination-wrapper > .label-default').hide();

    if ( $('.tabfootable tbody tr').hasClass('footable-empty') ){ //출력 건수가 없다면 삭제
        $('.tabfootable tbody tr').remove();
    }
});


// footable에서 click했을때 view화면으로 가기 위한 처리
function formatter(value, options, rowData) {
    return "<a href='" + rowData.URL+rowData.NO + "'>" + value + "</a>"
}



// tinymce
if($('.tinymce').length> 0) {
    tinymce.init({
        height : "300",
        language: 'ko_KR',
        plugins: "paste",
        //language_url : '/resources/tinymce/langs/ko_KR.js',
        selector: '.tinymce',  // change this value according to your HTML
        toolbar: 'insertfile undo redo | fontselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link imageupload | print preview media fullpage | forecolor backcolor emoticons',
        font_formats: "맑은고딕='맑은고딕';굴림=굴림;돋음=돋음;바탕=바탕;궁서=궁서;Arial=Arial;Times=Times;Verdana=Verdana;Andale Mono=andale mono,times;Arial=arial,helvetica,sans-serif;Arial Black=arial black,avant garde;Book Antiqua=book antiqua,palatino;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Georgia=georgia,palatino;Helvetica=helvetica;Impact=impact,chicago;Symbol=symbol;Tahoma=tahoma,arial,helvetica,sans-serif;Terminal=terminal,monaco;Times New Roman=times new roman,times;Trebuchet MS=trebuchet ms,geneva;Verdana=verdana,geneva;Webdings=webdings;Wingdings=wingdings,zapf dingbats",
        setup: function(editor) {
            if ($('#'+editor.id).prop('readonly')) {
                editor.settings.readonly = true;
            }
            // create input and insert in the DOM
            var inp = $('<input id="tinymce-uploader" type="file" name="pic" accept="image/*" style="display:none">');
            $(editor.getElement()).parent().append(inp);

            // add the image upload button to the editor toolbar
            editor.addButton('imageupload', {
                icon: 'image',
                onclick: function(e) { // when toolbar button is clicked, open file select modal
                    inp.trigger('click');
                }
            });

            // when a file is selected, upload it to the server
            inp.on("change", function(e){
                minymceUploadFile($(this), editor);
            });
        }
    });

// tinymce4 이미지 업로드
    function minymceUploadFile(inp, editor) {
        var input = inp.get(0);
        var data = new FormData();
        data.append('files', input.files[0]);

        $.ajax({
            url: '/tinyMCE',
            type: 'POST',
            data: data,
            cache:false,
            enctype: 'multipart/form-data',
            dataType : 'json',
            processData: false, // Don't process the files
            contentType: false, // Set content type to false as jQuery will tell the server its a query string request
            success: function(data, textStatus, jqXHR) {
                editor.insertContent('<img class="content-img" src="' + data.location + '" data-mce-src="' + data.location + '" />');
            },
            error: function(jqXHR, textStatus, errorThrown) {
                if(jqXHR.responseText) {
                    errors = JSON.parse(jqXHR.responseText).errors
                    alert('Error uploading image: ' + errors.join(", ") + '. Make sure the file is an image and has extension jpg/jpeg/png.');
                }
            }
        });
    }
}


$(document).ready(function() {
// daterange 호출
if($('.daterange').length > 0){
    $('.daterange').daterangepicker({
        format: 'YYYY-MM-DD',
        separator:' ~ '
    });
}
// i-check
if($('.i-checks').length > 0){
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
}
// datepicker
if($('.date').length > 0){
    $('.date').datepicker({
        keyboardNavigation:false,
        forceParse:false,
        autoclose:true
    });
}
});
//daumApi 사용
$('.daumzip').click(function(e){ //이벤트를 걸 인풋,버튼에 daumzip 클래스 추가
    e.preventDefault();
    new daum.Postcode({
        oncomplete: function(data) {
            var clickId = e.currentTarget.id;//클릭한 id값 을 받아온다\
            if(clickId ==''){
                clickId = e.target.id;
            }
            var head = clickId.substr(0,clickId.indexOf('addr'));//id의 헤더만 잘라낸다. ex)homaddr1-> hom
            //addr1 : 우편번호 , addr2 : 도로명 , addr3 : 건물명 +사용자입력  
            $("#"+head+"addr1").val(data.zonecode);
            $("#"+head+"addr2").val(data.roadAddress);
            $("#"+head+"addr3").val(data.buildingName);
        }
    }).open();
});


function iCheckClick(bool){
    $('.icheckbox_square-green input[type="checkbox"]').each(function(index,item){
        var checkVal = $(item).val();
        if(checkVal == 1){
            $(item).iCheck('check');
        }
        if(bool){
            //true로 들어오면 Read 화면처럼 데이터 변경이 안되게 막음.
            $(item).attr('disabled',bool);
            $(item).parent().addClass('disabled');
        }

    });
}

$('.icheckbox_square-green input[type="checkbox"]').on('ifChecked', function(e){
    if(e.target.id != undefined && e.target.id != '' ){
        if ( $('#'+e.target.id).prop('checked') == true ) {//icheck 선택 시 value를 1로 설정.
            $('#'+e.target.id).val(1);
        }
    }
});



//     jTree
function jsTree(url, jsTreeOption) {
    $('#jstreeSet').jstree({
       'core' : {
            'data' : {
                "url" : url,
                "dataType" : "json",
                "data" : function (nodes, cb) {
                }
            }
        },
        'plugins':jsTreeOption.plugin,
        'types':{
            'default': jsTreeOption.icon
        }
    });
    $("#jsTreeForm").submit(function(e) {
        e.preventDefault();
        $('#jstreeSet').jstree(true).search($("#jsTreeVal").val());
    });
}
