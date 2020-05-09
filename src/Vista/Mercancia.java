
package Vista;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Mercancia extends JFrame{ 
    public JList list;
    public JScrollPane spList;
    public JLabel lNombre;
    public JLabel lDescripcion;
    public JLabel lCategoria;
    public JLabel lPrecio;
    public JLabel lExistencia;
    public JTextField tfNombre;
    public JTextField tfDescripcion;
    public JTextField tfCategoria;
    public JTextField tfPrecio;
    public JTextField tfExistencia;
    public JButton buttonAgregar;
    public JButton buttonEditar;
    public JButton buttonBebidas;
    public JButton buttonFarmacia;
    public JButton buttonComida;
    public JButton buttonElectronicos;
    public JButton buttonVestimenta;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Mercancia (){
        marco();
    }
    
    public void marco(){
        //Fuente que se le aplicará a las etiquetas
        Font a = new Font("arial", Font.BOLD, 18);
        
        //Creacion del Panel contenedor
        JPanel contenedor = new JPanel();
        
        contenedor.setLayout(null);
        
        //Creacion del JList y Panel
        list = new JList();
        spList = new JScrollPane(list);
        
        //Etiquetas
        lNombre = new JLabel("Nombre:");
        lDescripcion = new JLabel("Descripcion:");
        lCategoria = new JLabel("Categoria: ");
        lPrecio = new JLabel("Precio: ");
        lExistencia = new JLabel("Existencia: ");
        
        //Cajas de Texto
        tfNombre  = new JTextField();
        tfDescripcion = new JTextField();
        tfCategoria  = new JTextField();
        tfPrecio  = new JTextField();  
        tfExistencia = new JTextField();
        
        //Botones
        buttonBebidas = new JButton("Bebidas");
        buttonFarmacia = new JButton("Farmacia");
        buttonComida = new JButton("Comida");
        buttonElectronicos = new JButton("Electronicos");
        buttonVestimenta = new JButton("Vestimenta");
        buttonAgregar = new JButton("Agregar");
        buttonEditar = new JButton("Editar");
        
        //Se le asigna la fuente a las etiquetas
        lNombre.setFont(a);
        lDescripcion.setFont(a);
        lCategoria.setFont(a);
        lPrecio.setFont(a);
        lExistencia.setFont(a);
        
        //acomodo, utilizando setBounds
        //(posicion x,posicion y,ancho,altura)
        spList.setBounds(10,10,520,210);
        
        lNombre.setBounds(63,220,150,50);
        lDescripcion.setBounds(63,260,150,50);
        lCategoria.setBounds(63,300,150,50);
        lPrecio.setBounds(63,340,150,50);
        lExistencia.setBounds(63,380,150,50);
        
        tfNombre.setBounds(187,230,300,30);
        tfDescripcion.setBounds(187,270,300,30);
        tfCategoria.setBounds(187,310,300,30);
        tfPrecio.setBounds(187,350,300,30);
        tfExistencia.setBounds(187,390,300,30);
        
        buttonBebidas.setBounds(10,510,80,30);
        buttonFarmacia.setBounds(100,510,100,30);
        buttonComida.setBounds(210,510,80,30);
        buttonElectronicos.setBounds(300,510,110,30);
        buttonVestimenta.setBounds(420,510,110,30);
        
        buttonAgregar.setBounds(185,450,80,30);
        buttonEditar.setBounds(285,450,80,30);
        
        //Añadiendo los elementos al Panel
        contenedor.add(spList);
        
        contenedor.add(lNombre);
        contenedor.add(lDescripcion);
        contenedor.add(lCategoria);
        contenedor.add(lPrecio);
        contenedor.add(lExistencia);
        
        contenedor.add(tfNombre);
        contenedor.add(tfDescripcion);
        contenedor.add(tfCategoria);
        contenedor.add(tfPrecio);
        contenedor.add(tfExistencia);
        
        contenedor.add(buttonBebidas);
        contenedor.add(buttonFarmacia);
        contenedor.add(buttonComida);
        contenedor.add(buttonElectronicos);
        contenedor.add(buttonVestimenta);
        
        contenedor.add(buttonAgregar);
        contenedor.add(buttonEditar);
        
        add(contenedor);
    }
}
