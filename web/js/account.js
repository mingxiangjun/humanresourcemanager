function addAccount(){
    var account=$("#account").val();
    var email=$("#email").val();
    var securityAns=$("#securityAns").val();
    var securityQues=$("#securityQues").val();
    var param = {
        "account":account,
        "email":email,
        "securityAns":securityAns,
        "securityQues":securityQues
    }
    $.ajax({
        "url":"/accountInfo/saveAccountInfo",
        "type":"post",
        "data":param,
        "dataType":"json",
        "success":function () {
            alert("操作成功！")
        },
        "error":function () {
            alert("操作失败！")
        }
    });
}