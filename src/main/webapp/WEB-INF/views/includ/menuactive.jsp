<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
    var active = '${menuactive}';
    $(document).ready(function(){

        if(active == 'cust'){
            $('.custMenu').addClass('active');
            $('.custMenu').children().attr('aria-expanded',true);
            $('.custMenu').children('ul').addClass('collapse in');
        }else if(active == 'allnotice'){
            $('.myinfo').addClass('active');
            $('.allnotice').addClass('active');
            $('.myinfo').children().attr('aria-expanded',true);
            $('.myinfo').children('ul').addClass('collapse in');
        }else if(active == 'insideNotice'){
            $('.myinfo').addClass('active');
            $('.insideNotice').addClass('active');
            $('.myinfo').children().attr('aria-expanded',true);
            $('.myinfo').children('ul').addClass('collapse in');
        }else if(active == 'code'){
            $('.manager').addClass('active');
            $('.codeMenu').addClass('active');
            $('.manager').children().attr('aria-expanded',true);
            $('.manager').children('ul').addClass('collapse in');
        }else if(active == 'formatM'){
            $('.manager').addClass('active');
            $('.formatMenu').addClass('active');
            $('.manager').children().attr('aria-expanded',true);
            $('.manager').children('ul').addClass('collapse in');
        }else if(active == 'noticeM'){
            $('.myinfo').addClass('active');
            $('.noticeMenu').addClass('active');
            $('.myinfo').children().attr('aria-expanded',true);
            $('.myinfo').children('ul').addClass('collapse in');
        }else if(active == 'vocnoticeM'){
            $('.vocMenu').addClass('active');
            $('.vocnoticeMenu').addClass('active');
            $('.vocMenu').children().attr('aria-expanded',true);
            $('.vocMenu').children('ul').addClass('collapse in');
        }else if(active == 'vocdashM'){
            $('.vocMenu').addClass('active');
            $('.vocdashMenu').addClass('active');
            $('.vocMenu').children().attr('aria-expanded',true);
            $('.vocMenu').children('ul').addClass('collapse in');
        }else if(active =='serviceM'){
            $('.serviceM').addClass('active');
            $('.serviceMenu').addClass('active');
            $('.serviceM').children().attr('aria-expanded',true);
            $('.serviceM').children('ul').addClass('collapse in');
        }else if(active == 'servicedeliveryM'){
            $('.serviceM').addClass('active');
            $('.servicedeliveryMenu').addClass('active');
            $('.serviceM').children().attr('aria-expanded',true);
            $('.serviceM').children('ul').addClass('collapse in');
        }else if(active == 'serviceCallendar'){
            $('.serviceM').addClass('active');
            $('.serviceCallendarMenu').addClass('active');
            $('.serviceM').children().attr('aria-expanded',true);
            $('.serviceM').children('ul').addClass('collapse in');
        }

    });
</script>

