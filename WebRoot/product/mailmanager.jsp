<%@ page language="java" import="hibernate.po.*" pageEncoding="gb2312"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>�ʼ�����</title>

		<link rel="stylesheet" href="<%=path%>/css/andreas08(blue).css"
			type="text/css" media="screen,projection" />

		<script type="text/javascript">
   		function check(){
   			if(form.fromaddressname.value==""){
   				alert("�������ʼ���ַ");
   				form.fromaddressname.focus();
   				return false;
   			}
   			if(form.frompassword.value==""){
   				alert("�������ʼ�����");
   				form.frompassword.focus();
   				return false;
   			}
   			return true;
   		}
   		
  
 function findEmail(){
   send_request("<%=request.getContextPath()%>/mail.action?a=all");
  } 
  
 var http_request = false;

function send_request(url)
	{ //��ʼ����ָ������������������ĺ���
	   //alert("url\t"+url);
		http_request = false;
		//��ʼ��ʼ��XMLHttpRequest����
		if(window.XMLHttpRequest) 
		{ //Mozilla �����
			http_request = new XMLHttpRequest();
			if(http_request.overrideMimeType) 
			{//����MiME���
				http_request.overrideMimeType('text/xml');
			}
		}
		else if(window.ActiveXObject) 
		{ // IE�����
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
		{ // �쳣����������ʵ��ʧ��
			window.alert("���ܴ���XMLHttpRequest����ʵ��.");
			return false;
		}
		http_request.onreadystatechange = processRequest;
		// ȷ����������ķ�ʽ��URL�Լ��Ƿ�ͬ��ִ���¶δ���
		http_request.open("POST", url, true);
		http_request.send(null);
	}
	// ��������Ϣ�ĺ���
    function processRequest() 
    {
        if (http_request.readyState == 4) 
        { // �ж϶���״̬
            if (http_request.status == 200) 
            { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
               var divhtml = http_request.responseText;
			   document.getElementById('xianshi').innerHTML="����Ա���䣺";
			   document.getElementById('email').innerHTML=divhtml;
            }
        }
       
   } 

   </script>
	</head>


	<body>


		<div id="container">

			<div id="header">

			</div>

			<div id="navigation">
				<ul>
					<li class="selected"></li>
					<li>
						<a href="<%=path%>/index.jsp">��ҳ</a>
					</li>
					<li>
						<a href="<%=path%>/product/itservice.jsp">IT����</a>
					</li>
					<li>
						<a href="<%=path%>/product/products.jsp">��������ϵͳ</a>
					</li>
					<li>
						<a href="<%=path%>/product/employee.jsp">Ա����Ƹ</a>
					</li>
					<li>
						<a href="<%=path%>/product/ContactUs.jsp">��������</a>
					</li>
					<li></li>
				</ul>
			</div>

			<div id="content2">
				<%
					Productuser p = (Productuser) session.getAttribute("productuser");
					if (p != null && p.getSuperuser().equals("3")) { //����Ա
				%>
				<table width="100%" height="20" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="20">
											<div class="table_t">|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
												<a href="<%=path%>/login.action?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|
											</div>
										</td>
										<td>
											<div>
											<a href="<%=path%>/user.action?a=all"><img src="<%=path%>/images/userlist.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="<%=path%>/product.action?a=all"><img src="<%=path%>/images/productslist.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="<%=path%>/product/mailmanager.jsp"><img src="<%=path%>/images/mailmanager.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										    </div>
										</td>	
									</tr>
								</table>
								<br />
								
				
				<table width="100%" height="41" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr><td bgcolor="#467AA7" colspan="2" height="5"></td></tr>
					<tr>
						<td width="15" height="18" align="left" valign="top">
							<div align="left"></div>
						</td>
						<td width="385" align="left" valign="bottom" class="12">
						</td>
					</tr>
					<tr>
						<td height="4" colspan="2" align="left" valign="bottom"></td>
					</tr>

					<tr>
						<td height="15" align="left" valign="top">
						</td>
						<td height="15" align="left" valign="top" class="12">
							<div id="xianshi">
								<a href="javascript:findEmail();">��������</a>
							</div>
							<div id="email">
							</div>
							<div align="center">
								<form name="form" method="post" action="<%=path%>/mail.action?a=save">
									<table width="70%" border="0" cellpadding="0" cellspacing="8"
										bgcolor="f3f3f3">
										<tbody>
											<tr>
												<td width="26%">
													<div align="center">
														����Email��ַ
													</div>
													<div align="center"></div>
												</td>
												<td width="43%" align="left">
													 <input name="fromaddressname" type="text" id="fromaddressname"/>
												</td>
												<td width="31%">
													<select name="fromaddresstype" id="fromaddresstype">
														<option value="@163.com" selected="selected">
															@163.com
														</option>
														<option value="@126.com">
															@126.com
														</option>
														<option value="@sohu.com">
															@sohu.com
														</option>
														<option value="@sina.com">
															@sina.com
														</option>
														<option value="@gmail.com">
															@gmail.com
														</option>
													</select>
												</td>
											</tr>
											<tr>
												<td>
													<div align="center">
														����Email����
													</div>
												</td>
												<td align="left">
													<input name="frompassword" type="password" id="frompassword"/>
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td>
													<div align="center">
														�ռ�Email��ַ
													</div>
												</td>
												<td align="left">
													<input name="toaddress" type="text" id="toaddress"/>
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<div align="center">
														<input type="submit" name="Submit" value="�ύ" onclick="return check();"/>
														&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="reset" name="Reset" value="ȡ��"/>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
							<div>
								<br />
								������
								<br />
								&lt;1&gt;����ȷ�����÷������ַ�����룬���ʼ��Ǹ������ʼ��ĵ�ַ
								<br />
								&lt;2&gt;����ȷ�������ռ����ַ�����ʼ��ǽ����ʼ��ĵ�ַ�����ͻ���
								<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������ύ���ʼ��ᷢ�͵����ʼ�
								<br />
								&lt;3&gt;������ʱ�����������Լ������䣬�����ʼ���ַ���޷��鿴����
								<br />
								&lt;4&gt;�����������䣬�鿴�����õ����������Ƿ���ȷ
							</div>
							<br />
							<div class="table_wz"></div>
						</td>
					</tr>
				</table>
				<%
					} else {
				%>
				<div class="padding">
					<div id="middlebody">
						<center>
							<font size="3">����Ȩ�������ҳ</font>
						</center>
					</div>
				</div>
				<%
					}
				%>
			</div>
			<div id="footer">
				<p>
					<a href="http://www.ascenttech.com.cn/" target="_blank">��Ȩ���У�������˼������Ƽ����޹�˾
						&copy;2004-2008|��ICP��05005681</a>
				</p>
			</div>

		</div>
	</body>
</html>
