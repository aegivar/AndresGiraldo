import java.util.ArrayList;

public class Usuario {
    private String Id;
    private String Name;
    private String LastName;
    private ArrayList<PrestamoLibros> prestamosLibros;

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

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public ArrayList<PrestamoLibros> getPrestamosLibros() {
        return prestamosLibros;
    }

    public void setPrestamosLibros(ArrayList<PrestamoLibros> prestamosLibros) {
        this.prestamosLibros = prestamosLibros;
    }
}
