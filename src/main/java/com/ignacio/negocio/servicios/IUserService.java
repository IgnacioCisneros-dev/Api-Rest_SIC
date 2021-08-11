package com.ignacio.negocio.servicios;

import java.util.List;

import com.ignacio.negocio.dto.UserDTO;

public interface IUserService {
	
	public List<UserDTO> getUser();
}
