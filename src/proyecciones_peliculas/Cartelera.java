package proyecciones_peliculas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juare
 */
public class Cartelera extends javax.swing.JFrame {
    Imagen  fondo = new Imagen();
    Ingreso ingre;
    Conexion cnn;
    private  String Usuario;

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public Cartelera(Ingreso ingre) {
        cnn = new Conexion("verison_1_2_3");
        cnn.conectar();
        this.ingre = ingre;
        initComponents();
        this.inicializarComponentes();
        
    }
   
    private int indice = 0;
    private int max;
    ArrayList <String> titulos;
    ArrayList <String> duracion;
    ArrayList <String> categoria;
    ArrayList <String> director;
    ArrayList <String> actor;
    
    public void inicializarComponentes(){
        titulos = new ArrayList();
        duracion = new ArrayList();
        categoria = new ArrayList();
        director = new ArrayList();
        actor = new ArrayList();
        
        
        cnn.consultarP("ConsultarProyeccionTicket", "nombre", titulos);
        cnn.ConsultarDuracion(duracion);
        cnn.consultarP("ConsultarProyeccionTicket", "genero", categoria);
        cnn.consultarP("ConsultarProyeccionTicket", "director", director);
        cnn.consultarP("ConsultarProyeccionTicket", "actor", actor);
        InsertarValores(indice);
        max = titulos.size();
    }
    
    public void InsertarValores(int indice){
        this.salacbb.removeAllItems();
        salacbb.addItem("");
        this.horariocbb.removeAllItems();
        this.peliculalbl.setText(titulos.get(indice));
        this.duracionlbl.setText(duracion.get(indice));
        this.categorialbl.setText(categoria.get(indice));
        this.directorlbl.setText(director.get(indice));
        this.actorlbl.setText(actor.get(indice));
        cnn.ConsultarNumSala(titulos.get(indice), salacbb);
        cnn.ConsultarHorario(titulos.get(indice),salacbb.getSelectedItem().toString(),horariocbb);
        
    
    }
    
    public Cartelera() { 
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new Imagen();
        jPanel1 = new javax.swing.JPanel();
        Preimagen = new Imagen("2.jpg");
        labelsxd = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        peliculalbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        directorlbl = new javax.swing.JLabel();
        duracionlbl = new javax.swing.JLabel();
        categorialbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        actorlbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        salacbb = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        horariocbb = new javax.swing.JComboBox<>();
        jPanel3 = new Imagen("next.png");
        jPanel6 = new Imagen("last.png");
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Preimagen.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout PreimagenLayout = new javax.swing.GroupLayout(Preimagen);
        Preimagen.setLayout(PreimagenLayout);
        PreimagenLayout.setHorizontalGroup(
            PreimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        PreimagenLayout.setVerticalGroup(
            PreimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jPanel1.add(Preimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, -1, -1));

        labelsxd.setText("Categoria:");
        jPanel1.add(labelsxd, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 92, -1, -1));

        jLabel4.setText("Duracion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 63, -1, -1));

        peliculalbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        peliculalbl.setText("TITULO");
        jPanel1.add(peliculalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 13, 334, -1));

        jLabel7.setText("Actores:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 178, -1, -1));

        directorlbl.setText("DIRECTOR");
        jPanel1.add(directorlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        duracionlbl.setText("DURACION");
        jPanel1.add(duracionlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 63, 199, -1));

        categorialbl.setText("CATEGORIA");
        jPanel1.add(categorialbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 92, 199, -1));

        jLabel12.setText("español");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 199, -1));

        actorlbl.setText("ACTORES");
        jPanel1.add(actorlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 178, 199, -1));

        jLabel14.setText("Horario:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        salacbb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                salacbbItemStateChanged(evt);
            }
        });
        salacbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salacbbActionPerformed(evt);
            }
        });
        jPanel1.add(salacbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        jLabel9.setText("Idioma:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabel10.setText("director:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        jLabel16.setText("Sala:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        horariocbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horariocbbActionPerformed(evt);
            }
        });
        jPanel1.add(horariocbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        jPanel3.setBackground(new java.awt.Color(51, 255, 204));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 255, 204));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LogOut");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Comprar");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(279, 279, 279))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(285, 285, 285))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton1)
                        .addGap(112, 112, 112)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
        this.ingre.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here
        Rectangle r = this.jPanel3.getBounds();
        r.setSize((int)(r.getWidth()*1.1), (int) (r.getHeight()*1.1));
        this.jPanel3.setBounds(r);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        Rectangle r = this.jPanel3.getBounds();
        r.setSize((int)(r.getWidth()/1.1), (int) (r.getHeight()/1.1));
        this.jPanel3.setBounds(r);
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
        Rectangle r = this.jPanel6.getBounds();
        r.setSize((int)(r.getWidth()*1.1), (int) (r.getHeight()*1.1));
        this.jPanel6.setBounds(r);
        
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
        Rectangle r = this.jPanel6.getBounds();
        r.setSize((int)(r.getWidth()/1.1), (int) (r.getHeight()/1.1));
        this.jPanel6.setBounds(r);
    }//GEN-LAST:event_jPanel6MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        String Sala = this.salacbb.getSelectedItem().toString();
        String Horario = this.horariocbb.getSelectedItem().toString();
        String Nombre = this.peliculalbl.getText();
        int condicion =-1;
        condicion = cnn.seleccionarProyeccion(Nombre, Sala, Horario);
        if(condicion != -1){
            Compra cm = new Compra(this,condicion);
            this.setVisible(false);
            cm.setVisible(true);
            cm.setUsuario(Usuario);
            //cm.setPk_proyeccion(condicion);
        }
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
         System.out.println("hola : boton"+indice);

        indice++;           

        if(indice >= max){
            indice = 0;
        }
        this.InsertarValores(indice);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        
        indice--;
        System.out.println(""+indice);
        if(indice < 0){
            indice = max-1; 
        }
        this.InsertarValores(indice);
        
    }//GEN-LAST:event_jPanel6MouseClicked

    private void salacbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salacbbActionPerformed

           if(salacbb.getSelectedIndex() > -1){
            this.horariocbb.removeAllItems();
            cnn.ConsultarHorario(titulos.get(indice),salacbb.getSelectedItem().toString(),horariocbb);
        } 
        
        
    }//GEN-LAST:event_salacbbActionPerformed

    private void horariocbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horariocbbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horariocbbActionPerformed

    private void salacbbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_salacbbItemStateChanged
        // TODO add your handling code here:
        /*
        if(salacbb.getSelectedIndex()> -1){
         System.out.println("segundo");
         this.horariocbb.removeAllItems();
         System.out.println(""+titulos.get(indice));
         //System.out.println(""+this.sala.get(indice));
         System.out.println(""+salacbb.getSelectedItem().toString());
         //cnn.BuscarPorSala(titulos.get(indice), salacbb);
        }
        */
    }//GEN-LAST:event_salacbbItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Info_Cuenta InfoC = new Info_Cuenta(this,this.Usuario);
        InfoC.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cartelera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Preimagen;
    private javax.swing.JLabel actorlbl;
    private javax.swing.JLabel categorialbl;
    private javax.swing.JLabel directorlbl;
    private javax.swing.JLabel duracionlbl;
    private javax.swing.JComboBox<String> horariocbb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelsxd;
    private javax.swing.JLabel peliculalbl;
    private javax.swing.JComboBox<String> salacbb;
    // End of variables declaration//GEN-END:variables
    // esta clase se usa para que los Jpanels tengan una imagen
    
        
    
    
    
}
