# almundo.callcenter
Las siguientes son las clases principales del sistema:

AttendingParams.java
---------
	/**Cantidad de llamadas simuladas concurrentemente para el programa principal*/
	public static final int TOPE_LLAMADAS 		= 30;
	
	/**Cantidad de receptores tipo empleados con cargo de Operador*/
	public static final int NUM_OPERADORES 		= 5;
	
	/**Cantidad de receptores tipo empleados con cargo de Supervisor*/
	public static final int NUM_SUPERVISORES 	= 3;
	
	/**Cantidad de receptores tipo empleados con cargo de Directo*/
	public static final int NUM_DIRECTORES 		= 2;
	
	/**Cantidad de receptores de llamada virtuales*/
	public static final int NUM_VIRTUAL			= 3;
---------

AttendingMain.java
---------
	Clase principal para la ejecución del programa.
---------

TestDiezLlamadas.java
---------
	Clase principal para la ejecución de las pruebas unitarias.
---------
