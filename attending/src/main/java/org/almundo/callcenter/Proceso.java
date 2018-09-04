package org.almundo.callcenter;

import org.almundo.callcenter.fabricas.FabricaCallCenters;
import org.almundo.callcenter.impl.LlamadaTelefonica;
import org.almundo.callcenter.impl.Persona;

/**
 * 
 * @author IvanLemus
 *
 */
public class Proceso extends Thread {

	public Proceso(String mensaje) {
		super(mensaje);
	}
	
	
	@Override
	public void run() {
		super.run();
		
		try{
			System.out.println("Proceso: " + getName());
			
			//Instanciar el call center
			ICallCenter callCenter = FabricaCallCenters.obtenerInstanciaCallCenter();
			
			//Crear una llamada
			ILlamada llamada = new LlamadaTelefonica(this.getName());
			System.out.println(llamada);

			//Iniciar la llamada
			llamada.iniciar(new Persona("Persona No." + this.getName()));
			
			//El Call Center Recibe la llamda
			callCenter.recibirLlamada(llamada);
			
		} catch (Exception e) {
			System.out.println("Error programa:" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
