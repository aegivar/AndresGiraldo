import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Libro {
    private String Id;
    private String Name;
    private String Author;
    private Boolean busy;

    public Libro(String id, String name, String author, Boolean busy) {
        Id = id;
        Name = name;
        Author = author;
        this.busy = busy;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public static String findByName(ArrayList<Libro> libros, String nombre) {
        List<String> libroFound =  (libros.stream().filter(libro -> libro.getName().equals(nombre)))
                .map(libro -> libro.getName())
                .collect(Collectors.toList());
        return libroFound.get(0);
    }
}
