//사이드바 localstorage
$(document).ready(function(){








    if(localStorage.sideState == 1){
        $('body').addClass('mini-navbar');
    }else if(localStorage.sideState == null){
        $('body').removeClass('mini-navbar');
    }
});
$('.navbar-minimalize').click(function(){

    if(localStorage.sideState == null){
        localStorage.sideState = 1;
    }else if(localStorage.sideState == 1){
        delete localStorage.sideState
    }

});


