import com.ejemplo.services.ServicioA;
import com.ejemplo.services.impl.ServicioAImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestServicioA {

    @Test
    public void testSumar(){
        int a =2;
        int b =2;

        ServicioA servicioA= new ServicioAImpl();
        assertEquals(servicioA.sumar(a,b), 4);
    }
}
