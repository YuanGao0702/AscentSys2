<%@ page language="java" import="hibernate.po.Productuser" contentType="text/html;charset=gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>ascent</title>
<meta http-equiv="content-type" content="text/html; charset=GB2312" />
<meta name="description" content="Your website description goes here" />
<meta name="keywords" content="your,keywords,goes,here" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/acesys.js"></script>
</head>

<body>
<div id="container" >
<div id="header">
</div>
<div id="navigation">
<ul>
<li class="selected"></li>
<li><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
<li><a href="<%=request.getContextPath()%>/product/itservice.jsp">IT服务</a></li>
<li><a href="<%=request.getContextPath()%>/product/products.jsp">电子商务系统</a></li>
<li><a href="<%=request.getContextPath()%>/product/employee.jsp">员工招聘</a></li>
<li><a href="<%=request.getContextPath()%>/product/ContactUs.jsp">关于我们</a></li>
<li></li>
</ul>
</div>

<div id="content"> 
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td>我的位置 &gt;&gt; 电子商务管理</td>
    </tr>
    <tr>
      <td><hr noshade="noshade" /></td>
    </tr>
    <tr>
      <td>商品信息</td>
    </tr>
  </table>
  <br />
  <div class="md_wenzi"> astaTech， Inc.提供全世界配药，生物科技和agroche mical药物研究&amp;发展的先进和新颖的中间体。
    我们的编目是最新与1500年药物象产品。 超过五十种新的化合物每个月增加到产品名单。我们先进的中间体的宽广的类型，
    包括积木，新颖的胺物、被保护的胺物、不自然的氨基酸、酮、醋醛、heterocycles、isatoic酐、boroinc酸和手性
    的中间体可能加速您的药物研究过程。AstaTech也提供半大块中间体(10公斤)，大块中间体(对吨)，使原材料和他们的
    中间体服麻醉剂进入合理的价格和优良品质。 
    请参观<a href="<%=request.getContextPath()%>/product.action?a=all">浏览产品页</a>。<br />
    编目可以在网上被观看或者由<a href="<%=request.getContextPath()%>/product/Product_Search.jsp">查询产品浏览产品</a> 或您喜欢电子上接受我们的编目的(以PDF或SD格式)，请电子邮件我们. </div>
  <p>&nbsp;</p>
</div><div id="subcontent">

<form name="form" method="post" action="<%=request.getContextPath()%>/login.action?a=login">
  <div class="small box">
  	<%
			Productuser p =(Productuser)session.getAttribute("productuser");
			if(p==null){
		%>
    <table width="150" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="30%" colspan="2" valign="middle"><img src="<%=request.getContextPath()%>/images/username.jpg" width="61" height="17" align="bottom" />
            <input name="username" type="text" size="7"/>        </td>
      </tr>
      <tr>
        <td colspan="2" valign="middle"><img src="<%=request.getContextPath()%>/images/password.jpg" width="61" height="17" />
            <input name="password" type="password" size="6" /></td>
      </tr>
      <tr>
        <td height="30" valign="bottom">点击这里<a href="<%=request.getContextPath()%>/product/register.jsp">注册</a></td>
        <td align="left" valign="bottom"><a href="#">
          <input name="image" type="image" onclick="return checkLogin(form);" src="<%=request.getContextPath()%>/images/login_1_7.jpg" alt="登录" width="44" height="17" border="0"/>
        </a></td>
      </tr>
      <tr>
        <td colspan="2" valign="bottom">&nbsp;</td>
      </tr>
    </table>
    <%
			}
			else{
		%>
	 <table width="150" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="30%" colspan="2" valign="middle">欢迎您，<%=p.getUsername()%></td>
      </tr>
      <tr>
        <td colspan="2" valign="middle">邮箱：<%=p.getEmail()%></td>
      </tr>
      <tr>
        <td height="30" valign="bottom"><span class="big_k">
          <a href="<%=request.getContextPath()%>/login.action?a=out">注销</a>
        </span></td>
        <% if(p.getSuperuser().equals("3")){%>
		 <td align="left" valign="bottom"></td>
		<%}}%>
       
      </tr>
      <tr>
        <td colspan="2" valign="bottom">&nbsp;</td>
      </tr>
    </table>	
		
  </div>
</form>
  <h2>最新商品列表</h2>
  <ul class="menublock">
    <li><a href="#">项目实战精解</a><a href="#"><img src="<%=request.getContextPath()%>/images/buy.gif" width="20" height="16" border="0"/></a></li>
    <li><a href="#">java核心技术</a><a href="#"><img src="<%=request.getContextPath()%>/images/buy.gif" width="20" height="16" border="0"/></a></li>
    </ul>
  </div>
<div id="footer">
<p><a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司 &copy;2004-2008|京ICP备05005681</a><a href="#"></a></p>
</div>
</div>
<body>
</html>
