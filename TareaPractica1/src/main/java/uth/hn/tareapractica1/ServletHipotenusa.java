package uth.hn.tareapractica1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletHipotenusa", value = "/ServletHipotenusa")
public class ServletHipotenusa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hipotenusa(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hipotenusa(request, response);
    }

    private void hipotenusa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String paramA = request.getParameter("a");
        String paramB = request.getParameter("b");

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Calcular Hipotenusa</title></head><body>");
        out.println("<h1>Servlet Tarea_1</h1>");
        out.println("<h2>Integrantes:</h2>");
        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><th>Nombre</th><th>Número de Cuenta</th></tr>");
        out.println("<tr><td>Edwin Noe Godoy Garcia</td><td>202230060187</td></tr>");
        out.println("<tr><td>Jeison Josue Espinal Diaz</td><td>202110060116</td></tr>");
        out.println("</table>");
        out.println("<h1>Calcular Hipotenusa</h1>");

        out.println("<form method='post'>");
        out.println("Lado A: <input type='text' name='a' value='" + (paramA != null ? paramA : "") + "' /><br><br>");
        out.println("Lado B: <input type='text' name='b' value='" + (paramB != null ? paramB : "") + "' /><br><br>");
        out.println("<input type='submit' value='Calcular Hipotenusa' />");
        out.println("</form>");

        if (paramA != null && paramB != null) {
            try {
                if (paramA.isEmpty() || paramB.isEmpty()) {
                    throw new IllegalArgumentException("Campos vacíos");
                }

                double a = Double.parseDouble(paramA);
                double b = Double.parseDouble(paramB);
                double c = Math.sqrt((a * a) + (b * b));

                // Mostrar los resultados en una tabla
                out.println("<h2>Resultado:</h2>");
                out.println("<table border='1' cellpadding='5'>");
                out.println("<tr><th>Lado A</th><th>Lado B</th><th>Hipotenusa (c)</th></tr>");
                out.println("<tr><td>" + a + "</td><td>" + b + "</td><td>" + c + "</td></tr>");
                out.println("</table>");

            } catch (Exception e) {
                out.println("<br><p style='color:red;'>Error: Debes ingresar números válidos en los campos.</p>");
                //out.println("<p>Error: Debes ingresar números válidos en ambos campos.</p>");
            }
        }

        out.println("<br><br><a href='http://localhost:8092/TareaPractica1_war_exploded/Menu' style='display:inline-block;padding:10px 20px;background-color:#007BFF;color:black;text-decoration:none;border-radius:8px;transition:background-color 0.3s;font-weight:bold;'>Volver al Menú</a>");
        out.println("</body></html>");
    }
}
