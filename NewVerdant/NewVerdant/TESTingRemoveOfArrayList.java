
/**
 * Write a description of class TESTingRemoveOfArrayList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TESTingRemoveOfArrayList
{
    public static void main(String args[]){
        ArrayList<String> x = new ArrayList<String>();
        x.add("y");
        x.add("x");
        x.add("y");
        x.add("Hi");
        x.add("y");
        x.add("Love");
        x.add("y");
        for(int i = 0; i!=x.size(); i++){
            if(x.get(i).equals("y")){
                x.remove(i);
                i--;
                continue;
            }
            System.out.println(x.get(i));
        }
    }
}
