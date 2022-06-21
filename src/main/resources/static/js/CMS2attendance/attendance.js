// CMS_2.出勤系統

// CMS_2Leaverecorded 查詢

function getCookie() {
    var cookie = document.cookie.split('=');
    return cookie[1].toString();
}

// 全部紀錄(頁面1)
$(function () {
    var usertoken = JSON.stringify({ "userToken": getCookie() });
    $.ajax({
        url: "http://localhost:8080/Attendance/findPersonData",
        type: "POST",
        data: usertoken,
        contentType: 'application/json',
        success: function (data) {
            console.log(data);
            var i = 1;
            $.each(data, function () {
                if (this.approvalId == 1) {
                    var attendancerecord1 = $(`<tr class="staffWord" id="${this.attendanceId}">
                           <td class="tableStyle">${i}</td>
                           <td class="tableStyle">${this.leaveType}</td>
                           <td class="tableStyle">${this.startDate}<br> ~ <br>${this.endDate}</td>
                           <td class="tableStyle">${this.hours}</td>
                           <td class="tableStyle">${this.approvalType}</td>
                           <td class="tableStyle">
                           <span class="icon-input-btn">
                                <i class="glyphicon glyphicon-pencil" id="glyphiconPencil"></i>
                                <input type="button" value="修改" class="function" onClick="leaveEdit(${i})">
                            </span>&nbsp;&nbsp;
                            <span class="icon-input-btn">
                                <i class="glyphicon glyphicon-trash" id="glyphiconTrash"></i>
                                <input type="button" value="刪除" class="function deleteB" onClick="attDel(${i})";>
                            </span>&nbsp;&nbsp;
                                <input type="button" onClick="apply(${i})" value="申請人審核" class="function">&nbsp;&nbsp;
                                <input type="button" onClick="reviewProcess(${i})" value="審核歷程" class="function review">
                           </td>
                       </tr>`);
                    attendancerecord1.appendTo("#attendanceTable1");
                } else {
                    var attendancerecord2 = $(`<tr class="staffWord" id="${this.attendanceId}">
                           <td class="tableStyle">${i}</td>
                           <td class="tableStyle">${this.leaveType}</td>
                           <td class="tableStyle">${this.startDate}<br> ~ <br>${this.endDate}</td>
                           <td class="tableStyle">${this.hours}</td>
                           <td class="tableStyle">${this.approvalType}</td>
                           <td class="tableStyle">
                                <input type="button" onClick="reviewProcess(${i})" value="審核歷程" class="function review">
                           </td>
                       </tr>`);
                    attendancerecord2.appendTo("#attendanceTable1");
                }
                i++;


            })
        }
    })
})



//搜尋類別紀錄(頁面1)
$("#leaveEditBtn1").on("click", function () {
    $(".staffWord").empty();
    var usertoken = JSON.stringify({ "userToken": getCookie() });
    $.ajax({
        url: "http://localhost:8080/Attendance/findPersonData",
        type: "POST",
        data: usertoken,
        contentType: 'application/json',
        success: function (data) {
            var i = 1;
            $.each(data, function () {
                if (this.leaveId == $("#leaves").val() || $("#leaves").val() == "") {
                    if (data.approvalId == 1) {
                        var attendancerecord3 = $(`<tr class="staffWord" id="${this.attendanceId}">
                               <td class="tableStyle">${i}</td>
                               <td class="tableStyle">${this.leaveType}</td>
                               <td class="tableStyle">${this.startDate}<br> ~ <br>${this.endDate}</td>
                               <td class="tableStyle">${this.hours}</td>
                               <td class="tableStyle">${this.approvalType}</td>
                               <td class="tableStyle">
                               <span class="icon-input-btn">
                                    <i class="glyphicon glyphicon-pencil" id="glyphiconPencil"></i>
                                    <input type="button" value="修改" class="function" onClick="leaveEdit(${i})">
                                </span>&nbsp;&nbsp;
                                <span class="icon-input-btn">
                                    <i class="glyphicon glyphicon-trash" id="glyphiconTrash"></i>
                                    <input type="button" value="刪除" class="function deleteB" onClick="attDel(${i})";>
                                </span>&nbsp;&nbsp;
                                    <input type="button" onClick="apply(${i})" value="申請人審核" class="function">&nbsp;&nbsp;
                                    <input type="button" onClick="reviewProcess(${i})" value="審核歷程" class="function review">
                               </td>
                           </tr>`);
                        attendancerecord3.appendTo("#attendanceTable1");
                    } else {
                        var attendancerecord4 = $(`<tr class="staffWord" id="${this.attendanceId}">
                               <td class="tableStyle">${i}</td>
                               <td class="tableStyle">${this.leaveType}</td>
                               <td class="tableStyle">${this.startDate}<br> ~ <br>${this.endDate}</td>
                               <td class="tableStyle">${this.hours}</td>
                               <td class="tableStyle">${this.approvalType}</td>
                               <td class="tableStyle">
                                    <input type="button" onClick="reviewProcess(${i})" value="審核歷程" class="function review">
                               </td>
                           </tr>`);
                        attendancerecord4.appendTo("#attendanceTable1");
                    }
                    i++;
                }
            })

        }
    })


})


// 出勤新增(頁面2)
$("#sendAnnouncement").on("click", function () {
    let evestart = moment($('#startDates').val()).format('YYYY-MM-DD HH:mm:ss');
    let eveend = moment($('#endDates').val()).format('YYYY-MM-DD HH:mm:ss');
    let nowdate = moment(new Date).format('YYYY-MM-DD HH:mm:ss');
    var usertoken = JSON.stringify([{
        "userToken": getCookie(),
        "leaveId": $("#leaves").find("option:selected").val(),
        "contentText": $("#contentText").val(),
        "startDate": evestart,
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
                window.location.href = "./CMS_2Leaverecorded.html";
            }
        }
    })
})



// 出勤修改(頁面4)
function leaveEdit(i) {
    // console.log("OK");
    var findattId = JSON.stringify([{
        attendanceId: document.getElementsByTagName("tr")[i].getAttribute('id'),
    }]);
    console.log(findattId);
    $(function () {
        $.ajax({
            url: "http://localhost:8080/Attendance/update/",
            type: "PUT",
            data: findattId,
            contentType: "application/json",
            success: function (data) {
                window.location.href = "./CMS_2_4.html"
                



                function changeAnnouncement() {
                    if (confirm("修改成功")) {
                        window.location.href = "./CMS_2Leaverecorded.html"
                    }


                }

            }
        })
    })
}







// 出勤刪除(頁面1)
function attDel(i) {
    var attDelSet = JSON.stringify([{
        attendanceId: document.getElementsByTagName("tr")[i].getAttribute('id')
    }]);
    console.log(attDelSet);

    $.ajax({
        url: "http://localhost:8080/Attendance/delete/",
        type: "DELETE",
        data: attDelSet,
        contentType: "application/json",
        success: function () {
            if (confirm("刪除成功")) {
                window.location.href = './CMS_2Leaverecorded.html';
            }
        }
    })
}



// 申請人審核按鈕  (按下後 1.頁面1表格狀態會改變)
function apply(i) {
    var attDelSet = JSON.stringify([{
        "userToken": getCookie(),
        attendanceId: document.getElementsByTagName("tr")[i].getAttribute('id'),
        approvalId: "3"
    }]);
    $.ajax({
        url: "http://localhost:8080/Approval/updateApproval1/",
        type: "PUT",
        data: attDelSet,
        contentType: "application/json",
        success: function () {
            if (confirm("申請成功")) {
                window.location.href = './CMS_2Leaverecorded.html';
            }
        }
    })
}


// 審核歷程按鈕  (彈跳視窗)




// 審核通過按鈕  (按下後  1.會傳送到頁面3的相對應(第三層)的審核人員進行審核  或  全部審核完成)




//審核未通過按鈕 (狀態改變)




