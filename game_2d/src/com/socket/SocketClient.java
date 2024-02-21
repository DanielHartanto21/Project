package com.socket;

import com.ui.ChatFrame;
import com.ui.test;
import com.ui.play;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SocketClient implements Runnable{
    
    public int port,hpsendiri,hpmusuh,resetsendiri,resetmusuh,ultcount,healing,posisix1,posisiy1,posisix2,posisiy2,disablecount,repaircountsendiri,repaircountmusuh;
    public String serverAddr;
    public Socket socket;
    public ChatFrame ui;
    public ObjectInputStream In;
    public ObjectOutputStream Out;
    public History hist;
    
    
    public SocketClient(ChatFrame frame) throws IOException{
        ui = frame; this.serverAddr = ui.serverAddr; this.port = ui.port;
        socket = new Socket(InetAddress.getByName(serverAddr), port);
            
        Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
    }
    @Override
    public void run() {
        boolean keepRunning = true;
        hpsendiri=100;
        hpmusuh=100;
        resetsendiri=0;
        resetmusuh=0;
        ultcount=0;
        healing=5;
        disablecount=3;
        repaircountsendiri=0;
        repaircountmusuh=0;
        while(keepRunning){
            try {
                Message msg = (Message) In.readObject();
                System.out.println("Incoming : "+msg.toString());
                /*if(msg.content.substring(0,3).equals("Pnt")){
                        if(Integer.parseInt(msg.content.substring(1))<=140){
                           } 
                        if(!msg.sender.equals(ui.username)){
                        
                           play.player2.setBounds(play.player2.getBounds().x,Integer.parseInt(msg.content.substring(3)), play.player2.getWidth(), play.player2.getHeight());
                        }  
                    }
                else if(msg.content.substring(0,3).equals("Pkk")){
                        if(Integer.parseInt(msg.content.substring(1))<=140){
                           } 
                        if(!msg.sender.equals(ui.username)){
                        
                           play.player2.setBounds(Integer.parseInt(msg.content.substring(3)),play.player2.getBounds().y, play.player2.getWidth(), play.player2.getHeight());
                        }  
                    }
                else*/ 
                if(msg.type.equals("yourid")){
                    if(ui.jTextField4.getText().length()==0){ui.jTextField4.setText(msg.content);}
                }
                else if(msg.type.equals("atas")){
                    if(!msg.sender.equals(ui.username)){
                        ui.player2.setBounds(ui.player2.getBounds().x,Integer.parseInt(msg.content), ui.player2.getWidth(), ui.player2.getHeight());
                    }
                    else{
                        ui.player1.setBounds(ui.player1.getBounds().x,Integer.parseInt(msg.content), ui.player1.getWidth(), ui.player1.getHeight());
                    
                    if(ui.player1.getBounds().y<=404){
                        ui.bawah.setEnabled(true);
                    }
                    if(ui.player1.getBounds().y<=100){
                        ui.atas.setEnabled(false);
                    }
                    }
                }
                else if(msg.type.equals("bawah")){
                    if(!msg.sender.equals(ui.username)){
                        ui.player2.setBounds(ui.player2.getBounds().x,Integer.parseInt(msg.content), ui.player2.getWidth(), ui.player2.getHeight());
                    }
                    else{
                        ui.player1.setBounds(ui.player1.getBounds().x,Integer.parseInt(msg.content), ui.player1.getWidth(), ui.player1.getHeight());
                    
                    if(ui.player1.getBounds().y>=404){
                        ui.bawah.setEnabled(false);
                    }
                    if(ui.player1.getBounds().y>=100){
                        ui.atas.setEnabled(true);
                    }
                    }
                }
                else if(msg.type.equals("kanan")){
                    if(!msg.sender.equals(ui.username)){
                        ui.player2.setBounds(ui.player2.getBounds().x-(Integer.parseInt(msg.content)*2),ui.player2.getBounds().y, ui.player2.getWidth(), ui.player2.getHeight());
                    }
                    else{
                        ui.player1.setBounds(ui.player1.getBounds().x+Integer.parseInt(msg.content),ui.player1.getBounds().y, ui.player1.getWidth(), ui.player1.getHeight());
                    if(ui.player1.getBounds().x>=530){
                        ui.kanan.setEnabled(false);
                    }
                    if(ui.player1.getBounds().x>=10){
                        ui.kiri.setEnabled(true);
                    }
                    }
                }
                else if(msg.type.equals("kiri")){
                    if(!msg.sender.equals(ui.username)){
                        ui.player2.setBounds(ui.player2.getBounds().x+(Integer.parseInt(msg.content)*2),ui.player2.getBounds().y, ui.player2.getWidth(), ui.player2.getHeight());
                    }
                    else{
                        ui.player1.setBounds(ui.player1.getBounds().x-Integer.parseInt(msg.content),ui.player1.getBounds().y, ui.player1.getWidth(), ui.player1.getHeight());
                    if(ui.player1.getBounds().x<=530){
                        ui.kanan.setEnabled(true);
                    }
                    if(ui.player1.getBounds().x<=10){
                        ui.kiri.setEnabled(false);
                    }
                    }
                    
                }
                
                else if(msg.type.equals("disable")){
                    if(!msg.sender.equals(ui.username)){
                        ui.attack.setEnabled(false);
                        ui.repair.setEnabled(true);
                        ui.atas.setEnabled(false);
                        ui.kanan.setEnabled(false);
                        ui.kiri.setEnabled(false);
                        ui.bawah.setEnabled(false);
                        repaircountsendiri=0;
                    }
                    else{
                        disablecount=disablecount-1;
                        repaircountmusuh=0;
                        ui.disable.setEnabled(false);
                    }
                }
                
                else if(msg.type.equals("repair")){
                    if(msg.sender.equals(ui.username)){
                        repaircountsendiri=repaircountsendiri+1;
                    }
                    else{
                        repaircountmusuh=repaircountmusuh+1;
                    }
                    if(repaircountsendiri==5){
                            ui.repair.setEnabled(false);
                            ui.attack.setEnabled(true);
                            if(ui.player1.getBounds().y>100){
                                ui.atas.setEnabled(true);
                            }
                            if(ui.player1.getBounds().y<=404){
                                ui.bawah.setEnabled(true);
                            }
                            if(ui.player1.getBounds().x>10){
                                ui.kiri.setEnabled(true);
                            }
                            if(ui.player1.getBounds().x<530){
                                ui.kanan.setEnabled(true);
                            }
                            repaircountsendiri=0;
                    }
                    if(repaircountmusuh==5){
                        if(disablecount==0){
                            ui.disable.setEnabled(false);
                        }
                        else{
                            ui.disable.setEnabled(true);
                        }
                    }
                    
                }
                /*
                else if(msg.type.equals("x")){
                    if(!msg.sender.equals(ui.username)){
                        if(msg.content.equals("kurang")){
                            ui.player2.setBounds(ui.player2.getBounds().x+10,ui.player2.getBounds().y, ui.player2.getWidth(), ui.player2.getHeight());
                        }
                        else{
                            ui.player2.setBounds(ui.player2.getBounds().x-10,ui.player2.getBounds().y, ui.player2.getWidth(), ui.player2.getHeight());
                        }
                    }
                }
                 player1.setBounds(player1.getBounds().x, player1.getBounds().y-10, player1.getWidth(), player1.getHeight());
                else if(msg.type.equals("y")){
                    if(!msg.sender.equals(ui.username)){
                        if(msg.content.equals("kurang")){
                            ui.player2.setBounds(ui.player2.getBounds().x,Integer.parseInt(msg.content), ui.player2.getWidth(), ui.player2.getHeight());
                        }
                        else{
                            ui.player2.setBounds(ui.player2.getBounds().x,Integer.parseInt(msg.content), ui.player2.getWidth(), ui.player2.getHeight());
                        }
                    }
                        
                    
                }*/
                
                else if(msg.type.equals("serang")){
                    if(Integer.parseInt(msg.content)<20){
                        if(Math.abs(ui.player2.getBounds().x-ui.player1.getBounds().x)<=20 && Math.abs(ui.player2.getBounds().y-ui.player1.getBounds().y)<=10){
                            if(!msg.sender.equals(ui.username)){
                                if(hpsendiri>Integer.parseInt(msg.content)){
                                    hpsendiri=hpsendiri- Integer.parseInt(msg.content);
                                }
                                else{
                                    hpsendiri=0;
                                }
                                ui.healthbarsendiri.setValue(hpsendiri);
                                if(hpsendiri==0 || hpmusuh==0){
                                    ui.attack.setEnabled(false);
                                    ui.kanan.setEnabled(false);
                                    ui.atas.setEnabled(false);
                                    ui.kiri.setEnabled(false);
                                    ui.bawah.setEnabled(false);
                                    ui.ult.setEnabled(false);
                                    ui.heal.setEnabled(false);
                                    ui.repair.setEnabled(false);
                                    ui.disable.setEnabled(false);
                                    JOptionPane.showMessageDialog(null, "Lose !!");
                                }
                                ultcount=ultcount+2;
                                if(healing==0){
                                    ui.heal.setEnabled(false);
                                }else{
                                    ui.heal.setEnabled(true);
                                }
                            }
                            else {
                                
                                if(hpmusuh>Integer.parseInt(msg.content)){

                                    hpmusuh=hpmusuh-Integer.parseInt(msg.content);
                                }
                                else{
                                    hpmusuh=0;
                                }
                                ui.healthbarmusuh.setValue(hpmusuh);
                                if(hpsendiri==0 || hpmusuh==0){
                                    ui.attack.setEnabled(false);
                                    ui.kanan.setEnabled(false);
                                    ui.atas.setEnabled(false);
                                    ui.kiri.setEnabled(false);
                                    ui.bawah.setEnabled(false);
                                    ui.ult.setEnabled(false);
                                    ui.heal.setEnabled(false);
                                    ui.repair.setEnabled(false);
                                    ui.disable.setEnabled(false);
                                    JOptionPane.showMessageDialog(null, "win !!");
                                }
                                ultcount=ultcount+1;
                            }
                            if(ultcount>=10){
                                ui.ult.setEnabled(true);
                            }
                            else{
                                ui.ult.setEnabled(false);
                            }
                        }
                    }
                    else{
                        if(!msg.sender.equals(ui.username)){
                            if(hpsendiri>Integer.parseInt(msg.content)){
                                hpsendiri=hpsendiri- Integer.parseInt(msg.content);
                            }
                            else{
                                hpsendiri=0;
                            }
                            ui.healthbarsendiri.setValue(hpsendiri);
                            if(hpsendiri==0 || hpmusuh==0){
                                ui.attack.setEnabled(false);
                                ui.kanan.setEnabled(false);
                                ui.atas.setEnabled(false);
                                ui.kiri.setEnabled(false);
                                ui.bawah.setEnabled(false);
                                ui.ult.setEnabled(false);
                                ui.heal.setEnabled(false);
                                ui.repair.setEnabled(false);
                                ui.disable.setEnabled(false);
                                JOptionPane.showMessageDialog(null, "Lose !!");
                            }
                            if(healing==0){
                                ui.heal.setEnabled(false);
                            }else{
                                ui.heal.setEnabled(true);
                            }
                            ultcount=ultcount+2;
                        }
                        else {
                            if(hpmusuh>Integer.parseInt(msg.content)){
                                hpmusuh=hpmusuh-Integer.parseInt(msg.content);
                            }
                            else{
                                hpmusuh=0;
                            }
                            ui.healthbarmusuh.setValue(hpmusuh);
                             
                            if(hpsendiri==0 || hpmusuh==0){
                                ui.attack.setEnabled(false);
                                ui.kanan.setEnabled(false);
                                ui.atas.setEnabled(false);
                                ui.kiri.setEnabled(false);
                                ui.bawah.setEnabled(false);
                                ui.ult.setEnabled(false);
                                ui.heal.setEnabled(false);
                                ui.repair.setEnabled(false);
                                ui.disable.setEnabled(false);
                                JOptionPane.showMessageDialog(null, "win !!");
                            }
                            
                            ui.ult.setEnabled(false);
                            ultcount=0;
                        }
                    }
                    if(ultcount>=10){
                        ui.ult.setEnabled(true);
                    }
                    else{
                        ui.ult.setEnabled(false);
                    }
                    
                    if(hpsendiri==0 || hpmusuh==0){
                        ui.restart.setEnabled(true);
                        ui.ult.setEnabled(false);
                        ui.heal.setEnabled(false);
                    }
                }
                else if(msg.type.equals("heal")){
                    if(!msg.sender.equals(ui.username)){
                        hpmusuh=hpmusuh+Integer.parseInt(msg.content);
                        ui.healthbarmusuh.setValue(hpmusuh);
                    }
                    else{
                        hpsendiri=hpsendiri+Integer.parseInt(msg.content);
                        ui.healthbarsendiri.setValue(hpsendiri);
                        if(hpsendiri==100){
                            ui.heal.setEnabled(false);
                        }
                        healing=healing-1;
                        if(healing==0){
                            ui.heal.setEnabled(false);
                        }
                    }
                }
                else if(msg.type.equals("reset")){
                    if(!msg.sender.equals(ui.username)){
                        resetsendiri=1;
                    }
                    else {
                        resetmusuh=1;
                    }
                    if(resetsendiri==1 && resetmusuh==1){
                        ui.attack.setEnabled(true);
                        ui.kanan.setEnabled(true);
                        ui.atas.setEnabled(true);
                        ui.restart.setEnabled(false);
                        ui.ult.setEnabled(false);
                        ui.heal.setEnabled(false);
                        ui.repair.setEnabled(false);
                        ui.disable.setEnabled(true);
                        ultcount=0;
                        hpsendiri=100;
                        hpmusuh=100;
                        ui.healthbarsendiri.setValue(hpsendiri);
                        ui.healthbarmusuh.setValue(hpmusuh);
                        resetsendiri=0;
                        resetmusuh=0;
                        healing=5;
                        disablecount=3;
                        ui.player1.setBounds(10,410,ui.player1.getWidth(),ui.player1.getHeight());
                        ui.player2.setBounds(540,410,ui.player2.getWidth(),ui.player2.getHeight());
                            
                    }
                }
                /*
                else if(msg.type.equals("y")){
                    if(!msg.sender.equals(ui.username)){
                        ui.player2.setBounds(ui.player2.getBounds().x,Integer.parseInt(msg.content), ui.player2.getWidth(), ui.player2.getHeight());
                    }
                }*/
                else if(msg.type.equals("login")){
                    if(msg.content.equals("TRUE")){
                        ui.jButton2.setEnabled(false);                 
                        
                        ui.jTextArea1.append("[SERVER > Me] : Login Successful\n");
                        ui.jTextField4.setEnabled(false); 
                        ui.atas.setEnabled(true);/*
                        ui.bawah.setEnabled(true);
                        ui.kiri.setEnabled(true);*/
                        ui.kanan.setEnabled(true);
                        ui.attack.setEnabled(true);
                        ui.disable.setEnabled(true);
                    }
                    else{
                        ui.jTextArea1.append("[SERVER > Me] : Login Failed\n");
                    }
                }
                else if(msg.type.equals("test")){
                    ui.jButton1.setEnabled(false);
                    ui.jButton2.setEnabled(true); 
                    ui.jTextField4.setEnabled(true); 
                    ui.jTextField4.setEditable(true); 
                    ui.jTextField1.setEditable(false); ui.jTextField2.setEditable(false);                 
                } 
                else if(msg.type.equals("signout")){
                    if(msg.content.equals(ui.username)){
                        ui.jTextArea1.append("["+ msg.sender +" > Me] : Bye\n");
                        ui.jButton1.setEnabled(true); 
                        ui.jTextField1.setEditable(true); ui.jTextField2.setEditable(true);
                        
                        for(int i = 1; i < ui.model.size(); i++){
                            ui.model.removeElementAt(i);
                        }
                        
                        ui.clientThread.stop();
                    }
                    else{
                        ui.model.removeElement(msg.content);
                        ui.jTextArea1.append("["+ msg.sender +" > All] : "+ msg.content +" has signed out\n");
                    }
                }/*
                else{
                }*/
            }
            catch(Exception ex) {
                keepRunning = false;
                ui.jTextArea1.append("[Application > Me] : Connection Failure\n");
                ui.jButton1.setEnabled(true); ui.jTextField1.setEditable(true); ui.jTextField2.setEditable(true);
                
                
                for(int i = 1; i < ui.model.size(); i++){
                    ui.model.removeElementAt(i);
                }
                
                ui.clientThread.stop();
                
                System.out.println("Exception SocketClient run()");
                ex.printStackTrace();
            }
        }
    }
    
    public void send(Message msg){
        try {
            Out.writeObject(msg);
            Out.flush();
            System.out.println("Outgoing : "+msg.toString());
            
            if(msg.type.equals("message") && !msg.content.equals(".bye")){
                String msgTime = (new Date()).toString();
                
            }
        } 
        catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }
    
    public void closeThread(Thread t){
        t = null;
    }
}
