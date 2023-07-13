package com.adea.controller;

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
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName=request.getParameter("userName");  
		String password=request.getParameter("password");
		String message;
		
		UsuarioModel usuarioModel = usuarioService.login(userName, password);
		if(usuarioModel!=null) {
			message = "BIENVENIDO " + usuarioModel.getNombre() + " " + usuarioModel.getApellidoPaterno() + " " + usuarioModel.getApellidoMaterno() + ".";
		    return new ModelAndView("welcome", "message", message);
		} else {
	    	  message = "Wrong username or password.";
	    	  return new ModelAndView("error", 
	    			  "message", message);
		}
	}
	
}
