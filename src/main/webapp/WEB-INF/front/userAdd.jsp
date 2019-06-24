<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>注册</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/images/icon/icon.png">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/icon/favicon.ico">
    <script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/nprogress.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.lazyload.min.js"></script>
    <!--[if gte IE 9]>
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/js/html5shiv.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/js/respond.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href='upgrade-browser.html';</script>
    <![endif]-->
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style>
        label {
            font-weight: 200;
        }
    </style>
</head>

<body>
    <jsp:include page="head.jsp" flush="true"></jsp:include>
    <div class="container">
        <form class="form-signin" action="addUser" method="post" style="width:30em;margin:auto">
            <h2 class="form-signin-heading" style="color:#4CC3FF">注册</h2>
            <div id="user_nickname_div">
                <label for="user_nickname">昵称</label>
                <input style="display:inline" type="text" id="user_nickname" name="user_nickname" class="form-control" placeholder="昵称" required autofocus>
            </div><br>
            <div id="user_name_div">
                <label for="user_name">账号</label>
                <input type="text" id="user_name" name="user_name" class="form-control" maxlength="15" minlength="4" class="form-control" placeholder="账号" required autofocus>
                <span id="user_name_msg"></span>
            </div><br>

            <div id="user_password_div">
                <label for="user_password">请输入密码</label>
                <input type="password" id="user_password" name="user_password" class="form-control" maxlength="15" minlength="6" placeholder="请输入密码" onKeyUp="pwStrength(this.value)" onBlur="pwStrength(this.value)" required>
                <span id="user_password_msg"></span>
                <table width="217" border="1" cellspacing="0" cellpadding="1" bordercolor="#cccccc" height="23" style='display:inline'>
                    <tr align="center" bgcolor="#eeeeee">
                    <td width="33%" id="strength_L">弱</td>
                    <td width="33%" id="strength_M">中</td>
                    <td width="33%" id="strength_H">强</td>
                    </tr>
                </table>
            </div><br>

            <div id="user_password2_div">
                <label for="user_password2">请输再次入密码</label>
                <input type="password" id="user_password2" class="form-control" maxlength="15" minlength="6" placeholder="请再次输入密码" required>
                <span id="user_password2_msg"></span>
            </div><br>

            <div id="user_birthday_div">
                <label for="user_birthday">出生日期</label><br>
                <input type="date" id="user_birthday" name="user_birthday" value="1998-01-01"/>
            </div><br>

            <button class="btn btn-lg btn-primary btn-block" type="submit" id="registBut">注册</button>
        </form>

    </div>

    <!--登录注册模态框-->
    <%--<div class="modal fade user-select" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">--%>
        <%--<div class="modal-dialog" role="document">--%>
            <%--<div class="modal-content">--%>
                <%--<form action="" method="post">--%>
                    <%--<div class="modal-header">--%>
                        <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                        <%--<h4 class="modal-title" id="loginModalLabel">登录</h4>--%>
                    <%--</div>--%>
                    <%--<div class="modal-body">--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="loginModalUserNmae">用户名</label>--%>
                            <%--<input type="text" class="form-control" id="loginModalUserNmae" placeholder="请输入用户名" autofocus maxlength="15" autocomplete="off" required>--%>
                        <%--</div>--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="loginModalUserPwd">密码</label>--%>
                            <%--<input type="password" class="form-control" id="loginModalUserPwd" placeholder="请输入密码" maxlength="18" autocomplete="off" required>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="modal-footer">--%>
                        <%--<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>--%>
                        <%--<button id="loginButton" type="button" class="btn btn-primary" >登录</button>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <!-- /container -->


    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.ias.js"></script>
    <script src="<%=request.getContextPath()%>/js/scripts.scripts.jsp"></script>
    <script src="<%=request.getContextPath()%>/js/userAdd.js"></script>
</body>

</html>