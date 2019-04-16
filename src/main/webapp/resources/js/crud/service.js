$('#servicecode1').change(function(){
    upperCode('servicecode1');
});
// 커밋 테스트
function serviceStep(){
    var step = $('#servicestep').val();
    if(step == 3){
        tinyMCE.EditorManager.editors[0].setMode('readonly');
        $('.reward').prop("disabled",true);
        $('.reward').iCheck('disable');
    }else if(step == 5 || step == 6){
        tinyMCE.EditorManager.editors[0].setMode('readonly');
        $('.reward').prop("disabled",true);
        $('.reward').iCheck('disable');
    }
    var sessionId = $('#sessionId').val();
    var owner = $('#owner').val();
    if(sessionId != owner ){
        tinyMCE.EditorManager.editors[2].setMode('readonly');
        $('.ract').prop("disabled",true);
    }
}