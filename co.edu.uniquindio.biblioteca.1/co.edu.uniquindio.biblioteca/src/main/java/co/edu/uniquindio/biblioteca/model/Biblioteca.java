package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;

public class Biblioteca {

    private String nombre;
    private String crearCliente;
    private ArrayList<Cliente> listaClientes = new ArrayList();
    private ArrayList<Empleado> listaEmpleados = new ArrayList();
    private ArrayList<Libro> listaLibros = new ArrayList();
    private ArrayList<Prestamo> listaPrestamos = new ArrayList();

    public Biblioteca(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getCrearCliente(){return crearCliente;}
    public void setCrearCliente(String crearCliente){this.crearCliente = crearCliente;}

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Libro> getListaLibros(){
        return listaLibros;
    }

    public ArrayList<Empleado> getListaEmpleados(){
        return listaEmpleados;
    }
}
