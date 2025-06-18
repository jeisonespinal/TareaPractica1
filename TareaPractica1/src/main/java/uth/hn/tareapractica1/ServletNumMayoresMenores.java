package uth.hn.tareapractica1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "ServletNumMayoresMenores", value = "/ServletNumMayoresMenores")
public class ServletNumMayoresMenores extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        numerosMayMen(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        numerosMayMen(request, response);
    }

    private void numerosMayMen(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String paramNum1 = request.getParameter("num1");
        String paramNum2 = request.getParameter("num2");
        String paramNum3 = request.getParameter("num3");
        String lista = request.getParameter("listaNumeros");

        boolean formularioEnviado = paramNum1 != null && paramNum2 != null && paramNum3 != null && lista != null;

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Números Mayores, Menores y Repetidos</title></head><body>");
        out.println("<h1>Servlet Tarea_1</h1>");
        out.println("<h2>Integrantes:</h2>");
        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><th>Nombre</th><th>Número de Cuenta</th></tr>");
        out.println("<tr><td>Edwin Noe Godoy Garcia</td><td>202230060187</td></tr>");
        out.println("<tr><td>Jeison Josue Espinal Diaz</td><td>202110060116</td></tr>");
        out.println("</table>");
        out.println("<h1>Operaciones con Números</h1>");

        out.println("<form method='post'>");
        out.println("Número 1: <input type='number' name='num1' value='" + (paramNum1 != null ? paramNum1 : "") + "'><br><br>");
        out.println("Número 2: <input type='number' name='num2' value='" + (paramNum2 != null ? paramNum2 : "") + "'><br><br>");
        out.println("Número 3: <input type='number' name='num3' value='" + (paramNum3 != null ? paramNum3 : "") + "'><br><br>");
        out.println("Números (separados por coma): <input type='text' name='listaNumeros' placeholder='ej: 4,5,2,4,9' value='" + (lista != null ? lista : "") + "'><br><br>");
        out.println("<input type='submit' value='Procesar'>");
        out.println("</form>");

        if (formularioEnviado) {
            try {
                if (paramNum1.isEmpty() || paramNum2.isEmpty() || paramNum3.isEmpty()) {
                    throw new IllegalArgumentException("Campos vacios");
                }

                int num1 = Integer.parseInt(paramNum1);
                int num2 = Integer.parseInt(paramNum2);
                int num3 = Integer.parseInt(paramNum3);

                int mayor = Math.max(num1, Math.max(num2, num3));
                int menor = Math.min(num1, Math.min(num2, num3));

                String[] partes = lista.split(",");
                Map<Integer, Integer> frecuencia = new HashMap<>();

                for (String s : partes) {
                    int n = Integer.parseInt(s.trim());
                    frecuencia.put(n, frecuencia.getOrDefault(n, 0) + 1);
                }

                int masRepetido = -1;
                int maxRepeticiones = 0;
                for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
                    if (entry.getValue() > maxRepeticiones) {
                        masRepetido = entry.getKey();
                        maxRepeticiones = entry.getValue();
                    }
                }

                out.println("<!DOCTYPE html>");
                out.println("<html><head><title>Resultado:</title></head><body>");
                out.println("<h1>Resultado:</h1>");
                out.println("<table border='1' cellpadding='5'>");
                out.println("<tr><th>Mayor de los tres</th><th>Menor de los tres</th><th>Número más repetido en la lista</th></tr>");
                out.println("<tr><td>" + mayor + "</td><td>" + menor + "</td><td>" + masRepetido + " (repetido " + maxRepeticiones + " veces)</td></tr>");
                out.println("</table>");

            } catch (Exception e) {
                out.println("<br><p style='color:red;'>Error: Asegúrese de llenar todos los campos correctamente con números válidos.</p>");
            }
        }
            out.println("<br><br><a href='http://localhost:8092/TareaPractica1_war_exploded/Menu' style='display:inline-block;padding:10px 20px;background-color:#007BFF;color:black;text-decoration:none;border-radius:8px;transition:background-color 0.3s;font-weight:bold;'>Volver al Menú</a>");
            out.println("</body></html>");
        }
    }




