package org.almundo.callcenter.impl;

import org.almundo.callcenter.IEmisorLlamada;
import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.fabricas.FabricaLlamadas;

public class Persona implements IEmisorLlamada{

	private String nombre;
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	private ILlamada llamadaEnCurso;
	public ILlamada getLlamadaEnCurso() {return llamadaEnCurso;}
	public void setLlamadaEnCurso(ILlamada llamadaEnCurso) {this.llamadaEnCurso = llamadaEnCurso;}

	/**
	 * Constrctor de persona
	 * @param nombre Nombre de la persona que llama
	 */
	public Persona(String nombre){
		this.nombre = nombre;
	}
	
	/**
	 * Valida si el empleado tiene una llamada en curso.
	 */
	public synchronized boolean estaDisponible() {
		return llamadaEnCurso == null ? true : false;
	}

	/**
	 * Finaliza la llamadaEnCurso y queda disponible nuevamente.
	 * @return La llamadaEnCurso.
	 */
	public ILlamada finalizarLlamada() {
		ILlamada llamadaAFinalizar = llamadaEnCurso;
		//Finalizar llamada
		llamadaEnCurso = null;
		
		return llamadaAFinalizar;
	}
	/**
	 * Recibe una 
	 */
	public ILlamada realizarLlamada() {
		
		//Validación: NO Realiza la llamada si está ocupada
		if(!estaDisponible())
			return null;
		
		
		//Iniciar la llamada.
		ILlamada llamadaNueva = FabricaLlamadas.crearLlamadaTelefonica(this);
		
		//Asignar a llamada en curso.
		llamadaEnCurso = llamadaNueva;
		System.out.println("Llamada " + llamadaNueva.obtenerId() + " - Inicio");
		
		//Retornar nueva llamada
		return llamadaEnCurso;
		
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}

}
