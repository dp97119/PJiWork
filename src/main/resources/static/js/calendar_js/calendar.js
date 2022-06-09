document.addEventListener('DOMContentLoaded', function() {
    // 從左邊拖曳事件進行事曆
    var containerEl = document.getElementById('external-events-list');
    new FullCalendar.Draggable(containerEl, {
        itemSelector: '.fc-event',
        eventData: function(eventEl) {
            console.log(eventEl);
            return {
            title: eventEl.innerText.trim()
            }
        }
    });
    var calendarEl = document.getElementById('calendar');
    var eventList=[  
        {   
            id:0,
            title:'Lab1',
            start:'2022-05-26',
            end:'2022-05-27',
            type:"個人",
            allDay:true

        },
        {
            id:1,
            title:'Lab2',
            start:'2022-05-25T15:00:00',
            end:'2022-05-25T16:00:00',
            type:"部門",
            allDay:false

        },
        {
            id:2,
            title:'Lab3',
            start:'2022-05-26',
            type:"公司",
            allDay:true
        },
    ];
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        locale:'zh-tw',
        navLinks: true,      //日期可以點，並跳轉頁面
        fixedWeekCount:false,   //依照月份呈現週列數
        dayMaxEvents: true,   //超過事件筆數顯示more
        height: '100%',
        headerToolbar: {    //抬頭呈現方式
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
        },
        editable: true,   //日曆允許編輯
        eventStartEditable:false,     //允許事件的開始時間可通過拖動進行編輯
        eventDurationEditable:false,  //允許通過調整大小來更改事件的持續時間
        events:eventList,
        eventClick: function(info) {
            newEvents.showModal();
            console.log(info.event.startStr.split("+")[0].split('T'));
            $('#eventTitle').val(info.event.title);
            var startT = info.event.startStr.split("+")[0].split('T');
            var endT = info.event.endStr.split("+")[0].split('T');
            if(startT[1] != null){
                $('#start').val(startT[0]); 
            }else{
                $('#start').val(startT[0] + 'T00:00:00');
            }

            if(info.event.endStr != null){
                if(endT[1] == null){
                    $('#end').val(endT[0] + 'T23:59:00');
                }else{
                    $('#end').val(endT[0]);
                }
            }else{
                $('#end').val(startT[0] + 'T23:59:59');
            }

            if (info.event.allDay == true){
                $('#allDay').prop("checked",true);
            }else{
                $('#allDay').prop("checked",false);
            }
            
            
            
        }
        
    });
    
    calendar.on('dateClick', function(info) {
        //點擊日期空白處發生的事情
        let date = info.dateStr;   //抓日期
        newEvents.showModal();
        let datetimes = date + 'T00:00:00'
        $('#eventTitle').val('');
        $('#start').val(datetimes);
        
    });
    calendar.render();

    $(':submit').on('click',function(){   //資料提交
        
    })

    $('#delete').on('click',function(info){
        if (confirm('是否刪除此事件?')) {
            arg.event.remove();     //刪除事件
        }
    })
    
});