package com.ignacio.negocio.servicios;

import java.util.List;

import com.ignacio.negocio.dto.EmployeeDTO;
import com.ignacio.negocio.dto.PuestoDTO;
import com.ignacio.negocio.exception.EmployeeException;

public interface IEmployeeService {
	
	public List<EmployeeDTO> getEmployee()throws EmployeeException ;
	public Long addEmployee(EmployeeDTO empleados) throws EmployeeException;
	public List<PuestoDTO> getPuesto()throws EmployeeException ;
	public Long eliminarEmployee(int idEmpleado)throws EmployeeException;
	public Long actualizarEmployee(EmployeeDTO employeeBody, int idEmpleado) throws EmployeeException;
}
