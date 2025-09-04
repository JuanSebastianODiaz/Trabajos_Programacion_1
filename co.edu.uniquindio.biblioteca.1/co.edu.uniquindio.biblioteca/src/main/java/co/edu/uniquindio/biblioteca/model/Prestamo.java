package co.edu.uniquindio.biblioteca.model;

public class Prestamo {

    private String numeroPrestamo;
    private String fechaPrestamo;
    private String fechaEntrega;
    private String descripcion;

    Prestamo(String numeroPrestamo, String fechaPrestamo, String fechaEntrega, String descripcion){
        this.numeroPrestamo = numeroPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
    }

    public String getNumeroPrestamo(){
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(String numeroPrestamo){
        this.numeroPrestamo = numeroPrestamo;
    }

    public String getFechaPrestamo(){
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaEntrega(){
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega){
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
