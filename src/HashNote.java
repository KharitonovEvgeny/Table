// Hash таблица в виде Массива с цепочкми
public class HashNote {
    private final List data[]; 
    private final int size;
    
    public HashNote(int s){
        size = s;
        data = new List[size];
        for(int i=0;i<size;i++)
            data[i] = new List();
    }
    
    private int hash(String n){ 
        return Math.abs(n.hashCode() % size);
    }    
    public boolean insert (String s,String m,String p,String n){ 
        return data[hash(n)].insert(s,m,p,n);
    }
    
    public ItemList search (String n){ 
        return data[hash(n)].search(n);  
    }
    
    public void delete (String n){
        data[hash(n)].delete(n);
    } 
    public void show (){
        System.out.println("HASH:");
        for (int i=0;i<size;i++){
            data[i].show();
        }
    }
}
