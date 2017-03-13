<%@ page language="java" import="java.util.*,hibernate.po.*" pageEncoding="GB2312" %>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb电子商务</title>
<link rel="stylesheet" href="<%=path%>/css/andreas08(blue).css" type="text/css" media="screen,projection" />

</head>
<body>
 <form name="form" method="post" action="">
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
							<td height="4" colspan="2" align="left" valign="bottom"></td>
						</tr>
						<tr>
							<td height="15" align="left" valign="top">&nbsp;
							</td>
							<td height="15" align="left" valign="top" class="12">
							 <table width="100%" height="20" border="0" cellpadding="0"cellspacing="0">
								<tr><td height="20">
								<div class="right_proaducts">我的位置&gt;&gt;电子商务管理&gt;商品列表</div>
								<br />
														<%
															Productuser p = (Productuser)session.getAttribute("productuser");
															if(p!=null&&p.getSuperuser().equals("3")){
														%>
									<table width="100%">
										<tbody>
										<tr>
											<td height="20" width="30%" >
											<div class="table_t">|&nbsp;&nbsp;欢迎,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
												<a href="<%=path%>/login.action?a=out" class="table_t">注销</a>&nbsp;&nbsp;|</div>
											</td>
											<td width="70%">
											<div><a href="<%=path%>/user.action?a=all"><img src="<%=path%>/images/userlist.jpg" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											     <a href="<%=path%>/product.action?a=all"><img src="<%=path%>/images/productslist.jpg" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 <a href="<%=path%>/order.action?a=all"><img src="<%=path%>/images/ShowOrders.jpg" border="0" /></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 <a href="<%=path%>/product/add_products_admin.jsp"><img src="<%=path%>/images/addProduct.jpg" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</div>
											</td>
										</tr>
																<!-- 产品列表 -->
									  </tbody>
									</table>
									<table class="mars" cellspacing="1" cellpadding="0" width="100%" border="0">
									  <tbody>
										<tr bgcolor="#fba661" height="30">
										   <td><div align="center">编号</div></td>
										   <td><div align="center">名称</div></td>
										    <td><div align="center">catalogno</div></td>
										    <td><div align="center">MDLNumber</div></td>
										    <td><div align="center">价格</div></td>
											<td><div align="center">库存</div></td>
											<td><div align="center">图片</div>
											</td><td><div align="center">修改</div></td>
											<td><div align="center">删除</div></td>
										</tr>		
							         <% 	List list= (ArrayList)session.getAttribute("productlist");
										    Iterator its= list.iterator();
										    while(its.hasNext())
										    {
										       Product pu = new Product();
										       pu= (Product)its.next();
										       int id= pu.getPid();
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
										    <td><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=updateProduct&pid=<%=id%>"><img src="<%=request.getContextPath()%>\images\update1.gif" width="20" height="20" border="0" alt="修改"/></a></div></td>
										    <td><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=del&pid=<%=id%>" onclick="return confirm_oper();"><img src="<%=request.getContextPath()%>\images\sz_tu02.gif" border="0" alt="删除"/></a></div></td>
										  </tr>
										 <%}%>				
																			  </tbody>
							        </table>
														<%
															} else {	//最上面的if的else
														%>
																<br/><br/><br/><br/><br/><br/>
																<center><h3>对不起，您没有权限查看！！！</h3></center>
																<br/><br/><br/><br/><br/><br/>
																<br/><br/><br/><br/><br/><br/>
														<%
															}
														%>    
													
											
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
		</form>
	</body>
</html>