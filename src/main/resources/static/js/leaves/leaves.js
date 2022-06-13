$(function(){
    $.ajax({
        url:"http://localhost:8080/leaves/",
        type:"GET",
        success:function(data){
            $.each(data,function(){
                var option = $("<option>"+this.leaveType+"</option>");
                option.appendTo("#leaves");
                console.log("OK");
            })
        }
    })
})