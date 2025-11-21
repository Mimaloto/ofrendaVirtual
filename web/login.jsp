<!DOCTYPE html>
<html>
<head>
    <title>Ingreso a Ofrenda Virtual</title>
</head>
<body>
    <h2>Ingreso a Ofrenda Virtual</h2>
    <h2>Ingresar</h2>

    <form action="LoginServlet" method="post">
        <input type="hidden" name="accion" value="login">

        <label>Correo:</label><br>
        <input type="text" name="correo"><br><br>

        <label>Contraseña:</label><br>
        <input type="password" name="contrasena"><br><br>

        <button type="submit">Ingresar</button>
    </form>

    <%= request.getParameter("error") != null ? "<p style='color:red'>Usuario o contraseña incorrectos</p>" : "" %>
</body>
</html>
