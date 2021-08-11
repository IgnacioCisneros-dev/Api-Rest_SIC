package com.ignacio.persistencia.repository;

import java.util.List;
import com.ignacio.persistencia.entidad.Employee;
import com.ignacio.persistencia.entidad.Puesto;

public interface IExtraeEmployee {

	public List<Employee> getEmployee();
	public void guardarEmpleado(Employee employee);
	public List<Puesto> getListPuesto();
	public void deleteEmpleados(int idEmployee);
	public void updateEmpleados(Employee employeeBody);
}
