import Work.Ascensor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class AscensorTest {
    private Ascensor ascensor;
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Before
    public void before(){
        //Prepaarcion de la prueba
        ascensor = new Ascensor();
    }

    @Test
    public void soloHayCapacidadParaunaPersona() throws Exception{
        //Verificacion o Assert
        ascensor.llamarAscensor(1,1,3);
        exception.expect(Exception.class);
        ascensor.llamarAscensor(3,1,2);
    }
    @Test
    public void esperarPrimerPiso() throws Exception{
        //Verificacion o Assert
        assertEquals("Piso actual del ascensor 1 y puerta cerrado",ascensor.verificarEstadoAscensor());

    }
    @Test
    public void colocarPersonaEnUnpiso() throws Exception{
        //Verificacion o Assert
        assertEquals("La persona esta en el piso 1",ascensor.crearPersona(1,2));
    }
    @Test
    public void pisoDestinoEsDiferentePisoActualPersona() throws Exception{
        //Verificacion o Assert
        exception.expect(Exception.class);
        ascensor.crearPersona(1,1);
    }
    @Test
    public void pisoDestinoNoExistente() throws Exception{
        //Verificacion o Assert
        exception.expect(Exception.class);
        ascensor.crearPersona(1,5);
    }
    @Test
    public void personaAparecePrimerPiso() throws Exception{
        //Verificacion o Assert
        assertEquals("Subirse inmediatamente",ascensor.llamarAscensor(1,1,2));


    }
    @Test
    public void personaApareceSegundoPiso() throws Exception{
        //Verificacion o Assert
        ascensor.llamarAscensor(1,1,2);
        assertEquals("Esperando ascensor",ascensor.llamarAscensor(1,2,3));


    }
    @Test
    public void conocerEstadoAscensor() throws Exception{
        //Verificacion o Assert
        ascensor.llamarAscensor(1,1,2);
        assertEquals("Piso actual del ascensor 2 y puerta cerrado",ascensor.verificarEstadoAscensor());

    }

}
