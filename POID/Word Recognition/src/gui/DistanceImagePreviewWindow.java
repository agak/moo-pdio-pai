/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 *
 * @author Lukasz
 */
public class DistanceImagePreviewWindow extends javax.swing.JFrame {

    BufferedImage image;

    /**
     * Creates new form DistanceImagePreviewWindow
     */
    public DistanceImagePreviewWindow() {
        initComponents();
    }

    public void setImage(BufferedImage image){
        this.image = image;
        double scale = (double)(this.getHeight()-50)/ (double)image.getHeight();
        double scale2 = (double)(this.getWidth()-50)/ (double)image.getWidth();
        scale = Math.min(scale, scale2);
        int w = (int)Math.floor((double)image.getWidth()*scale);
        int h = (int)Math.floor((double)image.getHeight()*scale);
        this.imagePanel.setImage(resize(image,image.getWidth()*3,image.getHeight()*3));
        //this.imagePanel.setImage(image);
        this.validate();
    }
    public static BufferedImage resize(BufferedImage image, int width,
            int height) {
        if (image == null) {
            return null;
        }
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
//        g.setComposite(AlphaComposite.Src);
//        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g.setRenderingHint(RenderingHints.KEY_RENDERING,
//                RenderingHints.VALUE_RENDER_QUALITY);
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    public static BufferedImage resize(BufferedImage originalImage, int height) {
        double scale = ((double) (height)) / originalImage.getHeight();
        int width = (int) (originalImage.getWidth() * scale);
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new gui.ImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        imagePanel.setMaximumSize(new java.awt.Dimension(600, 300));
        imagePanel.setMinimumSize(new java.awt.Dimension(600, 300));
        imagePanel.setPreferredSize(new java.awt.Dimension(600, 300));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        getContentPane().add(imagePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.ImagePanel imagePanel;
    // End of variables declaration//GEN-END:variables
}
