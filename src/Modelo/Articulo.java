package Modelo;

public class Articulo {
    private String nombre;
    private String categoria;
    private String descripcion;
    private Float precio;
    private int existencia;

    public Articulo() {
    }
    
    //al momento de hacer las ventas
    public Articulo(String nombre, String categoria, int existencia) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.existencia = existencia;
    }
    
    //añadir articulo al almace
    public Articulo(String nombre, String categoria, String descripcion, Float precio, int existencia) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    @Override
    public String toString() {
        return nombre+",   " + descripcion + ",   precio: $" + precio + ",   existencia:" + existencia;
    }
}