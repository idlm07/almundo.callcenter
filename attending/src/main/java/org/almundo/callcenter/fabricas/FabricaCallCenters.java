package org.almundo.callcenter.fabricas;

import org.almundo.callcenter.ICallCenter;
import org.almundo.callcenter.impl.CallCenter;

public class FabricaCallCenters {

	private static ICallCenter callCenter;
	
	/**
	 * Metodo de solitario de call center
	 * @return solitario call center
	 */
	public static ICallCenter obtenerInstanciaCallCenter() {
		//Patron Solitario
		if(callCenter == null)
			callCenter = new CallCenter();
		return callCenter;
	}
}
