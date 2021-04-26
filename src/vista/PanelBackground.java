/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class PanelBackground extends JPanel{
    
    private Image backgroundImage;

    public PanelBackground() {
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\User\\Documents\\NetBeansProjects\\GastosPersonales\\src\\fotos\\revenue-icons-vector.png"));
        } catch (IOException ex) {
            Logger.getLogger(PanelBackground.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(backgroundImage, 0, 0, this);
    }
    
    
}
