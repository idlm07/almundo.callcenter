package org.almundo.callcenter.impl;

import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;

public class ContestadoraVirtual implements IReceptorLlamada {

	public ContestadoraVirtual() {}

	public boolean estaDisponible() {
		return true;
	}

	public ILlamada finalizarLlamada() {
		return null;
	}

	public String obtenerNombre() {
		return "Contestadora Virtual";
	}

	public int obtenerPrioridad() {
		return -1;
	}

	@Override
	public String toString() {
		return "ContestadoraVirtual [estaDisponible()=" + estaDisponible()
				+ ", obtenerNombre()=" + obtenerNombre() + "]";
	}

	public int asignarLlamada(ILlamada llamada) {

		return 0;
	}

	public void atenderLlamada(int duracion) {
		
	}

}
