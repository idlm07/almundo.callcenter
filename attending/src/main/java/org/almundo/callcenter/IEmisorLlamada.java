package org.almundo.callcenter;

public interface IEmisorLlamada {

	public boolean estaDisponible();
	public ILlamada realizarLlamada();
	public ILlamada finalizarLlamada();
	
}
