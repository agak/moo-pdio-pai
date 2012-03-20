/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import sys.BufferedImageHelper;
import sys.IFilter;
import sys.IconHelper;
import sys.TabData;

/**
 *
 * @author Lukasz
 */
public class EditWindow extends javax.swing.JFrame implements PropertyChangeListener {

    TabData data;
    IFilter filtr;
    IFilter copyFiltr;

    /**
     * Creates new form EditWindow
     */
    public EditWindow(TabData data, IFilter filtr) {
        this.data = data;
        this.filtr = filtr;
        this.copyFiltr = filtr.getCopy();
        initComponents();
        JPanel panel = copyFiltr.getEditPanel();
        copyFiltr.getChangeSupport().addPropertyChangeListener(this);
        this.settingsPanel.add(panel);
        this.setTitle(filtr.getName());
         if (filtr.getIcon() == null) {
                    this.setIconImage(IconHelper.getDefaultIcon().getImage());
                } else {
                    this.setIconImage(new ImageIcon(getClass().getResource(filtr.getIcon())).getImage());
                }
    }
    
 protected BufferedImage doInBackground() {
        if (data.getFilters() == null || data.getFilters().isEmpty()) {
            return data.getBaseMiniatureImage();
        }
        int index = this.data.getFilters().indexOf(filtr);
        BufferedImage tmp = BufferedImageHelper.copy(data.getBaseMiniatureImage());
        for (int i = 0; i < data.getFilters().size(); i++) {
            if(i!=index){
               tmp = data.getFilters().get(i).processImage(tmp); 
            }
            else{
                tmp = copyFiltr.processImage(tmp); 
            }
        }
        return tmp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        previewPanel = new ImagePreviewPanel(data.getFilteredMiniatureImage());
        settingsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));

        previewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Preview"));
        previewPanel.setMaximumSize(new java.awt.Dimension(32767, 130));
        previewPanel.setMinimumSize(new java.awt.Dimension(0, 130));
        previewPanel.setPreferredSize(new java.awt.Dimension(400, 130));

        javax.swing.GroupLayout previewPanelLayout = new javax.swing.GroupLayout(previewPanel);
        previewPanel.setLayout(previewPanelLayout);
        previewPanelLayout.setHorizontalGroup(
            previewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        previewPanelLayout.setVerticalGroup(
            previewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        getContentPane().add(previewPanel, java.awt.BorderLayout.PAGE_START);

        settingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Opcje"));
        settingsPanel.setMaximumSize(new java.awt.Dimension(2147483647, 130));
        settingsPanel.setMinimumSize(new java.awt.Dimension(12, 130));
        settingsPanel.setPreferredSize(new java.awt.Dimension(12, 130));
        settingsPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(settingsPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(490, 50));

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.png"))); // NOI18N
        okButton.setText("OK");
        okButton.setMaximumSize(new java.awt.Dimension(85, 25));
        okButton.setMinimumSize(new java.awt.Dimension(85, 25));
        okButton.setPreferredSize(new java.awt.Dimension(85, 25));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 214, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        int index = this.data.getFilters().indexOf(filtr);
        if(index!=-1){
             this.data.getFilters().set(index, copyFiltr);
        }
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    public ImagePreviewPanel previewPanel;
    public javax.swing.JPanel settingsPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.previewPanel.setImage(doInBackground());
        this.previewPanel.revalidate();
        this.repaint();
    }
}
