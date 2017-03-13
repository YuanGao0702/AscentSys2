function checkLogin(form){
		if(form.username.value==""){
			alert("用户名不能为空");
			form.username.focus();
			return false;
//			return;
		}
		if(form.password.value==""){
			alert("用户密码不能为空");
			form.password.focus();
			return false;
//			return;
		}
		return true;
//		return;
	}

function checkAddProducts(form){
	if(form.productId.value == "")
    {
        alert("编号不能为空 ！");
        form.productId.focus();
        return false;
    }
    if(form.productname.value == "")
    {
        alert("产品名称不能为空 ！");
        form.productname.focus();
        return false;
    }
    if(form.author.value == "")
    {
        alert("作者不能为空 ！");
        form.author.focus();
        return;
    }
    if(form.publisher.value == "")
    {
        alert("出版日期不能为空 ！");
        form.publisher.focus();
        return false;
    }
   if(form.category.value == "")
    {
        alert("类型必须输入！");
        form.category.focus();
        return false;
    }
    if(form.newproduct.value == "")
    {
        alert("新产品必须选择 ！");
        form.newproduct.focus();
        return false;
    }
   
   if(form.price1.value == "")
    {
        alert("请输入价格1 ！");
        form.price1.focus();
        return false;
    }
    
       if(form.stock.value == "")
    {
        alert("请输入总数量 ！");
        form.stock.focus();
        return false;
    }
     if(form.realstock.value == "")
    {
        alert("请输入实际数量 ！");
        form.realstock.focus();
        return false;
    }
    if(form.upload.value == "")
   {
       alert("请选择图片 ！");
      form.upload.focus();
      return false;
   }
   form.submit();
 }
 

 function checkRegister(form){
	if(form.username.value == "")
    {
       alert("用户名不能为空！"); 
       form.username.focus();
        return false;
    }
   if(form.password.value == "")
    {
        alert("请输入密码 ！");
        form.password.focus();
         return false;
    }
     if(form.password2.value == "")
    {
        alert("请再次输入密码 ！");
       form.password2.focus();
         return false;
    }
    if(form.password.value!=form.password2.value){
    
       alert("两次输入的密码不一致 ！");
        form.password2.focus();
         return false;
    }
    if(form.email.value == "")
    {
        alert("请输入邮件 ！");
        form.email.focus();
         return false;
    }
    
 var regm = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//验证Mail的正则表达式,^[a-zA-Z0-9_-]:开头必须为字母,下划线,数字,
  if (form.email.value!="" && !form.email.value.match(regm) )
   		 {
     		alert("邮件格式不对，检查后重新输入！");
	     	form.email.focus();
             return false;
   		 }  
   if(form.code.value==""){
   		alert("请输入验证码！");
        form.code.focus();
         return false;
   }
  else 
    return true;
}

 function checkOrder(form){
	if(form.username.value == "")
    {
       alert("用户名不能为空！"); 
       form.username.focus();
        return false;
    }
    if(form.tel.value!=""){
    	 var mobilereg = /^(((13[0-9]{1})+\d{8}))|(((15[0-9]{1})+\d{8}))$/;
    	 var telreg = /^(((0[0-9]{2})+(\-)+\d{8}))|(((0[0-9]{3})+(\-)+\d{8}))|(((0[0-9]{3})+(\-)+\d{7}))$/;    
  		 var bl1=mobilereg.test(form.tel.value);
  		 var bl2=telreg.test(form.tel.value);
  		 if(bl1||bl2){
  		 	return true;
  		 }else{
  		 	alert("您输入正确手机或0xx-xxxxxxxx格式电话");
  		 	form.tel.focus();
  		 	return false;
  		 }
    }
   
    if(form.email.value == "")
    {
        alert("请输入邮件 ！");
        form.email.focus();
         return false;
    }
    
 var regm = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//验证Mail的正则表达式,^[a-zA-Z0-9_-]:开头必须为字母,下划线,数字,
  if (form.email.value!="" && !form.email.value.match(regm) )
   		 {
     		alert("邮件格式不对，检查后重新输入！");
	     	form.email.focus();
             return false;
   		 }  
  else 
    return true;
}
 function changeStyle(sel){
        var value = sel.options[sel.selectedIndex].value;
        var links = document.getElementById("styles");
        links.href="./css/"+value; 
     }
    
