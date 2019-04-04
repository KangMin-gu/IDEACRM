$('.cust').click(function(e){
    if( e.target.classList.contains('dataCancle') == false ){
        debugger;
        openNewWindow('고객','/popcust',e.currentTarget.id,650,700);
    }
});
$('.owner').click(function(e){
    if( e.target.classList.contains('dataCancle') == false ){
        openNewWindow('사용자','/popowner',e.currentTarget.id,650,700);
    }
});

$('#reset').click(function(e){
    $('.searchparam').val('');
})

var newWindow = null;
// 부모 window 가 실행

function openNewWindow(name,url,target,x,y){
    // specs -> 팝업창의 설정들을 정의해 둔 부분
    var specs= "scrollbars=yes,menubar=no,status=no,toolbar=no,Width="+x+",Height="+y;
    // window.open 함수를 통해서 팝업창 호출
    newWindow = window.open(url, name, specs);
    // window Popup이 되고 난후에 바로 실행시키면 inpu창이 만들어지지 않아서 1초의 시간을 지연시킴
    if(target != ""){
        setTimeout(function(){
            newWindow.document.getElementById("parentid").value = target;
        },1000);
    }
}
// 자식 window가 실행
// 영업 담당자 및 담당자 가지고옴
//tr -> 실제로 클릭한 tr 자체
// 담당자 팝업 클릭
function parentOwnerUser(tr){
    // 접수자, 담당자가 겹치는 경우에 발생할 것 같아서 한번에 처리 할수 있게 수정작업함..
    // parentid => 버튼을 눌렀을때의 id 값
    var parentid = $('#parentid').val();
    // opener -> 부모의 window를 의미함.
    // tr.getAttribute("value") -> tr 값에 value를 넣어두었는데 해당 value 값을 가지고옴 => 여기서는 영업담당자의 키값(USERNO)
    // 버튼을 눌렀을때의 id 값의 next값 즉 Owner_ 옆의 Owner 값(DB에 들어갈값)
    opener.$('[name="'+parentid+'"]').next().val(tr.children().get(0).textContent);
    // tr.children.userName.textContent -> tr하위에있는 td 값중 userName의 text값을 가지고옴 => 여기서는 영업담당자의 이름을 의미
    // 버튼을 눌렀을때의 id 값을 실제로 넣음.
    opener.$('[name="'+parentid+'"]').val(tr.children().get(1).textContent).trigger('keyup');
    opener.$('#'+parentid).trigger('keyup');
    // window 창을 종료 -> 담당자 팝업을 종료함.
    window.close();
}
// 고객 팝업 클릭
function parentCustname(tr){
    var parentid = $('#parentid').val();
    opener.$('[name="'+parentid+'"]').next().val(tr.children().get(0).textContent);
    opener.$('[name="'+parentid+'"]').val(tr.children().get(1).textContent).trigger('keyup');

    setTimeout(function(){
        window.close();
    },300);
}
$('.nav-link').click(function(e){
    // click 탭의 href의 값을 가지고 온다.
    var href = e.target.attributes.href.value;
    // href의 tabpanel에 footable에 사용할 url을 가지고 온다.
    var url = $(href).attr('url');
    tabFootableSearchList(href,url);
});
