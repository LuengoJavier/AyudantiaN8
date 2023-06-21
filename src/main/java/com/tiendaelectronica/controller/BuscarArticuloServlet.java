package com.tiendaelectronica.controller;

import com.tiendaelectronica.model.data.DBGenerator;
import com.tiendaelectronica.model.data.dao.ArticuloDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "buscarArticuloServlet", value = "/buscarArticulo")
public class BuscarArticuloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("TiendaElectronica");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher respuesta = req.getRequestDispatcher("/buscarArticulo.jsp");
        respuesta.forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/busquedaArticuloErroneo.jsp");
        if(req.getParameter("categoria").length()!=0){
            String categoria = req.getParameter("categoria");
            try {
                if(buscarArticulos(categoria)!=null){
                    req.setAttribute("libros",buscarArticulos(categoria));
                    respuesta = req.getRequestDispatcher("/buscarArticuloExitoso.jsp");
                }
                else{
                    respuesta = req.getRequestDispatcher("/busquedaArticuloErroneo.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private List buscarArticulos(String categoria) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("TiendaElectronica");
        List articulos = ArticuloDAO.obtenerArticulo(query,"categoria",categoria);
        if(articulos.size()!=0){
            return articulos;
        }else {
            return null;
        }
    }
}
