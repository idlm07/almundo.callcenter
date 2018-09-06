package org.almundo.callcenter.impl;

import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;
import org.almundo.callcenter.utils.RandomUtil;

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
	public synchronized boolean estaDisponible() {
		return llamadaEnCurso == null ? true : false;
	}

	/**
	 * Atender la llamadaEntrante siempre y cuando esté disponible
	 * para atenderla.
	 */
	public synchronized int asignarLlamada(ILlamada llamadaEntrante) {

		//Atiende la llamada si está disponible
		if(estaDisponible()){
			llamadaEnCurso = llamadaEntrante;
			llamadaEnCurso.contestar(this);
			
			return RandomUtil.randomRango(5, 10); 
		}
		
		return 0;
	}
	
	/**
	 * Atender la llamadaEntrante siempre y cuando esté disponible
	 * para atenderla.
	 */
	public void atenderLlamada(int duracion) {

		//Si está disponible no atiende ninguna llamada
		if(estaDisponible()){
			return;
		}
		
		//Atender Llamada en curso
		try {
			System.out.println("Llamada " + llamadaEnCurso.obtenerId() + " - EnCurso...");
			Thread.sleep(duracion*1000);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		
	}

	/**
	 * Finaliza la llamadaEnCurso y queda disponible nuevamente.
	 * @return La llamadaEnCurso.
	 */
	public ILlamada finalizarLlamada() {
		ILlamada llamadaAFinalizar = llamadaEnCurso;
		//Finalizar llamada
		llamadaAFinalizar.finalizar();
		llamadaEnCurso = null;
		
		
		return llamadaAFinalizar;
	}
}
