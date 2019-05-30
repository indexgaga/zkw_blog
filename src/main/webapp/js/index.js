$(function () {
    $("#loginOut").click(function () {
        $.ajax({
            url : 'loginOut',
            type : 'get',
            cache : false,
            processData : false,
            contentType : false,
            success : function (data) {
                if(data.code == 200){
                    window.location.href = "index";
                }
            },
            error : function (data) {
                alert(data.msg);
            }
        })
    })

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
                window.location.href="index";
                alert(result.msg);
            },
            error : function (result) {
                alert(result.msg);
            }
        })
    })
})