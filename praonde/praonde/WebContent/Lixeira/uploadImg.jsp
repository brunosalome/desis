<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Exemplo de upload</title>
    </head>
    <body>
        <form action="upload" method="post" name="form" enctype="multipart/form-data">
        Upload: <input type="file" name="arquivo" /><br />
        <input type="submit" name="enviar" value="Enviar" />
        </form>
    </body>
</html>