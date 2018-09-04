package org.almundo.callcenter;

import org.almundo.callcenter.exceptions.AttendingException;

/**
 * Interface que describe el comportamiento
 * de una clase Despachadora, o redireccionadora de 
 * llamadas de un Call Center.
 * @author IvanLemus
 */
public interface IDispatcher{
	
	/**
	 * Agrega a llamada a despachar.
	 * @param llamada Llamada entrante
	 */
	public void addCall(ILlamada llamada);
	
	/**
	 * Buscar un receptor de llamada disponible.
	 * @return Receptor de Llamada
	 * @throws AttendingException si no existe ninguno disponible
	 */
	public IReceptorLlamada dispatchCall() throws AttendingException;
	

}
