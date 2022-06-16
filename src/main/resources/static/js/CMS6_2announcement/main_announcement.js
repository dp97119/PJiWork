// CMS_6_2管理系統，公告

// 查詢
$(function () {
    $.ajax({
        url: "http://localhost:8080/showAnnouncement/",
        type: "GET",
        success: function (data) {
            $.each(data, function () {
                var NowDate = new Date();
                var yy = NowDate.getFullYear();
                var mm = ('0' + (NowDate.getMonth() + 1)).slice(-2);
                var dd = ('0' + NowDate.getDate()).slice(-2);
                var today = yy + '-' + mm + '-' + dd;
                // console.log(today);

                if (today < this.removed) {
                    var announcementRecord = $(`<li id="notice">` + this.title + `</li>`);
                    $("#notice").before(announcementRecord);
                }
            })
        }
    })
})
