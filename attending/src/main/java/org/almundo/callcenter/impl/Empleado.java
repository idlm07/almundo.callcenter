package org.almundo.callcenter.impl;

import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;

public abstract class Empleado implements IReceptorLlamada {

	protected String nombre;
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	private ILlamada llamadaEnCurso;
	public ILlamada getLlamadaEnCurso() {return llamadaEnCurso;}
	public void setLlamadaEnCurso(ILlamada llamadaEnCurso) {this.llamadaEnCurso = llamadaEnCurso;}

	/**
	 * Valida si el empleado tiene una llamada en curso.
	 */
	public boolean estaDisponible() {
		return llamadaEnCurso == null ? true : false;
	}

	/**
	 * Atender la llamadaEntrante siempre y cuando esté disponible
	 * para atenderla.
	 */
	public boolean atenderLlamada(ILlamada llamadaEntrante) {

		//Atiende la llamada si está disponible
		if(estaDisponible()){
			llamadaEnCurso = llamadaEntrante;
			llamadaEnCurso.contestar(this);
			return true;
		}
		//De lo contrario la rechaza.
		else{
			return false;
		}
		
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
}
