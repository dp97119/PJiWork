$(function(){
    $.ajax({
        url:"http://localhost:8080/apart/",
        type:"GET",
        success:function(data){
            $.each(data,function(){
                var option = $("<option>"+this.apart+"</option>");
                option.appendTo("#aparts");
                console.log("OK");
            })
        }
    })
})