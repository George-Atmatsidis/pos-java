package Modelo;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Almacen extends javax.swing.JFrame{
    //Lugar donde se almacenaran todos los productos
    public DefaultListModel<Articulo> bebidas;
    public DefaultListModel<Articulo> farmacia;
    public DefaultListModel<Articulo> comida;
    public DefaultListModel<Articulo> electronicos;
    public DefaultListModel<Articulo> vestimenta;
    
    public float beb = 0;
    public float farm = 0;
    public float com = 0;
    public float elec = 0;
    public float vest = 0;
    
    public Almacen(){
        bebidas = new DefaultListModel<Articulo>();
        farmacia = new DefaultListModel<Articulo>();
        comida = new DefaultListModel<Articulo>();
        electronicos = new DefaultListModel<Articulo>();
        vestimenta = new DefaultListModel<Articulo>();
    }
    
    public Boolean agregar(String nombre, String categoria, String descripcion, Float precio, int existencia){
        Boolean exito = false;
        
        switch(categoria){
            case "Bebidas":
                bebidas.addElement(new Articulo(nombre, categoria, descripcion, precio, existencia));
                exito = true;
            break;
                
            case "Farmacia":
                farmacia.addElement(new Articulo(nombre, categoria, descripcion, precio, existencia));
                exito = true;
            break;
                
            case "Comida":
                comida.addElement(new Articulo(nombre, categoria, descripcion, precio, existencia));
                exito = true;
            break;
                
            case "Electronicos":
                electronicos.addElement(new Articulo(nombre, categoria, descripcion, precio, existencia));
                exito = true;
            break;
                
            case "Vestimenta":
                vestimenta.addElement(new Articulo(nombre, categoria, descripcion, precio, existencia));
                exito = true;
            break;
                
            default:
                JOptionPane.showMessageDialog(null,"El almacen no existe, verificalo por favor");
            break;
        }
        
        return exito;
    }
    
    public void eliminar(int index, String categoria){
        switch(categoria){
            case "Bebidas":
                if(index >= 0)
                    bebidas.remove(index);
        
                else
                    JOptionPane.showMessageDialog(rootPane,"No hay elementos en la lista");
            break;
                
            case "Farmacia":
                if(index >= 0)
                    farmacia.remove(index);
        
                else
                    JOptionPane.showMessageDialog(rootPane,"No hay elementos en la lista");
            break;
                
            case "Comida":
                if(index >= 0)
                    comida.remove(index);
        
                else
                    JOptionPane.showMessageDialog(rootPane,"No hay elementos en la lista");
            break;
                
            case "Electronicos":
                if(index >= 0)
                    electronicos.remove(index);
        
                else
                    JOptionPane.showMessageDialog(rootPane,"No hay elementos en la lista");
            break;
                
            case "Vestimenta":
                if(index >= 0)
                    vestimenta.remove(index);
        
                else
                    JOptionPane.showMessageDialog(rootPane,"No hay elementos en la lista");
            break;
        }
    }
    
    public void editar(String nombre, String categoria, int cantidad){
        //Cantidad es el numero de productos que se añadiran al almacen
        
        switch(categoria){
            case "Bebidas":
                for(int i = 0; i < bebidas.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(bebidas.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        int existencia = bebidas.elementAt(i).getExistencia();
                            
                        if(cantidad > 0){
                            bebidas.elementAt(i).setExistencia(existencia+cantidad);
                            JOptionPane.showMessageDialog(rootPane, "Existencia modificada con éxito");
                        }
                            
                        else
                            JOptionPane.showMessageDialog(rootPane, "No se aceptan números negativos");
                            
                        break;
                    }
                }
            break;
                
            case "Farmacia":
                for(int i = 0; i < farmacia.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(farmacia.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        int existencia = farmacia.elementAt(i).getExistencia();
                            
                        if(cantidad > 0){
                            farmacia.elementAt(i).setExistencia(existencia+cantidad);
                            JOptionPane.showMessageDialog(rootPane, "Existencia modificada con éxito");
                        }
                            
                        else
                            JOptionPane.showMessageDialog(rootPane, "No se aceptan números negativos");
                            
                        break;
                    }
                }
            break;
                
            case "Comida":
                for(int i = 0; i < comida.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(comida.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        int existencia = comida.elementAt(i).getExistencia();
                            
                        if(cantidad > 0){
                            comida.elementAt(i).setExistencia(existencia+cantidad);
                            JOptionPane.showMessageDialog(rootPane, "Existencia modificada con éxito");
                        }
                            
                        else
                            JOptionPane.showMessageDialog(rootPane, "No se aceptan números negativos");
                            
                        break;
                    }
                }
            break;
                
            case "Electronicos":
                for(int i = 0; i < electronicos.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(electronicos.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        int existencia = electronicos.elementAt(i).getExistencia();
                            
                        if(cantidad > 0){
                            electronicos.elementAt(i).setExistencia(existencia+cantidad);
                            JOptionPane.showMessageDialog(rootPane, "Existencia modificada con éxito");
                        }
                            
                        else
                            JOptionPane.showMessageDialog(rootPane, "No se aceptan números negativos");
                            
                        break;
                    }
                }
            break;
                
            case "Vestimenta":
                for(int i = 0; i < vestimenta.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(vestimenta.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        int existencia = vestimenta.elementAt(i).getExistencia();
                            
                        if(cantidad > 0){
                            vestimenta.elementAt(i).setExistencia(existencia+cantidad);
                            JOptionPane.showMessageDialog(rootPane, "Existencia modificada con éxito");
                        }
                            
                        else
                            JOptionPane.showMessageDialog(rootPane, "No se aceptan números negativos");
                            
                        break;
                    }
                }
            break;
        }
    }
    
    public Float vender(DefaultListModel<Articulo> listaCompras){
        Float total = 0f;
        
        for(int i = 0; i < listaCompras.getSize(); i++){
            String categoria = listaCompras.elementAt(i).getCategoria();
            /*
                Acontinuacion la variable existencia de listaCompra representará
                la cantidad de articulos que se van a vender
            */
            int cantidadAVender = listaCompras.elementAt(i).getExistencia();
            String nombre = listaCompras.elementAt(i).getNombre();
            
            switch(categoria){
                case "Bebidas":
                    for(int j = 0; j<bebidas.getSize(); j++){
                        //Busca donde está almacenado el producto
                        if(nombre.equals(bebidas.elementAt(j).getNombre())){
                            //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                            int existencia = bebidas.elementAt(j).getExistencia();
                            int calculo = existencia-cantidadAVender;
                            
                            bebidas.elementAt(j).setExistencia(calculo);
                            total = total + (cantidadAVender*bebidas.elementAt(j).getPrecio());
                            beb = beb + (cantidadAVender*bebidas.elementAt(j).getPrecio());    
                            break;
                        }
                    }  
                break;
                
                case "Farmacia":
                    for(int j = 0; j < farmacia.getSize(); j++){
                        //Busca donde está almacenado el producto
                        if(nombre.equals(farmacia.elementAt(j).getNombre())){
                            //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                            int existencia = farmacia.elementAt(j).getExistencia();
                            int calculo = existencia-cantidadAVender;
                            
                            farmacia.elementAt(j).setExistencia(calculo);
                            total = total + (cantidadAVender*farmacia.elementAt(j).getPrecio());
                            farm = farm + (cantidadAVender*farmacia.elementAt(j).getPrecio());    
                            break;
                        }
                    }
                break;
            
                case "Comida":
                    for(int j = 0; j < comida.getSize(); j++){
                        //Busca donde está almacenado el producto
                        if(nombre.equals(comida.elementAt(j).getNombre())){
                            //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                            int existencia = comida.elementAt(j).getExistencia();
                            int calculo = existencia-cantidadAVender;
                            
                            comida.elementAt(j).setExistencia(calculo);
                            total = total + (cantidadAVender*comida.elementAt(j).getPrecio());
                            com = com + (cantidadAVender*comida.elementAt(j).getPrecio());
                            break;
                        }
                    }
                break;
                
                case "Electronicos":
                    for(int j = 0; j < electronicos.getSize(); j++){
                        //Busca donde está almacenado el producto
                        if(nombre.equals(electronicos.elementAt(j).getNombre())){
                            //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                            int existencia = electronicos.elementAt(j).getExistencia();
                            int calculo = existencia-cantidadAVender;
                            
                            electronicos.elementAt(j).setExistencia(calculo);
                            total = total + (cantidadAVender*electronicos.elementAt(j).getPrecio());
                            elec = elec + (cantidadAVender*electronicos.elementAt(j).getPrecio());
                            break;
                        }
                    }         
                break;
                
                case "Vestimenta":
                    for(int j = 0; j < vestimenta.getSize(); j++){
                        //Busca donde está almacenado el producto
                        if(nombre.equals(vestimenta.elementAt(j).getNombre())){
                            //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                            int existencia = vestimenta.elementAt(j).getExistencia();
                            int calculo = existencia-cantidadAVender;
                            
                            vestimenta.elementAt(j).setExistencia(calculo);
                            total = total + (cantidadAVender*vestimenta.elementAt(j).getPrecio());
                            vest = vest + (cantidadAVender*vestimenta.elementAt(j).getPrecio());
                            break;
                        }
                    }           
                break;
            }
        }
        
        return total;
    }
    
    public int recuperarExistencia(String nombre, String categoria){
        int existencia = 0;
        
        switch(categoria){
            case "Bebidas":
                for(int i = 0; i < bebidas.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(bebidas.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        existencia = bebidas.elementAt(i).getExistencia();
                    break;
                }
            }
            
            case "Farmacia":
                for(int i = 0; i < farmacia.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(farmacia.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        existencia = farmacia.elementAt(i).getExistencia();
                    break;
                }
            }
            
            case "Comida":
                for(int i = 0; i < comida.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(comida.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        existencia = comida.elementAt(i).getExistencia();
                    break;
                }
            }
            
            case "Electronicos":
                for(int i = 0; i < electronicos.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(electronicos.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        existencia = electronicos.elementAt(i).getExistencia();
                    break;
                }
            }
            
            case "Vestimenta":
                for(int i = 0; i < vestimenta.getSize(); i++){
                    //Busca donde está almacenado el producto
                    if(nombre.equals(vestimenta.elementAt(i).getNombre())){
                        //Comprueba que la existencia despues de hacer la venta sea mayor a 0
                        existencia = vestimenta.elementAt(i).getExistencia();
                    break;
                }
            }
        }
        
        return existencia;
    }
    
    public DefaultListModel recuperarTodosLosProductos(String categoria){
        DefaultListModel r = new DefaultListModel();
        
        switch(categoria){
            case "Bebidas":
                for(int i = 0; i<bebidas.getSize(); i++)
                    r.addElement((Articulo)bebidas.elementAt(i));
                
            break;
            
            case "Farmacia":
                for(int i = 0; i<farmacia.getSize(); i++)
                    r.addElement((Articulo)farmacia.elementAt(i));
            
            break;
            
            case "Comida":
                for(int i = 0; i<comida.getSize(); i++)
                    r.addElement((Articulo)comida.elementAt(i));
            
            break;
        
            case "Vestimenta":
                for(int i = 0; i<vestimenta.getSize(); i++)
                    r.addElement((Articulo)vestimenta.elementAt(i));
            break;
            
            case "Electronicos":
                for(int i = 0; i<electronicos.getSize(); i++)
                    r.addElement((Articulo)electronicos.elementAt(i));
            break;
        }
        return r;
    }
    
    public DefaultListModel<String> recuperarNombre(DefaultListModel<Articulo> temporal){
        DefaultListModel<String> lista = new DefaultListModel();
        
        for(int i = 0; i<temporal.getSize(); i++){
            String categoria = temporal.elementAt(i).getCategoria();
            
            switch(categoria){
                case "Bebidas":
                    for(int j = 0; j<bebidas.getSize(); j++){
                        if(temporal.elementAt(i).getNombre().equals(bebidas.elementAt(j).getNombre())){
                            String nombre = bebidas.elementAt(j).getNombre();
                            String descripcion =  bebidas.elementAt(j).getDescripcion();
                            String precio = String.valueOf(bebidas.elementAt(j).getPrecio());
                            String cantidad = Integer.toString(temporal.elementAt(i).getExistencia());
                            String dato = nombre+",   "+descripcion+",   Precio: $"+precio+",   Cantidad: "+cantidad;
                            lista.addElement(dato);
                        }
                    }
                break;
                    
                case "Farmacia":
                    for(int j = 0; j<farmacia.getSize(); j++){
                        if(temporal.elementAt(i).getNombre().equals(farmacia.elementAt(j).getNombre())){
                            String nombre = farmacia.elementAt(j).getNombre();
                            String descripcion =  farmacia.elementAt(j).getDescripcion();
                            String precio = String.valueOf(farmacia.elementAt(j).getPrecio());
                            String cantidad = Integer.toString(temporal.elementAt(i).getExistencia());
                            String dato = nombre+",   "+descripcion+",   Precio: $"+precio+",   Cantidad: "+cantidad;
                            lista.addElement(dato);
                        }
                    }
                break;
            
                case "Comida":
                    for(int j = 0; j<comida.getSize(); j++){
                        if(temporal.elementAt(i).getNombre().equals(comida.elementAt(j).getNombre())){
                            String nombre = comida.elementAt(j).getNombre();
                            String descripcion =  comida.elementAt(j).getDescripcion();
                            String precio = String.valueOf(comida.elementAt(j).getPrecio());
                            String cantidad = Integer.toString(temporal.elementAt(i).getExistencia());
                            String dato = nombre+",   "+descripcion+",   Precio: $"+precio+",   Cantidad: "+cantidad;
                            lista.addElement(dato);
                        }
                    }
                break;
        
                case "Vestimenta":
                for(int j = 0; j<vestimenta.getSize(); j++){
                        if(temporal.elementAt(i).getNombre().equals(vestimenta.elementAt(j).getNombre())){
                            String nombre = vestimenta.elementAt(j).getNombre();
                            String descripcion =  vestimenta.elementAt(j).getDescripcion();
                            String precio = String.valueOf(vestimenta.elementAt(j).getPrecio());
                            String cantidad = Integer.toString(temporal.elementAt(i).getExistencia());
                            String dato = nombre+",   "+descripcion+",   Precio: $"+precio+",   Cantidad: "+cantidad;
                            lista.addElement(dato);
                        }
                    }
                break;
            
                case "Electronicos":
                for(int j = 0; j<electronicos.getSize(); j++){
                        if(temporal.elementAt(i).getNombre().equals(electronicos.elementAt(j).getNombre())){
                            String nombre = electronicos.elementAt(j).getNombre();
                            String descripcion =  electronicos.elementAt(j).getDescripcion();
                            String precio = String.valueOf(electronicos.elementAt(j).getPrecio());
                            String cantidad = Integer.toString(temporal.elementAt(i).getExistencia());
                            String dato = nombre+",   "+descripcion+",   Precio: $"+precio+",   Cantidad: "+cantidad;
                            lista.addElement(dato);
                        }
                    }
                break;
            }
        }
        
        return lista;
    }
}