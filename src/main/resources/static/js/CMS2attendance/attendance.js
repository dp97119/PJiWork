// CMS_2.出勤系統

// CMS_2Leaverecorded 查詢

function getCookie() {
    var cookie = document.cookie.split('=');
    return cookie[1].toString();
}


// $(function () {
//     var usertoken = JSON.stringify({ "userToken": getCookie() });
//        $.ajax({
//            url: "http://localhost:8080/Attendance/insert/",
//            type: "POST",
//            data: usertoken,
//            success: function (data) {
//                $.each(data, function () {                
//                        var attendancerecord1 = $(`<tr class="staffWord">
//                        <td class="tableStyle">${this.}</td>
//                        <td class="tableStyle">${this.}</td>
//                        <td class="tableStyle">${this.}</td>
//                        <td class="tableStyle">${this.}</td>
//                        <td class="tableStyle">${this.}</td>
//                        <td class="tableStyle">
//                            <span class="icon-input-btn">
//                                <i class="glyphicon glyphicon-pencil"></i>
//                                <input type="button" value="修改" class="function"
//                                    onClick="window.location.href='./CMS_2_2.html';">
//                            </span>&nbsp;&nbsp;
//                            <span class="icon-input-btn">
//                                <i class="glyphicon glyphicon-trash"></i>
//                                <input type="button" value="刪除" class="function deleteB">
//                            </span>&nbsp;&nbsp;
//                            <input type="button" value="申請人審核" class="function">&nbsp;&nbsp;
//                            <input type="button" value="審核歷程" class="function" id="review">
//                        </td>
//                    </tr>`);
//                    attendancerecord1.appendTo("#attendanceTable1");
//                })
//            }
//        })
//    }


// 新增
$("#sendAnnouncement").on("click",function(){
    let evestart = moment($('#startDates').val()).format('YYYY-MM-DD HH:mm:ss');
    let eveend = moment($('#endDates').val()).format('YYYY-MM-DD HH:mm:ss');
    let nowdate = moment(new Date).format('YYYY-MM-DD HH:mm:ss');
    var usertoken = JSON.stringify([{"userToken": getCookie(),   
    "leaveId":$("#leaves").find("option:selected").val() ,
    "startDate":evestart ,
    "endDate": eveend,
    "hours": $("#hours").val(),
    "approvalId": "1",
    "createDate": nowdate
    }]);

    $.ajax({
        url: "http://localhost:8080/Attendance/insert/",
        type: "POST",
        data: usertoken,
        contentType: "application/json",
        success: function () {
            if (confirm("確認完成")) {
                window.location.href="./CMS_2Leaverecorded.html";
            }
        }
    })


})



// 修改




// 刪除
