<!DOCTYPE html>
<html>
<head>
    <title>Ingreso a Ofrenda Virtual</title>
</head>
<body>
    <h2>Ingreso a Ofrenda Virtual</h2>
    <h2>Ingresar</h2>

    <form action="UsuarioControlador" method="post">
    <input type="hidden" name="accion" value="login">

        <label>Usuario:</label><br>
        <input type="text" name="usuario"><br><br>

        <label>Contraseña:</label><br>
        <input type="password" name="contrasena"><br><br>

        <button type="submit">Ingresar</button>
    </form>

    <%= request.getParameter("error") != null ? "<p style='color:red'>Usuario o contraseña incorrectos</p>" : "" %>
</body>
</html>
