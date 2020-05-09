package Vista;

/*
    Creo objetos de las vistas para asi poder acceder a todos sus 
    elementos
*/

public class Vista {
    public Ventas vv;
    public Mercancia m;
    public Personal p;

    public Vista() {
        vv = new Ventas();
        m = new Mercancia();
        p = new Personal();
    }
}