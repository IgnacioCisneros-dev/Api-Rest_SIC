package com.ignacio.persistencia.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ignacio.persistencia.entidad.Employee;

public class EmployeeRowMapper implements RowMapper<List<Employee>> {

	@Override
	public List<Employee> mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		List<Employee> empleados = new ArrayList<Employee>();
		
		Employee empleado = null;
		do {
			empleado = new Employee();
			empleado.setIdEmployee(rs.getInt("idEmployee"));
			empleado.setApellidoPaterno(rs.getString("apellidoPaterno"));
			empleado.setApellidoMaterno(rs.getString("apellidoMaterno"));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setIdUser(rs.getInt("idUser"));
			empleado.setIdPosition(rs.getInt("idPosition"));
			empleado.setStatus(rs.getInt("STATUS"));
			
			empleados.add(empleado);
			
		} while (rs.next());
		
		return empleados;
	}

}
