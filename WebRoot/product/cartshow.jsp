<%@ page language="java" import="java.util.*,hibernate.po.*" contentType="text/html;charset=gb2312"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
 <head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>AscentWeb电子商务</title>
		<link rel="stylesheet" href="<%=path%>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
<script language="javascript">
 function updateQuantity(obj,str,str2){
   var pid = str;
   var quantity = obj.value;
   var realstock = str2;
   var reg = /[1-9][0-9]*/;
   if( quantity == "" )
   {
   		alert("购买数量不能为空！");
   		location.reload();
	    number.focus();
        return false;
   }
   if( quantity !="" && !quantity.match(reg) )
   		 {
     		alert("购买数量必须为大于0数字，检查后重新输入！");
	     	location.reload();
	     	number.focus();
            return false;
   		 }  
   send_request("<%=request.getContextPath()%>/shopcart.action?a=updateNum&pid="+pid+"&quantity="+quantity+"&realstock="+realstock);
  } 
  
  var http_request = false;
	function send_request(url)
	{ //初始化、指定处理函数、发送请求的函数
		http_request = false;
		//开始初始化XMLHttpRequest对象
		if(window.XMLHttpRequest) 
		{ //Mozilla 浏览器
			http_request = new XMLHttpRequest();
			if(http_request.overrideMimeType) 
			{//设置MiME类别
				http_request.overrideMimeType('text/xml');
			}
		}
		else if(window.ActiveXObject) 
		{ // IE浏览器
			try 
			{
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			} 
			catch(e) 
			{
				try 
				{
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch(e){}
			}
		}
		if(!http_request) 
		{ // 异常，创建对象实例失败
			window.alert("不能创建XMLHttpRequest对象实例.");
			return false;
		}
		http_request.onreadystatechange = processRequest;
		// 确定发送请求的方式和URL以及是否同步执行下段代码
		http_request.open("POST", url, true);
		http_request.send(null);
	}
	// 处理返回信息的函数
    function processRequest() 
    {
        if (http_request.readyState == 4) 
        { // 判断对象状态
            if (http_request.status == 200) 
            { // 信息已经成功返回，开始处理信息
               var divhtml = http_request.responseText;
			   alert(divhtml);
			   location.reload();
            }
        }
       
   } 
</script>
</head>

<body>
			<div id="container">
               <div id="header"></div>
                 <div id="navigation">
					<ul>
						<li class="selected"></li>
						<li><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
						<li><a href="<%=request.getContextPath()%>/product/itservice.jsp">IT服务</a></li>
						<li><a href="<%=request.getContextPath()%>/product/products.jsp">电子商务系统</a></li>
						<li><a href="<%=request.getContextPath()%>/product/employee.jsp">员工招聘</a></li>
						<li><a href="<%=request.getContextPath()%>/product/ContactUs.jsp">关于我们</a></li>	
					</ul>
				  </div>

				<div id="content2">
					<table width="100%" height="41" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="15" height="18" align="left" valign="top"><div align="left"></div></td>
							<td width="385" align="left" valign="bottom" class="12">&nbsp;</td>
						</tr>
						<tr>
							<td height="4" colspan="2" align="left" valign="bottom"></td>
						</tr>
						<tr>
							<td height="15" align="left" valign="top">&nbsp;
							</td>
							<td height="15" align="left" valign="top" class="12">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr> 
<%
	Productuser p = (Productuser)session.getAttribute("productuser");
	if(p!=null&&p.getSuperuser().equals("3")){  //管理员
	
%>
<td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,<%=p.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/login.action?a=out" class="table_t">注销</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:history.go(-1)"><<< 返回</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=all"><img src="<%=request.getContextPath()%>\images\productslist.jpg" width="75" height="17" border="0"/></a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/order.action?a=all">订单管理</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=all">继续购物</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/shopcart.action?a=checkout">结算中心</a></div></td>
<%}
	else if(p==null){  //未注册用户
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,游客&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/register.jsp" class="table_t">注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:history.go(-1)"><<< 返回</a></div></td>
<td width="20%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=all">继续购物</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/shopcart.action?a=checkout">结算中心</a></div></td>

<%}
	else{  //刚注册用户
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,<%=p.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/login.action?a=out" class="table_t">注销</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:history.go(-1)"><<< 返回</a></div></td>
<td width="20%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>\order.action?a=all">查看订单</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=all">继续购物</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/shopcart.action?a=checkout">结算中心</a></div></td>
<%}%>
</tr>
</table>
<br><br>	

<!-- 产品列表 --> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">编号</div></td>
    <td><div align="center">名称</div></td>
    <td><div align="center">catalogno</div></td>
    <td><div align="center">库存(g)</div></td>
    <td><div align="center">质量(g)</div></td>
    <td><div align="center">删除</div></td>
  </tr>
 
  <%
 
    Collection list= (Collection)session.getAttribute("shopcartlist");
    Iterator its= list.iterator();
    while(its.hasNext())
    {
      Product pu = new Product();
       pu= (Product)its.next();
       int id= pu.getPid();
       String num = pu.getQuantity();
       String realstock = pu.getRealstock();
       %>
    <tr bgcolor="#f3f3f3" height="25"> 
    <td width="10%"><div align="center"><%=pu.getProductId()%></div></td>
    <td width="13%"><div align="center"><%=pu.getProductname()%></div></td>
    <td width="12%"><div align="center"><%=pu.getCatalogno()%></div></td>
    <td width="13%"><div align="center"><%=pu.getRealstock()%></div></td>
   <%if (num==null||num.equals("") || (num != null && Integer.parseInt(num) > Integer.parseInt(realstock))){
    %>
     <td width="13%"><div align="center"><input name="number" value="5" onchange="updateQuantity(this,<%=id%>,<%=realstock%>)" /></div></td>
    <%
     }else{%>
      <td width="13%"><div align="center"><input name="number" value="<%=num%>" onchange="updateQuantity(this,<%=id%>,<%=realstock%>)" /></div></td>
     <%} 
     %>
    <td width="13%"><div align="center"><a href="<%=request.getContextPath()%>/shopcart.action?a=move&pid=<%=id%>">删除</a></div></td>
 </tr>
 <%}%>
  
 
</table>   
	</td>
						</tr>
					</table>
				  </div>
				  
				 <div id="footer">
					<p>
						<a href="http://www.ascenttech.com.cn/" target="_blank">版权所有：北京亚思晟商务科技有限公司
							&copy;2004-2008|京ICP备05005681</a>
					</p>
				</div>
  

</div>
</body>
</html>
