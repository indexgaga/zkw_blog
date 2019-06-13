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
    <title>Bootstrap 101 Template</title>
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
    <!--[if lt IE 9]>
    <![endif]-->
    <style>
        .row{
            width:20%;
            margin-left:30%;
            margin-top: 20px;
        }

        h3{
            color: #5F5F5F;
        }
    </style>
    <script type="text/javascript">
        function edit() {        　
            var oldhtml = document.getElementById("user_name").innerHTML; //获得元素之前的内容    
            var element = document.getElementById("user_name");       　
            var newobj = document.createElement('input'); //创建一个input元素               　
            newobj.type = 'text'; //为newobj元素添加类型
            newobj.value = oldhtml;　
            element.innerHTML = '';　　 //设置元素内容为空               　
            element.appendChild(newobj); //添加子元素               　
            newobj.focus(); //获得焦点
                //设置newobj失去焦点的事件               　
            newobj.onblur = function () {
                //下面应该判断是否做了修改并使用ajax代码请求服务端将id与修改后的数据提交
            //alert(element.id);
                    //当触发时判断newobj的值是否为空，为空则不修改，并返回oldhtml
            //element.innerHTML = this.value ? this.value : oldhtml;
                if(this.value==null || this.value==""){
                    element.innerHTML = oldhtml;
                }else if(this.value==oldhtml){
                    element.innerHTML = oldhtml;
                }else{
                    var user_nickname = this.value;
                    $.ajax({
                        url : 'updateUserName?user_nickname='+user_nickname,
                        type : 'put',
                        dataType : 'json',
                        data : {
                            //user_nickname:user_nickname
                        },
                        success : function (data) {
                            if(data.code == 200){
                                element.innerHTML = newobj.value;
                            }else{
                                alert("修改失败");
                            }
                        },
                        error : function (data) {
                            alert("修改失败");
                        }
                    })
                }
            }
        }

        function sex_Edit(){
            var select_sex = $("#user_sex").val();
            $.ajax({
                url : "updateSex?user_sex="+select_sex,
                type : "put",
                dataType : "json",
                success : function (data) {
                    if(data.code==200){
                    }else{
                        alert("修改失败");
                    }
                },
                error : function (data) {
                    alert("修改失败");
                }
            })
        }

        function birthday_edit(){
            var birthday = $("#user_birthday").val();
            $.ajax({
                url : "updateBirthday?user_birthday="+birthday,
                type : "put",
                dataType : "json",
                success : function (data) {
                    if(data.code==200){

                    }else if(data.code==304){
                        alert("更新失败");
                    }
                },
                error : function () {
                    if(data.code==304){
                        alert("更新失败");
                    }
                }
            })
        }
        </script>
</head>

<body>
<jsp:include page="head.jsp" flush="true"/>
    <div class="container-fluid">
        <div class="row">
            <img src="<%=request.getContextPath()%>/uploadFiles/userPhoto/${user.user_photo}" alt="..." class="img-circle img-responsive" >
        </div>
        <div class="row">
            <div class="col-xs-12" style="width:300em;"><h3 >等级: <span>13</span></h3></div>
            <div></div>
        </div>
        <div class="row">
            <div class="col-xs-12" style="width:300em"><h3>账号: <span>${user.user_name}</span></h3></div>
        </div>
        <div class="row">
            <div class="col-xs-12" style="width:300em"><h3>昵称: <span id="user_name">${user.user_nickname}</span> <span id="pencil" onclick="edit()" class="glyphicon glyphicon-pencil" aria-hidden="true"></span></h3></div>
        </div>
        <div class="row">
            <div class="col-xs-12" style="width:300em"><h3>年龄: <span>${user_age}</span></h3></div>
        </div>
        <div class="row">
            <div class="col-xs-12" style="width:300em"><h3>性别: <span>
                <select id="user_sex" style="font-size:80%;height:30px" onchange="sex_Edit()">
                    <option value="2" <c:if test="${user.user_sex==2}">selected="selected"</c:if>>男</option>
                    <option value="1" <c:if test="${user.user_sex==1}">selected="selected"</c:if>>女</option>
                </select>
            </span></h3></div>
        </div>
        <div class="row">
            <div class="col-xs-12" style="width:300em"><h3>生日: <span><input type="date" id="user_birthday" onchange="birthday_edit()" value="${birthday}" style="font-size:70%"></span></h3></div>
        </div>
    </div>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ias.js"></script>
<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
</body>

</html>