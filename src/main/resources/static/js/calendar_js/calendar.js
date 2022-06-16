document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var eventList=[];
    $(function() {
        $.ajax({
            url: "http://localhost:8080/Calendar/allEvent/",
            type: "GET",
            success: function(data) {
                var i = 0
                var colors="";
                var allD = true;
                $.each(data, function() {
                    switch (this.calendarType){
                        case "個人":
                            colors = "steelblue";
                            break;
                        case "部門":
                            colors = "mediumseagreen";
                            break;
                        case "公司":
                            colors = "palevioletred";
                            break;
                        default:
                            colors = "black";
                            break;
                    }
                    if (this.allDay=="Y"){
                        allD = true;
                    }else{
                        allD = false;
                    }
                    eventList[i]={
                        id:this.calendarId,
                        title:this.calendarTitle,
                        start:this.eventStart.split(" ")[0]+"T"+this.eventStart.split(" ")[1],
                        end:this.eventEnd.split(" ")[0]+"T"+this.eventEnd.split(" ")[1],
                        type:this.calendarType,
                        allDay:allD,
                        backgroundColor:colors
                    };
                    i++;
                })
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
                        $('#eventTitle').val(info.event.title);
                        var startDT = info.event.startStr.split("+")[0];
                        var startT = startDT.split('T');
                        var endDT = info.event.endStr.split("+")[0];
                        var endT = endDT.split('T');
                        if(startT[1] == null){
                            $('#start').val(startT[0] + 'T00:00:00');
                        }else{
                            $('#start').val(startDT); 
                        }
            
                        if(info.event.end != null){
                            if(endT[1] == null){
                                $('#end').val(endT[0] + 'T23:59');
                            }else{
                                $('#end').val(endDT);
                            }
                        }else{
                            $('#end').val(startT[0] + 'T23:59');
                        }
            
                        if (info.event.allDay == true){
                            $('#allDay').prop("checked",true);
                        }else{
                            $('#allDay').prop("checked",false);
                        }
  
                        for(var i = 0; i <eventList.length ;i++){
                            if (eventList[i].id == info.event.id){
                                var types = eventList[i].type;
                                switch (types){
                                    case "個人":
                                        $('#person').prop("checked", true);
                                        break;
                                    case "部門":
                                        $('#depart').prop("checked", true);
                                        break;
                                    case "公司":
                                        $('#company').prop("checked", true);
                                        break;
                                    default:
                                        break;
                                }
                            }
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
                    $('#end').val('');
                    $('#allDay').prop("checked", false);
                    $(":radio").removeAttr("checked");
                });
                calendar.render();   //產生事件
            
            }
        })
    })
 
    $('#submit').on('click',function(){   //資料提交
        var types = "";
        switch ($("[name='eventType']:checked").val()){
            case "1":
                types = "個人";
                break;
            case "2":
                types = "部門";
                break;
            case "3":
                types = "公司";
                break;
            default:
                console.log("事件種類有誤");
                break;
        }
        var allDays ="";
        if ($("#allDay").prop('checked')){
            allDays = "Y";
        }else{
            allDays = "N";
        }
        let evestart = moment($('#start').val()).format('YYYY-MM-DD HH:mm:ss');
        let eveend;
        if($('#end').val() != ""){
            eveend = moment($('#end').val()).format('YYYY-MM-DD HH:mm:ss');
        }else{
            eveend = moment($('#start').val()).format('YYYY-MM-DD HH:mm:ss');
        }

        var insertEvent = JSON.stringify([{
            calendarTitle: $('#eventTitle').val(),
            eventStart: evestart,
            eventEnd: eveend,
            calendarType: types ,
            allDay:allDays
        }]);

        $.ajax({
            url: "http://localhost:8080/Calendar/saveEvent/",
            type: "POST",
            data: insertEvent,
            contentType: "application/json",
            success: function() {
                console.log(insertEvent);
                confirm("確認完成");
                newEvents.close();
            }
        })
    })

    $('#delete').on('click',function(info){
        if (confirm('是否刪除此事件?')) {
            arg.event.remove();     //刪除事件
        }
    })

    $('#cancel').on('click',function(){
        // $("input[name='eventType']").each(function() {  
        //     $(this).removeAttr("checked");
        // });
        newEvents.close();
    })
});