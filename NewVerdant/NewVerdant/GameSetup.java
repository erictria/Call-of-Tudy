/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Migs
 */
public class GameSetup extends javax.swing.JFrame {
    public JFrame GS = this;
    protected JComboBox playerAmount;
    protected String[] noOfPlayers = {"2","3","4"};
    protected String[] playerList = {"AI","Mr Magic", "Mr Butch", "ReD", "Chase"};
    protected String[] playerList2 = {"Mr Magic", "Mr Butch", "ReD", "Chase"};
    protected String[] mapList = {"Classic", "Spicy", "Sky Dive", "Factory"};
    protected String[] gameType = {"Deathmatch"};
    protected GameStarter at;
    //public String[] gameType = {"Deathmatch", "Team Deathmatch", "Tag"};
    //public String[] 
    protected String imagePath = "Images\\";
    protected String ip = "";
    protected String port = ""; 
    protected String name = "";
    protected JFrame frame = this;
    protected boolean isLocal = false;
    public GameSetup(String ip, String port, String name) {
        this.ip = ip;
        this.port = port;
        this.name = name;
        initComponents();
        //addWindowListner(new OpenMain());
    }
    public GameSetup(String name)
    {
        this.name = name;
        isLocal = true;
        initComponents();
        //addWindowListner(new OpenMain());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        addWindowListener(new OpenMain(this));
        livesLabel = new javax.swing.JLabel();
        livesTextField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        mapsLabel = new javax.swing.JLabel();
        playersLabel = new javax.swing.JLabel();
        playerAmount = new javax.swing.JComboBox();
        
        gameTypeLabel = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        gameStartButton = new javax.swing.JButton();
        player1ActualImage = new javax.swing.JLabel();
        player2ActualImage = new javax.swing.JLabel();
        player3ActualImage = new javax.swing.JLabel();
        player4ActualImage = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        mapsComboBox = new javax.swing.JComboBox();
        livesLabel1 = new javax.swing.JLabel();
        livesLabel2 = new javax.swing.JLabel();
        gameTypeComboBox = new javax.swing.JComboBox();
        player1ComboBox = new javax.swing.JComboBox();
        player2ComboBox = new javax.swing.JComboBox();
        player3ComboBox = new javax.swing.JComboBox();
        player4ComboBox = new javax.swing.JComboBox();
        player1Image = new javax.swing.JLabel();
        player2Image = new javax.swing.JLabel();
        player3Image = new javax.swing.JLabel();
        player4Image = new javax.swing.JLabel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        livesLabel.setText("Lives (Default: 3)");

        livesTextField.setText("3");

        mapsLabel.setText("Map (Default: Classic)");

        portLabel.setText("Port");

        playersLabel.setText("Number of Players (Default: 4)");

        playerAmount.setModel(new JComboBox<>(noOfPlayers).getModel());
        playerAmount.setSelectedItem("4");
        playerAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerAmountActionPerformed(evt);
            }
        });

        gameTypeLabel.setText("Game Type (Default: Deathmatch)");

        ipLabel.setText("IP Address");

        gameStartButton.setText("Start Game");
        gameStartButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                frame.dispose();
                String[] playersChosen = null;
                int numberOfPlayers = Integer.parseInt( (String) playerAmount.getSelectedItem());
                
                 
                String mapChosen = (String) mapsComboBox.getSelectedItem();
                int livesChosen = Integer.parseInt( livesTextField.getText());
                boolean[] players = {true, true, true, true};
                
                String player1Type = (String) player1ComboBox.getSelectedItem();
                String player2Type = (String) player2ComboBox.getSelectedItem();
                String player3Type = (String) player3ComboBox.getSelectedItem();
                String player4Type = (String) player4ComboBox.getSelectedItem();
                
                if ( player1Type.equals("AI"))
                {
                    players[0] = false;
                    int randomPlayer = (int)(Math.random()*playerList2.length);
                    String random = (playerList2[randomPlayer]);
                    player1Type = random;
                }
                if (player2Type.equals("AI"))
                {
                    players[1] = false;
                    int randomPlayer = (int)(Math.random()*playerList2.length);
                    String random = (playerList2[randomPlayer]);
                    player2Type = random;
                }
                if ( player3Type.equals("AI"))
                {
                    players[2] = false;
                    int randomPlayer = (int)(Math.random()*playerList2.length);
                    String random = (playerList2[randomPlayer]);
                    player3Type = random;
                }
                if ( player4Type.equals("AI"))
                {
                    players[3] = false;
                    int randomPlayer = (int)(Math.random()*playerList2.length);
                    String random = (playerList2[randomPlayer]);
                    player4Type = random;
                }
                
                if (numberOfPlayers == 2)
                {
                    playersChosen = new String[]{player1Type, player2Type};
                }
                else if (numberOfPlayers == 3)
                {
                    playersChosen = new String[]{player1Type, player2Type, player3Type};
                }
                else if (numberOfPlayers == 4)
                {
                    playersChosen = new String[]{player1Type, player2Type, player3Type, player4Type};
                }
                
                OnlineGameSetup.hasStarted = true;
                //String gameType = (String) 
                at = new GameStarter(mapChosen,livesChosen, players,
                              playersChosen, isLocal);
             }
          });

        try
        {
            Icon icon1, icon2, icon3, icon4;
            icon1 = new ImageIcon(getClass().getResource("Images\\Player1.png"));
            icon2 = new ImageIcon(getClass().getResource("Images\\Player2.png"));
            icon3 = new ImageIcon(getClass().getResource("Images\\Player3.png"));
            icon4 = new ImageIcon(getClass().getResource("Images\\Player4.png")); 
            
            player1ActualImage.setIcon(icon1);
            player2ActualImage.setIcon(icon2);
            player3ActualImage.setIcon(icon3);
            player4ActualImage.setIcon(icon4);
        }
        catch (Exception e)
        {
        }

        confirmButton.setText("Set");
        confirmButton.setOpaque(false);
        /*
        confirmButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (playerAmount.getText().equals("0"))
                {
                    player1ComboBox.setEnabled(false);
                    player2ComboBox.setEnabled(false);   
                    player3ComboBox.setEnabled(false);   
                    player4ComboBox.setEnabled(false);   
                }
                else
                if (playerAmount.getText().equals("1"))
                {
                    player1ComboBox.setEnabled(true);
                    player2ComboBox.setEnabled(false);   
                    player3ComboBox.setEnabled(false);   
                    player4ComboBox.setEnabled(false);   
                }
                else if(playerAmount.getText().equals("2"))
                {
                    player1ComboBox.setEnabled(true);
                    player2ComboBox.setEnabled(true);    
                    player3ComboBox.setEnabled(false);   
                    player4ComboBox.setEnabled(false);   
                }
                else if(playerAmount.getText().equals("3"))
                {
                    player1ComboBox.setEnabled(true);
                    player2ComboBox.setEnabled(true);    
                    player3ComboBox.setEnabled(true);    
                    player4ComboBox.setEnabled(false);   
                }
                else
                {
                    player1ComboBox.setEnabled(true);
                    player2ComboBox.setEnabled(true);    
                    player3ComboBox.setEnabled(true);    
                    player4ComboBox.setEnabled(true);    
                }
                
            }
        }); */
        mapsComboBox.setModel(new JComboBox<>(mapList).getModel());

        livesLabel1.setText(port);

        livesLabel2.setText(ip);

        gameTypeComboBox.setModel(new JComboBox<>(gameType).getModel());

        //player1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        player1ComboBox.setModel(new JComboBox<>(playerList).getModel());
        player1ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1ComboBoxActionPerformed(evt);
            }
        });
        player2ComboBox.setModel(new JComboBox<>(playerList).getModel());
        player2ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2ComboBoxActionPerformed(evt);
            }
        });
        player3ComboBox.setModel(new JComboBox<>(playerList).getModel());
        player3ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3ComboBoxActionPerformed(evt);
            }
        });
        player4ComboBox.setModel(new JComboBox<>(playerList).getModel());
        player4ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player4ComboBoxActionPerformed(evt);
            }
        });
        //player2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        //player3ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        //player4ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        player1Image.setText("Player Icon");

        player2Image.setText("Player Icon");

        player3Image.setText("Player Icon");

        player4Image.setText("Player Icon");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(portLabel)
                            .addComponent(mapsLabel)
                            .addComponent(livesLabel)
                            .addComponent(livesTextField))
                        .addComponent(player1ActualImage, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(player3ActualImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(mapsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(livesLabel1)
                    .addComponent(player1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player3ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(260, 260, 260)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(player2ActualImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(playersLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gameTypeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ipLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(playerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(confirmButton)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(player4ActualImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(323, 323, 323))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(livesLabel2)
                            .addComponent(gameTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(player4Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(player2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(player4ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(player2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(gameStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livesLabel)
                    .addComponent(playersLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mapsLabel)
                    .addComponent(gameTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mapsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portLabel)
                    .addComponent(ipLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livesLabel1)
                    .addComponent(livesLabel2))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(player1ActualImage, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(player2ActualImage, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player3ActualImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player4ActualImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player3ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player4ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player4Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(gameStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        confirmButton.setVisible(false);
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); 
        getRootPane().getActionMap().put("Cancel", new AbstractAction(){ 
            public void actionPerformed(ActionEvent e)
            {
                GS.dispose();
                JFrame frame = new LaunchGame();
            }
        });
    }// </editor-fold>                        

    private void playerAmountActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String temp = (String) playerAmount.getSelectedItem();
        if(temp.equals("2"))
        {
            player1ComboBox.setEnabled(true);
            player2ComboBox.setEnabled(true);    
            player3ComboBox.setEnabled(false);   
            player4ComboBox.setEnabled(false);   
        }
        else if(temp.equals("3"))
        {
            player1ComboBox.setEnabled(true);
            player2ComboBox.setEnabled(true);    
            player3ComboBox.setEnabled(true);    
            player4ComboBox.setEnabled(false);   
        }
        else
        {
            player1ComboBox.setEnabled(true);
            player2ComboBox.setEnabled(true);    
            player3ComboBox.setEnabled(true);    
            player4ComboBox.setEnabled(true);    
        }
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameSetup().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify                     
    protected javax.swing.JButton confirmButton;
    protected javax.swing.JButton gameStartButton;
    protected javax.swing.JComboBox mapsComboBox;
    protected javax.swing.JComboBox gameTypeComboBox;
    protected javax.swing.JComboBox player1ComboBox;
    protected javax.swing.JComboBox player2ComboBox;
    protected javax.swing.JComboBox player3ComboBox;
    protected javax.swing.JComboBox player4ComboBox;
    protected javax.swing.JLabel livesLabel;
    protected javax.swing.JLabel player4ActualImage;
    protected javax.swing.JLabel livesLabel1;
    protected javax.swing.JLabel livesLabel2;
    protected javax.swing.JLabel player1Image;
    protected javax.swing.JLabel player2Image;
    protected javax.swing.JLabel player3Image;
    protected javax.swing.JLabel player4Image;
    protected javax.swing.JLabel mapsLabel;
    protected javax.swing.JLabel portLabel;
    protected javax.swing.JLabel playersLabel;
    protected javax.swing.JLabel gameTypeLabel;
    protected javax.swing.JLabel ipLabel;
    protected javax.swing.JLabel player1ActualImage;
    protected javax.swing.JLabel player2ActualImage;
    protected javax.swing.JLabel player3ActualImage;
    protected javax.swing.JTextField livesTextField;
    //private javax.swing.JTextField playerAmount;
    // End of variables declaration               

    private void player1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        
        
        String temp = (String)player1ComboBox.getSelectedItem();
        Icon icon;
        try
        {
            icon = new ImageIcon(getClass().getResource(imagePath + temp + ".png")); 
            player1Image.setText("");
            player1Image.setIcon(icon);
        }
        catch (Exception e)
        {
        }
    }
    private void player2ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        
        
        String temp = (String)player2ComboBox.getSelectedItem();
        Icon icon;
        try
        {
            icon = new ImageIcon(getClass().getResource(imagePath + temp + ".png")); 
            player2Image.setText("");
            player2Image.setIcon(icon);
        }
        catch (Exception e)
        {
        }
    }
    private void player3ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        
        
        String temp = (String)player3ComboBox.getSelectedItem();
        Icon icon;
        try
        {
            icon = new ImageIcon(getClass().getResource(imagePath + temp + ".png")); 
            player3Image.setText("");
            player3Image.setIcon(icon);
        }
        catch (Exception e)
        {
        }
    }
    private void player4ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        
        
        String temp = (String)player4ComboBox.getSelectedItem();
        Icon icon;
        try
        {
            icon = new ImageIcon(getClass().getResource(imagePath + temp + ".png")); 
            player4Image.setText("");
            player4Image.setIcon(icon);
        }
        catch (Exception e)
        {
        }
    }            
}