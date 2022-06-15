$(function(){
    $.ajax({
        url:"http://localhost:8080/countToken/",
        type:"POST",
        data:"void",
        success:function(data){
            console.log(data.countRs);
            countpeople.innerText = data.countRs; 
        
        }
    })
})