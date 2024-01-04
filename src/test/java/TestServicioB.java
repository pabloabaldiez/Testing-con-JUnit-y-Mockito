import com.ejemplo.services.ServicioA;
import com.ejemplo.services.ServicioB;
import com.ejemplo.services.impl.ServicioAImpl;
import com.ejemplo.services.impl.ServicioBImpl;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestServicioB {

    @Test
    public void testMultiplicar(){

        ServicioB servicioB=new ServicioBImpl();
        assertEquals(servicioB.multiplicar(3,4), 12);
    }


    //Sin mockito estoy "atado a la dependencia, por lo que si modifico el servicio A siempre me va a dar error el test"
    @Test
    public void testMultiplicarSumar(){

        ServicioA servicioA= new ServicioAImpl();

        ServicioB servicioB= new ServicioBImpl();

        servicioB.setServicioA(servicioA);

        Assert.assertEquals(servicioB.multiplicarSumar(2,3,2), 10);
    }


    //Mockito aisla la clase y ya no me afectan los cambios que hubiese en la dependencia. Esto favorece y atomiza el test
    @Test
    public void testMultiplicarSumarMockito(){

        ServicioA servicioA= Mockito.mock(ServicioA.class);

        Mockito.when(servicioA.sumar(2,3)).thenReturn(5);

        ServicioB servicioB = new ServicioBImpl();
        servicioB.setServicioA(servicioA);

        Assert.assertEquals(servicioB.multiplicarSumar(2,3,2),10);


    }
}
