<%@ page import="cn.zkw.vo.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
  String path = request.getContextPath();      //上下文路径，/mldn
  //请求方式                    服务器名，地址                          端口
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>清歌一片文章页面</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/nprogress.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
  <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/images/icon/icon.png">
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/icon/favicon.ico">
  <script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/nprogress.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.qqFace.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.lazyload.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/js/html5shiv.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/js/respond.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/js/selectivizr-min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/back/lib/ueditor/ueditor.parse.js" type="text/javascript"></script>

  <!-- night代码高亮 -->
  <%--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/night/styles/tomorrow-night-eighties.css">--%>
  <%--<script type="text/javascript" src="<%=request.getContextPath()%>/night/highlight.pack.js"></script>--%>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/night/styles/tomorrow-night-eighties.css">
  <script src="<%=request.getContextPath()%>/night/highlight.pack.js"></script>
  <script>hljs.initHighlightingOnLoad();</script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>

<body class="user-select single">
<jsp:include page="head.jsp" />
<section class="container">
  <div class="content-wrap">
    <div class="content">
      <header class="article-header">
        <h1 class="article-title"><a href="article.jsp">${article.article_title}</a></h1>
        <div class="article-meta"> <span class="item article-meta-time">
          <time class="time" data-toggle="tooltip" data-placement="bottom" title="时间：2016-1-4 10:29:39"><i class="glyphicon glyphicon-time"></i> 2016-1-4 10:29:39</time>
          </span> <span class="item article-meta-source" data-toggle="tooltip" data-placement="bottom" title="来源：第一PHP社区"><i class="glyphicon glyphicon-globe"></i> 第一PHP社区</span> <span class="item article-meta-category" data-toggle="tooltip" data-placement="bottom" title="栏目：后端程序"><i class="glyphicon glyphicon-list"></i> <a href="program" title="">后端程序</a></span> <span class="item article-meta-views" data-toggle="tooltip" data-placement="bottom" title="查看：120"><i class="glyphicon glyphicon-eye-open"></i> 共120人围观</span> <span class="item article-meta-comment" data-toggle="tooltip" data-placement="bottom" title="评论：0"><i class="glyphicon glyphicon-comment"></i> 0个不明物体</span> </div>
      </header>
      <article class="article-content1" >
        <%=request.getAttribute("article_content")%>
      </article>
      <div class="article-tags">标签：<a href="" rel="tag">PHP</a></div>
      <div class="relates">
        <div class="title">
          <h3>相关推荐</h3>
        </div>
        <ul>
          <li><a href="article.jsp">php如何判断一个日期的格式是否正确</a></li>
          <li><a href="article.jsp">php如何判断一个日期的格式是否正确</a></li>
          <li><a href="article.jsp">php如何判断一个日期的格式是否正确</a></li>
          <li><a href="article.jsp">php如何判断一个日期的格式是否正确</a></li>
          <li><a href="article.jsp">php如何判断一个日期的格式是否正确</a></li>
          <li><a href="article.jsp">php如何判断一个日期的格式是否正确</a></li>
          <li><a href="article.jsp">php如何判断一个日期的格式是否正确</a></li>
          <li><a href="article.jsp">php如何判断一个日期的格式是否正确</a></li>
        </ul>
      </div>
      <div class="title" id="comment">
        <h3>评论 <small>抢沙发</small></h3>
      </div>
      <!--<div id="respond">
        <div class="comment-signarea">
          <h3 class="text-muted">评论前必须登录！</h3>
          <p> <a href="javascript:;" class="btn btn-primary login" rel="nofollow">立即登录</a> &nbsp; <a href="javascript:;" class="btn btn-default register" rel="nofollow">注册</a> </p>
          <h3 class="text-muted">当前文章禁止评论</h3>
        </div>
      </div>-->
      <div id="respond">
        <form action="<%=request.getContextPath()%>/comment/add" method="post" id="comment-form">
          <div class="comment">
            <div class="comment-title">
              <c:if test="${photo==null}"><img class="avatar" src="<%=request.getContextPath()%>/images/tourist.jpg" alt="" /></c:if>
              <c:if test="${photo!=null}"><img class="avatar" src="<%=request.getContextPath()%>/uploadFiles/userPhoto/${photo}" alt="" /></c:if>
            </div>
            <div class="comment-box">
              <textarea  contenteditable="true" placeholder="您的评论可以一针见血" name="comment_content" id="comment-textarea" cols="100%" rows="3" tabindex="1" ></textarea>
              <div class="comment-ctrl"> <span class="emotion" id="emotion"><img src="images/face/5.png" width="20" height="20" alt="" />表情</span>
                <div class="comment-prompt"> <i class="fa fa-spin fa-circle-o-notch"></i> <span class="comment-prompt-text"></span> </div>
                <input type="hidden" value="1" class="articleid" />
                <button type="submit" name="comment-submit" id="comment-submit" tabindex="5" articleid="1">评论</button>
              </div>
            </div>
          </div>
        </form>
      </div>
      <div id="postcomments">
        <ol class="commentlist" id="commentList">
          <c:forEach items="${listComment}" var="comment" varStatus="status">
            <c:if test="${comment.user_id!=null}">
              <li class="comment-content"><span class="comment-f">#${status.index}</span>
                <div class="comment-avatar"><img class="avatar" src="<%=request.getContextPath()%>/uploadFiles/userPhoto/${comment.user_photo}" alt="" /></div>
                <div class="comment-main">
                  <p><span class="address">${comment.user_name}</span><span class="time"><fmt:formatDate value="${comment.comment_date}" pattern="yyyy-MM-dd HH:mm" /></span><br />
                  <span class="comment_content_p">${comment.comment_content}</span></p>
                </div>
              </li>
            </c:if>
            <c:if test="${comment.user_id==null}">
              <li class="comment-content"><span class="comment-f">#${status.index}</span>
                <div class="comment-avatar"><img class="avatar" src="<%=request.getContextPath()%>/images/tourist.jpg" alt="" /></div>
                <div class="comment-main">
                  <p>来自<span class="address">${comment.user_name}</span>的用户<span class="time"><fmt:formatDate value="${comment.comment_date}" pattern="yyyy-MM-dd HH:mm" /></span><br />
                    <span class="comment_content_p">${comment.comment_content}</span></p>
                </div>
              </li>
            </c:if>
          </c:forEach>
        </ol>
        <%--<div class="quotes"><span class="disabled">首页</span><span class="disabled">上一页</span><a class="current">1</a><a href="">2</a><span class="disabled">下一页</span><span class="disabled">尾页</span></div>--%>
      </div>
    </div>
  </div>
  <aside class="sidebar">
    <div class="fixed">
      <div class="widget widget-tabs">
        <ul class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active"><a href="#notice" aria-controls="notice" role="tab" data-toggle="tab">网站公告</a></li>
          <li role="presentation"><a href="#centre" aria-controls="centre" role="tab" data-toggle="tab">会员中心</a></li>
          <li role="presentation"><a href="#contact" aria-controls="contact" role="tab" data-toggle="tab">联系站长</a></li>
        </ul>
        <div class="tab-content">
          <div role="tabpanel" class="tab-pane notice active" id="notice">
            <ul>
              <li>
                <time datetime="2016-01-04">01-04</time>
                <a href="" target="_blank">欢迎访问异清轩博客</a></li>
              <li>
                <time datetime="2016-01-04">01-04</time>
                <a target="_blank" href="">在这里可以看到前端技术，后端程序，网站内容管理系统等文章，还有我的程序人生！</a></li>
              <li>
                <time datetime="2016-01-04">01-04</time>
                <a target="_blank" href="">在这个小工具中最多可以调用五条</a></li>
            </ul>
          </div>
          <div role="tabpanel" class="tab-pane centre" id="centre">
            <h4>需要登录才能进入会员中心</h4>
            <p> <a href="javascript:;" class="btn btn-primary">立即登录</a> <a href="javascript:;" class="btn btn-default">现在注册</a> </p>
          </div>
          <div role="tabpanel" class="tab-pane contact" id="contact">
            <h2>Email:<br />
              <a href="mailto:admin@ylsat.com" data-toggle="tooltip" data-placement="bottom" title="admin@ylsat.com">admin@ylsat.com</a></h2>
          </div>
        </div>
      </div>
      <div class="widget widget_search">
        <form class="navbar-form" action="/Search" method="post">
          <div class="input-group">
            <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
            <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span> </div>
        </form>
      </div>
    </div>
    <div class="widget widget_sentence">
      <h3>每日一句</h3>
      <div class="widget-sentence-content">
        <h4>2016年01月05日星期二</h4>
        <p>Do not let what you cannot do interfere with what you can do.<br />
          别让你不能做的事妨碍到你能做的事。（John Wooden）</p>
      </div>
    </div>
    <div class="widget widget_hot">
      <h3>热门文章</h3>
      <ul>
        <li><a href=""><span class="thumbnail"><img class="thumb" data-original="images/excerpt.jpg" src="images/excerpt.jpg" alt=""></span><span class="text">php如何判断一个日期的格式是否正确</span><span class="muted"><i class="glyphicon glyphicon-time"></i> 2016-1-4 </span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i> 120</span></a></li>
        <li><a href=""><span class="thumbnail"><img class="thumb" data-original="images/excerpt.jpg" src="images/excerpt.jpg" alt=""></span><span class="text">php如何判断一个日期的格式是否正确</span><span class="muted"><i class="glyphicon glyphicon-time"></i> 2016-1-4 </span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i> 120</span></a></li>
        <li><a href=""><span class="thumbnail"><img class="thumb" data-original="images/excerpt.jpg" src="images/excerpt.jpg" alt=""></span><span class="text">php如何判断一个日期的格式是否正确</span><span class="muted"><i class="glyphicon glyphicon-time"></i> 2016-1-4 </span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i> 120</span></a></li>
        <li><a href=""><span class="thumbnail"><img class="thumb" data-original="images/excerpt.jpg" src="images/excerpt.jpg" alt=""></span><span class="text">php如何判断一个日期的格式是否正确</span><span class="muted"><i class="glyphicon glyphicon-time"></i> 2016-1-4 </span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i> 120</span></a></li>
        <li><a href=""><span class="thumbnail"><img class="thumb" data-original="images/excerpt.jpg" src="images/excerpt.jpg" alt=""></span><span class="text">php如何判断一个日期的格式是否正确</span><span class="muted"><i class="glyphicon glyphicon-time"></i> 2016-1-4 </span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i> 120</span></a></li>
      </ul>
    </div>
  </aside>
</section>
<footer class="footer">
  <div class="container">
    <p>&copy; 2016 <a href="">ylsat.com</a> &nbsp; <a href="#" target="_blank" rel="nofollow">豫ICP备20151109-1</a> &nbsp; &nbsp; <a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
  </div>
  <div id="gotop"><a class="gotop"></a></div>
</footer>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
  <div class="modal-dialog" role="document" style="margin-top:120px;width:280px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="images/weixin.jpg" alt="" style="cursor:pointer"/> </div>
    </div>
  </div>
</div>
<!--该功能正在日以继夜的开发中-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
      </div>
      <div class="modal-body"> <img src="images/baoman/baoman_01.gif" alt="深思熟虑" />
        <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<div id="rightClickMenu">
  <ul class="list-group rightClickMenuList">
    <li class="list-group-item disabled">欢迎访问异清轩博客</li>
    <li class="list-group-item"><span>IP：</span>172.16.10.129</li>
    <li class="list-group-item"><span>地址：</span>河南省郑州市</li>
    <li class="list-group-item"><span>系统：</span>Windows10</li>
    <li class="list-group-item"><span>浏览器：</span>Chrome47</li>
  </ul>
</div>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ias.js"></script>
<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.qqFace.js"></script>
<script type="text/javascript">
$(function(){
	$('.emotion').qqFace({
		id : 'facebox', 
		assign:'comment-textarea', 
		path:'<%=request.getContextPath()%>/images/arclist/'	//表情存放的路径
	});

  uParse('.article-content1', {
    rootPath: '../'
  })
 });

var allpre = document.getElementsByTagName("pre");
for(i = 0; i < allpre.length; i++)
{
  var onepre = document.getElementsByTagName("pre")[i];
  var mycode = document.getElementsByTagName("pre")[i].innerHTML;
  onepre.innerHTML = '<code id="mycode">'+mycode+'</code>';
}

//qqface 评论中显示表情
var comment_content = $(".comment_content_p");
$.each(comment_content,function (n) {
  // alert(($(this).search(']')));
  if(($(this).text().search(']')>=0)){
    $(this).html(replace_em($(this).text()));
  }
})
//字符串替换,,插入图片,显示表情
function replace_em(str) {
  var start = str.indexOf("[");
  var ent = str.indexOf("]");
  var em = str.substring(start,ent+1);
  var em_end = em.indexOf("]");
  var em_id = em.substring(4,em_end);
  str = str.replace(em,"<img src='<%=request.getContextPath()%>/images/arclist/"+em_id+".gif'>");
  return str;
}

<%--// qqface--%>
<%--$(function(){--%>
  <%--$("#comment-textarea").bind(--%>
          <%--'input',function(){  //兼容IE9及以上版本和其他浏览器--%>
            <%--console.log('value changed!');--%>
          <%--});--%>

  <%--$('.emotion').qqFace({--%>

    <%--id : 'facebox',--%>

    <%--assign:'comment-textarea',--%>

    <%--path:'<%=request.getContextPath()%>/images/arclist/'        //表情存放的路径--%>

  <%--});--%>

  <%--$(".emotion").click(function(){--%>

    <%--var str = $("#comment-textarea").val();--%>
    <%--console.log(str);--%>

    <%--$("#comment-textarea").html(replace_em(str));--%>

  <%--});--%>

<%--});--%>

<%--//查看结果--%>

<%--function replace_em(str){--%>

  <%--str = str.replace(/\</g,'<');--%>

  <%--str = str.replace(/\>/g,'>');--%>

  <%--str = str.replace(/\n/g,'<br/>');--%>

  <%--str = str.replace(/\[em_([0-9]*)\]/g,'<img src="arclist/$1.gif" border="0" />');--%>

  <%--return str;--%>
<%--}--%>
</script>
</body>
</html>