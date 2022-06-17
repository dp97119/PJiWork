$(function(){
    $.ajax({
        url:"/security/countToken",
        type:"POST",
        data:"void",
        success:function(data){
            countpeople.innerText = data.countRs; 
        
        }
    })
})