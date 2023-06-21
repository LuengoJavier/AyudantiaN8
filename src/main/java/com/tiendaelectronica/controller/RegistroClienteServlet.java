package com.tiendaelectronica.controller;
import com.tiendaelectronica.model.Cliente;
import com.tiendaelectronica.model.data.DBGenerator;
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

@WebServlet(name = "registroClienteServlet", value = "/registroCliente")
public class RegistroClienteServlet extends HttpServlet {
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
		RequestDispatcher respuesta = req.getRequestDispatcher("/registroCliente.jsp");
		//envía la respuesta
		respuesta.forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		RequestDispatcher respuesta = req.getRequestDispatcher("/registroClienteErroneo.jsp");
		if(req.getParameter("correo").length()!=0 && req.getParameter("nombre").length()!=0  &&
				req.getParameter("rut").length()!=0){
			String nombre = req.getParameter("nombre");
			String correo = req.getParameter("correo");
			String rut = req.getParameter("rut");
			Cliente cliente = new Cliente(rut,nombre,correo);
			try {
				if(agregarUsuario(cliente)){
					req.setAttribute("cliente",cliente);
					respuesta = req.getRequestDispatcher("/registroClienteExitoso.jsp");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		respuesta.forward(req,resp);
	}
	private boolean agregarUsuario(Cliente cliente) throws ClassNotFoundException {
		DSLContext query= DBGenerator.conectarBD("TiendaElectronica");
		List clientes = ClienteDAO.obtenerCliente(query,"rut", cliente.getRut());
		if(clientes.size()!=0){
			return false;
		}
		else{
			ClienteDAO.registarCliente(query,cliente);
			return true;
		}
	}
}