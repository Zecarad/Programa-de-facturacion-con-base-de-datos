/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

import proyecto.pkgfinal.Menú;
import proyecto.pkgfinal.Login;
import java.sql.*;
import javax.swing.JOptionPane;

public class claselogin {
    public void acceso(String usuario ,String clave){
Connection conexio=null;
Statement consulta=null;
ResultSet tabla=null;
try{
Class.forName("com.mysql.jdbc.Driver");
conexio=DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","root");//conexion a la base de datos
consulta=conexio.createStatement();
tabla=consulta.executeQuery("select usuario , contraseña from usuarios where usuario='"+usuario+"'and contraseña='"+clave+"'");//el ingreso a mi sistema
if(tabla.next()){
JOptionPane.showMessageDialog(null, "Datos aceptados, Bienvenido "+usuario+"");
Menú menu=new Menú();
menu.show();
menu.setExtendedState(new Menú().MAXIMIZED_BOTH);
}
else{
JOptionPane.showMessageDialog(null,"Usuario y Clave Incorrecto");
 new Login().setVisible(true);
}
}catch(ClassNotFoundException |SQLException e){

JOptionPane.showMessageDialog(null, e.getMessage());

}

}
}
