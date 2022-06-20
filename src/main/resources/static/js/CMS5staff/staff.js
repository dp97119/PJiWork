// 紀錄
$(function () {
    $.ajax({
        url: "http://localhost:8080/emp/findAll",
        type: "GET",
        success: function (data) {
            console.log(data);
            var i = 1;
            $.each(data, function () {
                var staffAll = $(`<tr class="staffTr">
                    <td class="tableStyle">${i}</td>
                    <td class="tableStyle">${this.aparts.apart}</td>
                    <td class="tableStyle" id="empNames">${this.empName}</td>
                    <td class="tableStyle">${this.tel}</td>
                    <td class="tableStyle">${this.cellphone1}</td>
                    <td class="tableStyle">${this.email}</td>
                </tr>`);

                staffAll.appendTo("#staffRecord");
                i++;
            })
        }
    })
})


// 查詢
$("#staffSearchbtn").on("click", function () {
    // console.log("OK")
    $(".staffTr").empty();
    $.ajax({
        url: "http://localhost:8080/emp/findAll",
        type: "GET",
        success: function (data) {
            var k = 1;
            $.each(data, function () {
                if (this.aparts.apartId == $("#aparts").val() || this.empName == $("#empNameIn").val()) {
                    var staffAllS2 = $(`<tr class="staffTr">
                        <td class="tableStyle">${k}</td>
                        <td class="tableStyle">${this.aparts.apart}</td>
                        <td class="tableStyle">${this.empName}</td>
                        <td class="tableStyle">${this.tel}</td>
                        <td class="tableStyle">${this.cellphone1}</td>
                        <td class="tableStyle">${this.email}</td>
                    </tr>`);

                    staffAllS2.appendTo("#staffRecord");
                    k++;
                }else if ($("#aparts").val() == "" && $("#empNameIn").val() == "") {
                    var staffAllS3 = $(`<tr class="staffTr">
                        <td class="tableStyle">${k}</td>
                        <td class="tableStyle">${this.aparts.apart}</td>
                        <td class="tableStyle">${this.empName}</td>
                        <td class="tableStyle">${this.tel}</td>
                        <td class="tableStyle">${this.cellphone1}</td>
                        <td class="tableStyle">${this.email}</td>
                    </tr>`);

                    staffAllS3.appendTo("#staffRecord");
                    k++;
                }
            })

        }
    })
})

