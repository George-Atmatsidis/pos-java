package Vista;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Personal extends JFrame {
    public JList list;
    public JScrollPane spList;
    public JLabel lNombre;
    public JLabel lApellido;
    public JLabel lPuesto;
    public JLabel lSalario;
    public JLabel lUsuario;
    public JLabel lContrasena;
    public JTextField tfNombre;
    public JTextField tfApellido;
    public JTextField tfPuesto;
    public JTextField tfSalario;
    public JTextField tfUsuario;
    public JTextField tfContrasena;
    public JButton buttonAgregar;
    public JButton buttonEditar;
    public JButton buttonEliminar;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Personal (){
        marco();
    }
    
    public void marco(){
        JPanel contenedor;
        Font a = new Font("arial", Font.BOLD, 14);
        
        contenedor = new JPanel();
        contenedor.setLayout(null);
        
        list = new JList();
        spList = new JScrollPane(list);
        
        lNombre = new JLabel("Nombre");
        lApellido = new JLabel("Apellidos");
        lPuesto = new JLabel("Puesto");
        lSalario = new JLabel("Salario");
        lUsuario = new JLabel("Usuario");
        lContrasena = new JLabel("Contraseña");
        
        tfNombre = new JTextField();
        tfApellido = new JTextField();
        tfPuesto = new JTextField();
        tfSalario = new JTextField();
        tfUsuario = new JTextField();
        tfContrasena = new JTextField();
        
        buttonAgregar = new JButton("Agregar");
        buttonEditar = new JButton("Editar");
        buttonEliminar = new JButton("Eliminar");
        
        lNombre.setFont(a);
        lApellido.setFont(a);
        lPuesto.setFont(a);
        lSalario.setFont(a);
        lUsuario.setFont(a);
        lContrasena.setFont(a);
        
        spList.setBounds(10,10,520,210);
        
        lNombre.setBounds(63,220,100,50);
        lApellido.setBounds(63,260,100,50);
        lPuesto.setBounds(63,300,100,50);
        lSalario.setBounds(63,340,100,50);
        lUsuario.setBounds(63,380,100,50);
        lContrasena.setBounds(63,420,100,50);
        
        tfNombre.setBounds(187,230,300,30);
        tfApellido.setBounds(187,270,300,30);
        tfPuesto.setBounds(187,310,300,30);
        tfSalario.setBounds(187,350,300,30);
        tfUsuario.setBounds(187,390,300,30);
        tfContrasena.setBounds(187,430,300,30);
        
        buttonAgregar.setBounds(83,500,100,30);
        buttonEditar.setBounds(210,500,100,30);
        buttonEliminar.setBounds(337,500,100,30);
        
        contenedor.add(spList);
        
        contenedor.add(lNombre);
        contenedor.add(lApellido);
        contenedor.add(lPuesto);
        contenedor.add(lSalario);
        contenedor.add(lUsuario);
        contenedor.add(lContrasena);
        
        contenedor.add(tfNombre);
        contenedor.add(tfApellido);
        contenedor.add(tfPuesto);
        contenedor.add(tfSalario);
        contenedor.add(tfUsuario);        
        contenedor.add(tfContrasena);
        contenedor.add(buttonAgregar);        
        contenedor.add(buttonEditar);
        contenedor.add(buttonEliminar);
        
        add(contenedor);
    }
}