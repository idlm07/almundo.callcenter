package org.almundo.callcenter.impl;

import java.util.Collections;
import java.util.List;

import org.almundo.callcenter.IDispatcher;
import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;
import org.almundo.callcenter.exceptions.AttendingException;
import org.almundo.callcenter.fabricas.FabricaReceptores;
import org.almundo.callcenter.utils.ComparatorIReceptorLlamada;

public class  Dispatcher implements IDispatcher {

	private ILlamada llamada;
	private IReceptorLlamada receptorSeleccionado;
	
	private List<IReceptorLlamada> empleados;
	public List<IReceptorLlamada> getEmpleados() {return empleados;}
	public void setEmpleados(List<IReceptorLlamada> empleados) {this.empleados = empleados;}
	
	private List<IReceptorLlamada> automaticos;
	public List<IReceptorLlamada> getAutomaticos() {return automaticos;}
	public void setAutomaticos(List<IReceptorLlamada> automaticos) {this.automaticos = automaticos;}
	
	/**
	 * Constructor vacío.
	 */
	public Dispatcher() {
		this.empleados 		= FabricaReceptores.crearEmpleados();
		this.automaticos 	= FabricaReceptores.crearAutomaticos();
	}
	
	/**
	 * Agregar llamada a despachar
	 */
	public void addCall(ILlamada llamada) {
		this.llamada = llamada;
	}
	
	/**
	 * Despachar llamada adicionada
	 */
	public IReceptorLlamada dispatchCall() throws AttendingException {

		//Inicializar variables
		receptorSeleccionado = null;
		
		//Validar receptores de llamadas
		if((empleados 	== null || empleados.isEmpty() ) && 
		   (automaticos == null || automaticos.isEmpty()))
			throw new AttendingException("No hay ningún recurso disponible para atender la llamada. Intente más tarde. Gracias");
		
		//Ordenar por prioridad.
		Collections.sort(empleados, new ComparatorIReceptorLlamada());
		
		//Busca si existe un empleado disponible.
		for(IReceptorLlamada empleado : empleados){
			if(empleado.estaDisponible()){
				receptorSeleccionado = empleado;
				break;
			}
		}
		
		//Si no existe ningun empleado que pueda atender
		// se busca si existe un recurso automático.
		if(receptorSeleccionado == null){
			for(IReceptorLlamada automatico : automaticos){
				if(automatico.estaDisponible()){
					receptorSeleccionado = automatico;
					break;
				}
			} 
		}
		
		if(receptorSeleccionado == null)
			throw new AttendingException("No hay ningún recurso disponible para atender la llamada. Intente más tarde. Gracias");
		
		//Asignar receptor a la llamada
		int duracion = receptorSeleccionado.atenderLlamada(llamada);
		System.out.println("Duración de "+ duracion + " segs para la " + llamada);
		receptorSeleccionado.finalizarLlamada();
		
		return receptorSeleccionado;
	}

}
