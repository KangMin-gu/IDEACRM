
function goCustDetail(prm){
    var url = "/cust/"+prm;
    location.href = url;
}

/**
 * 체크박스 전체 선택
 * 해당 체크박스에 onclick 이벤트로 이 함수 호출. 파라미터로 선택 될 셀렉트박스 tag이름을 넣어준다 ex)custno
 * @param tagName
 */
function selectCheckbox(tagName){
    if($("#checkAll").prop("checked")){
        $("input[name="+tagName+"]").prop("checked",true);
    }else{
        $("input[name="+tagName+"]").prop("checked",false);
    }
}

/**
 * 유저 삭제 (단일)
 * @param custno
 */
function custDelete(custno){
    var param = {"custno":custno};
    $.ajax({
        type: 'POST',
        url: '/cust/del',
        data: param,
        async: false,
        success: function(data) {
            if(data != null) { alert('삭제 되었습니다.');  }
            location.href = "/cust";
        },error:function(request,status,error){
            alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
        }
    });
}

/**
 * 선택 된 고객 삭제 (멀티)
 */
function custMultyDelete(){
    var count=$('input:checkbox[name=custno]:checked').length;
    if(count > 0){//선택값이 있다면 삭제 폼 실행
        $('.deleteForm').submit();
    }else{alert('선택 된 값이 없습니다.');}
}

/**
 * 리스트 페이지 fooTable 컬럼에 옵션 부여
 * @param value
 * @param options
 * @param rowData
 * @returns {string}\
 */
function custListFormatter(value, options, rowData){
    if(value){  return "<a href='/cust/"+ rowData.CUSTNO + "'>" + value + "</a>";  }
    return "";
}

function custListChkBoxFormatter(value, options, rowData){
    return "<input type='checkbox' class='row-checkbox' name='custno' value='"+ value + "' >";
}

/**
 * 다음 API 지도 구현
 * @param mapFieldId 맵<div> id
 * @param addrFieldId 주소<span> id
 * @param nameFieldId 이름<span> id
 */
function drawMap(mapFieldId, addrFieldId, nameFieldId){

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

/**
 * i-box content에 맵구현
 * 페이지 로드 되고 해당 i-box가 활성화 되면 맵을 구현한다.
 * @param mapFieldId  맵<div> id
 * @param addrFieldId  주소<span> id
 * @param nameFieldId 이름<span> id
 * @param iboxDivId ibox-content<div>  id
 */
function iboxDrawMap(mapFieldId, addrFieldId, nameFieldId,iboxDivId){
    setTimeout(function(){
        if( $('#'+iboxDivId).css('display') == 'block'){//i-box가 활성화 된 상태의 stlye속성
            drawMap(mapFieldId,addrFieldId,nameFieldId);
        }
    },300);
}



