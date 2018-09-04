package org.almundo.callcenter.utils;

import java.util.Comparator;

import org.almundo.callcenter.IReceptorLlamada;

/**
 * Clase para comparar dos Receptores de Llamadas
 * @author IvanLemus
 */
public class ComparatorIReceptorLlamada implements Comparator<IReceptorLlamada> {

	/**
	 * Método de comparación de dos Receptores de Llamadas
	 */
	public int compare(IReceptorLlamada o1, IReceptorLlamada o2) {
		if(o1.obtenerPrioridad() < o2.obtenerPrioridad())
			return -1;
		
		if(o1.obtenerPrioridad() > o2.obtenerPrioridad())
			return 1;
		
		return 0;
	}

}
