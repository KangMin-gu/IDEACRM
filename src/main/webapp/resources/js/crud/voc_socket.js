//VOC 콜백 알람
function voc_send_message(){
    //var sock = new SockJS("http://localhost/vocCount");
    var sock = new SockJS("/vocCount");
    sock.onopen = function(evt) {
        timerCallback();
    };

    sock.onmessage = function(evt) {
        var alarmJson = evt.data;
        var jData = JSON.parse(evt.data);

        var admincallbackcnt = jData.payload.ADMINCALLBACKCNT;//관리자 할당 해야 할 콜백 수
        var callbackCnt = jData.payload.CALLBACKCNT;//할당된 콜백 수
        var successCallback = jData.payload.SUCCESSCALLBACK;
        $('#callbackCnt').text(callbackCnt);
        $('#successCallback').text(successCallback);
    };

    sock.onclose = function(evt) {
        sock.close;
    };

    sock.onerror = function(evt) {
        sock.close
    };

    function timerCallback(){
        var userno = $('#userno').val();
        var trunk = $('#trunk').val();
        var chkauth = $('#chkauth').val();
        var countVal = {"userno": userno ,"trunk": trunk ,"chkauth":chkauth};
        sock.send(JSON.stringify(countVal));
    }

    //알림 5초마다 실행
    setInterval(function(){
        timerCallback();
    }, 5000);
}