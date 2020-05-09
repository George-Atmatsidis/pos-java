package Modelo;

/*
    Creo objetos de todo lo relacionado para asi poder acceder
    a todos los elementos y metodos disponibles
*/

public class Modelo {
    public Almacen a;
    public AlmacenamientoPersonal ap;
    
    public Modelo(){
        a = new Almacen();
        ap = new AlmacenamientoPersonal();
        
        //Inicializacion de productos en el almacen
        a.agregar("Coca Cola", "Bebidas", "600ml", 11f, 10);
        a.agregar("Pepsi", "Bebidas", "600ml", 11f, 10);
        a.agregar("Big Cola", "Bebidas", "600ml", 11f, 10);
        a.agregar("Paracetamol", "Farmacia", "15 capsulas", 70f, 10);
        a.agregar("Condones", "Farmacia", "2 articulos", 40f, 10);
        a.agregar("Curitas", "Farmacia", "5 articulos", 10f, 10);
        a.agregar("Sabritas", "Comida", "Originales", 10f, 10);
        a.agregar("Toreadas", "Comida", "Habanero", 10f, 10);
        a.agregar("Carne", "Comida", "De Res", 70f, 10);
        a.agregar("Audifonos", "Electronicos", "Distintos colores", 15f, 10);
        a.agregar("Bocinas", "Electronicos", "Entrada USB", 300f, 10);
        a.agregar("Memoria USB", "Electronicos", "8GB de almacenamiento", 80f, 10);
        a.agregar("Pantalon", "Vestimenta", "Levis", 200f, 10);
        a.agregar("Playera", "Vestimenta", "Cuidado con el perro", 150f, 10);
        a.agregar("Bermuda", "Vestimenta", "Cuadriculada", 200f, 10);
        
        //Inicializacion de personal
        ap.agregar("Ruben", "Garcia", "Vendedor", 2000f, "55", "55");
        ap.agregar("Guillermo","Guzman","Gerente",2000f,"89","89");
        ap.agregar("Israel","Marcial","Gerente",2000f,"99","99");
    }
    
    //Método para recuperar el nombre del producto en su respectiva posición y almacen
    //Usado para llenar el comboBox de Productos
    public String recuperarNombre(int i, String categoria){
        String h = "";
        
        switch(categoria){
            case "Bebidas":
                h = a.bebidas.elementAt(i).getNombre();
            break;
                
            case "Farmacia":
                h = a.farmacia.elementAt(i).getNombre();
            break;
                
            case "Comida":
                h = a.comida.elementAt(i).getNombre();
            break;
                
            case "Electronicos":    
                h = a.electronicos.elementAt(i).getNombre();
            break;
                
            case "Vestimenta":
                h = a.vestimenta.elementAt(i).getNombre();
            break;
        }
        
        return h;
    }
}