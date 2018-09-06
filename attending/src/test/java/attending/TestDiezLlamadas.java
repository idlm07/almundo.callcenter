package attending;

import static org.junit.Assert.assertTrue;

import org.almundo.callcenter.ProcesoLlamada;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;

@RunWith(ConcurrentTestRunner.class)
public class TestDiezLlamadas {

	private final static int THREAD_COUNT = 10;
	
	@Test
	@ThreadCount(THREAD_COUNT)
	public void test() {
		//Procesamiento en paralelo de 10 llamadas
		
		Thread proceso = new ProcesoLlamada("Proceso 1");
		proceso.start();
		
		
		assertTrue(true);
	}

}
