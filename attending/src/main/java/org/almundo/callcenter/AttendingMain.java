package org.almundo.callcenter;


public class AttendingMain {

	public static void main(String[] args) {
		
		Thread hilo1 = new Proceso("1");
		Thread hilo2 = new Proceso("2");
		Thread hilo3 = new Proceso("3");
		Thread hilo4 = new Proceso("4");
		Thread hilo5 = new Proceso("5");
		Thread hilo6 = new Proceso("6");
		Thread hilo7 = new Proceso("7");
		Thread hilo8 = new Proceso("8");
		Thread hilo9 = new Proceso("9");
		Thread hilo10 = new Proceso("10");
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		hilo6.start();
		hilo7.start();
		hilo8.start();
		hilo9.start();
		hilo10.start();
		
	}

}
