
package com.ignacio.negocio.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignacio.negocio.dto.EmployeeDTO;
import com.ignacio.negocio.dto.PuestoDTO;
import com.ignacio.negocio.exception.EmployeeException;
import com.ignacio.negocio.servicios.IEmployeeService;
import com.ignacio.persistencia.entidad.Employee;
import com.ignacio.persistencia.entidad.Puesto;
import com.ignacio.persistencia.repository.IExtraeEmployee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IExtraeEmployee employeeRepository;
	
	@Override
	public List<EmployeeDTO> getEmployee() throws EmployeeException {
		
		List<EmployeeDTO> listEmployeesDTO = new ArrayList<EmployeeDTO>();
		List<Employee> employee = new ArrayList<Employee>();
		
		employee = employeeRepository.getEmployee();
		
		if (employee != null) {
			listEmployeesDTO = employee.stream().map(this::convertiraDTO).collect(Collectors.toList());
			return listEmployeesDTO;
		}else{
			throw new EmployeeException("No se encontraron empleados", 404);
		}
	}
	
	public EmployeeDTO convertiraDTO(Employee employee){
		EmployeeDTO empl = new EmployeeDTO();
		
		empl.setIdEmployee(employee.getIdEmployee());
		empl.setNombre(employee.getNombre());
		empl.setApellidoPaterno(employee.getApellidoPaterno());
		empl.setApellidoMaterno(employee.getApellidoMaterno());
		empl.setIdUser(employee.getIdUser());
		empl.setIdPosition(employee.getIdPosition());
		empl.setStatus(employee.getStatus());
		
		return empl;
	}
	
	public PuestoDTO convertiraDTOPuesto(Puesto puesto){
		PuestoDTO empl = new PuestoDTO();
		
		empl.setId(puesto.getIdPosition());
		empl.setNombre(puesto.getNombre());
		return empl;
	}

	@Override
	public Long addEmployee(EmployeeDTO empleados) throws EmployeeException {
		
		Employee employee = new Employee();
		
		employee.setNombre(empleados.getNombre());
		employee.setApellidoPaterno(empleados.getApellidoPaterno());
		employee.setApellidoMaterno(empleados.getApellidoMaterno());
		employee.setIdPosition(empleados.getIdPosition());
		employee.setIdUser(empleados.getIdUser());
		
		employeeRepository.guardarEmpleado(employee);
		
		
		return null;
	}

	@Override
	public List<PuestoDTO> getPuesto() throws EmployeeException {
		
		List<PuestoDTO> puestoDTO = new ArrayList<PuestoDTO>();
		List<Puesto> puesto = new ArrayList<Puesto>();
		
		puesto = employeeRepository.getListPuesto();
		
		if(puesto != null) {
			puestoDTO = puesto.stream().map(this::convertiraDTOPuesto).collect(Collectors.toList());
			return puestoDTO;
		}else {
			throw new EmployeeException("No se encontraron Puestos", 404);
		}
	
	}

	@Override
	public Long eliminarEmployee(int employee) throws EmployeeException {

					
		employeeRepository.deleteEmpleados(employee);
		
		return null;
	}

	@Override
	public Long actualizarEmployee(EmployeeDTO employeeBody, int idEmpleado) throws EmployeeException {
		
		Employee empleado = new Employee();
		
		empleado.setIdEmployee(employeeBody.getIdEmployee());
		empleado.setNombre(employeeBody.getNombre());
		empleado.setApellidoPaterno(employeeBody.getApellidoPaterno());
		empleado.setApellidoMaterno(employeeBody.getApellidoMaterno());
		empleado.setIdUser(employeeBody.getIdUser());
		empleado.setIdPosition(employeeBody.getIdPosition());
		empleado.setStatus(employeeBody.getStatus());
		
		employeeRepository.updateEmpleados(empleado);
		
		return null;
	} 

}
