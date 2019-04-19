
    var schList= $('#schList').val();//hidden value에 담겨있는 스케쥴 리스트를 받아온다.(json String)
    /* initialize the calendar
         -----------------------------------------------------------------*/
    var url = window.location.pathname;

    $('#calendar').fullCalendar({

        header: {//캘린더 프레임 헤더설정
            left: 'prev,next today',//저번달, 다음달, 오늘로이동
            center: 'title',
            right: 'month,agendaWeek,agendaDay' //월,주,일별 보기
        },

        editable: false, //false - 일정 수정 안됨.

        droppable: false, // false - 드래그 박스의 일정 캘린더로 이동이 안됨.

        //한글화
        monthNames: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
        monthNamesShort: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
        dayNames: ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
        dayNamesShort: ["일","월","화","수","목","금","토"],
        buttonText: {
            today : "오늘",
            month : "월별",
            week : "주별",
            day : "일별",
        },
        timeFormat : "HH:mm",

        eventRender: function(event, element){
            debugger;
            if(event.end == null){
                event.end = event.start;
                event.end._i = event.start._i;
            }

            element.popover({
                placement:'top',
                animation:true,
                delay: 100,
                content: '<b>서비스명</b>:'+event.title+"<b>서비스 일자</b>:"+event.start._i,
                trigger: 'hover',
                html : true
            });
        },

        eventClick: function(event, element) {//캘린더 이벤트 클릭시
            //window.location.href = campUrl+"/"+id;
            openNewWindow("캘린더상세",url+"/"+event.id,"",600,700);
        },
        eventSources: [
            {
                events:  JSON.parse(schList)//json String객체를 json객체로 변환해준다  -> 스케쥴 리스트 달력에 표시됨
            }
        ]
    });//캘린더의끝
