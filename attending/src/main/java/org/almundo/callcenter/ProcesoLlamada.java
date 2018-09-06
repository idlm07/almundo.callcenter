package org.almundo.callcenter;

import org.almundo.callcenter.fabricas.FabricaCallCenters;
import org.almundo.callcenter.impl.Persona;

/**
 * 
 * @author IvanLemus
 *
 */
public class ProcesoLlamada extends Thread {

	private String idProceso;
	
	public ProcesoLlamada(String mensaje) {
		super(mensaje);
		
		idProceso = mensaje;
	}
	
	
	@Override
	public void run() {
		super.run();
		
		try{
			System.out.println("Proceso: " + idProceso);
			
			//Instanciar el call center
			ICallCenter callCenter = FabricaCallCenters.obtenerInstanciaCallCenter();
			
			//Crear persona del proceso
			Persona emisor = new Persona("Persona del proceso:" + idProceso);
			
			//Crear una llamada
			ILlamada llamada = emisor.realizarLlamada();
			
			//El CallCenter Recibe la llamda
			callCenter.recibirLlamada(llamada);
			
		} catch (Exception e) {
			System.out.println("Error programa:" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
