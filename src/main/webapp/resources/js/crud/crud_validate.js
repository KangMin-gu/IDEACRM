//정규표현 패턴
var emailPattern  = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
var passPattern = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{8,15}$/;
var percentPattern = /^[0-9]{1}$|^[1-9]{1}[0-9]{1}$|^100$/; // -> 0~100 정수.
var urlPattern = /^[^((http(s?))\:\/\/)]([0-9a-zA-Z\-]+\.)+[a-zA-Z]{2,6}(\:[0-9]+)?(\/\S*)?$/; //-> www.crudsystem.co.kr

//메서드추가
$.validator.addMethod("url", function(value,element) {
    return this.optional(element) || /^[^((http(s?))\:\/\/)]([0-9a-zA-Z\-]+\.)+[a-zA-Z]{2,6}(\:[0-9]+)?(\/\S*)?$/.test(value);
},"URL을 올바로 입력해 주세요.(http://, https:// 문구 제외)");

$.validator.addMethod( "notEqualTo", function( value, element, param ) {
    return this.optional( element ) || !$.validator.methods.equalTo.call( this, value, element, param );
}, "동일한 담당자에게 이관할 수 없습니다." );

jQuery.validator.addMethod("testphone",
    function(value, element, param) {
        var boolean = true;
        for (i = 0; i < $(param).length; i++) {
            if ("" == $.trim($(param).eq(i).val())) {
                boolean = false;
            }
        }
        return this.optional(element) || boolean;
    },
    "전화번호 3자리를 모두 입력해주세요"
);

jQuery.validator.addMethod("bsno",
    function(value, element, param) {
        var boolean = true;
        for (i = 0; i < $(param).length; i++) {
            if ("" == $.trim($(param).eq(i).val())) {
                boolean = false;
            }
        }
        return this.optional(element) || boolean;
    },
    "사업자등록번호 3자리를 모두 입력해주세요"
);

jQuery.validator.addMethod("incno",
    function(value, element, param) {
        var boolean = true;
        for (i = 0; i < $(param).length; i++) {
            if ("" == $.trim($(param).eq(i).val())) {
                boolean = false;
            }
        }
        return this.optional(element) || boolean;
    },
    "법인번호 2자리를 모두 입력해주세요"
);




$.validator.addMethod(
    "testconnect",
    function (value, element) {
        if(value != "") {
            return true;
        } else {
            return false;
        }
    },
    "값이 없습니다!."
);

//클래스 규칙 추가 - 아래 name 룰과는 별계로 작동함
$.validator.addClassRules("connect",{required:false,"testconnect":true});
$.validator.addClassRules("test",{required: true, minlength: 2});
$.validator.addClassRules("req-phone",{required: true, minlength: 3, maxlength:4});
$.validator.addClassRules("phone",{minlength: 3, maxlength:4});
$.validator.addClassRules("url",{required:false, url: true});
$.validator.addClassRules("name",{required: true, minlength: 2, maxlength:20});
$.validator.addClassRules("password",{required: true, minlength: 8});
$.validator.addClassRules("confirmpassword",{required: true, minlength: 8, equalTo: ".password"});
$.validator.addClassRules("testphone",{minlength: 3, maxlength:4,testphone:".testphone" });
$.validator.addClassRules("incno",{incno:".incno"});
$.validator.addClassRules("bsno",{bsno:".bsno"});
$.validator.addClassRules("usercheck",{required:true,notEqualTo:"#prevowner"});
$.validator.addClassRules("adminemail",{email:true,required:true});

//$.validator.addClassRules("notequal",{required: true, notEqualTo:"대상"});


//한글 메시지 변경
jQuery.extend(jQuery.validator.messages, {
    required: "반드시 입력해야 합니다.",
   // remote: "수정 바랍니다.",
    email: "이메일 주소를 올바로 입력하세요.",
    url: "URL을 올바로 입력해 주세요.(http://, https:// 문구 제외)",
    date: "날짜가 잘못 입력됐습니다.",
    dateISO: "ISO 형식에 맞는 날짜로 입력하세요.",
    number: "숫자만 입력하세요.",
    digits: "숫자(digits)만 입력하세요.",
    creditcard: "올바른 신용카드 번호를 입력하세요.",
    equalTo: "값이 서로 다릅니다.",
    accept: "승낙해 주세요.",
    maxlength: jQuery.validator.format("{0}글자 이상은 입력할 수 없습니다."),
    minlength: jQuery.validator.format("{0}글자 이상 입력해야 합니다."),
    rangelength: jQuery.validator.format("{0}글자 이상 {1}글자 이하로 입력해 주세요."),
    range: jQuery.validator.format("{0}에서 {1} 사이의 값을 입력하세요."),
    max: jQuery.validator.format("{0} 이하로 입력해 주세요."),
    min: jQuery.validator.format("{0} 이상으로 입력해 주세요.")
});


validator = $("#command").validate({
    ignore: ".ignore",
     invalidHandler:function(event, validator){//실패시 실행 메서드
        alert('입력값을 확인해 주세요');
     },
    rules: {//name에 설정 된 룰들
        name: {
            required: true,
            minlength:2,
            maxlength:20
        },
        password: {
            required: true,
            minlength: 8
        },
        confirm_password: {
            required: true,
            minlength: 8,
            equalTo: "#password"
        },
        email: {
            email: true
        },
        topic: {
            required: "#newsletter:checked",
            minlength: 2
        },
        agree: "required",
        url:{
            url: true
        },
        nextowner:{
            required:true
        }
        /* ID 중복체크
        userid: {
            minlength:5,
            remote: {
                url: "/user/idcheck",
                method: "get",
                cache:false,
                complete: function (data) {
                    if(data.responseText == 0){
                        $('#userid').addClass('valid').removeClass('error').next().text('사용가능한 ID 입니다.');
                        $('#userid').next().show();
                    }else{
                        $('#userid').removeClass('valid').addClass('error').next().text('중복된 ID 입니다..');
                        $('#userid').next().show();
                    }
                },

            }
        }
        */
    },
    messages: {
        name: "이름을 입력해 주세요",
        password: {
            required: "암호를 입력해 주세요",
            minlength: "암호는 8자 이상이어야 합니다."
        },
        confirm_password: {
            required: "암호를 한 번 더 입력해 주세요",
            minlength: "암호는 8자 이상이어야 합니다.",
            equalTo: "암호가 일치하지 않습니다."
        },
        email: "형식에 맞는 이메일을 입력해 주세요.",
        agree: "정책 동의에 체크해 주세요",
    }
});

function inputValidate(){
    var size = $('.input-tab-link').length;
    var object = $('form');

    if(size != 0){
        for(var i=0;i<size;i++) {
            $('.input-tab-link:eq('+i+')').trigger('click');
            if( object.valid() == false){ return; }
        }
    }else{
        object.valid();
    }
    object.submit();
}

$('.save').click(function(e){
    e.preventDefault();
    inputValidate();
    var path = window.location.pathname;
    if( path.indexOf('/service/') >= 0){
        serviceCheckReqiredField();
    }
});
//서비스 필수값 체크
function serviceCheckReqiredField(){
    var servicetype = $('input[name=servicetype]').val();
    var servicecode1 = $('select[name="servicecode1"] option:selected').val()

    var bool = requiredValueCheck(servicetype);
    if(bool == false){
        $('input[name=servicetype]').focus();
        alert('구분값을 선택해주세요.');
        return false;
    }
    bool = requiredValueCheck(servicecode1);
    if(bool == false){
        $('input[name=servicecode1]').focus();
        alert('유형을 선택해주세요.');
        return false;
    }
}