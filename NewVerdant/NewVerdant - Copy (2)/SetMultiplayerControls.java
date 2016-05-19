
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class SetMultiplayerControls extends JFrame
{
     Map map;
     int ijk = -1;
     JComboBox<String> cb = new JComboBox<String>();
     JLabel[] jl = new JLabel[12];
     JButton[] jb = new JButton[12];
     int[] buttonKeys = new int[12];
    public SetMultiplayerControls()
    {
        cb.addItem("Player 1");
        cb.addItem("Player 2");
        cb.addItem("Player 3");
        cb.addItem("Player 4");
        String controlName = "Controller";
        try{
            for (int j = 0; j<4; j++)
            {
                FileReader fr = new FileReader("Player " + j);
                Scanner sc = new Scanner(fr);
                String namer = sc.nextLine();
                String[] split = namer.split("\\s");
                //System.out.println(split.length);
                for(String x:split)
                    //System.out.println(x);
                for(int i = 0; i!=buttonKeys.length; i++)
                    buttonKeys[i] = Integer.parseInt(split[i]); 
            }
           
        }catch(IOException ioe){}
        class KeyRecorder implements KeyListener{
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                if(ijk>-1){
                    for(int i = 0; i!=12; i++){
                        if(buttonKeys[i] == e.getKeyCode()){
                            buttonKeys[i] = -1;
                            //jb[i].setText(KeyEvent.getKeyText(buttonKeys[i]));
                            jb[i].setText("Unassigned");
                        }
                    }
                    buttonKeys[ijk] = e.getKeyCode();
                    //System.out.println(e.getKeyText(e.getKeyCode()));
                    jb[ijk].setText(KeyEvent.getKeyText(buttonKeys[ijk]));
                    ijk = -1;
                }
                //System.out.println(e.getKeyText(e.getKeyCode()));
                //System.out.println(e.getKeyCode());
            }

            public void keyTyped(KeyEvent e){
                //System.out.println(String.fromCharCode(e.getKeyCode()));
            }
        }
        class ActionRecorder implements ActionListener{
            int i;
            public ActionRecorder(int j){
                i=j;
            }

            public void actionPerformed(ActionEvent e){
                ijk = i;
                //System.out.println(ijk);
            }
        }
        class ControlsWriter implements ActionListener{
            String fileName;
            public ControlsWriter(String fN){
                fileName = fN;
            }
            
            public void actionPerformed(ActionEvent e){
                try
                {
                    String cbSelected = (String) cb.getSelectedItem();
                    if(cbSelected.equals("Player 1"))
                    {
                        fileName = "Controller 1";
                    }
                    else if ( cbSelected.equals("Player 2") )
                    {
                        fileName = "Controller 2";
                    }
                    else if ( cbSelected.equals("Player 3") )
                    {
                        fileName = "Controller 3";
                    }
                    else if ( cbSelected.equals("Player 4") )
                    {
                        fileName = "Controller 4";
                    }
                    else 
                    {
                        System.out.println("oops");
                    }
                }
                catch (Exception ae)
                {
                }
                
                FileWriter fw = null;
                try{
                    fw = new FileWriter(fileName);
                }catch(IOException ioe){
                }
                String writer = "";
                for(int i = 0; i!= buttonKeys.length; i++){
                    writer += buttonKeys[i];
                    if(i!=buttonKeys.length-1)
                        writer+=" ";
                }
                try{
                    fw.write(writer);
                    fw.flush();
                    fw.close();
                }catch(IOException ioe){
                }
            }
        }
        JFrame x = new JFrame();
        JPanel p = new JPanel();
        int i = 0;
        jl[i++] = new JLabel("Up");
        jl[i++] = new JLabel("Down");
        jl[i++] = new JLabel("Left");
        jl[i++] = new JLabel("Right");
        jl[i++] = new JLabel("Action 1");
        jl[i++] = new JLabel("Action 2");
        jl[i++] = new JLabel("Action 3");
        jl[i++] = new JLabel("Action 4");
        jl[i++] = new JLabel("Fire Up");
        jl[i++] = new JLabel("Fire Left");
        jl[i++] = new JLabel("Fire Right");
        jl[i++] = new JLabel("Fire Down");
        i = 0;
        /*buttonKeys[i++] = KeyEvent.VK_UP;
        buttonKeys[i++] = KeyEvent.VK_DOWN;
        buttonKeys[i++] = KeyEvent.VK_LEFT;
        buttonKeys[i++] = KeyEvent.VK_RIGHT;
        buttonKeys[i++] = KeyEvent.VK_Q;
        buttonKeys[i++] = KeyEvent.VK_E;
        buttonKeys[i++] = KeyEvent.VK_R;
        buttonKeys[i++] = KeyEvent.VK_F;
        buttonKeys[i++] = KeyEvent.VK_W;
        buttonKeys[i++] = KeyEvent.VK_A;
        buttonKeys[i++] = KeyEvent.VK_D;
        buttonKeys[i++] = KeyEvent.VK_S;*/
        for(int j = 0; j!= 12; j++){
            jb[j] = new JButton(KeyEvent.getKeyText(buttonKeys[j]));
        }
        for(int j = 0; j!= 12; j++){
            jb[j].addActionListener(new ActionRecorder(j));
            jb[j].addKeyListener(new KeyRecorder());
        }
        for(int j = 0; j!=12; j++){
            p.add(jl[j]);
            p.add(jb[j]);
        }
        x.setSize(1050,720);
        x.setLayout(new BorderLayout());
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        p.addKeyListener(new KeyRecorder());
        p.setLayout(new GridLayout(7,4));
        p.add(new JLabel(""));
        p.add(new JLabel(""));
        p.add(new JLabel(""));
        JButton record = new JButton("Record");
        p.add(record);
        record.addActionListener(new ControlsWriter(controlName));
        
        x.add("North", cb);
        x.add("Center", p);
        //map = new Map();
        //x.add(map);
        //x.addComponentListener(new Resizer(map));
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
         */
        //addSpawnRandTestFunc(20);
        //map.gameLoop();
        //x.add();
    }
    

       
}
