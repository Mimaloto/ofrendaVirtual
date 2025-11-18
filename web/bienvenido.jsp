<h1>¡Bienvenido, ${usuario.nombre}!</h1>
<a href="index.jsp">Volver al inicio</a>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje != null) {
%>
    <p style="color:red;"><%= mensaje %></p>
<%
    }
%>
