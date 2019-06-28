<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
  <script>
    function findById(id) {

            location.href ="${pageContext.request.contextPath}/student/updateUI?id="+id;


    }


    function del(id) {
        if (confirm("您确定要删除吗?")){
        location.href ="${pageContext.request.contextPath}/student/deleteById?id="+id;
        }
    }

    function delAll() {
        if (confirm("您确定要删除吗?")) {
            var form = document.getElementById("form");
            form.submit();
        }
    }
  </script>
</head>
<body>
  <h1>学生信息列表</h1>
  <a href="/add.jsp">新增</a>     
  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
<input type="button" value="批量删除" onclick="delAll()">
  
  <table border="1" cellspacing="0">
    <tr>
      <th></th>
      <th>学生id</th>
      <th>学生名称</th>
      <th>学生性别</th>
      <th>学生年龄</th>
      <th>居住地址</th>
      <th>操作</th>
    </tr>
    <form action="${pageContext.request.contextPath}/student/deleteAll" id="form" method="post">
    <c:forEach items="${studentList}" var="student">
    <tr>
      <td>
        <input type="checkbox"  name="ids" value="${student.id}">
      </td>



      <td>${student.id}</td>
      <td>${student.name}</td>

        <c:if test="${student.sex==1}">
      <td>
          女
      </td>
        </c:if>

      <c:if test="${student.sex==0}">
        <td>
          男
        </td>
      </c:if>

      <td>${student.age}</td>
      <td>${student.address}</td>
      <td>
          <a href="javascript:void(0)" onclick="findById(${student.id})">修改</a>
          &nbsp;&nbsp;
          <a href="javascript:void(0)" onclick="del(${student.id})">删除</a>
        </td>
    </tr>
    </c:forEach>
    </form>
  </table>
</body>
</html>
