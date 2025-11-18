<%-- 
    Document   : registrar
    Created on : 16/11/2025, 4:10:41 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Usuario</title>
</head>
<body>

<h2>Registro de Usuario</h2>

<form action="Usuario" method="post">
    <input type="hidden" name="accion" value="registrar">

    <label>Nombre: </label>
    <input type="text" name="nombre" required><br><br>

    <label>Correo: </label>
    <input type="email" name="correo" required><br><br>

    <label>Contraseña: </label>
    <input type="password" name="contrasena" required><br><br>

    <button type="submit">Crear Cuenta</button>
</form>

${mensaje}

</body>

