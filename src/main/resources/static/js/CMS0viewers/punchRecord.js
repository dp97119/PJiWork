// 限定只能撈三筆資料
function displayPunchInfo(userPunchData) {
    if (userPunchData[0].status == "下班") {
        for (var i = 0; i < userPunchData.length; i += 2) {
            var dateday = userPunchData[i].time.split(" ")[0];
            var datetime = userPunchData[i].time.split(" ")[1];
            console.log(dateday + "+" + datetime);

            var precord = $(`<tr>
                                <td colspan="2">
                                    <h5>${dateday}</h5>
                                </td>
                            </tr>
                            <tr class="myTimeborder">
                                <td class="myTime">上班</td>
                                <td class="myTime">${userPunchData[i + 1].time.split(" ")[1]}</td>
                            </tr>
                            <tr class="myTimeborder">
                                <td class="myTime">下班</td>
                                <td class="myTime">${userPunchData[i].time.split(" ")[1]}</td>
                            </tr>
                            <tr>
                                <td> <pre> </pre> </td>
                            </tr>`);
            precord.appendTo("#punchRecord");
        }
    } else {
        var precord = $(`<tr>
                            <td colspan="2">
                            <h5>${userPunchData[0].time.split(" ")[0]}</h5>
                            </td>
                        </tr>
                        <tr class="myTimeborder">
                            <td class="myTime">上班</td>
                            <td class="myTime">${userPunchData[0].time.split(" ")[1]}</td>
                        </tr>
                        <tr class="myTimeborder">
                            <td class="myTime">下班</td>
                            <td class="myTime">------</td>
                        </tr>
                        <tr>
                             <td> <pre> </pre> </td>
                        </tr>`);
        precord.appendTo("#punchRecord");
        for (var i = 1; i < userPunchData.length-1; i += 2) {
            var dateday = userPunchData[i].time.split(" ")[0];
            var datetime = userPunchData[i].time.split(" ")[1];
            console.log(dateday + "+" + datetime);

            var precord = $(`<tr>
                                <td colspan="2">
                                <h5>${dateday}</h5>
                                </td>
                            </tr>
                            <tr class="myTimeborder">
                                <td class="myTime">上班</td>
                                <td class="myTime">${userPunchData[i + 1].time.split(" ")[1]}</td>
                            </tr>
                            <tr class="myTimeborder">
                                <td class="myTime">下班</td>
                                <td class="myTime">${userPunchData[i].time.split(" ")[1]}</td>
                            </tr>
                            <tr>
                                <td> <pre> </pre> </td>
                            </tr>`);
            precord.appendTo("#punchRecord");
        }
    }

}

function getCookie() {
    var cookie = document.cookie.split('=');
    return cookie[1].toString();
 }

$(function () {
    var data = JSON.stringify({"userToken":getCookie()});
    console.log(data);
    $.ajax({
        type: "post",
        url: "/punch/getInfo",
        data:data,
        contentType: 'application/json',
        dataType : 'json',
        success:function(data){
            displayPunchInfo(data);
            console.log(data);
        } 
    });
})


