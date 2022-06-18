// CMS_6_2管理系統，公告

// 查詢
$(function () {
    $.ajax({
        url: "http://localhost:8080/showAnnouncement/",
        type: "GET",
        success: function (data) {
            // var i = -1;
            $.each(data, function () {
                var NowDate = new Date();
                var yy = NowDate.getFullYear();
                var mm = ('0' + (NowDate.getMonth() + 1)).slice(-2);
                var dd = ('0' + NowDate.getDate()).slice(-2);
                var today = yy + '-' + mm + '-' + dd;
                // console.log(today);

                if (today < this.removed) {
                    var announcementRecord = $(`<li id="${this.announceId}" class="noticeContent" onclick="openbtn(${this.announceId})">${this.title}</li>`);
                    $("#mainAnnouncement").after(announcementRecord);
                    // i++;

                }else{
                    // console.log("下架了")
                }

            })
        }

    })
})



// 公告第二層彈跳視窗
function openbtn(i) {
    console.log("OK");
    var openNumber = JSON.stringify([{
        announceId: document.getElementById(`${i}`).innerText
    }]);
    console.log(openNumber);

}



// $("#notice").on("click", function () {
    // var annTwo = JSON.stringify([{
    //     announceId: document.getElementsByTagName("li")[i].getAttribute('value')
    // }]);
    // console.log(annTwo);
    // currentIndex = idx;
    // $("#titleTextBox").prop("value", newsList[idx].title);
    // $("#ymdTextBox").prop("value", newsList[idx].ymd);
    // $("#newsModal").modal({ backdrop: "static" });
// })
