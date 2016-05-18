
/**
 * I'm the made for testing MapReader without networking DOESN"T WORK
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 May 13, 2016
 */
public class MapReaderThread implements Runnable
{
    Map map; MapReader mapper;
    public MapReaderThread(Map m, MapReader mr){
        map = m;
        mapper = mr;
    }
    public void run(){
        while(true){
            mapper.getMap(map.giveMap());
        }
    }
}
