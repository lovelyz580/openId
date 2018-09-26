<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>

</head>
<body>
    <h2>Hello World!</h2>


    <form action="<%=request.getContextPath()%>/upload/file"method="POST" enctype="multipart/form-data">
        选择一个文件:
        <input type="file" name="file"/>
        <br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>