// 中間個人資訊
$(function () {

    var usertoken = JSON.stringify({ "userToken": getCookie() });

    $.ajax({
        type: "POST",
        url: "/emp/getUserInfo",
        data: usertoken,
        contentType: 'application/json',
        dataType: 'json',
        success: function (data) {
            userApart.innerText = data.apart;
            userNumber.innerText = data.empId;
            userName.innerText = data.empName;
        }
    })
})

function getCookie() {
    var cookie = document.cookie.split('=');
    return cookie[1].toString();
}

// 修改information(PUT) 
$(function () {
    var usertoken = JSON.stringify({ "userToken": getCookie() });
    $.ajax({
        type: "POST",
        url: "/emp/getUserInfo",
        data: usertoken,
        contentType: 'application/json',
        dataType: 'json',
        success: function (data) {        
            $("#inUserName").val(data.empName);
            $("#inUserPwd").val(data.empPwd);
            $("#inUserTel").val(data.empTel);
            $("#inUserPhone").val(data.empPhone);
            $("#inUserEmail").val(data.empEmail);
            $("#inUserAddr").val(data.empAddr);
        }
    })



})

function informationBtn() {
	console.log("OK")
    var usertoken = JSON.stringify({"userToken": getCookie(),   
    "empName": $("#inUserName").val(),
    "empPwd": $("#inUserPwd").val(),
    "empTel": $("#inUserTel") .val(),
    "empPhone": $("#inUserPhone").val(),
    "empEmail": $("#inUserEmail").val(),
    "empAddr": $("#inUserAddr").val(),    
    });
    console.log(usertoken);
    $.ajax({
        type: "PUT",
        url: "/emp/updateUserInfo",
        data: usertoken,
        contentType:'application/json',
        success: function () {
            console.log($("#inUserName").val());
            alert("修改成功")
        }
    })

}

