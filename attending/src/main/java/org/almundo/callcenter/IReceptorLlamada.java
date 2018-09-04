package org.almundo.callcenter;

public interface IReceptorLlamada {

	public String  obtenerNombre();
	public int  obtenerPrioridad();
	public boolean estaDisponible();
	public boolean atenderLlamada(ILlamada llamada);
	public ILlamada finalizarLlamada();
	
}
