package modelo;

/**
 *
 * @author almed
 */
public class empleado {
    int ci;
    String nombre;
    String apellido;
    int telefono;
    String correo;
    int idCargos;
    String idMateria;

    public empleado() {
    }

    public empleado(int ci, String nombre, String apellido, int telefono, String correo, int idCargos, String idMateria) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.idCargos = idCargos;
        this.idMateria = idMateria;
    }
    public void mostrar(){
        System.out.println("___________DAtos___________");
        System.out.println(this.getCi());
        System.out.println(this.getNombre());
        System.out.println(this.getApellido());
        System.out.println(this.getTelefono());
        System.out.println(this.getCorreo());
        System.out.println(this.getIdCargos());
        System.out.println(this.getIdMateria());
        System.out.println("___________-----___________");
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdCargos() {
        return idCargos;
    }

    public void setIdCargos(int idCargos) {
        this.idCargos = idCargos;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }
    
}
