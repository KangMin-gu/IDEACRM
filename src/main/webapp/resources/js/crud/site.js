function map(mapFieldId, addrFieldId, nameFieldId){

    var mapContainer = document.getElementById(mapFieldId), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 지도를 표시하는 div 크기를 변경하는 함수입니다
    function resizeMap() {
        var mapContainer = document.getElementById(mapFieldId);
        mapContainer.style.width = '650px';
        mapContainer.style.height = '650px';
    }

    function relayout() {

        // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
        // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다
        // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
        map.relayout();
    }

    var geocoder = new daum.maps.services.Geocoder();

    var accountAddr = $('#'+addrFieldId).text();
    var accountName = $('#'+nameFieldId).text();

    // 주소로 좌표를 검색합니다
    geocoder.addressSearch(accountAddr, function(result, status) {

        // 정상적으로 검색이 완료됐으면
        if (status === daum.maps.services.Status.OK) {

            var coords = new daum.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new daum.maps.Marker({
                map: map,
                position: coords
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new daum.maps.InfoWindow({
                content: "<div style='width:150px;text-align:center;padding:6px 0;''>"+accountName+"</div>"
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        }
    });
}
// IDEA발송수 탭 클릭
$('.totalCnt').click(function(e){

    var siteId = $('#siteid').val();
    var param = searchDataToJson();

    $.ajax({
        url: "/common/site/totalMoney/"+siteId,
        method: "POST",
        dataType: "json",
        data : param,
        cache: false,
        success: function (data) {
            debugger;
            $('#smscharge').text(data.chargeType.smscharge);
            $('#mmscharge').text(data.chargeType.mmscharge);
            $('#lmscharge').text(data.chargeType.lmscharge);
            $('#kakaocharge').text(data.chargeType.kakaocharge);
            $('#emailcharge').text(data.chargeType.emailcharge);

            $('#smscnt').text(data.smsCnt);
            $('#mmscnt').text(data.mmsCnt);
            $('#lmscnt').text(data.lmsCnt);
            $('#kakaocnt').text(data.kakaoCnt);
            $('#emailcnt').text(data.emailCnt);

            $('#smstotal').text(data.smsTotal);
            $('#mmstotal').text(data.mmsTotal);
            $('#lmstotal').text(data.lmsTotal);
            $('#kakaototal').text(data.kakaoTotal);
            $('#emailtotal').text(data.emailTotal);

            $('#mergemoney').text(data.mergeMoney);
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });

});


function masterPasswordReset(siteid){
    var param = {"siteid":siteid}
    $.ajax({
        url: "/common/site/password/"+siteid,
        method: "POST",
        dataType: "json",
        data:param,
        cache: false,
        success: function (data) {
            alert("비밀번호가 초기화 되었습니다.");
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}