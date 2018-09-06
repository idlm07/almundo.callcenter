package org.almundo.callcenter.fabricas;

import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.impl.LlamadaTelefonica;
import org.almundo.callcenter.impl.Persona;

public class FabricaLlamadas {

	private static int contadorLlamadas = 0;
	
	public synchronized static ILlamada crearLlamadaTelefonica(Persona emisor){
		//Incrementar contador de llamadas
		contadorLlamadas++;
		
		//Crear nueva llamada
		ILlamada llamada = new LlamadaTelefonica(""+contadorLlamadas);
		llamada.iniciar(emisor);
		
		return llamada;
	}
}
