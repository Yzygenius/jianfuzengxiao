<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>智慧平安社区社群服务</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/font.css">
	<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/xadmin.css">
	<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/index-icon.css">
    <script type="text/javascript" src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
    <script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/jianfuzengxiao/statics/system/js/xadmin.js"></script>

</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="/jianfuzengxiao/system.html">智慧平安社区社群服务</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <!-- <ul class="layui-nav left fast-add" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">+新增</a>
            <dl class="layui-nav-child"> 二级菜单
              <dd><a onclick="x_admin_show('资讯','http://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
              <dd><a onclick="x_admin_show('图片','http://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
               <dd><a onclick="x_admin_show('用户','http://www.baidu.com')"><i class="iconfont">&#xe6b8;</i>用户</a></dd>
            </dl>
          </li>
        </ul> -->
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">${admin.username }</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <!-- <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
              <dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd> -->
              <dd><a href="/jianfuzengxiao/system/logout.html">退出</a></dd>
            </dl>
          </li>
         <!--  <li class="layui-nav-item to-index"><a href="/jianfuzengxiao/home.html">前台首页</a></li> -->
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
      	<c:if test="${admin.roleId == 1 || admin.roleId == 3}">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <!-- <i class="iconfont">&#xe6b8;</i> -->
                    <span class="iconfont icon-shequ"></span>
                    <cite>基础数据管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                	<li>
                        <a _href="/jianfuzengxiao/system/gwh/toGwhPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管委会管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/community/toCommunityPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>社区管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/communityStreet/toCommunityStreetPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>小区/道路管理</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <!-- <i class="iconfont">&#xe723;</i> -->
                    <span class="iconfont icon-fangwu"></span>
                    <cite>房屋管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/jianfuzengxiao/system/houses/toHousesFwPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>住房管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/houses/toHousesDpPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>商铺管理</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                   <!--  <i class="iconfont">&#xe723;</i> -->
                   <span class="iconfont icon-renyuanguanli"></span>
                    <cite>人员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                	<c:if test="${admin.roleId == 1}">
                	<li>
                        <a _href="/jianfuzengxiao/system/admin/toLgzgManagePage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>流管专干管理</cite>
                        </a>
                    </li >
                    </c:if>
                    <li>
                        <a _href="/jianfuzengxiao/system/admin/toAdminPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>包户干部管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/per/toPerPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>社区人员管理</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <!-- <i class="iconfont">&#xe723;</i> -->
                    <span class="iconfont icon-shenhe"></span>
                    <cite>人员审核</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                	<%-- <li>
                        <a _href="/jianfuzengxiao/system/user/toUserPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员认证</cite>
                        </a>
                    </li > --%>
                    <li>
                        <a _href="/jianfuzengxiao/system/per/toAuditYezhuPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>房主/店主审核</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/per/toAuditZuhuPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>租户/员工/家属审核</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <!-- <i class="iconfont">&#xe723;</i> -->
                    <span class="iconfont icon-tongji"></span>
                    <cite>统计分析</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/jianfuzengxiao/system/statistics/toIndex.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>上报信息统计</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/statistics/toHouses.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>房屋信息统计</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/statistics/toPersonnel.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>人员信息统计</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
        </c:if>
        
        <c:if test="${admin.roleId == 2}">
        <ul id="nav">
        	<li>
                <a href="javascript:;">
                   <!--  <i class="iconfont">&#xe723;</i> -->
                   <span class="iconfont icon-fangwu"></span>
                    <cite>房屋管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/jianfuzengxiao/system/houses/toHousesFwPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>住房管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/houses/toHousesDpPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>商铺管理</cite>
                        </a>
                    </li>
                </ul>
            </li>
        	<li>
                <a href="javascript:;">
                    <!-- <i class="iconfont">&#xe723;</i> -->
                    <span class="iconfont icon-shenhe"></span>
                    <cite>人员审核</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                	<%-- <li>
                        <a _href="/jianfuzengxiao/system/user/toUserPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员认证</cite>
                        </a>
                    </li > --%>
                    <li>
                        <a _href="/jianfuzengxiao/system/per/toAuditYezhuPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>房主/店主审核</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/per/toAuditZuhuPage.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>租户/员工/家属审核</cite>
                        </a>
                    </li >
                </ul>
            </li>
             <li>
                <a href="javascript:;">
                    <!-- <i class="iconfont">&#xe723;</i> -->
                    <span class="iconfont icon-tongji"></span>
                    <cite>统计分析</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/jianfuzengxiao/system/statistics/toIndex.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>上报信息统计</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/statistics/toHouses.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>房屋信息统计</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/jianfuzengxiao/system/statistics/toPersonnel.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>人员信息统计</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
        </c:if>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home layui-this"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/jianfuzengxiao/system/welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <!-- <div class="footer">
        <div class="copyright"> 备案号   &nbsp;&nbsp;&nbsp;&nbsp;</div>  
    </div> -->
    <!-- 底部结束 -->
</body>
</html>