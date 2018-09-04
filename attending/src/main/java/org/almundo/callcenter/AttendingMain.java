package org.almundo.callcenter;

import org.almundo.callcenter.impl.CallCenter;
import org.almundo.callcenter.impl.LlamadaTelefonica;
import org.almundo.callcenter.impl.Persona;

public class AttendingMain {

	public static void main(String[] args) {
		ICallCenter callCenter = new CallCenter();
		
		try {
			//Crear 5 Llamadas
			for(int i=0; i<5;i++){
				ILlamada llamada = new LlamadaTelefonica();
				llamada.iniciar(new Persona("Persona No."+i));
				callCenter.recibirLlamada(llamada);			
			}
			
		} catch (Exception e) {
			System.out.println("Error programa:" + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
