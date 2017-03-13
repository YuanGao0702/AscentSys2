<%@ page language="java" import="java.util.*,hibernate.po.*" contentType="text/html;charset=gb2312"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>AscentWeb电子商务</title>
		<link rel="stylesheet" href="<%=path%>/css/andreas08(blue).css"
			type="text/css" media="screen,projection" />
	</head>

	<body>

		<div id="container">

			<div id="header">

			</div>

			<div id="navigation">
				<ul>
					<li class="selected"></li>
					<li>
						<a href="<%=path%>/index.jsp">首页</a>
					</li>
					<li>
						<a href="<%=path%>/product/itservice.jsp">IT服务</a>
					</li>
					<li>
						<a href="<%=path%>/product/products.jsp">电子商务系统</a>
					</li>
					<li>
						<a href="<%=path%>/product/employee.jsp">员工招聘</a>
					</li>
					<li>
						<a href="<%=path%>/product/ContactUs.jsp">关于我们</a>
					</li>
					<li></li>
				</ul>
			</div>

			<div id="content2">
				<table width="100%" height="41" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td width="15" height="18" align="left" valign="top">
							<div align="left"></div>
						</td>
						<td width="385" align="left" valign="bottom" class="12">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td height="4" colspan="2" align="left" valign="bottom"></td>
					</tr>

					<tr>
						<td height="15" align="left" valign="top">
							&nbsp;
						</td>
						<td height="15" align="left" valign="top" class="12">
							<table width="100%" height="20" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="20">
										<div class="right_proaducts">
											我的位置&gt;&gt;电子商务管理&gt;订单&gt;订单查看
											<br />
											<br />
										</div>

										<table cellspacing="0" cellpadding="0" width="100%" border="0">
											<tbody>
												<tr>
													<%
														String orderid = (String)session.getAttribute("orderid");
														Productuser p = (Productuser)session.getAttribute("productuser");
														if(p!=null&&p.getSuperuser().equals("3")){  //管理员
													%>
															<td width="33%">
																<div align="left">
																	|&nbsp;&nbsp;欢迎,<%=p.getUsername() %>&nbsp;&nbsp;|<a href="<%=path%>/login.action?a=out" class="table_t">注销</a>|<a href="javascript:history.back()"><<< 返回</a>
																</div>
															</td>
															<td>
																<div align="center">
																	<a href="<%=path%>/product.action?a=all"><img src="<%=path%>/images/productslist.jpg" width="75" height="17" border="0"/></a>
																</div>
															</td>
															<td>
																<div align="center">
																	<a href="<%=path%>/order.action?a=all">订单管理</a>
																</div>
															</td>
															<td height="50">
																<div align="center">
																	&nbsp;
																</div>
															</td>
													<%
														} else if(p!=null&&p.getSuperuser().equals("1")){  //注册用户
													%>
															<td width="33%">
																<div align="left">
																	|&nbsp;&nbsp;欢迎,<%=p.getUsername() %>&nbsp;&nbsp;|<a href="<%=path%>/login.action?a=out" class="table_t">注销</a>|<a href="javascript:history.back()"><<< 返回</a>
																</div>
															</td>
															<td>
																<div align="center">
																	&nbsp;
																</div>
															</td>
															<td>
																<div align="center">
																	<a href="<%=path%>/product/Product_Search.jsp">商品查询</a>
																</div>
															</td>
															<td>
																<div align="center">
																	<a href="<%=path%>/order.action?a=all">订单管理</a>
																</div>
															</td>
															<td height="50">
																<div align="center">
																	<a href="<%=path%>/shopcart.action?a=find">查看购物车</a>
																</div>
															</td>
													<%
														} else if(p==null){  //未注册用户
													%>
															<td width="33%">
																<div align="left">
																	|&nbsp;&nbsp;欢迎,<%=p.getUsername() %>&nbsp;&nbsp;|<a href="<%=path%>/login.action?a=out" class="table_t">注销</a>|<a href="javascript:history.back()"><<< 返回</a>
																</div>
															</td>
															<td>
																<div align="center">
																	&nbsp;
																</div>
															</td>
															<td>
																<div align="center">
																	&nbsp;
																</div>
															</td>
															<td>
																<div align="center">
																	<a href="<%=path%>/order.action?a=all">订单管理</a>
																</div>
															</td>
															<td height="50">
																<div align="center">
																	<a href="<%=path%>/shopcart.action?a=find">查看购物车</a>
																</div>
															</td>
													<%
														}
													%>
												</tr>
											</tbody>
										</table>
									
											<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">编号</div></td>
    <td><div align="center">名称</div></td>
    <td><div align="center">catalogno</div></td>
    <td><div align="center">MDLNumber</div></td>
    <td><div align="center">价格</div></td>
    <td><div align="center">库存</div></td>
    <td><div align="center">图片</div></td>
 <%
 if(p!=null&&p.getSuperuser().equals("3")){//管理员
  %>
    <td><div align="center">删除</div></td>
 <%} %>
  </tr>
  <% 
  List list= (List)session.getAttribute("orderitemlist");
    Iterator its= list.iterator();
    while(its.hasNext())
    {
       Orderitem oi = new Orderitem();
       oi= (Orderitem)its.next();
       Product pu = oi.getProduct();
       if(pu != null) {
       int pid= pu.getPid();
 %>
    <tr bgcolor="#f3f3f3" height="25"> 
    <td width="10%"><div align="center"><%=pu.getProductId()%></div></td>
    <td width="13%"><div align="center"><%=pu.getProductname()%></div></td>
   <td width="12%"><div align="center"><%=pu.getCatalogno()%></div></td>
    <td width="13%"><div align="center"><%=pu.getMdlnumber()%></div></td>
    <td width="10%"><div align="center"><%=pu.getPrice1()%></div></td>
    <td width="13%"><div align="center"><%=pu.getStock()%></div></td>
     <%if(pu.getStructure()==null||pu.getStructure().equals(""))
    {
    %>
     <td width="12%"><div align="center"><img src="<%=request.getContextPath()+"/upload/23007.gif"%>" width="60" height="30" hspace="0" border="0"/></div></td>
    <%
    }else
    {
     %>
     <td width="12%"><div align="center"><img src="<%=request.getContextPath()+"/upload/"+pu.getStructure()%>" width="60" height="30" hspace="0" border="0"/></div></td>
    <%
    }%>
 <%
 if(p!=null&&p.getSuperuser().equals("3")){  //管理员
  %>   
    <td><div align="center"><a href="<%=request.getContextPath()%>/order.action?a=delitem&pid=<%=pid%>&oid=<%=orderid%>" >删除</a></div></td>
  <%}%>   
  </tr>
 <%}} %>
</table>   
									</td>
								</tr>
							</table>
							<br />
							<div class="table_wz"></div>
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
