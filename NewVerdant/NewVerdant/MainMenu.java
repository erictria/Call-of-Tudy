import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class MainMenu here.
 * 
 * @author Migs
 * @version May 18
 */
public class MainMenu extends JFrame
{
    JFrame frame = new JFrame();
    Icon gameLogo = new ImageIcon(getClass().getResource("Images\\NewV_Logo.png"));
    public MainMenu()
    {
        frame.setSize(1050,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel panel = new JPanel();
        
        //Logo
        JLabel logo = new JLabel();
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo.setIcon(gameLogo);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(logo);
        
        //Buttons
        
        // === HOST ===
        JButton hostButton = new JButton("Host Network Game");
        hostButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hostButton.setMargin(new Insets(30,30,30,30));
        hostButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String port = JOptionPane.showInputDialog(frame, "Please Input Port Number");
                String name = JOptionPane.showInputDialog(frame, "What is your name?");
                System.out.println("Port: " + port + "\nName: " + name);
            }
            
            
        });
        
        // === JOIN === 
        JButton joinButton = new JButton("Join Network Game");
        joinButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        joinButton.setMargin(new Insets(30,30,30,30));
        joinButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String port = JOptionPane.showInputDialog(frame, "Please Input Port Number");
                String IP = JOptionPane.showInputDialog(frame, "Please Input IP Address of Server");
                String name = JOptionPane.showInputDialog(frame, "What is your name?");
                System.out.println("Port: " + port + "\nIP Address: " + IP + "\nName: " + name);
            }
            
           
        });
        
        // === LOCAL ===
        JButton localButton = new JButton("Local Game");
        localButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        localButton.setMargin(new Insets(30,30,30,30));
        
        // === SET CONTROLS ===
        JButton setControlsButton = new JButton("Set Controls");
        setControlsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setControlsButton.setMargin(new Insets(30,30,30,30));
        setControlsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                //JFrame setControls = new SetPlayerControls();
            }
            
           
        });
        
        panel.add(hostButton);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(joinButton);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(localButton);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(setControlsButton);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        JFrame main = new MainMenu();
    }
}
