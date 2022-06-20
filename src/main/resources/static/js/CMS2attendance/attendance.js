// CMS_2.出勤系統

// CMS_2Leaverecorded 查詢

function getCookie() {
    var cookie = document.cookie.split('=');
    return cookie[1].toString();
}

// 全部紀錄1
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
                    var attendancerecord1 = $(`<tr class="staffWord" id="${this.approvalId}">
                           <td class="tableStyle">${i}</td>
                           <td class="tableStyle">${this.leaveType}</td>
                           <td class="tableStyle">${this.startDate}<br> ~ <br>${this.endDate}</td>
                           <td class="tableStyle">${this.hours}</td>
                           <td class="tableStyle">${this.approvalType}</td>
                           <td class="tableStyle">
                           <span class="icon-input-btn">
                                <i class="glyphicon glyphicon-pencil" id="glyphiconPencil"></i>
                                <input type="button" id="leaveEdit" value="修改" class="function" onClick="window.location.href='./CMS_2_4.html';">
                            </span>&nbsp;&nbsp;
                            <span class="icon-input-btn">
                                <i class="glyphicon glyphicon-trash" id="glyphiconTrash"></i>
                                <input type="button" id="leaveDel" value="刪除" class="function deleteB">
                            </span>&nbsp;&nbsp;
                                <input type="button" id="apply" value="申請人審核" class="function">&nbsp;&nbsp;
                                <input type="button" id="reviewProcess" value="審核歷程" class="function review">
                           </td>
                       </tr>`);
                    attendancerecord1.appendTo("#attendanceTable1");
                } else {
                    var attendancerecord2 = $(`<tr class="staffWord" id="${this.approvalId}">
                           <td class="tableStyle">${i}</td>
                           <td class="tableStyle">${this.leaveType}</td>
                           <td class="tableStyle">${this.startDate}<br> ~ <br>${this.endDate}</td>
                           <td class="tableStyle">${this.hours}</td>
                           <td class="tableStyle">${this.approvalType}</td>
                           <td class="tableStyle">
                                <input type="button" id="reviewProcess" value="審核歷程" class="function review">
                           </td>
                       </tr>`);
                    attendancerecord2.appendTo("#attendanceTable1");
                }
                i++;


            })
        }
    })
})



//搜尋類別紀錄1
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
                if (this.leaveId == $("#leaves").val()) {
                    if (data.approvalId == 1) {
                        var attendancerecord3 = $(`<tr class="staffWord" id="${this.approvalId}">
                               <td class="tableStyle">${i}</td>
                               <td class="tableStyle">${this.leaveType}</td>
                               <td class="tableStyle">${this.startDate}<br> ~ <br>${this.endDate}</td>
                               <td class="tableStyle">${this.hours}</td>
                               <td class="tableStyle">${this.approvalType}</td>
                               <td class="tableStyle">
                               <span class="icon-input-btn">
                                    <i class="glyphicon glyphicon-pencil" id="glyphiconPencil"></i>
                                    <input type="button" id="leaveEdit" value="修改" class="function" onClick="window.location.href='./CMS_2_2.html';">
                                </span>&nbsp;&nbsp;
                                <span class="icon-input-btn">
                                    <i class="glyphicon glyphicon-trash" id="glyphiconTrash"></i>
                                    <input type="button" id="leaveDel" value="刪除" class="function deleteB">
                                </span>&nbsp;&nbsp;
                                    <input type="button" id="apply" value="申請人審核" class="function">&nbsp;&nbsp;
                                    <input type="button" id="reviewProcess" value="審核歷程" class="function review">
                               </td>
                           </tr>`);
                        attendancerecord3.appendTo("#attendanceTable1");
                    } else {
                        var attendancerecord4 = $(`<tr class="staffWord" id="${this.approvalId}">
                               <td class="tableStyle">${i}</td>
                               <td class="tableStyle">${this.leaveType}</td>
                               <td class="tableStyle">${this.startDate}<br> ~ <br>${this.endDate}</td>
                               <td class="tableStyle">${this.hours}</td>
                               <td class="tableStyle">${this.approvalType}</td>
                               <td class="tableStyle">
                                    <input type="button" id="reviewProcess" value="審核歷程" class="function review">
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






// 新增
$("#sendAnnouncement").on("click", function () {
    let evestart = moment($('#startDates').val()).format('YYYY-MM-DD HH:mm:ss');
    let eveend = moment($('#endDates').val()).format('YYYY-MM-DD HH:mm:ss');
    let nowdate = moment(new Date).format('YYYY-MM-DD HH:mm:ss');
    var usertoken = JSON.stringify([{
        "userToken": getCookie(),
        "leaveId": $("#leaves").find("option:selected").val(),
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



// 修改




// 刪除
