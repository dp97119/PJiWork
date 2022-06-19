function getCookie() {
    var cookie = document.cookie.split('=');
    return cookie[1].toString();
}

$(function () {
    var usertoken = JSON.stringify({ "userToken": getCookie() });
    $.ajax({
        type: "POST",
        url: "/security/checkAdm",
        data: usertoken,
        contentType:'application/json',
        success: function (data) {
        //    console.log("HOOOOOOOOOOO")
        if(data.userAdm != "admin"){
            document.getElementById("disabled").style.visibility = "hidden";
         }else{
            console.log("管理者")
         }
        }
    })
})