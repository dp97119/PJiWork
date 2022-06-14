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
                    <td class="tableStyle">`+this.aparts.apart+`</td>
                    <td class="tableStyle">`+this.aparts.apart+`</td>
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
                console.log(data);
            })
        }
    })
})



// 新增


// 修改


// 刪除