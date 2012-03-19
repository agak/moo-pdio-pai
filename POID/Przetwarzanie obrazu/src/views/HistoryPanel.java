/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import gui.EditWindow;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.JTableBinding.ColumnBinding;
import org.jdesktop.swingbinding.SwingBindings;
import sys.IFilter;
import sys.TabData;

/**
 *
 * @author Lukasz
 */
public class HistoryPanel extends javax.swing.JPanel {

    public TabData data;

    /**
     * Creates new form HistoryPanel
     */
    public HistoryPanel(TabData data) {
        this.data = data;
        initComponents();
        JTableBinding tb = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, data.getFilters(), this.historyTable);
        BeanProperty name = BeanProperty.create("name");
        ColumnBinding nameColumn = tb.addColumnBinding(name);
        nameColumn.setColumnName("Name");
        nameColumn.setEditable(false);
        tb.bind();
        HistorySelectionListener listener = new HistorySelectionListener(this);
        this.historyTable.getSelectionModel().addListSelectionListener(listener);
        this.historyTable.getColumnModel().getSelectionModel().addListSelectionListener(listener);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(historyTable);

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/up.png"))); // NOI18N
        upButton.setToolTipText("Move up");
        upButton.setEnabled(false);
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png"))); // NOI18N
        downButton.setToolTipText("Move down");
        downButton.setEnabled(false);
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        removeButton.setToolTipText("Remove item");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        editButton.setToolTipText("Edit item");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(upButton)
                        .addGap(4, 4, 4)
                        .addComponent(downButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        int selected = this.historyTable.getSelectedRow();
        if (selected > 0 && selected < this.data.getFilters().size()) {
            IFilter tmp = this.data.getFilters().get(selected);
            this.data.getFilters().remove(selected);
            this.data.getFilters().add(selected - 1, tmp);
            this.historyTable.setRowSelectionInterval(selected - 1, selected - 1);
        }
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        int selected = this.historyTable.getSelectedRow();
        if (selected >= 0 && selected < this.data.getFilters().size() - 1) {
            IFilter tmp = this.data.getFilters().get(selected);
            this.data.getFilters().remove(selected);
            this.data.getFilters().add(selected + 1, tmp);
            this.historyTable.setRowSelectionInterval(selected + 1, selected + 1);
        }
    }//GEN-LAST:event_downButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selected = this.historyTable.getSelectedRow();
        if (selected >= 0 && selected < this.data.getFilters().size()) {
            this.data.getFilters().remove(selected);
            if (selected < this.data.getFilters().size()) {
                this.historyTable.setRowSelectionInterval(selected, selected);
            } else if (selected - 1 >= 0) {
                this.historyTable.setRowSelectionInterval(selected - 1, selected - 1);
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selected = this.historyTable.getSelectedRow();
        if (selected >= 0 && selected < this.data.getFilters().size()) {
            EditWindow editWindow = new EditWindow(data, data.getFilters().get(selected));
            editWindow.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton downButton;
    public javax.swing.JButton editButton;
    public javax.swing.JTable historyTable;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton removeButton;
    public javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
