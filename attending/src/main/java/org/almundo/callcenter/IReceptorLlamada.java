package org.almundo.callcenter;

public interface IReceptorLlamada {

	public String  obtenerNombre();
	public int  obtenerPrioridad();
	public boolean estaDisponible();
	public int asignarLlamada(ILlamada llamada);
	public void atenderLlamada(int duracion);
	public ILlamada finalizarLlamada();
	
}
