package sistemaacademicofinal;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    static void registrarAsignatura() {
        System.out.println("=== Registrar Asignatura ===");

        System.out.print("Ingrese el código: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese los créditos: ");
        int creditos = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el docente: ");
        String docente = scanner.nextLine();

        Asignatura asignatura = new Asignatura(codigo, nombre, creditos, docente);
        listaAsignaturas.add(asignatura);

        System.out.println("\nAsignatura registrada exitosamente.");
        System.out.println(asignatura);
    }
    
    static void listarAsignaturas() {
        System.out.println("=== Lista de Asignaturas ===");

        if (listaAsignaturas.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }

        for (Asignatura a : listaAsignaturas) {
            System.out.println("----------------------------");
            System.out.println(a);
        }
        System.out.println("----------------------------");
        System.out.println("Total: " + listaAsignaturas.size() + " asignatura(s).");
    }
    
    static void buscarAsignatura() {
        System.out.println("=== Buscar Asignatura ===");

        System.out.print("Ingrese el código a buscar: ");
        String codigoBuscado = scanner.nextLine();

        for (Asignatura a : listaAsignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                System.out.println("\nAsignatura encontrada:");
                System.out.println(a);
                return;
            }
        }

        System.out.println("No se encontró ninguna asignatura con el código: " + codigoBuscado);
    }
    
    static void actualizarAsignatura() {
        System.out.println("=== Actualizar Asignatura ===");

        System.out.print("Ingrese el código de la asignatura a actualizar: ");
        String codigoBuscado = scanner.nextLine();

        for (Asignatura a : listaAsignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                System.out.println("\nAsignatura encontrada:");
                System.out.println(a);

                System.out.println("\nIngrese los nuevos datos (Enter para mantener el valor actual):");

                System.out.print("Nuevo nombre [" + a.getNombre() + "]: ");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.isEmpty()) a.setNombre(nuevoNombre);

                System.out.print("Nuevos créditos [" + a.getCreditos() + "]: ");
                String nuevosCreditos = scanner.nextLine();
                if (!nuevosCreditos.isEmpty()) a.setCreditos(Integer.parseInt(nuevosCreditos));

                System.out.print("Nuevo docente [" + a.getDocente() + "]: ");
                String nuevoDocente = scanner.nextLine();
                if (!nuevoDocente.isEmpty()) a.setDocente(nuevoDocente);

                System.out.println("\nAsignatura actualizada exitosamente:");
                System.out.println(a);
                return;
            }
        }

        System.out.println("No se encontró ninguna asignatura con el código: " + codigoBuscado);
    }
    
}
