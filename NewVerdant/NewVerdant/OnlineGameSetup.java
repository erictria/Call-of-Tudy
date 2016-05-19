
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
    public OnlineGameSetup(String ip, String port, String name){
        super(ip,port,name);
        final String port1 = port;
        new Thread(grover, new Runnable(){
                public void run(){
                    ServerSocket ss = null;
                    try{
                        ss = new ServerSocket(Integer.parseInt(port1));
                        while(true){
                            Socket socket = ss.accept();
                            //if(s.size()<)
                            if(Thread.currentThread().interrupted()){
                                ss.close();
                                break;
                            }
                        }
                        ss.close();
                    }catch(IOException e){}
                }
            });
    }
}
