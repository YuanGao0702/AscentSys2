<%@ page language="java"
	import="java.util.*,hibernate.po.Productuser" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>AscentWeb电子商务</title>
		<link rel="stylesheet" href="<%=path%>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
	</head>

	<body>
		<form name="form" method="post" action="">
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
				<%
					Productuser p = (Productuser) session.getAttribute("productuser");
					if (p != null && p.getSuperuser().equals("3")) {
				%>
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
											<div class="table_t">
												|&nbsp;&nbsp;欢迎,
												<%=p.getUsername()%>
												&nbsp;&nbsp;|&nbsp;&nbsp;
												<a href="<%=path%>/login.action?a=out" class="table_t">注销</a>&nbsp;&nbsp;|
											</div>
										</td>
										<td>
										<div>
										<a href="<%=path%>/user.action?a=all"><img src="<%=path%>/images/userlist.jpg" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="<%=path%>/product.action?a=all"><img src="<%=path%>/images/productslist.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="<%=path%>/product/mailmanager.jsp"><img src="<%=path%>/images/mailmanager.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									    </div>
										</td>
									</tr>
								</table>
								<br />
								
								<table width="100%" border="0" cellspacing="1" cellpadding="0"
									class="mars">
									<tr bgcolor="#fba661" height="25">
										<td width="10%" bgcolor="#fba661">
											<div align="center">
												用户名
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												Email
											</div>
										</td>
										<td width="12%" bgcolor="#fba661">
											<div align="center">
												电话
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												公司名称
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												角色
											</div>
										</td>
										<td width="9%" bgcolor="#fba661">
											<div align="center">
												修改
											</div>
										</td>
										<td width="10%" bgcolor="#fba661">
											<div align="center">
												角色修改
											</div>
										</td>
										<td width="10%" bgcolor="#fba661">
											<div align="center">
												状态
											</div>
										</td>
									</tr>
									<%
											////PageBean pBean = (PageBean)session.getAttribute("productuser_page_list");
											List list = (ArrayList) session.getAttribute("allproductlist");
											Iterator its = list.iterator();
											while (its.hasNext()) {
												Productuser pu = new Productuser();
												pu = (Productuser) its.next();
												String state = pu.getSuperuser();
												String del = String.valueOf(pu.getDelFlag().intValue());
									%>
												<tr bgcolor="#f3f3f3" height="25">
													<td width="10%">
														<div align="center">
															<%=pu.getUsername()%>
														</div>
													</td>
													<td width="13%">
														<div align="center">
															<%=pu.getEmail()%>
														</div>
													</td>
													<td width="12%">
														<div align="center">
															<%=pu.getTel()%>
														</div>
													</td>
													<td width="13%">
														<div align="center">
															<%=pu.getCompanyname()%>
														</div>
													</td>
													<%
														if (state.equals("3")) {
													%>
															<td width="13%">
																<div align="center">
																	管理员
																</div>
															</td>
													<%
														} else {
													%>
															<td width="13%">
																<div align="center">
																	普通用户
																</div>
															</td>
													<%
													}
													%>
													<td width="9%">
														<div align="center">
															<a href="user.action?a=finduser&uid=<%=pu.getUid()%>"><img
																	src="<%=path%>/images/update1.gif"
																	width="20" height="20" border="0" alt="修改" />
															</a>
														</div>
													</td>
													<td width="10%">
														<div align="center">
															<a
																href="<%=path%>/product/changesuperuser.jsp?uid=<%=pu.getUid()%>&superuser=<%=state%>"><img
																	src="<%=path%>/images/Changeuser.gif"
																	width="20" height="20" border="0" alt="角色修改" />
															</a>
														</div>
													</td>
													<%
														if (state.equals("3")) {
													%>
															<td>
																<div align="center">
																	无操作
																</div>
															</td>
													<%
														} else if (del.equals("1")) {
													%>
															<td>
																<div align="center">
																	<a href="user.action?a=delsuser&uid=<%=pu.getUid()%>&value=0"
																		onclick="return confirm_oper();"><img
																			src="<%=path%>/images/sz_tu01.gif"
																			border="0" alt="删除" />
																	</a>
																</div>
															</td>
													<%
														} else {
													%>
															<td>
																<div align="center">
																	<a href="user.action?a=delsuser&uid=<%=pu.getUid()%>&value=1"
																		onclick="return confirm_oper();"><img
																			src="<%=path%>/images/sz_tu02.gif"
																			border="0" alt="恢复" />
																	</a>
																</div>
															</td>
													<%
														}
													%>
												</tr>
									<%
										}
									%>
								</table>
								<table width="100%" height="100" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td valign="top" class="12">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
				<%
					} else {//最上面的if的else 
				%>
						<center>
							<h3>
								对不起，您没有权限查看！！！
							</h3>
						</center>
				<%
					}
				%>
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
