package sistemaacademicofinal;

public class Nota {
    
    Estudiante estudiante;
    Asignatura asignatura;
    double valor;
    String periodo;

    public Nota() {
    }

    public Nota(Estudiante estudiante, Asignatura asignatura, double valor, String periodo) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.valor = valor;
        this.periodo = periodo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido() +
               "\nAsignatura: " + asignatura.getNombre() +
               "\nValor: " + valor +
               "\nPeriodo: " + periodo;
    }
    
}
