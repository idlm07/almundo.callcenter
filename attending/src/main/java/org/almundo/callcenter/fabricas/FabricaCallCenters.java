package org.almundo.callcenter.fabricas;

import org.almundo.callcenter.ICallCenter;
import org.almundo.callcenter.impl.CallCenter;

/**
 * Encargada de la fabricación instancias de CallCenter
 * @author IvanLemus
 *
 */
public class FabricaCallCenters {

	/***/
	private static ICallCenter callCenter;
	
	/**
	 * Metodo de solitario de call center
	 * @return solitario call center
	 */
	public synchronized static ICallCenter obtenerInstanciaCallCenter() {
		//Patron Solitario
		if(callCenter == null)
			callCenter = new CallCenter();
		return callCenter;
	}
}
