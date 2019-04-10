//내부통지 알람
function send_message(){

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
        var noteImport = jData.payload.IMPORTANT;
        $('#alarm').hide();
        $('#noteAlarm').hide();
        if(noteAlarm != 0){
            $("#alarm").text(noteAlarm);
            $("#noteAlarm").text(noteAlarm);
            $('#alarm').show();
            $('#noteAlarm').show();
        }else {
            $('#dropClick span').hide();
            $('#noteAlarm').hide();
        }

        if(noteImport != 0){
            $("#noteImportant").text(noteImport);
            $('#noteImportant').show();
        }else {
            $('#noteImportant').hide();
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