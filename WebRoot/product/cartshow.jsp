<%@ page language="java" import="java.util.*,hibernate.po.*" contentType="text/html;charset=gb2312"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
 <head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>AscentWeb��������</title>
		<link rel="stylesheet" href="<%=path%>/css/andreas08(blue).css" type="text/css" media="screen,projection" />
<script language="javascript">
 function updateQuantity(obj,str,str2){
   var pid = str;
   var quantity = obj.value;
   var realstock = str2;
   var reg = /[1-9][0-9]*/;
   if( quantity == "" )
   {
   		alert("������������Ϊ�գ�");
   		location.reload();
	    number.focus();
        return false;
   }
   if( quantity !="" && !quantity.match(reg) )
   		 {
     		alert("������������Ϊ����0���֣������������룡");
	     	location.reload();
	     	number.focus();
            return false;
   		 }  
   send_request("<%=request.getContextPath()%>/shopcart.action?a=updateNum&pid="+pid+"&quantity="+quantity+"&realstock="+realstock);
  } 
  
  var http_request = false;
	function send_request(url)
	{ //��ʼ����ָ��������������������ĺ���
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
	// ����������Ϣ�ĺ���
    function processRequest() 
    {
        if (http_request.readyState == 4) 
        { // �ж϶���״̬
            if (http_request.status == 200) 
            { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
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
						<li><a href="<%=request.getContextPath()%>/index.jsp">��ҳ</a></li>
						<li><a href="<%=request.getContextPath()%>/product/itservice.jsp">IT����</a></li>
						<li><a href="<%=request.getContextPath()%>/product/products.jsp">��������ϵͳ</a></li>
						<li><a href="<%=request.getContextPath()%>/product/employee.jsp">Ա����Ƹ</a></li>
						<li><a href="<%=request.getContextPath()%>/product/ContactUs.jsp">��������</a></li>	
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
	if(p!=null&&p.getSuperuser().equals("3")){  //����Ա
	
%>
<td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=p.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/login.action?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:history.go(-1)"><<< ����</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=all"><img src="<%=request.getContextPath()%>\images\productslist.jpg" width="75" height="17" border="0"/></a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/order.action?a=all">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=all">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/shopcart.action?a=checkout">��������</a></div></td>
<%}
	else if(p==null){  //δע���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,�ο�&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/register.jsp" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:history.go(-1)"><<< ����</a></div></td>
<td width="20%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=all">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/shopcart.action?a=checkout">��������</a></div></td>

<%}
	else{  //��ע���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=p.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/login.action?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:history.go(-1)"><<< ����</a></div></td>
<td width="20%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>\order.action?a=all">�鿴����</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product.action?a=all">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/shopcart.action?a=checkout">��������</a></div></td>
<%}%>
</tr>
</table>
<br><br>	

<!-- ��Ʒ�б� --> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">���</div></td>
    <td><div align="center">����</div></td>
    <td><div align="center">catalogno</div></td>
    <td><div align="center">���(g)</div></td>
    <td><div align="center">����(g)</div></td>
    <td><div align="center">ɾ��</div></td>
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
    <td width="13%"><div align="center"><a href="<%=request.getContextPath()%>/shopcart.action?a=move&pid=<%=id%>">ɾ��</a></div></td>
 </tr>
 <%}%>
  
 
</table>   
	</td>
						</tr>
					</table>
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