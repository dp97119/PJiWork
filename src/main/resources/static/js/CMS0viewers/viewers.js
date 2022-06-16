$(function(){
    $.ajax({
        url:"http://localhost:8080/countToken/",
        type:"POST",
        data:"void",
        success:function(data){
            countpeople.innerText = data.countRs; 
        
        }
    })
})