package org.almundo.callcenter.impl;

public class Operador extends Empleado {

	public Operador(String nombre) {
		this.nombre = nombre;
	}
	
	public String obtenerNombre() {
		return "Operador" + nombre;
	}
	
	public int obtenerPrioridad() {
		return 1;
	}

}
