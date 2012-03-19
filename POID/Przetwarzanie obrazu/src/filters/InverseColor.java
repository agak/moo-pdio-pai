/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import sys.AbstractFilter;
import sys.IFilter;

/**
 *
 * @author Lukasz
 */
public class InverseColor extends AbstractFilter{

     private short[] invertTable;
    public InverseColor(){
        this.setName("Inverse color");
        this.setDescription("Ten filtr odwrca kolory na obrazie.");
        this.setEditable(true);
         invertTable = new short[256];
        for (int i = 0; i < 256; i++) {
            invertTable[i] = (short) (255 - i);
        }
    }
    @Override
    public BufferedImage processImage(BufferedImage image) {
        Color col;
        int RGBA;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                RGBA = image.getRGB(x, y); 
                col = new Color(RGBA, true);
                image.setRGB(x, y, new Color(invertTable[col.getRed()],invertTable[col.getGreen()], invertTable[col.getBlue()]).getRGB()); //set the pixel to the altered colors
            }
        }
        return image;
    }
    
    @Override
    public JPanel getEditPanel(){
        return new InverseColorPanel();
    }
    
     @Override
    public IFilter getCopy(){
         return new InverseColor();
    }
    
   
    
}