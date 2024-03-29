/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;

/**
 *
 * @author pawel
 */
public class DiffWindow extends javax.swing.JFrame {

    JFileChooser chooser;
    File input, output;

    /**
     * Creates new form DiffWindow
     */
    public DiffWindow() {
        ButtonGroup g = new ButtonGroup();
        chooser = new JFileChooser();
        initComponents();
        g.add(mse);
        g.add(mae);
        g.add(psnr);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputButton = new javax.swing.JButton();
        outputButton = new javax.swing.JButton();
        inputText = new javax.swing.JTextField();
        outputText = new javax.swing.JTextField();
        computeButton = new javax.swing.JButton();
        computedText = new javax.swing.JTextField();
        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mse = new javax.swing.JRadioButton();
        psnr = new javax.swing.JRadioButton();
        mae = new javax.swing.JRadioButton();

        inputButton.setText("input");
        inputButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputButtonMouseClicked(evt);
            }
        });

        outputButton.setText("output");
        outputButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outputButtonMouseClicked(evt);
            }
        });

        inputText.setText("input file..");

        outputText.setText("output file...");

        computeButton.setText("compute");
        computeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                computeButtonMouseClicked(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Method");

        mse.setText("MSE");

        psnr.setText("PSNR");

        mae.setText("MAE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputText)
                                    .addComponent(outputText))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(outputButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 148, Short.MAX_VALUE))
                                    .addComponent(computedText))
                                .addGap(18, 18, 18)
                                .addComponent(computeButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(psnr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mae)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputButton))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mse)
                            .addComponent(psnr)
                            .addComponent(mae))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(computeButton)
                            .addComponent(computedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputButtonMouseClicked
        chooser.showOpenDialog(this);
        input = chooser.getSelectedFile();
        if (input != null) {
            inputText.setText(input.getPath());
        }
    }//GEN-LAST:event_inputButtonMouseClicked

    private void outputButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outputButtonMouseClicked
        chooser.showOpenDialog(this);
        output = chooser.getSelectedFile();
        if (output != null) {
            outputText.setText(output.getPath());
        }
    }//GEN-LAST:event_outputButtonMouseClicked

    private void computeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computeButtonMouseClicked
        // TODO add your handling code here:
        BufferedImage in = null, out = null;
        try {
            in = ImageIO.read(input);
            out = ImageIO.read(output);

        } catch (IOException ex) {
            Logger.getLogger(DiffWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (mse.isSelected()) {
            computedText.setText("" + sys.DiffCalculator.calculateError(in, out, 1));
        } else if (psnr.isSelected()) {
            computedText.setText("" + sys.DiffCalculator.calculateError(in, out, 2));
        } else if (mae.isSelected()) {
            computedText.setText("" + sys.DiffCalculator.calculateError(in, out, 3));
        }
    }//GEN-LAST:event_computeButtonMouseClicked

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton computeButton;
    private javax.swing.JTextField computedText;
    private javax.swing.JButton inputButton;
    private javax.swing.JTextField inputText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton mae;
    private javax.swing.JRadioButton mse;
    private javax.swing.JButton outputButton;
    private javax.swing.JTextField outputText;
    private javax.swing.JRadioButton psnr;
    // End of variables declaration//GEN-END:variables

}