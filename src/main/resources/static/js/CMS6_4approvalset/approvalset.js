// 查詢
var approvalList = [];
$(function () {
	$.ajax({
		url: "http://localhost:8080/Approvalset/find/",
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
                            	<input type="button" value="修改" class="function" onClick="editbtn( ${i})"; />
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
				apartId: $("#aparts").find("option:selected").val(),
				fisrtApproval: $("#reviewerone").find("option:selected").val(),
				secondApproval: $("#reviewertwo").find("option:selected").val()
			}]);
			$.ajax({
				url: "http://localhost:8080/Approvalset/save/",
				type: "POST",
				data: insertSet,
				contentType: "application/json",
				success: function () {
					if (confirm("確認完成")) {
						window.location.href = './CMS_6_4_1.html';
					}
				}
			})
		} else {
			if (confirm("資料已存在")) {
				window.location.href = './CMS_6_4_1.html';
			}
		}
	}
})

// 修改
function editbtn(i) {
	var findId = JSON.stringify({
		approvalSetId: document.getElementsByTagName("tr")[i].getAttribute('id')
	});
	$(function () {
		console.log(findId)
		console.log("--------")
		$.ajax({
			url: "http://localhost:8080/Approval/dataresponse/",
			type: "POST",
			data: findId,
			contentType: "application/json",
			success: function (data) {
				console.log(findId)
				console.log(data.firstApprovalId);
				console.log(data.secondApprovalId);
				window.location.href = './CMS_6_4_2.html';
				$("approvalsetid").val(data.approvalSetId)
				$('#aparts').find(`option[value=${data.apartId}]`).prop('selected',true);  //可以抓
				$("#reviewerone").find(`option[value=${data.firstApprovalId}]`).prop('selected',true);
				$("#reviewertwo").find(`option[value=${data.secondApprovalId}]`).prop('selected',true);
				$('#aparts').prop('disabled',true); //可以鎖
				console.log("確認收到")
			}
		})
	})
	
}
	// var editSet = JSON.stringify([{
	// 	approvalSetId: document.getElementsByTagName("tr")[i].getAttribute('id'),
	// 	fisrtApproval: $("#reviewerone").find("option:selected").val(),
	// 	secondApproval: $("#reviewertwo").find("option:selected").val()
	// }]);
	// console.log(editSet);
	// $.ajax({
	// 	url: "http://localhost:8080/Approvalset/update/",
	// 	type: "PUT",
	// 	data: editSet,
	// 	contentType: "application/json",
	// 	success: function () {
	// 		console.log(editSet);
	// 		if (confirm("修改成功")) {
	// 			window.location.href = './CMS_6_4_1.html';
	// 		}
	// 	}
	// })

// }



// 刪除

// getAttribute回傳屬性值

function deletebtn(i) {
	var deleteSet = JSON.stringify([{
		approvalSetId: document.getElementsByTagName("tr")[i].getAttribute('id')
	}]);

	$.ajax({
		url: "http://localhost:8080/Approvalset/delete/",
		type: "DELETE",
		data: deleteSet,
		contentType: "application/json",
		success: function () {
			if (confirm("刪除成功")) {
				window.location.href = './CMS_6_4_1.html';
			}
		}
	})
}

