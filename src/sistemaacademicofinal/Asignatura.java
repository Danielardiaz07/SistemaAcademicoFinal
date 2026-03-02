package sistemaacademicofinal;

public class Asignatura {
    String codigo;
    String nombre;
    int creditos;
    String docente;
    
        public Asignatura() {
    }

    public Asignatura(String codigo, String nombre, int creditos, String docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getDocente() {
        return docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
