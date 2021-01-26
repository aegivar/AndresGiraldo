import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS )
public class DisponibilidadTest {
    ArrayList<Libro> libros;

    @BeforeAll
    public void beforeAll(){
        libros = new ArrayList<>();
        libros.add(new Libro("isbn-123","EL psicoanalista","john",false));
        libros.add(new Libro("isbn-124","Juicio Final","john",true));
        libros.add(new Libro("isbn-456","el cuarto mono","pedro",true));
    }

    @Test
    public void findByName(){
        assertEquals("Juicio Final",Libro.findByName(libros, "Juicio Final"));
    }

    @Test
    public void findAvalableBook(){
        assertEquals(true,libros.get(1).getBusy());
    }

    @Test
    public void findBusyBook(){
        assertEquals(false, libros.get(0).getBusy());
    }

}
