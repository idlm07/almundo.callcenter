package org.almundo.callcenter.impl;

import java.util.Date;

import org.almundo.callcenter.IEmisorLlamada;
import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.IReceptorLlamada;

public class LlamadaTelefonica implements ILlamada {

	private IEmisorLlamada emisor;
	public IEmisorLlamada getEmisor() {return emisor;}
	public void setEmisor(IEmisorLlamada emisor) {this.emisor = emisor;}
	
	private IReceptorLlamada receptor;
	public IReceptorLlamada getReceptor() {return receptor;}
	public void setReceptor(IReceptorLlamada receptor) {this.receptor = receptor;}
	
	private Date inicio;
	public Date getInicio() {return inicio;}
	public void setInicio(Date inicio) {this.inicio = inicio;}
	
	private Date fin;
	public Date getFin() {return fin;}
	public void setFin(Date fin) {this.fin = fin;}
	
	public LlamadaTelefonica() {}
	
	/**
	 * Inicia la llamada entre un emisor y un receptor.
	 * El receptor puede ser nulo en caso que no se sepa quién va a contestar.
	 */
	public boolean iniciar(IEmisorLlamada emisor) {
		this.inicio 	= new Date();
		this.fin 		= null;
		this.emisor		= emisor;
		
		return true;
	}

	/**
	 * Termina la duración de la llamada
	 */
	public boolean finalizar() {
		
		if(fin == null){
			fin = new Date();
			return true;
		}else{
			return false;
		}
		
	}

	/**
	 * Realiza el cálculo entre la fecha de inicio de la llamada
	 * y la fecha fin.
	 */
	public int duracion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Contesta un receptor la llamada
	 */
	public boolean contestar(IReceptorLlamada receptor) {
		this.receptor 	= receptor;
		
		return true;
	}

}
