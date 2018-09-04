package org.almundo.callcenter;

public interface ILlamada {

	/**
	 * Identificador de la llamada
	 * @return
	 */
	public String obtenerId();
	
	/**
	 * Inicia la llamada
	 * @return
	 */
	public boolean iniciar(IEmisorLlamada emisor);
	
	/**
	 * Contesta la llamada un receptor.
	 * @param receptor - Recurso que va a atender la llamada.
	 * @return true si contesta
	 */
	public boolean contestar(IReceptorLlamada receptor);
	
	/**
	 * Termina la llamada iniciada.
	 * @return true si se finaliza.
	 * false si no se finaliza.
	 */
	public boolean finalizar();
	
	/**
	 * Retorna la duración de la llamada actual 
	 * en minutos.
	 * @return
	 */
	public int duracion();
}
