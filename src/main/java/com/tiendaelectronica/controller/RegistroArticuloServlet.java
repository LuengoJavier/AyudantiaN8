package com.tiendaelectronica.controller;

import com.tiendaelectronica.model.Articulo;
import com.tiendaelectronica.model.Cliente;
import com.tiendaelectronica.model.data.DBGenerator;
import com.tiendaelectronica.model.data.dao.ArticuloDAO;
import com.tiendaelectronica.model.data.dao.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registroArticuloServlet", value = "/registroArticulo")
public class RegistroArticuloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		try {
			DBGenerator.iniciarBD("TiendaElectronica");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
		RequestDispatcher respuesta = req.getRequestDispatcher("/registroArticulo.jsp");
		//envía la respuesta
		respuesta.forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		RequestDispatcher respuesta = req.getRequestDispatcher("/registroArticuloErroneo.jsp");
		if(req.getParameter("id").length()!=0 && req.getParameter("nombre").length()!=0  &&
				req.getParameter("peso").length()!=0 && req.getParameter("precio").length() !=0 &&
				req.getParameter("categoria").length()!=0){
			int id = Integer.parseInt(req.getParameter("id"));
			String nombre = req.getParameter("nombre");
			double peso = Double.parseDouble(req.getParameter("peso"));
			int precio = Integer.parseInt(req.getParameter("precio"));
			String categoria = req.getParameter("categoria");
			Articulo articulo = new Articulo(id,nombre,peso,precio,categoria);
			try {
				if(agregarArticulo(articulo)){
					req.setAttribute("articulo", articulo);
					respuesta = req.getRequestDispatcher("/registroArticuloExitoso.jsp");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		respuesta.forward(req,resp);
	}
	private boolean agregarArticulo(Articulo articulo) throws ClassNotFoundException {
		DSLContext query= DBGenerator.conectarBD("TiendaElectronica");
		List articulos = ArticuloDAO.obtenerArticulo(query,"id", articulo.getId());
		if(articulos.size()!=0){
			return false;
		}
		else{
			ArticuloDAO.registarArticulo(query,articulo);
			return true;
		}
	}
}