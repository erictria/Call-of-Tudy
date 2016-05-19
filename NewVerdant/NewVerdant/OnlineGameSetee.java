
/**
 * Setup for online games
 */
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class OnlineGameSetee extends GameSetup
{
    static ThreadGroup grover = new ThreadGroup("OMG");
    static ArrayList<Socket> s = new ArrayList<Socket>();
    static MapReader mapper = new MapReader();
    static NetworkedController myController = new NetworkedController(mapper);
    static boolean hasStarted = false;
    public OnlineGameSetee(String ip, String port, String name){
        super(ip,port,name);
        hasStarted = false;
        gameStartButton.setEnabled(false);
        mapsComboBox.setEnabled(false);
        gameTypeComboBox.setEnabled(false);
        playerAmount.setEnabled(false);
        livesTextField.setEnabled(false);
        player1ComboBox.setEnabled(false);
        Socket s = null;
        int port1 = Integer.parseInt(port);
        try{
            s = new Socket(ip,port1);
        }catch(IOException e){
            System.out.println("Failed to find Connection");
            System.exit(-1);}
        final Socket ss = s;
        new Thread(grover, new Runnable(){
                public void run(){
                    try{
                        PrintWriter pw = new PrintWriter(ss.getOutputStream());
                        final Scanner sc = new Scanner(ss.getInputStream()).useDelimiter("\\\\");
                        final int myNumber = Integer.parseInt(sc.next());
                        player2ComboBox.setEnabled(false);
                        player3ComboBox.setEnabled(false);
                        player4ComboBox.setEnabled(false);
                        if(myNumber==2){
                            player2ComboBox.setEnabled(true);
                        }else if(myNumber==3){
                            player3ComboBox.setEnabled(true);
                        }else{
                            player4ComboBox.setEnabled(true);
                        }
                        new Thread(grover,new Runnable(){
                                public void run(){
                                    while(!hasStarted){
                                        String x = sc.next();
                                        if(x.equals("GO!")){
                                            hasStarted = true;
                                            continue;
                                        }
                                        String[] y = x.split("\\");
                                        livesTextField.setText(y[0]);
                                        int z = y[1].equals("Classic")? 0 :
                                            y[1].equals("Spicy")? 1 : 
                                            y[1].equals("Spicy")? 2 : 3;
                                        mapsComboBox.setSelectedIndex(z);
                                        String tempo;
                                        tempo = y[2];
                                        int me = 0;
                                        if(tempo.equals("AI"))me = 0;
                                        else if(tempo.equals("Mr Magic"))me = 1;
                                        else if(tempo.equals("Mr Butch"))me = 2;
                                        else if(tempo.equals("ReD"))me = 3;
                                        else if(tempo.equals("Chase"))me = 4;
                                        else me = 0;
                                        player1ComboBox.setSelectedIndex(me);
                                        tempo = y[3];
                                        me = 0;
                                        if(tempo.equals("AI"))me = 0;
                                        else if(tempo.equals("Mr Magic"))me = 1;
                                        else if(tempo.equals("Mr Butch"))me = 2;
                                        else if(tempo.equals("ReD"))me = 3;
                                        else if(tempo.equals("Chase"))me = 4;
                                        else me = 0;
                                        if(myNumber!=2)
                                            player2ComboBox.setSelectedIndex(me);
                                        tempo = y[4];
                                        me = 0;
                                        if(tempo.equals("AI"))me = 0;
                                        else if(tempo.equals("Mr Magic"))me = 1;
                                        else if(tempo.equals("Mr Butch"))me = 2;
                                        else if(tempo.equals("ReD"))me = 3;
                                        else if(tempo.equals("Chase"))me = 4;
                                        else me = 0;
                                        if(myNumber!=3)
                                            player3ComboBox.setSelectedIndex(me);
                                        tempo = y[5];
                                        me = 0;
                                        if(tempo.equals("AI"))me = 0;
                                        else if(tempo.equals("Mr Magic"))me = 1;
                                        else if(tempo.equals("Mr Butch"))me = 2;
                                        else if(tempo.equals("ReD"))me = 3;
                                        else if(tempo.equals("Chase"))me = 4;
                                        else me = 0;
                                        if(myNumber!=4)
                                            player4ComboBox.setSelectedIndex(me);
                                    }
                                    try{
                                        Thread.sleep(20);
                                    }catch(InterruptedException e){}
                                    while(true){
                                        String tempo = sc.next();
                                        String[] tempor = tempo.split("\\"); 
                                        if(tempor.length<7){
                                            continue;
                                        }
                                        String[][] right = new String[tempor.length/6][6];
                                        for(int i=0; i!=tempor.length; i+=6){
                                            right[i/6][i%6] = tempor[i];
                                        }
                                        mapper.getMap(right);
                                    }
                                }
                            }).start();
                        while(!hasStarted){
                            String myString = "";
                            if(myNumber==2){
                                myString = (String) player2ComboBox.getSelectedItem();
                            }else if(myNumber==3){
                                myString = (String) player3ComboBox.getSelectedItem();
                            }else if(myNumber==4){
                                myString = (String) player4ComboBox.getSelectedItem();
                            }
                            pw.write(myString+"\\\\");
                            pw.flush();
                        }
                        try{
                            Thread.sleep(20);
                        }catch(InterruptedException e){}
                        while(true){
                            int[] getHere = mapper.sendInput();
                            for(int i = 0; i!=getHere.length; i++){
                                pw.write(getHere[i]+"\\");
                            }
                            pw.write("\\");
                            pw.flush();
                        }
                    }catch(IOException e){}
                }
            }).start();
        //player2ComboBox.setEnabled(false);
        //player3ComboBox.setEnabled(false);
        //player4ComboBox.setEnabled(false);
        while(!hasStarted);
    }

    public static void main(String args[]){
        JFrame a = new OnlineGameSetee("1","1","1");
    }
}