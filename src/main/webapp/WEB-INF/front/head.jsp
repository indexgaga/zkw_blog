<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <ul class="site-nav topmenu">
                    <li><a href="tags.jsp">标签云</a></li>
                    <li><a href="readers.jsp" rel="nofollow">读者墙</a></li>
                    <li><a href="links.jsp" rel="nofollow">友情链接</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" rel="nofollow">关注本站 <span class="caret"></span></a>
                        <ul class="dropdown-menu header-topbar-dropdown-menu">
                            <li><a data-toggle="modal" data-target="#WeChat" rel="nofollow"><i class="fa fa-weixin"></i> 微信</a></li>
                            <li><a href="#" rel="nofollow"><i class="fa fa-weibo"></i> 微博</a></li>
                            <li><a data-toggle="modal" data-target="#areDeveloping" rel="nofollow"><i class="fa fa-rss"></i> RSS</a></li>
                        </ul>
                    </li>
                </ul>
                <c:if test="${name==null}"><a data-toggle="modal" data-target="#loginModal" class="login" rel="nofollow">Hi,请登录</a></c:if>
                <c:if test="${name!=null}">欢迎您_<a href="" style="color: #4CC3FF">${name}</a>&nbsp;&nbsp;&nbsp;<a id="loginOut">注销</a></c:if>
                &nbsp;&nbsp;<a href="userAdd"  class="register" rel="nofollow" >我要注册</a>&nbsp;&nbsp;<a href="" rel="nofollow">找回密码</a> </div>

            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <h1 class="logo hvr-bounce-in"><a href="" title=""><img src="<%=request.getContextPath()%>/images/logo.png" alt=""></a></h1>
            </div>
            <div class="collapse navbar-collapse" id="header-navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden-index active"><a data-cont="异清轩首页" href="index.jsp">异清轩首页</a></li>
                    <li><a href="category.jsp">前端技术</a></li>
                    <li><a href="category.jsp">后端程序</a></li>
                    <li><a href="category.jsp">管理系统</a></li>
                    <li><a href="category.jsp">授人以渔</a></li>
                    <li><a href="category.jsp">程序人生</a></li>
                </ul>
                <form class="navbar-form visible-xs" action="/Search" method="post">
                    <div class="input-group">
                        <input type="text" name="keyword" class="form-control" placeholder="请输入关键字" maxlength="20" autocomplete="off">
                        <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span> </div>
                </form>
            </div>
        </div>
    </nav>
</header>
<script src="<%=request.getContextPath()%>/js/index.js"></script>