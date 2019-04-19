//내부통지 알람
function send_message(){

    $('.isnVal').hide();
    // var sock = new SockJS("http://211.233.81.190/noteCount");
    // var sock = new SockJS("http://localhost/noteCount");
    var sock = new SockJS("http://localhost:8080/alramCount");
    sock.onopen = function(evt) {
        timerNote();
    };

    sock.onmessage = function(evt) {
        var alarmJson = evt.data;
        var jData = JSON.parse(evt.data);
        var noteAlarm = jData.payload.READCHEK;
        if(noteAlarm != 0){
            $('.isnVal').text(noteAlarm);
            $('.isnVal').show();
        }
    };

    sock.onclose = function(evt) {
        sock.close;
    };

    sock.onerror = function(evt) {
        sock.close
    };

    function timerNote(){
        var wsSiteid = $("#hiddenSiteId").val();
        var wsUserNo = $("#hiddenUserNo").val();
        var countVal = {userNo:	wsUserNo,siteId: wsSiteid};
        sock.send(JSON.stringify(countVal));
    }

    //내부통지 알림 1분마다 실행
    setInterval(function(){
        timerNote();
    }, 10000);
}
//내부통지 알람 MG
$(document).ready(function(){
     send_message();
});

//내부통지알람 읽지않은 통지 TOP10 바인딩
$('#ins').click(function () {

    $.ajax({
        url:"/insnotread",
        type:'GET',
        success:function(data){
            $('#insNotRead li').remove();
            for(var i =0; i<data.length; i++){
                html = "<li><div class='dropdown-messages-box'><a style='color:black;' href='/inbox'><strong>"+data[i].TITLE+"</strong></a><br>"+"<small class='text-muted'>"+data[i].SENDER + "&nbsp;/&nbsp;" + data[i].SENDDATE +"</small></div></div></li><li class='dropdown-divider'></li>";
                $('#insNotRead').append(html);
            }
            html2 = "<li>" +
                "<div class='text-center link-block'>" +
                "<a href='mailbox.html' class='dropdown-item'>" +
                "<a href='/inbox'><i class='fa fa-envelope'></i> <strong>모든 내부통지 확인</strong></a>" +
                "</a>" +
                "</div>" +
                "</li>";
            $('#insNotRead').append(html2);
        },
        error:function(jqXHR, textStatus, errorThrown){
            alert("오류가 발생하였습니다. 지속된다면, 관리자에게 문의해주세요.");
            return false;
        }
    });

})