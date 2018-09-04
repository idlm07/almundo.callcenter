package org.almundo.callcenter.fabricas;

import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.impl.LlamadaTelefonica;

public class FabricaLlamadas {

	public static ILlamada crearLlamadaTelefonica(){
		return new LlamadaTelefonica();
	}
}
