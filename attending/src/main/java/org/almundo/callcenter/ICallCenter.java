package org.almundo.callcenter;

import org.almundo.callcenter.exceptions.AttendingException;

public interface ICallCenter {

	/**
	 * Método encargado de recibir las llamadas 
	 * que ingresan al call center.
	 * @param llamada - Llamada entrante.
	 * @return true si la recibió, falso si no.
	 * @throws Exception Si existe un error en la atención
	 * de la llamada
	 */
	public boolean recibirLlamada(ILlamada llamada) throws Exception;
}
