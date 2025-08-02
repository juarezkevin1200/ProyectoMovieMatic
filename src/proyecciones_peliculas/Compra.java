package proyecciones_peliculas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Compra extends javax.swing.JFrame {

    private String Usuario;
    private int pk_proyeccion;
    Conexion cnn;
    
    public Compra() {
        initComponents();
        this.inicializarComponentes();
    }
    Cartelera cm;
    public Compra(Cartelera cm,int pk_proyeccion) {
        this.pk_proyeccion = pk_proyeccion;
        cnn = new Conexion("verison_1_2_3");
        cnn.conectar();
        this.cm = cm;
        initComponents();
        this.inicializarComponentes();
    }
    ArrayList <Imagen> imagenes;
    
    //ArrayList <ActionListener> acciones;
    public void inicializarComponentes(){
        imagenes = new ArrayList();
        for(int i=0;i<8;i++){
            for(int j=0;j<5;j++){
                imagenes.add(new Imagen("asiento_libre.png"));
                imagenes.get(j+i*5).setBounds(i*95,j*80, 95, 80);
                PanelCine.add(imagenes.get(j+i*5));
                
                //imagenes.get(i).addMouseListener(new MouseListener);
                
            }
        }
        
        ArrayList <Integer> filasO =new ArrayList();
        ArrayList <Integer> columnasO=new ArrayList();
        cnn.BuscarPorButaca(this.pk_proyeccion, filasO, columnasO);
        for(int i =0;i<filasO.size();i++){
            System.out.println("filas: "+filasO.get(i) +" ,columnas: "+columnasO.get(i));
            imagenes.get(columnasO.get(i)+filasO.get(i)*5).setEstado(3);
        }
        
        
        for(int i=0;i<8;i++){
            for(int j=0;j<5;j++){
                            if(imagenes.get(j+i*5).getEstado() == 3){
                             PanelCine.remove(imagenes.get(j+5*i));
                             imagenes.set(j+5*i,new Imagen("asiento_ocupado.png"));
                             imagenes.get(j+i*5).setEstado(3);
                             PanelCine.add(imagenes.get(j+5*i));
                             
                             imagenes.get(j+i*5).setBounds(i*95,j*80, 95, 80);
                            }
            }
        }
        
        
        //le pone un listener al mouse para que cambie el estado del asiento
        MouseListener ML;
        ML = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                for(int i=0;i<8;i++){
                    for(int j=0;j<5;j++){
                        int x0 = i*95; int y0 = j*80;
                        int ancho = i*95+95;int largo = j*80+80;
                        if(x >= x0 && x<= ancho && y >= y0 && y <= largo){
                            
                            PanelCine.remove(imagenes.get(j+5*i));
                            if(imagenes.get(j+i*5).getEstado() == 0){
                             imagenes.set(j+5*i,new Imagen("asiento_seleccionado.png"));
                                imagenes.get(j+i*5).setEstado(1);
                            }else if(imagenes.get(j+i*5).getEstado() == 1){
                             imagenes.set(j+5*i,new Imagen("asiento_seleccionado_nino.png"));
                             imagenes.get(j+i*5).setEstado(2);
                            }else if(imagenes.get(j+i*5).getEstado() == 2){
                             imagenes.set(j+5*i,new Imagen("asiento_libre.png"));
                            imagenes.get(j+i*5).setEstado(0);
                            }
                            
                            PanelCine.add(imagenes.get(j+5*i));
                            imagenes.get(j+i*5).setBounds(i*95,j*80, 95, 80);
                            break;
                        }
                    }
                    
                }
                PanelCine.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        PanelCine.addMouseListener(ML);
        PanelCine.repaint();
        //this.addMouseListener(this);
    }
    
    /*
    Auxiliar = new Imagen("can.jpg");
        this.PeliPanel.add(Auxiliar);
        Auxiliar.setBounds(0, 0,this.PeliPanel.getWidth(),this.PeliPanel.getHeight());
    */
    
    /*
    int Aux = this.peliculacbb.getSelectedIndex();
        this.PeliPanel.remove(Auxiliar);
        switch(Aux){
            case 0: Auxiliar = new Imagen("can.jpg");break;
            case 1: Auxiliar = new Imagen("torna.jpg");break;
            case 2: Auxiliar = new Imagen("lucy.jpg");break;
            case 3: Auxiliar = new Imagen("box.jpg");break;
            case 4: Auxiliar = new Imagen("tor.jpg");break;
            case 5: Auxiliar = new Imagen("ninfo.jpg");break;
            default: break;
        }
     
        this.PeliPanel.add(Auxiliar);
        Auxiliar.setBounds(0, 0,this.PeliPanel.getWidth(),this.PeliPanel.getHeight());
        this.PeliPanel.repaint();
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelCine = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sala:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        PanelCine.setBackground(new java.awt.Color(0, 51, 51));
        PanelCine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelCineMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelCineLayout = new javax.swing.GroupLayout(PanelCine);
        PanelCine.setLayout(PanelCineLayout);
        PanelCineLayout.setHorizontalGroup(
            PanelCineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        PanelCineLayout.setVerticalGroup(
            PanelCineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel1.add(PanelCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 760, 400));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 160, 60));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 475, 160, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Pantalla");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel3)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 470, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelCineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelCineMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelCineMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        cm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList <String> valoresF = new ArrayList();
        ArrayList <String> valoresC = new ArrayList();
        ArrayList <String> valoresT = new ArrayList();
        for(int i=0;i<8;i++){
            for(int j=0;j<5;j++){
                if(imagenes.get(j+i*5).getEstado() == 1){
                valoresF.add(String.valueOf(i));
                valoresC.add(String.valueOf(j));
                valoresT.add("adulto");
                }
                
                if(imagenes.get(j+i*5).getEstado() == 2){
                valoresF.add(String.valueOf(i));
                valoresC.add(String.valueOf(j));
                valoresT.add("niño");
                }
            }
        }
        
        
        
        this.setVisible(false);
        Ticket tk = new Ticket(this,Usuario,pk_proyeccion,valoresF,valoresC,valoresT);
        tk.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCine;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setPk_proyeccion(int pk_proyeccion) {
        this.pk_proyeccion = pk_proyeccion;
    }

    
}
