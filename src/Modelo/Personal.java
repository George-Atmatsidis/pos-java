package Modelo;

public class Personal {
    private String nombre;
    private String apellido;
    private String puesto;
    private Float salario;
    private String numControl;
    private String contrasena;

    public Personal() {
    }
    //fue prueba
    public Personal(String numControl) {
        this.numControl = numControl;
    }
    //se utiliza cada vez que quieres agregar un nuevo persona
    public Personal(String nombre, String apellido, String puesto, Float salario, String numControl, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.salario = salario;
        this.numControl = numControl;
        this.contrasena = contrasena;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return nombre+" "+ apellido + ",   puesto: " + puesto + ",   salario: $" + salario + ",   Usuario: " + numControl + ",   Password: " + contrasena;
    }
}