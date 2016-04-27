//JUST A TEST. Expected output is a bunch of red boxes not moving but rotating
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class SetPlayerControls
{
    static Map map;
    static int ijk = -1;
    static JLabel[] jl = new JLabel[12];
    static JButton[] jb = new JButton[12];
    static int[] buttonKeys = new int[12];
    public static void main(String args[]){
        String controlName = "Controller";
        try{
            FileReader fr = new FileReader(controlName);
            Scanner sc = new Scanner(fr);
            String namer = sc.nextLine();
            String[] split = namer.split("\\s");
            //System.out.println(split.length);
            for(String x:split)
                //System.out.println(x);
            for(int i = 0; i!=buttonKeys.length; i++)
                buttonKeys[i] = Integer.parseInt(split[i]);
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
            x.add(jl[j]);
            x.add(jb[j]);
        }
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        x.addKeyListener(new KeyRecorder());
        x.setLayout(new GridLayout(7,4));
        x.add(new JLabel(""));
        x.add(new JLabel(""));
        x.add(new JLabel(""));
        JButton record = new JButton("Record");
        x.add(record);
        record.addActionListener(new ControlsWriter(controlName));
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
