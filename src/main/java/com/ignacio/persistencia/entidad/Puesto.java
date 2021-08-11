package com.ignacio.persistencia.entidad;

public class Puesto {
	private int idPosition;
	private String nombre;
	private int sueldoMensual;

	public int getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(int sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}

}
