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
    
    static void eliminarAsignatura() {
        System.out.println("=== Eliminar Asignatura ===");

        System.out.print("Ingrese el código de la asignatura a eliminar: ");
        String codigoBuscado = scanner.nextLine();

        for (Asignatura a : listaAsignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                System.out.println("\nAsignatura encontrada:");
                System.out.println(a);
                System.out.print("\nEsta seguro que desea eliminar esta asignatura? (s/n): ");
                String confirmacion = scanner.nextLine();

                if (confirmacion.equalsIgnoreCase("s")) {
                    listaAsignaturas.remove(a);
                    System.out.println("\nAsignatura eliminada exitosamente.");
                } else {
                    System.out.println("\nEliminacion cancelada.");
                }
                return;
            }
        }

        System.out.println("No se encontro ninguna asignatura con el codigo: " + codigoBuscado);
    }
    
    static void registrarNota() {
        System.out.println("=== Registrar Nota ===");

        System.out.print("Ingrese el codigo del estudiante: ");
        String codigoEstudiante = scanner.nextLine();

        Estudiante estudianteEncontrado = null;
        for (Estudiante e : listaEstudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigoEstudiante)) {
                estudianteEncontrado = e;
                break;
            }
        }

        if (estudianteEncontrado == null) {
            System.out.println("No se encontro ningun estudiante con ese codigo.");
            return;
        }

        System.out.print("Ingrese el codigo de la asignatura: ");
        String codigoAsignatura = scanner.nextLine();

        Asignatura asignaturaEncontrada = null;
        for (Asignatura a : listaAsignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigoAsignatura)) {
                asignaturaEncontrada = a;
                break;
            }
        }

        if (asignaturaEncontrada == null) {
            System.out.println("No se encontro ninguna asignatura con ese codigo.");
            return;
        }

        System.out.print("Ingrese el valor de la nota: ");
        double valor = Double.parseDouble(scanner.nextLine());

        System.out.print("Ingrese el periodo (ej: 2024-1): ");
        String periodo = scanner.nextLine();

        Nota nota = new Nota(estudianteEncontrado, asignaturaEncontrada, valor, periodo);
        listaNotas.add(nota);

        System.out.println("Nota registrada exitosamente.");
        System.out.println(nota);
    }
    
    
    static void listarNotas() {
        System.out.println("=== Lista de Notas ===");

        if (listaNotas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return;
        }

        for (Nota n : listaNotas) {
            System.out.println("----------------------------");
            System.out.println(n);
        }
        System.out.println("----------------------------");
        System.out.println("Total: " + listaNotas.size() + " nota(s).");
    }

    static void buscarNota() {
        System.out.println("=== Buscar Nota ===");

        System.out.print("Ingrese el codigo del estudiante: ");
        String codigoBuscado = scanner.nextLine();

        boolean encontrado = false;

        for (Nota n : listaNotas) {
            if (n.getEstudiante().getCodigo().equalsIgnoreCase(codigoBuscado)) {
                System.out.println("----------------------------");
                System.out.println(n);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron notas para ese estudiante.");
        } else {
            System.out.println("----------------------------");
        }
    }

    static void actualizarNota() {
        System.out.println("=== Actualizar Nota ===");

        System.out.print("Ingrese el codigo del estudiante: ");
        String codigoEstudiante = scanner.nextLine();

        System.out.print("Ingrese el codigo de la asignatura: ");
        String codigoAsignatura = scanner.nextLine();

        for (Nota n : listaNotas) {
            if (n.getEstudiante().getCodigo().equalsIgnoreCase(codigoEstudiante) &&
                n.getAsignatura().getCodigo().equalsIgnoreCase(codigoAsignatura)) {

                System.out.println("\nNota encontrada:");
                System.out.println(n);

                System.out.println("\nIngrese los nuevos datos (Enter para mantener el valor actual):");

                System.out.print("Nuevo valor [" + n.getValor() + "]: ");
                String nuevoValor = scanner.nextLine();
                if (!nuevoValor.isEmpty()) n.setValor(Double.parseDouble(nuevoValor));

                System.out.print("Nuevo periodo [" + n.getPeriodo() + "]: ");
                String nuevoPeriodo = scanner.nextLine();
                if (!nuevoPeriodo.isEmpty()) n.setPeriodo(nuevoPeriodo);

                System.out.println("\nNota actualizada exitosamente:");
                System.out.println(n);
                return;
            }
        }

        System.out.println("No se encontro ninguna nota con esos datos.");
    }
    
    static void eliminarNota() {
        System.out.println("=== Eliminar Nota ===");

        System.out.print("Ingrese el codigo del estudiante: ");
        String codigoEstudiante = scanner.nextLine();

        System.out.print("Ingrese el codigo de la asignatura: ");
        String codigoAsignatura = scanner.nextLine();

        for (Nota n : listaNotas) {
            if (n.getEstudiante().getCodigo().equalsIgnoreCase(codigoEstudiante) &&
                n.getAsignatura().getCodigo().equalsIgnoreCase(codigoAsignatura)) {

                System.out.println("\nNota encontrada:");
                System.out.println(n);
                System.out.print("\nEsta seguro que desea eliminar esta nota? (s/n): ");
                String confirmacion = scanner.nextLine();

                if (confirmacion.equalsIgnoreCase("s")) {
                    listaNotas.remove(n);
                    System.out.println("\nNota eliminada exitosamente.");
                } else {
                    System.out.println("\nEliminacion cancelada.");
                }
                return;
            }
        }

        System.out.println("No se encontro ninguna nota con esos datos.");
    }
    
}
