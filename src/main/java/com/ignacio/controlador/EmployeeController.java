package com.ignacio.controlador;

import java.util.List;

import javax.persistence.PostUpdate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ignacio.negocio.dto.EmployeeDTO;
import com.ignacio.negocio.dto.PuestoDTO;
import com.ignacio.negocio.exception.EmployeeException;
import com.ignacio.negocio.servicios.IEmployeeService;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/saludo")
	public String saludo() {
		String saludo = "Hola como estas";
		return saludo;
	}

	@GetMapping("api/Empleados")
	public List<EmployeeDTO> GetEmployee(HttpServletResponse response, HttpServletRequest request)
			throws EmployeeException {

		return employeeService.getEmployee();
	}
	
	@PostMapping("api/AsignarEmpleado")
	public Long addEmployee(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeDTO employeeBody) throws EmployeeException{
		
		
		return employeeService.addEmployee(employeeBody);
		
	}
	@GetMapping("api/Puestos")
	public List<PuestoDTO> GetPuestos(HttpServletRequest request, HttpServletResponse response) throws EmployeeException{
		
		
		return employeeService.getPuesto();
		
	}
	
	@DeleteMapping("api/EliminarEmployee/{idEmployee}")
	public Long deleteEmployee(HttpServletRequest request, HttpServletResponse response, @PathVariable("idEmployee") int idEmpleado) throws EmployeeException{
		
		
		return employeeService.eliminarEmployee(idEmpleado);
		
	}
	
	@PutMapping("api/ActualizarEmployee/{idEmployee}")
	public Long updateEmployee(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeDTO employeeBody, @PathVariable("idEmployee") int idEmployee ) throws EmployeeException{
		
		return employeeService.actualizarEmployee(employeeBody, idEmployee);
	}
	
}
