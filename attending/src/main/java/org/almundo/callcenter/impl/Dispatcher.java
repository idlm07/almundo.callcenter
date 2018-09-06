package org.almundo.callcenter.impl;

import java.util.Collections;
import java.util.List;

import org.almundo.callcenter.IDispatcher;
import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;
import org.almundo.callcenter.exceptions.AttendingException;
import org.almundo.callcenter.fabricas.FabricaReceptores;
import org.almundo.callcenter.utils.ComparatorIReceptorLlamada;

/**
 * Clase que realiza el despacho de la información
 * @author IvanLemus
 *
 */
public class Dispatcher implements IDispatcher {

	
	public List<IReceptorLlamada> empleados;
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
	 * Despachar llamada adicionada
	 */
	public IReceptorLlamada dispatchCall(ILlamada llamada) throws AttendingException {

		//Inicializar variables
		IReceptorLlamada receptorSeleccionado = null;
		int duracionLlamada = 0;
		
		//Validar receptores de llamadas
		if((empleados 	== null || empleados.isEmpty() ) && 
		   (automaticos == null || automaticos.isEmpty()))
			throw new AttendingException("No hay ningún recurso disponible para atender la llamada. Intente más tarde. Gracias");
		
		
		//Busca si existe un empleado disponible.
		for(IReceptorLlamada empleado : empleados){
			synchronized (empleado) {
				if(empleado.estaDisponible()){
					
					//Asignar receptor a la llamada
					duracionLlamada = empleado.asignarLlamada(llamada);
					System.out.println("Llamada "+llamada.obtenerId() + " - Asignada a: "+ empleado);
					receptorSeleccionado = empleado;
					
					break;
				}
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
		
		//Atender llamada
		receptorSeleccionado.atenderLlamada(duracionLlamada);
		
		//Llamada finalizada
		receptorSeleccionado.finalizarLlamada();
		System.out.println("Llamada " + llamada.obtenerId() + " - Fin (duracion:" + duracionLlamada + "segs.)");
		
		return receptorSeleccionado;
	}


}
