package org.almundo.callcenter.fabricas;

import org.almundo.callcenter.IDispatcher;
import org.almundo.callcenter.impl.Dispatcher;

public class FabricaDispatchers {

	private static IDispatcher dispatcher;
	
	/**
	 * Metodo de solitario de dispatcher
	 * @return solitario dispatcher
	 */
	public static IDispatcher obtenerInstanciaDispatcher() {
		//Patron Solitario
		if(dispatcher == null)
			dispatcher = new Dispatcher();
		return dispatcher;
	}
}
