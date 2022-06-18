$(document).ready(function () {
    var date = new Date();
    findAllOrdersByDate(date);
});

function findAllOrdersByDate(date) {
    var param = 0;
    if (date.getHours() <= 13) {
        param = JSON.stringify({
            "startDate": moment().add(-1, 'days').format("YYYY-MM-DD 12:00:00"),
            "endDate": moment().format("YYYY-MM-DD 12:00:00")
        });
    } else {
        param = JSON.stringify({
            "startDate": moment().format("YYYY-MM-DD 12:00:00"),
            "endDate": moment().add(1, 'days').format("YYYY-MM-DD 12:00:00")
        });
    }
    $.ajax({
        type: "post",
        url: "/orderSys/getAllOrdersByDate",
        data: param,
        contentType: "application/json",
        dataType: 'json',
        success: function (data) {

            var ordersTable = document.getElementById("ordersTable");
            console.log(ordersTable);
            $('#ordersTable').empty();
            for (var i = 0; i < data.length; i++) {
                orderTr = document.createElement("tr");
                orderTr.innerHTML = `   <td class="ordertableStyle">1</td>
                                        <td class="ordertableStyle">林子吟</td>
                                        <td class="ordertableStyle">2022年10月10號</td>
                                        <td class="ordertableStyle"></td>
                                        <td class="ordertableStyle"></td>
                                        <td class="ordertableStyle"></td>
                                        <td class="ordertableStyle"></td>`;
                ordersTable.appendChild(orderTr);
            }
        }
    });

}