package com.adea.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adea.models.UsuarioModel;
import com.adea.service.UsuarioService;

@Controller
@CrossOrigin
public class UsuariosController {
	
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/mantenimiento.htm", method = RequestMethod.GET)
	public ModelAndView status(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		 String status = request.getParameter("status");
		 List<UsuarioModel> list = usuarioService.usuarios(status);
		 return new ModelAndView("welcome", "list",  list);
	}
	
	@RequestMapping(value = "/edit.htm", method = RequestMethod.GET)
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		 String login = request.getParameter("editar");
		 UsuarioModel usuarioModel = usuarioService.getUsuario(login);
		 return new ModelAndView("edit", "usuario",  usuarioModel);
	}
	
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		 UsuarioModel editar = new UsuarioModel();
		 
		 editar.setLogin(request.getParameter("introducir_login"));
		 editar.setPassword(request.getParameter("introducir_password"));
		 editar.setNombre(request.getParameter("introducir_nombre"));
		 editar.setCliente(Float.valueOf(request.getParameter("introducir_cliente")));
		 if(request.getParameter("introducir_email") != null
				 && request.getParameter("introducir_email").trim() != "") {
			 editar.setEmail(request.getParameter("introducir_email"));
		 }
		 editar.setFechaAlta(Date.valueOf(request.getParameter("introducir_fechaalta")));
		 if(request.getParameter("introducir_fechabaja") != null
				 && request.getParameter("introducir_fechabaja").trim() != "") {
			 editar.setFechaBaja(Date.valueOf(request.getParameter("introducir_fechabaja")));
		 }
		 editar.setStatus(request.getParameter("introducir_status").charAt(0));
		 editar.setIntentos(Float.valueOf(request.getParameter("introducir_intentos")));
		 if(request.getParameter("introducir_fecharevocado") != null
				 && request.getParameter("introducir_fecharevocado").trim() != "") {
			 editar.setFechaRevocado(Date.valueOf(request.getParameter("introducir_fecharevocado")));
		 }
		 if(request.getParameter("introducir_fechavigencia") != null
				 && request.getParameter("introducir_fechavigencia").trim() != "") {
			 editar.setFechaVigencia(Date.valueOf(request.getParameter("introducir_fechavigencia")));
		 }
		 if(request.getParameter("introducir_noacceso") != null
				 && request.getParameter("introducir_noacceso").trim() != "") {
			 editar.setNoAcceso(Integer.valueOf(request.getParameter("introducir_noacceso")));
		 }
		 if(request.getParameter("introducir_apellidopaterno") != null
				 && request.getParameter("introducir_apellidopaterno").trim() != "") {
			 editar.setApellidoPaterno(request.getParameter("introducir_apellidopaterno"));
		 }
		 if(request.getParameter("introducir_apellidomaterno") != null
				 && request.getParameter("introducir_apellidomaterno").trim() != "") {
			 editar.setApellidoMaterno(request.getParameter("introducir_apellidomaterno"));
		 }
		 if(request.getParameter("introducir_area") != null
				 && request.getParameter("introducir_area").trim() != "") {
			 editar.setArea(Integer.valueOf(request.getParameter("introducir_area")));
		 }
		 
		 boolean commit = usuarioService.saveUsuario(editar);
		 return new ModelAndView("welcome", "message",  commit ? "Registro editado exitosamente." : "Error en datos.");
	}
	
	@RequestMapping(value = "/baja.htm", method = RequestMethod.GET)
	public ModelAndView baja(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		 String login = request.getParameter("baja");
		 boolean commit = usuarioService.deleteUsuario(login);
		 return new ModelAndView("welcome", "message",  commit ? "Registro eliminado exitosamente." : "Error en datos.");
	}
}
