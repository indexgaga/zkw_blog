$(function () {
    //在页面未加载完毕之前显示的loading Html自定义内容
    var _LoadingHtml = '<div id="loadingDiv" style="display: none; "><div id="over" style=" position: absolute;top: 0;left: 0; width: 100%;height: 100%; background-color: #f5f5f5;opacity:0.5;z-index: 1000;"></div><div id="layout" style="position: absolute;top: 40%; left: 40%;width: 20%; height: 20%;  z-index: 1001;text-align:center;"><img src="<%=request.getContextPath()%>/js/plugins/timg.gif" /></div></div>';
//呈现loading效果
    //document.write(_LoadingHtml);

//移除loading效果
    function completeLoading() {
        document.getElementById("loadingDiv").style.display="none";
    }
//展示loading效果
    function showLoading()
    {
        document.getElementById("loadingDiv").style.display="block";
    }


    $("#loginOut").click(function () {
        $.ajax({
            url : 'loginOut',
            type : 'get',
            cache : false,
            processData : false,
            contentType : false,
            success : function (data) {
                if(data.code == 200){
                    window.location.href = data.url;
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
                if(result.code==200){
                    window.location.href="index";
                }
                alert(result.msg);
            },
            error : function (result) {
                alert(result.msg);
            }
        })
    })
})

function on_return() {
    if (window.event.keyCode == 13) {
        if ($("#loginButton") != null) {
            var user_name = $("#loginModalUserNmae").val();
            var user_password = $("#loginModalUserPwd").val();
            var data = new FormData();
            data.append("user_name", user_name);
            data.append("user_password", user_password);
            $.ajax({
                url: 'login',
                data: data,
                cache: false,
                processData: false,
                contentType: false,
                type: 'post',
                success: function (result) {
                    if (result.code == 200) {
                        window.location.href = "index";
                    }
                    alert(result.msg);
                },
                error: function (result) {
                    alert(result.msg);
                }
            })
        }
    }
}

