package attending;

import org.almundo.callcenter.ICallCenter;
import org.almundo.callcenter.ILlamada;
import org.almundo.callcenter.fabricas.FabricaCallCenters;
import org.almundo.callcenter.impl.Persona;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;

@RunWith(ConcurrentTestRunner.class)
public class TestDiezLlamadas {

	private final static int THREAD_COUNT = 10;
	private int contador = 1;

	
	@Before
	public void initiate(){
		contador++;
	}
	
	@Test
	@ThreadCount(THREAD_COUNT)
	public void test() {
		
		boolean resultado = false;
		
		try{
			System.out.println("Proceso: " + contador);
			
			//Instanciar el call center
			ICallCenter callCenter = FabricaCallCenters.obtenerInstanciaCallCenter();
			
			//Crear persona del proceso
			Persona emisor = new Persona("Persona del proceso:" + contador);
			
			//Crear una llamada
			ILlamada llamada = emisor.realizarLlamada();
			
			//El CallCenter Recibe la llamda
			resultado = callCenter.recibirLlamada(llamada);
			
		} catch (Exception e) {
			//Manejo de Exception
			Assert.assertFalse(resultado);
		}
		
		Assert.assertTrue(resultado);

	}

}
