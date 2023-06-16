/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.pkgfinal;




import java.sql.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

 
public class facturacion extends javax.swing.JFrame {

    /**
     * Creates new form facturacion
     */
    public facturacion() {
        initComponents();
        txtfecha.setText(fechaactual());     
        setLocationRelativeTo(null);
        setResizable (false);
        setTitle("Crear facturas");
        mostrar("");
        
     int contador= 0;
     String pregunta;
       
     
    String estado = "Activo";
     
     this.txtclientes.removeAllItems();
        try{
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","root");
       Statement Sent = con.createStatement();
ResultSet rs = Sent.executeQuery("select * from datos WHERE Estado='"+estado+"'");
while(rs.next()){

   
    this.txtclientes.addItem(rs.getString("nombre")+" "+rs.getString("apellido"));
}
contador++;
}catch(SQLException e){
JOptionPane.showMessageDialog(null, e);   
}
///Fin combo 



 /////combo estado
this.txtproducto.removeAllItems();
try{
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","root");
Statement Sent = con.createStatement();
ResultSet rs = Sent.executeQuery("select * from productos");
while(rs.next()){

    this.txtproducto.addItem(rs.getString("descripcion"));

}
contador++;
}catch(SQLException e){
JOptionPane.showMessageDialog(null, e);   
}
///Fin combo 
     
    }
    
    void mostrar(String valor) {
    DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("SKU");
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("PRECIO");
        modelo.addColumn("DETALLES ");
        modelo.addColumn("CANTIDAD");      
        modelo.addColumn("TOTAL");
        
        factura.setModel(modelo);
        String sql="";
    
    if (valor.equals(""))
        {sql="SELECT * FROM datosdefactura";
        }
        else {
            sql= "SELECT * FROM datosdefactura WHERE Descripcion = '"+valor+"'";
                    }       
        String [] dato = new String [7];
        
         try {
            Statement stt = cn.createStatement();
            ResultSet rss = stt.executeQuery(sql);
             while(rss.next()){
                 dato[0]=rss.getString(1);
                 dato[1]=rss.getString(2);
                 dato[2]=rss.getString(3);
                 dato[3]=rss.getString(4);
                 dato[4]=rss.getString(5);
                 dato[5]=rss.getString(6);              
                 
                 modelo.addRow(dato);
                 factura.setModel(modelo); 
                     
             }
        }catch (Exception e) {
             System.out.println(e.getMessage());
        }
    
    }
    
    void mostrardatos(String valor) {
        

        String sql="";
        if (valor.equals(""))
        {sql="SELECT * FROM productos";
        }
        else {
            sql= "SELECT * FROM productos WHERE descripcion = '"+valor+"'";
                    }       
        String [] datos = new String [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 datos[0]=rs.getString(1);
                 datos[1]=rs.getString(2);
                 datos[2]=rs.getString(4);
                 datos[3]=rs.getString(5);
                 datos[4]= txtcantidad.getText();
                 int dat =Integer.parseInt(txtcantidad.getText());
                 int det =Integer.parseInt(rs.getString(4));
                 String total = String.valueOf(dat*det);
                 datos[5]= total ;               
                   
             }    
             
        }catch (Exception e) {
             System.out.println(e.getMessage());
        }
    
        try {
            // Preparar la subida de datos
            
            factura.getModel();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO datosdefactura(sku,descripcion,precio,detalles,cantidad,total,nombre,fecha) VALUES (?,?,?,?,?,?,?,?)");
            pst.setString(1, datos[0]);
            pst.setString(2, datos[1]);
            pst.setString(3, datos[2]);
            pst.setString(4, datos[3]);
            pst.setString(5, datos[4]);
            pst.setString(6, datos[5]);
            pst.setString(7, txtclientes.getSelectedItem().toString());
            pst.setString(8, txtfecha.getText());
            
            
            // Enviar información
            pst.executeUpdate();

            // limpiar campos
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
        
    }
    @SuppressWarnings("unchecked")
    
    public static String fechaactual(){
        
        Date fecha= new Date();
        SimpleDateFormat formatofecha= new SimpleDateFormat("dd/MM/YYYY");
    
       
                
        return formatofecha.format(fecha);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        factura = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtcantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JComboBox<>();
        txtclientes = new javax.swing.JComboBox<>();
        btnagregar1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnagregar2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnagregar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        factura.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        factura.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        factura.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(factura);

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-clear-shopping-cart-35.png"))); // NOI18N
        jButton3.setText("Eliminar producto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnagregar.setBackground(new java.awt.Color(0, 51, 102));
        btnagregar.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnagregar.setForeground(new java.awt.Color(255, 255, 255));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-add-shopping-cart-35.png"))); // NOI18N
        btnagregar.setText("Agregar producto");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-costa-rica-50.png"))); // NOI18N

        txtcantidad.setText("0");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Fecha de facturación");

        txtfecha.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Cantidad");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(51, 153, 255));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imgmont.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 246, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Roboto Slab", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registro de Facturas");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ingrese los datos de facturacion");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Producto");

        btnagregar1.setBackground(new java.awt.Color(0, 51, 102));
        btnagregar1.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnagregar1.setForeground(new java.awt.Color(255, 255, 255));
        btnagregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-money-transfer-35.png"))); // NOI18N
        btnagregar1.setText("Generar Factura");
        btnagregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar1ActionPerformed(evt);
            }
        });

        btnagregar2.setBackground(new java.awt.Color(0, 51, 102));
        btnagregar2.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnagregar2.setForeground(new java.awt.Color(255, 255, 255));
        btnagregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-window-search-35.png"))); // NOI18N
        btnagregar2.setText("Buscar Producto");
        btnagregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-descending-sorting-35.png"))); // NOI18N
        jButton4.setText("Mostrar Todos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnagregar3.setBackground(new java.awt.Color(0, 51, 102));
        btnagregar3.setFont(new java.awt.Font("Roboto Slab", 0, 14)); // NOI18N
        btnagregar3.setForeground(new java.awt.Color(255, 255, 255));
        btnagregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-available-updates-35.png"))); // NOI18N
        btnagregar3.setText("Nueva facturacion");
        btnagregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcantidad)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtclientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtfecha)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                            .addComponent(txtproducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(116, 116, 116)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnagregar3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnagregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnagregar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(62, 62, 62))))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtclientes, txtproducto});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar2)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar1)
                    .addComponent(btnagregar3))
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtclientes, txtproducto});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnagregar, btnagregar2, jButton3, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = factura.getSelectedRow();
        if(fila>=0){
            String cod="";
            cod=factura.getValueAt(fila, 4).toString();
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM datosdefactura WHERE cantidad='"+cod+"'");
                pst.executeUpdate();
                mostrar("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else{
            JOptionPane.showMessageDialog(null,"Por Favor debe Selecionar un Dato antes de modificar");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        String combo = (String)txtproducto.getSelectedItem();
        mostrardatos(combo);
        
        mostrar("");
        txtcantidad.setText("0");
        txtclientes.setEnabled(false);
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnagregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar1ActionPerformed

       Connection con; 
       
       try {
       Class.forName("com.mysql.jdbc.Driver");
       
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","root");
            
            try {   
                 JasperPrint print = JasperFillManager.fillReport(facturacion.class.getResourceAsStream("/Reportes/reportes.jasper"), new HashMap<>(), con);            
            
                 JasperViewer view = new JasperViewer(print,false);
                 view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                 view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (SQLException ex) {
            Logger.getLogger (facturacion.class.getName()).log(Level.SEVERE,null, ex);
        }
            
            
                }catch(ClassNotFoundException ex) {
                    Logger.getLogger(facturacion.class.getName()).log(Level.SEVERE, null, ex);
                }
       try {
                    PreparedStatement pst = cn.prepareStatement(" truncate datosdefactura" );
                    pst.executeUpdate();
       } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
       
       mostrar("");
       txtclientes.setEnabled(true);
    }//GEN-LAST:event_btnagregar1ActionPerformed

    private void btnagregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar2ActionPerformed
        String pregunta = JOptionPane.showInputDialog(null,"Ingrese el producto que desea buscar");
       mostrar(pregunta);
    }//GEN-LAST:event_btnagregar2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       mostrar("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnagregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar3ActionPerformed
        try {
                    PreparedStatement pst = cn.prepareStatement(" truncate datosdefactura" );
                    pst.executeUpdate();
       } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
       
       mostrar("");
       txtclientes.setEnabled(true);
    }//GEN-LAST:event_btnagregar3ActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
      
        
        
        
           
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnagregar1;
    private javax.swing.JButton btnagregar2;
    private javax.swing.JButton btnagregar3;
    private javax.swing.JTable factura;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JComboBox<String> txtclientes;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JComboBox<String> txtproducto;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn= cc.conexion();
}
