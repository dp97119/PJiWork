 $( document ).ready(function() {
    if(document.cookie==""){
      alert("請先登入");
      window.location.href="/index.html";
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
          window.location.href="/CMS_0interface.html";
        }
			}
    })
  });