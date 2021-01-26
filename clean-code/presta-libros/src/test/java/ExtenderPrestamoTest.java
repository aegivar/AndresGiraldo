import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS )
public class ExtenderPrestamoTest {
    PrestamoLibros prestamoLibro;

    @BeforeAll
    public void beforeAll(){
        prestamoLibro = new PrestamoLibros("002",new Libro("ISBN-456","La sombra del viento","carlos ruiz zafon",true),new Date());
    }

    @Test
    public void renovationRequest(){
        assertEquals(2,prestamoLibro.remainingDays(),"Se puede realizar la renovacion");
    }

    @Test
    public void renew(){
        assertAll(()->{
                    Date endDate = prestamoLibro.getEndDate();
                    assertNotNull(endDate);
                    assertAll("is available for renew",
                            ()->assertTrue(prestamoLibro.remainingDays()>2),
                            ()->assertEquals(true,prestamoLibro.getBook().getBusy())
                    );
        }
        );
    }
}
