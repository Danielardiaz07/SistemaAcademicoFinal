package sistemaacademicofinal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();
    static ArrayList<Nota> listaNotas = new ArrayList<>();
    static ArrayList<Estudiante> listaEstudiantes = new ArrayList <>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1: registrarEstudiante(); break;
                case 2: listarEstudiantes(); break;
                case 3: buscarEstudiante(); break;
                case 4: actualizarEstudiante(); break;
                case 5: eliminarEstudiante(); break;
                case 6: registrarAsignatura(); break;
                case 7: listarAsignaturas(); break;
                case 8: buscarAsignatura(); break;
                case 9: actualizarAsignatura(); break;
                case 10: eliminarAsignatura(); break;
                case 11: registrarNota(); break;
                case 12: listarNotas(); break;
                case 13: buscarNota(); break;
                case 14: actualizarNota(); break;
                case 15: eliminarNota(); break;
                case 0: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opcion no valida."); break;
            }
        } while (opcion != 0);
    }
    
    static int mostrarMenu() {
        System.out.println("\n=============================");
        System.out.println("   SISTEMA ACADEMICO FINAL   ");
        System.out.println("=============================");
        System.out.println("--- Estudiantes ---");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Actualizar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("--- Asignaturas ---");
        System.out.println("6. Registrar asignatura");
        System.out.println("7. Listar asignaturas");
        System.out.println("8. Buscar asignatura");
        System.out.println("9. Actualizar asignatura");
        System.out.println("10. Eliminar asignatura");
        System.out.println("--- Notas ---");
        System.out.println("11. Registrar nota");
        System.out.println("12. Listar notas");
        System.out.println("13. Buscar nota");
        System.out.println("14. Actualizar nota");
        System.out.println("15. Eliminar nota");
        System.out.println("-----------------------------");
        System.out.println("0. Salir");
        System.out.println("=============================");
        System.out.print("Seleccione una opcion: ");
        return Integer.parseInt(scanner.nextLine());
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
