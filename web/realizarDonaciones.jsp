<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Realizar Donación - Ofrenda Virtual</title>
</head>
<body>

    <h2>Bienvenido Danos tu aporte,Realizar Donación</h2>

    <!-- Mostrar mensaje de éxito -->
    <% 
        String exito = request.getParameter("exito");
        if ("1".equals(exito)) {
    %>
        <p style="color:green; font-size:18px;">¡Gracias por realizar la donación!</p>
    <% } %>

    <form action="DonacionesServlet" method="post">
        <input type="hidden" name="accion" value="registrar">

        <label>Monto de la Donación:</label><br>
        <input type="number" name="monto" step="0.01" required><br><br>

        <label>Descripción:</label><br>
        <textarea name="descripcion" rows="4" cols="40" required></textarea><br><br>

        <button type="submit"> Realizar Donación</button>
    </form>

</body>
</html>

