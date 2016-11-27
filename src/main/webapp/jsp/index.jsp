<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016-8-16
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="${sessionScope.ctx}js/jquery-3.1.0.min.js"></script>
    <script>
      function Test() {
        $.ajax({
          url:"${sessionScope.ctx}account/account.do",
          data:{
            NickName:"xiu",
            PayPassword:"1234567",
            Account:100000000.00

          },
          success:function (data) {
            $("#D").append(data);
          }
        });
      }
    </script>
  </head>
  <body>
  <button onclick="Test()">登录</button>
  <div id="D"></div>
  </body>
</html>
