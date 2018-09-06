package org.almundo.callcenter.impl;

import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;
import org.almundo.callcenter.utils.RandomUtil;

/**
 * Clase para simular una contestadora virtual,
 * para esperar en línea.
 * @author IvanLemus
 *
 */
public class ContestadoraVirtual implements IReceptorLlamada {

	protected String nombre;
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	private ILlamada llamadaEnCurso;
	public ILlamada getLlamadaEnCurso() {return llamadaEnCurso;}
	public void setLlamadaEnCurso(ILlamada llamadaEnCurso) {this.llamadaEnCurso = llamadaEnCurso;}
	
	private int llamadasAtendidas;
	public int getLlamadasAtendidas() {return llamadasAtendidas;}
	public void setLlamadasAtendidas(int llamadasAtendidas) {this.llamadasAtendidas = llamadasAtendidas;}
	
	/**
	 * Constructor vacío
	 */
	public ContestadoraVirtual() {
		this.nombre 			= "Contestadora Virtual";
		this.llamadasAtendidas 	= 0;
	}

	/**
	 * Verificar si hay disponibilidad de atención.
	 */
	public boolean estaDisponible() {
		//En este código se puede desarrollar un algoritmo 
		//de capacidad para una contestadora automática
		
		return llamadaEnCurso == null ? true : false;
	}

	/**
	 * Finaliza su tiempo en la Contestadora Virtual.
	 * @return La llamadaEnCurso.
	 */
	public ILlamada finalizarLlamada() {
		ILlamada llamadaAFinalizar = llamadaEnCurso;
		
		//soltar la llamada llamada
		llamadasAtendidas++;
		llamadaEnCurso = null;
		
		return llamadaAFinalizar;
	}

	public String obtenerNombre() {
		return "Contestadora Virtual";
	}
	
	/**
	 * No hay una prioridad diferenciada para este 
	 * tipo de receptor.
	 */
	public int obtenerPrioridad() {
		return 0;
	}

	@Override
	public String toString() {
		return "ContestadoraVirtual [estaDisponible()="
				+ estaDisponible() + "]";
	}
	
	/**
	 * Asignar la llamadaEntrante siempre y cuando esté disponible
	 * para atenderla.
	 */
	public int asignarLlamada(ILlamada llamadaEntrante) {
		//Atiende la llamada si está disponible
		if(estaDisponible()){
			llamadaEnCurso = llamadaEntrante;
			llamadaEnCurso.contestar(this);
			
			return RandomUtil.randomRango(3, 5); 
		}
		
		return 0;
	}

	/**
	 * Esta atención de la llamada, es especial.
	 * La contestadora virutal podrá colocar música
	 * para que espere que un empreado se desocupe
	 * o podrá ser un Bot que le vaya contando algo.
	 */
	public void atenderLlamada(int duracion) {
		//Atender Llamada en curso
		try {
			System.out.println("Llamada " + llamadaEnCurso.obtenerId() + " - Música de fondo...Mientras un Empleado está disponible");
			Thread.sleep(duracion*1000);
		} catch (InterruptedException e) {e.printStackTrace();}
	}

	/**
	 * Obtener el numero de llamadas atendidas
	 */
	public int obtenerLlamadasAtendidas() {
		return llamadasAtendidas;
	}

}
