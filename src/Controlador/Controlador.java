package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import Modelo.Articulo;
import Modelo.Modelo;
import Vista.Vista;

public class Controlador extends JFrame implements ActionListener {
    public Vista v;
    public Modelo m;
    final DefaultListModel<Articulo> temporal = new DefaultListModel();
    
    public Controlador(Vista v, Modelo m){
        this.v = v;
        this.m = m;
        this.v.vv.buttonPagar.addActionListener(this);
        this.v.vv.buttonPersonal.addActionListener(this);
        this.v.vv.buttonAlmacen.addActionListener(this);
        this.v.vv.buttonReportes.addActionListener(this);
        mouse();
    }
    
    public void iniciarVistaVentas(String nombre, String puesto){
        if(puesto.equals("Gerente")){
            v.vv.setVisible(true);
            v.vv.setSize(560,380); 
            v.vv.setDefaultCloseOperation(EXIT_ON_CLOSE);
            v.vv.setResizable(true);
            v.vv.setLocation(100,100);
            v.vv.setTitle("Ventas-root");    
            v.vv.lMensajeBienvenida.setText(v.vv.lMensajeBienvenida.getText()+nombre);
        }
        
        else{
            v.vv.setVisible(true);
            v.vv.setSize(560,380); 
            v.vv.setDefaultCloseOperation(EXIT_ON_CLOSE);
            v.vv.setResizable(true);
            v.vv.setLocation(100,100);
            v.vv.setTitle("Ventas");    
            v.vv.lMensajeBienvenida.setText(v.vv.lMensajeBienvenida.getText()+nombre);
            v.vv.buttonAlmacen.setVisible(false);
            v.vv.buttonPersonal.setVisible(false);
            v.vv.buttonReportes.setVisible(false);
        }
    }
    
    //Definicion de eventos con ActionListener
    @Override
    public void actionPerformed(ActionEvent evento){
        try{
            //Se agrega el evento al boton pagar
            if(v.vv.buttonPagar == evento.getSource()){
                //Ejecuta el evento vender y manda a imprimir el total a pagar
                JOptionPane.showMessageDialog(rootPane, "Total a pagar: $"+m.a.vender(temporal));
                temporal.removeAllElements();   //Reinicia el jlist al hacer las ventas
                v.vv.list.setModel(temporal);
                v.vv.tfCantidad.setText("Agrega la cantidad que deseas");
            }
            
            //Muestra el reporte de ventas por categorias
            if(v.vv.buttonReportes == evento.getSource()){
                JOptionPane.showMessageDialog(rootPane, "REPORTE DE VENTAS POR CATEGORIAS\n\n"
                        + "Bebidas: $"+m.a.beb
                        + "\nFarmacia: $"+m.a.farm
                        + "\nComida: $"+m.a.com
                        + "\nElectrónicos: $"+m.a.elec
                        + "\nVestimenta: $"+m.a.vest);
            }
            
            //Eventos de la ventana Almacen
            //Evento del botón almacen, abre la ventana
            if(v.vv.buttonAlmacen == evento.getSource()){
                v.m.marco();            
                v.m.setSize(550,600);
                v.m.setVisible(true);
                v.m.setTitle("Almacen");
                v.m.setDefaultCloseOperation(HIDE_ON_CLOSE);
                this.v.m.buttonAgregar.addActionListener(this);
                this.v.m.buttonEditar.addActionListener(this);
                this.v.m.buttonBebidas.addActionListener(this);
                this.v.m.buttonFarmacia.addActionListener(this);
                this.v.m.buttonComida.addActionListener(this);
                this.v.m.buttonElectronicos.addActionListener(this);
                this.v.m.buttonVestimenta.addActionListener(this);
            }
            
            //Añade más productos al almacen
            if(v.m.buttonEditar == evento.getSource()){
                int indice = v.m.list.getSelectedIndex();   //Guarda el indice del elementos seleccionado
                
                //Comprueba que se haya seleccionado un elmento
                if(indice>0){
                    String nombre = m.a.bebidas.elementAt(indice).getNombre();
                    String categoria = m.a.bebidas.elementAt(indice).getCategoria();
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la cantidad  de producto"
                                                        + " a añadir:"));
                    //Cambia el valor en el almacen
                    m.a.editar(nombre, categoria, cantidad);
                    //Actualiza la lista de productos el almacen
                    v.m.list.setModel(m.a.recuperarTodosLosProductos(categoria));
                }
            
                else{
                    JOptionPane.showMessageDialog(null,"Selecciona un articulo primero");
                }
            }
            
            //Los siguientes eventos cambian el contenido del Jlist dependiendo del boton seleccionado
            if(v.m.buttonBebidas == evento.getSource()){
                v.m.list.setModel(m.a.recuperarTodosLosProductos("Bebidas"));
            }
        
            if(v.m.buttonFarmacia == evento.getSource()){
                v.m.list.setModel(m.a.recuperarTodosLosProductos("Farmacia"));
            }
        
            if(v.m.buttonComida == evento.getSource()){
                v.m.list.setModel(m.a.recuperarTodosLosProductos("Comida"));
            }
        
            if(v.m.buttonElectronicos == evento.getSource()){
                v.m.list.setModel(m.a.recuperarTodosLosProductos("Electronicos"));
            }
        
            if(v.m.buttonVestimenta == evento.getSource()){
                v.m.list.setModel(m.a.recuperarTodosLosProductos("Vestimenta"));
            }
            
            //Agrega un elemento al almacen
            if(v.m.buttonAgregar == evento.getSource()){
                //Comprueba que no haya algun campo vacio
                if(v.m.tfNombre.getText().equals("")||v.m.tfDescripcion.getText().equals("")
                        ||v.m.tfCategoria.getText().equals("")||v.m.tfPrecio.getText().equals("")
                        ||v.m.tfExistencia.getText().equals("")){
                
                    JOptionPane.showMessageDialog(null,"Existe un campo vacio, llenelos todos");
                }
            
                else{
                    Float precio = Float.parseFloat(v.m.tfPrecio.getText());
                    int existencia = (int) Float.parseFloat(v.m.tfExistencia.getText());
                    //Agrega el articulo al almacen
                    if(m.a.agregar(v.m.tfNombre.getText(), v.m.tfCategoria.getText(), v.m.tfDescripcion.getText(), precio, existencia)){
                        //Limpia los campos de texto
                        v.m.tfNombre.setText("");
                        v.m.tfCategoria.setText("");
                        v.m.tfDescripcion.setText("");
                        v.m.tfPrecio.setText("");
                        v.m.tfExistencia.setText("");   
                        JOptionPane.showMessageDialog(null,"Producto agregado al almacen con éxito");
                    }
                    
                    //Actualiza el Jlist
                    v.m.list.setModel(m.a.recuperarTodosLosProductos(v.m.tfCategoria.getText()));
                }
            }
        
            //Eventos de la ventana Personal
            //Inicializa la ventana
            if(v.vv.buttonPersonal == evento.getSource()){
                v.p.marco();            
                v.p.setSize(550,600);
                v.p.setVisible(true);
                v.p.setDefaultCloseOperation(HIDE_ON_CLOSE);
                this.v.p.buttonAgregar.addActionListener(this);
                this.v.p.buttonEditar.addActionListener(this);
                this.v.p.buttonEliminar.addActionListener(this);
                //Actualiza el Jlist con el personal actual
                v.p.list.setModel(m.ap.recuperarPersonal());
            }
        
            //Evento del bontón "agregar"
            if(v.p.buttonAgregar == evento.getSource()){
                //Comprueba que no haya algun campo vacio
                if(v.p.tfNombre.getText().equals("")||v.p.tfApellido.getText().equals("")
                        ||v.p.tfPuesto.getText().equals("")||v.p.tfSalario.getText().equals("")
                        ||v.p.tfUsuario.getText().equals("")||v.p.tfContrasena.getText().equals("")){
                
                    JOptionPane.showMessageDialog(null,"Existe un campo vacio, llenelos todos");
                }
            
                else{
                    //Agrega el nuevo personal
                    m.ap.agregar(v.p.tfNombre.getText(), v.p.tfApellido.getText(), 
                                 v.p.tfPuesto.getText(), Float.parseFloat(v.p.tfSalario.getText()), 
                                 v.p.tfUsuario.getText(), v.p.tfContrasena.getText());
            
                    JOptionPane.showMessageDialog(null,"Personal agregado con éxito");
                    v.p.list.setModel(m.ap.recuperarPersonal());
                }
            }
        
            //Evento del botón "editar", cambia el password del personal
            if(v.p.buttonEditar == evento.getSource()){
                int indice = v.p.list.getSelectedIndex();
                //Comprueba que se haya seleccionado un elemento
                if(indice>0){
                    //Pregunta y almacena el nuevo password
                    String password = JOptionPane.showInputDialog(null,"Ingresa el nuevo Password:");
                    //cambia el password
                    m.ap.editarPassword(indice, password);
                    v.p.list.setModel(m.ap.recuperarPersonal());
                }
                
                else
                    JOptionPane.showMessageDialog(null,"Selecciona un  trabajador primero");
            }
        
            //Evento del botón eliminar, elimina el elemento seleccionado
            if(v.p.buttonEliminar == evento.getSource()){
                int indice = v.p.list.getSelectedIndex();
                //Comprueba que se haya elegido un elemento
                if(indice>0){
                    //Pide la confirmacion para hacerlo
                    String resp = JOptionPane.showInputDialog(null,"Estás seguro de que seas eliminarlo?"
                                                                + "\nSi - para confirmar");
                    if(resp.equals("Si") || resp.equals("si")){
                        m.ap.eliminar(indice);
                        JOptionPane.showMessageDialog(null,"Personal eliminado con éxito");
                        v.p.list.setModel(m.ap.recuperarPersonal());
                    }
                }
            
                else
                    JOptionPane.showMessageDialog(null,"Selecciona un trabajador primero");
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void mouse(){
        //Eventos restantes, estos se ejecutan al hacer el "click"
        try{
            /*Evento del combobox "Categoria" al seleccionar alguna categoria
                Se actualiza el combobox de productos
            */
            v.vv.cbCategoria.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    v.vv.cbProductos.removeAllItems();  //Elimina todos los elementos del combobox de productos
                    
                    //recupera el elementos seleccionado del combobox
                    String categoria = (String) v.vv.cbCategoria.getSelectedItem(); 
                    
                    //Dependiendo del elemento seleccionado se actualiza el combobox de productos
                    switch(categoria){
                        case "Bebidas":
                            if(m.a.bebidas.isEmpty())   //Comprueba si está vacio el almacen
                                v.vv.cbProductos.addItem("No hay productos en el almacen");
                            
                            else
                                for(int i = 0; i<m.a.bebidas.getSize(); i++)    //llena el sgundo combobox con los productos
                                    v.vv.cbProductos.addItem(m.recuperarNombre(i, categoria));    
                        break;
                        
                        case "Farmacia":
                            if(m.a.farmacia.isEmpty())
                                v.vv.cbProductos.addItem("No hay productos en el almacen");
                            
                            else
                                for(int i = 0; i<m.a.farmacia.getSize(); i++)
                                    v.vv.cbProductos.addItem(m.recuperarNombre(i, categoria));    
                        break;
                        
                        case "Comida":
                            if(m.a.comida.isEmpty())
                                v.vv.cbProductos.addItem("No hay productos en el almacen");
                            
                            else
                                for(int i = 0; i<m.a.comida.getSize(); i++)
                                    v.vv.cbProductos.addItem(m.recuperarNombre(i, categoria));   
                        break;
                        
                        case "Electronicos":
                            if(m.a.electronicos.isEmpty())
                                v.vv.cbProductos.addItem("No hay productos en el almacen");

                            else
                                for(int i = 0; i<m.a.electronicos.getSize(); i++)
                                    v.vv.cbProductos.addItem(m.recuperarNombre(i, categoria));    
                        break;

                        case "Vestimenta":
                            if(m.a.vestimenta.isEmpty())
                                v.vv.cbProductos.addItem("No hay productos en el almacen");

                            else
                                for(int i = 0; i<m.a.vestimenta.getSize(); i++)
                                    v.vv.cbProductos.addItem(m.recuperarNombre(i, categoria));    
                        break;
                    }
                }
            });
        
            //Evento del boton agregar de la ventana Ventas
            v.vv.buttonAgregar.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    int cantidad;
                    Boolean continuarCantidad = false;
                    Boolean seleccionar = false;
                    Boolean continuarExistencia = false;
                
                    //Comprueba que no esté vació el campo cantidad
                    if(!"".equals(v.vv.tfCantidad.getText())) {
                        cantidad = (int) Float.parseFloat(v.vv.tfCantidad.getText());
                        
                        //Comprueba que no sea un valor negativo
                        if(cantidad > 0)
                            continuarCantidad = true;
                        
                        //Comprueba que se haya seleccionado un producto
                        if(("Selecciona".equals((String)v.vv.cbProductos.getSelectedItem())) == false)
                            seleccionar = true; 
                        
                        //recupera la existencia del producto seleccionado y su nombre
                        int existencia = m.a.recuperarExistencia((String) v.vv.cbProductos.getSelectedItem(), (String) v.vv.cbCategoria.getSelectedItem());
                        String nombre = (String) v.vv.cbProductos.getSelectedItem();
                        
                        //Comprueba que se pueda vender la cantidad deseada
                        if(existencia>=cantidad)
                            continuarExistencia = true;
                        
                        if(seleccionar){    //entra si se seleccionó un producto
                            if(continuarCantidad){  //entra si la cantidad es valida
                                if(continuarExistencia){    //entra si se puede surtir la cantidad del producto
                                    //Añade todos los productos seleccionados a una lista temporal
                                    temporal.addElement(new Articulo((String) v.vv.cbProductos.getSelectedItem(), 
                                    (String) v.vv.cbCategoria.getSelectedItem(),
                                    (int) Double.parseDouble(v.vv.tfCantidad.getText())));
                                    //v.vv.list.setModel(temporal);   //Se la pasa al list para que lo muestre
                                    v.vv.list.setModel(m.a.recuperarNombre(temporal));
                                    v.vv.tfCantidad.setText("Agrega la cantidad que deseas");
                                }
                                
                                else{
                                    if(existencia == 0)
                                        JOptionPane.showMessageDialog(rootPane, "No hay producto disponible en el almacen");
                                    
                                    else
                                        JOptionPane.showMessageDialog(rootPane, "Solo se encuentran en existencia "+existencia+" productos de "+nombre);
                                }  
                            }
                        
                            else
                                JOptionPane.showMessageDialog(rootPane, "Ingresa una cantidad valida");
                        }
                        
                        else
                                JOptionPane.showMessageDialog(rootPane, "Elige un producto de la lista");
                    }
                }
            });
        
            //Evento del boton eliminar, elimina el producto seleccionado en la ventana Ventas
            v.vv.buttonEliminar.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    int index = v.vv.list.getSelectedIndex();
                    //Comprueba que haya un elemento seleccionado
                    if(index<0)
                        JOptionPane.showMessageDialog(rootPane, "No hay productos agregados en la lista");
                
                    else
                        temporal.remove(index);
                }
            });
            
            //Evento que limpia el campo de texto de la ventana Ventas
            v.vv.tfCantidad.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    v.vv.tfCantidad.setText("");
                }
            });
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}