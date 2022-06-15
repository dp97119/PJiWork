// 查詢
$(function () {
    $.ajax({
        url: "http://localhost:8080/findApprovalset/",
        type: "GET",
        success: function (data) {
            var i = 1;
            $.each(data, function () {                
                    var approvalsetrecord = $('<tr class="staffWord"><td class="tableStyle">'+i+`</td>
                    <td class="tableStyle">`+this.aparts.apart+`</td>
                    <td class="tableStyle">`+this.employees.empName+`</td>
                    <td class="tableStyle">`+this.employee.empName+`</td>
                    <td class="tableStyle">
                        <span class="icon-input-btn">
                            <i class="glyphicon glyphicon-pencil"></i>
                            <input type="button" value="修改" class="function"
                                onClick="window.location.href='./CMS_6_4_2.html';"/>
                        </span>&nbsp;&nbsp;
                        <span class="icon-input-btn">
                            <i class="glyphicon glyphicon-trash"></i>
                            <input type="button" value="刪除" class="function"/>
                        </span>&nbsp;&nbsp;
                    </td>
                </tr>`);
                approvalsetrecord.appendTo("#leavelRecord");
                i++;
            })
        }
    })
})


// 新增
$("#sendbtn").on("click",function(){
    console.log("OK");
    if($("#aparts").find("option:selected").val() == "" || $("#reviewerone").find("option:selected").val() == "" || $("#reviewertwo").find("option:selected").val() == "" ){
        confirm("欄位不可為空白");
    }else{
        var insertSet = JSON.stringify([{
            apartId: $("#aparts").find("option:selected").val(),
            fisrtApproval:$("#reviewerone").find("option:selected").val(),
            secondApproval: $("#reviewertwo").find("option:selected").val()
        }]);

        
        $.ajax({
            url: "http://localhost:8080/saveApprovalset/",
            type: "POST",
            data: insertSet,
            contentType:"application/json",
            success:function(){
                var yes = confirm("確認完成");
                if (yes) {
                    window.location.href = './CMS_2Leaverecorded.html';
                }
            }
        })
    }

})



// 修改




// 刪除



