/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.table.DefaultTableModel;
import sys.TabData;
import sys.Task;

/**
 *
 * @author Lukasz
 */
public class PerformanceViewPanel extends javax.swing.JPanel implements PropertyChangeListener {

    TabData data;
    DateFormat dateFormater;
    DecimalFormat decimalFormater;
    DefaultTableModel model;

    /**
     * Creates new form PerformanceViewPanel
     */
    public PerformanceViewPanel(TabData data) {
        this.data = data;
        this.data.getStopWatch().getChangeSupport().addPropertyChangeListener(this);
        initComponents();
        dateFormater = new SimpleDateFormat("mm'm:'ss':'SSS");
        decimalFormater = new DecimalFormat("#.##########");
        dateFormater.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        model = (DefaultTableModel) this.jTable1.getModel();
        for (Task task : data.getStopWatch().getTasks()) {
            model.addRow(new Object[]{task.getName(), dateFormater.format(task.getOperationTime()),decimalFormater.format((double)task.getOperationTime()/(double)data.getStopWatch().getPixelCount())});
        }

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
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Time", "Millisecond/pixel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (Task task : data.getStopWatch().getTasks()) {
             model.addRow(new Object[]{task.getName(), dateFormater.format(task.getOperationTime()),decimalFormater.format((double)task.getOperationTime()/(double)data.getStopWatch().getPixelCount())});
        }
    }
}