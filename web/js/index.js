function sendRedisMsg(){
    var key=$("#msgKey").val();
    var content=$("#msgContent").val();
    $.ajax({
        url:"/sendRedisMsg",
        data:{"key":key,"content":content},
        dataType:"json",
        success:function(result){
            if (result.code == "1") {
                alert(result.msg);
            }else
                alert("test");
        },
        error:function () {
            alert("Operation Faild!")
        }
    });
}