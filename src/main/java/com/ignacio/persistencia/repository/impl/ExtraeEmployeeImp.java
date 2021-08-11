package com.ignacio.persistencia.repository.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ignacio.negocio.dto.EmployeeDTO;
import com.ignacio.persistencia.RowMapper.EmployeeRowMapper;
import com.ignacio.persistencia.RowMapper.PuestoRowMapper;
import com.ignacio.persistencia.entidad.Employee;
import com.ignacio.persistencia.entidad.Puesto;
import com.ignacio.persistencia.repository.IExtraeEmployee;

@Repository
public class ExtraeEmployeeImp implements IExtraeEmployee {

	@Autowired 
	private JdbcTemplate template;
	
	@Override
	public List<Employee> getEmployee() {
		String query = "SELECT * FROM EMPLOYEE WHERE STATUS = 1";
		return template.queryForObject(query,new EmployeeRowMapper());
	}

	@Override
	public void guardarEmpleado(Employee employee) {
		
		String query = "INSERT INTO employee (nombre,apellidoPaterno,apellidoMaterno,idUser,idPosition)"
				+ "values(?,?,?,?,?) ";
		
		template.update(query, new Object[] {employee.getNombre(), employee.getApellidoPaterno(),employee.getApellidoMaterno(),
											employee.getIdUser(), employee.getIdPosition()});
		
	}

	@Override
	public List<Puesto> getListPuesto() {
		String consulta = "SELECT idPosition, nombre FROM PUESTO";
		return template.queryForObject(consulta,new PuestoRowMapper());
	}

	@Override
	public void deleteEmpleados(int idEmployee) {
		
		String query = "UPDATE EMPLOYEE SET STATUS = 0 WHERE idEmployee = ?";
		
		template.update(query, new Object[] {idEmployee}, new int[] {Types.NUMERIC});
		
	}

	@Override
	public void updateEmpleados(Employee employeeBody) {
		
		String query = "UPDATE EMPLOYEE SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?,"
				+ "idUser = ?, idPosition = ?, STATUS = ? WHERE idEmployee = ? ";
		
		template.update(query, new Object[] { employeeBody.getNombre(), employeeBody.getApellidoMaterno(), employeeBody.getApellidoPaterno(), employeeBody.getIdUser()
				, employeeBody.getIdPosition(), employeeBody.getStatus(), employeeBody.getIdEmployee()} );
	}

}
