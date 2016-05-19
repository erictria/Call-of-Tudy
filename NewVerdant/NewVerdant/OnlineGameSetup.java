
/**
 * Setup for online games
 */
import java.net.*;
import java.io.*;
import java.util.*;
public class OnlineGameSetup extends GameSetup
{
    static ThreadGroup grover = new ThreadGroup("OMG");
    static ArrayList<Socket> s = new ArrayList<Socket>();
    static boolean hasStarted = false;
    public OnlineGameSetup(String ip, String port, String name){
        super(ip,port,name);
        hasStarted = false;
        player2ComboBox.setEnabled(false);
        player3ComboBox.setEnabled(false);
        player4ComboBox.setEnabled(false);
        final String port1 = port;
        new Thread(grover, new Runnable(){
                public void run(){
                    ServerSocket ss = null;
                    try{
                        System.out.println("Waiting...");
                        ss = new ServerSocket(Integer.parseInt(port1));
                        while(!hasStarted){
                            Socket socket = ss.accept();
                            int numberOfPlayers = Integer.parseInt( 
                                    (String) playerAmount.getSelectedItem());
                            if(s.size()<numberOfPlayers){
                                s.add(socket);
                                final int playNum = s.size()+1;
                                final Socket a = socket;
                                new Thread(grover, new Runnable(){
                                        public void run(){
                                            try{
                                                PrintWriter pw = new PrintWriter(a.getOutputStream());
                                                final Scanner sc = new Scanner(a.getInputStream()).useDelimiter("\\\\");
                                                new Thread(grover, new Runnable(){
                                                        public void run(){
                                                            while(!hasStarted){
                                                                String tempo = sc.next();
                                                                int me = 0;
                                                                if(tempo.equals("AI"))me = 0;
                                                                else if(tempo.equals("Mr Magic"))me = 1;
                                                                else if(tempo.equals("Mr Butch"))me = 2;
                                                                else if(tempo.equals("ReD"))me = 3;
                                                                else if(tempo.equals("Chase"))me = 4;
                                                                else me = 0;
                                                                if(playNum==2){
                                                                    player2ComboBox.setSelectedIndex(me);
                                                                }else if(playNum==3){
                                                                    player3ComboBox.setSelectedIndex(me);
                                                                }else if(playNum==4){
                                                                    player4ComboBox.setSelectedIndex(me);
                                                                }
                                                            }
                                                            while(true){
                                                                String tempo = sc.next();
                                                                String[] tempor = tempo.split("\\"); 
                                                                if(tempor.length<4){
                                                                    continue;
                                                                }
                                                                int[] xer = new int[9];
                                                                for(int ij = 0; ij!=9; ij++){
                                                                    xer[ij] = Integer.parseInt(tempor[ij]);
                                                                }
                                                                at.map.addControls(playNum-1,xer);
                                                            }
                                                        }
                                                    }).start();
                                                pw.write(playNum+"\\\\");
                                                pw.flush();
                                                while(!hasStarted){
                                                    //pw.print();
                                                    String player1Type = (String) player1ComboBox.getSelectedItem();
                                                    String player2Type = (String) player2ComboBox.getSelectedItem();
                                                    String player3Type = (String) player3ComboBox.getSelectedItem();
                                                    String player4Type = (String) player4ComboBox.getSelectedItem();
                                                    String mapChosen = (String) mapsComboBox.getSelectedItem();
                                                    int livesChosen = Integer.parseInt( livesTextField.getText());
                                                    pw.write(livesChosen+"\\"+mapChosen+"\\"
                                                        +player1Type+"\\"+player2Type+"\\"
                                                        +"\\"+player3Type+"\\"+player4Type+"\\\\");
                                                    pw.flush();
                                                    //System.out.println("Got em");
                                                }
                                                pw.write("GO!"+"\\\\");
                                                while(GameStarter.runMe){
                                                    String[][] temp = at.map.giveMap();
                                                    for(int i = 0; i!= temp.length; i++){
                                                        for(int j = 0; j!= temp.length; j++){
                                                            pw.write(temp[i][j]);
                                                            if(i==0&&j==0){
                                                                pw.write("\\");
                                                            }
                                                        }
                                                    }
                                                    pw.write("\\");
                                                    pw.flush();
                                                }
                                                pw.close();
                                            }catch(IOException e){
                                            }
                                        }
                                    }).start();
                            }
                            if(Thread.currentThread().interrupted()){
                                ss.close();
                                break;
                            }
                        }
                        System.out.println("Starting...");
                        ss.close();
                    }catch(IOException e){}
                }
            }).start();
    }
}
