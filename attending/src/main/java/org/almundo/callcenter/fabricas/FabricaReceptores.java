package org.almundo.callcenter.fabricas;

import java.util.ArrayList;
import java.util.List;

import org.almundo.callcenter.IReceptorLlamada;
import org.almundo.callcenter.impl.ContestadoraVirtual;
import org.almundo.callcenter.impl.Director;
import org.almundo.callcenter.impl.Operador;
import org.almundo.callcenter.impl.Supervisor;

public class FabricaReceptores {

	/**
	 * Metodo de fábrica de empleados
	 * @return Lista de empleados
	 */
	public static List<IReceptorLlamada> crearEmpleados() {
		//Declarar variable temporal
		List<IReceptorLlamada> empleados = new ArrayList<IReceptorLlamada>();
		
		//Poblar la lista de empleados
		empleados.add(new Supervisor("2"));
		empleados.add(new Supervisor("3"));
		empleados.add(new Director("1"));
		empleados.add(new Director("2"));
		empleados.add(new Operador("1"));
		empleados.add(new Operador("2"));
		empleados.add(new Operador("3"));
		empleados.add(new Operador("4"));
		empleados.add(new Supervisor("1"));
		empleados.add(new Director("3"));
		
		return empleados;
	}
	/**
	 * Metodo de fábrica de contestadoras virtuales
	 * @return
	 */
	public static List<IReceptorLlamada> crearAutomaticos() {
		
		List<IReceptorLlamada> automaticos = new ArrayList<IReceptorLlamada>();
		automaticos.add(new ContestadoraVirtual());
		
		return automaticos;
	}


}
