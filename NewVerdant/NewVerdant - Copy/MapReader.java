
/**
 * I'm the MapReader, I'm MADE for networking
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 May 13, 2016
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.*;
public class MapReader extends Map
{
    private String drawMe[][] = null;
    private boolean up,down, left, right, action1, action2, action3, action4;
    private int dirFir = 1;
    /*public MapReader(){
        super(null);
    }*/
    public int prePaint(Graphics g)
    {
        iterateSpawnControllers();
        setBackground(Color.MAGENTA);
        try{
            for(int it = 0; it<drawMe.length; it++){
                //Spawn a = spawns.get(it);
                String sprite = drawMe[it][4];
                //System.out.println(sprite);
                BufferedImage i = null;
                //System.out.println(sprite);
                for(int counter = 0; counter!=imageNames.size(); counter++){
                    if(imageNames.get(counter).equals(sprite)){
                        //System.out.println(imageNames.get(counter));
                        i = images.get(counter);
                    }
                }
                if(i==null&&sprite!=null){
                    //System.out.println(sprite);
                    try{
                        i = ImageIO.read(new File(sprite));
                        //System.out.println(sprite);
                        images.add(i);
                        imageNames.add(sprite);
                    }catch(IOException e){
                        try{
                            String replaced = sprite.replaceAll( "\\\\","/" );
                            i = ImageIO.read(new File(replaced));
                            //System.out.println(replaced);
                            images.add(i);
                            imageNames.add(sprite);
                        }catch(IOException e2){
                            System.out.println("Failed to find " + sprite+".");
                        }
                    }
                }

                float[] temp = new float[5];
                for(int j = 0; j!=4; j++){
                    temp[j] = Float.parseFloat(drawMe[it][j]);
                }
                temp[4] = Float.parseFloat(drawMe[it][5]);
                float widther = temp[2]*widthFactor/i.getWidth();
                float heighter = (temp[3]*heightFactor)/i.getHeight();
                AffineTransform matrix = AffineTransform.getTranslateInstance((int)(temp[0]*widthFactor),
                        (int)(temp[1]*heightFactor));
                matrix.scale(widther,heighter);
                matrix.rotate(Math.toRadians(temp[4]),i.getWidth()/2,i.getHeight()/2);

                Graphics2D gg = (Graphics2D) g;
                gg.drawImage(i,matrix,null);         
            }
        }catch(ConcurrentModificationException|NullPointerException e){};//System.out.println("concurrentModification");}
        return 0;
    }
    public int getMap(String[][] x){
        drawMe = x;
        return 0;
    }
    public int[] sendInput(){
        int[] temp = new int[9];
        temp[0] = (up? 1 : 0);
        temp[1] = down? 1 : 0;
        temp[2] = right? 1 : 0;
        temp[3] = left? 1 : 0;
        temp[4] = action1? 1 : 0;
        temp[5] = action2? 1 : 0;
        temp[6] = action3? 1 : 0;
        temp[7] = action4? 1 : 0;
        temp[8] = dirFir;
        return temp;
    }
    public void setUp(boolean in){
        up = in;
    }
    public void setDown(boolean in){
        down = in;
    }
    public void setRight(boolean in){
        right = in;
    }
    public void setLeft(boolean in){
        left = in;
    }
    public void setAction1(boolean in){
        action1 = in;
    }
    public void setAction2(boolean in){
        action2 = in;
    }
    public void setAction3(boolean in){
        action3 = in;
    }
    public void setAction4(boolean in){
        action4 = in;
    }
    public void setDirFir(int in){
        dirFir = in;
    }
}
