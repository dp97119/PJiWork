// CMS_6_2管理系統，公告

// 查詢
$(function () {
    $.ajax({
        url: "http://localhost:8080/showAnnouncement/",
        type: "GET",
        success: function (data) {
            var i = 1;
            $.each(data, function () {                
                    var announcementRecord = $(`<tr class="staffWord">
                    <td class="tableStyle">`+ i +`</td>
                    <td class="tableStyle" style="text-align: left;">`+ this.title +`</td>
                    <td class="tableStyle" style="text-align: left;">`+this.content+`</td>
                    <td class="tableStyle" style="text-align: left;">`+ i +`</td>
                    <td class="tableStyle">`+this.employees.empName+`</td>
                    <td class="tableStyle">`+this.updateDate+`</td>
                    <td class="tableStyle">`+this.removed+`</td>
                    <td class="tableStyle">
                        <span class="icon-input-btn">
                            <i class="glyphicon glyphicon-pencil"></i>
                            <input type="button" value="修改" class="function"
                                onClick="window.location.href='./CMS_6_2_2.html';">
                        </span>&nbsp;&nbsp;
                        <span class="icon-input-btn">
                            <i class="glyphicon glyphicon-trash"></i>
                            <input type="button" value="刪除" class="function deleteB">
                        </span>&nbsp;&nbsp;
                    </td>
                </tr>`);
                announcementRecord.appendTo("#announcementTable");
                i++;
            })
        }
    })
})


// 新增
// $("#sendbtn").on("click",function(){
//     console.log("OK");
//     if($("#aparts").find("option:selected").val() == "" || $("#reviewerone").find("option:selected").val() == "" || $("#reviewertwo").find("option:selected").val() == "" ){
//         confirm("欄位不可為空白");
//     }else{
//         console.log($("#aparts").find("option:selected").val());
//         console.log($("#reviewerone").find("option:selected").val());
//         console.log($("#reviewertwo").find("option:selected").val());
//     }

// })



// 修改




// 刪除
