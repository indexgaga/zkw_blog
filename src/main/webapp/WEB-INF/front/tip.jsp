<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();      //上下文路径，/mldn
    //请求方式                    服务器名，地址                          端口
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/images/icon/icon.png">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/icon/favicon.ico">
    <script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/nprogress.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.lazyload.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/js/html5shiv.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/js/respond.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/js/selectivizr-min.js" type="text/javascript"></script>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<h2>${msg}<a href="${url}">点击跳转</a></h2>


<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ias.js"></script>
<script src="<%=request.getContextPath()%>/js/scripts.scripts.jsp"></script>
<script src="<%=request.getContextPath()%>/js/userAdd.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
