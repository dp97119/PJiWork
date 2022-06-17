
var myLocation = {
  lat: 0,
  lng: 0
};

function setLocation(mylat, mylng) {
  myLocation.lat = mylat;
  myLocation.lng = mylng;
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

  console.log('Your current position is:');
  console.log('Latitude : ' + crd.latitude);
  console.log('Longitude: ' + crd.longitude);
  console.log('More or less ' + crd.accuracy + ' meters.');
  setLocation(crd.latitude, crd.longitude);
  getDistance(crd.latitude, crd.longitude);
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

var distance;
//計算googleMap 打卡點與公司的距離
function getDistance(myLat, myLng) {
  var origin1 = new google.maps.LatLng(24.15062949399325, 120.65117611577809); // 公司位置
  var service = new google.maps.DistanceMatrixService();
  service.getDistanceMatrix(
    {
      origins: [origin1],
      destinations: [myLocation],
      travelMode: 'WALKING', // 交通方式：BICYCLING(自行車)、DRIVING(開車，預設)、TRANSIT(大眾運輸)、WALKING(走路)
      unitSystem: google.maps.UnitSystem.METRIC, // 單位 METRIC(公里，預設)、IMPERIAL(哩)
    }, function (response, status) {
      if (status !== google.maps.DistanceMatrixStatus.OK) {
        window.alert('Error was' + status);
      } else {
        console.log(response.rows[0].elements[0].distance.value);
        distance = response.rows[0].elements[0].distance.value;
      }

    });
}
function getCookie() {
  var cookie = document.cookie.split('=');
  return cookie[1].toString();
}

$("#punchOK").click(function () {

  let date = moment().format('YYYY-MM-DD HH:mm:ss');

  var punchInfo = JSON.stringify([{
    status: $(this).val(),
    time: date,
    person: getCookie(),
    locationLat: myLocation.lat,
    locationLng: myLocation.lng,
  }]);
  if (distance < 500000) {
    $.ajax({
      type: "post",
      url: "/punch/saveInfo",
      data: punchInfo,
      contentType: 'application/json',
      success: function () {
        alert("打卡成功");
        $.ajax({
          type: "post",
          url: "/punch/getInfo",
          data: JSON.stringify({ "userToken": getCookie() }),
          contentType: 'application/json',
          success: function (data) {
            parent.displayPunchInfo(data);
            window.parent.location.reload();
          }
        });
      }
    });
  } else {
    alert("離公司太遠囉，不能這樣");
  }
  var onWorkTime = moment(parent.document.getElementById("onWork0").innerHTML).valueOf();
  var noWorkTime = moment(parent.document.getElementById("noWork0").innerHTML).valueOf();


  parent.$(".modal").modal("hide");
});

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
  // var onWorkTime = moment(parent.document.getElementById("onWork0").innerText).valueOf();
  // var noWorkTime = moment(parent.document.getElementById("noWork0").innerText).valueOf();
  console.log(parent.document.getElementById("noWork0").innerHTML);
  console.log(parent.document.getElementById("onWork0").innerHTML);
  // console.log(noWorkTime);
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


