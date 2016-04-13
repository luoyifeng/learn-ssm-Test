<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/13
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json交互测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        //请求的json,输出的json
        function requestJson() {
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/requestJson.action',
                contentType:'application/json;charset-utf-8',
                data:'{"name":"手机", "price":999}',
                success:function(data){
                    alert(data.name);
                }
            })
        }

        //请求的key/value,输出的json
        function responseJson() {
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/responseJson.action',
                //请求的key/value默认的contentType就是下面这个
//              contentType:'application/json;charset-utf-8',
                data:'name=手机&price=999',
                success:function(data){
                    alert(data.name);
                }
            })
        }
    </script>
</head>
<body>
    <input type="button" onclick="requestJson()" value="请求的json,输出的json">
    <input type="button" onclick="responseJson()" value="请求的key/value,输出的json">
</body>
</html>
