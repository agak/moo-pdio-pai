/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dtw.DTWMatch;
import dtw.DistanceImageGenerator;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sys.Messages;

/**
 *
 * @author Lukasz
 */
public class MatchPreview extends javax.swing.JPanel {

    private static DecimalFormat df = new DecimalFormat("#.##");
    private DTWMatch match;
    private static DistanceImageGenerator distanceImageGenerator;
    public static DistanceImagePreviewWindow window;

    /**
     * Creates new form MatchPreview
     */
    public MatchPreview(DTWMatch match) {
        initComponents();
        this.match = match;
        this.wordLabel.setText(match.getData().getWord());
        this.distnaceLabel.setText("nieznana");
        File audio = match.getData().getFile();
        this.playButton.setEnabled(audio!=null && audio.exists());
    }

    public static DistanceImageGenerator getDistanceImageGenerator() {
        return distanceImageGenerator;
    }

    public static void setDistanceImageGenerator(DistanceImageGenerator distanceImageGenerator) {
        MatchPreview.distanceImageGenerator = distanceImageGenerator;
    }

    public void setWord(String word) {
        this.wordLabel.setText(word);
    }

    public void setDistance(double distace) {
        if(distace!=Double.MAX_VALUE){
            this.distnaceLabel.setText(df.format(distace));
        }
        else{
            this.distnaceLabel.setText("0");
        }
    }

    public void setMiniaturImage(BufferedImage image) {
        this.miniaturImagePanel.setImage(resize(image, 100, 60));
    }

    public void refershImage() {
        if (match.getImage() != null) {
            distanceImageGenerator.generate(match);
        }
    }

    public void setThresholdLevel(boolean threshold) {
        if (threshold) {
            thresholdLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/true.gif")));
        } else {
            thresholdLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/false.png")));
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

        miniaturImagePanel = new gui.ImagePanel();
        playButton = new javax.swing.JButton();
        wordLabel = new javax.swing.JLabel();
        thresholdLabel = new javax.swing.JLabel();
        distnaceLabel = new javax.swing.JLabel();

        miniaturImagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        miniaturImagePanel.setMaximumSize(new java.awt.Dimension(100, 60));
        miniaturImagePanel.setMinimumSize(new java.awt.Dimension(100, 60));
        miniaturImagePanel.setPreferredSize(new java.awt.Dimension(100, 60));
        miniaturImagePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniaturImagePanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout miniaturImagePanelLayout = new javax.swing.GroupLayout(miniaturImagePanel);
        miniaturImagePanel.setLayout(miniaturImagePanelLayout);
        miniaturImagePanelLayout.setHorizontalGroup(
            miniaturImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        miniaturImagePanelLayout.setVerticalGroup(
            miniaturImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png"))); // NOI18N
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        wordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        wordLabel.setText("wordLabel");

        thresholdLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/true.gif"))); // NOI18N
        thresholdLabel.setToolTipText("Threshold");

        distnaceLabel.setText("distnaceLabel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(miniaturImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(distnaceLabel)
                    .addComponent(wordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(thresholdLabel)
                .addGap(42, 42, 42)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miniaturImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(wordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distnaceLabel))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(thresholdLabel)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void miniaturImagePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniaturImagePanelMouseClicked
        if (match.getImage() == null) {
            distanceImageGenerator.generate(match);
            return;
        }
        if (MatchPreview.window == null) {
            MatchPreview.window = new DistanceImagePreviewWindow();
        }
        MatchPreview.window.setImage(match.getImage());
        window.setVisible(true);
    }//GEN-LAST:event_miniaturImagePanelMouseClicked
    public void playSound(final File soundFile) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile.getAbsoluteFile());
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    Messages.error(e.getMessage());
                }
            }
        }).start();
    }
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        File audio = match.getData().getFile();
        if(audio!=null && audio.exists()){
            playSound(audio);
        }
    }//GEN-LAST:event_playButtonActionPerformed
    public static BufferedImage resize(BufferedImage image, int width,
            int height) {
        if (image == null) {
            return null;
        }
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel distnaceLabel;
    private gui.ImagePanel miniaturImagePanel;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel thresholdLabel;
    private javax.swing.JLabel wordLabel;
    // End of variables declaration//GEN-END:variables
}