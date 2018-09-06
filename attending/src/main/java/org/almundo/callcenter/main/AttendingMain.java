package org.almundo.callcenter.main;

import java.util.ArrayList;
import java.util.List;

import org.almundo.callcenter.ProcesoLlamada;

/**
 * Clase principal de atención de llamadas concurrentes
 * @author IvanLemus
 */
public class AttendingMain {

	/**
	 * Programa principal de atención de llamadas concurrentes
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Listado de procesos
		List<ProcesoLlamada> procesos = new ArrayList<ProcesoLlamada>();

		//Generar la cantidad TOPE_LLAMADAS de llamadas para ser atendidas.
		for(int i = 1; i <= AttendingParams.TOPE_LLAMADAS ; i++){
			ProcesoLlamada hilo = new ProcesoLlamada("" + i);
			hilo.start();
			procesos.add(hilo);
		}
		
	}

}
