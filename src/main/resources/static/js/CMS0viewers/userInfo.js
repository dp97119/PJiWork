// 中間個人資訊
$(function () {

    var usertoken = JSON.stringify({"userToken": getCookie() });

    $.ajax({
        type: "POST",
        url: "/emp/getUserInfo",
        data: usertoken,
        contentType: 'application/json',
        dataType: 'json',
        success: function(data){
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

// 修改information(POST) 
$(function () {

    var usertoken = JSON.stringify({"userToken": getCookie() });

    $.ajax({
        type: "POST",
        url: "/emp/getUserInfo",
        data: usertoken,
        contentType: 'application/json',
        dataType: 'json',
        success: function(data){
            $("#inUserName").val(data.empName);
            $("#inUserPwd").val(data.empPwd);
            $("#inUserTel").val(data.empTel);
            $("#inUserPhone").val(data.empPhone);
            $("#inUserEmail").val(empEmail);
            $("#inUserAddr").val(empAddr);
        }
    })
})