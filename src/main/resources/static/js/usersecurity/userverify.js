function getCookie(){
  var cookie = document.cookie.split('=');
  return cookie[1].toString();
}
 
 $( document ).ready(function() {
    if(document.cookie==""){
      alert("請先登入");
      parent.location.href="/index.html";
    };
    var usertoken = JSON.stringify([{
				usertoken: getCookie()
			}]);
    $.ajax({
      type: "post",
			url: "http://localhost:8080/loginAction/1",
			data: usertoken,
			contentType: 'application/json',
			success: function (data) {
        console.log(data);
        if(data.state=='201'){
          alert("登入時間過長，已自動登出");
          parent.location.href="/index.html";
        }
			}
    })
  });