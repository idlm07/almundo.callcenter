package org.almundo.callcenter.main;

import java.util.ArrayList;
import java.util.List;

import org.almundo.callcenter.ProcesoLlamada;

/**
 * Clase principal para la ejecución de los hilos
 * @author IvanLemus
 */
public class AttendingMain {

	public static void main(String[] args) {
		
		List<ProcesoLlamada> procesos = new ArrayList<ProcesoLlamada>();
		
		for(int i = 1; i <= 4 ; i++){
			ProcesoLlamada hiloLlamada1 = new ProcesoLlamada("1");
			hiloLlamada1.start();
//			procesos.add(hiloLlamada1);
		}
		
//		ProcesoLlamada hiloLlamada1 = new ProcesoLlamada("1");
//		ProcesoLlamada hiloLlamada2 = new ProcesoLlamada("2");
//		ProcesoLlamada hiloLlamada3 = new ProcesoLlamada("3");
//		ProcesoLlamada hiloLlamada4 = new ProcesoLlamada("4");
//		ProcesoLlamada hiloLlamadada5 = new ProcesoLlamada("5");
//		ProcesoLlamada hiloLlamadada6 = new ProcesoLlamada("6");
//		ProcesoLlamada hiloLlamadada7 = new ProcesoLlamada("7");
//		ProcesoLlamada hiloLlamadada8 = new ProcesoLlamada("8");
//		ProcesoLlamada hiloLlamadada9 = new ProcesoLlamada("9");
//		ProcesoLlamada hiloLlamadada10 = new ProcesoLlamada("10");
		
//		hiloLlamada1.start();
//		hiloLlamada2.start();
//		hiloLlamada3.start();
//		hiloLlamada4.start();
//		hiloLlamada5.start();
//		hiloLlamada6.start();
//		hiloLlamada7.start();
//		hiloLlamada8.start();
//		hiloLlamada9.start();
//		hiloLlamada10.start();
	}

}
