
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class RPS extends javax.swing.JFrame {
    
    //Attempts variable...
    //global variable
    private int attempts = 5;
    
   

   //Lets create borders...
    Border grayBorder = BorderFactory.createMatteBorder(1,1,1,1, Color.DARK_GRAY);
    Border orangeBorder = BorderFactory.createMatteBorder(1,1,1,1, Color.ORANGE);
    
    //load pictures to variable, local variable
    String rock = "/images/Rock Icon.jpg";
    String paper = "/images/Paper Icon.jpg";
    String scissors = "/images/Scissor Icon.jpg";
    
    //Lets create an arrayList for the choices of the player
    ArrayList <String> list = new ArrayList<>();
    Random random = new Random();
    
    //declare local variables for player and the computer
    int yourWins = 0, computerWins = 0;
    String randomSelection;
    
    
    public RPS() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        // Set the title of the application
        setTitle("Rock Paper Scissors Game");
    
        // Set the application icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Scissor Icon.jpg")); // Replace with your actual icon path
        setIconImage(icon.getImage());
        
        // Set Label Border for both the player and the computer
        jLabelPlayer.setBorder(grayBorder);
        jLabelComputer.setBorder(grayBorder);
        
        //Label that acts as a button. The player's choices
        jLabelComputer.setBorder(grayBorder);
        jLabelRock.setBorder(grayBorder);
        jLabelPaper.setBorder(grayBorder);
        jLabelScissor.setBorder(grayBorder);
        
        list.add(rock);
        list.add(paper);
        list.add(scissors);
        
        displayImage(rock, jLabelRock);
        displayImage(paper, jLabelPaper);
        displayImage(scissors, jLabelScissor);
        
    }
    
   // Method to handle player moves
    private void handlePlayerMove() {
        if (attempts > 0) {
            attempts--; // Decrement attempts
            jLabelAttempts.setText("Attempts: " + attempts); // Update label
            
            if (attempts == 0) {
                gameOverDialog();
            }
        }
    }
    
    


// Show JDialog when attempts reach 0
private void gameOverDialog() {
    String message;
    
    // Convert JLabel text to int
    int playerScoreValue = Integer.parseInt(playerScore.getText());
    int computerScoreValue = Integer.parseInt(computerScore.getText());
    
    // overall score
    
    if (playerScoreValue == computerScoreValue) {
        message = "It's a tie!";
    }else if(playerScoreValue > computerScoreValue) {
        message = "You Won! Congratulations";
  
    } else {
        message = "You lose! Computer Won";
    }
    
    // Append overall score to the message
    message += "\n\nFinal Score:\nPlayer: " + playerScoreValue + "\nComputer: " + computerScoreValue;
    
     // Show the message in a dialog and ask to play again
    int choice = JOptionPane.showConfirmDialog(this, message + "\n\nDo you want to play again?", 
                                               "Game Over", 
                                               JOptionPane.YES_NO_OPTION, 
                                               JOptionPane.INFORMATION_MESSAGE);
    
    if (choice == JOptionPane.YES_OPTION) {
        resetGame(); // Reset the game if the player chooses "Yes"
    } else {
        System.exit(0); // Exit the game if the player chooses "No"
    }
}

// Method to reset the game
private void resetGame() {
    attempts = 5; // Reset attempts
    yourWins = 0; // Reset player score tracking
    computerWins = 0; // Reset computer score tracking
    playerScore.setText("0"); // Reset player score
    computerScore.setText("0"); // Reset computer score
    jLabelAttempts.setText("Attempts: " + attempts); // Update attempts label
    jLabelStatus.setText("-----------------------");

}
    private void displayImage(String imagePath, JLabel label) {
        // Get images...
        ImageIcon imgIco = new ImageIcon(getClass().getResource(imagePath));
        //resize images
        Image img = imgIco.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        //set image into JLabel...
        label.setIcon(new ImageIcon(img));
       
    }   
    //get the winner for a point
    public void getWinner(String player, String computer) {
    if (player.equals(computer)) {
        System.out.println("0");
        jLabelAttempts.setText("It's a Tie!");
        jLabelStatus.setText("       Draw!");
    } else if ((player.equals(rock) && computer.equals(scissors)) ||
               (player.equals(paper) && computer.equals(rock)) ||
               (player.equals(scissors) && computer.equals(paper))) {
        yourWins++;
        playerScore.setText(String.valueOf(yourWins));
        jLabelAttempts.setText("Player Wins!");
        jLabelStatus.setText("   Player Wins!");
    } else {
        computerWins++;
        computerScore.setText(String.valueOf(computerWins));
        jLabelAttempts.setText("Computer Wins!");
        jLabelStatus.setText("Computer Wins!");
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

        jLabelComputer = new javax.swing.JLabel();
        computerScore = new javax.swing.JLabel();
        playerScore = new javax.swing.JLabel();
        jLabelScissor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelPlayer = new javax.swing.JLabel();
        jLabelRock = new javax.swing.JLabel();
        jLabelPaper = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelAttempts = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelComputer.setBackground(new java.awt.Color(153, 153, 153));
        jLabelComputer.setOpaque(true);
        getContentPane().add(jLabelComputer, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 230, 173));

        computerScore.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        computerScore.setForeground(new java.awt.Color(255, 255, 255));
        computerScore.setText("0");
        getContentPane().add(computerScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 176, 40, -1));

        playerScore.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        playerScore.setForeground(new java.awt.Color(255, 255, 255));
        playerScore.setText("0");
        getContentPane().add(playerScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 176, 41, -1));

        jLabelScissor.setBackground(new java.awt.Color(51, 204, 255));
        jLabelScissor.setOpaque(true);
        jLabelScissor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelScissorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelScissorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelScissorMouseExited(evt);
            }
        });
        getContentPane().add(jLabelScissor, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 306, 177, 137));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("-");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 176, -1, -1));

        jLabelPlayer.setBackground(new java.awt.Color(153, 153, 153));
        jLabelPlayer.setOpaque(true);
        getContentPane().add(jLabelPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 230, 173));

        jLabelRock.setBackground(new java.awt.Color(51, 204, 255));
        jLabelRock.setToolTipText("");
        jLabelRock.setOpaque(true);
        jLabelRock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRockMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRockMouseExited(evt);
            }
        });
        getContentPane().add(jLabelRock, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 306, 177, 137));

        jLabelPaper.setBackground(new java.awt.Color(51, 204, 255));
        jLabelPaper.setOpaque(true);
        jLabelPaper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPaperMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPaperMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPaperMouseExited(evt);
            }
        });
        getContentPane().add(jLabelPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 306, 178, 137));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Computer");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 181, 50));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("You");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 78, 38));

        jLabelAttempts.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabelAttempts.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAttempts.setText("Attempts: 5");
        getContentPane().add(jLabelAttempts, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 138, -1));

        jLabelStatus.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("-----------------------");
        getContentPane().add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 690, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelRockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRockMouseClicked
    //display rock image    
    displayImage(rock, jLabelPlayer);
    //make a random selection...
    randomSelection = list.get(random.nextInt(list.size()));
    //display image...
    displayImage(randomSelection, jLabelComputer); 
    getWinner(rock, randomSelection);
    handlePlayerMove();
    }//GEN-LAST:event_jLabelRockMouseClicked

    private void jLabelRockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRockMouseEntered
        jLabelRock.setBorder(orangeBorder);
        
    }//GEN-LAST:event_jLabelRockMouseEntered

    private void jLabelPaperMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPaperMouseEntered
        jLabelPaper.setBorder(orangeBorder);
        
    }//GEN-LAST:event_jLabelPaperMouseEntered

    private void jLabelScissorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelScissorMouseEntered
       jLabelScissor.setBorder(orangeBorder);
        
    }//GEN-LAST:event_jLabelScissorMouseEntered

    private void jLabelRockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRockMouseExited
       jLabelRock.setBorder(grayBorder);
    }//GEN-LAST:event_jLabelRockMouseExited

    private void jLabelPaperMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPaperMouseExited
        jLabelPaper.setBorder(grayBorder);      
    }//GEN-LAST:event_jLabelPaperMouseExited
   
    private void jLabelScissorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelScissorMouseExited
        jLabelScissor.setBorder(grayBorder);
    }//GEN-LAST:event_jLabelScissorMouseExited

    private void jLabelPaperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPaperMouseClicked
        displayImage(paper, jLabelPlayer);
        //make a random selection...
        randomSelection = list.get(random.nextInt(list.size()));
        //display image...
        displayImage(randomSelection, jLabelComputer); 
        getWinner(paper, randomSelection);
        handlePlayerMove();
    }//GEN-LAST:event_jLabelPaperMouseClicked

    private void jLabelScissorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelScissorMouseClicked
        displayImage(scissors, jLabelPlayer);
        
        //make a random selection...
        randomSelection = list.get(random.nextInt(list.size()));
        
        //display image...
        displayImage(randomSelection, jLabelComputer);
        getWinner(scissors, randomSelection);
        handlePlayerMove();
    }//GEN-LAST:event_jLabelScissorMouseClicked

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
            java.util.logging.Logger.getLogger(RPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RPS().setVisible(true);
            }
        });
    }
    //global variables
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel computerScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAttempts;
    private javax.swing.JLabel jLabelComputer;
    private javax.swing.JLabel jLabelPaper;
    private javax.swing.JLabel jLabelPlayer;
    private javax.swing.JLabel jLabelRock;
    private javax.swing.JLabel jLabelScissor;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel playerScore;
    // End of variables declaration//GEN-END:variables
}
