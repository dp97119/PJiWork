// CMS0_公告

// CMS0_公告  查詢
$(function () {
    $.ajax({
        url: "http://localhost:8080/showAnnouncement/",
        type: "GET",
        success: function (data) {
            var i = 0;
            $.each(data, function () {
                var NowDate = new Date();
                var yy = NowDate.getFullYear();
                var mm = ('0' + (NowDate.getMonth() + 1)).slice(-2);
                var dd = ('0' + NowDate.getDate()).slice(-2);
                var today = yy + '-' + mm + '-' + dd;

                if (today < this.removed) {
                    var announcementRecord = $(`<li id="${this.announceId}" class="notice" onclick="openbtn(${i})">${this.title}</li>`);
                    // $("#mainAnnouncement").after(announcementRecord);
                    announcementRecord.appendTo("#mainAnnouncement");
                    console.log(this);
                    i++;
                } else {
                    console.log("下架了")
                }
            })
        }
    })
})

// CMS0_公告第二層彈跳視窗
function openbtn(i) {
    console.log("OK");
    var openNumber = JSON.stringify([{
        announceId: document.getElementsByTagName("li")[i].getAttribute('id')
    }]);
    // console.log(openNumber);
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/showAnnouncement/",
        data:openNumber,
        success: function (data) {
            console.log("HOHOHOHOHOHOHOHO")
            titleText.innerText = data.title;
            startTime.innerText = data.updateDate;
            contentText.innerText = data.content;
            noticedialog.showModal();
        }
    })
}
