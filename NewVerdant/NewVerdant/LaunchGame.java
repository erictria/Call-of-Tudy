import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import sun.audio.*;
import javax.sound.sampled.*;
import java.net.*;
public class LaunchGame extends JFrame
{
    JButton start;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JPanel panel;
    JPanel subpanel;
    JMenuBar mb;
    JMenuItem help;
    String ip,girl,boy;
    //Map map,map1;
    Clip clip;
    LaunchGame lg;
    public LaunchGame()
    {
        lg = this;
        this.setSize(1050,720);
        this.setResizable(false);
        
        mb = new JMenuBar();
        help = new JMenuItem("Help");
        help.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "KILL YOUR OPPONENT");
            }
        });
        mb.add(help);
        
        setJMenuBar(mb);
        
        panel = new JPanel(new BorderLayout());
        subpanel = new JPanel();
        start = new JButton("Host Network Game");
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String port = JOptionPane.showInputDialog(lg, "Please Input Port Number");
                String name = JOptionPane.showInputDialog(lg, "What is your name?");
                //System.out.println("Port: " + port + "\nName: " + name);
                JFrame next = new OnlineGameSetup("localhost", port, name);
                lg.setVisible(false);
            }
            
            
        });
        two = new JButton("Join Network Game");
        two.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String port = JOptionPane.showInputDialog(lg, "Please Input Port Number");
                String IP = JOptionPane.showInputDialog(lg, "Please Input IP Address of Server");
                String name = JOptionPane.showInputDialog(lg, "What is your name?");
                //System.out.println("Port: " + port + "\nIP Address: " + IP + "\nName: " + name);
                JFrame next = new OnlineGameSetee(IP, port, name);
                lg.setVisible(false);
                
            }
    
        });
        three = new JButton("Local Game");
        three.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JFrame next = new GameSetup("Nevi");
                lg.setVisible(false);
            }
    
        });
        four = new JButton("Set Controls");
        four.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JFrame setControls = new SetMultiplayerControls();
            }
    
        });
        five = new JButton("Quit Game");
        canvasBackground cb = new canvasBackground();
        panel.add("Center", cb);
        subpanel.add(start);
        subpanel.add(two);
        subpanel.add(three);
        subpanel.add(four);
        subpanel.add(five);
        panel.add("South", subpanel);
        add(panel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
        this.setTitle("Call of Tudy");
        
        start.addActionListener(new button());
        five.addActionListener(new quit());
        
        
        
        /*try
        {
            URL url = this.getClass().getClassLoader().getResource("best.au");
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (Exception e) {}
        clip.loop(Clip.LOOP_CONTINUOUSLY);*/
    }
    public static void main(String[] args) throws Exception
    {
        JFrame f = new LaunchGame();
        
    }
    
    class button implements ActionListener
{
        public void actionPerformed(ActionEvent a)
        {
           
        }
    
    }
    class quit implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            lg.dispose();
        }
    }
}
class canvasBackground extends Canvas
{
    private BufferedImage img;
    public canvasBackground()
    {
        try
        {
            img = ImageIO.read(getClass().getResource("Images\\co2d.jpg"));
        }
        catch(IOException e)
        {
        }
    }
    public void paint(Graphics g)
    {
        g.drawImage(img,0,0,null);
    }
}