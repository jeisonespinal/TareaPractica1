package uth.hn.tareapractica1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Menu", value = "/")
public class Menu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MostrarMenuPrincipal(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MostrarMenuPrincipal(request, response);
    }

    private void MostrarMenuPrincipal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        out.println("<html>");
        out.println("<head><title>Menu de inicio Servlets</title>");
        out.println("<style>body {font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;margin:0;padding:0;background-color: #f4f4f4} .menu{background-color: #003366;padding: 10px 0;box-shadow: 0 2px 5px rgba(0,0,0,0.2);text-align: center;} .menu a {display: inline-block;padding: 12px 25px;color:white;text-decoration:none;margin: 0 10px;border-radius: 5px;transition:background 0.3s ease, transform 0.2s ease;} .menu a:hover{background-color: #444;transform: scale(1.05);}</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='menu'>");
        out.println("<a href='ServletBinario?nombre1=ServletBinario'>Servlet Binario</a>");
        out.println("<a href='ServletNumMayoresMenores?nombre2=ServletNumMayoresMenores'>Servlet Numeros Mayores y Menores</a>");
        out.println("<a href='ServletHipotenusa?nombre3=ServletHipotenusa'>Servlet Hipotenusa</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
