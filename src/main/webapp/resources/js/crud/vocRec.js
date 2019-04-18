
function goPlay(recDate, recExt, recFilename){
    var urlStr = "http://203.239.159.133:8090";
    var recIdx = '';
    var nucIdx = 0;
    $.ajax({
        type : "POST",
        url : urlStr+"/ncrUrlConvInput.do",
        data : {
            "rec_idx" : recIdx,
            "rec_ext" : recExt,
            "rec_date" : recDate,
            "rec_file" : recFilename
        },
        dataType : "json",
        success : function(req) {
            var result_code = req.result_code;//상태
            var result_msg = req.result_msg;
            var result_idx = req.result_idx;
            $('#nucIdx').val(result_idx);
            if(result_code == 0){
                //fn_nuc_url_conv_check(result_idx);
                openNewWindow('rec','/voc/pop/rec','',500,120);
            }else{
                alert(result_msg);
            }
        },
        error : function(result, status, err) {
            alert(result + " / " + status + " / " + err);
        },
        beforeSend: function() {

        },
        complete: function(){
        }
    });
}

//오디오플레이어 활성화
function audio(){
    var strCtiBrowser = navigator.userAgent;
    var player = "";

    if(strCtiBrowser.indexOf("MSIE") > 0 || strCtiBrowser.indexOf("Trident") > 0) {
        player += "<object id='Player' classid='clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95' codebase='http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=6,4,5,71' ";
        player += "width='100%' height='70' standby='Loading Microsoft Windows Media Player components...' type='application/x-oleobject'>";
        player+="<param name='AutoStart' value='true'>"
        player+="<param name='TransparentAtStart' value='True'>";
        player+="<param name='ShowControls' value='1'>";
        player+="<param name='ShowDisplay' value='0'>";
        player+="<param name='ShowStatusBar' value='1'>";
        player+="<param name='AutoSize' value='1'>";
        player+="<param name='AnimationAtStart' value='false'>";
        player+="<param name='hidden' value='true'>";
        player+="<param name='FileName' value=''>";
        player+="</object>";
        document.getElementById("audio").innerHTML = player;
    } else if(strCtiBrowser.indexOf("Chrome") > 0){//크롬
        player+="<audio id='Player' controls='controls' controlsList='nodownload' class='audio_con' preload='metadata'>";
        player+="<source src='' type='audio/wav'/></audio>";
        document.getElementById("audio").innerHTML = player;
    } else {
        player+="<audio id='Player' controls='controls' controlsList='nodownload' class='audio_con' preload='metadata'>";
        player+="<source src='' type='audio/wav'/></audio>";
        document.getElementById("audio").innerHTML = player;
    }
}
//녹취 파일 호출
function fn_nuc_url_conv_check(nucIdx){
    var urlStr = "http://203.239.159.133:8090";
    var strCtiBrowser = navigator.userAgent;
    var nucStatus = "N";
    var nucFile = "";
    var checkHomeUrl = urlStr+"/wav/urldown/";

    $.ajax({
        type : "POST",
        url : urlStr+"/ncrUrlConvStatus.do",
        data : {
            "nuc_idx" : nucIdx
        },
        dataType : "json",
        success : function(req) {
            nucStatus = req.nucStatus;
            nucFile = req.nucFile;
            //녹취변환성공시
            if(nucStatus == "Y"){
                debugger;
                $("#checkTryCount").val("0");
                $("#nucFile").val(nucFile);

                if(strCtiBrowser.indexOf("MSIE") > 0 || strCtiBrowser.indexOf("Trident") > 0) {
                    document.getElementById("Player").FileName = checkHomeUrl + nucFile;
                } else if(strCtiBrowser.indexOf("Chrome") > 0) {
                    $("#Player").attr("src", checkHomeUrl + nucFile);
                    document.getElementById("Player").play();
                }

                var prm = document.getElementsByTagName("param");
                var value = "";
                for(var i = 0; i<prm.length;i++){
                    if(prm[i].getAttribute("name") == "FileName"){
                        value = prm[i].getAttribute("value");
                        //prm[i].setAttribute('value',"C:\\recfile_temp\\" + recfilename);
                        prm[i].setAttribute('value',checkHomeUrl + nucFile);
                    }
                }
            }else{
                if( $("#checkTryCount").val() < 60){
                    setTimeout("(fn_nuc_url_conv_check("+nucIdx+"))", 1000);
                    $("#checkTryCount").val( parseInt($("#checkTryCount").val()) +1  );
                }else{
                    $("#checkTryCount").val("0");
                    alert("오류");
                }
            }
        },
        error : function(result, status, err) {
            alert(result + " / " + status + " / " + err);
        },
        beforeSend: function() {

        },
        complete: function(){
        }
    });
}