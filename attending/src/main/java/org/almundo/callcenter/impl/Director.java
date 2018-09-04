package org.almundo.callcenter.impl;


public class Director extends Empleado{

	public Director(String nombre) {
		this.nombre = nombre;
	}
	
	public String obtenerNombre() {
		return "Director " + nombre;
	}

	public int obtenerPrioridad() {
		return 3;
	}

	@Override
	public String toString() {
		return "Director [nombre=" + nombre + ", estaDisponible()="
				+ estaDisponible() + "]";
	}
}
