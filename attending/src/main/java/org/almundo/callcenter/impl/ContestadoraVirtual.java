package org.almundo.callcenter.impl;

import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;

public class ContestadoraVirtual implements IReceptorLlamada {

	public ContestadoraVirtual() {}

	public boolean estaDisponible() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean atenderLlamada(ILlamada llamada) {
		// TODO Auto-generated method stub
		return false;
	}

	public ILlamada finalizarLlamada() {
		// TODO Auto-generated method stub
		return null;
	}

	public String obtenerNombre() {
		return "Contestadora Virtual";
	}

	public int obtenerPrioridad() {
		return 1;
	}
	
	

}
