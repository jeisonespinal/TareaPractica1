package uth.hn.tareapractica1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletBinario", value = "/ServletBinario")
public class ServletBinario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        conversion(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        conversion(request, response);
    }

    private void conversion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");
        String binario = request.getParameter("binario");
        String decimalStr = request.getParameter("decimal");

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Conversión Binario/Decimal</title></head><body>");
        out.println("<h1>Servlet Tarea_1</h1>");
        out.println("<h2>Integrantes:</h2>");
        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><th>Nombre</th><th>Número de Cuenta</th></tr>");
        out.println("<tr><td>Edwin Noe Godoy Garcia</td><td>202230060187</td></tr>");
        out.println("<tr><td>Jeison Josue Espinal Diaz</td><td>202110060116</td></tr>");
        out.println("</table>");
        out.println("<h1>Conversión Numero Binario y Decimal</h1>");
        out.println("<form method='post'>");
        out.println("Número Binario: <input type='text' name='binario' value='" + (binario != null ? binario : "") + "' />");
        out.println("<input type='submit' name='accion' value='Convertir a Decimal' /><br><br>");
        out.println("Número Decimal: <input type='text' name='decimal' value='" + (decimalStr != null ? decimalStr : "") + "' />");
        out.println("<input type='submit' name='accion' value='Convertir a Binario' />");
        out.println("</form>");
        out.println("</body></html>");

        if (accion != null) {
            if ("Convertir a Decimal".equals(accion)) {
                try {
                    int decimal = Integer.parseInt(binario, 2);
                    out.println("<h2>Resultado:</h2>");
                    out.println("<table border='1' cellpadding='5'>");
                    out.println("<tr><th>Tipo</th><th>Entrada</th><th>Resultado</th></tr>");
                    out.println("<tr><td>Binario a Decimal</td><td>" + binario + "</td><td>" + decimal + "</td></tr>");
                    out.println("</table>");
                } catch (Exception e) {
                    out.println("<br><p style='color:red;'>Error: Debe ingresar un valor o el número Binario ingresado no es válido.</p>");
                }
            } else if ("Convertir a Binario".equals(accion)) {
                try {
                    int decimal = Integer.parseInt(decimalStr);
                    String bin = Integer.toBinaryString(decimal);
                    out.println("<h2>Resultado:</h2>");
                    out.println("<table border='1' cellpadding='5'>");
                    out.println("<tr><th>Tipo</th><th>Entrada</th><th>Resultado</th></tr>");
                    out.println("<tr><td>Decimal a Binario</td><td>" + decimalStr + "</td><td>" + bin + "</td></tr>");
                    out.println("</table>");
                } catch (Exception e) {
                    out.println("<br><p style='color:red;'>Error: Debe ingresar un valor o el número Decimal ingresado no es válido.</p>");
                }
            }
        }

        out.println("<br><br><a href='http://localhost:8092/TareaPractica1_war_exploded/Menu' style='display:inline-block;padding:10px 20px;background-color:#007BFF;color:black;text-decoration:none;border-radius:8px;transition:background-color 0.3s;font-weight:bold;'>Volver al Menú</a>");
        out.println("</body></html>");
    }
}
