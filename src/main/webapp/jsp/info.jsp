<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016-8-18
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${sessionScope.ctx}js/jquery-3.1.0.min.js"></script>
    <script>
        function Test() {
            $.ajax({
                url:"${sessionScope.ctx}AutoAuth/AutoCheckAuth.do",
                type:"POST",
                success:function (data) {
                    $("#Result").append(data);
                }
            });
        }
        $(function () {
            $.ajax({
                url:"${sessionScope.ctx}Wallet/WalletApply.do",
                type:"POST",
                data:{
                    UserRealName:"修峻青",
                    UserPwd:"123456",
                    UserSex:1
                },
                success:function (data) {
                    $("#Menu").append(data);
                }
            });
        });
    </script>
</head>
<body>
  我是信息页面
  <input type="button" value="改变权限" onclick="Test()"/>
  <div id="Result"></div>
  <div id="Menu"></div>
</body>
</html>
