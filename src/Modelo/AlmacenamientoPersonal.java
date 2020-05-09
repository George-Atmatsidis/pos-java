package Modelo;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AlmacenamientoPersonal extends javax.swing.JFrame{
    //Lugar donde se almacena todo el personal
    public DefaultListModel<Personal> personal;
    
    public AlmacenamientoPersonal(){
        personal = new DefaultListModel<Personal>();
    }
    //lo jalado de personal
    public void agregar(String nombre, String apellido, String puesto, Float salario, String numControl, String contraseña){
        personal.addElement(new Personal(nombre, apellido, puesto, salario, numControl, contraseña));
    }
    
    public void eliminar(int index){
        if(index >= 0)
            personal.remove(index);
        
        else
            JOptionPane.showMessageDialog(rootPane,"No hay elementos en la lista");
    }
    
    public Personal comprobarInicioSesion(String usuario, String password){
        Personal p = new Personal("No");
        
        for(int i = 0; i < personal.getSize(); i++){
            Personal original = (Personal) personal.elementAt(i);
            
            if(usuario.equals(original.getNumControl())&&password.equals(original.getContrasena())){
                p = (Personal) original;
                break;
            }
        }
        
        return p;
    }
    
    public DefaultListModel recuperarPersonal(){
        DefaultListModel p = new DefaultListModel();
        
        for(int i = 0; i<personal.getSize(); i++)
            p.addElement((Personal) personal.elementAt(i));
        
        return p;
    }
    
    public void editarPassword(int index, String password){
        personal.elementAt(index).setContrasena(password);
    }
}