package org.almundo.callcenter.fabricas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.almundo.callcenter.IReceptorLlamada;
import org.almundo.callcenter.impl.Director;
import org.almundo.callcenter.impl.Operador;
import org.almundo.callcenter.impl.Supervisor;
import org.almundo.callcenter.utils.ComparatorIReceptorLlamada;

public class FabricaReceptores {

	/**
	 * Metodo de fábrica de empleados
	 * @return Lista de empleados
	 */
	public static List<IReceptorLlamada> crearEmpleados() {
		//Declarar variable temporal
		List<IReceptorLlamada> empleados = new ArrayList<IReceptorLlamada>();
		
		//Poblar la lista de empleados

		empleados.add(new Director("1"));
//		empleados.add(new Director("2"));
		empleados.add(new Operador("1"));
//		empleados.add(new Operador("2"));
		empleados.add(new Supervisor("1"));
//		empleados.add(new Supervisor("2"));
		
		//Ordenar por prioridad.
		Collections.sort(empleados, new ComparatorIReceptorLlamada());
		
		return empleados;
	}
	/**
	 * Metodo de fábrica de contestadoras virtuales
	 * @return
	 */
	public static List<IReceptorLlamada> crearAutomaticos() {
		
		List<IReceptorLlamada> automaticos = new ArrayList<IReceptorLlamada>();
//		automaticos.add(new ContestadoraVirtual());
		
		return automaticos;
	}


}
