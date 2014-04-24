import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {
    boolean end;
    int sizeElem;
    BufferedReader in;
    
    public Reader() throws FileNotFoundException{
        in = new BufferedReader(new FileReader("data.csv"));
        end = false;
    }
    
    public boolean isEnd(){
        return end;
    }
    
    public String[] getHeader(){
        try {
            String[] tmp = in.readLine().split("#");
            sizeElem = tmp.length;
            return tmp;
        }catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String[] getNext() {
        String[] tmp;
        try {
            tmp = in.readLine().split("#");
            if(tmp.length != sizeElem){
            end = true;
            return null; 
        }
        return  tmp;
        } catch (IOException ex) {
            return  null;
        }       
    }
}