package Vista;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Ventas extends JFrame {
    public JList list;
    public JScrollPane spList;
    public JLabel lMensajeBienvenida;
    public JLabel lCategoria;
    public JLabel lProducto;
    public JLabel lEspacio;
    public JTextField tfCantidad;
    public JButton buttonAgregar;
    public JButton buttonEliminar;
    public JButton buttonPagar;
    public JButton buttonAlmacen;
    public JButton buttonPersonal;
    public JButton buttonReportes;
    public JComboBox cbCategoria;
    public JComboBox cbProductos;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Ventas(){
        marco();
    }
    
    public void marco(){
        Font a = new Font("Segoe UI", Font.BOLD, 18);
        JPanel contenedor = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        
        contenedor.setLayout(new GridLayout(6,1));
        
        list = new JList();
        spList = new JScrollPane(list);
        
        lMensajeBienvenida = new JLabel("Bienvenido: ");
        lCategoria = new JLabel("Categoria:");
        lProducto = new JLabel("Productos:");
        lEspacio = new JLabel("            ");
        JLabel lEspacio2 = new JLabel("            ");
        JLabel lEspacio3 = new JLabel("            ");
        
        tfCantidad = new JTextField("Agrega la cantidad que deseas");
        
        buttonAgregar = new JButton("Agregar");
        buttonEliminar = new JButton("Eliminar");
        buttonPagar = new JButton("Pagar");
        buttonPersonal = new JButton("Personal");
        buttonAlmacen = new JButton("Almacen");
        buttonReportes = new JButton("Reporte De Ventas");
        
        String[] categorias = {"Bebidas", "Farmacia", "Electronicos", "Comida", "Vestimenta"};
        cbCategoria = new JComboBox(categorias);
        cbProductos = new JComboBox();
        
        lMensajeBienvenida.setFont(a);
        
        p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
        p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));
        p3.setLayout(new BoxLayout(p3,BoxLayout.X_AXIS));
        p4.setLayout(new BoxLayout(p4,BoxLayout.X_AXIS));
        p5.setLayout(new BoxLayout(p5,BoxLayout.X_AXIS));
        p6.setLayout(new BoxLayout(p6,BoxLayout.X_AXIS));
        
        p1.add(lMensajeBienvenida);
        p2.add(lCategoria);
        p2.add(cbCategoria);
        p3.add(lProducto);
        p3.add(cbProductos);
        p4.add(tfCantidad);
        p4.add(buttonAgregar);
        p5.add(buttonEliminar);
        p5.add(spList);
        p6.add(buttonPagar);
        p6.add(lEspacio);
        p6.add(buttonReportes);
        p6.add(lEspacio2);
        p6.add(buttonAlmacen);
        p6.add(lEspacio3);
        p6.add(buttonPersonal);
        
        contenedor.add(p1);
        contenedor.add(p2);
        contenedor.add(p3);
        contenedor.add(p4);
        contenedor.add(p5);
        contenedor.add(p6);
        
        add(contenedor);
    }
}