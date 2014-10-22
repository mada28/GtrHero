/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero.view;

import guitarhero.control.Controller;
import guitarhero.models.Dot;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author BUDDY_1cent
 */

public class GuitarHeroView extends javax.swing.JFrame {
    /**
     * Creates new form GameView
     */
    Controller controller;
    private boolean[] keys;
    private boolean[] keysFuse;
    private Timer timer;
    
    public GuitarHeroView(Controller controller) {
        initComponents();
        keys = new boolean[6];
        keysFuse = new boolean[6];

        System.out.println("keysfuse "+keysFuse[0]);
        this.controller=controller;
        controller.setView(this);
        this.requestFocus(); 
    }
    public void resetScore(){
        scoreLabel.setText(""+0);
    }
    public void setScore(int score){
        scoreLabel.setText(""+score);
    }
    public void setName(String name){
        nameLabel.setText(name);
    }
    public void resetName(){
        nameLabel.setText("PLAYER");
    }
    
    public boolean[] getKeys(){
        return keys;
    }

    public void updateModel(List<Dot> model) {
        mainPanel1.updateModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel1 = new guitarhero.view.MainPanel();
        nameLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        mainPanel1.setMinimumSize(new java.awt.Dimension(600, 508));

        nameLabel.setFont(new java.awt.Font("DotumChe", 0, 24)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("PLAYER");

        scoreLabel.setFont(new java.awt.Font("DotumChe", 0, 24)); // NOI18N
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("0");

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        startButton.setText("Hrej");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanel1Layout = new javax.swing.GroupLayout(mainPanel1);
        mainPanel1.setLayout(mainPanel1Layout);
        mainPanel1Layout.setHorizontalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addGroup(mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        mainPanel1Layout.setVerticalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel1Layout.createSequentialGroup()
                .addGroup(mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(302, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_X:
                keys[0] =(keysFuse[0]) ? false : true;
                keysFuse[0] = true;
                break;
            case KeyEvent.VK_C:
                keys[1] =(keysFuse[1]) ? false : true;
                keysFuse[1] = true;
                break;
            case KeyEvent.VK_V:
                keys[2] =(keysFuse[2]) ? false : true;
                keysFuse[2] = true;
                break;
            case KeyEvent.VK_B:
                keys[3] =(keysFuse[3]) ? false : true;
                keysFuse[3] = true;
                break;
            case KeyEvent.VK_N:
                keys[4] =(keysFuse[4]) ? false : true;
                keysFuse[4] = true;
                break;
            case KeyEvent.VK_M:
                keys[5] =(keysFuse[5]) ? false : true;
                keysFuse[5] = true;
                break;
            default:
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_X:
                keys[0] = false;
                keysFuse[0] = false;
                break;
            case KeyEvent.VK_C:
                keys[1] = false;
                keysFuse[1] = false;
                break;
            case KeyEvent.VK_V:
                keys[2] = false;
                keysFuse[2] = false;
                break;
            case KeyEvent.VK_B:
                keys[3] = false;
                keysFuse[3] = false;
                break;
            case KeyEvent.VK_N:
                keys[4] = false;
                keysFuse[4] = false;
                break;
            case KeyEvent.VK_M:
                keys[5] = false;
                keysFuse[5] = false;
                break;
            default:
        }
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        controller.start();
        this.requestFocus();
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        // TODO add your handling code here:
        controller.stop();
        this.requestFocus();
    }//GEN-LAST:event_stopButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private guitarhero.view.MainPanel mainPanel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}