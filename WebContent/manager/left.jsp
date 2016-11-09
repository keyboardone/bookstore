<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台左侧导航页面</title>
    
<style type="text/css">
	.dc { 
			display: none; 
			margin-left: 10px;
		  }
</style>

<script language="javascript">
      function test1() {
    	  var e = document.getElementsByClassName("dc")[0];
    		if(e.style.display == "none"){
    			e.style.display = "block";
    		}else{
    			e.style.display = "none";
    		}    
      }
      function test2() {
    	  var e = document.getElementsByClassName("dc")[1];
    		if(e.style.display == "none"){
    			e.style.display = "block";
    		}else{
    			e.style.display = "none";
    		}    
      }
      function test3() {
    	  var e = document.getElementsByClassName("dc")[2];
    		if(e.style.display == "none"){
    			e.style.display = "block";
    		}else{
    			e.style.display = "none";
    		}    
      }
</script>
</head>
<body>
  <ul>
  	<li>
  		<a href="#" onclick="test1()">分类管理
  		<div class="dc">
   			<a href="${pageContext.request.contextPath }/manager/addcategory.jsp"  target="right">添加分类</a><br/>
   			<a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=getAll"  target="right">查看分类</a><br/>
   		</div>
  		</a>
  	</li>
  	
  	<br/><br/>
  	
  	<li>
  		<a href="#" onclick="test2()">图书管理
  			<div class="dc">
   				<a href="${pageContext.request.contextPath }/manager/BookServlet?method=forAddUI"  target="right">添加图书</a><br/>
   				<a href="${pageContext.request.contextPath }/manager/BookServlet?method=list"  target="right">查看图书</a>
   		</div>
  		</a>
  	</li>
  	
  	<br/><br/>
  	
  	<li>
  		<a href="#" onclick="test3()">订单管理
   		<div class="dc">
   			<a href="${pageContext.request.contextPath }/manager/OrderServlet1?method=getAll&state=false"  target="right">待处理订单</a><br/>
   			<a href="${pageContext.request.contextPath }/manager/OrderServlet1?method=getAll&state=true"  target="right">已发货订单</a><br/>
   		</div>
  		</a>
  	</li>
  	
  	<br/><br/>
  	
  </ul>
</body>
</html>