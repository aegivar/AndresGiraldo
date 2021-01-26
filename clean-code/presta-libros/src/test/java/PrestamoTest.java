import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestInstance(TestInstance.Lifecycle.PER_CLASS )
public class PrestamoTest {
    PrestamoLibros prestamoLibro;

    @BeforeAll
    public void beforeAll(){
        prestamoLibro = new PrestamoLibros("001",new Libro("ISBN-123","La cadena","adrian mckinty",true),new Date());

    }

    @Test
    public void bookLoanTime() {
        assertTrue(prestamoLibro.timeElapsed()>0,"han pasado " +prestamoLibro.timeElapsed()+ " días");
    }

    @Test
    public void enableBookForLend(){
        assertEquals(true, prestamoLibro.getBook().getBusy());
    }
}
