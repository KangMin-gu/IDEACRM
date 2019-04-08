var globalUrl;
// footable 검색 및 ready상태일때 사용할 수 있게 변경
function footableSearchList(url) {
    var param = searchDataToJson();
    globalUrl = url;
    $.post(url, param, function (response) {
        $('.footable').footable({
            "toggleSelector": ".footable-toggle",
            "paging": {
                "enabled": true,
                "container" : ".pagination"
            },
            "rows": response
        });
    });
}
function popPupFootableSearchList(url) {
    var param = searchDataToJson();
    $.post(url, param, function (response) {
        $('.footable').footable({
            "toggleSelector": ".footable-toggle",
            "paging": {
                "enabled": true,
                "container" : ".pagination"
            },
            "rows": response
        });
    });
}
function tabFootableSearchList(id,url) {
    debugger;
    var param = searchDataToJson();
    $.post(url, param, function (response) {
        debugger;
        $(id).find('.tabfootable').footable({
            "toggleSelector": ".footable-toggle",
            "paging": {
                "enabled": true,
                "container" : ".pagination"
            },
            "rows": response
        });
    });
}
$(".footable").on("click.ft.row",function(obj,e,ft,row){
    if(globalUrl =='/popowner'){
        parentOwnerUser($(obj.target.parentElement));
    }
    if(globalUrl == '/popcust'){
        parentCustname($(obj.target.parentElement));
    }
    if(globalUrl == '/popclient'){
        popParentNameClick($(obj.target.parentElement));
    }


});


// footable에서 click했을때 view화면으로 가기 위한 처리
function formatter(value, options, rowData) {
    return "<a href='" + rowData.URL + "'>" + value + "</a>"
}

// 검색조건들 footable에서 사용하기 위해서 json형태로 변환
function searchDataToJson() {
    var param = {};
    var data = $('.searchparam');
    var dataLength = data.length;

    for (i = 0; i < dataLength; i++) {
        var idVal = data[i].id;
        if (idVal != '') {
            if (idVal.substring(0, 4) == 'deny') { // 수신거부 체크박스 항목일 경우
                if ($('#' + idVal).prop('checked') == true) {
                    param[idVal] = dataata[i].value;//체크 되었으면 값 바인딩
                } else {
                    param[idVal] = 0; // 체크 해제 되었다면 0
                }
            } else {
                param[idVal] = data[i].value;
            }
        }
    }
    return param;
}

// tinymce
if($('.tinymce').length> 0) {
    tinymce.init({
        height : "300",
        language: 'ko_KR',
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
