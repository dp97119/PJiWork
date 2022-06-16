// CMS_6_2管理系統，公告

// 查詢
$(function () {
    $.ajax({
        url: "http://localhost:8080/showAnnouncement/",
        type: "GET",
        success: function (data) {
            $.each(data, function () {                
                    var announcementRecord = $(`<li id="notice">`+ this.title +`</li>`);
                announcementRecord.appendTo("#mainAnnouncement");
            })
        }
    })
})
