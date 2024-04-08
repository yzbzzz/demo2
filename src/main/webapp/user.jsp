<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023/6/2
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div style="text-align: center">
    <h1>登录页面</h1>
    <form action="UserServlet" method="get" id="userForm">
        账号：<input type="text" name="username" id="username" value="${messageModel.object.username}"><br>
        密码：<input type="password" name="password" id="password" value="${messageModel.object.password}"><br>
        <div style="color: red" id="div">${messageModel.msg}</div><br>
        <button type="button" id="but">登录</button>
        <button type="button"><a href="register.jsp" style="text-decoration: none">注册</a></button>
    </form>
</div>
</body>
<%--加载jquery-3.4.1.js插件--%>
<script src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    <%--通过id选择器，给登录按钮绑定一个点击事件--%>
    $("#but").click(function () {
        //通过id选择器获取账号和密码
        var username=$("#username").val();
        var password=$("#password").val();
        //判断用户名和密码是否为空，若为空返回true，不为空返回false
        function isEmpty(str) {
            if(str==null||str.trim()==""){
                return true;
            }
            return false;
        }
        //判断账号是否为空
        if(isEmpty(username)) {
            //若账号为空，提示并返回：
            $("#div").html("账号不能为空！")
            return;
        }if(isEmpty(password)){
            /* //若密码为空，提示并返回：*/
            $("#div").html("密码不能为空！")
            return;
        }
        $("#userForm").submit()
    });

</script>
</html>

