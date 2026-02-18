package org.example;

import org.example.Model.Estudiante;
import org.example.Service.SistemaGestionEstudiantes;
import org.example.Util.ValidacionUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {//se inicializan el objeto es scanner y el boleano para while
        SistemaGestionEstudiantes sistema = new SistemaGestionEstudiantes();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {   //Menu basico con las acciones que tendra el programa
            System.out.println("---Sistema de Gestión de Estudiantes---");
            System.out.println("1 Registrar estudiante");
            System.out.println("2 Listar estudiantes");
            System.out.println("3 Buscar estudiante por ID");
            System.out.println("4Modificar estudiante");
            System.out.println("5 Eliminar estudiante");
            System.out.println("6 Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {//se poblan los datos del objeto
                case 1 -> {
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el correo del estudiante: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese el programa académico: ");
                    String programa = scanner.nextLine();

                    if (ValidacionUtil.textoVacio(nombre) || ValidacionUtil.textoVacio(correo) || ValidacionUtil.textoVacio(programa)) {
                        System.out.println("Error: No se pueden dejar campos vacíos.");
                        break;//verificacion de la primera regla...
                    }

                    if (!ValidacionUtil.correoValido(correo)) {
                        System.out.println("Error: Formato de correo inválido.");
                        break;//verificacion de la segunda regla...
                    }

                    Estudiante estudiante = new Estudiante(correo, nombre, programa);
                    sistema.registrarEstudiantes(estudiante);
                    System.out.println("Estudiante registrado: " + estudiante);
                }
                case 2 -> {
                    List<Estudiante> lista = sistema.listarEstudiates();
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        System.out.println("Lista de estudiantes:");//bucle que recorre la lista..
                        for (Estudiante e : lista) {
                            System.out.println(e);
                        }
                    }
                }
                case 3 -> {//llamada al metodo de buscar
                    System.out.print("Ingrese el ID del estudiante a buscar ");
                    int id = scanner.nextInt();
                    Estudiante encontrado = sistema.buscarEstudiante(id);
                    if (encontrado == null) {
                        System.out.println("No se encontró el estudiante con ID " + id);
                    } else {
                        System.out.println("Estudiante encontrado" + encontrado);
                    }
                }
                case 4 -> {//este tambien llama al metodo de buscar estudiante como apoyo para la logica
                    System.out.print("Ingrese el ID del estudiante a modificar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Estudiante encontrado = sistema.buscarEstudiante(id);
                    if (encontrado == null) {
                        System.out.println("No se encontró el estudiante con ID " + id);
                        break;
                    }
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = scanner.nextLine();
                    System.out.print("Nuevo programa académico: ");
                    String nuevoPrograma = scanner.nextLine();

                    if (ValidacionUtil.textoVacio(nuevoNombre) || ValidacionUtil.textoVacio(nuevoCorreo) || ValidacionUtil.textoVacio(nuevoPrograma)) {
                        System.out.println("Error: No se pueden dejar campos vacíos.");
                        break;
                    }
                    if (!ValidacionUtil.correoValido(nuevoCorreo)) {
                        System.out.println("Error: Formato de correo inválido.");
                        break;
                    }

                    Estudiante modificado = sistema.modificarEstudiante(id, nuevoNombre, nuevoCorreo, nuevoPrograma);
                    System.out.println("Estudiante modificado: " + modificado);
                }
                case 5 -> {
                    System.out.print("Ingrese el ID del estudiante a eliminar: ");
                    int id = scanner.nextInt();
                    Estudiante eliminado = sistema.eliminarEstudiante(id);
                    if (eliminado == null) {
                        System.out.println("No se encontró el estudiante con ID " + id);
                    } else {
                        System.out.println("Estudiante eliminado: " + eliminado);
                    }
                }
                case 6 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
