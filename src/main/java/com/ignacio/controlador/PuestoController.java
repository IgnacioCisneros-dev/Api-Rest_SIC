package com.ignacio.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignacio.negocio.dto.UserDTO;

@RestController
@RequestMapping(value = "/")
public class PuestoController {

	@GetMapping("/User")
	public List<UserDTO> getUser(HttpServletRequest request, HttpServletResponse response ){
		
		
		return null;
	}
}
