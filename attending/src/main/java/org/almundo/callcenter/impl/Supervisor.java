package org.almundo.callcenter.impl;

public class Supervisor extends Empleado{
	
	public Supervisor(String nombre) {
		this.nombre = nombre;
	}
	
	public String obtenerNombre() {
		return "Supervisor" + nombre;
	}
	
	public int obtenerPrioridad() {
		return 2;
	}
}
