<%@ page language="java" import="hibernate.po.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>AscentWeb电子商务</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
	</head>
<body>
<form name="form" action="<%=request.getContextPath()%>/user.action?a=updatesuper" method="post">
<%
       String uidd = request.getParameter("uid");
       String superuser = request.getParameter("superuser");
  %>

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
						<tr><td height="4" colspan="2" align="left" valign="bottom"></td>
						</tr>
						<tr>
							<td height="15" align="left" valign="top">&nbsp;</td>
							<td height="15" align="left" valign="top" class="12">
								
								<table width="100%" height="20" border="0" cellpadding="0" cellspacing="0">
								 <tr>
									<td height="20"><div class="right_proaducts">我的位置&gt;&gt;电子商务管理&gt;&gt;用户修改</div></td>
								 </tr>
							   </table>
							   <br/>
								<table width="680" border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr><td bgcolor="#467AA7" colspan="2" height="5"></td></tr>
										<tr><td colspan="2" height="7"></td></tr>
										<tr><td width="110" height="20" bgcolor="#bbddff" class="table_c">修改权限</td>
											<td width="439" bgcolor="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;
												<a href="javascript:history.back()">&lt;&lt;&lt; 返回</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
										</tr>
									</tbody>
								</table>
								<div class="table_wz">
								
								<table width="680" height="260" border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr><td colspan="2" height="5">
										<%
	Productuser p = (Productuser)session.getAttribute("productuser");
	if(p!=null&&p.getSuperuser().equals("3")){
%>		
			
			<%if("1".equals(superuser)){ %>
			<INPUT type="radio" name="superuser" value="1" checked="true">
			<%}else{ %>
			<INPUT type="radio" name="superuser" value="1" >
			<%} %>&nbsp;&nbsp;普通注册用户<br/>
			<%if("3".equals(superuser)){ %>
			<INPUT type="radio" name="superuser" value="3" checked="true">
			<%}else{ %>
			<INPUT type="radio" name="superuser" value="3" >
			<%} %>&nbsp;&nbsp;高级管理员<br>
			<input type="hidden" name="uid" value="<%=uidd%>"/>
		
			<P>
				 &nbsp;
			</P>
			<P>         &nbsp;&nbsp;  &nbsp;<INPUT type="submit" name="submit" value="修改">   &nbsp;</P>
			<P>
				 &nbsp;
			</P>
			<P>
				 &nbsp;
			</P>
			
		
<%
 }else	//最上面的if的else
{ 
%>
<br><br><br><br><br><br/>
<center><h3>对不起，您没有权限查看！！！</h3></center>

<%} %>    
										
									</td></tr>	
									</tbody>
								</table>
								              </div>
		        </td>
				
		        </tr>
		      </table>
        <br/>
        <div class="table_wz"></div>

  </div>
<div id="footer">
<p><a href="http://www.ascenttech.com.cn/" target="_blank">版权所有:北京亚思晟商务科技有限公司 &copy;2004-2008|京ICP备05005681</a></p>
</div>
</div>
</form>  
</body>
</html>
