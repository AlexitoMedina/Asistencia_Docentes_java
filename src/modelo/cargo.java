package modelo;

/**
 *
 * @author almed
 */
public class cargo {
    int id;
    String nombre;

    public cargo() {
    }

    public cargo(int id, String cargo) {
        this.id = id;
        this.nombre = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String cargo) {
        this.nombre = cargo;
    }
    
}
