$(function () {
    $("#loginButton").click(function () {
        var user_name = $("#loginModalUserNmae").val();
        var user_password = $("#loginModalUserPwd").val();
        var data = new FormData();
        data.append("user_name",user_name);
        data.append("user_password",user_password);
        $.ajax({
            url : 'login',
            data : data,
            cache : false,
            processData : false,
            contentType : false,
            type : 'post',
            success : function (result) {
                alert(result.msg);
            },
            error : function (result) {
                alert(result.msg);
            }
        })
    })
})