/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author jose-
 */
public class conectar {
    Connection Conectar=null;
public Connection conexion(){
try {
Class.forName("com.mysql.jdbc.Driver");
Conectar=DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","root");
} catch (Exception e) {
//System.out.print(e.getMessage());
JOptionPane.showMessageDialog(null, e.getMessage());
}
return Conectar;
}
}
