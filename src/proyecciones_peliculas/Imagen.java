package proyecciones_peliculas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class Imagen extends JPanel{
        private Image imagen;
        private String NombreImagen;
        private int estado;
        
        public Imagen(){
            this.NombreImagen ="4991912.jpg";
            estado = 0;
        }
        public Imagen(String NombreImagen){
            this.NombreImagen = NombreImagen;
            estado = 0;
        }
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/images/"+NombreImagen)).getImage();
            g.drawImage(imagen, 0, 0,getWidth(),getHeight(),this);
            
            setOpaque(false);
            super.paint(g);
        }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
