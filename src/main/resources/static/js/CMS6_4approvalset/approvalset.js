// 查詢
var approvalList = [];
$(function () {
	$.ajax({
		url: "http://localhost:8080/findApprovalset/",
		type: "GET",
		success: function (data) {
			var i = 1;
			$.each(data, function () {
				var approvalsetrecord =
					$(`<tr class="staffWord" id="${this.approvalSetId}">
						<td class="tableStyle"> ${i} </td>
                    	<td class="tableStyle"> ${this.aparts.apart}</td>
                    	<td class="tableStyle">${this.employees.empName} </td>
                    	<td class="tableStyle"> ${this.employee.empName} </td>
                    	<td class="tableStyle">
                        	<span class="icon-input-btn">
                            	<i class="glyphicon glyphicon-pencil"></i>
                            	<input type="button" value="修改" class="function" onClick="window.location.href='./CMS_6_4_2.html';editbtn( ${i})"/>
                        	</span>&nbsp;&nbsp;
                        	<span class="icon-input-btn">
                            	<i class="glyphicon glyphicon-trash"></i>
                            	<input type="button" value="刪除" class="function" onClick="deletebtn( ${i})"/>
                        	</span>&nbsp;&nbsp;
                    	</td>
                	</tr>`);
				approvalsetrecord.appendTo("#leavelRecord");
				approvalList[i - 1] = this.aparts.apartId;
				i++;
			})
		}
	})
})



// 新增
$("#sendbtn").on("click", function () {
	if ($("#aparts").find("option:selected").val() == "" || $("#reviewerone").find("option:selected").val() == "" || $("#reviewertwo").find("option:selected").val() == "") {

		confirm("欄位不可為空白");

	} else {
		var j = false;
		for (var i = 0; i < approvalList.length; i++) {
			if ($("#aparts").find("option:selected").val() == approvalList[i]) {
				j = true;
				break;
			}
		}
		if (j == false) {
			var insertSet = JSON.stringify([{
				apartId: $("#aparts").find("this.approvalSetId").val(),
				fisrtApproval: $("#reviewerone").find("option:selected").val(),
				secondApproval: $("#reviewertwo").find("option:selected").val()
			}]);

			$.ajax({
				url: "http://localhost:8080/saveApprovalset/",
				type: "POST",
				data: insertSet,
				contentType: "application/json",
				success: function () {
					var yes = confirm("確認完成");
					if (yes) {
						window.location.href = './CMS_6_4_1.html';
					}
				}
			})
		} else {
			var yes = confirm("資料已存在");
			if (yes) {
				window.location.href = './CMS_6_4_1.html';
			}
		}

	}

})


// 修改
function editbtn(i) {
	// var editSet = JSON.stringify([{
	// 	approvalSetId: document.getElementsByTagName("tr")[i].getAttribute('id')
	// }]);
	// console.log(editSet);

	// console.log("hihi");
	// console.log(document.getElementsByTagName("tr")[i].getAttribute('id'));

}



// 刪除

// getAttribute回傳屬性值

function deletebtn(i) {
	var deleteSet = JSON.stringify([{
		approvalSetId: document.getElementsByTagName("tr")[i].getAttribute('id')
	}]);

	$.ajax({
		url: "http://localhost:8080/deleteApprovalset/",
		type: "DELETE",
		data: deleteSet,
		contentType: "application/json",
		success: function () {
			var yes = confirm("刪除成功");
			if (yes) {
				window.location.href = './CMS_6_4_1.html';
			}
			console.log(deleteSet);
		}
	})





	// console.log("haha");
	// console.log(document.getElementsByTagName("tr")[i].getAttribute('id'));
}
