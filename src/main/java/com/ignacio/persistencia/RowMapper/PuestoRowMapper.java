package com.ignacio.persistencia.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ignacio.persistencia.entidad.Puesto;

public class PuestoRowMapper implements RowMapper<List<Puesto>> {

	@Override
	public List<Puesto> mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		List<Puesto> puestos = new ArrayList<Puesto>();
		Puesto puesto = null;
		
		do {
			puesto = new Puesto();
			puesto.setIdPosition(rs.getInt("idPosition"));
			puesto.setNombre(rs.getString("nombre"));
			puestos.add(puesto);
		} while (rs.next());
		
		
		return puestos;
	}

}
