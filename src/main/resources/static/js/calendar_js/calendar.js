document.addEventListener('DOMContentLoaded', function() {
    var containerEl = document.getElementById('external-events-list');
    new FullCalendar.Draggable(containerEl, {
        itemSelector: '.fc-event',
        eventData: function(eventEl) {
            return {
            title: eventEl.innerText.trim()
            }
        }
    });
    var calendarEl = document.getElementById('calendar');
    var eventList=[  
        {
            title:'Lab1',
            start:'2022-05-26',
            end:'2022-05-27'

        },
        {
            title:'Lab2',
            start:'2022-05-25T15:00:00',
            end:'2022-05-25T16:00:00'
        },
        {
            title:'Lab3',
            start:'2022-05-26',
            allDay:false
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
        // eventClick: function(calEvent, jsEvent, view) {//日程區塊，單擊時觸
        //     return false; //return false可以阻止點擊後續事件發生（比如event中的url跳轉事件）
        // },
        editable: true,   //日曆允許編輯
        droppable: true,  // 可以移動日曆的事件
        drop: function(arg) {
            // is the "remove after drop" checkbox checked?
            if (document.getElementById('drop-remove').checked) {
            // if so, remove the element from the "Draggable Events" list
            arg.draggedEl.parentNode.removeChild(arg.draggedEl);
            }
        },
        events:eventList,
        eventClick: function(info) {
            if (confirm('Are you sure you want to delete this event?')) {
                arg.event.remove()     //刪除事件
              }
            console.log(info.event)     //取得事件資訊
        }

    });
    calendar.on('dateClick', function(info) {
        //點擊日期
        let date=info.dateStr;
    });
    calendar.render();
});
