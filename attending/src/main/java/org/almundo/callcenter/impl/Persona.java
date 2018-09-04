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
	 * Valida si el empleado tiene una llamada en curso.
	 */
	public boolean estaDisponible() {
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
		//Atiende la llamada si está disponible
		if(estaDisponible()){
			
			//Iniciar la llamada.
			ILlamada llamadaNueva = FabricaLlamadas.crearLlamadaTelefonica();
			llamadaNueva.iniciar(this);
			
			//Asignar a llamada en curso.
			llamadaEnCurso = llamadaNueva;
			
			//Retornar nueva llamada
			return llamadaNueva;
		}
		//De lo contrario la rechaza.
		else{
			return null;
		}
	}

}
