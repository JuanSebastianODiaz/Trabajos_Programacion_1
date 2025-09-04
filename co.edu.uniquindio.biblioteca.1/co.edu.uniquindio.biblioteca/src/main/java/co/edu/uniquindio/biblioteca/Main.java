package co.edu.uniquindio.biblioteca;

import co.edu.uniquindio.biblioteca.model.Biblioteca;
import co.edu.uniquindio.biblioteca.model.Cliente;
import co.edu.uniquindio.biblioteca.model.Empleado;
import co.edu.uniquindio.biblioteca.model.Libro;

import javax.swing.*;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {

    Biblioteca bibliotecaCliente = inicializarDatosCliente();
    Biblioteca bibliotecaLibro = inicializarDatosLibro();
    int opcionMenu = 0;
    int opcionMenuCliente = 0;
    int opcionMenuLibro = 0;
    do{
        mostrarMenu();
        opcionMenu = leerEntero("Ingrese la opción del menu:");
        switch (opcionMenu) {
            case 1:
                do {
                    mostrarMenuCliente();
                    opcionMenuCliente = leerEntero("Ingrese la opcion que desea elegir:");
                    switch (opcionMenuCliente) {
                        case 1:
                            String respuesta = crearCliente(bibliotecaCliente);
                            System.out.println("La información del cliente es: "+respuesta);
                            break;
                        case 2:
                            Cliente cliente = obtenerCliente(bibliotecaCliente);
                            int edad = leerEntero("Ingrese el edad del cliente a validar: ");
                            String resultadoValidacionEdad = validarEdadCliente(cliente, edad);
                            System.out.println("El resultado de la operación es: "+resultadoValidacionEdad);
                            break;
                        default:
                            mostrarMenu();
                            break;
                    }
                } while (opcionMenuCliente != 3);
            case 2:
                String respuesta2 = crearEmpleado(bibliotecaLibro);
                System.out.println("La informacion del empleado es: "+respuesta2);
            case 3:
                do{
                    mostrarMenuLibro();
                    opcionMenuLibro = leerEntero ("Ingrese la opcion que desea elegir:");
                    switch (opcionMenuLibro) {
                        case 1:
                            String respuesta3 = crearLibro(bibliotecaLibro);
                            System.out.println("La informacion del libro es: "+respuesta3);
                            break;
                        case 2:
                            Libro libro = obtenerLibro(bibliotecaLibro);
                            String nombre = leerStringConsola("Ingrese el nombre del libro a validadr: ");
                            String resultadoValidacionLibro = validarNombreLibro(libro, nombre);
                            System.out.println("El resultado de la operacion es :"+resultadoValidacionLibro);
                            break;
                        default:
                            mostrarMenu();
                    }
                } while (opcionMenuLibro != 3);
                default:
                    break;
        }
    } while (opcionMenu != 4);
}

public static Biblioteca inicializarDatosCliente() {
    Biblioteca biblioteca = new Biblioteca("UQ");
    Cliente cliente = new Cliente();
    cliente.setNombre("Juan");
    cliente.setApellido("Diaz");
    cliente.setCedula("1094");
    cliente.setEdad(29);
    cliente.setTipo("VIP");

    biblioteca.getListaClientes().add(cliente);

    return biblioteca;
}

public static Biblioteca inicializarDatosLibro() {
    Biblioteca biblioteca = new Biblioteca("Libros");
    Libro libro = new Libro();
    libro.setNombre("Montecristo");
    libro.setAutor("Dumas");
    libro.setEditorial("deBolsillo");
    libro.setGenero("Novela");
    libro.setCodigo("273");

    biblioteca.getListaLibros().add(libro);

    return biblioteca;
}

public static Cliente obtenerCliente(Biblioteca biblioteca) {
        String cedulaCliente = leerStringConsola("Ingrese la cedula del cliente a buscar: ");
        Cliente clienteEncontrado = null;
        for(int i=0; i<biblioteca.getListaClientes().size();i++){
            if(biblioteca.getListaClientes().get(i).getCedula().equals(cedulaCliente)){
                clienteEncontrado = biblioteca.getListaClientes().get(i);
                break;
            }
        }
        return clienteEncontrado;
    }

public static String validarEdadCliente(Cliente cliente, int edad) {
        if(cliente != null){
            if(cliente.getEdad() == edad){
                return "la edad del cliente es valida";
            }else{
                return "la edad del cliente no es valida";
            }
        }else{
            return "No se puede validar, el cliente no existe";
        }
    }

public static Libro obtenerLibro(Biblioteca biblioteca) {
    String codigoLibro = leerStringConsola("Ingrese el codigo del libro a buscar: ");
    Libro libroEncontrado = null;
    for(int i=0; i<biblioteca.getListaLibros().size();i++){
        if(biblioteca.getListaLibros().get(i).getCodigo().equals(codigoLibro)){
            libroEncontrado = biblioteca.getListaLibros().get(i);
            break;
        }
    }
    return libroEncontrado;
}

public static String validarNombreLibro(Libro libro, String nombre) {
    if(libro != null){
            if(libro.getNombre().equals(nombre)){
                return "El nombre del libro es valido";
            }else{
                return "El nombre del libro no es valido";
            }
    }else{
        return "No se puede validar, el libro no existe";
    }
}

public static String crearCliente(Biblioteca biblioteca){
        String nombreCliente = leerStringConsola("Ingrese el nombre del cliente:");
        String apellidoCliente = leerStringConsola("Ingrese el apellido del cliente:");
        String cedulaCliente = leerStringConsola("Ingrese la cedula del cliente:");
        int edadCliente = leerEntero("Ingrese la edad del cliente:");
        String tipoCliente = leerStringConsola("Ingrese el tipo de cliente:");

        Cliente cliente = new Cliente();

        cliente.setNombre(nombreCliente);
        cliente.setApellido(apellidoCliente);
        cliente.setCedula(cedulaCliente);
        cliente.setEdad(edadCliente);
        cliente.setTipo(tipoCliente);

        biblioteca.getListaClientes().add(cliente);

        return cliente.toString();
    }

public static String crearEmpleado(Biblioteca biblioteca){
        String nombreEmpleado = leerStringConsola("Ingrese el nombre del empleado:");
        String apellidoEmpleado = leerStringConsola("Ingrese el apellido del empleado:");
        String cedulaEmpleado = leerStringConsola("Ingrese la cedula del empleado:");
        int edadEmpleado = leerEntero("Ingrese la edad del empleado:");
        String cargoEmpleado = leerStringConsola("Ingrese el cargo de empleado:");

        Empleado empleado = new Empleado();

        empleado.setNombre(nombreEmpleado);
        empleado.setApellido(apellidoEmpleado);
        empleado.setCedula(cedulaEmpleado);
        empleado.setEdad(edadEmpleado);
        empleado.setCargo(cargoEmpleado);

        biblioteca.getListaEmpleados().add(empleado);

        return empleado.toString();
    }

public static String crearLibro(Biblioteca biblioteca){
        String nombreLibro = leerStringConsola("Ingrese el nombre del libro:");
        String autorLibro =  leerStringConsola("Ingrese el autor del libro:");
        String editorialLibro = leerStringConsola("Ingrese la editorial del libro:");
        String generoLibro = leerStringConsola("Ingrese el genero del libro:");
        String codigoLibro = leerStringConsola("Ingrese el codigo del libro:");

        Libro libro = new Libro();

        libro.setNombre(nombreLibro);
        libro.setAutor(autorLibro);
        libro.setEditorial(editorialLibro);
        libro.setGenero(generoLibro);
        libro.setCodigo(codigoLibro);

        biblioteca.getListaLibros().add(libro);

        return libro.toString();
    }

public static void mostrarMenu() {
        System.out.println("1. Crear Cliente");
        System.out.println("2. Crear Empleado");
        System.out.println("3. Crear Libro");
        System.out.println("4. Salir");
    }

public static void mostrarMenuCliente(){
        System.out.println("1. Crear Cliente");
        System.out.println("2. Validar Edad Cliente");
        System.out.println("3. Regresar Menu Anterior");
    }

public static void mostrarMenuLibro(){
        System.out.println("1. Crear Libro");
        System.out.println("2. Validar Disponibilidad Libro");
        System.out.println("3. Regresar Menu Anterior");
    }

public static int leerEntero(String mensaje) {
        int dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Integer.parseInt(captura);
        return dato;
    }

public static String leerStringConsola(String mensaje)
    {
        String captura="";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        return captura;
    }

}