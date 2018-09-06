package org.almundo.callcenter.fabricas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.almundo.callcenter.IReceptorLlamada;
import org.almundo.callcenter.impl.Director;
import org.almundo.callcenter.impl.Operador;
import org.almundo.callcenter.impl.Supervisor;
import org.almundo.callcenter.main.AttendingParams;
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
		for(int i=1; i<= AttendingParams.NUM_OPERADORES ; i++ ){
			empleados.add(new Operador("" + i));
		}
		
		for(int i=1; i<= AttendingParams.NUM_SUPERVISORES ; i++ ){
			empleados.add(new Supervisor("" + i));
		}
		
		for(int i=1; i<= AttendingParams.NUM_DIRECTORES ; i++ ){
			empleados.add(new Director("" + i));
		}
		
		//Ordenar por prioridad de atención.
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
