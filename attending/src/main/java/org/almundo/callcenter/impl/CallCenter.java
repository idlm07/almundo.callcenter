package org.almundo.callcenter.impl;

import org.almundo.callcenter.ICallCenter;
import org.almundo.callcenter.IDispatcher;
import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;
import org.almundo.callcenter.fabricas.FabricaDispatchers;

/**
 * Clase encargada de la atención de las llamadas
 * @author IvanLemus
 */
public class CallCenter implements ICallCenter {
	
	/** Atributo despachador de llamadas*/
	private IDispatcher dispatcher;
	public IDispatcher getDispatcher() {return dispatcher;}
	public void setDispatcher(IDispatcher dispatcher) {this.dispatcher = dispatcher;}

	/**
	 * Constructor vacío del Call Center
	 */
	public CallCenter() {
		//Inicializar el dispatcher
		this.dispatcher = FabricaDispatchers.obtenerInstanciaDispatcher();
	}
	
	/**
	 * Recibir llamada y direccionar su atención
	 */
	public boolean recibirLlamada(ILlamada llamada) throws Exception {
		
		//Declaración de variables del método.
		IReceptorLlamada 	receptor 	= null;
		boolean 			intentar 	= true;
		int 				numIntentos = 3	;

		//Atender llamada.
		while (intentar){
			try {
				
				//Delega al Dispatcher que busque un empleado disponible.
				receptor = dispatcher.dispatchCall(llamada);
				
				//Seguir intentando, pues es una contestadora virtual.
				if("Contestadora Virtual".equals(receptor.obtenerNombre()))
					intentar = true;
				
				//No seguir intentando, puesto que ya lo encontró.
				else
					intentar = false;
				
			} 
			//No encontró receptor de la llamada.
			catch (Exception e) {
				
				System.out.println("Llamada " + llamada.obtenerId() + " - EnEspera");
				//Esperar 10 segundos.
				Thread.sleep(10000);
				
				//Validar numero de intentos
				numIntentos--;
				if(0 == numIntentos){
					intentar = false;
				}
				
				System.out.println("Llamada " + llamada.obtenerId() + " - Reintento " + numIntentos);
				
			}
		}
		
		return receptor != null ? true : false;
	}

}
