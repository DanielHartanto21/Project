package com.ui;

import com.socket.History;
import com.socket.Message;
import com.socket.SocketClient;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.IconUIResource;

public class ChatFrame extends javax.swing.JFrame {
    
    ImageIcon stayP1=new ImageIcon("D:\\netbeans\\project\\coba_project\\src\\media\\stayP1.jpg");
    ImageIcon stayP2=new ImageIcon("D:\\netbeans\\project\\coba_project\\src\\media\\stayP2.jpg");  
    ImageIcon attackP1=new ImageIcon("D:\\netbeans\\project\\coba_project\\src\\media\\attackP1.jpg");  
    ImageIcon attackP2=new ImageIcon("D:\\netbeans\\project\\coba_project\\src\\media\\attackP2.jpg");  
    public SocketClient client;
    public int port;
    public String serverAddr, username, password;
    public Thread clientThread;
    public DefaultListModel model;
    public File file;
    
    
    public ChatFrame() {
        initComponents();
        this.setTitle("jMessenger");
        this.addWindowListener(new WindowListener() {

            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) { try{ client.send(new Message("message", username, ".bye", "SERVER")); clientThread.stop();  }catch(Exception ex){} }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
        
        
        
    }
    
    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        restart = new javax.swing.JButton();
        player1 = new javax.swing.JLabel();
        atas = new javax.swing.JButton();
        player2 = new javax.swing.JLabel();
        bawah = new javax.swing.JButton();
        kanan = new javax.swing.JButton();
        kiri = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        healthbarsendiri = new javax.swing.JProgressBar();
        healthbarmusuh = new javax.swing.JProgressBar();
        attack = new javax.swing.JButton();
        ult = new javax.swing.JButton();
        heal = new javax.swing.JButton();
        disable = new javax.swing.JButton();
        repair = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Host : ");

        jTextField1.setText("localhost");

        jLabel2.setText("Port : ");

        jTextField2.setText("13000");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Name :");

        jButton2.setText("Login");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        restart.setText("restart");
        restart.setEnabled(false);
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });

        player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/stayP1.png"))); // NOI18N

        atas.setText("atas");
        atas.setEnabled(false);
        atas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atasActionPerformed(evt);
            }
        });

        player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/stayP2.png"))); // NOI18N

        bawah.setText("bawah");
        bawah.setEnabled(false);
        bawah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bawahActionPerformed(evt);
            }
        });

        kanan.setText("kanan");
        kanan.setEnabled(false);
        kanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kananActionPerformed(evt);
            }
        });

        kiri.setText("kiri");
        kiri.setEnabled(false);
        kiri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kiriActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        healthbarsendiri.setValue(100);

        healthbarmusuh.setValue(100);

        attack.setText("attack");
        attack.setEnabled(false);
        attack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackActionPerformed(evt);
            }
        });

        ult.setText("ultimate");
        ult.setEnabled(false);
        ult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultActionPerformed(evt);
            }
        });

        heal.setText("heal");
        heal.setEnabled(false);
        heal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healActionPerformed(evt);
            }
        });

        disable.setText("disable");
        disable.setEnabled(false);
        disable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableActionPerformed(evt);
            }
        });

        repair.setText("repair");
        repair.setEnabled(false);
        repair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(player1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(player2))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(disable)
                                    .addGap(7, 7, 7)
                                    .addComponent(ult))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(restart)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(repair, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(attack)
                                .addComponent(kiri))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(atas)
                                .addComponent(bawah))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(heal)
                                .addComponent(kanan))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(healthbarsendiri, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(healthbarmusuh, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(healthbarsendiri, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthbarmusuh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(332, 332, 332)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player2)
                    .addComponent(player1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ult)
                                .addComponent(disable))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(attack)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kiri)
                                    .addComponent(restart)
                                    .addComponent(repair)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(atas)
                                .addGap(6, 6, 6)
                                .addComponent(bawah))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(heal)
                                .addGap(6, 6, 6)
                                .addComponent(kanan))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        serverAddr = jTextField1.getText(); port = Integer.parseInt(jTextField2.getText());
        
        if(!serverAddr.isEmpty() && !jTextField2.getText().isEmpty()){
            try{
                client = new SocketClient(this);
                clientThread = new Thread(client);
                clientThread.start();
                client.send(new Message("test", "testUser", "testContent", "SERVER"));
                
            }
            catch(Exception ex){

            }
            
        }
        jTextField4.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        username = jTextField4.getText();
        
        if(!username.isEmpty()){
            client.send(new Message("login", username, "", "SERVER"));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed
        // TODO add your handling code here:
       client.send(new Message("reset", username, "", "SERVER"));
    }//GEN-LAST:event_restartActionPerformed

    private void atasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atasActionPerformed
        // TODO add your handling code here:
       
        client.send(new Message("atas", username,Integer.toString(player1.getBounds().y-10), "SERVER"));
    }//GEN-LAST:event_atasActionPerformed

    private void bawahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bawahActionPerformed
        // TODO add your handling code here:
        
        client.send(new Message("bawah", username,Integer.toString(player1.getBounds().y+10), "SERVER"));
    }//GEN-LAST:event_bawahActionPerformed

    private void kananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kananActionPerformed
        // TODO add your handling code here:
        player1.setBounds(player1.getBounds().x+10, player1.getBounds().y, player1.getWidth(), player1.getHeight());
        client.send(new Message("kanan", username,"10", "SERVER"));
    }//GEN-LAST:event_kananActionPerformed

    private void kiriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kiriActionPerformed
        // TODO add your handling code here:
        player1.setBounds(player1.getBounds().x-10, player1.getBounds().y, player1.getWidth(), player1.getHeight());
        client.send(new Message("kiri", username,"10", "SERVER"));
    }//GEN-LAST:event_kiriActionPerformed

    private void attackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackActionPerformed
        // TODO add your handling code here:
       client.send(new Message("serang", username,"5", "SERVER"));
    }//GEN-LAST:event_attackActionPerformed

    private void ultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultActionPerformed
        // TODO add your handling code here:
        client.send(new Message("serang", username,"20", "SERVER"));
    }//GEN-LAST:event_ultActionPerformed

    private void healActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healActionPerformed
        // TODO add your handling code here:
        client.send(new Message("heal", username,"5", "SERVER"));
    }//GEN-LAST:event_healActionPerformed

    private void disableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableActionPerformed
        // TODO add your handling code here:
        client.send(new Message("disable", username,"", "SERVER"));
    }//GEN-LAST:event_disableActionPerformed

    private void repairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repairActionPerformed
        // TODO add your handling code here:
        client.send(new Message("repair", username,"", "SERVER"));
    }//GEN-LAST:event_repairActionPerformed
        
   
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception ex){
            System.out.println("Look & Feel exception");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton atas;
    public javax.swing.JButton attack;
    public javax.swing.JButton bawah;
    public javax.swing.JButton disable;
    public javax.swing.JButton heal;
    public javax.swing.JProgressBar healthbarmusuh;
    public javax.swing.JProgressBar healthbarsendiri;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JButton kanan;
    public javax.swing.JButton kiri;
    public javax.swing.JLabel player1;
    public javax.swing.JLabel player2;
    public javax.swing.JButton repair;
    public javax.swing.JButton restart;
    public javax.swing.JButton ult;
    // End of variables declaration//GEN-END:variables
}
