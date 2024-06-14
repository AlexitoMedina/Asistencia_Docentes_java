package modelo;
/**
 *
 * @author almed
 */
public class materias {
    String idMateria;
    String nomMateria;

    public materias() {
    }

    public materias(String idMateria, String nomMateria) {
        this.idMateria = idMateria;
        this.nomMateria = nomMateria;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNomMateria() {
        return nomMateria;
    }

    public void setNomMateria(String nomMateria) {
        this.nomMateria = nomMateria;
    }
    
}
