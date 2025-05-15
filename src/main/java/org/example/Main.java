package org.example;

import org.example.dao.LibroDAO;
import org.example.dao.*;
import org.example.model.*;
import org.example.util.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = Conexion.obtenerConexion()) {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            LibroDAOlmpl LibroDAO = new LibroDAOlmpl();
            AutoresDAOlmpl AutoresDAO = new AutoresDAOlmpl();
            MiembrosDAOlmpl miembrosDAO = new MiembrosDAOlmpl();
            PrestamosDAOlmpl prestamosDAO = new PrestamosDAOlmpl();

            do {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Libros");
                System.out.println("2. Autores");
                System.out.println("3. Miembros");
                System.out.println("4. Préstamos");
                System.out.println("0. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1: // Libros
                        menuLibros(scanner, LibroDAO);
                        break;
                    case 2: // Autores
                        menuAutores(scanner, AutoresDAO);
                        break;
                    case 3: // Miembros
                        menuMiembros(scanner, miembrosDAO);
                        break;
                    case 4: // Préstamos
                        menuPrestamos(scanner, prestamosDAO);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos.");
            e.printStackTrace();
        }
    }

    // Submenú Libros
    private static void menuLibros(Scanner scanner, LibroDAOlmpl dao) {
        int op;
        do {
            System.out.println("\n--- MENÚ LIBROS ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Listar libros");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();
                    System.out.print("ID autor: ");
                    int autorId = scanner.nextInt();

                    Libro libro = new Libro(id, titulo, genero, autorId);
                    dao.crear(libro);
                    System.out.println("Libro registrado.");
                    break;
                case 2:
                    System.out.print("ID libro: ");
                    String buscar = scanner.nextLine();
                    Libro l = dao.buscar(buscar);
                    System.out.println((l != null) ? l : "Libro no encontrado.");
                    break;
                case 3:
                    System.out.print("ID libro a actualizar: ");
                    String actualizar = scanner.nextLine();
                    Libro libroA = dao.buscar(actualizar);
                    if (libroA != null) {
                        System.out.print("Nuevo título: ");
                        libroA.setTitulo(scanner.nextLine());
                        System.out.print("Nuevo género: ");
                        libroA.setGenero(scanner.nextLine());
                        System.out.print("Nuevo ID autor: ");
                        libroA.setAutor_id(scanner.nextInt());

                        dao.actualizar(libroA);
                        System.out.println("Libro actualizado.");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID libro a eliminar: ");
                    String eliminar = scanner.nextLine();
                    dao.eliminar(eliminar);
                    System.out.println("Libro eliminado.");
                    break;
                case 5:
                    List<Libro> libros = dao.listadelibros();
                    libros.forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }

    // Submenú Autores
    private static void menuAutores(Scanner scanner, AutoresDAOlmpl dao) {
        int op;
        do {
            System.out.println("\n--- MENÚ AUTORES ---");
            System.out.println("1. Registrar autor");
            System.out.println("2. Buscar autor");
            System.out.println("3. Actualizar autor");
            System.out.println("4. Eliminar autor");
            System.out.println("5. Listar autores");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID: ");
                    int autor_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("apellido");
                    String apellido = scanner.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = scanner.nextLine();

                    Autores autor = new Autores(autor_id,nombre,apellido,nacionalidad);

                    dao.crear(autor);
                    System.out.println("Autor registrado.");
                    break;
                case 2:
                    System.out.print("ID autor: ");
                    String buscar = scanner.nextLine();
                    Autores a = dao.buscar(buscar);
                    System.out.println((a != null) ? a : "Autor no encontrado.");
                    break;
                case 3:
                    System.out.print("ID autor a actualizar: ");
                    String actualizar = scanner.nextLine();
                    Autores autorA = dao.buscar(actualizar);
                    if (autorA != null) {
                        System.out.print("Nuevo nombre: ");

                        autorA.setNombre(scanner.nextLine());
                        System.out.print("Nueva nacionalidad: ");
                        autorA.setNacionalidad(scanner.nextLine());

                        dao.actualizar(autorA);
                        System.out.println("Autor actualizado.");
                    } else {
                        System.out.println("Autor no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID autor a eliminar: ");
                    String eliminar = scanner.nextLine();
                    dao.eliminar(eliminar);
                    System.out.println("Autor eliminado.");
                    break;
                case 5:
                    List<Autores> autores = dao.listadeautores();
                    autores.forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }

    // Submenú Miembros
    private static void menuMiembros(Scanner scanner, MiembrosDAOlmpl dao) {
        int op;
        do {
            System.out.println("\n--- MENÚ MIEMBROS ---");
            System.out.println("1. Registrar miembro");
            System.out.println("2. Buscar miembro");
            System.out.println("3. Actualizar miembro");
            System.out.println("4. Eliminar miembro");
            System.out.println("5. Listar miembros");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Fecha de inscripción (AAAA-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());

                    Miembros miembro = new Miembros(id, nombre, apellido, fecha);
                    dao.crear(miembro);
                    System.out.println("Miembro registrado.");
                    break;
                case 2:
                    System.out.print("ID miembro: ");
                    String buscar = scanner.nextLine();
                    Miembros m = dao.buscar(buscar);
                    System.out.println((m != null) ? m : "Miembro no encontrado.");
                    break;
                case 3:
                    System.out.print("ID miembro a actualizar: ");
                    String actualizar = scanner.nextLine();
                    Miembros miembroA = dao.buscar(actualizar);
                    if (miembroA != null) {
                        System.out.print("Nuevo nombre: ");
                        miembroA.setNombre(scanner.nextLine());
                        System.out.print("Nuevo apellido: ");
                        miembroA.setApellido(scanner.nextLine());
                        System.out.print("Nueva fecha de inscripción (AAAA-MM-DD): ");
                        miembroA.setFecha_inscripcion(LocalDate.parse(scanner.nextLine()));

                        dao.actualizar(miembroA);
                        System.out.println("Miembro actualizado.");
                    } else {
                        System.out.println("Miembro no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID miembro a eliminar: ");
                    String eliminar = scanner.nextLine();
                    dao.eliminar(eliminar);
                    System.out.println("Miembro eliminado.");
                    break;
                case 5:
                    List<Miembros> miembros = dao.listademiembros();
                    miembros.forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }

    // Submenú Préstamos
    private static void menuPrestamos(Scanner scanner, PrestamosDAOlmpl dao) {
        int op;
        do {
            System.out.println("\n--- MENÚ PRÉSTAMOS ---");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Buscar préstamo");
            System.out.println("3. Actualizar préstamo");
            System.out.println("4. Eliminar préstamo");
            System.out.println("5. Listar préstamos");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID préstamo: ");
                    int id = scanner.nextInt();
                    System.out.print("ID libro: ");
                    int libroId = scanner.nextInt();
                    System.out.print("ID miembro: ");
                    int miembroId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Fecha de préstamo (AAAA-MM-DD): ");
                    LocalDate fPrestamo = LocalDate.parse(scanner.nextLine());
                    System.out.print("Fecha de devolución (AAAA-MM-DD): ");
                    LocalDate fDevolucion = LocalDate.parse(scanner.nextLine());

                    Prestamos prestamo = new Prestamos(id, libroId, miembroId, fPrestamo, fDevolucion);
                    dao.crear(prestamo);
                    System.out.println("Préstamo registrado.");
                    break;
                case 2:
                    System.out.print("ID préstamo: ");
                    String buscar = scanner.nextLine();
                    Prestamos p = dao.buscar(buscar);
                    System.out.println((p != null) ? p : "Préstamo no encontrado.");
                    break;
                case 3:
                    System.out.print("ID préstamo a actualizar: ");
                    String actualizar = scanner.nextLine();
                    Prestamos pA = dao.buscar(actualizar);
                    if (pA != null) {
                        System.out.print("Nuevo ID libro: ");
                        pA.setLibro_id(scanner.nextInt());
                        System.out.print("Nuevo ID miembro: ");
                        pA.setMiembro_id(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Nueva fecha préstamo (AAAA-MM-DD): ");
                        pA.setFecha_prestamo(LocalDate.parse(scanner.nextLine()));
                        System.out.print("Nueva fecha devolución (AAAA-MM-DD): ");
                        pA.setFecha_devolucion(LocalDate.parse(scanner.nextLine()));

                        dao.actualizar(pA);
                        System.out.println("Préstamo actualizado.");
                    } else {
                        System.out.println("Préstamo no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID préstamo a eliminar: ");
                    String eliminar = scanner.nextLine();
                    dao.eliminar(eliminar);
                    System.out.println("Préstamo eliminado.");
                    break;
                case 5:
                    List<Prestamos> prestamos = dao.listadeprestamos();
                    prestamos.forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }
}