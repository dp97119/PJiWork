var myLocation = {
  lat: 0,
  lng: 0
};

function setLocation(mylat, mylng) {
  myLocation.lat = mylat;
  myLocation.lng = mylng;
}

function getLatLngByAddr(myAddr) {   

  var geocoder = new google.maps.Geocoder();   
  geocoder.geocode(   
      { address: myAddr },     
      function(results, status) {      
          if (status == google.maps.GeocoderStatus.OK) {    
              getDistance(results[0].geometry.location);                                          
          } else {   
              alert('Error');   
          }   
    }   
);   
}  


//顯示當前時間
function ShowTime() {
  var NowDate = new Date();
  var yy = NowDate.getFullYear();
  var mm = ('0' + (NowDate.getMonth() + 1)).slice(-2);
  var dd = ('0' + NowDate.getDate()).slice(-2);
  var h = ('0' + NowDate.getHours()).slice(-2);
  var m = ('0' + NowDate.getMinutes()).slice(-2);
  var s = ('0' + NowDate.getSeconds()).slice(-2);
  document.getElementById('showbox').innerHTML = yy + '年' + mm + '月' + dd + '日' + '   ' + h + ':' + m + ':' + s;
  setTimeout('ShowTime()', 1000);
}

var options = {
  enableHighAccuracy: true,
  timeout: 5000,
  maximumAge: 0
};

function success(pos) {

  var crd = pos.coords;

  setLocation(crd.latitude, crd.longitude);
  getMyAddr();
  var myAddr = window.localStorage.getItem("myAddr");
  getLatLngByAddr(myAddr);
  initMap();
};

function error(err) {
  console.warn('ERROR(' + err.code + '): ' + err.message);
};

function initMap() {

  map = new google.maps.Map(document.getElementById("siteMap"), {
    //設置地圖樣式
    center: myLocation,
    zoom: 17,
    mapTypeId: 'terrain',
    scrollwheel: false,
    mapTypeControl: false,
    zoomControl: false,
    scaleControl: false,
    streetViewControl: false,
    rotateControl: false,
    fullscreenControl: false
  });
  // Mark位置
  var marker = new google.maps.Marker({
    position: myLocation,
    map: map
  });
  var myRangeLocation = {
    lat: myLocation.lat - 0.00085,
    lng: myLocation.lng
  };
  var markerRange = new google.maps.Marker({
    position: myRangeLocation,
    icon: "/img/MarkRange.png",
    map: map
  });
}

var distanceOfCompany;
var distanceOfHome;
//計算googleMap 打卡點與公司的距離
function getDistance(homeLat, homeLng) {
  var origin1 = new google.maps.LatLng(24.15062949399325, 120.65117611577809); // 公司位置
  var origin2 = new google.maps.LatLng(homeLat,homeLng); // 住家位置
  var service = new google.maps.DistanceMatrixService();
  service.getDistanceMatrix(
    {
      origins: [origin1,origin2],
      destinations: [myLocation,myLocation],
      travelMode: 'WALKING', // 交通方式：BICYCLING(自行車)、DRIVING(開車，預設)、TRANSIT(大眾運輸)、WALKING(走路)
      unitSystem: google.maps.UnitSystem.METRIC, // 單位 METRIC(公里，預設)、IMPERIAL(哩)
    }, function (response, status) {
      if (status !== google.maps.DistanceMatrixStatus.OK) {
        window.alert('Error was' + status);
      } else {
        distanceOfCompany = response.rows[0].elements[0].distance.value;
        distanceOfHome = response.rows[1].elements[0].distance.value;
      }

    });
}
function getCookie() {
  var cookie = document.cookie.split('=');
  return cookie[1].toString();
}

$("#punchOK").click(function () {
  if ($("#punchOK").val() == "下班") {

    var start = moment(parent.$("#onWork0").text(), 'HH:mm:ss');
    var end = moment(new Date(), 'HH:mm:ss');
    var second = end.diff(start, 'seconds');
    if (second <= 9 * 60 * 60) {
      if (confirm("目前時數還未達9小時，使否確定要打卡下班")) {
        sendPunchInfo(201);
      }
    } else {
      sendPunchInfo();
      parent.$(".modal").modal("hide");
    }
  } else {
    sendPunchInfo();
    parent.$(".modal").modal("hide");
  }

});

function sendPunchInfo(state) {
  let date = moment().format('YYYY-MM-DD HH:mm:ss');
  var punchInfo = JSON.stringify([{
    status: $("#punchOK").val(),
    time: date,
    person: getCookie(),
    locationLat: myLocation.lat,
    locationLng: myLocation.lng,
  }]);
  if (distanceOfCompany < 500 || distanceOfHome < 500) {
    $.ajax({
      type: "post",
      url: "/punch/saveInfo",
      data: punchInfo,
      contentType: 'application/json',
      success: function () {
        if(state == 201){
          alert("未滿規定時數,請到出勤系統填寫表單");
          parent.window.location.href="CMS_2_2.html";
        }else{
          alert("打卡成功");
        }
        $.ajax({
          type: "post",
          url: "/punch/getInfo",
          data: JSON.stringify({ "userToken": getCookie() }),
          contentType: 'application/json',
          success: function (data) {
            parent.punchdialog.close();
            parent.displayPunchInfo(data);
          }
        });
      }
    });
  } else {
    alert("目前不在可打卡範圍哦");
  }
}

$("#punchCancer").click(function () {
  parent.punchdialog.close();
});

$(parent.$("#myCardbtn1")).click(function () {
  if (checkPunchState() == "200") {
    $("#punchOK").val("上班");
    navigator.geolocation.getCurrentPosition(success, error, options);
  } else {
    if (confirm("尚未打下班卡，無法操作")) {
      parent.punchdialog.close();
    } else {
      parent.punchdialog.close();
    }
  }
});
$(parent.$("#myCardbtn2")).click(function () {
  if (checkPunchState() == "200") {
    if (confirm("尚未打上班卡，無法操作")) {
      parent.punchdialog.close();
    } else {
      parent.punchdialog.close();
    }

  } else {
    $("#punchOK").val("下班");
    navigator.geolocation.getCurrentPosition(success, error, options);
  }
});

function checkPunchState() {
  return PunchState = parent.document.getElementById("noWork0").getAttribute("value");
}


//獲取地址
function getMyAddr(){
  $.ajax({
    type : "post",
    url : "/emp/getAddr",
    data : JSON.stringify({ userToken : getCookie()}),
    contentType : "application/json",
    dataType : "json",
    success : function(data){
      window.localStorage.setItem("myAddr",data.addr);
    }
  });
}