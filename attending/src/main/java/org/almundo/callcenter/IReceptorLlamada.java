package org.almundo.callcenter;

public interface IReceptorLlamada {

	public String  obtenerNombre();
	public int  obtenerPrioridad();
	public boolean estaDisponible();
	public int atenderLlamada(ILlamada llamada);
	public ILlamada finalizarLlamada();
	
}
