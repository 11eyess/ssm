<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <h1>登陆页面</h1>
  <form action="${pageContext.request.contextPath}/user/login" method="post">
      <div style="color: red"> ${msg}</div>
    用户名：<input type="text" name="name"><br/>
    密码：<input type="password" name="password"><br/>
    <button type="submit">登陆</button>
  </form>
</body>
</html>
